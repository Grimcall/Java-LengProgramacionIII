1)	Escribir un programa que permita calcular la media de unas calificaciones de examen, contemplando todos sus posibles errores en tiempo de ejecución.

3)	Escribir un programa llamada Calculadora que realice las funciones típicas de una calculadora. Para ello pedirá al usuario tres valores: operación (+,-,*,/), operando1, operando2 y a partir de ellos muestre el resultado de la operación. Cuando el usuario introduzca una Z como valor de la operación el programa parará, si se introduce cualquier otro carácter se debe producir una excepción definida por el usuario imprimiendo un mensaje de error. 
Se deberán intentar utilizar todos los mecanismos de tratamiento de excepciones dados en teoría.

3)	Calcular las raíces de una ecuación de segundo grado, usando excepciones en java:
ax2+bx+c=0 tiene las siguientes raíces, debe incluir main principal y las excepciones necesarias:

x1 = (-b + (b^2 - 4ac)^1/2)/2a

x2 = (-b - (b^2 - 4ac)^1/2)/2a

4) Escriba un programa en Java que tenga una clase llamada Login. Esta clase tiene los nombres de usuario y sus correspondientes palabras claves guardadas en arreglos String (declarados private). También tiene una variable boolean, accessPermitted, cuyo valor por defecto es falseo Existe un método llamado passwordChecker () que verifica la palabra clave ingresada contra el nombre de usuario. Si la palabra clave ingresada es correcta, entonces imprime "Autenticación Verificada. Acceso al Usuario Permitido" en la salida estándar cambia el valor de accessPermitted a true. Si la palabra clave ingresada es incorrecta entonces accessPermitted se hace false y se lanza una excepción llamada TressPassing. TressPassing es una excepción definida por el usuario. La clase User instancia la clase Login, e invoca al método passwordChecker () para validar la palabra clave a fin de obtener acceso a SecretData. Los datos en la clase secretData solo puede ser accedidos cuando accessPermitted de Login es true, de otra  forma se lanza una excepción HackerAlert,  también definida por el usuario. Ambas excepciones TressPassing y HackerAlert tienen información que puede ser usada por User cuando son capturadas.

5) Escriba un programa en Java que tenga una clase abstracta llamada Cuenta. Esta Clase debe tener los siguientes miembros: 
private int id; 
private float  saldo; 
abstract void depositar{float monto) throws MontoAnormalException; 
abstract void retirar{float monto) throws MontolnsuficienteException; 
El programa debe tener también dos clases concretas llamadas CuentaCorriente y CuentaAhorro que son subclases de la clase Cuenta. Los objetos de la clase CuentaCorriente pueden llegar a tener el saldo negativo luego de un retiro, al contrario de los objetos de la clase CuentaAhorro que no pueden llegar a tener saldo negativo. Las clases MontoAnormalException y MontolnsuficienteException son clases excepciones que deben ser manejadas en el programa. Debe escribir una clase Principal que permita crear instancias de CuentaCorriente y CuentaAhorro para verificar el manejo correcto de las excepciones. 

