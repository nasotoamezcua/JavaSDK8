//Gracias a jjs (terminal o linea de comandos) poder levantar archivos JavaScript que contengan codigo enmbebido java

//Archivo JavaScript con codigo de java
//Ejecutar codigo JavaScript desde la terminal
//Se tiene que tener instalado nashorn, el cual viene incluido desde la version 1.8 de Java
//para ejecutar codigo JavaScript desde la terminal: jjs -v
//Ejemplo Ejecutando codigo desde la terminal:
//var x = 1;
//var y = 3;
//print(x+y);
//Imprime en la consola 4

//Tambien se puede ejecutar desde la consola, archivos .js que contengan codigo enmbebido java
//Lo unico que hay que hacer es ir a la rutra donde se encuentra el archivo .js y ejecutar lo siguiente:
//jjs nombre_archivo.js
//jjs java.js
var clase = Java.type('java.util.ArrayList');
var lista = new clase();
lista.add('MitoCode');
lista.add('Mito');
lista.add('Code');

print(lista.get(2));