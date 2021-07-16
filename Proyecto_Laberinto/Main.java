/* UNEFA-NPC, LENGUAJE DE PROGRAMACIÓN III
 * PROYECTO 25%, CUARTO CORTE 
 * LABERINTO CON ALGORITMO DE BUSQUEDA PROFUNDA.
 * 09/07/2021
 * 
 * INTEGRANTES:
 * DIEGO PARRA, 26.671.334
 * KATHERINE GARCÍA, 26.696.857
 * GRUPO #4
 * 
 * PROFESORA: YELMIN PEREZ
 * 
 * 
 * Main.java*/
import javax.swing.SwingUtilities;

//Declaraciones para la inicialización de la interfaz.
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


//Utilice las teclas de dirección para avanzar: Derecha lleva
//la bola más cerca del objetivo, mientras que izquierda le aleja.