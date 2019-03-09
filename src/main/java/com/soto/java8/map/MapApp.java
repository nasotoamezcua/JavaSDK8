package com.soto.java8.map;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class MapApp {
	
	private Map<Integer, String> map;
	
	public void poblar() {
		map = new HashMap<>();
		map.put(1, "Mito");
		map.put(2, "Code");
		map.put(3, "Suscribete");
		
		
	}
	
	public void imprimir_v7() {
		for(Entry<Integer, String> e: map.entrySet()) {
			System.out.println("LLave. " +  e.getKey() + " Valor: " + e.getValue());
		}
	}
	
	public void imprimir_v8() {
		//Forma 1 solo se puede utilizando lambda
		//map.forEach((k,v) -> System.out.println("LLave. " +  k + " Valor: " + v));
		
		//Forma 2 utilizando lambda
		//map.entrySet().stream().forEach((x) -> System.out.println(x));
		
		//Forma 2 utilizando metodo de referencia
		map.entrySet().stream().forEach(System.out::println);
	}
	
	public void recolectar() {
		
		//Extraer ciertos elementos del map y almacenarlos en un nuevo map
		Map<Integer, String> mapaRecolectado = map.entrySet().stream()
				.filter(e -> e.getValue().contains("N"))
				.collect(Collectors.toMap(p-> p.getKey(), p-> p.getValue()));
		
		mapaRecolectado.forEach((k,v) -> System.out.println("LLave. " +  k + " Valor: " + v));
		
	}
	
	public void insertarSiAusente() {
		//Este metodo agrega un elemento siempre y cuando su llave no exista en el map
		map.putIfAbsent(4, "Nestor Alejandro");
	}
	
	public void operarSiPresente() {
		//Si se encuentra la llave 3, realiza la operacion indicada
		map.computeIfPresent(3, (k,v) -> k + v);
		System.out.println(map.get(3));
	}
	
	public void obtenerOrPredeterminado() {
		//Si el la llave indicada no existe en el map se muestra un mensaje por defecto
		String valor = map.getOrDefault(5, "valor por defecto");
		System.out.println(valor);
	}
	
	
	
	public static void main(String[] args) {
		MapApp app = new MapApp();
		app.poblar();
		app.insertarSiAusente();
		//app.imprimir_v7();
		//app.imprimir_v8();
		//app.operarSiPresente();
		//app.obtenerOrPredeterminado();
		app.recolectar();
	}

}
