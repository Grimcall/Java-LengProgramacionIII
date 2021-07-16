/* UNEFA-NPC, LENGUAJE DE PROGRAMACIÓN III
 * ACTIVIDAD 15%, SEGUNDO CORTE, QUINTO EJERCICIO.
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
 * Excepciones05.java*/

/*Sistema bancario básico. */
import java.util.Scanner;



public class Excepciones05 {
	

	public static void main(String[] args) {
		
		//Objetos.
		CuentaCorriente miCC = new CuentaCorriente();
		CuentaAhorros miCA = new CuentaAhorros();
		Scanner entradaMain;
		int aux = 0;
		System.out.println("GRUPO4//Excepciones05.java//UNEFA-NPC\n\n");
		System.out.println("===BIENVENIDO AL PROGRAMA===");
	
		try{
			while(aux != 4) {
			entradaMain = new Scanner(System.in);
			System.out.println("\n-0. Resumen de cuentas.");
			System.out.println("-1. Abrir cuenta.");
			System.out.println("-2. Depositar en cuenta.");
			System.out.println("-3. Retirar de una cuenta.");
			System.out.println("-4. Salir");
			System.out.print("Eleccion: ");

			aux = entradaMain.nextInt();
			
			switch(aux) {
			case 0: 
				
				System.out.println("IDENTIDAD CC: " + miCC.getId());
				System.out.println("SALDO CC: $" + miCC.getSaldo());
				System.out.println("IDENTIDAD CA: " + miCA.getId());
				System.out.println("SALDO CA: $"  + miCA.getSaldo());
				break;
				
			//Caso REGISTRO.
			case 1:
				System.out.println("Que tipo de cuenta desea registrar?");
				System.out.println("-1. Corriente.");
				System.out.println("-2. Ahorros.");
				System.out.print("Eleccion: ");
				
				switch(entradaMain.nextInt()) {
					
					case 1: 
						if(miCC.getId() != 0) {
							System.out.println("Ya posee una cuenta registrada.");
							break;
						}
						
						System.out.print("Introduzca su cedula: ");
						miCC.setId(entradaMain.nextInt());
						break;
							
					case 2: 
						
						if(miCA.getId() != 0) {
							System.out.println("Ya posee una cuenta registrada.");
							break;
						}

						System.out.print("Introduzca su cedula: ");
						miCA.setId(entradaMain.nextInt());
						break;
						
					default: System.out.println("Operacion invalida."); break;

					}
				
				break;
				
			//Caso DEPOSITO
			case 2:
				System.out.println("En que tipo de cuenta desea depositar?");
				System.out.println("-1. Corriente.");
				System.out.println("-2. Ahorros.");
				
				switch(entradaMain.nextInt()) {
				
				case 1: 
					
					if(miCC.getId() == 0) {
						System.out.println("Registre una cuenta de este tipo para poder manejarla.");
						break;
					}				
					
					System.out.print("Introduzca el monto a depositar: ");
					miCC.depositar(entradaMain.nextFloat());
					break;
						
				case 2: 
				
					if(miCA.getId() == 0) {
						System.out.println("Registre una cuenta de este tipo para poder manejarla.");
						break;
					}		
					
					System.out.print("Introduzca el monto a depositar: ");
					miCA.depositar(entradaMain.nextFloat());
					
					break;
					
				default: System.out.println("Operacion invalida."); break;
				}
					
				break;
			
			//Caso RETIRAR.
			case 3:
			System.out.println("De cual cuenta desea retirar?");
			System.out.println("-1. Corriente.");
			System.out.println("-2. Ahorros.");
			
			switch(entradaMain.nextInt()) {
			
			case 1: 
				
				if(miCC.getId() == 0) {
					System.out.println("Registre una cuenta de este tipo para poder manejarla.");
					break;
					}			
				System.out.print("Introduzca el monto a retirar: ");
				miCC.retirar(entradaMain.nextFloat());
				break;
					
			case 2: 
				
				if(miCA.getId() == 0) {
					System.out.println("Registre una cuenta de este tipo para poder manejarla.");
					break;
				}	
			
				System.out.print("Introduzca el monto a retirar: ");
				miCA.retirar(entradaMain.nextFloat());
				break;
				
			default: System.out.println("Operacion invalida."); break;
			}
			break;
			
			//Caso SALIR
			case 4: entradaMain.close();  
			System.exit(0); 
			
				}
			
			}
		}catch(Exception error) {
			System.out.println("Operacion invalida: " + error);
		
		}

	}
}	

	//----------------------------------------
	//========================================
	//clase abstracta CUENTA.
	//========================================
	//----------------------------------------
	abstract class Cuenta{
		
		private int id = 0; 
		private float saldo; 
		abstract void depositar (float monto) throws MontoAnormalException; 
		abstract void retirar (float monto) throws MontoInsuficienteException; 
		 

		//=================
		//Getters y Setters
		//=================
		int getId() {
			return id;
		}
		void setId(int id) {
			this.id = id;
		}
	
		float getSaldo() {
			return saldo;
		}
		void setSaldo(float saldo) {
			this.saldo = saldo;
		}
		

	}
	
	//----------------------------------------
	//========================================
	//subclase CuentaCorriente de CUENTA
	//========================================
	//----------------------------------------
	class CuentaCorriente extends Cuenta{


		void depositar(float monto) throws MontoAnormalException {
			
			
			setSaldo(getSaldo() + monto);
			
			if(monto < 0)throw new MontoAnormalException("El monto indicado no es valido. Intente de nuevo.");
			System.out.print("Su saldo es: $" + getSaldo() + "\n");
		}
		
		void retirar(float monto) throws MontoInsuficienteException {
			
			setSaldo(getSaldo() - monto);		
			System.out.print("Su saldo es: $" + getSaldo() + "\n");

		
	}

}
	
	//----------------------------------------
	//========================================
	//subclase CuentaAhorros de CUENTA.
	//========================================
	//----------------------------------------
	class CuentaAhorros extends Cuenta{
		
		void depositar(float monto) throws MontoAnormalException {
			
			
			setSaldo(getSaldo() + monto);
			
			if(monto < 0)throw new MontoAnormalException("El monto indicado no es valido. Intente de nuevo.");
			System.out.print("Su saldo es: $" + getSaldo() + "\n");

		}
		
		void retirar(float monto) throws MontoInsuficienteException {
			
			setSaldo(getSaldo() - monto);		
		
			if(getSaldo() < 0)throw new MontoInsuficienteException("El saldo en su cuenta quedó en negativo. Esta operacion es invalida.");
			System.out.print("Su saldo es: $" + getSaldo() + "\n");

		
	}
	
}



//----------------------------------------
//========================================
//clases EXCEPCIONES PERSONALIZADAS.
//========================================
//----------------------------------------

class MontoAnormalException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2453616720779806453L;

	public MontoAnormalException(String error) {
			super(error);
	}

}

class MontoInsuficienteException extends Exception{	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1736760138859056127L;

	public MontoInsuficienteException (String error) {
		super(error);
	}
	
	}
	
/*Pensaba hacerlo con archivos pero no me odio tanto. Revisar documentacion. */
	