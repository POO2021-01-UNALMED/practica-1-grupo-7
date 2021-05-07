package gestorAplicacion;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class OficinaBodega implements Serializable {

    // ATRIBUTOS
	private Administrador admin;
    private String nombre;
    public static Localizacion ubicacion;
    private String telefono;
    public static Empleado empleado;
    
    // "BASE DE DATOS"
    public static List<Encomienda> encomiendas = new ArrayList<>();
    public static List<Cliente> clientes = new ArrayList<>();

    // CONSTRUCTOR
    public OficinaBodega(
            String nombre,
            Localizacion ubicacion,
            String telefono, Administrador admin
            ) {
        this.nombre = nombre;
        this.ubicacion = ubicacion;
        this.telefono = telefono;
        this.admin = admin;
    }

    // GETTERS Y SETTERS
    public String getNombre() {
        return nombre;
    }

    public static List<Encomienda> getEncomiendas() {
        return encomiendas;
    }

    public static void setEncomiendas(List<Encomienda> encomiendas) {
        OficinaBodega.encomiendas = encomiendas;
    }

    public static List<Cliente> getClientes() {
        return clientes;
    }

    public static void setClientes(List<Cliente> clientes) {
        OficinaBodega.clientes = clientes;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

//    public Localizacion getUbicacion() {
//        return ubicacion;
//    }
//
//    public void setUbicacion(Localizacion ubicacion) {
//        this.ubicacion = ubicacion;
//    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

//    public Empleado getEmpleado() {
//        return empleado;
//    }
//
//    public void setEmpleado(Empleado empleado) {
//        this.empleado = empleado;
//    }
    
    // TOSTRING
    @Override
    public String toString() {
        return "\n== INFORMACION DE LA EMPRESA =="
                + "\nNombre: " + nombre
                + "\nUbicacion: " + ubicacion
                + "\nTelefono: " + telefono
                + "\n == REPRESENTANTE LEGAL == \n" 
                + admin;
    }
}
