package gestorAplicacion;

public class Empleado extends Persona {
	
	// ATRIBUTOS
	private float salario;
	private String vigenciaContrato;
	 	
	// CONSTRUCTOR (implementa herencia)
	public Empleado(String nombre, String id, float salario, String vigenciaContrato) {
		super(nombre, id);
		this.salario = salario;
		this.vigenciaContrato = vigenciaContrato;
	}
	
	// METODOS
	public Encomienda crearEncomienda() {
		return new Encomienda(); // TODO: Borrar
		/* TODO: Crear instrucciones donde se pida
		 * y se pida la información del paquete al empleado
		 * y se cree el paquete que será retornado por el 
		 * método 
		 * 
		 * Usar el atributo estático "clientes" de la oficina-bodega para ver
		 * si el usuario (tanto remitente como destinatario)
		 * ya está registrado en la base de datos (lista) y no 
		 * tener que volver a llenar todos sus datos. En caso
		 * de que no esté, agregarlo a OficinaBodega.clientes
		 * 
		 * 
		 */
	
	}
	
	public void realizarEnvio(Encomienda enc, Cliente destinatario) {
		// TODO: Este lo podemos mirar después
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
	
	
	public String getVigenciaContrato() {
		return vigenciaContrato;
	}

	public void setVigenciaContrato(String vigenciaContrato) {
		this.vigenciaContrato = vigenciaContrato;
	}

	// TOSTRING
	@Override
	public String toString() {
		return "Nombre: " + super.getNombre()
				+ "\nSuperEnviosId: " + super.getId()
				+ "\nSalario: $" + salario
				+ "\n¿Vigencia del contrato?: " + vigenciaContrato;
	}
}
