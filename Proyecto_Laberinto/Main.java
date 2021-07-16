/* 
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
