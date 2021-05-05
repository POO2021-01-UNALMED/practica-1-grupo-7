package baseDatos;

// librerías
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;

import gestorAplicacion.OficinaBodega; //

public class Serializador {
	
	private static File rutaTemp = new File("src\\baseDatos\\temp");
	
	// Este es el método encargado de serializar las listas que estan creadas en la clase Depto
	public static void serializar(OficinaBodega ofiBo) {
		FileOutputStream fos;
		ObjectOutputStream oos;
		File[] docs = rutaTemp.listFiles();
		PrintWriter pw;
		
		
		for(File file : docs) {
			try {
				pw = new PrintWriter(file);
			}catch(FileNotFoundException e ) {
				e.printStackTrace();
			}
		}
		
		for(File file : docs) {
			if(file.getAbsolutePath().contains("asignturas")) {
				try {
					fos = new FileOutputStream(file);
					oos = new ObjectOutputStream(fos);
					oos.writeObject(dpto.getAsiganturas());	
				}catch (FileNotFoundException e) {
					e.printStackTrace();
				}
			}else if(file.getAbsolutePath().contains("alumnos")) {
				try {
					fos = new FileOutputStream(file);
					oos = new ObjectOutputStream(fos);
					oos.writeObject(dpto.getAlumnos());	
				}catch(FileNotFoundException e) {
					e.printStackTrace();
				}catch(IOException e) {
					e.printStackTrace();
				}	
			}
		}
	} // Aqui termina
}
