/* UNEFA-NPC, LENGUAJE DE PROGRAMACIÓN III
 * ACTIVIDAD 10%, SEGUNDO CORTE, PRIMER EJERCICIO.
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
 * Recursividad01.java*/

//01. Escribir una funcion con recursión para imprimir
//los numeros desde n hasta 0. n es un entero positivo
//que se obtiene como entrada.

import java.util.Scanner;

public class Recursividad01 {

	int numero;
	private static Scanner miEntero;

	public static void main(String[] args) {
		
		
		//Decl variables y objetos.
		Recursividad01 miNumero = new Recursividad01();
		miEntero = new Scanner(System.in);
		
		System.out.println("==PRIMER EJERCICIO==");
		System.out.print("Introduzca el valor entero n para imprimir de n a 0: ");
		
		miNumero.numero = miEntero.nextInt();
				
		
		miNumero.imprimirNumeros(miNumero.numero);
		
		
	}
	
		//======================================
		//Funcion para imprimir numeros de n a 0.
		//======================================
		void imprimirNumeros(int n) {//init imprimirNumeros
		
		if(n > 0) {
		System.out.println(n);
		imprimirNumeros(--n);
			
		}else {
			System.out.println(n);
			return;
		}
		
	}//fin imprimirNumeros

}
