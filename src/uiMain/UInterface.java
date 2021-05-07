package uiMain;

import java.util.Scanner;

import gestorAplicacion.*;
import utilidades.Utils;

public class UInterface {
        
    private static Scanner input = new Scanner(System.in);
    
    public static void main(String[] args) {
        
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

        // MEN� PRINCIPAL
        do {
            System.out.println("\n  �BIENVENIDO(A) A SUPERENVIOS!\n");
            System.out.println("\t.:MEN� PRINCIPAL:.\n");
            // System.out.println("0. Administrar");  �AGREGAR ADMIN?
            System.out.println("1. Ver datos de la oficina");
            System.out.println("2. Realizar nuevo env�o");
            System.out.println("3. Rastrear o ver detalles de envio");
            System.out.println("4. Terminar sesi�n");
            System.out.print("Ingresa el n�mero de la opci�n deseada: ");
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
                    System.out.println("Sesi�n terminada con �xito");
                    
                    break;  // TODO: SERIALIZAR INFO
                default:
                    System.out.println("Opci�n no disponible");
            }

        } while (opcion != 4);
    }
        
    // M�TODOS DE ACCI�N
    private static void datosOfi(OficinaBodega ofiBo) {
        System.out.println(ofiBo.toString());
    }

    private static void nuevoEnvio(Empleado emp) {
        Encomienda nuevaEnc = emp.crearEncomienda();
        double costoEnv = emp.calcularCostosEnv(nuevaEnc);
        
        System.out.println("== ENCOMIEDA CREADA CON �XITO ==");
        System.out.println(
            "N�mero de gu�a (CONSERVE ESTE N�MERO PARA HACER SUS CONSULTAS): " + nuevaEnc.getId()
        );
        System.out.print("Costos de envio: $" + costoEnv);
        
        System.out.println(
            "\n1. Confirmar y realizar envio (NO SE PUEDEN HACER MODIFICACIONES UNA VEZ CONFIRMADO EL ENV�O)"
        );
        System.out.println("2. Cancelar (elimina los datos de la encomienda)");
        System.out.print("Ingresa el n�mero de la opci�n deseada: ");
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

