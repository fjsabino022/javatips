## SPLITERATOR

Es un objeto especial en Java 8, en la que los **Streams** son construidos. Es una nueva interfaz que como su nombre lo indica, es un nuevo tipo de iterador que puede recorrer una coleccion de datos.
Son usados para transversar y particionar secuencias de datos.
El Spliterator no puede utilizarse sobre clases que implementan la interfaz Map.

El Spliterator puede "cortar/splittear", particionando algunos de sus elementos como otro Spliterartor. Esto permite un procesamiento paralelo de diferentes partes de una coleccion, pero hay que aclarar que el Spliterator en si mismo no provee comportamento paralelo. 


default Stream<E> stream () {
	return StreamSupport.stream(spliterator(), false);
}

Este spliterator es contruido llamando al metodo de spliterator desde la interface Collection.

El stream devuelto se basa en el spliterator.
Es una nueva interfaz en Java8 and modela el acceso a los datos de un Stream.
Puede verse como un iterador de los datos de una colecion.

ArrayList and HashSet tienen diferentes spliterators

Arraylist:
public Spliterator<E> spliterator() {
	return new ArrayListSpliterator<>(this, 0, -1, 0);
}

HashSet:
public Spliterator<E> spliterator() {
	return new HashMap.KeySpliterator<E, Object>(map, 0, -1, 0, 0);
}

Un stream es dividido en dos partes:
1- Un objeto para acceder a los datos, que es llamado **Spliterator**. Este tiene significado ser sobreescrito para satisfacer nuestras necesidades.
2- Un objeto que se encarga de procesar los datos del stream llamado **ReferencePipeline**. Es un objeto muy complejo y nosotros no nocesitamos sobreescribirlo.

Un iterador en Java posee metodos como por ejemplo: next(), hasNext() y remove.
Ahora podemos ver los siguientes metodos de la interfaz spliterator:

1- **tryAdvance(Consumer)**: Es el principal metodo de la interfaz y se utiliza para recorrer la secuencia de datos. Este metodo toma un Consumer como parametro y se utiliza este consumer para consumir los elementos del Spliterator uno a uno secuencialmente. Retorna false si no hay elementos para recorrer. Se utiliza para iterar elementos individualmente in multiples hilos paar soportar el procesamiento paralelo.

2- **trySplit()**: Se utiliza para que el Spliterator pueda dividirse asi mismo para soportar el procesamiento paralelo.

3. **estiamteSize()**: Retorna un estimado del numero de elementos que se pueden encontrar por el metodo forEachRemaining() or Long.Max_Value si el valor es infinito, no se sabe la cantidad o es muy costoso para computar.

4- **characteristics()**: Retorna un set de caracteristicas del Spliterator y sus elementos.

El spliterator sostiene la logica de acceso a los datos de un stream y los datos de un stream pueden ser infinitos, y puede que no sea seguro si todavia tiene objetos para consumir.
El concepto de stream es muy muy diferente al concepto de colecciones en Java.


## Bibliografía
http://www.baeldung.com/java-spliterator
https://blog.rapid7.com/2015/10/28/java-8-introduction-to-parallelism-and-spliterator/
https://www.journaldev.com/13521/java-spliterator
