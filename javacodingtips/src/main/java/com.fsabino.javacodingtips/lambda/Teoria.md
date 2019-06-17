# Lambda

Las expresiones lambda son funciones anónimas, es decir, funciones que no necesitan una clase.
Su sintáxis básica se detalla a continuación:

	(parametro) -> {cuerpo lambda}

Por medio de expresiones lambda podemos referenciar métodos anónimos o métodos sin nombre, lo que nos permite escribir código más claro y conciso que  cuando usamos clases anónimas. Una expresión lambda se compone de:

**Parametros**
Listado de parámetros separados por comas y encerrados en paréntesis, por ejemplo: (a,b).
Cuando se tiene un solo parámetro no es necesario utilizar los paréntesis.
Cuando no se tienen parámetros, o cuando se tienen dos o más, es necesario utilizar paréntesis.
 
**Simbolo lambda**
El símbolo de flecha hacia la derecha: ->
   
**Cuerpo**
Cuando el cuerpo de la expresión lambda tiene una única línea no es necesario utilizar las llaves y no necesitan especificar la clausula return en el caso de que deban devolver valores.
Cuando el cuerpo de la expresión lambda tiene más de una línea se hace necesario utilizar las llaves y es necesario incluir la clausula return en el caso de que la función deba devolver un valor .
Un cuerpo que puede ser un bloque de código encerrado entre llaves o una sola expresión.

A continuación algunos ejemplos de expresiones lambda:

1. (int a, int b) ­>  a + b
2. (int a) ­> a +  1
3. (int  a, int b) ­> {
					System.out.println(a + b);  
					return a + b; 
				   } 
4. () ­> new ArrayList()

1. El primer ejemplo es una expresión lambda que tiene dos (2) parámetros tipo int y una sola sentencia que realiza la suma de dichos parámetros
2. La segunda expresión tiene un solo parámetro y una sola sentencia que suma una unidad a dicho parámetro
3. La tercera expresión cuenta con dos (2) parámetros tipo int y tiene un cuerpo con dos (2) sentencias que primero escribe a la consola la suma de ambos parámetros y luego retorna dicho valor. Nótese que cuando tenemos varias sentencias dentro del cuerpo de una expresión lambda, además de encerrar su cuerpo entre llaves ({}) también debemos separar las sentencias por medio de puntos y comas (;)
4. La última expresión no tiene parámetros, pero retorna una nueva instancia de la clase java.util.ArrayList


### Interfaces recargadas 

Java SE 8 hace un cambio grande a las interfaces con el fin de que las librerías puedan evolucionar sin perder compatibilidad. A partir de esta versión, las interfaces pueden proveer métodos con una implementación por defecto. Las clases que implementen dichas interfaces heredarán automáticamente la implementación por defecto si éstas no proveen una explícitamente:

1. Llamados métodos por defecto, métodos virtuales o métodos defensores , son especificados e implementados  en  la interface.  Usan  la nueva palabra reservada default antes  del tipo  de retorno.
2. La implementación por defecto es usada solo cuando la clase implementadora no provee su 
propia implementación .
3. Desde el punto de vista de quién invoca al método, es un método más de la interface.
4. Conflicto cuando se implementen interfaces con métodos por defecto con el mismo nombre.

En el siguiente ejemplo vemos como se ha adicionado el método por defecto +sort(Comparator):void a la interface java.util.List sin que esto afecte sus implementaciones:

Interface List<T> {
    … 
    default void sort(Comparator<? super T>  cmp)
    { 
    Collections.sort(this, cmp);
    }
    …
} 
 

Con la adición de métodos por defecto, las clases ahora pueden heredar diferentes comportamientos de múltiples interfaces. En caso de conflictos, este es el orden en el que se selecciona el método por defecto:

1.   Implementaciones en clases concretas
2.   Implementaciones en subinterfaces
3.   Explícitamente seleccionando el método deseado usando: X.super.m(...) , donde X es la interface y m es el método.

A continuación definiremos dos (2) interfaces, ambas definen un método por defecto con el mismo nombre:

public interface  SaludoMañanaInterface {
    default void saludo(){ 
        System.out.println("Buenos días");
    }
} 
public interface  SaludoTardeInterface {
    default void saludo(){ 
        System.out.println("Buenas tardes");
    } 
} 
 
Dado que la clase concreta implementa ambas interfaces, ésta deberá sobreescribir obligatoriamente el método y decidir cuál de los dos invocar:

