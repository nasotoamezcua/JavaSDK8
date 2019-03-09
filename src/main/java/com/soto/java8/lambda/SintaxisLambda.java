package com.soto.java8.lambda;

public class SintaxisLambda {
	
	
	public double probarSintaxis() {
		
		//Sintaxis Basica
		Operacion operacion = (double x, double y) -> (x+y) /2;
		
		//Se puede agregar llavez en una sola linea, hay que agregar el return
		//Operacion operacion = (double x, double y) -> {return (x+y) /2;};
		
		/*Se puede poner mas de una linea, hay que agregar {} y dentro agregar el contenido
		Operacion operacion = (double x, double y) -> {
			double a = 2.0;
			System.out.println(a);
			return (x+y) /2 + a;
			};
		
		Operacion operacion = ( x,  y) -> {
			double a = 2.0;
			System.out.println(a);
			return (x+y) /2 + a;
			};
		*/
		
		// Se puede omitir el tipo de parametro
		//Operacion operacion = (x, y) -> {return (x+y) /2;};
		
		//Ejemplo Sin parametros
		//Operacion operacion = () -> 2;
		
		/*
		Operacion operacion = () -> {
			int x = 2;
			int y = 3;
			return x+y;
		};
		
		return operacion.calcularPromedio();
		*/
		
		return operacion.calcularPromedio(2, 3);
	}
	
	public static void main(String[] args) {
		SintaxisLambda app = new SintaxisLambda();
		System.out.println(app.probarSintaxis());
	}

}
