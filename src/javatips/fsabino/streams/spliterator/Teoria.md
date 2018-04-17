## SPLITERATOR

Es un objeto especial en Java 8, en la que los **Streams** son construidos.

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
1- tryAdvance(Consumer)
2- trySplit()
3. estiamteSize()
4- characteristics()

El spliterator sostiene la logica de acceso a los datos de un stream y los datos de un stream pueden ser infinitos, y puede que no sea seguro si todavia tiene objetos para consumir.
El concepto de stream es muy muy diferente al concepto de colecciones en Java.







