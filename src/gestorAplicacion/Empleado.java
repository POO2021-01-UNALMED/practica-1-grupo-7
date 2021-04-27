package gestorAplicacion;

public class Empleado extends Persona {
	
	// ATRIBUTOS
	private float salario;
	// ¿Vigencia del contrato?
	 	
	// CONSTRUCTOR
	public Empleado(String nombre, String id, float salario) {
		super(nombre, id);
		this.salario = salario;
	}
	
	// METODOS
	public Encomienda crearEncomienda() {
		return new Encomienda();
	}
	
	public void realizarEnvio(Encomienda enc, Cliente destinatario) {
		
	}
	
	public double costosEnvio(Encomienda enc) {
		double costoTotal;
		costoTotal = enc.getAlto() * 150
					+ enc.getAncho() * 150
					+ enc.getPeso() * 200
					+ enc.getLargo() * 150;
		
		enc.setCostosEnvio(costoTotal);
		return enc.getCostosEnvio();
	}
	
	// GETTERS Y SETTERS
	public float getSalario() {
		return salario;
	}
	
	public void setSalario(float s) {
		salario = s;
	}
	
	// TOSTRING
	@Override
	public String toString() {
		return "Nombre: " + super.getNombre()
				+ "\nSuperEnviosId: " + super.getId()
				+ "\nSalario: $" + salario
				+ "\n¿Vigencia del contrato?: ";
	}
}
