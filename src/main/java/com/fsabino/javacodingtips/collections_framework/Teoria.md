# Java Collections Framework 

Java tiene desde la versión 1.2 todo un juego de clases e interfaces para guardar colecciones de objetos. En él, todas las entidades conceptuales están representadas por interfaces, y las clases se usan para proveer implementaciones de esas interfaces. Una introducción conceptual debe entonces enfocarse primero en esas interfaces.

La interfaz nos dice qué podemos hacer con un objeto. Un objeto que cumple determinada interfaz es “algo con lo que puedo hacer X”. La interfaz no es la descripción entera del objeto, solamente un mínimo de funcionalidad con la que debe cumplir.

Como corresponde a un lenguaje tan orientado a objetos, estas clases e interfaces están estructuradas en una jerarquía. A medida que se va descendiendo a niveles más específicos aumentan los requerimientos y lo que se le pide a ese objeto que sepa hacer.


## Collection

La interfaz más importante es Collection. Una Collection es todo aquello que se puede recorrer (o “iterar”) y de lo que se puede saber el tamaño. Muchas otras clases extenderán Collection imponiendo más restricciones y dando más funcionalidades. Es de notar que el requisito de “que se sepa el tamaño” hace inconveniente utilizar estas clases con colecciones de objetos de las que no se sepa “a priori” la cantidad (ésto podría considerarse una limitación de este framework).

Las operaciones básicas de una collection entonces son:

1. **add(T)**: Añade un elemento.
2. **iterator()**: Obtiene un “iterador” que permite recorrer la colección visitando cada elemento una vez.
3. **size()**: Obtiene la cantidad de elementos que esta colección almacena.
4. **contains(t)**: Pregunta si el elemento t ya está dentro de la colección.

Una capacidad de un objeto Collection es la de poder ser recorrido. Como a este nivel no está definido un orden, la única manera es proveyendo un iterador, mediante el método iterator(). Un iterador es un objeto “paseador” que nos permite ir obteniendo todos los objetos al ir invocando progresivamente su método next(). También, si la colección es modificable, podemos remover un objeto durante el recorrido mediante el método remove() del iterador.

Existen 3 interfaces que implementan la interfaz Collection y son: List, Set y Queue.


### List

Un List, o simplemente lista, es una Collection. La diferencia que tiene una lista con una Collection es que la lista mantiene un orden arbitrario de los elementos y permite acceder a los elementos por orden. Podríamos decir que en una lista, por lo general, el orden es dato. Es decir, el orden es información importante que la lista también nos está almacenando.

No hay ningún método en Collection para obtener el tercer elemento. No lo puede haber porque, como se dijo, a nivel Collection ni siquiera estamos seguros de que si volvemos a recorrer la colección los elementos aparecerán en el mismo orden. Una lista sí debe permitir acceder al tercer elemento, por eso se añaden los siguientes métodos:

**get(int i)**: Obtiene el elemento en la posición i.
**set(int i, T t)**: Pone al elemento t en la posición i.

La interfaz List sí admite elementos duplicados. A parte de los métodos heredados de Collection, añade métodos que permiten mejorar los siguientes puntos:

1. Acceso posicional a elementos: manipula elementos en función de su posición en la lista.
2. Búsqueda de elementos: busca un elemento concreto de la lista y devuelve su posición.
3. Iteración sobre elementos: mejora el Iterator por defecto.
4. Rango de operación: permite realizar ciertas operaciones sobre ragos de elementos dentro de la propia lista.

En Resumen:
La interfaz List es una coleccion ordenada en donde los elementos duplicados estan permitidos.
Los elementos son almacenados en forma secuencial y estos elementos pueden ser accedidos a traves de un valor de indice.

Implmentaciones de la interfaz list:
-ArrayList
-LinkedList
-Vector

Declaración
public interface List<E> extends Collection<E>  


#### Implementación List: ArrayList

Se basa en un array redimensionable que aumenta su tamaño según crece la colección de elementos. Es la que mejor rendimiento tiene sobre la mayoría de situaciones.
La ventaja de ArrayList por sobre un array común es que es expansible, es decir que crece a medida que se le añaden elementos (mientras que el tamaño de un array es fijo desde su creación). Lo bueno es que el tiempo de acceso a un elemento en particular es ínfimo. Lo malo es que si queremos eliminar un elemento del principio, o del medio, la clase debe mover todos los que le siguen a la posición anterior, para “tapar” el agujero que deja el elemento removido. Esto hace que sacar elementos del medio o del principio sea costoso.

