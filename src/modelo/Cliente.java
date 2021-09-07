package modelo;

import java.io.Serializable;

public class Cliente extends Persona implements Serializable {

	// ATRIBUTOS AUXILIARES
	private static final long serialVersionUID = 1L;

	// ATRIBUTOS
	private String telefono;
	private Localizacion ubicacion;

	// CONSTRUCTOR
	public Cliente(String nombre, Localizacion ubicacion) {
		this(nombre, "No especifica", "No especifica", ubicacion);
	}
	
	public Cliente(String nombre, String id, String telefono, Localizacion ubicacion) {
		super(nombre, id);
		this.telefono = telefono;
		this.ubicacion = ubicacion;
	}

	// GETTERS Y SETTERS
	public Localizacion getUbicacion() {
		return ubicacion;
	}

	public void setUbicacion(Localizacion ubicacion) {
		this.ubicacion = ubicacion;
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
		return "Nombre: " + getNombre() + "\nId: " + getId() + "\nTelefono: " + telefono + "\nDireccion: "
				+ ((ubicacion != null) ? ubicacion : "");
	}
}
