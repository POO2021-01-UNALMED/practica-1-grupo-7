package gestorAplicacion;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import baseDatos.Deserializador;

public class OficinaBodega implements Serializable {

	// ATRIBUTOS AUXILIARES
	private static final long serialVersionUID = 1L;

	// ATRIBUTOS
	private Administrador admin;
	private String nombre;
	public static Localizacion ubicacion;
	private String telefono;
	public static Empleado empleado;
	public static int encomiendasRealizadas = 0;

	// DATA
	public static List<Encomienda> encomiendas = new ArrayList<>();
	public static List<Cliente> clientes = new ArrayList<>();

	// CONSTRUCTOR
	public OficinaBodega(String nombre, Localizacion ubicacion, String telefono, Administrador admin) {
		this.nombre = nombre;
		OficinaBodega.ubicacion = ubicacion;
		this.telefono = telefono;
		this.admin = admin;

		Deserializador.deserializarEncomiendas();
		Deserializador.deserializarClientes();
		Deserializador.deserializarEmpleado();
		Deserializador.deserializarConteoIdEncomienda();

		boolean encPend = false;
		for (Encomienda enc : encomiendas) {
			if (!enc.getEstado().equals("Entregado")) {
				System.out.println(!encPend ? "\n == DESPACHANDO ENCOMIENDAS PENDIENTES... ==\n" : "");
				encPend = true;
				Transporte.trasportarEncPend(enc);
			}
		}
	}

	// GETTERS Y SETTERS
	public String getNombre() {
		return nombre;
	}

	public static List<Encomienda> getEncomiendas() {
		return encomiendas;
	}

	public static void setEncomiendas(List<Encomienda> encomiendas) {
		OficinaBodega.encomiendas = encomiendas;
	}

	public static List<Cliente> getClientes() {
		return clientes;
	}

	public static void setClientes(List<Cliente> clientes) {
		OficinaBodega.clientes = clientes;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	// TOSTRING
	@Override
	public String toString() {
		return "\n== INFORMACION DE LA EMPRESA ==" 
				+ "\nNombre: " + nombre 
				+ "\nUbicacion: " + ubicacion
				+ "\nTelefono: " + telefono 
				+ "\nEmpleado actual: " + empleado.getNombre()
				+ "\n == REPRESENTANTE LEGAL == \n" + admin;
	}
}
