#  HashCode and Equals


### HashCode

Este método viene a complementar al método equals y sirve para comparar objetos de una forma más rápida en estructuras Hash ya que únicamente nos devuelve un número entero. Cuando Java compara dos objetos en estructuras de tipo hash (HashMap, HashSet etc) primero invoca al método hashcode y luego el equals. Si los métodos hashcode de cada objeto devuelven diferente hash no seguirá comparando y considerará a los objetos distintos. En el caso en el que ambos objetos compartan el mismo hashcode Java invocará al método equals() y revisará a detalle si se cumple la igualdad. De esta forma las búsquedas quedan simplificadas en estructuras hash.

El objetivo de hashCode es devolver un número entero que 'identifica' al objeto cuando se guarda en una estructura de datos conocida como HashMap (u otros como Hashtable, HashSet), cuyo objetivo es almacenar un conjunto de valores (de forma similar a un ArrayList o un arreglo). 

Al querer guardar un objeto en esta estructura, se llama al método hashCode(), como mencioné, este devuelve un número entero, que la estructura usará para decidir en cuál 'cajón' (bucket) guardará este dato. Ahora, si quiero recuperar el objeto que guardé, llamo al método hashCode nuevamente, y así determino de cuál cajón debo recuperar el objeto (como cuando guardo datos llave/valor, llama al método hashCode de la llave para obtener el valor correspondiente). El objetivo de guardar los datos de esta forma y de llamar al método es lograr almacenar y recuperar información en tiempo constante (lo cuál no ocurre siempre, pero se acerca). El que no suceda esto depende, casi siempre, del valor que devuelva el método hashCode() para cada objeto.

Supongamos que guardamos 3 objetos en esta estructura y el método hashCode de los 3 devuelve 0, esto quiere decir que los 3 objetos se gurdarán en el cajón 0. Si quiero recuperarlos, ocurrirá que debo recorrer ahora los objetos que haya guardado en este cajón para determinar cuál es el que quiero. Por lo tanto, el método hashCode() de estos objetos no es útil, pues lo que se consigue es que al guardar los elementos estos queden dispersos de forma uniforme en toda la estructura (que queden la menor cantidad de cajones vacíos y que no haya cajones donde se guarden muchos más elementos que otros).

Respecto a la implementación del método hashCode de la clase Object, el identificador native señala que es responsabilidad del compilador determinar cómo realizará esta labor. En todas las implementaciones que he revisado, de **forma nativa devuelve una representación numérica de la 'dirección de memoria' en la que se encuentra ubicado el objeto**. Esta parece una buena estrategia por defecto, pero tiene un gran problema: hay muchas más direcciones de memoria que 'número de cajones' por lo que la estructura resuelve el problema (nuevamente, esto también depende de la implementación) asignándole el cajón número hashcode()%MAX_LENGTH donde MAX_LENGTH es el tamaño máximo del arreglo. Entonces, a mayor cantidad de elementos a guardar, mayor es la probabilidad que haya cajones en la estructura que tengan exceso de elementos.

Reglas que sigue el método hashCode

1- Si el método hashCode es invocado en múltiples ocasiones durante la ejecución de una aplicación, debe regresar consistentemente el mismo valor entero, esto si la información utilizada para calcular el hashcode no ha cambiado entre invocación e invocación del método hashCode.
2- Si dos objetos son iguales según el método equals, entonces la llamada al método hashCode debe regresar el mismo hashcode.
3- No es requerido que si dos métodos no son iguales según el método equals, tengan diferentes valores hashcode.


### Equals

La implementación por defecto de la clase Object es clara: **compara referencias entre objetos**. Así que no sobreescribirlo al definir una clase es una muy mala idea, porque no habría ninguna diferencia entre llamar a equals() y usar el operador ==. La documentación es clara al señalar las características que debe tener este método al comparar:

**Reflexividad**: si comparo un objeto consigo mismo , debe retornar true. (x.equals(x) debe retornar true)
**Simetría**: si comparo un objeto A con un objeto B y retorna true, entonces la comparación del objeto B con el objeto A también debe retornar true.
	(x.equals(y) debe retornar true si y solo si y.equals(x) retorna true)
**Transitividad**: si comparo un objeto A con un objeto B y retorna true y comparo el objeto B con otro objeto C y retorna true, al comparar el objeto A con el objeto C debe retornar true. (si x.equals(y) debe retorna true y y.equals(z) retorna true entonces x.equals(z) debe retornar true)
**Consistencia**: si los objetos A y B no se modifican, llamadas sucesivas al método deben retornar el mismo valor.

La implementación del método equals de la clase Object usa la equivalencia más restrictiva posible, esto es, para cualquier referencia no nula de x e y este método retorna true si y solo si son el mismo objeto (x == y tienen la misma referencia).

Ahora bien, como se dará cuenta, el método equals() no llama al método hashCode(), entonces ¿por qué sobreescribir el método hashCode() cuando se sobreescribe el método equals()? la respuesta más sencilla es porque la documentación lo sugiere: si dos objetos son iguales, deben tener el mismo valor devuelto por hashCode(). A pesar de ser una sugerencia, nuevamente la operación en estas estructuras deja ver por qué es necesario: si dos objetos tienen el mismo hashCode, ambos objetos se guardarán en el mismo cajón, la estructura usa ahora el método equals() dentro de ese cajón para determinar cuál corresponde con el solicitado, y para eso depende de que usted haya sobreescrito el método, de lo contrario no garantiza un resultado correcto.

En resumen:

