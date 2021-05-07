package utilidades;

import java.util.Date;

import gestorAplicacion.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Utils {
    
    public static boolean validarPLAA(float valor){ // PLAA: Peso, largo, ancho, alto
        return valor < 0;
    }
    
    public static boolean buscarClienteDB (String idC){
        
        for (Cliente cliente: OficinaBodega.clientes) {
            if (cliente.getId().equals(idC)){
                return true;
            }
        }
        return false;
    }
    
    public static Cliente detallesCliente(String idC){
        
        for (Cliente cliente: OficinaBodega.clientes){
            if (cliente.getId().equals(idC)){
                return cliente;
            }
        }
        return null;
    }
    
    public static void borrarEncDB(Encomienda enc){
        
        for (Encomienda encomienda: OficinaBodega.encomiendas){
            if (encomienda.getId() == enc.getId()){
                OficinaBodega.encomiendas.remove(enc);
                System.out.println("Encomienda eliminada");
                return;
            }
        }
    }
    
    public static Date validarFormatoFecha(String f){
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
                
        try {
            Date fecha = formatter.parse(f);
            return fecha;
        } catch (ParseException e) {
            System.out.println("Ingresa la fecha en formato DD-MM-YYYY y sin espacios");
            System.out.println("Ejemplo: 30-05-2020");
        }
        return null;
    }
    
    public static boolean comprobarFechasEnvEnt(Date envio, Date entrega){
        
        if (entrega.before(envio)){
            System.out.println("La fecha de entrega debe ser mayor o igual a la fecha de envío");
            return true;
        } else {
            return false;
        }
    }
}
