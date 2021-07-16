/* 
 * Recursividad03.java*/

//03. Escribir una funcion recursiva que acepte
//un entero positivo como parámetro y devuelva un entero con dos
//ocurrencias de cada dígito, como salida invirtiendo el 
//número a mostrar. Si por ejemplo, el número 123 es dado como entrada,
//la salida debe ser 332211.

import java.util.Scanner;

public class Recursividad03 {

	int numero;
	long numeroAlReves;
	private static Scanner miEntero;

	public static void main(String[] args) {
		
		//Decl. variables y objetos.
		Recursividad03 miNumero = new Recursividad03();
		miEntero = new Scanner(System.in);
		
		System.out.println("==TERCER EJERCICIO==");
		System.out.print("Introduzca el entero positivo para imprimir al revés: ");
		
		
		miNumero.numero = miEntero.nextInt();
				
		
		System.out.println("NUMERO: " + miNumero.imprimirAlReves(miNumero.numero, miNumero.numeroAlReves));
		
		
	}
	
	//==============================================
	//Imprimir objeto al revés.
	//==============================================	
		 long imprimirAlReves(int n, long aux) {//init imprimirAlReves
			int digito;
						
		if(n > 0) {
			
		digito = n%10;
		aux += (digito*10)+digito;
		n /= 10;
		
		return imprimirAlReves(n, aux*100);
		
			
		}else {
			return aux/100;
		}
		
	}//fin imprimirAlReves

}

