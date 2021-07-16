/* 
 * Excepciones03.java*/

//03. Calcular las raices de una ecuación de 2do grado
import java.util.Scanner;

public class Excepciones03 {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		
		double a=0;
		double b=0;
		double c=0;
		double x1=0;
		double x2=0;
		double argumento=0;
		
		Scanner entrada = new Scanner(System.in);
		System.out.println("GRUPO4//Excepciones03.java//UNEFA-NPC\n\n");

		
		try{
		
			System.out.print("Ingrese el coeficiente a: ");
		a = entrada.nextDouble();
		
		System.out.print("Ahora, el coeficiente b: ");
		b = entrada.nextDouble();
		
		System.out.print("Finalmente, el coeficiente c: ");
		c = entrada.nextDouble();
		
		if(a<0){
			a = a*-1;
			b = b*-1;
			c = c*-1;
		}
		if(a==0)throw new Exception("a debe ser diferente de cero");
		
		argumento = (b*b)-(4*a*c);
		
		x1 = (-b+Math.sqrt(argumento))/(2*a);
		x2 = (-b-Math.sqrt(argumento))/(2*a);
		
		System.out.print("\n");
		System.out.println("Ya tenemos el valor de las raices!");
		System.out.print("x1 = " + x1);
		System.out.print(" y  x2 = " + x2);
		entrada.close();
		
		}catch( Exception error){
			System.out.println("Operacion no es valida! " + error);

	   }finally{
		   System.out.println("\nPrograma finalizado.");
	   }

	}
	
}
