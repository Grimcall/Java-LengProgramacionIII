/* UNEFA-NPC, LENGUAJE DE PROGRAMACI�N III
 * PROYECTO 25%, CUARTO CORTE 
 * LABERINTO CON ALGORITMO DE BUSQUEDA PROFUNDA.
 * 09/07/2021
 * 
 * INTEGRANTES:
 * DIEGO PARRA, 26.671.334
 * KATHERINE GARC�A, 26.696.857
 * GRUPO #4
 * 
 * PROFESORA: YELMIN PEREZ
 * 
 * 
 * Main.java*/
import javax.swing.SwingUtilities;

//Declaraciones para la inicializaci�n de la interfaz.
public class Main {
 
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable(){
			
			public void run() {
				Interfaz interfaz = new Interfaz();
				interfaz.setVisible(true);
			}
		});
	}

}


//Utilice las teclas de direcci�n para avanzar: Derecha lleva
//la bola m�s cerca del objetivo, mientras que izquierda le aleja.