Los puntos importantes son:
1. Puede contener elementos duplicados.
2. Mantiene el orden de objetos insertados.
3. Es una clase no sincronizada.
4. Permite acceso aleatorio porque el arreglo trabaja con un indice que permite el acceso a los elementos.
5. La manipulacion es lenta porque se necesitaran muchos recursos si uno de los elementos del arreglo es eliminado (salvo el ultimo elemento de la lista)

Declaracion
public class ArrayList<E> extends AbstractList<E> implements List<E>, RandomAccess, Cloneable, Serializable 


#### Implementación List: LinkedList

Esta implementación se basa en una lista doblemente enlazada de los elementos, teniendo cada uno de los elementos un puntero al anterior y al siguiente elemento.
Los elementos son mantenidos en una serie de nodos atados entre sí como eslabones de una cadena. Cada uno de estos nodos apunta a su antecesor y al elemento que le sigue. No hay nada en cada uno de esos nodos que tenga algo que ver con la posición en la lista. Para obtener el elemento número “n”, esta implementación de List necesita entonces empezar desde el comienzo, desde el primer nodo, e ir avanzando al “siguiente” n veces. Buscar el elemento 400 entonces implica 400 de esos pasitos. La ventaja es que es posible eliminar elementos del principio de la lista y del medio de manera muy eficiente. Para eliminar un elemento solamente hay que modificar a sus dos “vecinos” para que se “conecten” entre sí ignorando al elemento que se está borrando. Como en una cadena, se retira un eslabón abriendo los eslabones adyacentes al que se eliminá y cerrándolos de modo que lo excluyan. No es necesario hacerle ningún cambio al resto de los elementos de la lista.

Su método get(int) es particularmente lento porque, como dije, necesita recorrer para llegar al elemento pedido. Esto hace que recorrer la lista con un simple for(int i = 0 ; i < lista.size(); i++) sea tremendamente lento! La complejidad pasa de ser lineal a cuadrática, es decir: Si se recorre así una lista de 300 elementos, se tarda como si tuviera 44.850 elementos! Una LinkedList sólo debe recorrerse mediante iteradores.

Los puntos importantes son:
1. Puede contener elementos duplicados.
2. Mantiene el orden de objetos insertados.
3. Es una clase no sincronizada.
4. La manipulacion es muy rapida ya que no necesita recursos cuando se realiza.
5. Puede ser usada como lista, cola o pila.
6. El acceso a un elemento particular de LinkedList es muy costoso.

Declaracion
public class LinkedList<E> extends AbstractSequentialList<E> implements List<E>, Deque<E>, Cloneable, Serializable  


|  Array List                            |  LinkedLIst               |
|  Position  | Initial | Middle |  End   |  Initial | Middle |  End  |
|  get       | 0(1)    | 0(1)   |  0(1)  |  0(1)    | 0(n/2) |  0(n) |
|  remove    | 0(n)    | 0(n/2) |  0(1)  |  0(1)    | 0(1)   |  0(1) |
|  add       | 0(n)    | 0(n/2) |  0(1)  |  0(1)    | 0(1)   |  0(1) |

"Indexing" as a separate operation. So insertion is itself O(1), but getting to that middle node is O(n).

https://beginnersbook.com/2013/12/difference-between-arraylist-and-linkedlist-in-java/

### Set

La interfaz Set define una colección que no puede contener elementos duplicados. Esta interfaz contiene, únicamente, los métodos heredados de Collection añadiendo la restricción de que los elementos duplicados están prohibidos. Es importante destacar que, para comprobar si los elementos son elementos duplicados o no lo son, es necesario que dichos elementos tengan implementada, de forma correcta, los métodos **equals y hashCode**. Para comprobar si dos Set son iguales, se comprobarán si todos los elementos que los componen son iguales sin importar en el orden que ocupen dichos elementos.

