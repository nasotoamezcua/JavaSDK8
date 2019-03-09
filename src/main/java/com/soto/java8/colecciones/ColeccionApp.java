package com.soto.java8.colecciones;

import java.util.ArrayList;
import java.util.List;

public class ColeccionApp {
	
	private List<String> lista;
	
	public void llenarLista() {
		lista = new ArrayList<>();
		lista.add("MitoCode");
		lista.add("Mito");
		lista.add("Code");
	}
	
	public void usarForEach() {
		/*Java 7
		for(String elemento : lista) {
			System.out.println(elemento);
		}
		*/
		
		//java 8
		//lambda
		//lista.forEach((x) -> System.out.println(x));
		
		//Metodo a Referencias
		lista.forEach(System.out :: println);
	}
	
	public void usarRemoveIf() {
		/*Java 7
		Iterator<String> it = lista.iterator();
		while(it.hasNext()) {
			if(it.next().equalsIgnoreCase("Code")) {
				it.remove();
			}
		}
		*/
		lista.removeIf(x -> x.equalsIgnoreCase("Code"));
	}
	
	public void usarSort() {
		lista.sort((x,y) -> x.compareTo(y));
	}
	
	public static void main(String[] args) {
		ColeccionApp app = new ColeccionApp();
		app.llenarLista();
		app.usarSort();
		//app.usarRemoveIf();
		app.usarForEach();
	}
}
