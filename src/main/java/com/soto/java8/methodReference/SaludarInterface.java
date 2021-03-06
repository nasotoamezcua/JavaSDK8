package com.soto.java8.methodReference;

@FunctionalInterface
public interface SaludarInterface {
	/*
	 * Las interfaces declaradas @FunctionalInterface solo admiten un metodo
	 * y pueden tambien admitir cualquier cantiodad de metodos declarados como default
	 */
	void saludar();
}
