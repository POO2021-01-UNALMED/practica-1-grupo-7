package gestorAplicacion;

public class Persona {
	
	// ATRIBUTOS
	private String nombre;
	private double id;
	
	// CONSTRUCTOR
	public Persona(String nombre, double id) {
		super();
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
	public double getId() {
		return id;
	}
	public void setId(double id) {
		this.id = id;
	}
	
	// TOSTRING
	public String toString() {
		return "Nombre: " + nombre
				+ "\nId: " + id;
	}
}
