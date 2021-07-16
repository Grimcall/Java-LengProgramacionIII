/* UNEFA-NPC, LENGUAJE DE PROGRAMACIÓN III
 * ACTIVIDAD 15%, SEGUNDO CORTE, SEGUNDO EJERCICIO.
 * EXCEPCIONES.
 * 14/05/2021
 * 
 * INTEGRANTES:
 * DIEGO PARRA, 26.671.334
 * KATHERINE GARCÍA, 26.696.857
 * GRUPO #4
 * 
 * PROFESORA: YELMIN PEREZ
 * 
 * 
 * Excepciones02.java*/

/*02.	Escribir un programa llamada Calculadora que realice las funciones típicas de una calculadora. 
 * Para ello pedirá al usuario tres valores: operación (+,-,*,/), operando1, operando2 y a partir de ellos muestre el resultado de la operación. 
 * Cuando el usuario introduzca una Z como valor de la operación el programa parará, si se introduce 
 * cualquier otro carácter se debe producir una excepción definida por el usuario imprimiendo un mensaje de error. 
 * Se deberán intentar utilizar todos los mecanismos de tratamiento de excepciones dados en teoría.
*/
import java.util.Scanner;

public class Excepciones02 {

	//Atributos
	private double operando1, operando2;
		
	public static void main(String[] args) {
	
		//Declaraciones.
		Excepciones02 miNumero = new Excepciones02();
		Scanner entrada = new Scanner(System.in);
		
		
		System.out.println("GRUPO4//Excepciones02.java//UNEFA-NPC\n\n");
		System.out.println("===BIENVENIDO AL PROGRAMA===");
		try{ 
			
			Excepciones02.mostrarMenu(entrada, miNumero);
			
		}//fin try
		catch (java.util.InputMismatchException error) 
		{
			System.out.println("\nCaracter equivocado. Revise su sentencia o separador decimal. \nError: " + error);
		}
		catch (Exception error) 
			{ 
				System.out.println("\nAlgo ocurrio en el programa:\nError:  " + error);
			}
		
		finally {
			entrada.close();
			System.out.println("PROGRAMA TERMINADO.");
		}
		
	}

	//========================================
	//FUNCIONES DE CALCULADORA
	//========================================
	double sumar(double operando1, double operando2) 
	{
		return(operando1 + operando2);
	}
	
	double restar(double operando1, double operando2)
	{
		return(operando1 - operando2);
	}
		
	double dividir(double operando1, double operando2) 
	{
		return(operando1/operando2);
	}
	
	double multiplicar(double operando1, double operando2)
	{
		return(operando1*operando2);
	}
	
	//========================================
	//GETTERS y SETTERS
	//========================================
	public double getOperando1()
	{
		return operando1;
	}
	
	public double getOperando2()
	{
		return operando2;
	}
	
	void setOperando1(double o1) 
	{
		this.operando1 = o1;
	}
	
	void setOperando2(double o2)
	{
		this.operando2 = o2;
	}
	
	//====================================
	//EVITAR REDUNDANCIA
	//====================================
	public static void mostrarMenu(Scanner entrada, Excepciones02 miNumero) throws Exception 
	{
	
		System.out.println("Introduzca una de las siguientes opciones: ");
		System.out.println("1. Sumar\n2. Restar\n3. Dividir\n4. Multiplicar\n5. Salir");
		System.out.print("Eleccion: ");
		
		switch(entrada.nextInt()) 
		{
	case 1: miNumero.entradaDeDatos(entrada, miNumero);
			
			System.out.println("El resultado es: " + miNumero.sumar(miNumero.getOperando1(), miNumero.getOperando2()));
			break;
			
	case 2: miNumero.entradaDeDatos(entrada, miNumero);
	
			System.out.println("El resultado es: " + miNumero.restar(miNumero.getOperando1(), miNumero.getOperando2()));
	        break; 
	        
	case 3: miNumero.entradaDeDatos(entrada, miNumero);

			System.out.println("El resultado es: " + miNumero.dividir(miNumero.getOperando1(), miNumero.getOperando2()));
			break; 
    
	case 4: miNumero.entradaDeDatos(entrada, miNumero);

			System.out.println("El resultado es: " + miNumero.multiplicar(miNumero.getOperando1(), miNumero.getOperando2()));
			break; 
			
	case 5: System.exit(0);
	        	        
	default: throw new Exception("El numero introducido esta fuera de los limites del programa.");
		}
		
	}	

	
	void entradaDeDatos(Scanner entrada, Excepciones02 miNumero) throws CaracterIntroducido
	{
		String aux1 ="";
		String aux2 = "";
		double o1 = 0;
		double o2 = 0;
		
		System.out.print("Introduzca el primer operando: ");
		aux1 = entrada.next();
		
		if(aux1.equalsIgnoreCase("Z"))System.exit(0);
		else if(esNumero(aux1) == true)o1 = Double.parseDouble(aux1);
		
		System.out.print("Introduzca el segundo operando: ");
		aux2 = entrada.next();
		
		if(aux2.equalsIgnoreCase("Z"))System.exit(0);
		else if(esNumero(aux2) == true)o2 = Double.parseDouble(aux2);
		
		miNumero.setOperando1(o1);
		miNumero.setOperando2(o2);
	}
	
	boolean esNumero(String impostor) throws CaracterIntroducido {
		
		try {  
		    Double.parseDouble(impostor);  
		    return true;
		  } catch(NumberFormatException error){ 
			  throw new CaracterIntroducido ("Introdujo un caracter que no es valido. Intente nuevamente. ");
		 
		  }
	}
	
}

class CaracterIntroducido extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2541105066632802781L;

	public CaracterIntroducido(String error) {
			super(error);
	}

}
