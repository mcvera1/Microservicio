package co.com.webService.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "person")
public class Persona implements Serializable{
	private static final long serialVersionUID = -7389382787146355729L;
	
	@Id
	@Column(name="id")
	private Long id;
	
	@Column(name="name")
	private String nombre;
	
	@Column(name="phone")
	private int telefono;
	
	public Persona() {
		
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public int getTelefono() {
		return telefono;
	}
	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}
	
	@Override
	public String toString() {
		return "Persona [id=" + id + ", nombre=" + nombre + ", telefono=" + telefono + "]";
	}
}
