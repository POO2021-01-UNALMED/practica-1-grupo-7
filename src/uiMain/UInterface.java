package uiMain;

import java.util.LinkedList;
import java.util.Scanner;
import java.io.*;
import gestorAplicacion.*;

public class UInterface {

	static Scanner input = new Scanner(System.in);

	private static LinkedList<Empleado> empleados = new LinkedList<>();
	private static LinkedList<Localizacion> localizaciones = new LinkedList<>();
	private static LinkedList<Cliente> clientes = new LinkedList<>();
	private static LinkedList<Encomienda> encomiendas = new LinkedList<>();
	// private static LinkedList<OficinaBodega> oficinasBodegas = new
	// LinkedList<>();

	public static void main(String[] args) {
		int opcion;

		// Creando Objetos
		Empleado empleado1 = new Empleado("Maria", "1037633515", 2000000, "01-01-2022");
		Empleado empleado2 = new Empleado("Mario", "2037633516", 2000000, "01-01-2022");
		empleados.add(empleado1);
		empleados.add(empleado2);

		Localizacion local1 = new Localizacion("Antioquia", "Carolina", "Barrio azul", "Cra 45b #80-76");
		Localizacion local2 = new Localizacion("Cundinamarca", "Bogota", "Barrio morado", "Cll 170 av.caracas");
		localizaciones.add(local1);
		localizaciones.add(local2);

		Cliente cliente1 = new Cliente("Esteban Bermudez", "7758", 2607070, local1);
		Cliente cliente2 = new Cliente("Andrea Amaya", "1234567890", 2608080, local2);
		clientes.add(cliente1);
		clientes.add(cliente2);
		
		
		// Nosotros solo tendremos UNA oficina !! 
		OficinaBodega ofiBo = new OficinaBodega("Super Envios", local1, "8627365", empleado1);

		// MENU PRINCIPAL
		do {
			System.out.println("  BIENVENIDO(A) A SUPERENVIOS!\n");
			System.out.println("\t.:MENU PRINCIPAL:.\n");
			System.out.println("1. Ver datos de la oficina");
			System.out.println("2. Realizar nuevo envio");
			System.out.println("3. Rastrear o ver detalles de envio");
			System.out.println("4. Terminar sesion");
			System.out.println("5. ver encomiendas");
			System.out.print("Ingresa el numero de la opcion deseada: ");
			opcion = input.nextInt();

			switch (opcion) {
			case 1:
				datosOfi(ofiBo);
				break;
			case 2:
				crearEncomienda();
				break;
			case 5:
				verEncomiendas();
				break;

			}

		} while (opcion != 5);
	}

	private static void datosOfi(OficinaBodega ofiBo) {
		System.out.println(ofiBo.toString());
	}

	private static void crearEncomienda() {
		System.out.println("-------------------------");

		System.out.println("Ingrese el peso");
		int peso = input.nextInt();
		if (peso <= 0) {
			System.out.println("Peso invalido");
			return;
		}

		System.out.println("Ingrese el largo");
		int largo = input.nextInt();
		if (largo <= 0) {
			System.out.println("largo invalido");
			return;
		}

		System.out.println("Ingrese el ancho");
		int ancho = input.nextInt();
		if (ancho <= 0) {
			System.out.println("ancho invalido");
			return;
		}

		System.out.println("Ingrese el alto");
		int alto = input.nextInt();
		if (alto <= 0) {
			System.out.println("alto invalido");
			return;
		}

		System.out.println("Ingrese descricion de la encomienda");
		String descripcionEnc = input.next();
		System.out.println("Ingrese fecha de envio");
		String fechaEnvio = input.next();
		System.out.println("Ingrese fecha de entrega");
		String fechaEntrega = input.next();

		System.out.println("Ingrese lugarEntrega (ciudad)");
		String municipio = input.next();
		Localizacion lugarEntrega = verificarLocalizacion(municipio);

		System.out.println("Ingrese ultimaLocalizacion (ciudad)");
		String municipio2 = input.next();
		Localizacion ultimaLocalizacion = verificarLocalizacion(municipio2);

		System.out.println("Ingrese Id de cliente quien envia");
		String idcliente = input.next();
		Cliente remitente = verificarCliente(idcliente);

		System.out.println("Ingrese Id de cliente destinatario");
		String idclientedestinatario = input.next();
		Cliente destinatario = verificarCliente(idclientedestinatario);

		System.out.println("Ingrese estado recibido");
		Boolean estadoRecibido = input.nextBoolean();

		Encomienda nuevaEncomienda = new Encomienda(peso, largo, ancho, alto, descripcionEnc, fechaEnvio, fechaEntrega,
				lugarEntrega, ultimaLocalizacion, remitente, destinatario, estadoRecibido);

		encomiendas.add(nuevaEncomienda);

	}

	private static void rastrearEnvio() {
		// TODO: Despues lo miramos
		return;
	}

	private static Cliente verificarCliente(String idcliente) {
		for (Cliente cliente : clientes) {
			if (cliente.getId().equals(idcliente)) {
				return cliente;
			}
		}
		System.out.println("Cliente no regitrado, por favor registrelo");
		registrarCliente();
		return null;

	}

	private static Localizacion verificarLocalizacion(String municipio) {
		for (Localizacion loca : localizaciones) {
			if (loca.getMunicipio().equals(municipio)) {
				return loca;
			}
		}
		System.out.println("Localizacion no regitrado, por favor registrelo");
		// registrarLocalizacion()
		return null;

	}

	private static void registrarCliente() {
		System.out.println("EN CONSTRUCCION ------------------");
		System.out.println("Ingrese el nombre del cliente ");
		String nombre = input.next();
		System.out.println("Ingrese Id de cliente");
		String id = input.next();
		System.out.println("Ingrese el telefono del cliente");
		String telefono = input.next();
		System.out.println("Ingrese departamento de la localizaci�n (ubicaicon)");
		String localizcion = input.next();

	}

	/*
	 * private static void verificacionDatos(Encomienda enc) {
	 * System.out.println("== DATOS DE LA ENCOMIEDA CREADA ==");
	 * System.out.println("1. Confirmar"); System.out.println("2. Editar");
	 * System.out.println("3. Cancelar y borrar encomienda"); int opcion = new
	 * Scanner(System.in).nextInt();
	 * 
	 * switch(opcion) { case 1: break; case 2: TODO: crear metodo
	 * editarEnc(Encomienda enc) que permita editar cualquier atributo del paquete
	 * 
	 * case 3: enc = null; } }
	 */

	public static void verEncomiendas() {
		// Temporal solo para verificar
		for (Encomienda encomienda : encomiendas) {
			System.out.println(encomiendas.toString());
		}

	}

}
