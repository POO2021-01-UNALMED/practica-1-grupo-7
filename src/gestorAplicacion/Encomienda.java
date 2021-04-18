package gestorAplicacion;

public class Encomienda {
	private long id;
	private float peso;
	private float largo;
	private float ancho;
	private float alto;
	private String descripcionEnconmienda;
	private String fechaEnvio;
	private String fechaEntrega;
	private Localizacion lugarEntrega;
	private Localizacion ultimaLocalizacion;
	private Cliente vendedor;
	private Cliente comprador;
	private boolean estadoRecibido;
	
	public Encomienda(long id, float peso, float largo, float ancho, float alto, String descripcionEnconmienda,
			String fechaEnvio, String fechaEntrega, Localizacion lugarEntrega, Localizacion ultimaLocalizacion,
			Cliente vendedor, Cliente comprador, boolean estadoRecibido) {
		super();
		this.id = id;
		this.peso = peso;
		this.largo = largo;
		this.ancho = ancho;
		this.alto = alto;
		this.descripcionEnconmienda = descripcionEnconmienda;
		this.fechaEnvio = fechaEnvio;
		this.fechaEntrega = fechaEntrega;
		this.lugarEntrega = lugarEntrega;
		this.ultimaLocalizacion = ultimaLocalizacion;
		this.vendedor = vendedor;
		this.comprador = comprador;
		this.estadoRecibido = estadoRecibido;
	}

	@Override
	public String toString() {
		return "Encomienda [id=" + id + ", peso=" + peso + ", largo=" + largo + ", ancho=" + ancho + ", alto=" + alto
				+ ", descripcionEnconmienda=" + descripcionEnconmienda + ", fechaEnvio=" + fechaEnvio
				+ ", fechaEntrega=" + fechaEntrega + ", vendedor=" + vendedor + ", comprador=" + comprador
				+ ", estadoRecibido=" + estadoRecibido + "]";
	}
	
	
	
	
	

}
	


