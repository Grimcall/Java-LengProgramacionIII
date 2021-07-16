/* UNEFA-NPC, LENGUAJE DE PROGRAMACIÓN III
 * ACTIVIDAD 10%, SEGUNDO CORTE, SEGUNDO EJERCICIO.
 * RECURSIVIDAD.
 * 26/04/2021
 * 
 * INTEGRANTES:
 * DIEGO PARRA, 26.671.334
 * KATHERINE GARCÍA, 26.696.857
 * GRUPO #4
 * 
 * PROFESORA: YELMIN PEREZ
 * 
 * 
 * Recursividad02.java*/

//02. Escribir una funcion recursiva que imprima
//una linea que contenga exactamente n astericos.
//n se da como entrada.

import java.util.Scanner;

public class Recursividad02 {

	int numero;
	private static Scanner miEntero;

	public static void main(String[] args) {
		
		
		//Decl variables y objetos.
		Recursividad02 miNumero = new Recursividad02();
		miEntero = new Scanner(System.in);
		
		System.out.println("==SEGUNDO EJERCICIO==");
		System.out.print("Introduzca el valor entero n para imprimir asteriscos: ");
		
	
		miNumero.numero = miEntero.nextInt();
				
		
		miNumero.imprimirAsteriscos(miNumero.numero);
		
		
	}
	
		//======================================
		//Funcion para imprimir asteriscos.
		//======================================
		 void imprimirAsteriscos(int n) {//init Imprimirastericos
		
		if(n > 0) {
			
		System.out.print("*");
		imprimirAsteriscos(--n);
			
		}else {
			return;
		}
		
	}//fin imprimirAsteriscos

}