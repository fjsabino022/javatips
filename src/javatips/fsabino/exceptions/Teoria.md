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

## Bibliografía
http://fcqi.tij.uabc.mx/usuarios/palacios/java5.pdf
https://www.solvetic.com/tutoriales/article/1136-tipos-de-excepciones-en-java/

## Ejemplo de codigo
http://fcqi.tij.uabc.mx/usuarios/palacios/java5.pdf