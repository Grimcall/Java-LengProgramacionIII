/* UNEFA-NPC, LENGUAJE DE PROGRAMACI�N III
 * ACTIVIDAD 10%, SEGUNDO CORTE, CUARTO EJERCICIO.
 * RECURSIVIDAD.
 * 26/04/2021
 * 
 * INTEGRANTES:
 * DIEGO PARRA, 26.671.334
 * KATHERINE GARC�A, 26.696.857
 * GRUPO #4
 * 
 * PROFESORA: YELMIN PEREZ
 * 
 * 
 * Recursividad04.java*/

//04. Encontrar el MCD entre dos numeros usando la
//definici�n matem�tica en la gu�a.

import java.util.Scanner;

public class Recursividad04 {

	int enteroX, enteroY;
	private static Scanner miEntero;

	public static void main(String[] args) {
		
		//Decl. atributos y objetos.
		Recursividad04 miNumero = new Recursividad04();
		miEntero = new Scanner(System.in);
		
		System.out.println("==CUARTO EJERCICIO==");
	
		System.out.print("Introduzca el entero correspondiente a X: ");
		miNumero.enteroX = miEntero.nextInt();
		
		System.out.print("Introduzca el entero correspondiente a Y: ");
		miNumero.enteroY = miEntero.nextInt();
		
		System.out.println("El MCD de " + miNumero.enteroX + " y " + miNumero.enteroY + " es " + miNumero.buscarMCD(miNumero.enteroX, miNumero.enteroY) + ".");
		
		
	}
		
	//==============================================
	//Proceso para revisar MCD.
	//==============================================
			int buscarMCD(int x, int y) {
									
			//Cond  4
			if(y == 0) return x;
			//Cond 3
			if(x == 0) return y;
			
			//Cond 1
			if(x >= y)return buscarMCD(x-y, y);
			//Cond 2
			return buscarMCD(x, y-x);
			
		
	}

}