En un set el orden no es dato. Si bien es posible que existan sets que nos aseguren un orden determinado cuando los recorremos (por ejemplo obtener strings en orden alfabético), ese orden no es arbitrario y decidido por nosotros, ya que la interfaz Set no tienen ninguna funcionalidad para manipularlo (como si lo admite la interfaz List).

La ventaja de utilizar Sets es que preguntar si un elemento ya está contenido mediante **“contains()”** suele ser muy **eficiente**. Entonces es conveniente utilizarlos cada vez que necesitemos una colección en la que no importe el orden, pero que necesitemos preguntar si un elemento está o no.

Como, a diferencia de Collection, **el orden no necesariamente es preservado**, no existen métodos para “obtener el primer elemento”.

En Resumen:
1. Coleccion desordenada.
2. No mantiene un orden cuando se guardan los elementos.
3. No permite elementros duplicados.
4. No es sincronizada. (no se garantiza el estado del Set si dos o más hilos acceden de forma concurrente al mismo)

Implmentaciones de la interfaz list:
-HashSet
-LinkedHashSet
-TreeSet

Declaración
public interface Set<E> extends Collection<E>  


#### Implementación Set: HashSet

Este implementación almacena los elementos en una tabla hash. Es la implementación con mejor rendimiento de todas pero no garantiza ningún orden a la hora de realizar iteraciones. Es la implementación más empleada debido a su rendimiento y a que, generalmente, no nos importa el orden que ocupen los elementos. Esta implementación proporciona tiempos constantes en las operaciones básicas siempre y cuando la función hash disperse de forma correcta los elementos dentro de la tabla hash. Es importante definir el tamaño inicial de la tabla ya que este tamaño marcará el rendimiento de esta implementación.

Los Sets (y los Maps) aprovechan cierta cosa característica de Java: Todos los objetos heredan de Object, por lo tanto todos los métodos de la clase Object están presentes en todos los objetos. 
Dicho de otra manera, hay ciertas cosas que todo objeto en Java sabe hacer. Dos de estas cosas son:

1. Saber si es igual a otro, con su método **equals()**.
2. Devolver un número entero de modo tal que si dos objetos son iguales ese número también lo será (se conoce esto como un hash). Esto todo objeto lo sabe hacer con su método **hashCode()**.

La clase HashSet aprovecha la segunda de las funciones. A cada objeto que se añade a la colección se le pide que calcule su “hash”. Este valor será un número entre -2147483647 y 2147483648. Basado en ese valor se lo guarda en una tabla. Más tarde, cuando se pregunta con **contains()** si un objeto x ya está, habrá que saber si está en esa tabla. ¿En qué posición de la tabla está? HashSet puede saberlo, ya que para un objeto determinado, el hash siempre va a tener el mismo valor. Entonces la función contains de HashSet saca el hash del objeto que le pasan y va con eso a la tabla. En la posición de la tabla hay una lista de objetos que tienen ese valor de hash, y si uno de esos es el buscado contains devuelve true.

Un efecto de este algoritmo es que el orden en el que aparecen los objetos al recorrer el set es impredecible. También es importante darse cuenta de que es crítico que la función hashCode() tiene que devolver siempre el mismo valor para los objetos que se consideran iguales (o sea que equals() da true). Si esto no es así, HashSet pondrá al objeto en una posición distinta en la tabla que la que más adelante consultará cuando se llame a contains, y entonces contains dará siempre falso, por más que se haya hecho correctamente el add. Esto mismo puede suceder si se usan como claves objetos que varíen.

Los puntos importantes son:
1. Los elementos se guardan usando el mecanismo llamado **hashing**. 
2. Contiene elementos unicos. Si se intenta agregar un elemento duplicado en el HashSet, el valor viejo será sobre-escrito.
3. No es sincronizada.
4. Permite elementos nulos. Si existe ya el elemento NULL en la coleccion, al intentar agregar uno nuevo, siempre se devolvera el mismo.
5. No se mantiene orden alguno. Los elementos pueden ser retornados de forma aleatoria.

Declaración
public class HashSet<E> extends AbstractSet<E> implements Set<E>, Cloneable, Serializable  

#### Implementación Set: LinkedHashSet

Esta implementación almacena los elementos en función del orden de inserción. Es, simplemente, un poco más costosa que HashSet.
Es un HashTable and Linked list implementacion de la interfaz Set.

