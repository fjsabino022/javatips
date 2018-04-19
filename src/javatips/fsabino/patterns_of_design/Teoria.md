# Patrones de Diseño

Los **patrones de diseño** son unas técnicas para resolver problemas comunes en el desarrollo de software y otros ámbitos referentes al diseño de interacción o interfaces.

Un patrón de diseño resulta ser una solución a un problema de diseño. Para que una solución sea considerada un patrón debe poseer ciertas características. Una de ellas es que debe haber comprobado su efectividad resolviendo problemas similares en ocasiones anteriores. Otra es que debe ser reutilizable, lo que significa que es aplicable a diferentes problemas de diseño en distintas circunstancias.

Los patrones de diseño pretenden:

- Proporcionar catálogos de elementos reusables en el diseño de sistemas software.
- Evitar la reiteración en la búsqueda de soluciones a problemas ya conocidos y solucionados anteriormente.
- Formalizar un vocabulario común entre diseñadores.
- Estandarizar el modo en que se realiza el diseño.
- Facilitar el aprendizaje de las nuevas generaciones de diseñadores condensando conocimiento ya existente.

Asimismo, no pretenden:

- Imponer ciertas alternativas de diseño frente a otras.
- Eliminar la creatividad inherente al proceso de diseño.
- No es obligatorio utilizar los patrones, solo es aconsejable en el caso de tener el mismo problema o similar que soluciona el patrón, siempre teniendo en cuenta que en un caso particular puede no ser aplicable. "Abusar o forzar el uso de los patrones puede ser un error".


### Categorías de patrones

**Patrones de arquitectura**: Aquellos que expresan un esquema organizativo estructural fundamental para sistemas de software.
**Patrones de diseño**: Aquellos que expresan esquemas para definir estructuras de diseño (o sus relaciones) con las que construir sistemas de software.
**Dialectos**: Patrones de bajo nivel específicos para un lenguaje de programación o entorno concreto.

Además, también es importante reseñar el concepto de "**antipatrón de diseño**", que con forma semejante a la de un patrón, intenta prevenir contra errores comunes de diseño en el software. La idea de los antipatrones es dar a conocer los problemas que acarrean ciertos diseños muy frecuentes, para intentar evitar que diferentes sistemas acaben una y otra vez en el mismo callejón sin salida por haber cometido los mismos errores.


### Patrones creacionales

Corresponden a patrones de diseño de software que solucionan problemas de creación de instancias. Nos ayudan a encapsular y abstraer dicha creación:

**Object Pool** (no pertenece a los patrones especificados por GoF): se obtienen objetos nuevos a través de la clonación. Utilizado cuando el costo de crear una clase es mayor que el de clonarla. Especialmente con objetos muy complejos. Se especifica un tipo de objeto a crear y se utiliza una interfaz del prototipo para crear un nuevo objeto por clonación. El proceso de clonación se inicia instanciando un tipo de objeto de la clase que queremos clonar.
**Abstract Factory** (fábrica abstracta): permite trabajar con objetos de distintas familias de manera que las familias no se mezclen entre sí y haciendo transparente el tipo de familia concreta que se esté usando. El problema a solucionar por este patrón es el de crear diferentes familias de objetos, como por ejemplo, la creación de interfaces gráficas de distintos tipos (ventana, menú, botón, etc.).
**Builder (constructor virtual)**: abstrae el proceso de creación de un objeto complejo, centralizando dicho proceso en un único punto.
**Factory Method (método de fabricación)**: centraliza en una clase constructora la creación de objetos de un subtipo de un tipo determinado, ocultando al usuario la casuística, es decir, la diversidad de casos particulares que se pueden prever, para elegir el subtipo que crear. Parte del principio de que las subclases determinan la clase a implementar. A continuación se muestra un ejemplo de este patrón:
**Prototype (prototipo)**: crea nuevos objetos clonándolos de una instancia ya existente.
**Singleton (instancia única)**: garantiza la existencia de una única instancia para una clase y la creación de un mecanismo de acceso global a dicha instancia. Restringe la instanciación de una clase o valor de un tipo a un solo objeto.
**Model View Controller (MVC)**: Modelo Vista Controlador. Es un patrón de arquitectura de software que separa los datos y la lógica de negocio de una aplicación de la interfaz de usuario y el módulo encargado de gestionar los eventos y las comunicaciones. Este patrón plantea la separación del problema en tres capas: la capa model, que representa la realidad; la capa controller , que conoce los métodos y atributos del modelo, recibe y realiza lo que el usuario quiere hacer; y la capa vista, que muestra un aspecto del modelo y es utilizada por la capa anterior para interactuar con el usuario.

