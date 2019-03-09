package com.soto.java8.streams;

import java.util.ArrayList;
import java.util.List;

public class StreamApp {
	
	private List<String> lista;
	private List<String> numeros;
	
	public StreamApp() {
		lista = new ArrayList<>();
		lista.add("Mito");
		lista.add("Code");
		lista.add("Nestor");
		lista.add("MitoCode");
		
		numeros = new ArrayList<>();
		numeros.add("1");
		numeros.add("2");
	}
	
	public void filtrar() {
		//Referencia a Metodo
		lista.stream().filter(x -> x.startsWith("M")).forEach(System.out::println);
		//lambda
		//lista.stream().filter(x -> x.startsWith("M")).forEach((x) -> System.out.println(x));
	}
	
	public void ordenar() {
		//Ascendente
		//Referencia a Metodo
		//lista.stream().sorted().forEach(System.out:: println);
		//lambda
		//lista.stream().sorted().forEach((x) -> System.out.println(x));
		
		//Descendente
		//Referencia a Metodo
		lista.stream().sorted((x,y) -> y.compareTo(x)).forEach(System.out:: println);
		//lambda
		//lista.stream().sorted((x,y) -> y.compareTo(x)).forEach((x) -> System.out.println(x));
	}
	
	public void transformar() {
		//El metodo map es para transformar los elementos de la coleccion uno a uno a trvez de la expresion que se indique como parametro
		//Referencia a Metodo
		//lista.stream().map(String::toUpperCase).forEach(System.out::println);
		//lambda
		//lista.stream().map((x) -> x.toUpperCase()).forEach((x) -> System.out.println(x));
		
		//Covertir el arreglo de numeros String a Integer
		/*
		 * JAVA 7
		for(String x : numeros) {
			int num = Integer.parseInt(x) + 1;
			System.out.println(num);
		}
		 */
		
		numeros.stream().map((x) -> Integer.parseInt(x) + 1).forEach(System.out:: println);
	}
	
	public void limitar() {
		lista.stream().limit(2).forEach(System.out::println);
	}
	
	public void contar() {
		long x = lista.stream().count();
		System.out.println(x);
	}
	
	
	public static void main(String[] args) {
		StreamApp app = new StreamApp();
		//app.filtrar();
		//app.ordenar();
		//app.transformar();
		//app.limitar();
		app.contar();
	}

}
