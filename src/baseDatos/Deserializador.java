package baseDatos;

import java.io.*;
import java.util.List;

import gestorAplicacion.*;

public class Deserializador {
    
    // ATRIBUTOS
    private static String rutaGeneral = System.getProperty("user.dir")+"\\src\\baseDatos\\temp\\";
    
    // MÉTODOS DE DESERIALIZACIÓN
    private static File rutaClientes = new File(rutaGeneral + "clientes.txt");
    public static void deserializarClientes(){
        FileInputStream fis;
        ObjectInputStream ois;
        try {
            fis = new FileInputStream(rutaClientes);
            ois = new ObjectInputStream(fis);
            List<Cliente> clientes = (List<Cliente>) ois.readObject();
            ois.close();
            OficinaBodega.clientes = clientes;
        } catch (IOException | ClassNotFoundException e) {  }
    }
    
    private static File rutaEnc = new File(rutaGeneral + "encomiendas.txt");
    public static void deserializarEncomiendas(){
        FileInputStream fis;
        ObjectInputStream ois;
        try {
            fis = new FileInputStream(rutaEnc);
            ois = new ObjectInputStream(fis);
            List<Encomienda> encomiendas = (List<Encomienda>) ois.readObject();
            ois.close();
            OficinaBodega.encomiendas = encomiendas;
        } catch (IOException | ClassNotFoundException e) {  }
    }
    
    private static File rutaEmp = new File(rutaGeneral + "empleado.txt");
    public static void deserializarEmpleado(){
        FileInputStream fis;
        ObjectInputStream ois;
        try {
            fis = new FileInputStream(rutaEmp);
            ois = new ObjectInputStream(fis);
            Empleado emp = (Empleado) ois.readObject();
            ois.close();
            OficinaBodega.empleado = emp;
        } catch (IOException | ClassNotFoundException e) {  }
    }
    
    private static File rutaId = new File(rutaGeneral + "id.txt");
    public static void deserializarConteoIdEncomienda(){
        FileInputStream fis;
        ObjectInputStream ois;
        try {
            fis = new FileInputStream(rutaId);
            ois = new ObjectInputStream(fis);
            int id = (int) ois.readObject();
            ois.close();
            OficinaBodega.encomiendasRealizadas = id;
        } catch (IOException | ClassNotFoundException e) {  }
    }
}
