# ¿Qué son las @notaciones?

Una anotación sirve para dar información al compilador o a las herramientas de desarrollo para hacer algo.
Ese "algo" que decimos puede ser, por ejemplo para que el compilador detecte errores o advertencias, para que las herramientas de desarrollo puedan generar código, archivos, etc.

Las anotaciones son una forma de metadatos que proporcionan datos sobre un programa que no forma parte del programa en sí. Las anotaciones no tienen ningún efecto directo en el funcionamiento del código que anotan.

**Las anotaciones tienen una serie de usos, entre ellos:**

_Información para el compilador_: El compilador puede utilizar las anotaciones para detectar errores o suprimir las advertencias.
_Procesamiento en tiempo de compilación y tiempo de implementación_: Las herramientas de software pueden procesar información de anotaciones para generar código, archivos XML, etc.
_Procesamiento de tiempo de ejecución_: algunas anotaciones están disponibles para ser examinadas en tiempo de ejecución.

**El formato de una anotación**

Una anotación siempre va delante de una clase, método, o declaración y se ve así:
@UnaAnotacion

El carácter de signo (@) indica al compilador que lo que sigue es una anotación.
Con el signo de @ adelante del nombre y pueden tener elementos como parámetros con valor para más otorgar más información, por ejemplo:
@Autor(nombre = "Daniel Alvarez", fecha = "27/08/2017")
public class MiClase() {
}

En el siguiente ejemplo, el nombre de la anotación es Override:

@Override
void mySuperMethod() { ... }

La anotación puede incluir elementos, que pueden ser nombrados o sin nombre, y hay valores para esos elementos:

@Author(
   name = "Benjamin Franklin",
   date = "3/27/2003"
)
class MyClass() { ... }
or

@SuppressWarnings(value = "unchecked")
void myMethod() { ... }

Si sólo hay un elemento denominado valor, el nombre puede omitirse, como en:

@SuppressWarnings("unchecked")
void myMethod() { ... }

Si la anotación no tiene elementos, los paréntesis se pueden omitir, como se muestra en el ejemplo anterior de @Override.

También es posible utilizar múltiples anotaciones en la misma declaración:

@Author(name = "Jane Doe")
@EBook
class MyClass { ... }

Si las anotaciones tienen el mismo tipo, entonces se denomina anotación repetitiva:

@Author(name = "Jane Doe")
@Author(name = "John Smith")
class MyClass { ... }

Las anotaciones repetidas se admiten desde la versión de Java SE 8.

El tipo de anotación puede ser uno de los tipos que se definen en los paquetes java.lang o java.lang.annotation de la API de Java SE. En los ejemplos anteriores, Override y SuppressWarnings son anotaciones Java predefinidas. También es posible definir su propio tipo de anotación. Las anotaciones de Author y Ebook en el ejemplo anterior son tipos de **anotaciones personalizadas**.

Si vienes programando en Java anteriormente, seguramente te topaste con 
	@Deprecated
	@Override:  le informa al compilador que sobreescribirá el método de la clase padre.
	@SuppressWarning: le dice al compilador que elimine las advertencias que se pueden mostrar, es decir, ya no te mostrará advertencias que pueda generar ese método. Útil cuando ya no te interesan algunas advertencias que conoces.


**¿Dónde puedo utilizar anotaciones?**

Las anotaciones se pueden aplicar a declaraciones: declaraciones de clases, campos, métodos y otros elementos del programa. Cuando se utiliza en una declaración, cada anotación suele aparecer, por convención, en su propia línea.

A partir de la versión Java SE 8, las anotaciones también se pueden aplicar al uso de tipos. 

Aquí hay unos ejemplos:
_Expresión de creación de instancia de clase_: new @Interned MyObject();
_Tipo emitido_: MyString = (cadena @NonNull) str;
_cláusula implements_: class UnmodifiableList<T> implements @Readonly List<@Readonly T> { ... }
_Declaración de excepción lanzada_: void monitorTemperature() throws @Critical TemperatureException { ... }


**Otras anotaciones**

@author: el autor de la clase o método
@version: la versión del código
@see: algo que es interesante que se vea, como pueden ser webs. Se puede utilizar HTML, para un vínculo podemos utilizar la estructura: <a href="url">nombre</a>
@param nombreVariable: para explicar un parámetro de la clase
@return: para indicar que es lo que devuelve el método


## Bibliografía
https://medium.com/alvareztech/java-annotations-b8ae69739b4e
https://es.stackoverflow.com/questions/79397/cu%C3%A1l-es-la-funci%C3%B3n-de-las-anotaciones-en-java


## Ejemplo de codigo
https://jarroba.com/annotations-anotaciones-en-java/

