package com.soto.java8.finterface;

public class FuncInterApp {
	
	public double operar(double x, double y) {
		OperacionFuncional opFuncional = (n1,n2) -> n1 + n2;
		return opFuncional.calcular(x, y);
	}
	
	public static void main(String[] args) {
		FuncInterApp app = new FuncInterApp();
		System.out.println(app.operar(2, 3));
	}
}
