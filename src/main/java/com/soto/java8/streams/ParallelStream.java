package com.soto.java8.streams;

import java.util.ArrayList;
import java.util.List;

public class ParallelStream {
	
	private List<Integer> numeros;
	
	public void llenar() {
		numeros = new ArrayList<>();
		for(int i=0; i<10; i++) {
			numeros.add(i);
		}
	}
	
	public void probarStream() {
		numeros.stream().forEach(System.out:: println);
	}
	
	public void probarParalelo() {
		//Puede mejorar el rendimiento en algunas aplicaciones
		//Abuzar de este metodo no es tan recomendable si se trabaja en aplicaciones con Contenedores JEE (JEE Container --> EJB y JPA)
		//Se poya en un ForkJoinPool es decir en un pool de hilos
		// Se recomienda utilizar en procesos de tipo batch o aplicaciones de escritorio
		
		numeros.parallelStream().forEach(System.out:: println);
	}
	
	public static void main(String[] args) {
		ParallelStream app = new ParallelStream();
		app.llenar();
		//app.probarStream();
		app.probarParalelo();
	}

}
