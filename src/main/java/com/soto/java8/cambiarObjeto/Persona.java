package com.soto.java8.cambiarObjeto;

public class Persona {
	
	private String nombre;
	private String paterno;
	private String materno;
	private String edad;
	
	
	public Persona() {}
	
	public Persona(String nombre, String paterno, String materno, String edad) {
		super();
		this.nombre = nombre;
		this.paterno = paterno;
		this.materno = materno;
		this.edad = edad;
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getPaterno() {
		return paterno;
	}
	public void setPaterno(String paterno) {
		this.paterno = paterno;
	}
	public String getMaterno() {
		return materno;
	}
	public void setMaterno(String materno) {
		this.materno = materno;
	}
	public String getEdad() {
		return edad;
	}
	public void setEdad(String edad) {
		this.edad = edad;
	}

	@Override
	public String toString() {
		return "Persona [nombre=" + nombre + ", paterno=" + paterno + ", materno=" + materno + ", edad=" + edad + "]";
	}

}
