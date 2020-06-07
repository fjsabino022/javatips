# EXCEPCIONES

En Java una excepción es un error o una condición anormal que se ha producido durante la ejecución de
un programa. 

Java tiene diferentes tipos de excepciones: 
	excepciones de I/O, 
	las excepciones en tiempo de ejecución y las de su propia creación. 
	
Durante la compilación solamente se detectan los errores de sintaxis, pero el manejo de excepciones de Java permite el manipular los errores que ocurren en tiempo de ejecución, entre estas podemos mencionar las excepciones aritméticas (división entre cero), excepciones de puntero (acceso a punteros NULL) y excepciones de indexación (acceso por encima o debajo de los límites de un vector). 

Algunas excepciones son fatales y causan el fin de la ejecución del programa. En este caso conviene terminar ordenadamente y enviar un mensaje explicando el tipo de error que se ha producido. En otras situaciones, por ejemplo cuando no se encuentra un archivo sobre el que se desea realizar una operación, el programa puede dar al usuario la oportunidad de corregir el error.

Un buen programa debe manejar correctamente la mayoría de los errores que se puedan producir.
Java proporciona las siguientes herramientas para el manejo de excepciones: try, catch, throw, throws y finally.


## Jerarquía de las Excepciones

En Java, todas las excepciones estan consideradas en el de árbol de excepciones que se deriva de la
clase Throwable. Existen dos subclases directas de Throwable: Error y Exception.

La clase Error está relacionada con errores de la máquina virtual de Java y no el código, generalmente estos errores no dependen del programador por lo que no debe preocuparse por tratarlos.

En la clase Exception se encuentran las excepciones RuntimeException, producidas por errores de programación. El compilador de Java obliga a corregirlas.

## Tipos de Excepciones

En resumen las excepciones son generadas de tres formas diferentes.

1) La máquina Virtual de Java puede generar una excepción como producto de un error interno que
está fuera de su control. Estas excepciones generalmente no pueden ser manejadas por el
programa. Este tipo de excepciones son arrojadas cuando ocurren por la Java Virtual Machine o JVM, y están comprendidas dentro de la clase Error, estas se utilizan para describir errores internos del sistema, aunque realmente este tipo de errores ocurre con muy poca frecuencia y no podemos hacer mucho más que informar al usuario y terminar el programa.

2) Excepciones estándar: Son excepciones que deben ser manipuladas, se producen cuando se
ejecuta una división por cero o se trata de accesder a un arreglo con un índice fuera de límites
son generadas por errores en el código del programa.

3) El programador puede generar una excepción manualmente utilizando la estructura throw. Sin
importar cómo se produjo la excepción, se maneja de la misma forma.


### Excepciones No Chequeadas (Unchecked Exceptions)

Son las excepciones que tienen como superclase a la clase RuntimeException. No hay necesidad de capturarlas, es decir que no se necesita utilizar el bloque try/catch, pero al saltar uan excepción de este tipo, como todas las excepciones corta el flujo de la ejecución.
Pueden ser difíciles de detectar, pero finalmente hacen que el sistema se caiga si no fueron tomadas en cuenta.

Ejemplo:
Cuando se realiza una división por  cero se lanza automáticamente una ArithmeticException. Cuando se quiere acceder a un objeto que apunta a null se lanza automáticamente una NullPointerException. Cuando se quiere acceder a un array con un índice que es mayor al tamaño del array, se lanza automáticamente una ArrayIndexOutOfBoundException.

Generalmente este tipo de excepciones son lanzadas por la aplicación y se generan a partir de errores en tiempo de Runtime. Este tipo de excepciones representan errores en el código y que la aplicación no es capaz de controlar. Algunos de errores causados y que lanzan este tipo de excepciones, por ejemplo, argumentos inválidos pasados a un método (argumentos null pueden causar NullPointerException), otro error común son la excepciones del tipo IndexOutOfBoundsException y que son lanzadas cuando se quieren obtener elementos de una lista y el índice que se entrega está fuera del tamaño del arreglo. Como podrán ver, son errores de programación y que generarán defectos en momento de correr la aplicación (no así al compilar).

Las excepciones de tipo **Unchecked** son subclases que heredan desde **RuntimeException**. Además este tipo de excepciones **no tienen la obligación de ser declaradas con la cláusula throws en la cabecera del método**.
            
            
### Execpciones Chqueadas(Checked Exceptions)

Son las excepciones que tienen como superclase a la clase **Exception**. Necesitan ser capturadas, caso contrario no se podrá compilar el código.

Como por ejemplo:
SocketTimeoutException
IOException
DataFormatException

En el caso del FileReader se esta accediendo a lo que se llama un recurso externo al sistema en si. El sistema consta de las variables, las clases, los packages y los métodos que definimos, pero un archivo es un recurso externo, es decir que puede no existir al momento de ejecutar nuestro programa, o se a borrado mientras nuestro programa esta funcionando.
También llamamos recurso externo a una conexión con la base de datos, porque depende de una conexión de red. Todos estos artefactos que no son parte del programa sino que se interactúa con ellos, pueden traer algunas complicaciones como, no existir, que la red no esta conectada, que no haya mas espacio en disco, que la red se caiga en medio de una corrida del programa.
Todos estos motivos llevan a la necesidad de evaluar si se pueden realizar correcta y completamente las instrucciones del programa. Por lo tanto si algo sale mal, lo que no puede ocurrir es que dejemos una conexión tomada, o un archivo sin que otro sistema pueda acceder a el.
Aquí es donde tenemos que prestar mucha atención para que nuestro sistema no traiga problemas, simplemente verificar en el finally que se han liberado los recursos.

Ejemplo:
La clase FileReader se utiliza para el acceso al disco. Cuando utilizo un acceso a disco con métodos de la clase FileReader, debo capturar la excepción IOException.
                   
## Bibliografía
http://fcqi.tij.uabc.mx/usuarios/palacios/java5.pdf
https://www.solvetic.com/tutoriales/article/1136-tipos-de-excepciones-en-java/
http://labojava.blogspot.com.ar/2012/05/excepciones.html
https://blog.pcollaog.cl/2015/08/02/cheked-y-unchecked-exception/

## Ejemplo de codigo
http://fcqi.tij.uabc.mx/usuarios/palacios/java5.pdf