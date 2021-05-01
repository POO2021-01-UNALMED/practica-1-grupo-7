package uiMain;

import java.util.Scanner;
import java.io.*;

import gestorAplicacion.Empleado;
import gestorAplicacion.Encomienda;
import gestorAplicacion.Localizacion;
import gestorAplicacion.OficinaBodega;

public class UInterface {
	static Scanner input = new Scanner(System.in);
		
	public static void main(String[] args) {
		int opcion;
		
		// Crenado Objetos
		Empleado empleado1 = new Empleado("Maria", "1037633515", 2000000, "01-01-2022");
		Empleado empleado2 = new Empleado("Mario", "2037633516", 2000000, "01-01-2022");
		
		Localizacion localSE = new Localizacion("Antioquia", "Carolina", "Barrio azul", "Cra 45b #80-76");
		Localizacion localSE2 = new Localizacion("Bogota", "Andre", "Barrio morado", "Cll 170 av.caracas");
		
		OficinaBodega ofiBo = new OficinaBodega("Super Env�os", localSE, "8627365", empleado1);
		
		
		// MENU PRINCIPAL
		do {
			System.out.println("  BIENVENIDO(A) A SUPERENVIOS!\n");
			System.out.println("\t.:MENU PRINCIPAL:.\n");
			System.out.println("1. Ver datos de la oficina");
			System.out.println("2. Realizar nuevo envio");
			System.out.println("3. Rastrear o ver detalles de envio");
			System.out.println("4. Terminar sesion");
			System.out.print("Ingresa el numero de la opcion deseada: ");
			opcion = input.nextInt();
			
			switch (opcion) {
				case 1: System.out.println(ofiBo.toString()); // si vamos a menejar una sola oficina
				case 2: crearEncomienda();
				break;
					
			}
		} while (opcion != 4);
		
	}
	
	// Metodo realizar nuevo envio
	private static void crearEncomienda() {
		
		System.out.println("Ingrese el peso");
        int peso = input.nextInt();
        
        System.out.println("Ingrese el largo");
        int largo = input.nextInt();
        
        System.out.println("Ingrese el ancho");
        int ancho = input.nextInt();
        
        System.out.println("Ingrese el alto");
        int alto = input.nextInt();
        
        System.out.println("Ingrese descricion de la encomienda");
        String descripcionEnc = input.next();
        
        System.out.println("Ingrese fecha de envio");
        String fechaEnvio = input.next();
        
        System.out.println("Ingrese fecha de entrega");
        String fechaEntrega = input.next();
        
        System.out.println("Ingrese lugarEntrega");
        
        
        
        
        //Encomienda paquete = new Encomienda(peso, largo, ancho,alto,descripcionEnc,fechaEnvio,fechaEntrega);
		//Encomienda paquete = emp.crearEncomienda();
		
		/*emp.costosEnvio(paquete);
		verificacionDatos(paquete);
		if (paquete != null) {
			OficinaBodega.encomiendas.add(paquete);
		}
		emp.realizarEnvio(paquete, paquete.getDestinatario());*/
	}
	
	
	
	private static void rastrearEnvio(Encomienda enc) {
		// TODO: Despues lo miramos
	}
	
	private static void verificacionDatos(Encomienda enc) {
		System.out.println("== DATOS DE LA ENCOMIEDA CREADA ==");
		System.out.println("1. Confirmar");
		System.out.println("2. Editar");
		System.out.println("3. Cancelar y borrar encomienda");
		int opcion = new Scanner(System.in).nextInt();
		
		switch(opcion) {
			case 1: break;
			case 2: /* TODO: crear metodo editarEnc(Encomienda enc)
					que permita editar cualquier atributo del paquete
					*/
			case 3: enc = null;
		}
	}

}
