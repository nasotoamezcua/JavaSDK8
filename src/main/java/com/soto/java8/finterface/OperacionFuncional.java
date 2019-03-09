package com.soto.java8.finterface;

@FunctionalInterface
public interface OperacionFuncional {
	
	//Una interface funcional es aquella que solo puede definir un unico metodo
	// Y se indica con la notacion @FunctionalInterface
	
	double calcular(double n1, double n2);

}
