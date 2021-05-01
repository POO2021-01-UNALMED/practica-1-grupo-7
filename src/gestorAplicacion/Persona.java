package gestorAplicacion;
import java.io.Serializable;

public class Persona implements Serializable  {
	
	// ATRIBUTOS
	private String nombre;
	private String id;
	
	// CONSTRUCTOR
	public Persona(String nombre, String id) {
		this.nombre = nombre;
		this.id = id;}
		
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
	public void setId(String id) {
		this.id = id;
	}
	
	// TOSTRING
	public String toString() {
		return "Nombre: " + nombre
				+ "\nId: " + id;
	}
}
