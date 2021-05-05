package baseDatos;

import java.io.*;
import java.util.List;
import matricula.Departamento;
import matricula.Asignatura;
import matricula.Alumno;

public class Deserializador {
	private static File rutaTemp = new File("src\\baseDatos\\temp");// ruta

	public static void deserializar(Departamento dpto) {
		File[] docs = rutaTemp.listFiles() ;
		FileInputStream fis;
		ObjectInputStream ois; 
		
		for(File file:docs) {
			if(file.getAbsolutePath().contains("asignaturas")){
				try {
					fis = new FileInputStream(file);
					ois = new ObjectInputStream(fis);	
					dpto.setAsignaturas(List<Asignatura>) ois.readObject();

				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				}
			}
		
		else if(file.getAbsolutePath().contains("alumnos")){
				try {
					fis = new FileInputStream(file);
					ois = new ObjectInputStream(fis);	
					dpto.setAlumnos(List<Alumno>); ois.readObject();

				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				}

			}
		}

	}
}