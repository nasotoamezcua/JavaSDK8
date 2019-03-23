package com.soto.java8.cambiarObjeto;

public class CambiarObjeto {
	
	private static void modificaObjeto(Persona persona) {
		
		System.out.println("persona parametro: " + persona.toString());
		persona.setEdad("35");
		persona = new Persona("Alejandro","Soto","Amezcua", "33");
		System.out.println("persona nueva referencia: " + persona.toString());
		persona.setEdad("36");
		System.out.println("persona nueva referencia modificado: " + persona.toString());
	}
	
	public static void main(String[] args) {
		Persona persona = new Persona("Nestor Alejandro","Soto","Amezcua", "34");
		modificaObjeto(persona);
		System.out.println("persona original: " + persona.toString());
	}
}
