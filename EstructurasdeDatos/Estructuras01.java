package ImplementacionManual;
/* UNEFA-NPC, LENGUAJE DE PROGRAMACIÓN III
 * ACTIVIDAD 10%, TERCER CORTE, PRIMER EJERCICIO.
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
 * Estructuras01.java*/

/*01. Suma, resta, multiplicacion y division de polinoimos con lista enlazada doble circular. */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
 
public class Estructuras01 {
 
    public static void main(String[] args) throws NumberFormatException, IOException {
 
    	//Objetos y variables.
        BufferedReader dato = new BufferedReader(new InputStreamReader(System.in));
        ListaSE poli1 = new ListaSE();
        ListaSE poli2 = new ListaSE(); 
        int salir = 1;
        
        
        System.out.print("Introduzca cuantos terminos posee el primer polinomio: ");
        
        int cantidad = Integer.parseInt(dato.readLine());
        
        for (int i = 1; i <= cantidad; i++) {
           
        	System.out.print("==Termino #" + i + "==\n");
            System.out.print("Ingrese coeficiente: ");
            int coeficiente = Integer.parseInt(dato.readLine());
            
            System.out.print("Ingrese exponente: ");
            int exponente = Integer.parseInt(dato.readLine());
            if (exponente == 0)
                exponente = -1;
            Polinomio poli = new Polinomio(coeficiente, exponente);
            poli1.insertarAlFrente(poli);
        }
        
        System.out.print("Introduzca cuantos terminos posee el segundo polinomio: ");
        
        int cantidad2 = Integer.parseInt(dato.readLine());
        
        for (int i = 1; i <= cantidad2; i++) {
           
        	System.out.print("==Termino #" + i + "==\n");
            System.out.print("Ingrese coeficiente: ");
            int coeficiente = Integer.parseInt(dato.readLine());
            System.out.print("Ingrese exponente: ");
            int exponente = Integer.parseInt(dato.readLine());
            if (exponente == 0)
                exponente = -1;
            Polinomio poli = new Polinomio(coeficiente, exponente);
            poli2.insertarAlFrente(poli);
        }
        
    	System.out.println("\n\nPRIMER POLINOMIO: ");
    	mostrar(poli1.primerNodo);
    	System.out.println("\nSEGUNDO POLINOMIO: ");
    	mostrar(poli2.primerNodo);
        do {

        	
        
        	System.out.println("\n\n1. Sumar");
        	System.out.println("2. Restar");
            System.out.println("3. Multiplicar.");
            System.out.println("4. Dividir");
            System.out.println("5. Salir");
            System.out.println("6. Cambiar polinomios. ");
            System.out.println("7. Mostrar polinomios. ");
            
            System.out.print("Ingrese opcion: ");
            int opcion = Integer.parseInt(dato.readLine());
            
            switch (opcion) {
                case 1:
                   
                    System.out.print("\nRESPUESTA SUMA:  ");
                    sumaPolinomios(poli1.primerNodo, poli2.primerNodo, cantidad, cantidad2);
                    System.out.println();
                    break;
                case 2:
                	
                	System.out.print("RESPUESTA RESTA:  ");
                    restaPolinomios(poli1.primerNodo, poli2.primerNodo, cantidad, cantidad2);
                    System.out.println();
                    
                    break;
                case 3:
                   
                    System.out.print("RESPUESTA PRODUCTO:  ");
                    producto(poli1.primerNodo, poli2.primerNodo, cantidad, cantidad2);
                    System.out.println();
                    break;
                    
                case 4:
                	
                	System.out.print("RESPUESTA DIVISION: ");
                	divisionPolinomios(poli1.primerNodo, poli2.primerNodo, cantidad, cantidad2);
                	System.out.println();
                	break;
                	
                case 5:
                    System.exit(0);
                    break;
                    
                case 6: 
                	  System.out.print("Introduzca cuantos terminos posee el primer polinomio: ");
                      
                      cantidad = Integer.parseInt(dato.readLine());
                      
                      for (int i = 1; i <= cantidad; i++) {
                         
                      	System.out.print("==Termino #" + i + "==\n");
                          System.out.print("Ingrese coeficiente: ");
                          int coeficiente = Integer.parseInt(dato.readLine());
                          
                          System.out.print("Ingrese exponente: ");
                          int exponente = Integer.parseInt(dato.readLine());
                          if (exponente == 0)
                              exponente = -1;
                          Polinomio poli = new Polinomio(coeficiente, exponente);
                          poli1.insertarAlFrente(poli);
                      }
                      
                      System.out.print("Introduzca cuantos terminos posee el segundo polinomio: ");
                      
                      cantidad2 = Integer.parseInt(dato.readLine());
                      
                      for (int i = 1; i <= cantidad2; i++) {
                         
                      	System.out.print("==Termino #" + i + "==\n");
                          System.out.print("Ingrese coeficiente: ");
                          int coeficiente = Integer.parseInt(dato.readLine());
                          System.out.print("Ingrese exponente: ");
                          int exponente = Integer.parseInt(dato.readLine());
                          if (exponente == 0)
                              exponente = -1;
                          Polinomio poli = new Polinomio(coeficiente, exponente);
                          poli2.insertarAlFrente(poli);
                      }
                      
                		break;
                case 7: 
                	System.out.println("PRIMER POLINOMIO: ");
                	mostrar(poli1.primerNodo);
                	System.out.println("\nSEGUNDO POLINOMIO: ");
                	mostrar(poli2.primerNodo);
                	break; 
                default: System.out.println("Dato invalido. Intente de nuevo. "); break;
            }
        } while (salir != 5);
    }
 
 

