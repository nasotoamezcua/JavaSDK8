package com.soto.java8.lambda;

public class ScopesLambda {
	
	private static double atributo1;
	private double atributo2;
	
	public double probarLocalVariable() {
		double n3 = 3;
		Operacion op = new Operacion() {
			
			@Override
			public double calcularPromedio(double n1, double n2) {
				//Para tratar de asignar un valor a una variable local, esta tiene que ser declarada como final
				// Pero por al ser declarada final la variable no se le puede asignar un valor
				//n3 = n1 +n2;
				
				
				//Como conclusion: Una variable local (el identificador fianl es opcional ya que esta se comporta como final de forma implicita) 
				//solo podra utilizarce, mas no alterar su valor
				return n1 +n2 + n3;
			}
		};
		
		Operacion operacion = (x,y) -> {
			//Para tratar de asignar un valor a una variable local, esta tiene que ser declarada como final
			// Pero por al ser declarada final la variable no se le puede asignar un valor
			//n3 = x + y;
			
			//Como conclusion: Una variable local (el identificador fianl es opcional ya que esta se comporta como final de forma implicita) 
			//solo podra utilizarce, mas no alterar su valor
			return x + y + n3;
		};
		
		return operacion.calcularPromedio(1, 1);
	}
	
	
	public double probarAtributosStaticVariables() {
		
		//Con variables globales (de clase) static y no static , 
		//se puede realizar la lectura y escritura, 
		//tanto para clases anonimas como para lambdas
		
		Operacion op = new Operacion() {

			@Override
			public double calcularPromedio(double n1, double n2) {
				atributo1 = n1 + n2;
				atributo2 = atributo1;
				return atributo2 ;
			}
		};
		
		Operacion operacion = (x,y) -> {
			atributo1 = x + y;
			atributo2 = atributo1;
			return atributo2 ;
		};
		
		return operacion.calcularPromedio(3, 2);
		
	}
	
	public static void main(String[] args) {
		ScopesLambda app = new ScopesLambda();
		//System.out.println(app.probarLocalVariable());
		System.out.println(app.probarAtributosStaticVariables());
	}

}
