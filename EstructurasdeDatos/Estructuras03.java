package ImplementacionManual;
/* 
 * Estructuras03.java*/

/*03. Sistema de estacionamiento por pilas. */
import java.util.Scanner;

class Pila {
	int tope;
	String arreglo[];
	int capacidad;
	
	public Pila (int capacidad) {
		this.capacidad = capacidad;
		tope = -1;
		arreglo = new String[capacidad];
	}
	
	boolean estaVacia(){
		return(tope < 0);
		
	}
	
	boolean estaLlena() throws pilaLlenaException{
		if(tope >= (capacidad - 1)) {
			throw new pilaLlenaException("La pila esta llena. Cargue el progrma e intente de nuevo. ");
		}
		return false;
	}
	
	boolean apilar(String elemento) throws pilaLlenaException {
		if(estaLlena()) { System.out.println("La pila esta llena. ");
			return false;
		}
		
		else {
			arreglo[++tope] = elemento;
			System.out.println("'" + elemento + "' apilado exitosamente. ");
			return true;
		}
		
	}
	
	String desapilar() {
		if(estaVacia())return "La pila está vacia. ";
	
			String elemento = arreglo[tope--];
			return elemento;
		
	}
	
	String verCima() {
		if(estaVacia())return "La pila esta vacia.";
		
		String elemento = arreglo[tope];
		return elemento;
	}
	
	
	boolean mostrar() {
		if(estaVacia())return false;
		

		for ( int i = tope; i >= 0; i-- ) {
			
			System.out.println("-" + arreglo[i]);
			
		}
		return true;
		
	}
	
	void vaciar() {
	
		while(!estaVacia()) {
				desapilar();
		}
	}
	
}

class Estacionamiento extends Pila{

	public Estacionamiento(int capacidad) {
		super(capacidad);
	}
	
	Pila placa = new Pila(capacidad);
	Pila controlEntrada = new Pila(capacidad);
	
}

public class Estructuras03 {

	public static void main(String[] args) {
		
		//Variables y objetos.
		Estacionamiento registro = new Estacionamiento(100); //Por defecto en 100.
		
		Scanner entrada = new Scanner(System.in);
		int eleccion = 0;		
		String movimiento;
		int entradas = 0;
		int salidas = 0;
		
		System.out.println("GRUPO4//Estructuras03.java//UNEFA-NPC");
		System.out.println("===BIENVENIDO AL PROGRAMA===");
		
	try {
		while(eleccion != 4 ) {
		System.out.println("\n1. Realizar Movimiento.");
		System.out.println("2. Ver cima.");
		System.out.println("3. Mostrar vehiculos en el estacionamiento.");
		System.out.println("4. Finalizar dia. ");
		System.out.println("5. Salir. ");
		eleccion = entrada.nextInt();
		
		switch(eleccion) {
		
		//Movimiento
		case 1: 
		
			System.out.println("Introduzca el tipo de movimiento (E o S): ");
				
				movimiento = entrada.next();
				switch(movimiento.toUpperCase()) {
				
				//Caso entrada.
				case "E": 
					
					if(registro.controlEntrada.estaLlena()) {
						System.out.println("El estacionamiento está lleno! Retire un vehiculo en intente de nuevo. \n");
						break;
					}
					
					registro.controlEntrada.apilar("ENTRADA");
					System.out.println("Introduzca la placa del vehiculo: ");
					registro.placa.apilar(entrada.next());
					
					entradas += 1;
					
					break;
				
				//Caso salida.
				case "S": 
					
					registro.controlEntrada.apilar("SALIDA");
					System.out.println("Introduzca la placa del vehiculo: ");
					registro.placa.apilar(entrada.next());
					
					salidas += 1; 
					
					break;
					
				default: System.out.println("Dato invalido. Intente nuevamente. ");
				break;
				}
		break;
		
		//Ver Cima
		case 2: 
			
			if(registro.placa.estaVacia()) {
				System.out.println("La pila esta vacia. Introduzca algunos carros e intente de nuevo.");
				break;
	
			}
			System.out.println("-PLACA: " + registro.placa.verCima());
			System.out.println("-MOVIMIENTO: " + registro.controlEntrada.verCima());
			
			break; 
		
		//Mostrar todo
		case 3:
			
			System.out.println("==PLACAS==");
			registro.placa.mostrar();
			
			System.out.println("\n==CONTROL==");
			registro.controlEntrada.mostrar();
			
			break; 
		
			//Finalizar día
		case 4: 
			System.out.println("==PLACAS==");
			registro.placa.mostrar();
			
			System.out.println("\n==CONTROL==");
			registro.controlEntrada.mostrar();
			
			System.out.println("Salidas: " + salidas);
			System.out.println("Entradas: " + entradas);
			System.out.println("PROGRAMA FINALIZADO.");
		
			entrada.close();
			System.exit(0);
			
			
			//Salir
		case 5: 
			entrada.close();
			System.exit(0);
			
		default: 
			System.out.println("Dato invalido. Intente nuevamente.");
			
			break;
		}
		
		
		}
	}catch (Exception error) {
		System.out.println("Algo ocurrio en el programa: " + error);
		
		}
	}
}


class pilaLlenaException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8752531212456625284L;

	public pilaLlenaException(String error) {
			super(error);
	}

}




