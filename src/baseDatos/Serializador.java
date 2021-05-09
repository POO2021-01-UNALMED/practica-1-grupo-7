package baseDatos;

import java.io.*;
import java.util.List;

import gestorAplicacion.*;

public class Serializador {
    
    // METODOS DE SERIALIZACION
    public static void serializarClientes(List<Cliente> clientes) {
        try {
            ObjectOutputStream file = new ObjectOutputStream(new FileOutputStream("src\\baseDatos\\temp\\clientes.txt"));
            file.writeObject(clientes);
            file.close();

        } catch (IOException e) {  } 
   }
    
    public static void serializarEnc(List<Encomienda> encomiedas) {
        try {
            ObjectOutputStream file = new ObjectOutputStream(new FileOutputStream("src\\baseDatos\\temp\\encomiendas.txt"));
            file.writeObject(encomiedas);
            file.close();

        } catch (IOException e) {  } 
   }
    
    public static void serializarEmp(Empleado emp) {
        try {
            ObjectOutputStream file = new ObjectOutputStream(new FileOutputStream("src\\baseDatos\\temp\\empleado.txt"));
            file.writeObject(emp);
            file.close();

        } catch (IOException e) {  } 
   }
    
    public static void serializarConteoIdEnc(int id) {
        try {
            ObjectOutputStream file = new ObjectOutputStream(new FileOutputStream("src\\baseDatos\\temp\\id.txt"));
            file.writeObject(id);
            file.close();

        } catch (IOException e) {  } 
    }
}
       
        