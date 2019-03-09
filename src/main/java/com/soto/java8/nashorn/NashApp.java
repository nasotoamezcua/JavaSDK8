package com.soto.java8.nashorn;

import java.io.FileReader;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

public class NashApp {
	
	//Ejecutar codigo JavaScript desde Java gracias a nashorn
	
	private ScriptEngineManager m;
	private ScriptEngine e;
	
	//Para invocar funciones javaScript
	private Invocable invocador;
	
	public NashApp() {
		m = new ScriptEngineManager();
		//Indicar referencia al motor nashorn de JavaScript
		e = m.getEngineByName("nashorn");
		invocador = (Invocable) e;
		
	}
	
	public void llamarFunciones() throws Exception{
		//No se puede hacer sintaxis para manipulacion de DOM y alert
		//Solo se podra hacer codigo puro de javaScript
		//e.eval("print('Js desde java')");
		
		//Para hacer referencia a un archivo .js
		e.eval(new FileReader("src/main/java/com/soto/java8/nashorn/archivo.js"));
		
		//Para invocar funciones desde un archio .js
		String rpta1 = (String) invocador.invokeFunction("calcular", "2","3");
		System.out.println(rpta1);
		
		double rpta2 = (double) invocador.invokeFunction("calcular",2,3);
		System.out.println(rpta2);
	}
	
	public void implementarInterfaz() throws Exception{
		e.eval(new FileReader("src/main/java/com/soto/java8/nashorn/archivo.js"));
		
		
		//implementacion para una interface Runnable de JavaScript
		
		//Invocar a la variable de JavaScript que ejecuta una funcion de un hilo
		Object implementacion = e.get("hiloImpl");
		
		//Referenciamos la implementacion y al tipo de clase, que va hacer de tipo Runnable.class
		Runnable r = invocador.getInterface(implementacion, Runnable.class);
		
		Thread th1 = new Thread(r);
		th1.start();
		
		Thread th2 = new Thread(r);
		th2.start();
		
	}
	
	public static void main(String[] args) throws Exception{
		NashApp app = new NashApp();
		//app.llamarFunciones();
		app.implementarInterfaz();
	}

}