Los puntos importantes son:
1. Mantiene el orden de inserción. Los elementos son ordenados en la misma secuencia en la que los elementos han sido agregados al Set.
2. Contiene elementos unicos, no permite duplicados.
3. Permite elementos nulos.

Declaración
public class LinkedHashSet<E> extends HashSet<E> implements Set<E>, Cloneable, Serializable  

#### Implementación Set: TreeSet

Esta implementación almacena los elementos ordenándolos en función de sus valores. Es bastante más lento que HashSet. Los elementos almacenados deben implementar la interfaz Comparable. 

Antes de entrar en la descripción de TreeSet vaya una breve explicación. Otra cosa que pueden saber hacer los objetos con independencia de cómo y dónde son usados es saber ordenarse. A diferencia de “equals” y “hashCode”, que están en todos los objetos, la capacidad de “ordernarse” está sólo en aquellos que implementan la interfaz Comparable. Cuando un objeto implementa esta interfaz promete saber compararse con otros (con el método **compareTo()**), y responder con este método si él está antes, después o es igual al objeto que se le pasa como parámetro. Al orden resultante de usar este método se le llama en Java “orden natural”. Muchas de las clases de Java implementan Comparable, por ejemplo String lo hace, definiendo un orden natural de los strings que es el obvio, el alfabético. También implementan esta interfaz Date, Number, etc. y los “órdenes naturales” que definen estas implementaciones también son los que uno esperaría.

Si yo creo una clase mía llamada Alumno, queda a mi cargo, si así lo quiero, la definición de un orden natural para los alumnos. Puedo elegir usar el apellido, el nombre, el número de matrícula, etc. De acuerdo al atributo que elija para definir el orden natural codificaré el método compareTo(). Lo que es importante es que la definición de este método sea compatible con el **equals()**; esto es que **a.equals(b)** si y sólo si **a.compareTo(b) == 0**.

TreeSet usa una técnica completamente diferente a la explicada para HashSet. Construye un árbol con los objetos que se van agregando al conjunto. Un árbol es una forma en computación de tener un conjunto de cosas todo el tiempo en orden, y permitir que se agreguen más cosas y que el orden se mantenga.

Una ventaja de TreeSet es que el orden en el que aparecen los elementos al recorrerlos es el orden natural de ellos (los objetos deberán implementar Comparable, como lo explico arriba; si no lo hacen se deberá especificar una función de comparación manualmente). Una desventaja es que mantener todo ordenado tiene un costo, y esta clase es un poquito menos eficiente que HashSet.

Los puntos importantes son:
1. Peomite elemento null.
2. No es sincronizada.
3. Mantiene el orden de los elementos de forma ascendente.
4. Contiene elementos unicos.

Declaración
public class TreeSet<E> extends AbstractSet<E> implements NavigableSet<E>, Cloneable, Serializable  


## Map

La interfaz Map asocia claves a valores. Esta interfaz no puede contener claves duplicadas y cada una de dichas claves, sólo puede tener asociado un valor como máximo.
Ninguna de las implementaciones de esta interfaz son sincronizadas; es decir, no se garantiza el estado del Map si dos o más hilos acceden de forma concurrente al mismo

Un Map es un conjunto de valores, con el detalle de que cada uno de estos valores tiene un objeto extra asociado. A los primeros se los llama “claves” o “keys”, ya que nos permiten acceder a los segundos.
Cuando digo que las claves forman un conjunto, lo digo en el sentido Java: Son un “Set”, no puede haber duplicados. 

Un Map no es una Collection ya que esa interfaz le queda demasiado chica. Podríamos decir que Collection es unidimensional, mientras que un Map es bidimensional. No hay una manera trivial de expresar un Map en una simple serie de objetos que podemos recorrer. Sí podríamos recorrer una serie de objetos si cada uno de ellos representase un par {clave, valor} (y de hecho eso se puede hacer). Pero esta forma de recorrer un Map no es la forma primaria en que se usa.

Algunos de los métodos más importantes de un Map son:

**get(Object clave)**: Obtiene el valor correspondiente a una clave. Devuelve null si no existe esa clave en el map.
**put(K clave, V valor)**: Añade un par clave-valor al map. Si ya había un valor para esa clave se lo reemplaza.

