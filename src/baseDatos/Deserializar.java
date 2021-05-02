package baseDatos;
import java.io.*;
import java.util.Date;
import java.util.List;

import gestorAplicacion.OficinaBodega;// IMPORTAR OficinaBodega

public class Deserializar {
	
	private static File rutaTemp = new File("\\src\\baseDatos\\temp");

	public static void deserializar(OficinaBodega ofiBo) {
		File[] docs = rutaTemp.listFiles();
		FileInputStream fis;
		ObjectInputStream ois;

		for (File file : docs) {
			if (file.getAbsolutePath().contains("encomiendas")) {// encomiendas??
				try {
					fis = new FileInputStream(file);
					ois = new ObjectInputStream(fis);	
					ofiBo.setEncomiendas(List<Encomienda>) ois.readObject();
					
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				}
			}else if(file.getAbsolutePath().contains("clientes")){
				try {
					fis = new FileInputStream(file);
					ois = new ObjectInputStream(fis);	
					ofiBo.setClientes(List<Cliente>); ois.readObject();
					
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
