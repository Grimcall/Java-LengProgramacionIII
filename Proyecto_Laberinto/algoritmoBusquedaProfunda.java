/*
 * algoritmoBusquedaProfunda.java*/
import java.util.List;

public class algoritmoBusquedaProfunda {
	
//Algoritmo de busqueda profunda con recursión para conseguir el camino.
//Utiliza la lógica utilizada en Teoríga de Grafos utilizando el algoritmo
//de busqueda profunda.
	
		public static boolean buscarCamino(int [][] laberinto, 
				int x, int y, List<Integer> camino) {
			
			
			if(laberinto[y][x] == 9) {
				camino.add(x);
				camino.add(y);
				return true;
			}
			
			if(laberinto[y][x] == 0) {
				laberinto[y][x] = 2;
				
				int dx = -1;
				int dy = 0;
				if(buscarCamino(laberinto,  x + dx, y + dy, camino)) {
					
					camino.add(x);
					camino.add(y);
					return true;
				}
				
				 dx = 1;
				 dy = 0;
				if(buscarCamino(laberinto,  x + dx, y + dy, camino)) {
					
					camino.add(x);
					camino.add(y);
					return true;
				}
				 
				dx = 0;
				dy = -1;
				if(buscarCamino(laberinto,  x + dx, y + dy, camino)) {
					
					camino.add(x);
					camino.add(y);
					return true;
				}
				
				dx = 0;
				dy = 1;
				if(buscarCamino(laberinto,  x + dx, y + dy, camino)) {
					
					camino.add(x);
					camino.add(y);
					return true;
				}
			}
			return false;
		}
}