    static void mostrar(Nodo poli) {
    	Nodo poliAux = poli;
    	
        int acum = 0;
        int r = 0;
        int cont = 0;
        
        while(poliAux != null) {
        	acum = poliAux.poli.getCoeficiente();
        	r = poliAux.poli.getExponente();
        	
        	  if (cont == 0) {
                  if (r > 0 && acum > 0)
                      System.out.print(acum + " X ^  " + r + "   ");
   
                  if (r > 0 && acum < 0)
                      System.out.print(acum + " X ^  " + r + "   ");
   
                  if (r == 0)
                      System.out.print(acum + "  ");
   
                  if (r < 0)
                      System.out.print(" 0 ");
              }
        	  
        	  if (cont > 0) {
                  if (r > 0 && acum > 0)
                      System.out.print(" + " + acum + " X ^  " + r + "   ");
   
                  if (r > 0 && acum < 0)
                      System.out.print(acum + " X ^  " + r + "   ");
   
                  if (r == 0 && acum > 0)
                      System.out.print(" + " + acum + "  ");
                  if (r == 0 && acum < 0)
                      System.out.print(acum + "  ");
   
                  if (r < 0)
                      System.out.print(" +0 ");
   
              }
        	     cont++;
                 acum = 0;
                 r = 0;
                 poliAux = poliAux.siguiente;
        	  
        }
    }
 
  
    static void ordBurbuja(int a[], int n) {
	    boolean interruptor = true;
	    for (int pasada = 0; pasada < n - 1 && interruptor; pasada++) {
	        interruptor = false;
	        for (int j = 0; j < n - pasada - 1; j++)
	            if (a[j] < a[j + 1]) {
	                int aux;
	                interruptor = true;
	                aux = a[j];
	                a[j] = a[j + 1];
	                a[j + 1] = aux;
	            }
	
	    }
	}



