/*
 * 
 * Excepciones01.java*/

/*01.	Escribir un programa que permita calcular la media de unas calificaciones de examen,
     contemplando todos sus posibles errores en tiempo de ejecución */

import java.util.Scanner;

public class Excepciones01 {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		
		int n;
		double nota;
		double media;
		double suma = 0;
		Scanner entrada = new Scanner(System.in);
	
		try{
											
			System.out.print("Indique la cantidad de notas: ");
			n = entrada.nextInt();
			
			if(n < 1)throw new ArithmeticException("Numero es menor o igual a cero."); 
				
			
			System.out.println("Escriba las notas: ");
			for(int i = 0; i < n; i++)
				{//init ciclo 'for'
				
				nota = entrada.nextDouble(); 
				suma += nota;
				}//fin ciclo 'for'.
			
			//Cerrar scanner.
			entrada.close();
			
			media = suma / n;
		
		
			System.out.print("El promedio de notas es: ");
			System.out.println(media);
					
		}
		catch(java.util.InputMismatchException error) 
			{ 
			System.out.println("Introdujo un caracter erroneo. Revise su sentencia o separadores decimales e intente de nuevo.\nError: " + error);
			}
		catch( Exception error){
				System.out.println("Algo ocurrio en el programa.\nError:" + error);
		
    
	}

	}
}
