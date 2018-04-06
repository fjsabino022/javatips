# Lambda

Por medio de expresiones lambda podemos referenciar métodos anónimos o métodos sin nombre, lo que nos permite escribir código más claro y conciso que  cuando usamos clases anónimas. Una expresión lambda se compone de:

   Listado de parámetros separados por comas y encerrados en paréntesis, por ejemplo: (a,b).
   El símbolo de flecha hacia la derecha: ->
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

Nótese que la interface anterior define tres métodos abstractos, sin embargo +toString():String es uno de los métodos definidos en la clase java.lang.Object y por lo tanto no cuenta para la regla de interfaces funcionales. Lo cual nos deja con dos métodos abstractos y es por ello que el compilador mostrará el error: “MiInterface is not a functional interface”

Java SE 8 define cuatro (4) grandes grupos de interfaces funcionales agrupadas en el paquete
java.util.function. A continuación veremos las principales de cada grupo:

   java.util.function.**Predicate**<T>: Define  el  método  +test(T):boolean  y  es  usada  para validación de criterios.
   java.util.function.**Supplier**<T>: Define el método +get():T y es usada para la creación de objetos.
   java.util.function.**Consumer**<T>: Define el método +accept(T):void y es usada para consumir métodos del parámetro T, causando posibles efectos secundarios.
   java.util.function.**Function**<T, R>: Define el método +apply(T):R y es usada para convertir de un valor T a otro valor R.


## Bibliografía
http://www.oracle.com/technetwork/es/articles/java/expresiones-lambda-api-stream-java-2633852-esa.html
https://www.adictosaltrabajo.com/tutoriales/expresiones-lambda-con-java-8/

## Ejemplo de codigo
