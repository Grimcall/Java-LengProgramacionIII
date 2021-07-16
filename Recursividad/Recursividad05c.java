/* 
 * Recursividad05c.java*/

//05c. Determinar los primeros numeros KAPREKAR n <= 10.

import java.util.Scanner;

public class Recursividad05c {
	
	//Atributos
	int numero;
	int cantidadDigitos;	
	private static Scanner miEntero;

	//Main
	public static void main(String[] args) {
		
		//Llamadas a atributos y objetos.
		Recursividad05c miNumero = new Recursividad05c(); 
		miEntero = new Scanner(System.in);
		int eleccion = 0;
		int auxiliar;
		
				
		System.out.println("==QUINTO EJERCICIO C==\nIntroduzca una opción: \n");
		
	while (eleccion != 3) { 	
		System.out.println("-1. (ENUNCIADO) Iterar busqueda de numeros de Kaprekar n<=10.");
		System.out.println("-2. Revisar si un numero en particular es de KAPREKAR.");
		System.out.println("-3. Salir.\n");
		System.out.print("ELECCION: ");
		
		eleccion = miEntero.nextInt();
		
		switch(eleccion) {
		case 1: 
				auxiliar = 10;
				miNumero.iniciarProceso(auxiliar); break;
					
		case 2: 
				System.out.print("Introduzca el numero a verificar: ");
				auxiliar = miEntero.nextInt();
				
				if(miNumero.esKAPREKAR(auxiliar)) System.out.println(auxiliar + " es KAPREKAR.\n");
				else System.out.println(auxiliar + " no es KAPREKAR.");
				break;				
		
		case 3: System.exit(0);
		
		}
		
	}
	
}
	
	//==============================================
	//Verificar si un numero es Kaprekar.
	//==============================================
		boolean esKAPREKAR(int numero) {
		this.numero = numero;
		this.cantidadDigitos = contarDigitos(0);
		
		if(numero == 0)return false;
		
		//Variables
		long cuadrado;
		int kaprekar;
		int primeraMitad;
		int segundaMitad;

		//Valor de cuadrado.
		cuadrado = (long) Math.pow(numero, 2);
		
		if(cuadrado < 10) {
			kaprekar = (int) cuadrado;
			if(kaprekar == numero)return true;
		}
		
		//Cuenta numeros de cuadrado.
		cantidadDigitos = (int) contarDigitos(cuadrado);
		
		//Separar en mitades y sumar.		
		for( int i = cantidadDigitos-1; i > 0; i--) {
			
			primeraMitad = (int) (cuadrado / Math.pow(10, i));
			segundaMitad = (int) (cuadrado % Math.pow(10, i));
			
			if(primeraMitad == 0 || segundaMitad == 0)continue;
		
		kaprekar = primeraMitad + segundaMitad;
		
	
		if(kaprekar == numero)return true;}
		return false;
	}
		
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
	 void iniciarProceso(int iteraciones) {
			this.numero = 0;
			int contador = 0;
			
		while(contador < iteraciones) {
			
			if(esKAPREKAR(numero)) {
				System.out.println(numero);
				contador++; numero++;
			}else numero++;
		}
	}
	
}//fin clase Recursividad05c
	
	
		
	