Además hay algunas funciones que son útiles a la hora de recorrer eficientemente el contenido de un Map:

**keySet()**: Todas las claves (devuelve un Set, es decir, sin duplicados).
**values()**: Todos los valores (los valores sí pueden estar duplicados, por lo tanto esta función devuelve una Collection).
**entrySet()**: Todos los pares clave-valor (devuelve un conjunto de objetos Map.Entry, cada uno delos cuales devuelve la clave y el valor con los métodos getKey() y getValue() respectivamente).

Puntos a tener en cuenta:
1. Mapa clave-valor.
2. No existen elementos duplicados.

Implementaciones:
1. HashMap
2. Hashtable
3. TreeMap


#### Implementación Map: HashMap

Esta implementación almacena las claves en una tabla hash (implementa la interfaz Map utilizando el HashTable). Es la implementación con mejor rendimiento de todas pero no garantiza ningún orden a la hora de realizar iteraciones. Esta implementación proporciona tiempos constantes en las operaciones básicas siempre y cuando la función hash disperse de forma correcta los elementos dentro de la tabla hash. Es importante definir el tamaño inicial de la tabla ya que este tamaño marcará el rendimiento de esta implementación.

Esta clase no garantiza como será el orden del mapa. Es similar a HashTable excepto que este no sincronizada y permite valores nulos (clave nula y valores nulos).
Es una coleccion no ordenada que significa que no retorna las clave-valor en el mismo orden en el que fueron insertadas dentro del HashMap.

Los puntos importantes son:
1. Contiene valores relacionados a una Key.
2. Contiene elementos unicos, no permite duplicados.
3. Puede tener una unica key null, y muchos valores nulos.
4. No mantiene el orden de insercion.
5. HashMap is a non-synchronized

Declaración:
public class HashMap<K,V> extends AbstractMap<K,V> implements Map<K,V>, Cloneable, Serializable  


#### Implementación Map: TreeMap

Esta implementación almacena las claves ordenándolas en función de sus valores. Es bastante más lento que HashMap. Las claves almacenadas deben implementar la interfaz Comparable.

TreeMap implementa la interfaz Map utilizando un arbol. Proporciona un medio eficiente para almacenar pares clave / valor en orden ordenado. Esta ordenado de acuerdo al orden natural de las claves. TreeMap no es una coleccion sincronizada.

Los puntos importantes son:
1. Contiene valores relacionados a una key.
2. Contiene solo elementos unicos.
3. No puede contener claves nulas, pero si puede contener multiples valores nulos.
4. Es igual a HashMap solamente que mantiene un order ascendente de las claves.

Declaracion
public class TreeMap<K,V> extends AbstractMap<K,V> implements NavigableMap<K,V>, Cloneable, Serializable  

#### Implementación Map: LinkedHashMap

Esta implementación almacena las claves en función del orden de inserción. Es, simplemente, un poco más costosa que HashMap
Mantiene una lista doblemente enlanzada ejecutandose mediante todas las claves. Este enlace define la iteración del orden, que es normalmente el orden en que las claves han sifdo insertadas en el mapa.

Los puntos importantes son:
1. Contiene valores relacionadas a una key.
2. Contiene solo elementos unicos, no permite claves duplicadas.
3. Puede tener una clave nula, y multiples valores nulos.
4. Es igual al HashMap solamente que mantiene el orden de inserción.

Declaracion
public class LinkedHashMap<K,V> extends HashMap<K,V> implements Map<K,V>  

## Bibliografía
http://www.reloco.com.ar/prog/java/collections.html
https://www.adictosaltrabajo.com/tutoriales/introduccion-a-colecciones-en-java/
https://www.javatpoint.com/java-list
https://beginnersbook.com/2013/12/difference-between-arraylist-and-linkedlist-in-java/
https://www.aprenderaprogramar.com/index.php?option=com_content&view=article&id=605:interface-list-clase-linkedlist-api-java-ejercicio-diferencias-entre-arraylist-y-linkedlist-codigo-cu00921c&catid=58&Itemid=180

## Ejemplo de codigo
https://beginnersbook.com/java-collections-tutorials/#2