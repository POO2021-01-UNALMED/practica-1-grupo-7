package modelo;

import java.io.Serializable;
import java.util.Scanner;

import java.util.Date;

import controlador.*;

public class Empleado extends Persona implements Serializable {

	// ATRIBUTOS
	private float salario;
	private String vigenciaContrato;

	// CONSTRUCTOR
	public Empleado(String nombre, String id, float salario, String vigenciaContrato) {
		super(nombre, id);
		this.salario = salario;
		this.vigenciaContrato = vigenciaContrato;
	}

	// METODOS
	public Encomienda crearEncomienda() {

		Scanner in = new Scanner(System.in);

		float peso, largo, ancho, alto;
		String descripcion, fEnvio, fEntrega;
		Localizacion dirEntrega;

		String nombreC, telefonoC, idC;
		String departC, municipC, barrioC, direC;

		Cliente remitente, destinatario;

		System.out.println("\n == INFORMACION DEL REMITENTE ==");
		System.out.print("Numero de identificacion: ");
		idC = in.next();

		in.nextLine(); // NO BORRAR
		if (Utils.buscarClienteDB(idC)) {
			System.out.println("\n .:Cliente hallado en base de datos:.");
			System.out.println(Utils.detallesCliente(idC));
			remitente = Utils.detallesCliente(idC);
			modificarDatosCliente(remitente);
		} else {
			System.out.print("Nombres y apellidos: ");
			nombreC = in.nextLine();
			System.out.print("Telefono: ");
			telefonoC = in.next();

			in.nextLine(); // NO BORRAR
			System.out.println("\n== RESIDENCIA DEL REMITENTE ==");
			System.out.print("Departamento: ");
			departC = in.nextLine();
			System.out.print("Municipio: ");
			municipC = in.nextLine();
			System.out.print("Barrio: ");
			barrioC = in.nextLine();
			System.out.print("Direccion: ");
			direC = in.nextLine();

			Localizacion direcRemi = new Localizacion(departC, municipC, barrioC, direC);
			remitente = new Cliente(nombreC, idC, telefonoC, direcRemi);

			OficinaBodega.clientes.add(remitente);
		}

		System.out.println("\n== INFORMACION DEL DESTINATARIO ==");
		System.out.print("Numero de identificacion: ");
		idC = in.next();

		in.nextLine(); // NO BORRAR
		if (Utils.buscarClienteDB(idC)) {
			System.out.println("\n .:Cliente hallado en base de datos:.");
			System.out.println(Utils.detallesCliente(idC));
			destinatario = Utils.detallesCliente(idC);
			modificarDatosCliente(destinatario);
		} else {
			System.out.print("Nombres y apellidos: ");
			nombreC = in.nextLine();
			System.out.print("Telefono: ");
			telefonoC = in.next();

			in.nextLine(); // NO BORRAR
			System.out.println("\n== RESIDENCIA DEL DESTINATARIO ==");
			System.out.print("Departamento: ");
			departC = in.nextLine();
			System.out.print("Municipio: ");
			municipC = in.nextLine();
			System.out.print("Barrio: ");
			barrioC = in.nextLine();
			System.out.print("Direccion: ");
			direC = in.nextLine();

			Localizacion direcDest = new Localizacion(departC, municipC, barrioC, direC);
			destinatario = new Cliente(nombreC, idC, telefonoC, direcDest);

			OficinaBodega.clientes.add(destinatario);
		}

		System.out.println("\n== INFORMACION DE LA ENCOMIENDA ==");
		do {
			System.out.print("Digita el peso (kg): ");
			peso = in.nextFloat();

			if (peso < 0) {
				System.out.println("Peso no permitido");
			}

		} while (Utils.validarPLAA(peso));

		do {
			System.out.print("Digita el largo (cm): ");
			largo = in.nextFloat();

			if (largo < 0) {
				System.out.println("Largo no permitido");
			}

		} while (Utils.validarPLAA(largo));

		do {
			System.out.print("Digita el ancho (cm): ");
			ancho = in.nextFloat();

			if (ancho < 0) {
				System.out.println("Ancho no permitido");
			}

		} while (Utils.validarPLAA(ancho));

		do {
			System.out.print("Digita el alto (cm): ");
			alto = in.nextFloat();

			if (alto < 0) {
				System.out.println("Alto no permitido");
			}

		} while (Utils.validarPLAA(alto));

		in.nextLine(); // NO BORRAR
		System.out.print("Descripcion del paquete: ");
		descripcion = in.nextLine();

		Date envio;
		do {
			System.out.println("\nUse el siguiente formato de fechas " + "(note que no hay espacios): DD-MM-AAAA"
					+ "\nEjemplo: 31-05-2020");
			System.out.print("Fecha de envio (DD-MM-AAAA): ");
			fEnvio = in.next();

			envio = Utils.validarFormatoFecha((fEnvio));

		} while (envio == null);

		Date entrega;
		do {
			do {
				System.out.print("Fecha de entrega aproximada (DD-MM-AAAA): ");
				fEntrega = in.next();

				entrega = Utils.validarFormatoFecha(fEntrega);

			} while (entrega == null);
		} while (Utils.comprobarFechasEnvEnt(envio, entrega));

		System.out.print("Asignar el lugar de entrega a la direccion del destinatario (S/N): ");
		if (in.next().toLowerCase().equals("s")) {
			dirEntrega = Utils.detallesCliente(idC).getUbicacion();
		} else {
			in.nextLine(); // NO BORRAR
			System.out.println("\n== INFORMACION DE ENTREGA ==");
			System.out.print("Departamento: ");
			departC = in.nextLine();
			System.out.print("Municipio: ");
			municipC = in.nextLine();
			System.out.print("Barrio: ");
			barrioC = in.nextLine();
			System.out.print("Direccion: ");
			direC = in.nextLine();

			dirEntrega = new Localizacion(departC, municipC, barrioC, direC);
		}

		Encomienda enc = new Encomienda(peso, largo, ancho, alto, descripcion, fEnvio, fEntrega, dirEntrega, remitente,
				destinatario);

		OficinaBodega.encomiendas.add(enc);

		return enc;
	}