class MultipleHerencia implements  SaludoMañanaInterface, SaludoTardeInterface {
@Override
public void saludo() {
    SaludoMañanaInterface.super.saludo(); 
   }
}
 
También debemos mencionar que, a partir de Java SE 8, además de métodos por defecto, las interfaces también pueden definir e implementar métodos estáticos. A continuación se muestra uno de los métodos estáticos que ahora existen en la interface java.util.Comparator:

public interface Comparator<T>  {
   ...
   public static <T  extends Comparable<? super T>>  Comparator<T>  reverseOrder()  {
   return Collections.reverseOrder(); 
   }
   ...
} 
 
Con  estos cambios, las librerías podrán evolucionar sin afectar implementaciones actuales, por ejemplo, esta es la forma en la que ha evolucionado el framework de colecciones en esta nueva versión de Java.


### Interfaces funcionales 

Concepto nuevo en Java SE 8 y que es la base para que podamos escribir expresiones lambda. Una interface funcional se define como una interface que tiene uno y solo un método abstracto y que éste sea diferente a los métodos definidos en java.lang.Object (a saber: equals, hashcode, clone, etc.). 
La interface puede tener métodos por defecto y estáticos sin que esto afecte su condición de ser interface funcional.

Existe una nueva anotación denominada @FunctionalInterface que permite al compilador realizar la validación de que la interface tenga solamente un método abstracto. A continuación se muestra un código que no compilará, debido a que la interface define más de un método abstracto:

@FunctionalInterface public interface  MiInterface { 
   int  getNum();
   String getString(); 
   String toString();
} 

La declaración es exactamente igual que las interfaces normales con dos características adicionales:

Tiene un único método abstracto, como ya hemos dicho.
De manera opcional puede estar anotada como @FunctionalInterface.

El motivo de que la interfaz tenga un único método abstracto es que será la expresión lambda la que proveerá de la implementación para dicho método.

Nótese que la interface anterior define tres métodos abstractos, sin embargo +toString():String es uno de los métodos definidos en la clase java.lang.Object y por lo tanto no cuenta para la regla de interfaces funcionales. Lo cual nos deja con dos métodos abstractos y es por ello que el compilador mostrará el error: “MiInterface is not a functional interface”

Java SE 8 define cuatro (4) grandes grupos de interfaces funcionales agrupadas en el paquete
java.util.function. A continuación veremos las principales de cada grupo:

   java.util.function.**Predicate**<T>: Define  el  método  +test(T):boolean  y  es  usada  para validación de criterios.
   		Se trata de expresiones que aceptan un parámetro y devuelven un valor lógico.
   		String message -> message.length > 50
   		
   java.util.function.**Supplier**<T>: Define el método +get():T y es usada para la creación de objetos.
   		En este caso se trata de expresiones que no tienen parámetros pero devuelven un resultado.
   		() -> return createRandomInteger()
   
   java.util.function.**Consumer**<T>: Define el método +accept(T):void y es usada para consumir métodos del parámetro T, causando posibles efectos secundarios.
   		Se trata de aquellas expresiones lambda que aceptan un solo valor y no devuelven valor alguno.
   		String message -> System.out.println(message);
   		
   java.util.function.**Function**<T, R>: Define el método +apply(T):R y es usada para convertir de un valor T a otro valor R.
		Aquellas expresiones que aceptan un argumento y devuelven un valor como resultado y cuyos tipos no tienen porque ser iguales.
		Operadores Unarios: Caso especial de funciones en las que tanto el parámetro como el valor devuelto son del mismo tipo.
			String message -> message.toLowerCase()
		Operadores Binarios: Igual que en el caso de los Operadores Unarios, se trata de un caso especial de funciones en las que los dos argumentos 
		 	y el resultado son del mismo tipo.
			(String message, String anotherMesssage) -> message.concat(anotherMessage);	
			
			
###Inferencia de tipos 

Una expresión lambda puede ser usada para crear una instancia de una interface funcional. El tipo de interface funcional es inferida de acuerdo al contexto y funciona tanto en contextos de asignación como en invocación de métodos (parámetros). Además, el compilador infiere el tipo de los parámetros de la expresión lambda basándose en la definición del método abstracto de la interface funcional y por lo tanto no hay necesidad de escribir su tipo:

List<Camisa> camisas = …

//Contexto de asignación
Predicate<String>  p = s ­> “ROJO”.equals(s);

//Contexto de invocación de  métodos
List<Camisa> lista  = filtrar(camisas, c ­> “ROJO”.equals(c.getColor())); 
 
Del anterior bloque de código podemos notar que:

