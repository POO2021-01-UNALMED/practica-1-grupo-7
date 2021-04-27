package gestorAplicacion;

public class Cliente extends Persona {
	
	// ATRIBUTOS
	private double telefono;
	private Localizacion ubicacion;
	
	// CONSTRUCTOR
	public Cliente(String nombre, String id, double telefono, Localizacion ubicacion) {
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
	
	public double getTelefono() {
		return telefono;
	}

	public void setTelefono(double telefono) {
		this.telefono = telefono;
	}
	
	// TOSTRING
	@Override
	public String toString() {
		return "Nombre: " + getNombre()
				+ "\nId: " + getId()
				+ "\nTelefono: " + telefono
				+ "\nDirección: " + ubicacion;
	}
}
