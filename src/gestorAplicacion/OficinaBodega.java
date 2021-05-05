package gestorAplicacion;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import baseDatos.Deserializador;

public class OficinaBodega implements Serializable  {
    
	// ATRIBUTOS
    private String nombre;
    private Localizacion ubicacion;
    private String telefono;
    private Empleado empleado;
	private static LinkedList<Empleado> empleados = new LinkedList<>();
	private static LinkedList<Localizacion> localizaciones = new LinkedList<>();
	private static LinkedList<Cliente> clientes = new LinkedList<>();
	private static LinkedList<Encomienda> encomiendas = new LinkedList<>();


	// CONSTRUCTOR
	
	public OficinaBodega() {
		Deserializador.deserializar(this);
	}
	
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
    	return "\n== Informacion de la empresa =="
    			+ "\nNombre: " + nombre
    			+ "\nUbicacion: " + ubicacion
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


	public static LinkedList<Empleado> getEmpleados() {
		return empleados;
	}
	
	// setters y getters listas
	
	public static void setEmpleados(LinkedList<Empleado> empleados) {
		OficinaBodega.empleados = empleados;
	}


	public static LinkedList<Localizacion> getLocalizaciones() {
		return localizaciones;
	}


	public static void setLocalizaciones(LinkedList<Localizacion> localizaciones) {
		OficinaBodega.localizaciones = localizaciones;
	}


	public static LinkedList<Cliente> getClientes() {
		return clientes;
	}


	public static void setClientes(LinkedList<Cliente> clientes) {
		OficinaBodega.clientes = clientes;
	}


	public static LinkedList<Encomienda> getEncomiendas() {
		return encomiendas;
	}


	public static void setEncomiendas(LinkedList<Encomienda> encomiendas) {
		OficinaBodega.encomiendas = encomiendas;
	}
	

	
	
	
	
	
}