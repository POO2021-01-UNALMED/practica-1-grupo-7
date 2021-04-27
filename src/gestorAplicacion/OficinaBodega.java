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
}