_El tipo de interface funcional en el contexto de asignación o de invocación de método es inferido por el compilador basándose en el tipo de variable/parámetro al que se asignará la expresión lambda.
_En el contexto de asignación no es necesario escribir el tipo de parámetro, dado que el compilador sabe que la interface funcional java.util.function.Predicate<String> define el método +test(String):boolean y por lo tanto infiere que el parámetro es de tipo String.
_En el contexto de invocación de métodos no es necesario escribir el tipo de parámetro, dado que el compilador sabe que la interface funcional CamisaPredicate (definida para nuestro ejemplo de camisas) define el método +test(Camisa):boolean y por lo tanto infiere que el parámetro es de tipo Camisa.

De forma general, a continuación se listan los pasos que usa el compilador para inferir el tipo de una expresión lambda:

1. Identificación de contexto: asignación o invocación de método.
2. Identificar el tipo destino: variable o parámetro.
3. Identificar la interface funcional del tipo destino.
4. Identificar el descriptor de la función (firma del método abstracto).
5. Verificar que el descriptor de la función sea coherente con la expresión lambda.


### Alcance de una expresión lambda 

Las expresiones lambda pueden usar variables/parámetros en su interior si éstos han sido definidos como constantes (final) o son efectivamente constantes:

**Efectivamente Constante**: Variable/Parámetro que solo es asignado una vez, incluso si no se ha definido usando la palabra final.

Un ejemplo de lo anterior se muestra a continuación, nótese que el parámetro usado dentro de la expresión lambda no está definido como constante, pero tampoco se actualiza en alguna otra parte del método:

public static void  alcance(int num) { 
     List<String> palabras  = ...;
     Predicate<String>  odd = s ­> s.length()  > num;
     palabras.removeIf(odd);
} 

Si en alguna parte del código anterior modificamos el valor del parámetro, recibiríamos un error de compilación como el que sigue: **“local variables referenced from a lambda expression must be final or effectively final”**. Es como si la expresión lambda usara el valor más no la variable.

A diferencia de las clases anónimas, en expresiones lambda la palabra this hace referencia a la instancia de la clase sobre la cual se ha escrito la expresión lambda. Recordemos que en clases anónimas, la palabra this hace referencia a la clase anónima en sí.

El código a continuación muestra que podemos acceder al atributo de instancia nombrado before desde la expresión lambda, nótese también que el atributo de instancia no ha sido declarado como constante, pero es efectivamente constante ya que no se modifica en alguna otra parte del código:

class SessionManager {
   long before = ...;
   void expire(File  root) {
     root.listFiles(File p ­> checkExpiry(p.lastModified(),this.before)); 
   } 
   boolean checkExpiry(long time,  long expiry) { ... }
} 
 

###Referencias a métodos

Las referencias a los métodos nos permiten reutilizar un método como expresión lambda. Para hacer uso de las referencias a métodos basta con utilizar la siguiente sintáxis: referenciaObjetivo::nombreDelMetodo.

File::canRead // en lugar de File f -> f.canRead();

Con las referencias a los métodos se ofrece una anotación más rápida para expresiones lambda simples y existen 3 tipos diferentes:

1. Métodos estáticos.
	(String info) -> System.out.println(info) // Expresión lambda sin referencias.
	System.out::println // Expresión lambda con referencia a método estático.

2. Métodos de instancia de un tipo.
	(Student student, int registryIndex) -> student.getRegistry(registryIndex) // Expresión lambda sin referencias.
	Student::getRegistry // Expresión lambda con referencia a método de un tipo.

3. Métodos de instancia de un objeto existente.
	Student student -> getMarks(student) // Expresión lambda sin referencias.
	this::getMarks // Expresión lambda con referencia a método de un objeto existente. 
 
###Conclusiones

Las expresiones lambda de Java 8 nos ofrecen varias mejoras con respecto a las versiones anteriores:

1. Nos acerca a la programación funcional.
2. Hace nuestro código más preciso y legible, mejorando, en consecuencia, su mantenibilidad.
3. Su utilización junto con la API Stream hace más fácil la ejecución concurrente de tareas.


## Bibliografía
http://www.oracle.com/technetwork/es/articles/java/expresiones-lambda-api-stream-java-2633852-esa.html
https://www.adictosaltrabajo.com/tutoriales/expresiones-lambda-con-java-8/

## Ejemplo de codigo
https://www.adictosaltrabajo.com/tutoriales/expresiones-lambda-con-java-8/
https://www.arquitecturajava.com/java-8-lambda-expressions/