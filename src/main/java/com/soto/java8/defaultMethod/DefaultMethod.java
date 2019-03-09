package com.soto.java8.defaultMethod;

public class DefaultMethod implements PersonaA, PersonaB {
	
	@Override
	public void caminar() {
		System.out.println("Saludos Coders");
	}
	
	//Para llamar un metodo default de una interfaz, solo hay que invocarlo,
	//No se tiene que sobreescribir el metodo en la clase
	
	/*En caso de existir dos interfaces default con el mismo metodo  default "void hablar()".
	 * Se tiene que sobreescribir el metodo y hay que indicar la interface que se va utilizar
	@Override
	public void hablar() {
		PersonaB.super.hablar();
	}*/
	
	
	//En caso de existir dos interfaces default con el mismo metodo  default "void hablar()"
	// Y ninguno se quiere implementar, es necesario sobreescribir el metodo en la clase. 
	@Override
	public void hablar() {
		System.out.println("Suscribanse Coders");
	}

	public static void main(String[] args) {
		DefaultMethod app = new DefaultMethod();
		app.hablar();
	}

	

}
