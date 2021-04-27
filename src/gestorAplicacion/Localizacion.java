package gestorAplicacion;

public class Localizacion {
	
	// ATRIBUTOS
    private String pais = "Colombia";
    private String departamento;
    private String municipio;
    private String barrio;
    private String direccion;
    
    // CONSTRUCTOR
    public Localizacion( 
    		String departamento, String municipio, 
    		String barrio, String direccion) {
    	this.departamento = departamento;
    	this.municipio = municipio;
    	this.barrio = barrio;
    	this.direccion = direccion;
    }
   
    // TOSTRING
	@Override
	public String toString() {
		
		return direccion
				+ ", " + barrio
				+ ", " + municipio
				+ ", " + departamento
				+ ", " + pais;
	}

}
