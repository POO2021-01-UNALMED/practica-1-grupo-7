package modelo;

import java.io.Serializable;

public class Persona implements Serializable {

	// ATRIBUTOS
	protected String nombre;  
	protected final String id;  // Quitar final si sale error

	// CONSTRUCTOR
	public Persona(String nombre) {
		this(nombre, "No especifica");
	}
	
	public Persona(String nombre, String id) {
		this.nombre = nombre;
		this.id = id;
	}

	// GETTERS Y SETTERS
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getId() {
		return id;
	}

	// TOSTRING
	@Override
	public String toString() {
		return "Nombre: " + nombre + "\nId: " + id;
	}
}
