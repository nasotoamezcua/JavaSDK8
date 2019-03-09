package com.soto.java8.defaultMethod;

public interface PersonaA{
	
	public void caminar();
	
	default public void hablar() {
		System.out.println("Hola Coders - PersonaA");
		
	}

}
