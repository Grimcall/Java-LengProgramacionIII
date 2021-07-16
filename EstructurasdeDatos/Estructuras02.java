package ImplementacionManual;
/* UNEFA-NPC, LENGUAJE DE PROGRAMACIÓN III
 * ACTIVIDAD 10%, TERCER CORTE, SEGUNDO EJERCICIO.
 * ESTRUCTURAS DE DATOS.
 * 04/06/2021
 * 
 * INTEGRANTES:
 * DIEGO PARRA, 26.671.334
 * KATHERINE GARCÍA, 26.696.857
 * GRUPO #4
 * 
 * PROFESORA: YELMIN PEREZ
 * 
 * 
 * Estructuras02.java*/

/*02. Sistema de estacionamiento por colas. */
import java.util.Scanner;

class Cola{
	int front, rear, size;
	int capacidad;
	String arreglo[];
	
	
	public Cola(int capacidad) {
		
		this.capacidad = capacidad;
		front = this.size = 0;
		rear = capacidad - 1;
		arreglo = new String[this.capacidad];
	}
	
	boolean estaLlena ( Cola cola) {
		return (cola.size == cola.capacidad);
	}
	
	boolean estaVacia (Cola cola){
		return (cola.size == 0); 
	}
	
	
	void encolar(String item) {
		if(estaLlena(this))return;
		this.rear = (this.rear + 1) % this.capacidad;
	
	
		this.arreglo[this.rear] = item;
		
		this.size = this.size + 1;
	}
	
	String desencolar() {
		if(estaVacia(this))return "La cola esta vacia.";
		
		String item = this.arreglo[this.front];
		this.front = (this.front + 1) % this.capacidad;
		
		this.size = this.size - 1;
		
		return item;
		
	}
	
	String retornarFrente() {
		if(estaVacia(this))return "La cola esta vacia";
		
		String item = this.arreglo[this.front];
		
		return item;
		
	}
	
	String retornarRear() {
		if(estaVacia(this))return "La cola esta vacia";
		
		String item = this.arreglo[this.rear];
		
		return item;
		
	}
	
	void mostrar() {
		if(estaVacia(this))return;
		
		for(int i = 0; i < this.size; i++) {
			System.out.println(arreglo[i]);
			
		}
		
	}
	
}

class registroEstacionamiento extends Cola{

	public registroEstacionamiento(int capacidad) {
		super(capacidad);
	}
	

	Cola placa = new Cola(capacidad);
	Cola modelo = new Cola(capacidad);
	Cola color = new Cola(capacidad);
	Cola horaEntrada = new Cola(capacidad);
	Cola nombre = new Cola(capacidad);
	Cola year = new Cola(capacidad);
	
}
public class Estructuras02 {
	
	
	public static void main(String[] args) {
		
		//Variables y objetos.
		registroEstacionamiento registro = new registroEstacionamiento(100);
		Scanner entrada = new Scanner(System.in);
		float horasTranscurridas, precioPorHora;
		float recaudado = 0;
		int eleccion = 0;
		int salidas = 0;
		int entradas = 0; 
		
		System.out.print("Introduzca el precio por hora: ");
		precioPorHora = entrada.nextFloat();
		
		
		while (eleccion != 4) {
		System.out.println("1. Encolar Carro");
		System.out.println("2. Desencolar Carro");
		System.out.println("3. Finalizra día.");
		System.out.println("4. Salir");
		eleccion = entrada.nextInt();
		
		switch(eleccion) {
		//Entrada
		case 1: 
			
			if(registro.placa.estaLlena(registro.placa)) {
				System.out.println("La cola se encuentra llena. Intente de nuevo. ");
				break;}
			
			System.out.print("Introduzca la placa del vehiculo: ");
			registro.placa.encolar(entrada.next());
			
			System.out.print("Introduzca el modelo del vehiculo: ");
			registro.modelo.encolar(entrada.next());
			
			System.out.print("Introduzca el color del vehiculo: ");
			registro.color.encolar(entrada.next());
			
			System.out.print("Introduzca la hora de entrada del vehiculo: ");
			registro.horaEntrada.encolar(entrada.next());
			
			System.out.print("Introduzca el nombre del dueño del vehiculo: ");
			registro.nombre.encolar(entrada.next());
			
			System.out.print("Introduzca el año del vehiculo: ");
			registro.year.encolar(entrada.next());
			
			System.out.println("ENCOLADO EXITOSAMENTE: ");
			System.out.println("-Placa: " + registro.placa.retornarRear());
			System.out.println("-Modelo: " + registro.modelo.retornarRear());
			System.out.println("-Color: " + registro.color.retornarRear());
			System.out.println("-Hora de entrada: " + registro.horaEntrada.retornarRear());
			System.out.println("-Dueño: " + registro.nombre.retornarRear());
			System.out.println("-Año: " + registro.year.retornarRear());
			entradas+=1;
			
			break;
		
		//Salidas
		case 2: 
			
			if(registro.placa.estaVacia(registro.placa)) {
				System.out.println("La cola se encuentra vacía. Intente de nuevo. ");
				break;}  
			
			System.out.print("Cuantas horas transcurridas? ");
			horasTranscurridas = entrada.nextFloat();
			
			System.out.println("DESENCOLADO EXITOSAMENTE: ");
			System.out.println("-Placa: " + registro.placa.desencolar());
			System.out.println("-Modelo: " + registro.modelo.desencolar());
			System.out.println("-Color: " + registro.color.desencolar());
			System.out.println("-Hora de entrada: " + registro.horaEntrada.desencolar());
			System.out.println("-Dueño: " + registro.nombre.desencolar());
			System.out.println("-Año: " + registro.year.desencolar());
			
		
			System.out.println("Debe pagar: $" + horasTranscurridas*precioPorHora);
			salidas+=1;
			recaudado += horasTranscurridas*precioPorHora;
			
			break;
		
		//Finalizar día.
		case 3: System.out.println("-Total recaudado: $" + recaudado);
				System.out.println("-Cantidad de salidas: " + salidas);
				System.out.println("-Cantidad de entradas: " + entradas);
				System.out.println("-Cantidad de carros restantes dentro del estacionamiento: " + (entradas-salidas));
				System.out.println("==PROGRAMA FINALIZADO==");
				entrada.close();
				System.exit(0);
				
		case 4: 
			entrada.close();
			System.exit(0);
		default: System.out.println("Dato incorrecto. Intente de nuevo. ");
		
			}
		}
	}
	


}
