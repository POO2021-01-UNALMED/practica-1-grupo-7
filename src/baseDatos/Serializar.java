package baseDatos;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import gestorAplicacion.Empleado;

public class Serializar {
	
	static File archivo = new File("");//

	public static void main(String[] args) {
		
		// Crenado Objetos
		Empleado empleado1 = new Empleado("Maria", "1037633515", 2000000, "01-01-2022");
		Empleado empleado2 = new Empleado("Mario", "2037633516", 2000000, "01-01-2022");
		try {
			FileOutputStream f = new FileOutputStream(new File(archivo.getAbsolutePath()+
					"\\src\\baseDatos\\empleados.txt"));
			ObjectOutputStream o = new ObjectOutputStream(f);
		//Escribir objetos al archivo
			o.writeObject(empleado1);
			o.writeObject(empleado2);
			
			o.close();
			f.close();
			
		
			//llamar archivo
			FileInputStream fi =  new FileInputStream(new File(archivo.getAbsolutePath()+
					"\\src\\baseDatos\\empleados.txt"));
			ObjectInputStream oi = new ObjectInputStream(fi);
			//leer objetos del archivo
			Empleado pr1 = (Empleado) oi.readObject();
			Empleado pr2 = (Empleado) oi.readObject();
			
			//System.out.println(pr1.toString());
			
			// cerrar conexiones
			oi.close();
			fi.close();
		 	
		 }
		
	}
}