1- Si sobreescribe el método equals() es recomendable sobreescribir también el método hashCode() para conservar el contrato entre ambos métodos: dos objetos iguales deben retornar el mismo valor de hash. El método equals() no llama al método hashCode() para determinar la igualdad de dos objetos.
2- Es recomendable, por no decir obligatorio, sobreescribir el método equals() porque la implementación por defecto no es de mucha ayuda.
3- Si dos objetos no son iguales, no es necesario sobreescribir el método hashCode(), incluso, dos objetos diferentes pueden devolver valores hash iguales.
4- Si necesita guardar los objetos en las estructuras señaladas anteriormente (HashMap y similares) es absolutamente indispensable que sobreescriba el método hashCode(), de lo contrario obtendrá resultados inesperados o no deseados cuando realice operaciones de guardar, consultar o eliminar los datos.

Supongamos que hay dos ejemplares de un libro:

   Libro primerEjemplar = new Libro( );
   Libro segundoEjemplar = new Libro( );

Aunque sean dos ejemplares del mismo libro, y, por lo tanto, equivalentes para nosotros, el método equals( ) los tratará como distintos a no ser que lo sobreescribamos o sobrepasemos. Ahora bien, los libros tienen un número de identificación, ISBN, que es igual para todos los ejemplares del mismo libro. Usando este número como referencia, podemos sobreescribir equals( )

   public class Libro{
      public boolean equals(Object o){
         if(o instanceof Libro) //nos aseguramos de que el objeto en cuestión es un libro
            return ISBN.equals((Libro)o.getISBN( )); //hacemos un casting para poder usar el nuevo método     equals()
              else
                return false;
      }
   }

Veamos ahora cómo quedaría:
   
   Libro primerEjemplar = new Libro("0201914670"); //el mismo número que el ejemplo del tutorial
   Libro segundoEjemplar = new Libro("0201914670");
   if(primerEjemplar.equals(segundoEjemplar)){
   		System.out.println("Los dos objetos son iguales");
   }else{
   		System.out.println("Los objetos no son iguales");
   }
   
Ahora, los dos ejemplares del mismo libro son considerados iguales porque lo que se compara es su ISBN.

**Además, si sobreescribes el método equals( ), también debes sobreescribir el método hashCode( ) ¿Por qué?.**

El valor que devuelve el método hashCode( ) es la alocación en la memoria del objeto, expresada en un número hexadecimal. Esto significa que, antes de sobreescribir el método equals( ), dos referencias a un objeto son iguales cuando el objeto es el mismo y por tanto ocupa el mismo lugar en la memoria. Pero al sobreescribir el método equals( ), vimos antes que estamos asignando la misma referencia a dos ejemplares distintos de un mismo libro. Así que el método hashCode( ) ya no es válido a no ser que lo sobreescribamos también, porque la regla básica es que si dos objetos son iguales según equals( ), su hashCode debe ser también igual.

El hashCode viene siendo, pues, como el número de identidad de un objeto. Pero varios objetos pueden tener el mismo número de identidad. Incluso objetos distintos según equals( ).

Imaginemos una cajonera donde en un cajón guardamos sólo bolígrafos, en otro sólo lápices, en otro sólo papel, etc. Cuando queremos un bolígrafo, sabemos perfectamente a cuál cajón ir. Ése es su hashCode. Pero resulta que no queremos un bolígrafo cualquiera, si no uno con tinta verde. Ahí es donde usamos el método equals( ). Vemos que todos los bolígrafos tienen el mismo hashCode, pero no todos son iguales. Eso sí, si dos objetos son bolígrafos, se guardan en el mismo cajón.

HashCode( ) también tiene un contrato, que es como sigue:
1- Cuando durante la ejecución de una aplicación se invoque más de una vez el método hashCode( ), éste debe devolver consistentemente el mismo número, si no hay ningún cambio en equals( ). En distintas ejecuciones de la misma aplicación, el número puede variar.
2- Si dos objetos son iguales según equals( ), su hashCode es el mismo.
3- Si dos objetos son distintos según equals( ), su hashCode puede ser distinto o no.


### Ojo, mucho ojo

Si dos métodos son iguales según el método equals, el método hashCode debe regresar el mismo entero para ambos métodos. Sin embargo, si el métodos equals dice que dos métodos no son iguales, el método hashCode puede o no regresar el mismo entero.

Retornar un valor fijo en un método hashCode es una mala idea, ya que tendremos múltiples objetos con el mismo valor hashcode, lo cual no ayuda en nada a la hora de trabajar con colecciones de tipo Hash*.

Si utilizamos variables de clase de tipo transient para generar un hashcode, serializamos el objeto en cuestión y queremos recuperar el hashcode de ese método, nos encontraremos con que el hashcode será diferente al hashcode con que se serializó el objeto. Ya que este tipo de variables no se serializa. Por eso es una mala idea utilizar variables transient para generar el hashcode.

      
## Bibliografía
https://picodotdev.github.io/blog-bitix/2016/12/como-implementar-correctamente-y-por-que-los-metodos-equals-y-hashcode-de-los-objetos-java/
https://es.stackoverflow.com/questions/5641/equals-y-hashcode-java
https://www.arquitecturajava.com/entiendo-los-metodos-de-java-equals-y-hashcode/
http://javaparanulos.blogspot.com.ar/2011/12/hashcode-y-equals.html
http://www.javahispano.org/certificacion/2011/9/28/genericos-y-colecciones-parte-1-sobreescribiendo-equals-y-ha.html

## Ejemplo de codigo
https://www.geeksforgeeks.org/equals-hashcode-methods-java/
