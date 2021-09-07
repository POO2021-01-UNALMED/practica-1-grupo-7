package modelo;

import java.io.Serializable;

public class Localizacion implements Serializable {

	// ATRIBUTOS
	private String pais = "Colombia";
	private String departamento;
	private String municipio;
	private String barrio;
	private String direccion;

	// CONSTRUCTOR
	public Localizacion(String departamento, String municipio, String barrio, String direccion) {
		this.departamento = departamento;
		this.municipio = municipio;
		this.barrio = barrio;
		this.direccion = direccion;
	}

	// GETTERS Y SETTERS
	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public String getDepartamento() {
		return departamento;
	}

	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}

	public String getMunicipio() {
		return municipio;
	}

	public void setMunicipio(String municipio) {
		this.municipio = municipio;
	}

	public String getBarrio() {
		return barrio;
	}

	public void setBarrio(String barrio) {
		this.barrio = barrio;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	// TOSTRING
	@Override
	public String toString() {

		return direccion + ", " + barrio + ", " + municipio + ", " + departamento + ", " + pais;
	}
}
