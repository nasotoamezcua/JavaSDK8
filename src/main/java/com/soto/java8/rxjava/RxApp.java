package com.soto.java8.rxjava;

import java.util.ArrayList;
import java.util.List;

import rx.Observable;
import rx.functions.Action1;


public class RxApp {
	
	//RxJava: Permite el manejo de un procesamiento Asynchrono de manera muy lejible
	//Evitando el uso de future, collable, calback en java 7
	
	private List<Integer> lista1;
	private List<Integer> lista2;
	
	public RxApp() {
		lista1 = new ArrayList<>();
		lista2 = new ArrayList<>();
		this.llebarLista();
	}
	
	public void llebarLista() {
		for(int i=0; i<10000; i++) {
			lista1.add(i);
			lista2.add(i);
		}
	}
	
	public void buscar() {
		//Buscar solo numeros que empiecen con 1
		/*
		 * La desventaja de no hacer esto con la clsse Observable: Se tendria que hacer de manera secuencia:
		 * 1.- Recorrer la primer lista
		 * 2.- Hacer la funcion de buscar por 1
		 * 3.- Recorrer la segunda lista
		 * etc..
		 * Conla clase Observable: se hace manera Asynchrona
		 */
		
		
		Observable<Integer> obs1 = Observable.from(lista1);
		Observable<Integer> obs2 = Observable.from(lista2);
		
		/*
		Observable.merge(obs1, obs2).subscribe(new Action1<Integer>() {

			@Override
			public void call(Integer numero) {
				if(numero == 1) {
					System.out.println(numero);
				}
			}
		});
		*/
		
		//Observable.merge(obs1,obs2).filter(x-> x==1).subscribe(System.out::println);
		
		Observable.merge(obs1,obs2).filter(x-> x==1).subscribe(x->{
			if(x==1) {
				System.out.println(x);
			}
		});
	}
	
	public static void main(String[] args) {
		/*
		List<String> lista = new ArrayList<>();
		lista.add("Mito");
		lista.add("Code");
		lista.add("MitoCode");
		
		//Objeto que tiene que ser observado por Observes
		//Cuando suscribe a varios observadores los elementos o el contendio que exista en este observable va a notificar a cada uno de sus observadores
		Observable<String> obs = Observable.from(lista);
		obs.subscribe(new Action1<String>() {

			@Override
			public void call(String elemento) {
				System.out.println(elemento);
			}
		});
		*/
		
		RxApp app = new RxApp();
		app.buscar();
		
	}
	

}