### Patrones estructurales

Son los patrones de diseño software que solucionan problemas de composición (agregación) de clases y objetos:

**Adapter o Wrapper (Adaptador o Envoltorio)**: Adapta una interfaz para que pueda ser utilizada por una clase que de otro modo no podría utilizarla.
**Bridge (Puente)**: Desacopla una abstracción de su implementación.
**Composite (Objeto compuesto)**: Permite tratar objetos compuestos como si de uno simple se tratase.
**Decorator (Decorador)**: Añade funcionalidad a una clase dinámicamente.
**Facade (Fachada)**: Provee de una interfaz unificada simple para acceder a una interfaz o grupo de interfaces de un subsistema.
**Flyweight (Peso ligero)**: Reduce la redundancia cuando gran cantidad de objetos poseen idéntica información.
**Proxy**: Proporciona un intermediario de un objeto para controlar su acceso.
**Module**: Agrupa varios elementos relacionados, como clases, singletons, y métodos, utilizados globalmente, en una entidad única.

### Patrones de comportamiento

Se definen como patrones de diseño software que ofrecen soluciones respecto a la interacción y responsabilidades entre clases y objetos, así como los algoritmos que encapsulan:

**Chain of Responsibility (Cadena de responsabilidad)**: Permite establecer la línea que deben llevar los mensajes para que los objetos realicen la tarea indicada.
**Command (Orden)**: Encapsula una operación en un objeto, permitiendo ejecutar dicha operación sin necesidad de conocer el contenido de la misma.
**Interpreter (Intérprete)**: Dado un lenguaje, define una gramática para dicho lenguaje, así como las herramientas necesarias para interpretarlo.
**Iterator (Iterador)**: Permite realizar recorridos sobre objetos compuestos independientemente de la implementación de estos.
**Mediator (Mediador)**: Define un objeto que coordine la comunicación entre objetos de distintas clases, pero que funcionan como un conjunto.
**Memento (Recuerdo)**: Permite volver a estados anteriores del sistema.
**Observer (Observador)**: Define una dependencia de uno-a-muchos entre objetos, de forma que cuando un objeto cambie de estado se notifique y actualicen automáticamente todos los objetos que dependen de él.
**State (Estado)**: Permite que un objeto modifique su comportamiento cada vez que cambie su estado interno.
**Strategy (Estrategia)**: Permite disponer de varios métodos para resolver un problema y elegir cuál utilizar en tiempo de ejecución.
**Template Method (Método plantilla)**: Define en una operación el esqueleto de un algoritmo, delegando en las subclases algunos de sus pasos, esto permite que las subclases redefinan ciertos pasos de un algoritmo sin cambiar su estructura.
**Visitor (Visitante)**: Permite definir nuevas operaciones sobre una jerarquía de clases sin modificar las clases sobre las que opera.


# PATRONES DE CREACION


## SINGLETON (ÚNICO)

Es un patron que esta en des-uso ya que con la inyeccion de dependencias se ha sustituido.

private static Singleton s = null; --> Creacion bajo demanda. (creacion perezosa) Lo crea cuando alguien lo necesita.
private static Singleton s = new Singleton(); --> Se crea cuando se inicia el sistema. (creacion temprana)

1. Atributo estatico privado que sea del mismo tipo de la clase.
2. Constructor de la clase privado, para que nadie "sin querer" me haga el "new" de la clase y no se cumple la instancia unica.
3. Metodo estatico publico que devuelve la propia instancia del paso 1.

**Propósito**: Asegurar que una clase tenga una única instancia y proporcionar un punto de acceso global a la misma. El cliente llama a la función de acceso cuando se requiere una referencia a la instancia única.

Ejemplo de su uso: Runtime, Logger, Spring Beans, Graphic Managers.

Video: https://www.youtube.com/watch?v=fv2YXziJzxw


## ABSTRACT FACTORY (FABRICA ABSTRACTA)

Familias que crean productos abstractos. Los clientes no pueden crear productos abstractos porque los mismos son abtractos.
Proporciona una interface para crear familias de objetos relacionados.
Cada producto es de una sola familia, no puede existir a varias familias.
El cleinte no sabra con que familai estas trabajando.

