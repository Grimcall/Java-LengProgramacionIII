/* UNEFA-NPC, LENGUAJE DE PROGRAMACIÓN III
 * ACTIVIDAD 10%, SEGUNDO CORTE, QUINTO EJERCICIO-D.
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
 * Recursividad05d.java*/

//05d. Determinar los primeros numeros Narcisista n <= 10.

import java.util.Scanner;

public class Recursividad05d {
	
	//Atributos
	int numero;
	int cantidadDigitos;	
	private static Scanner miEntero;

	//Main
	public static void main(String[] args) {//init main.
		
		//Llamadas a atributos y objetos.
		Recursividad05d miNumero = new Recursividad05d(); 
		miEntero = new Scanner(System.in);
		int eleccion = 0;
		int auxiliar;		
				
		System.out.println("==QUINTO EJERCICIO D==\nIntroduzca una opción: \n");
		
	while (eleccion != 3) {//init while 	
		
		System.out.println("-1. (ENUNCIADO) Iterar busqueda de numeros narcisistas de cantidad de digitos N.");
		System.out.println("-2. Revisar si un numero en particular es narcisista.");
		System.out.println("-3. Salir.\n");
		System.out.print("ELECCION: ");
		
		eleccion = Math.abs(miEntero.nextInt());
		
		switch(eleccion) {//init switch
		case 1: 
			System.out.print("Introduzca la cantidad de digitos: ");
			auxiliar = Math.abs(miEntero.nextInt());
			miNumero.iniciarProceso(auxiliar); break;
					
		case 2: 
				System.out.print("Introduzca el numero a verificar: ");
				auxiliar = miEntero.nextInt();
				
				if(miNumero.esNarcisista(auxiliar)) System.out.println(auxiliar + " es narcisista.\n");
				else System.out.println(auxiliar + " no es narcisista.");
				break;				
		
		case 3: System.exit(0);
		
		} //fin switch
		
	}//fin while menú.
	
}//fin main.
	
	//==============================================
	//Verificar si un numero es Kaprekar.
	//==============================================
		boolean esNarcisista(int numero) {//init esNarcisista
		this.numero = numero;
		this.cantidadDigitos = contarDigitos(0);
		
		//Atributos
		int narcisista = 0;
					
		//Contar Digitos
		cantidadDigitos = contarDigitos(numero);
		int aux = numero;
			
		//Suma y operacion.		
		while(aux > 0) {//init while
				
				narcisista += Math.pow(aux % 10, cantidadDigitos);
				aux /= 10;
			}//fin while
		
			if(narcisista == numero)return true;
			return false;
	}//fin esNarcisista
		
		//==============================================
		//Contar Digitos del numero.
		//==============================================
		int contarDigitos(long numero) {
	
		if(numero > -10 && numero < 10) {
			return 1;
		}else return contarDigitos(numero/10)+1;
		
	}
	
		//==============================================
		//Iniciar proceso de impresion.
		//==============================================
	 void iniciarProceso(int cantidadDigitos) {
		 
		 	//Decl. variables.
			numero = (int) (cantidadDigitos*Math.pow(10, cantidadDigitos-1)/cantidadDigitos);
			int limiteSuperior = (int) ((cantidadDigitos*Math.pow(10, cantidadDigitos)/cantidadDigitos)-1);
			byte verificacion = 0;
			
			while(numero <= limiteSuperior) {
			
			if(esNarcisista(numero)) { 
				System.out.println(numero); verificacion = 1;
				}
				numero++;
				
		}if(verificacion == 0)System.out.println("No se encontraron numeros narcisistas de dígitos N:" + cantidadDigitos + "\n");
	}
}//fin clase Recursividad05c
	
	
		