	public void realizarEnvio(Encomienda enc) {
		System.out.println("\n== ENVIO DESPACHADO CON EXITO ==");
		Transporte.trasportarEnc(enc);
	}

	public double calcularCostosEnv(Encomienda enc) {
		double costoTotal;
		costoTotal = enc.getAlto() * 5 
					+ enc.getAncho() * 5 
					+ enc.getPeso() * 5.2 
					+ enc.getLargo() * 3;

		enc.setCostosEnvio(costoTotal);
		return enc.getCostosEnvio();
	}
	
	// SOBRECARGA DE MÉTODOS
	public void modificarDatosCliente(Cliente cliente, String nombre, String telefono) {
		cliente.setNombre(nombre);
		cliente.setTelefono(telefono);
	}

	public void modificarDatosCliente(Cliente cliente, Localizacion ubicacion) {
		cliente.setUbicacion(ubicacion);
	}

	private void modificarDatosCliente(Cliente cliente) {
		Scanner in = new Scanner(System.in);
		int op;

		do {
			System.out.println("\n1. Aceptar y continuar");
			System.out.println("2. Modificar informacion personal");
			System.out.println("3. Modificar informacion de residencia");
			System.out.print("Ingresa el numero de la opcion deseada: ");
			op = in.nextInt();
			switch (op) {
			case 1 -> {
			}
			case 2 -> {
				in.nextLine(); // NO BORRAR
				System.out.print("Nombres y apellidos: ");
				String nombreC = in.nextLine();
				System.out.print("Telefono: ");
				String telefonoC = in.next();
				modificarDatosCliente(cliente, nombreC, telefonoC);
				modificarDatosCliente(cliente);
			}
			case 3 -> {
				in.nextLine(); // NO BORRAR
				System.out.print("Departamento: ");
				String departC = in.nextLine();
				System.out.print("Municipio: ");
				String municipC = in.nextLine();
				System.out.print("Barrio: ");
				String barrioC = in.nextLine();
				System.out.print("Direccion: ");
				String direC = in.nextLine();
				modificarDatosCliente(cliente, new Localizacion(departC, municipC, barrioC, direC));
				modificarDatosCliente(cliente);
			}
			default -> System.out.println("Opcion invalida");
			}
		} while (op != 1);
	}

	// GETTERS Y SETTERS
	public float getSalario() {
		return salario;
	}

	public void setSalario(float s) {
		salario = s;
	}

	public String getVigenciaContrato() {
		return vigenciaContrato;
	}

	public void setVigenciaContrato(String vigenciaContrato) {
		this.vigenciaContrato = vigenciaContrato;
	}

	// TOSTRING
	@Override
	public String toString() {
		return "Nombre: " + super.getNombre() + "\nSuperEnviosId: " + super.getId() + "\nSalario: $" + salario
				+ "\nVigencia del contrato: " + vigenciaContrato;
	}
}
