/* UNEFA-NPC, LENGUAJE DE PROGRAMACIÓN III
 * ACTIVIDAD 10%, SEGUNDO CORTE, QUINTO EJERCICIO-B.
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
 * Recursividad05b.java*/

//05b. Determinar todos los numeros primos circulares de cinco dígitos.

import java.util.Scanner;

public class Recursividad05b {


	//Atributos
	int numero;
	int cantidadDigitos;	
	private static Scanner miEntero;

	public static void main(String[] args) {
		
		//Atributos y objetos.
		Recursividad05b miNumero = new Recursividad05b();
		miEntero = new Scanner(System.in);
		int eleccion = 0;
		int auxiliar;
		
				
		System.out.println("==QUINTO EJERCICIO B==\nIntroduzca una opción: \n");
		
	while (eleccion != 4) {//init While 	
		System.out.println("-1. (ENUNCIADO) Iterar busqueda de primos para cinco digitos.");
		System.out.println("-2. Establecer cantidad de digitos manualmente. (max. 6)");
		System.out.println("-3. Revisar si un numero en particular es primo circular.");
		System.out.println("-4. Salir.\n");
		System.out.print("ELECCION: ");
		
		eleccion = miEntero.nextInt();
		
		switch(eleccion) {//init Switch
		case 1: 
				auxiliar = 5;
				miNumero.iniciarProceso(auxiliar); break;
		
		case 2: System.out.print("Establezca el cantidad de digitos: ");
				auxiliar = Math.abs(miEntero.nextInt());
				
				if(auxiliar > 6) {
					System.out.println("Digito introducido es mayor al limite. Intente de nuevo.");
					break;
				}
				miNumero.iniciarProceso(auxiliar);
				break;
				
		case 3: 
				System.out.print("Introduzca el numero a verificar: ");
				auxiliar = miEntero.nextInt();
				
				if(miNumero.esCircular(auxiliar))System.out.println(auxiliar + " es Primo circular.\n");
				else System.out.println(auxiliar + " no es Primo circular.");
				break;				
		
		case 4: System.exit(0);
		
		}//fin Switch
		
	} //fin While
	
}//fin Main 
	
	
	//==============================================
	//Verificar si el numero es primo con recursión.
	//==============================================
		 boolean esPrimo(long num, long div){
			if(num <= 2)return (num == 2) ? true : false;
			if(num % div == 0)return false;
			if(div*div > num)return true;
			
				
				return esPrimo(num, div+1);
			
		}
		
		//=========================================
		//Verificar si el numero es circular.
		//========================================= 
		 boolean esCircular(long numero) {
			 this.numero = (int) numero;	
			 long aux = numero; 
			 	
			 cantidadDigitos = contarDigitos(aux);
			   aux = numero;
			  
			  while(esPrimo(aux, 2)) {
				  int eliminado = (int) (aux % 10);
				  int divisor = (int) (aux / 10);
				  
				  aux = (long) (((Math.pow(10, cantidadDigitos-1))* eliminado) + divisor);
				  
				  if(aux == numero)return true;
				  
			  }
			  return false;
		}
		
		
		//============================
		//Contar Digitos del numero.
		//============================
		int contarDigitos(long numero) {
	
		if(numero > -10 && numero < 10) {
			return 1;
		}else return contarDigitos(numero/10)+1;
		
	}	
		//============================
		//Iniciar proceso de impresion
		//============================
		 void iniciarProceso(int cantidadDigitos) {
			 
			 	//Decl. variables.
				numero = (int) (cantidadDigitos*Math.pow(10, cantidadDigitos-1)/cantidadDigitos);
				int limiteSuperior = (int) ((cantidadDigitos*Math.pow(10, cantidadDigitos)/cantidadDigitos)-1);
								
				while(numero <= limiteSuperior) {
				
				if(esCircular(numero))System.out.println(numero);					
					numero++;
					
			}
		}
		 
		
		
	}
		
		
	
	
