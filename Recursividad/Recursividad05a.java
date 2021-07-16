/* UNEFA-NPC, LENGUAJE DE PROGRAMACIÓN III
 * ACTIVIDAD 10%, SEGUNDO CORTE, QUINTO EJERCICIO-A.
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
 * Recursividad05a.java*/

//05b. Determinar los primeros 4 numeros FACTORION

import java.util.Scanner;

public class Recursividad05a {
	
	
	//Atributos
	int numero;
	private static Scanner miEntero;

	public static void main(String[] args) {
		
		//Llamadas a atributos y objetos.
		Recursividad05a miNumero = new Recursividad05a();
		miEntero = new Scanner(System.in);
		int eleccion = 0;
		int auxiliar;
		
				
		System.out.println("==QUINTO EJERCICIO A==\nIntroduzca una opción: \n");
		
	while (eleccion != 3) { 	
		System.out.println("-1. (ENUNCIADO) Iterar busqueda de numeros FACTORION hasta 4.");
		System.out.println("-2. Revisar si un numero en particular es FACTORION.");
		System.out.println("-3. Salir.\n");
		System.out.print("ELECCION: ");
		
		eleccion = Math.abs(miEntero.nextInt());
		
		switch(eleccion) {
		case 1: 
				auxiliar = 4;
				miNumero.iniciarProceso(auxiliar); break;
		
						
		case 2: 
				System.out.print("Introduzca el numero a verificar: ");
				auxiliar = Math.abs(miEntero.nextInt());
				
				if(miNumero.esFACTORION(auxiliar))System.out.println(auxiliar + " es FACTORION.\n");
				else System.out.println(auxiliar + " no es FACTORION.");
				break;				
		
		case 3: System.exit(0);
		
		}
		
	}
	
}
	
	//==================================================
	//Revisar si el numero es factorial con recursión
	//==================================================
	 int factorial(int numero) {//INIT factorial
		
		//Recursión
		if(numero >= 1)return numero*factorial(numero-1);
		else return 1;
	} //FIN factorial
	 
	
	//===================================
	//Revisar si el numero es FACTORION.
	//===================================
	 boolean esFACTORION(int numero) {//init esFACTORION
		long factorion = 0;
		this.numero = numero;
		if(numero == 0)return false;
	
		
		factorion += sumarDigitos(numero);
		
		
		if(factorion == numero)return true;
		else return false;
	}//fin esFACTORION
	
	//========================================================================
	//Sumar dígitos para el cálculo final con recursión y llamada a funciones
	//========================================================================
	 int sumarDigitos(int numero) {//init sumarDigitos
		if (numero == 0)return 0;
		
		//Recursión
		return(factorial(numero % 10) + sumarDigitos(numero / 10));
		
	}//fin sumarDigitos
	
	//=================================
	//Iniciar el proceso de impresión.
	//=================================
	void iniciarProceso(int iteraciones) {
				this.numero = 0;
				int contador = 0;

			while(contador < iteraciones) {
				
				if(esFACTORION(numero)) {
					System.out.println(numero);
					contador++; numero++;
				}else numero++;
			}
		
	}
	
}//fin clase Recursividad05a
	
	
		
	