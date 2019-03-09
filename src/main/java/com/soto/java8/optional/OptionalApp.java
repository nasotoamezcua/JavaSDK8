package com.soto.java8.optional;

import java.util.Optional;

public class OptionalApp {
	
	/*
	 * En algunas situaciones no es muy recomendable utilizar la clase Optional
	 * Especificamente si se requieren tener aplicaciones criticas en renedimeinto
	 * Puesto que utilizar esta clase (Optional) es un poco costozo 
	 */
	
	public void probar(String valor) {
		//System.out.println(valor.contains("mito"));
		//Si el parametro valor viene null, se cacha de forma tradiciopnal
		try {
			Optional op = Optional.empty();
			op.get();
		}catch (Exception e) {
			System.out.println("No hay Elemento");
		}
	}	
	
	public void orElse(String valor) {
		//Si el parametro valor acepta null (Optional.ofNullable(valor)), se muestra un mensaje predeterminado con op.orElse("Predeterminado")
		Optional<String> op = Optional.ofNullable(valor);
		String x = op.orElse("Predeterminado");
		System.out.println(x);
	}
	
	public void orElseThrow(String valor) {
		//Si el parametro valor acepta null (Optional.ofNullable(valor)), se arrojara un excepcion op.orElseThrow(NumberFormatException::new);
		Optional<String> op = Optional.ofNullable(valor);
		op.orElseThrow(NumberFormatException::new);
	}
	
	public void isPresent(String valor) {
		//Verficar si el valor fue inicializado o no (null)
		//Si esta iniciado es true en caso contrario (null) es false
		Optional<String> op = Optional.ofNullable(valor);
		System.out.println(op.isPresent());
		
	}
	
	public static void main(String[] args) {
		OptionalApp app = new OptionalApp();
		//app.probar("Mito");
		//app.orElse("Mito");
		//app.orElseThrow("Mito");
		app.isPresent("Mito");
	}

}
