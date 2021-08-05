package gestorAplicacion;

abstract class Transporte implements IdTransporte {

	// MÉTODOS
	public static String idCarroEnvioRetornar() {  // Transporte asignado para la entrega
		return idTrasnporte[(int) (0 + (Math.random() * (11)))];
	}
	 
	public static void trasportarEnc(Encomienda enc) {

		if (!enc.getEstado().equals("Entregado")) {
			enc.setEstado("En camino");
			int time = (int) (20 + (Math.random() * (60 - 20)));
			System.out.println("Tiempo estimado de entrega: " + time + " segs");
			new java.util.Timer().schedule(new java.util.TimerTask() {
				@Override
				public void run() {
					enc.setEstado("Entregado");
					enc.setUltimaLocalizacion(enc.getLugarEntrega());
					System.out.println(
						"\n\n== LA ENCOMIENDA NO." + enc.getId() + " HA SIDO ENTREGADA CON EXITO == \n"
						+ "== Encomienda realizada en transporte con id: " + idCarroEnvioRetornar() + " == \n"
						);
				}
			}, time * 1000);
		}
	}

	public static void trasportarEncPend(Encomienda enc) {

		if (!enc.getEstado().equals("Entregado")) {
			enc.setEstado("En camino");
			int time = (int) (20 + (Math.random() * (60 - 20)));
			System.out.println("Encomienda No. " + enc.getId() + " despachada");
			System.out.println("Encomienda despachada en transporte con id: " + idCarroEnvioRetornar());
			System.out.println("Tiempo estimado de entrega: " + time + " segs");
			new java.util.Timer().schedule(new java.util.TimerTask() {
				@Override
				public void run() {
					enc.setEstado("Entregado");
					enc.setUltimaLocalizacion(enc.getLugarEntrega());
					System.out.println(
						"\n\n== LA ENCOMIENDA NO." + enc.getId() + " HA SIDO ENTREGADA CON EXITO == \n"
						+ "== Encomienda realizada en transporte con id: " + idCarroEnvioRetornar() + " == \n"
						);
				}
			}, time * 1000);
		}
	}
}