	@SuppressWarnings("unused")
	static void sumaPolinomios(Nodo poli1, Nodo poli2, int cantidad, int cantidad2) {
        int[] numerosl1 = new int[cantidad];
        int[] numerosl2 = new int[cantidad2];
 
        //PRIMER POLINOMIO
        int acomp = 0;
        Nodo p = poli1;
        while (p != null) {
            numerosl1[acomp] = p.poli.getExponente();
            acomp++;
            p = p.siguiente;
        }
 
        //SEGUNDO POLINOMIO
        int acomp2 = 0;
        Nodo q = poli2;
        while (q != null) {
            numerosl2[acomp2] = q.poli.getExponente();
            acomp2++;
 
            q = q.siguiente;
        }
 
        //Operacion.
        int[] mipoli = new int[100];
        int aux = 0;
        int vueltas = cantidad + cantidad2;
        int cambios1 = 0, cambios2 = 0;
 
        for (int j = 0; j < cantidad; j++) {
            mipoli[j] = numerosl1[j];
 
        }
        for (int j = 0; j < cantidad2; j++) {
            mipoli[cantidad++] = numerosl2[j];
        }
 
        //Eliminar repetidos.
        int ver2 = 0;
        for (int i = 0; i < vueltas; i++) {
            for (int j = 0; j < vueltas; j++) {
                if (mipoli[i] == mipoli[j])
                    ver2++;
 
                if (ver2 == 2) {
                    mipoli[j] = 0;
                    ver2--;
                }
 
            }
            ver2 = 0;
 
        }
 
        //Exponentes.
        int ccero = 0;
        for (int i = 0; i < vueltas; i++) {
            if (mipoli[i] == 0) {
                ccero++;
            }
        }
        int actual = vueltas - ccero;
        int[] vpolinomio = new int[actual];
        int cvpoli = 0;
        for (int i = 0; i < vueltas; i++) {
            if (mipoli[i] != 0) {
                vpolinomio[cvpoli] = mipoli[i];
                cvpoli++;
            }
        }
 
        //Ordenamiento.
        ordBurbuja(vpolinomio, cvpoli);
 
        int d = 0;
        acomp = vpolinomio.length;
        while (acomp != 0) {
            int acum = 0;
            Nodo a = poli1;
            Nodo b = poli2;
 
            int ver = 0;
            boolean pass = false;
            boolean pass2 = false;
 
            //Sumamos.
            while (ver < 2) {
                if (!pass) {
                    if (a != null) {
                        if (vpolinomio[d] == a.poli.getExponente()) {
                            acum += a.poli.getCoeficiente();
                        }
                        a = a.siguiente;
                    } else {
                        ver++;
                        pass = true;
                    }
                }
 
                if (!pass2) {
                    if (b != null) {
                        if (vpolinomio[d] == b.poli.getExponente()) {
                            acum += b.poli.getCoeficiente();
                        }
                        b = b.siguiente;
                    } else {
                        ver++;
                        pass2 = true;
                    }
                }
            }
            
            //Impresion
            if (acomp != 0) {
                if (d == 0) {
                    if (vpolinomio[d] != -1 && acum > 0) {
                        System.out.print(acum + " X ^ " + vpolinomio[d] + "    ");
                    } else if (acum < 0 && vpolinomio[d] != -1) {
                        System.out.print(acum + " X ^ " + vpolinomio[d] + "    ");
                    }
                    if (vpolinomio[d] == -1)
                        System.out.print(acum + "    ");
                } else if (d > 0) {
                    if (vpolinomio[d] != -1 && acum > 0)
                        System.out.print(" + " + acum + " X ^ " + vpolinomio[d] + "    ");
                    else if (acum < 0 && vpolinomio[d] != -1)
                        System.out.print(acum + " X ^ " + vpolinomio[d] + "    ");
                    if (vpolinomio[d] == -1 && acum > 0)
                        System.out.print(" + " + acum + "    ");
                    else if (vpolinomio[d] == -1 && acum < 0)
                        System.out.print(acum + "    ");
                }
            }
 
            d++;
            acomp--;
        }
 
    }
 
