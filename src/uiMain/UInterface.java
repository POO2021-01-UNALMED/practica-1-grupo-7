package uiMain;

import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.util.Date;

import gestorAplicacion.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.Locale;
import utilidades.Utils;

public class UInterface {
        
    private static Scanner input = new Scanner(System.in);
    
    public static void main(String[] args) {
        
        // PRUEBAS (BORRAR)
//        Date envio;
//        String fEnvio;
//        do {
//            System.out.print("Fecha de envio (DD-MM-AAAA): ");
//            fEnvio = input.next();
//            
//            envio = Utils.validarFormatoFecha((fEnvio));
//            System.out.println(envio);
//            
//        } while (envio == null);
        
        // VARIABLES AUXILIARES
        int opcion;
        
        // INFO DE PRUEBA
        Empleado empleadoSE = new Empleado("Maria", "1037633515", 2000000, "01-01-2022");

        Localizacion local1 = new Localizacion("Antioquia", "Carolina", "Barrio azul", "Cra 45b #80-76");
        Localizacion local2 = new Localizacion("Cundinamarca", "Bogota", "Barrio morado", "Cll 170 av.caracas");

        Cliente cliente1 = new Cliente("Esteban Bermudez", "7758", "2607070", local1);
        Cliente cliente2 = new Cliente("Andrea Amaya", "1234567890", "2608080", local2);
        OficinaBodega.clientes.add(cliente1);
        OficinaBodega.clientes.add(cliente2);        

        OficinaBodega ofiBo = new OficinaBodega("Super Envios", local1, "8627365", empleadoSE);

        // MENÚ PRINCIPAL
        do {
            System.out.println("\n  ¡BIENVENIDO(A) A SUPERENVIOS!\n");
            System.out.println("\t.:MENÚ PRINCIPAL:.\n");
//            System.out.println("0. Administrar");  ¿AGREGAR ADMIN?
            System.out.println("1. Ver datos de la oficina");
            System.out.println("2. Realizar nuevo envío");
            System.out.println("3. Rastrear o ver detalles de envio");
            System.out.println("4. Terminar sesión");
            System.out.print("Ingresa el número de la opción deseada: ");
            opcion = input.nextInt();

            switch (opcion) {
                case 1:
                    datosOfi(ofiBo);
                    break;
                case 2:
                    nuevoEnvio(empleadoSE);
                    break;
                case 3:
                    System.out.print("Digita el id del envio: ");
                    int idEnc = input.nextInt();
                    rastrearEnvio(idEnc);
                    break;
                case 4:
                    System.out.println("Sesión terminada con éxito");
                    
                    break;  // TODO: SERIALIZAR INFO
                default:
                    System.out.println("Opción no disponible");
            }

        } while (opcion != 4);
    }
        
    // MÉTODOS DE ACCIÓN
    private static void datosOfi(OficinaBodega ofiBo) {
        System.out.println(ofiBo.toString());
    }

    private static void nuevoEnvio(Empleado emp) {
        Encomienda nuevaEnc = emp.crearEncomienda();
        double costoEnv = emp.calcularCostosEnv(nuevaEnc);
        
        System.out.println("== ENCOMIEDA CREADA CON ÉXITO ==");
        System.out.println(
            "Número de guía (CONSERVE ESTE NÚMERO PARA HACER SUS CONSULTAS): " + nuevaEnc.getId()
        );
        System.out.print("Costos de envio: $" + costoEnv);
        
        System.out.println(
            "\n1. Confirmar y realizar envio (NO SE PUEDEN HACER MODIFICACIONES UNA VEZ CONFIRMADO EL ENVÍO)"
        );
        System.out.println("2. Cancelar (elimina los datos de la encomienda)");
        int op = input.nextInt();
        
        switch (op) {
            case 1:
                emp.realizarEnvio(nuevaEnc);
                break;
            case 2:
                Utils.borrarEncDB(nuevaEnc);
                break;
        }
    }

    private static void rastrearEnvio(int idEnc) {
        for (Encomienda enc: OficinaBodega.encomiendas){
            if (enc.getId() == idEnc){
                System.out.println("\n == Encomienda No. " + idEnc + "== ");
                System.out.println(enc);
                return;
            }
        }
        System.out.println("\nEncomienda no encontrada");
    }
}
