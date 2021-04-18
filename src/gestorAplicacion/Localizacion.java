package gestorAplicacion;

public class Localizacion {
	//atributos
    private String pais = "Colombia";
    private String departamento;
    private String municipio;
    private String barrio;
    private String direccion;
    private Empleado empleado;
	@Override
	public String toString() {
		return "Localizacion [pais=" + pais + ", "
				+ "departamento=" + departamento + ","
				+ " municipio=" + municipio
				+ ", barrio=" + barrio + ", "
				+ "direccion=" + direccion + ", "
				+ "empleado=" + empleado + "]";
	}
    
    
    
    

}
