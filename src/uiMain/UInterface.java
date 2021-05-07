package uiMain;

import java.util.Scanner;

import gestorAplicacion.*;
import utilidades.Utils;

public class UInterface {
    
	// VARIABLES AUXILIARES
    private static Scanner input = new Scanner(System.in);
    
    // ADMIN
    private static Administrador admin = new Administrador("Juan David Amaya Bermudez", "1038365243");
    private static Localizacion localOB = new Localizacion("Antioquia", "Gómez Plata", "Parque principal", "Cra 45b #80-76");
    private static OficinaBodega ofiBo = new OficinaBodega("SuperEnvios", localOB, "3137652436", admin);
    
    public static void main(String[] args) {
        
        // VARIABLES AUXILIARES
        int opcion;
        
        // INFO DE PRUEBA
        Empleado empleadoSE = new Empleado("Maria", "1037633515", 2000000, "01-01-2022");
        OficinaBodega.empleado = empleadoSE;

        Localizacion local1 = new Localizacion("Antioquia", "Carolina", "Barrio azul", "Cra 45b #80-76");
        Localizacion local2 = new Localizacion("Cundinamarca", "Bogota", "Barrio morado", "Cll 170 av.caracas");

        Cliente cliente1 = new Cliente("Esteban Bermudez", "7758", "2607070", local1);
        Cliente cliente2 = new Cliente("Andrea Amaya", "1234567890", "2608080", local2);
        OficinaBodega.clientes.add(cliente1);
        OficinaBodega.clientes.add(cliente2);        

        // MENÚ PRINCIPAL
        do {
            System.out.println("\n  ¡BIENVENIDO(A) A SUPERENVIOS!\n");
            System.out.println("\t.:MENÚ PRINCIPAL:.\n");
            System.out.println("0. Administrar");
            System.out.println("1. Ver datos de la oficina");
            System.out.println("2. Realizar nuevo envio");
            System.out.println("3. Rastrear o ver detalles de envio");
            System.out.println("4. Información general de envios realizados");
            System.out.println("5. Terminar sesión");
            System.out.print("Ingresa el número de la opción deseada: ");
            opcion = input.nextInt();

            switch (opcion) {
            	case 0:
            		System.out.print("Contraseña: ");
            		int pass = input.nextInt();
            		if (pass != 12345) {
            			System.out.println("Contraseña incorrecta");
            		}
            		else {
            			System.out.println("\n == SESION COMO ADMINISTRADOR ==");
            			menuAdmin();
            		}
            		break;
                case 1:
                    datosOfi(ofiBo);
                    break;
                case 2:
                    nuevoEnvio(empleadoSE);
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
                	System.out.println("Sesion teminada con exito");
                	break;
                default:
                    System.out.println("Opcion no disponible");
            }

        } while (opcion != 5);
    }
        
    // MÉTODOS DE ACCIÓN
    private static void datosOfi(OficinaBodega ofiBo) {
        System.out.println(ofiBo.toString());
    }

    private static void nuevoEnvio(Empleado emp) {
        Encomienda nuevaEnc = emp.crearEncomienda();
        double costoEnv = emp.calcularCostosEnv(nuevaEnc);
        
        System.out.println("\n== ENCOMIEDA CREADA CON ÉXITO ==");
        System.out.println(
            "Número de guía (CONSERVE ESTE NÚMERO PARA HACER SUS CONSULTAS): " + nuevaEnc.getId()
        );
        System.out.print("Costos de envio: $" + costoEnv);
        
        System.out.println(
            "\n1. Confirmar y realizar envio (NO SE PUEDEN HACER MODIFICACIONES UNA VEZ CONFIRMADO EL ENVÍO)"
        );
        System.out.println("2. Cancelar (elimina los datos de la encomienda)");
        System.out.print("Ingresa el número de la opción deseada: ");
        int op = input.nextInt();
        
        switch (op) {
            case 1:
                emp.realizarEnvio(nuevaEnc);
                break;
            case 2:
                Utils.borrarEncDB(nuevaEnc);
                break;
        }
    }

    private static void rastrearEnvio(int idEnc) {
        for (Encomienda enc: OficinaBodega.encomiendas){
            if (enc.getId() == idEnc){
                System.out.println("\n == Encomienda No. " + idEnc + "== ");
                System.out.println(enc);
                return;
            }
        }
        System.out.println("\nEncomienda no encontrada");
    }
    
    private static void enviosRalizados() {
    	
    	if (OficinaBodega.encomiendas.size() == 0) {
    		System.out.println("\nSin registros");
    		return;
    	}
    	
    	for (Encomienda enc: OficinaBodega.encomiendas) {
    		if (enc != null) {
    			System.out.println("\nEncomienda No. " + enc.getId());
    			System.out.println("Remitente: " + enc.getRemitente().getNombre());
    			System.out.println("Destinatario: " + enc.getDestinatario().getNombre());
    			System.out.println("Descripción de la encomieda: " + enc.getDescripcionEnc());
    			System.out.println("Municipio o ciudad destino: " + enc.getLugarEntrega().getMunicipio());
    			System.out.println("Estado: " + enc.getEstado());
    		}
    	}
    }
    
    private static void menuAdmin() {
    	
    	int op;
    	do {
    		System.out.println("\n1. Ver información del empleado");
        	System.out.println("2. Modificar salario del empleado");
        	System.out.println("3. Renovar o modificar contrato del empleado");
        	System.out.println("4. Despedir empleado");
        	System.out.println("5. Contratar empleado");
        	System.out.println("6. Validar y terminar");
        	System.out.print("Digita la opción deseada: ");
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
        			input.nextLine();  // VACIADO DEL BUFFER
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
        			break;
    			default:
    				System.out.println("Opción no disponible");
        	}
    	} while (op != 6);
    }
}

