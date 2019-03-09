package com.soto.java8.methodReference;

import java.util.Arrays;
import java.util.Comparator;

public class MeRefApp {
	
	/*Tipos de Metodos Referenciados:
	 *  Referencias de Metodos Static
	 *  Referencias de Metodos a un Objeto Abitrario
	 *  Referencias de Metodos a un Objeto Particular
	 *  Referencias a un Constructor
	 */
	
	//Siempre se tiene que utilizar una Interface Funcional (@FunctionalInterface)
	//Los metodos a Referencia no aceptan el paso de parametros
	
	public static void referenciaMetodoStatic() {
		System.out.println("Metodo Referido a static");
	}
	
	public void referenciaMetodoIntanciaObjetoArbitrario() {
		String[] nombres = {"Mito","Code","Nestor"};
		
		/*Tradicional Java7
		Arrays.sort(nombres, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return o1.compareToIgnoreCase(o2);
			}
		});
		*/
		
		//Expresion Lambda
		//Arrays.sort(nombres, (o1, o2) -> o1.compareToIgnoreCase(o2));
		//System.out.println(Arrays.toString(nombres));
		
		//Referencias a Metodo
		Arrays.sort(nombres, String::compareToIgnoreCase);
		System.out.println(Arrays.toString(nombres));
	}
	
	public void referenciarMetodoIntanciaObjetoParticular() {
		System.out.println("Metodo Referido Instancia de Objeto Particular");
	}
	
	public void referenciarConstructor() {
		/*Tradicional Java7
		IPersona iper = new IPersona() {
			
			@Override
			public Persona crear(int id, String nombre) {
				return new Persona(id, nombre);
			}
		};
		*/
		//Expresion Lambda
		//IPersona iper2 = (x,y) -> (new Persona(x, y));
		//Persona p = iper2.crear(1, "Nestor Alejandro");
		//System.out.println(p.getId() + " - " +  p.getNombre());
		
		//Referencias a Metodo
		IPersona iper3 = Persona:: new;
		Persona per =  iper3.crear(1, "Nestor Alejandro");
		System.out.println(per.getId() + " - " +  per.getNombre());
	}
	
	public void operar() {
		
		//Expresion Lambda
		//SaludarInterface saludarIF = () -> MeRefApp.referenciaMetodoStatic();
		//saludarIF.saludar();
		
		//Referencias a Metodo
		SaludarInterface saludarIF2 = MeRefApp::referenciaMetodoStatic;
		saludarIF2.saludar();
	}
	
	public static void main(String[] args) {
		MeRefApp app = new MeRefApp();
		//app.operar();
		//app.referenciaMetodoIntanciaObjetoArbitrario();
		//SaludarInterface s = app::referenciarMetodoIntanciaObjetoParticular;
		//s.saludar();
		app.referenciarConstructor();
	}

}
