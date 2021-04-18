package gestorAplicacion;

public class Cliente extends Persona {
	
	// ATRIBUTOS
	private double telefono;
	// TODO: Agregar atributo dirección (Ubicación)
	
	// CONSTRUCTOR
	public Cliente(String nombre, double id, double telefono) {
		super(nombre, id);
		this.telefono = telefono;
	}

	// GETTERS Y SETTERS
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
				+ "\nDirección: "; // TODO: Agregar dirección;
	}
}
