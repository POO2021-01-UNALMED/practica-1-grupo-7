package gestorAplicacion;

import java.util.ArrayList;
import java.util.List;

public class OficinaBodega {
    
	// ATRIBUTOS
    private String nombre;
    private Localizacion ubicacion;
    private String telefono;
    private Empleado empleado;
    public static List<Encomienda> encomiendas = new ArrayList<>();
    public static List<Cliente> clientes = new ArrayList<>();


	// CONSTRUCTOR
    public OficinaBodega(
            String nombre, 
            Localizacion ubicacion, 
            String telefono,
            Empleado empleado) {
        this.nombre    = nombre;
        this.ubicacion = ubicacion;
        this.telefono  = telefono;
        this.empleado  = empleado;
    }
    
        
    // TOSTRING
    @Override
    public String toString() {
    	return "\n== Informaci�n de la empresa =="
    			+ "\nNombre: " + nombre
    			+ "\nUbicaci�n: " + ubicacion
    			+ "\nTelefono: " + telefono
    			+ "\n\n== Datos del empleado actual ==\n" + empleado
    			+ "\n";
    }
    
    //getters and setters

	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public Localizacion getUbicacion() {
		return ubicacion;
	}


	public void setUbicacion(Localizacion ubicacion) {
		this.ubicacion = ubicacion;
	}


	public String getTelefono() {
		return telefono;
	}


	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}


	public Empleado getEmpleado() {
		return empleado;
	}


	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}
}