**Propósito**: Proveer una interfaz para la creación de familias o objetos dependientes relacionados, sin especificar sus clases concretas. 

Es una jerarquía que encapsula muchas familias posibles y la creación de un conjunto de productos. 
El objeto "**fábrica**" tiene la responsabilidad de proporcionar servicios de creación para toda una familia de productos. 
Los "**clientes**" nunca crean directamente los objetos de la familia, piden la fábrica que los cree por ellos.

Aplicación: 

1. Cuando tenemos una o múltiples familias de productos.
2. Cuando tenemos muchos objetos que pueden ser cambiados o agregados durante el tiempo de ejecución.
3. Cuando queremos obtener un objeto compuesto de otros objetos, los cuales desconocemos a que clase pertenecen.
4. Para encapsular la creación de muchos objetos.

Video: https://www.youtube.com/watch?v=ruN4JRd9IGk


## FACTORY METHOD (FACTORIA)

Poder contruir objetos sin saber lo que estamos creando. Por ejemplo podríamos hacer un "createFigura" sin saber que figura estamos creando.
Tendriamos un producto abstracto y un conjunto de productos concretos. Se debe crear una estrutura paralela para la creacion de los productos. Se debera tener un "creador" abtracto para cada producto abstracto y un "creador" concreto para cada producto concreto. El cliente utilizada el creador abstracto. El factory principal tendra una instancia de producto sin saber que producto es y ademas tendra una instancia de creador sin saber que tipo de creador es.
Cada vez que hay un nuevo producto se debe crear la clase concreta del producto y a su vez la clase concreta creadora de ese producto.

Video: https://www.youtube.com/watch?v=UvoHIDs3YmE


## BUILDER (CONSTRUCTOR)

Permite tener una politica general de creacion de objetos, centralizandolo en una clase contructora.
Se utiliza uando tenemos que contruir un objeto complejo (por ejemplo el contructor tiene muchos atributos y no sabemos cual es cual  y ademas tenemos muchos construcotres en la clase para las distintas combinaciones de contructores)
t

**Propósito**: Separar la construcción de un objeto complejo de su representación para que el mismo proceso de construcción puede crear diferentes representaciones.

Nos permite crear un objeto que está compuesto por muchoso otros objetos. Sólo el "Builder" conoce a detalle las clases concretas de los objetos que serán creados, nadie más.

En este patrón intervienen un "Director" y un "Builder". El "Director" invoca los servicios del "Builder" el cual va creando las partes de un objeto complejo y al mismo tiempo guardo un estado intermedio de la construcción del objeto. Cuando el producto se ha construido por completo el cliente recupera el resultado.

A diferencia de otros patrones creacionales que construyen productos de una sola vez, el patrón "Builder" construye paso a paso los productos bajo el control del "Director".

Aplicación:

1- Construir un objeto compuesto de otros objetos.
2- Que la creación de las partes de un objeto sea independiente del objeto principal.
3- Ocultar la creación de las partes de un objeto del cliente, de esta manera no existe dependencia entre el cliente y las partes.

Ejemplo de este patron son las clases StringBuilder, DocumentBuilder y Locale.Builder.

Video: https://www.youtube.com/watch?v=ifw8rBmvnWw


## PROTOTYPE (CLONACIÓN)

**Propósito**: Especificar varios tipos de objetos que pueden ser creados en un prototipo para crear nuevos objetos copiando ese prototipo. Reduce la necesidad de crear subclases.

Aplicación

1- Queremos crear nuevos objetos mediante la clonación o copia de otros.
2- Cuando tenemos muchas clases potenciales que queremos usar sólo si son requeridas durante el tiempo de ejecución.

*Clonacion superficial vs Clonacion profunda*
**Superficial**: Cuando se clona el objeto pero el nuevo objeto es la misma instancia del anterior, es el mismo objeto.
**Clonacion**: Cuando se clona el objeto pero el nuevo objeto es una nueva instancia con los valores clonados.

# PATRONES DE COMPORTAMIENTO


## OBSERVER

**Propósito**: Defina una dependencia de uno a muchos entre los objetos de manera que cuando un objeto cambia de estado, todos los que dependen de él son notificados y se actualizan automáticamente.

Los **Observers** se registran con el **Subject** a medida que se crean. Siempre que el Subject cambie, difundirá a todos los Observers registrados que ha cambiado, y cada Observer consulta al Subject que supervisa para obtener el cambio de estado que se haya generado.

