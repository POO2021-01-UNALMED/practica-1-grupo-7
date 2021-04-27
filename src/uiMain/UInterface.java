package uiMain;

import java.util.Scanner;

import gestorAplicacion.Empleado;
import gestorAplicacion.Encomienda;
import gestorAplicacion.Localizacion;
import gestorAplicacion.OficinaBodega;

public class UInterface {
	
	public static void main(String[] args) {
		
		// VARIABLES AUXILIARES
		Scanner input = new Scanner(System.in);
		int opcion;
		
		Empleado empleadoSE = new Empleado("Mar�a", "1037633515", 2000000);
		Localizacion localSE = new Localizacion(
				"Antioquia", 
				"Carolina", 
				"Barrio azul", 
				"Cra 45b #80-76"
				);
		OficinaBodega ofiBo = new OficinaBodega("Super Env�os", localSE, "8627365", empleadoSE);
		
		// MEN� PRINCIPAL
		do {
			System.out.println("  �BIENVENIDO(A) A SUPERENVIOS!\n");
			System.out.println("\t.:MEN� PRINCIPAL:.\n");
			System.out.println("1. Ver datos de la oficina");
			System.out.println("2. Realizar nuevo env�o");
			System.out.println("3. Rastrear o ver detalles de envio");
			System.out.println("4. Terminar sesi�n");
			System.out.print("Ingresa el n�mero de la opci�n deseada: ");
			opcion = input.nextInt();
			
			switch (opcion) {
				case 1: datosOfi(ofiBo); break;
					
			}
			
		} while (opcion != 4);
		
	}
	
	// M�TODOS DE ACCI�N
	private static void datosOfi(OficinaBodega ofiBo) {
		System.out.println(ofiBo.toString());
	}
	
	private static void crearEncomienda(Empleado emp, OficinaBodega ofiBo) {
		Encomienda paquete = emp.crearEncomienda();
		emp.costosEnvio(paquete);
		verificacionDatos(paquete);
		if (paquete != null) {
			ofiBo.getEncomiendas().add(paquete);
		}
		emp.realizarEnvio(paquete, paquete.getDestinatario());
	}
	
	private static void rastrearEnvio(Encomienda enc) {
		
	}
	
	private static void verificacionDatos(Encomienda enc) {
		System.out.println("== DATOS DE LA ENCOMIEDA CREADA ==");
		System.out.println("1. Confirmar");
		System.out.println("2. Editar");
		System.out.println("3. Cancelar y borrar encomienda");
		int opcion = new Scanner(System.in).nextInt();
		
		switch(opcion) {
			case 1: break;
			case 2: // TODO: editarEnc(Encomienda enc)
			case 3: enc = null;
		}
	}

}