    @SuppressWarnings("unused")
	static void restaPolinomios(Nodo poli1, Nodo poli2, int cantidad, int cantidad2) {
        int[] numerosl1 = new int[cantidad];
        int[] numerosl2 = new int[cantidad2];
 
        //Polinomio 1
        int acomp = 0;
        Nodo p = poli1;
        while (p != null) {
            numerosl1[acomp] = p.poli.getExponente();
            acomp++;
            p = p.siguiente;
        }
 
        //Polinomio 2
        int acomp2 = 0;
        Nodo q = poli2;
        while (q != null) {
            numerosl2[acomp2] = q.poli.getExponente();
            acomp2++;
 
            q = q.siguiente;
        }
 
      
        int[] mipoli = new int[100];
        int aux = 0;
        int vueltas = cantidad + cantidad2;
        int cambios1 = 0, cambios2 = 0;
 
        for (int j = 0; j < cantidad; j++) {
            mipoli[j] = numerosl1[j];
 
        }
        for (int j = 0; j < cantidad2; j++) {
            mipoli[cantidad++] = numerosl2[j];
        }
 
       
        int ver2 = 0;
        for (int i = 0; i < vueltas; i++) {
            for (int j = 0; j < vueltas; j++) {
                if (mipoli[i] == mipoli[j])
                    ver2++;
 
                if (ver2 == 2) {
                    mipoli[j] = 0;
                    ver2--;
                }
 
            }
            ver2 = 0;
 
        }
 
     
        int ccero = 0;
        for (int i = 0; i < vueltas; i++) {
            if (mipoli[i] == 0) {
                ccero++;
            }
        }
        int actual = vueltas - ccero;
        int[] vpolinomio = new int[actual];
        int cvpoli = 0;
        for (int i = 0; i < vueltas; i++) {
            if (mipoli[i] != 0) {
                vpolinomio[cvpoli] = mipoli[i];
                cvpoli++;
            }
        }
 
     
        ordBurbuja(vpolinomio, cvpoli);
 
        int d = 0;
        acomp = vpolinomio.length;
        while (acomp != 0) {
            int acum = 0;
            Nodo a = poli1;
            Nodo b = poli2;
 
            int ver = 0;
            boolean pass = false;
            boolean pass2 = false;
 
            while (ver < 2) {
                if (!pass) {
                    if (a != null) {
                        if (vpolinomio[d] == a.poli.getExponente()) {
                            acum += a.poli.getCoeficiente();
                        }
                        a = a.siguiente;
                    } else {
                        ver++;
                        pass = true;
                    }
                }
 
                if (!pass2) {
                    if (b != null) {
                        if (vpolinomio[d] == b.poli.getExponente()) {
                            acum -= b.poli.getCoeficiente();
                        }
                        b = b.siguiente;
                    } else {
                        ver++;
                        pass2 = true;
                    }
                }
            }
            if (acomp != 0) {
                if (d == 0) {
                    if (vpolinomio[d] != -1 && acum > 0) {
                        System.out.print(acum + " X ^ " + vpolinomio[d] + "    ");
                    } else if (acum < 0 && vpolinomio[d] != -1) {
                        System.out.print(acum + " X ^ " + vpolinomio[d] + "    ");
                    }
                    if (vpolinomio[d] == -1)
                        System.out.print(acum + "    ");
                } else if (d > 0) {
                    if (vpolinomio[d] != -1 && acum > 0)
                        System.out.print(" + " + acum + " X ^ " + vpolinomio[d] + "    ");
                    else if (acum < 0 && vpolinomio[d] != -1)
                        System.out.print(acum + " X ^ " + vpolinomio[d] + "    ");
                    if (vpolinomio[d] == -1 && acum > 0)
                        System.out.print(" + " + acum + "    ");
                    else if (vpolinomio[d] == -1 && acum < 0)
                        System.out.print(acum + "    ");
                }
            }
 
            d++;
            acomp--;
        }
 
    }
    
  
 
