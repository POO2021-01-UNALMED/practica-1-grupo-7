package gestorAplicacion;

public class OficinaBodega {
    
	//atributos
    private String nombre;
    private Localizacion ubicacion;
    private String telefono;
    private Empleado empleado;

    //constructor
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
    
    
}