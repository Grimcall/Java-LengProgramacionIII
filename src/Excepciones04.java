/* UNEFA-NPC, LENGUAJE DE PROGRAMACIÓN III
 * ACTIVIDAD 15%, SEGUNDO CORTE, CUARTO EJERCICIO.
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
 * Excepciones04.java*/

/*04. Sistema de registro básico*/
import java.util.Scanner;

public class Excepciones04 { //Corresponde a la clase User, pero la llamamos Excepciones04 por conveniencia.


	public static void main(String[] args) {
		
		//Declaraciones
		Login miIngreso = new Login(); //Instancia de la clase Login.
		secretData misSecretos = new secretData(); 
		Scanner entradaMain; 
		@SuppressWarnings("resource")
		Scanner entradaStr = new Scanner (System.in);
		int aux = 0;
		
		System.out.println("GRUPO4//Excepciones04.java//UNEFA-NPC\n\n");

		try {
			
			while(aux != 4) {
				entradaMain = new Scanner(System.in);

			
			System.out.println("-1. Registrarse. ");
			System.out.println("-2. Ingresar. ");
			System.out.println("-3. Ver datos.");
			System.out.println("-4. Salir. ");
			System.out.print("Eleccion: ");
			
			aux = entradaMain.nextInt();
			
			switch(aux) {
			
			case 1:
				Login.accessPermitted = false;
				System.out.print("Introduzca el nombre de usuario para registrar: "); 
				miIngreso.setUser(entradaStr.nextLine());	
				System.out.print("Introduzca la contraseña para registrar: ");	
				miIngreso.setContra(entradaStr.nextLine());	
				break;
				
			case 2:
				miIngreso.passwordChecker();
				break;
			case 3:
				misSecretos.retornarDatos(miIngreso);
				break;
			case 4: System.exit(0);
				
				}
			}	
		}catch(Exception error) {
			System.out.println("Algo ocurrio en el programa: \n" + error);
			
		}		
	}
	

}


//----------------------------------------
//========================================
//clase LOGIN
//========================================
//----------------------------------------

class Login {
	private String user;
	private String contra;
	static boolean accessPermitted = false;
	
	//==================================
	//Funcion para revisar contraseñas.
	//==================================
	@SuppressWarnings("resource")
	void passwordChecker() throws Tresspassing 
	{//int passwordChecker
		
		Scanner entrada = new Scanner(System.in);
			String userAux;
			String contraAux;
			
		System.out.print("Introduzca el nombre de usuario: "); 
		userAux = entrada.nextLine();	
		System.out.print("Introduzca la contraseña: ");	
		contraAux = entrada.nextLine();	
			
		
		if(userAux.equals(user) && contraAux.equals(contra)){//init if
			
			System.out.println("Autenticación Verificada. Acceso al Usuario Permitido");
				accessPermitted = true;
				return;	
			}//fin if
		else {
		accessPermitted = false;
		throw new Tresspassing("Los datos introducidos son incorrectos.");}
		
	}//fin passwordChecker
	
	//==================================
	//SETTERS
	//==================================
	
	void setUser (String userAux) 
	{
		this.user = userAux;
		
	}
	
	void setContra (String contraAux)
	{
		this.contra = contraAux;
		
	}
}

//----------------------------------------
//========================================
//clase secretDATA
//========================================
//----------------------------------------

class secretData{
	
	private String identidad = "26671334";
	private String colorFavorito = "Rojo";
	private int edad = 22;
	
	void retornarDatos(Login miIngreso) throws HackerAlert
	{ 
		if(Login.accessPermitted == true) {
			System.out.println("-Cédula de identidad: " + identidad);
			System.out.println("-Color favorito: " + colorFavorito);
			System.out.println("-Edad: " + edad);
		}else throw new HackerAlert("No tiene permiso de ingresar al sistema. Intente ingresar de nuevo para ver sus datos.");
		
		
	}

}

//----------------------------------------
//========================================
//clases EXCEPCIONES PERSONALIZADAS.
//========================================
//----------------------------------------

class Tresspassing extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8611622804428636206L;

	public Tresspassing(String error) {
			super(error);
	}

}

class HackerAlert extends Exception{	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6934024188877694092L;

	public HackerAlert(String error) {
		super(error);
	}
	
}
	
	
