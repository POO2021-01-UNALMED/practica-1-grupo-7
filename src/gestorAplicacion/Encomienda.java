package gestorAplicacion;

public class Encomienda {
	
	// ATRIBUTOS
	private static int encRealizadas = 0;
	
	private long id;
	private float peso;
	private float largo;
	private float ancho;
	private float alto;
	private String descripcionEnc;
	private String fechaEnvio;
	private String fechaEntrega;
	private Localizacion lugarEntrega;
	private Localizacion ultimaLocalizacion;
	private Cliente remitente;
	private Cliente destinatario;
	private boolean estadoRecibido;
	
	private double costosEnvio;
	
	public Encomienda(float peso, float largo, float ancho, float alto, String descripcionEnc,
			String fechaEnvio, String fechaEntrega, Localizacion lugarEntrega, Localizacion ultimaLocalizacion,
			Cliente remitente, Cliente destinatario, boolean estadoRecibido) {
		this.peso = peso;
		this.largo = largo;
		this.ancho = ancho;
		this.alto = alto;
		this.descripcionEnc = descripcionEnc;
		this.fechaEnvio = fechaEnvio;
		this.fechaEntrega = fechaEntrega;
		this.lugarEntrega = lugarEntrega;
		this.ultimaLocalizacion = ultimaLocalizacion;
		this.remitente = remitente;
		this.destinatario = destinatario;
		this.estadoRecibido = estadoRecibido;
		
		encRealizadas ++;
		id = encRealizadas;
	}
	
	//public Encomienda() {}  // TODO: TEMPORAL, ELIMINAR

	// GETTERS Y SETTERS
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDescripcionEnc() {
		return descripcionEnc;
	}

	public void setDescripcionEnc(String descripcionEnc) {
		this.descripcionEnc = descripcionEnc;
	}

	public String getFechaEnvio() {
		return fechaEnvio;
	}

	public void setFechaEnvio(String fechaEnvio) {
		this.fechaEnvio = fechaEnvio;
	}

	public String getFechaEntrega() {
		return fechaEntrega;
	}

	public void setFechaEntrega(String fechaEntrega) {
		this.fechaEntrega = fechaEntrega;
	}

	public Localizacion getLugarEntrega() {
		return lugarEntrega;
	}

	public void setLugarEntrega(Localizacion lugarEntrega) {
		this.lugarEntrega = lugarEntrega;
	}

	public Localizacion getUltimaLocalizacion() {
		return ultimaLocalizacion;
	}

	public void setUltimaLocalizacion(Localizacion ultimaLocalizacion) {
		this.ultimaLocalizacion = ultimaLocalizacion;
	}

	public Cliente getRemitente() {
		return remitente;
	}

	public void setRemitente(Cliente remitente) {
		this.remitente = remitente;
	}

	public Cliente getDestinatario() {
		return destinatario;
	}

	public void setDestinatario(Cliente destinatario) {
		this.destinatario = destinatario;
	}

	public boolean isEstadoRecibido() {
		return estadoRecibido;
	}

	public void setEstadoRecibido(boolean estadoRecibido) {
		this.estadoRecibido = estadoRecibido;
	}
	
	public float getPeso() {
		return peso;
	}
	
	public void setPeso(float peso) {
		this.peso = peso;
	}
	
	public float getLargo() {
		return largo;
	}
	
	public void setLargo(float largo) {
		this.largo = largo;
	}
	
	public float getAncho() {
		return ancho;
	}
	
	public void setAncho(float ancho) {
		this.ancho = ancho;
	}
	
	public float getAlto() {
		return alto;
	}
	
	public void setAlto(float alto) {
		this.alto = alto;
	}
	
	public double getCostosEnvio() {
		return costosEnvio;
	}
	
	public void setCostosEnvio(double costosEnvio) {
		this.costosEnvio = costosEnvio;
	}
	
	// TOSTRING
	@Override
	public String toString() {
		return "Id: " + id
				+ "\nPeso: " + peso
				+ "\nLargo: " + largo
				+ "\nAncho: " + ancho
				+ "\nAlto: " + alto
				+ "\nDescripci�n: " + descripcionEnc
				+ "\nFecha de env�o: " + fechaEnvio
				+ "\nFecha aproximada de llegada: " + fechaEntrega
				+ "\nLugar de entrega: " + lugarEntrega
				+ "\n�ltima localizaci�n: " + ultimaLocalizacion
				+ "\nRemitente: " + remitente
				+ "\nDestinatario: " + destinatario
				+ "\nCostos de envio: " + costosEnvio
				+ "\nEstado: " + estadoRecibido;
	}

}



















