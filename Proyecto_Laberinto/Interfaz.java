/*
 * 
 * Interfaz.java*/

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;

public class Interfaz extends JFrame{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2575226178313033719L;
	
	//Declaracion del laberinto. A través de este atributo, le daremos forma al laberinto.
	//1 = Muro
	//0 = Camino
	//9 = Final
	
	//La posicion de entrada corresponde a (29,1) en nuestra matriz.
	
	//Este es el laberinto que usted puso en el documento enviado, tal cual.
		private int [][] laberinto =  
		{ 
			{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
			{1,1,1,1,1,1,0,1,1,1,1,1,1,1,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0},
			{1,1,1,1,1,1,0,1,1,1,1,1,1,1,1,1,1,0,1,1,1,1,1,1,1,1,1,1,1,1},
			{1,1,1,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,1,1,1,1,1,1,1,1,1,1,1,1},
			{1,1,1,1,1,1,1,1,1,1,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
			{1,1,1,1,1,1,1,1,1,1,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
			{1,1,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,1,1,1,1,1},
			{1,1,1,1,1,0,1,1,1,1,1,1,1,1,1,1,0,1,1,1,1,1,1,1,1,1,1,1,1,1},
			{1,1,1,1,1,0,1,1,1,1,1,1,1,1,1,1,0,1,1,1,1,1,1,1,1,1,1,1,1,1},
			{1,1,1,0,0,0,0,0,1,1,0,0,0,0,0,0,0,0,0,1,1,1,1,1,1,1,1,1,1,1},
			{1,1,1,1,1,0,1,1,1,1,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
			{1,1,1,1,1,0,1,1,1,1,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
			{1,1,1,1,1,0,1,1,1,1,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
			{1,1,1,1,1,1,1,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,9,1},
			{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1}
				};
	
private final List<Integer> camino = new ArrayList<Integer>();
private int caminoIndice;
	
//Apertura de interfaz.
public Interfaz(){
	setTitle("LaberintoV1.1—ParraDiegoGRUPO4—UNEFA");
	setSize(1280, 720);
	setLocationRelativeTo(null);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	
	//SE DEBE DEFINIR LA POSICION DE ENTRADA EN LOS PARAMETROS. EN ESTE CASO, ESTE LABERINTO COMIENZA EN (29, 1)
	algoritmoBusquedaProfunda.buscarCamino(laberinto, 29, 1, camino);
	caminoIndice = camino.size() - 2;
}

@Override
//Funcion paint perteneciente a el conjunto de clases JFrame.
//Se le ajusta con el proposito de acomodarse a nuestro laberinto.
public void paint (Graphics grafica){
 super.paint(grafica);	
 grafica.translate(50, 50);
 
 //Declaramos los colores.
 //Negro para muro.
 //Blanco para camino.
 //Rojo para final.
for (int fila = 0; fila < laberinto.length; fila++) {
	for(int col = 0; col < laberinto[0].length; col++) {
		Color color;
		switch(laberinto[fila][col]) {
		case 1: color = Color.GRAY; break;
		case 9: color = Color.RED; break;
		default : color = Color.WHITE;
		}
		grafica.setColor(color);
		grafica.fillRect(30*col, 30*fila, 30, 30);
		grafica.setColor(Color.GRAY);
		grafica.drawRect(30*col, 30*fila,  30, 30);
			}
		} 

//Pinta únicamente el camino correcto en verde.
//Utilizado mayormente por propositos de prueba.
		for( int c = 0 ; c < camino.size(); c += 2) {
			int caminoX = camino.get(c);
			int caminoY = camino.get(c + 1);
			grafica.setColor(Color.GREEN);
			grafica.fillRect(caminoX*30, caminoY*30, 30, 30);
			
		}
		
		//Pintar el final.
		int caminoX = camino.get(caminoIndice);
		int caminoY = camino.get(caminoIndice + 1);
		grafica.setColor(Color.RED);
		grafica.fillOval(caminoX*30, caminoY*30, 30, 30);
		
	}	

//Funcion definida para moverse a través del laberinto.
//La tecla derecha en el teclado acerca el trazador a la salida.
//Izquierda, le aleja.
	@Override
	protected void processKeyEvent(KeyEvent ke) {
		if ( ke.getID() != KeyEvent.KEY_PRESSED) {
			return;
			}
	if( ke.getKeyCode() == KeyEvent.VK_RIGHT) {
		caminoIndice -= 2;
			if (caminoIndice < 0) {
				caminoIndice = 0;
			}
	}
	else if(ke.getKeyCode() == KeyEvent.VK_LEFT) {
		caminoIndice += 2;
		if(caminoIndice > camino.size() - 2) {
			caminoIndice = camino.size() - 2;
			}
		}
	repaint();
	}
}



