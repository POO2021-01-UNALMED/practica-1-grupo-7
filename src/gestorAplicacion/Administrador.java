package gestorAplicacion;

import java.util.Scanner;

import utilidades.Utils;

public class Administrador extends Persona{
	
	private Scanner in = new Scanner(System.in);
    
    // CONSTRUCTOR
    public Administrador(String nombre, String id) {
        super(nombre, id);
    }
    
    // METODOS
    public void verInfoEmp() {
    	
    	if (OficinaBodega.empleado == null) {
    		System.out.println("No hay empleado registrado");
    		return;
    	}
    	
    	System.out.println(OficinaBodega.empleado);
    }
    
    public void modificarSalario() {
    	
    	if (OficinaBodega.empleado == null) {
    		System.out.println("No hay empleado registrado");
    		return;
    	}
    	
    	System.out.print("Nuevo salario: ");
    	float salario = in.nextFloat();
    	OficinaBodega.empleado.setSalario(salario);
    }
    
    public void renovarContratoEmp() {
    	
    	if (OficinaBodega.empleado == null) {
    		System.out.println("No hay empleado registrado");
    		return;
    	}
    	
    	String fecha;

        do {
        	System.out.print("Nueva fecha de vencimiento de contrato (DD-MM-YYYY): ");
        	fecha = in.next();
        	
        } while (Utils.validarFormatoFecha(fecha) == null);
        
        OficinaBodega.empleado.setVigenciaContrato(fecha);
    }
    
    public void despedirEmp() {
        if (OficinaBodega.empleado == null) {
        	System.out.println("No hay empleado registrado");
        } 
        else {
        	System.out.println("\n == EMPLEADO ELIMINADO DEL SISTEMA ==");
        	System.out.println(OficinaBodega.empleado);
        	OficinaBodega.empleado = null;
        }
    }
    
	public void contratarEmp(String nombre, String id, float salario, String contrato) {
		
		OficinaBodega.empleado = new Empleado(nombre, id, salario, contrato);
	}
    
    // TOSTRING
    @Override
    public String toString() {
    	return "Nombre: " + super.getNombre()
    			+ "\nC.C: " + super.getId();
    }
}




