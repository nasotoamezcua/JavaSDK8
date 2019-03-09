package com.soto.java8.dateapi;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

public class DateApi {
	
	public void verificar(int version) {
		if(version == 7) {
			Calendar fecha1 = Calendar.getInstance();
			Calendar fecha2 = Calendar.getInstance();
			fecha1.set(1984, 5, 5);
			System.out.println(fecha1.after(fecha2));
		}else if(version == 8) {
			//Fechas
			LocalDate fecha1 = LocalDate.of(1984, 6, 5);
			LocalDate fecha2 = LocalDate.now();
			System.out.println(fecha1.isAfter(fecha2));
			System.out.println(fecha1.isBefore(fecha2));
			
			//Tiempo
			LocalTime tiempo1 = LocalTime.of(22, 30, 50);
			LocalTime tiempo2 = LocalTime.now();
			System.out.println(tiempo1.isAfter(tiempo2));
			System.out.println(tiempo1.isBefore(tiempo2));
			
			//Fecha y Tiempo
			LocalDateTime fechaTiempo1 = LocalDateTime.of(1984, 6, 5, 22, 30, 50);
			LocalDateTime fechaTiempo2 = LocalDateTime.now();
			System.out.println(fechaTiempo1.isAfter(fechaTiempo2));
			System.out.println(fechaTiempo1.isBefore(fechaTiempo2));
		}
	}
	
	//currentTimeMillis
	public void medirTiempo(int version) throws InterruptedException{
		if(version == 7) {
			long ini = System.currentTimeMillis();
			Thread.sleep(1000);
			long fin = System.currentTimeMillis();
			System.out.println(fin -  ini);
		}else if(version == 8) {
			Instant ini = Instant.now();
			Thread.sleep(1000);
			Instant fin = Instant.now();
			System.out.println(Duration.between(ini, fin).toMillis());
		}
	}
	
	public void periodoEntreFechas(int version) {
		if(version == 7) {
			Calendar nacimiento = Calendar.getInstance();
			Calendar actual = Calendar.getInstance();

			nacimiento.set(1984, 5, 5);
			actual.set(2019, 3, 7);
			
			int anios = 0;
			
			while(nacimiento.before(actual)) {
				nacimiento.add(Calendar.YEAR, 1);
				if(nacimiento.before(actual)) {
					anios++;
				}
			}
			
			System.out.println(anios);
			
		}else if(version == 8) {
			LocalDate nacimiento = LocalDate.of(1984, 6, 5);
			LocalDate actual = LocalDate.now();
			
			Period periodo =  Period.between(nacimiento, actual);
			System.out.println("Han transcurrido " + periodo.getYears() + " años y " + periodo.getMonths() + " meses " 
			+ periodo.getDays() + " dias, desde " + nacimiento + " hasta " + actual);
		}
	}
	
	public void convertir(int version) throws ParseException{
		if(version == 7) {
			// No es necesario agregar los ceros al dia y al mes
			String fecha = "5/6/1984 15:33:43";
			DateFormat formateador = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
			Date fechaConvertida = formateador.parse(fecha);
			System.out.println(fechaConvertida);
			
			/*Asignar una fecha en particular
			Calendar calendar = Calendar.getInstance();
			calendar.set(1984, 5, 5, 15, 33, 43);
			Date fechaDate = calendar.getTime();
			formateador = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss a");
			String fechaCadena = formateador.format(fechaDate);
			System.out.println(fechaCadena);
			*/
			
			//Obtener FechaActual
			Date fechaActual = Calendar.getInstance().getTime();
			formateador = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss a");
			String fechaCadena = formateador.format(fechaActual);
			System.out.println(fechaCadena);
			
		}else if(version == 8) {
			// Es necesario agregar los ceros al dia y al mes
			String fecha = "05/06/1984";
			DateTimeFormatter formateador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			LocalDate fechaLocal = LocalDate.parse(fecha, formateador);
			//Sin formato
			System.out.println(fechaLocal);
			//Con el formato
			System.out.println(formateador.format(fechaLocal));
		}
		
	}
	
	public static void main(String[] args) {
		DateApi app = new DateApi();
		try {
			//app.verificar(8);
			//app.medirTiempo(8);
			//app.periodoEntreFechas(8);
			//app.convertir(7);
			app.convertir(8);
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
