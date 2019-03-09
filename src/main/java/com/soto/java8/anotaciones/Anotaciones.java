package com.soto.java8.anotaciones;

import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class Anotaciones {
	//El scope por default es class,
	//Hay que indicar el scope RUNTIME de la siguiente forma: @Retention(RetentionPolicy.RUNTIME)
	@Retention(RetentionPolicy.RUNTIME)
	public @interface Lenguajes{
		Lenguaje[] value() default{};
	}
	
	//Para indciar a la JVM que se tienen que leer las anotaciones repetidas: @Repeatable
	//Dentro de la notacion @Repeatable Indicar la notacion que se repetira: @Repeatable(value = Lenguajes.class)
	@Repeatable(value = Lenguajes.class)
	public @interface Lenguaje{
		String value();
	}
	
	//En las versiones Java 1.7 y 1.8:
	//Es necesario indicar la anotacion @Repeatable para en la anotacion que se va a repetir la informacion, en este caso Lenguaje.
	//En caso contrario se muestra error de compilacion.
	//1.7
	/*
	@Lenguajes({
		@Lenguaje("Java"),
		@Lenguaje("Python")
	})*/
	//1.8
	
	@Lenguaje("Java")
	@Lenguaje("Python")
	public interface LengaujeProgramacion{
		
	}
	
	public static void main(String[] args) {
		Lenguaje[] lengujeArray = LengaujeProgramacion.class.getAnnotationsByType(Lenguaje.class);
		System.out.println("Se tienen " + lengujeArray.length + " Anotaciones en lenguaje");
		Lenguajes len = LengaujeProgramacion.class.getAnnotation(Lenguajes.class);
		for(Lenguaje elemento : len.value()) {
			System.out.println(elemento.value());
		}
		
	}

}
