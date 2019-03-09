package com.soto.java8.highorder;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class HighApp {
	
	private Function<String, String> covertirMayusculas = x -> x.toUpperCase();
	private Function<String, String> covertirMinusculas = x -> x.toLowerCase();
	
	public void imprimir(Function<String, String> funcion, String valor) {
		System.out.println(funcion.apply(valor));
	}
	
	public Function<String, String> mostrar(String mensaje){
		return (String x) -> mensaje + x;
	}
	
	public void filtrar(List<String> lista, Consumer<String> consumidor, int longitud, String cadena) {
		//lista.stream().filter(establecerLogicaFiltro(longitud)).forEach(consumidor);
		lista.stream().filter(establecerLogicaFiltro(cadena)).forEach(consumidor);
		
	}
	
	public Predicate<String> establecerLogicaFiltro(int longitud){
		return texto -> texto.length() < longitud;
	}
	
	public Predicate<String> establecerLogicaFiltro(String cadena){
		return texto -> texto.contains(cadena);
	}
	
	
	public static void main(String[] args) {
		HighApp app = new HighApp();
		app.imprimir(app.covertirMayusculas, "mitocode");
		app.imprimir(app.covertirMinusculas, "Mitocode");
		
		String rpya =  app.mostrar("Hola ").apply("Nestor Alejandro");
		System.out.println(rpya);
		
		List<String> lista = new ArrayList<>();
		lista.add("Mito");
		lista.add("Code");
		lista.add("MitoCode");
		
		//app.filtrar(lista, System.out::println, 5, null);
		app.filtrar(lista, System.out::println, 0, "Code");
	}
	
	
	

}