En Java tenemos acceso a la clase Observer mediante java.util.Observer.

Aplicación: Usamos el patrón Observer cuando...

1. Un cambio en un objeto requiere cambiar los demás, pero no sabemos cuántos objetos hay que cambiar.
2. Configurar de manera dinámica un componente de la Vista, envés de estáticamente durante el tiempo de compilación.
3. Un objeto debe ser capaz de notificar a otros objetos sin que estos objetos estén fuertemente acoplados.

Video: https://www.youtube.com/watch?v=r3TdeykOFZQ


## STRATEGY (ESTRATEGIA)

Permite encapsular un algoritmo. Asignar diferentes algoritmos a contextos.

**Propósito**: Definir una familia de algoritmos, encapsular cada uno, y que sean intercambiables. Strategy permite al algoritmo variar independientemente de los clientes que lo utilizan.

Aplicación: 

1. Definir una familia de comportamientos.
2. Definir variantes de un mismo algoritmo.
3. Poder cambiar el comportamiento en tiempo de ejecución, es decir, dinámicamente.
4. Reducir largas listas de condicionales.
5. Evitar código duplicado.
6. Ocultar código complicado, o que no queremos revelar, del usuario.

Video: https://www.youtube.com/watch?v=sxNR8sAN9ow&index=16&list=PLC238B0613515968F


# PATRONES ESTRUCTURALES


## FACADE (FACHADA)

En sistemas complejos se utiliza una interfaz unica y simplificada para simplificar las cosas.
Con el crecimiento del numero de servicios en la aplicacion, metemos un intermediario que es la fachada y este es el que permite determinar los servicios de alto nivel.
El cliente pasa a tratar con la fachada y no con los servicios directamente. Una vez que metimos la fachada, y se agregan nuevos servicios, no debemos saltear la fachada y modificar esta para que se agregue el servicio.

**Propósito**: Proporcionar una interfaz unificada para un conjunto de interfaces de un subsistema. Facade define una interfaz de alto nivel que hace que el subsistema sea más fácil de usar.

Este patrón protege los clientes de los componentes del subsistema, propiciando el menor uso de componentes para que el subsistema pueda ser utilizado.
Además, promueve un bajo acoplamiento entre subsistemas y clientes.
Este patrón no evita que los clientes usen las clases internas del subsistema, si es que es necesario.
Es importante mencionar que el objeto Facade debe ser extremadamente simple. No debe convertirse en un objeto "dios".

Aplicación: 

1. Cuando queremos encapsular un subsistema complejo con una interface más simple.
2. Para crear una interface simplificada que ejecuta muchas acciones "detŕas del escenario".
3. Existen muchas dependencias entre clientes y la implementación de clases de una abstracción. Se introduce el facade para desacoplar el subsistema de los clientes y otros subsistemas.
4. Necesitamos desacoplar subsistemas entre sí, haciendo que se comuniquen únicamente mediante Facades.
5. Para definir un punto de entrada a cada nivel del subsistema.

Video: https://www.youtube.com/watch?v=U7kzLu7Vjlg&list=PLj2IVmcP-_QOQcDplVNiLbBQ6OLCXX7fv&index=5


## COMPOSITE (COMPUESTO)

En un problema de arbol, tratamos por igual a una hoja que a un compuesto. Con esta forma evitamos el codigo spaguetti y la alta cohesión (mas de una responsabilidad para una clase) entre las clases.
Creamos una clase abstracta que tiene el rol de componente, esta clase abstracta tendrá atributos compartidos entre la hoja y el compuesto. Cuando un atributo solo es de compuesto se lo lleva a compuesto.
La hoja y el compuesto concreto heredan de esta clase abtracta. La clase compuesta a su vez tiene atributos particulares del compuesto.
La clase compuesto tiene un atributo de una lista de componente.


Video: https://www.youtube.com/watch?v=E85Nu2auOFI&t=2s

## Bibliografía
https://es.wikipedia.org/wiki/Patr%C3%B3n_de_dise%C3%B1o
https://github.com/LuisBurgos/design-patterns
https://www.tutorialspoint.com/design_pattern/strategy_pattern.htm

## Ejemplo de codigo
https://github.com/miw-upm/APAW-pd/
https://github.com/iluwatar/java-design-patterns
https://github.com/alexyslozada/CursoPatronesDiseno
