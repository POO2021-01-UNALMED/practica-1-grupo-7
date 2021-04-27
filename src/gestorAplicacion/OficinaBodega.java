package gestorAplicacion;

import java.util.ArrayList;
import java.util.List;

public class OficinaBodega {
    
	// ATRIBUTOS
    private String nombre;
    private Localizacion ubicacion;
    private String telefono;
    private Empleado empleado;
    private List<Encomienda> encomiendas = new ArrayList<>();
    private List<Cliente> clientes = new ArrayList<>();


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
    
    // GETTERS Y SETTERS
    public List<Encomienda> getEncomiendas() {
    	return encomiendas;
    }
    
    public List<Cliente> getClientes() {
    	return clientes;
    }
    
    // TOSTRING
    @Override
    public String toString() {
    	return "\n== Información de la empresa =="
    			+ "\nNombre: " + nombre
    			+ "\nUbicación: " + ubicacion
    			+ "\nTelefono: " + telefono
    			+ "\n\n== Datos del empleado actual ==\n" + empleado
    			+ "\n";
    }
}