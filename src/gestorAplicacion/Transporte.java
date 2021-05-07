package gestorAplicacion;

public class Transporte {

    public static void trasportarEnc(Encomienda enc) {

        if (!enc.getEstado().equals("Entregado")) {
            enc.setEstado("En camino");
            int time = (int) (20 + (Math.random() * (60 - 20)));
            System.out.println("Tiempo estimado de entrega: " + time + " segs");
            new java.util.Timer().schedule(
                new java.util.TimerTask() {
                @Override
                public void run() {
                    enc.setEstado("Entregado");
                    enc.setUltimaLocalizacion(enc.getLugarEntrega());
                    System.out.println("\n\n== LA ENCOMIENDA NO." + enc.getId() + " HA ENTREDADA CON EXITO == \n");
                }
            },
            time * 1000
            );
        }
    }
}
