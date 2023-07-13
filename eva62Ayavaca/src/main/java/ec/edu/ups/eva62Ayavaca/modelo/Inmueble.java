package ec.edu.ups.eva62Ayavaca.modelo;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Inmueble implements Serializable {
	
	@Id
	private String serie;
	private String peso;
	private String marca;
	private String detalle;
	private String descripcion;
	
	public String getSerie() {
		return serie;
	}
	public void setSerie(String serie) {
		this.serie = serie;
	}
	public String getPeso() {
		return peso;
	}
	public void setPeso(String peso) {
		this.peso = peso;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getDetalle() {
		return detalle;
	}
	public void setDetalle(String detalle) {
		this.detalle = detalle;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	@Override
	public String toString() {
		return "Inmueble [serie=" + serie + ", peso=" + peso + ", marca=" + marca + ", detalle=" + detalle
				+ ", descripcion=" + descripcion + "]";
	}
	
	
}