package utilidades;

import java.util.Date;

import gestorAplicacion.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Utils {

	public static boolean validarPLAA(float valor) { // PLAA: Peso, largo, ancho, alto
		return valor < 0;
	}
	
	public static boolean validarPLAA(double valor) { // PLAA: Peso, largo, ancho, alto
		return valor < 0;
	}

	public static boolean buscarClienteDB(String idC) {

		for (Cliente cliente : OficinaBodega.clientes) {
			if (cliente.getId().equals(idC)) {
				return true;
			}
		}
		return false;
	}

	public static Cliente detallesCliente(String idC) {

		for (Cliente cliente : OficinaBodega.clientes) {
			if (cliente.getId().equals(idC)) {
				return cliente;
			}
		}
		return null;
	}

	public static void borrarEncDB(Encomienda enc) {

		for (Encomienda encomienda : OficinaBodega.encomiendas) {
			if (encomienda.getId() == enc.getId()) {
				OficinaBodega.encomiendas.remove(enc);
				OficinaBodega.encomiendasRealizadas --;
				System.out.println("\n== ENCOMIENDA ELIMINADA ==");
				return;
			}
		}
	}

	public static Date validarFormatoFecha(String f) {

		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		Date fecha;

		if (f.matches("\\d{1}-\\d{1}-\\d{4}") || f.matches("\\d{2}-\\d{2}-\\d{4}") || f.matches("\\d{1}-\\d{2}-\\d{4}")
				|| f.matches("\\d{2}-\\d{1}-\\d{4}")) {
			try {
				fecha = formatter.parse(f);
				return fecha;
			} catch (ParseException e) {
			}
		}
		return null;
	}

	public static boolean comprobarFechasEnvEnt(Date envio, Date entrega) {

		if (entrega.before(envio)) {
			System.out.println("LA FECHA DE ENTREGA DEBE SER MAYOR O IGUAL A LA FECHA DE ENVIO");
			return true;
		} else {
			return false;
		}
	}
}