    static void producto(Nodo poli1, Nodo poli2, int cantidad, int cantidad2) {
	
	    ListaSE guardap1 = new ListaSE();
	    Nodo a;
	    Nodo b;
	
	    if (cantidad > cantidad2) {
	
	        a = poli1;
	        b = poli2;
	    } else {
	
	        a = poli2;
	        b = poli1;
	    }
	
	    int cont = 0;
	
	    while (a != null) {
	        while (b != null) {
	            int coeficiente = a.poli.getCoeficiente() * b.poli.getCoeficiente();
	            int exponente = a.poli.getExponente() + b.poli.getExponente();
	            Polinomio poli = new Polinomio(coeficiente, exponente);
	            guardap1.insertarAlFrente(poli);
	            b = b.siguiente;
	            cont++;
	        }
	        if (cantidad > cantidad2) {
	            b = poli2;
	        } else {
	            b = poli1;
	        }
	        a = a.siguiente;
	    }
	    ListaSE vacio = new ListaSE();
	
	    Nodo ver = guardap1.primerNodo;
	
	    while (ver != null) {
	        if (ver.poli.getExponente() == 0) {
	            ver.poli.setExponente(-1);
	        }
	        ver = ver.siguiente;
	    }
	    sumaPolinomios(guardap1.primerNodo, vacio.primerNodo, cont, 0);
	}



	static void divisionPolinomios(Nodo poli1, Nodo poli2, int cantidad, int cantidad2) {
		 
	    ListaSE guardap1 = new ListaSE();
	    Nodo a;
	    Nodo b;
	
	    if (cantidad > cantidad2) {
	
	        a = poli1;
	        b = poli2;
	    } else {
	
	        a = poli2;
	        b = poli1;
	    }
	
	    int cont = 0;
	
	    while (a != null) {
	        while (b != null) {
	            int coeficiente = a.poli.getCoeficiente() / b.poli.getCoeficiente();
	            int exponente = a.poli.getExponente() - b.poli.getExponente();
	            Polinomio poli = new Polinomio(coeficiente, exponente);
	            guardap1.insertarAlFrente(poli);
	            b = b.siguiente;
	            cont++;
	        }
	        if (cantidad > cantidad2) {
	            b = poli2;
	        } else {
	            b = poli1;
	        }
	        a = a.siguiente;
	    }
	    ListaSE vacio = new ListaSE();
	
	    Nodo ver = guardap1.primerNodo;
	
	    while (ver != null) {
	        if (ver.poli.getExponente() == 0) {
	            ver.poli.setExponente(-1);
	        }
	        ver = ver.siguiente;
	    }
	    restaPolinomios(guardap1.primerNodo, vacio.primerNodo, cont, 0);
	}
}

/*Esta es la lista*/
class ListaSE {
	public Nodo primerNodo;
	public Nodo ultimoNodo;
 
	public ListaSE() {
		primerNodo = ultimoNodo = null;
	}
 
	public void insertarAlFrente(Polinomio est) {
		if (estaVacia())
			primerNodo = ultimoNodo = new Nodo(est);
		else
			primerNodo = new Nodo(est, primerNodo);
	}
 
 
	public boolean estaVacia() {
		return primerNodo == null;
	}
 
	public void insertarAlFinal(Polinomio est) {
		if (estaVacia())
			primerNodo = ultimoNodo = new Nodo(est);
		else
			ultimoNodo = ultimoNodo.siguiente = new Nodo(est);
 
	}
}
/*Este es el Nodo*/
class Nodo {
    Polinomio poli;
    Nodo siguiente;
 
    public Nodo(Polinomio x) {
        this.poli = x;
        siguiente = null;
    }
    public Nodo(Polinomio x, Nodo nuevoelemento) {
        this.poli = x;
        siguiente = nuevoelemento;
    }
    Polinomio getPolinomio() {
        return this.poli;
    }
 
    Nodo getsiguientet() {
        return siguiente;
    }
}

/*Este es el polinomio*/
class Polinomio {
	private int coeficiente;
	private int exponente;
	
 
	public Polinomio(){
		this.coeficiente=0;
		this.exponente=0;
 
	}

	public Polinomio(int co, int ex){
		setPolinomio(co, ex);
 
	}
	
 
	public void setPolinomio(int coeficiente,int exponente){
		this.coeficiente=coeficiente;
		this.exponente=exponente;
	}
 
	public int getExponente(){
		return this.exponente;
	}
 
	public void setExponente(int ex){
		this.exponente=ex;
	}
	public int getCoeficiente(){
		return this.coeficiente;
	}
	 
}
//Fin