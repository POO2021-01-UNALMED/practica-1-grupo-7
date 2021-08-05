package uiMain;

import java.util.Scanner;
import gestorAplicacion.*;
import utilidades.Utils;

import baseDatos.*;

public class UInterface {

	// VARIABLES AUXILIARES
	private static Scanner input = new Scanner(System.in);

	// ADMIN (NO BORRAR)
	private static Administrador admin = new Administrador("Juan David Amaya Bermudez", "1038365243");
	private static Localizacion localOB = new Localizacion("Antioquia", "Gomez Plata", "Parque principal",
			"Cra 45b #80-76");
	private static OficinaBodega ofiBo = new OficinaBodega("SuperEnvios", localOB, "3137652436", admin);

	public static void main(String[] args) {

		// VARIABLES AUXILIARES
		int opcion;
		
		// MENU PRINCIPAL
		System.out.println("\n  BIENVENIDO(A) A SUPERENVIOS");
		do {
			System.out.println("\n\t.:MENU PRINCIPAL:.\n");
			System.out.println("0. Administrar");
			System.out.println("1. Informacion general de la empresa");
			System.out.println("2. Realizar nuevo envio");
			System.out.println("3. Rastrear o ver detalles de envio");
			System.out.println("4. Informacion general de envios realizados");
			System.out.println("5. Terminar sesion");
			System.out.print("Ingresa el numero de la opcion deseada: ");
			opcion = input.nextInt();

			switch (opcion) {
			case 0:
				System.out.print("Clave de acceso: ");
				int pass = input.nextInt();
				if (pass != 12345) { // Contraseña: 12345
					System.out.println("Clave de acceso incorrecta");
				} else {
					System.out.println("\n == SESION COMO ADMINISTRADOR ==");
					menuAdmin();
				}
				break;
			case 1:
				datosOfi(ofiBo);
				break;
			case 2:
				nuevoEnvio(OficinaBodega.empleado);
				break;
			case 3:
				System.out.print("Digita el id del envio: ");
				int idEnc = input.nextInt();
				rastrearEnvio(idEnc);
				break;
			case 4:
				enviosRalizados();
				break;
			case 5:
				terminarSesion(ofiBo);
				break;
			default:
				System.out.println("Opcion no disponible");
			}

		} while (opcion != 5);
	}

	// METODOS DE ACCION
	private static void datosOfi(OficinaBodega ofiBo) {
		System.out.println(ofiBo.toString());
	}

	private static void nuevoEnvio(Empleado emp) {

		if (OficinaBodega.empleado == null) {
			System.out.println("\nNo hay empleado registrado para realizar esta acción");
			return;
		}

		Encomienda nuevaEnc = emp.crearEncomienda();
		double costoEnv = emp.calcularCostosEnv(nuevaEnc);

		System.out.println("\n== ENCOMIEDA CREADA CON EXITO ==");
		System.out.println("Numero de guia (CONSERVE ESTE NUMERO PARA HACER SUS CONSULTAS): " + nuevaEnc.getId());
		System.out.print("COSTOS DE ENVIO: $" + costoEnv);
		
		int op;
		do {
			System.out.println(
					"\n1. Confirmar y realizar envio (NO SE PUEDEN HACER MODIFICACIONES UNA VEZ CONFIRMADO EL ENVIO)");
			System.out.println("2. Cancelar (ELIMINA LOS DATOS DE LA ENCOMIENDA)");
			System.out.print("Ingresa el numero de la opcion deseada: ");
			op = input.nextInt();
			
			op = (op == 1 || op == 2) ? op : 3;
			
			switch (op) {
			case 1:
				emp.realizarEnvio(nuevaEnc);
				break;
			case 2:
				Utils.borrarEncDB(nuevaEnc);
				break;
			default:
				System.out.println("\n== OOPS!!... POR FAVOR INTENTA DE NUEVO ==");
			}
		} while (op == 3 );
	}

	private static void rastrearEnvio(int idEnc) {
		for (Encomienda enc : OficinaBodega.encomiendas) {
			if (enc.getId() == idEnc) {
				System.out.println("\n == Encomienda No. " + idEnc + "== ");
				System.out.println(enc);
				return;
			}
		}
		System.out.println("\nEncomienda no encontrada");
	}

	private static void enviosRalizados() {

		if (OficinaBodega.encomiendas.isEmpty()) {
			System.out.println("\nSin registros");
			return;
		}
		
		System.out.println("\n== HISTORIAL DE ENVIOS REALIZADOS ==");
		for (Encomienda enc : OficinaBodega.encomiendas) {
			if (enc != null) {
				System.out.println("\nEncomienda No. " + enc.getId());
				System.out.println("Remitente: " + enc.getRemitente().getNombre());
				System.out.println("Destinatario: " + enc.getDestinatario().getNombre());
				System.out.println("Descripcion de la encomieda: " + enc.getDescripcionEnc());
				System.out.println("Municipio o ciudad destino: " + enc.getLugarEntrega().getMunicipio());
				System.out.println("Estado: " + enc.getEstado());
			}
		}
	}

	private static void terminarSesion(OficinaBodega ofiBo) {
		System.out.println("Sesion terminada con exito");
		Serializador.serializarClientes(OficinaBodega.clientes);
		Serializador.serializarEnc(OficinaBodega.encomiendas);
		Serializador.serializarConteoIdEnc(OficinaBodega.encomiendasRealizadas);
		System.exit(0);
	}

	private static void menuAdmin() {
		int op;
		do {
			System.out.println("\n1. Ver informacion del empleado");
			System.out.println("2. Modificar salario del empleado");
			System.out.println("3. Renovar o modificar contrato del empleado");
			System.out.println("4. Despedir empleado");
			System.out.println("5. Contratar empleado");
			System.out.println("6. Validar y terminar");
			System.out.print("Digita la opcion deseada: ");
			op = input.nextInt();
			System.out.println();

			switch (op) {
			case 1:
				admin.verInfoEmp();
				break;
			case 2:
				admin.modificarSalario();
				break;
			case 3:
				admin.renovarContratoEmp();
				break;
			case 4:
				admin.despedirEmp();
				break;
			case 5:
				if (OficinaBodega.empleado != null) {
					System.out.println("Se ha alcanzado el limite de empleados");
					break;
				}
				input.nextLine(); // NO BORRAR
				System.out.print("Nombre del empleado: ");
				String nombre = input.nextLine();
				System.out.print("ID del empleado: ");
				String id = input.next();
				System.out.print("Salario del empleado: ");
				float salario = input.nextFloat();

				String fContrato = input.nextLine();
				do {
					System.out.print("Fecha de finalizacion de contrado del empleado (DD-MM-YYYY): ");
					fContrato = input.next();

				} while (Utils.validarFormatoFecha(fContrato) == null);

				admin.contratarEmp(nombre, id, salario, fContrato);
				break;
			case 6:
				System.out.println("Cambios guardados con exito");
				Serializador.serializarEmp(OficinaBodega.empleado);
				break;
			default:
				System.out.println("Opcion no disponible");
			}
		} while (op != 6);
	}
}
