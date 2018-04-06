# Inversion de control (IoC)

Inversion of control (IoC) es una forma de trabajar que rompe con el formato tradicional, en donde el programar es el encargado de definir la secuencia de operaciones que se deben de realizar para llegar a un resultado. En este sentido el programador debe conocer todos los detalles del framework y las operaciones a realizar en él, por otra parte, el Framework no conoce absolutamente nada de nuestro programa.

Nuestra aplicación es la que llama en todo momento al Framework y este hace lo que la App le solicita. Por otra parte, al Framework no le interesa en absoluto la App.

Pero qué pasaría si invirtiéramos la forma de trabajo, y que en lugar de que la App llame funciones del Framework, sea el Framework el que ejecute operaciones sobre la App, ¿suena extraño no? Pues en realidad a esta técnica es a la que se le conoce como Inversion of Control.

Otra de los problemas que intenta solucionar IoC es la de evitar utilizar el operador new para crear clases clave o que son gestionadas por el Framework. En su lugar el Framework creará estos objetos por nosotros y nos podrá a disposición por medio de inyección de dependencias.
 
Una de las cosas más entretenidas en el mundo de "enterprise java" es la gran cantidad de actividad que hay en la construcción de alternativas a las tecnologías J2EE, muchas de las cuales son open source. Muchas de ellas son una respuesta a lo pesado y complejo que es el mundo de J2EE, pero otras muchas además exploran alternativas y traen ideas creativas. Un tema común con el que tratan es cómo unir diferentes elementos: cómo juntas este arquitectura controlador web con la interface de base de datos cuando ambas han sido construidas por diferentes equipos con poco conocimiento el uno del otro. Un número de frameworks han abordado este problema, y varios están empezando a trabajar para conseguir la capacidad general de ensamblar componentes de diferentes capas. A menudo se conoce a estos frameworks como contenedores ligeros, por ejemplo PicoContainer y Spring.

Se refiere a todo aquel diseño de software cuyo propósito obedece a la necesidad de querer controlar el flujo de ejecución de este, de forma automática y transparente, es decir, ceder el control de ese flujo a un “agente externo”, normalmente un framework. He aquí el concepto de Inversion of Control.

Si solo ahondamos apenas un poquito en algunas de las herramientas que utilizamos en nuestro desarrollo, nos daremos cuenta que este patrón de diseño está presente en múltiples ocasiones facilitándonos enormemente el trabajo.

# Inyeccion de Dependencias

La dependencia de un objeto respecto a otro ocurre cuando el primero necesita del segundo para completar alguna de sus tareas.

Un caso típico es el de un coche, que depende del motor para, por ejemplo, poder avanzar.

public class Motor {
   public void acelerar() {
       //..
   }
   public int getRevoluciones() {
        return currentRPM;
   }
}
public class Vehiculo {

   private Motor m;
     
   public Vehiculo() {
        m = new Motor();
   }
   public int getRevolucionesMotor() {
       return m.getRevoluciones();
   }
}

Como podemos comprobar, la dependencia entre las clases Vehiculo y Motor queda patente dado que una instancia de la primera alberga dentro una instancia de la segunda.

Sin embargo, podemos comprobar que el acoplamiento existente en el código es alto. El motor está fuertemente ligado al vehículo, de forma que esta relación es poco flexible. Si quisiéramos realizar cualquier tipo de modificación en la clase Motor, esto supondría un alto impacto en la clase Vehiculo (por ejemplo, si quisiéramos hacer una concreción en MotorDiesel o MotorGasolina).

Como primer paso para desacoplar el motor del vehículo, podríamos hacer que la clase Vehiculo deje de encargarse de instanciar el objeto Motor, pasándoselo como parámetro al constructor. De esta forma, la clase Vehiculo quedaría de la siguiente manera:

public class Vehiculo {
   
   private Motor m;
 
   public Vehiculo(Motor motorVehiculo) {
        m = motorVehiculo;
   }
   public int getRevolucionesMotor() {
        return m.getRevoluciones();
   }
}

El constructor de vehículo se encarga de inyectar la dependencia dentro del objeto, eliminando esta responsabilidad de la propia clase. De esa forma, hemos dado un paso para desacoplar ambos objetos.

El siguiente paso que podríamos dar en aras de continuar con el desacoplamiento de ambos objetos es el uso de interfaces.

public interface IMotor {
   public void acelerar();
   public int getRevoluciones();
}
public class MotorGasolina {
 
   public void acelerar() {
        realizarAdmision();
        realizarCompresion();
        realizarExplosion();        //Propio de los motores de gasolina
        realizarEscape();
   }
   public int getRevoluciones() {
        return currentRPM;
   }
}
public class MotorDiesel {
 
   public void acelerar() {
        realizarAdmision();
        realizarCompresion();
        realizarCombustion();        //Propio de los motores diesel
        realizarEscape();
    }
    public int getRevoluciones() {
        return currentRPM;
    }
    //...
}
public class Vehiculo{
    private IMotor m;

   public Vehiculo(IMotor motorVehiculo) {
        m = motorVehiculo;
   } 
   public int getRevolucionesMotor() {
        return m.getRevoluciones();
   }
}

Como podemos observar, la clase Vehiculo ya no está acoplada a la clase Motor, sino que bastará con un objeto que implemente la interfaz IMotor, como lo son MotorDiesel o MotorGasolina.

Por último, nos faltaría ver como se realizaría la inyección de dependencias propiamente dicha. Veamos la siguiente clase, Main:

// todos los import necesarios
 
public class Main {
    public static void main(String[] args) {
 
   /*Al proporcionar un objeto que implementa la interfaz IMotor 
        como parámetro del constructor de Vehiculo, estamos inyectando 
        la dependencia.*/
        Vehiculo cocheDiesel = new Vehiculo(new MotorDiesel());
        /*En este caso, realizamos otra inyección de una dependencia, 
        pero con una instancia de MotorGasolina.*/
        Vehiculo cocheGasolina = new Vehiculo(new MotorGasolina());
 
        //...
   }
}

## Diferentes formas de inyección de dependencias

Como hemos visto en el ejemplo anterior, una de las formas de realizar la inyección de dependencias es mediante el uso de un constructor, pero no es la única. De hecho, a nivel formal podemos decir que existen algunas más:

**Inyección por constructor**
public class GeneradorPlaylist {
   private BuscadorCanciones buscadorCanciones;
   public GeneradorPlaylist(BuscadorCanciones buscadorCanciones){
        this.buscadorCanciones = buscadorCanciones;
   }
  //Resto de métodos de la clase
}

**Inyección por método**
public class GeneradorPlaylist {
   @autowired
   private BuscadorCanciones buscadorCanciones;

   public setBuscadorCanciones(BuscadorCanciones buscadorCanciones){
        this.buscadorCanciones = buscadorCanciones;
   }
   //Resto de métodos de la clase
}

**Inyección por propiedad** (esta la encontramos en otros lenguajes de programación, como C#).

En el ejemplo anterior hemos podido apreciar que, para la inyección por constructor, la clase que tiene la dependencia sobre otra debe tener, al menor, un constructor, donde reciba un parámetro de ese tipo.

## Bibliografía
http://www.davidvalverde.com/blog/inversion-de-control/
https://www.oscarblancarteblog.com/2016/12/01/concepto-inversion-of-control/
http://chuwiki.chuidiang.org/index.php?title=Inversi%C3%B3n_de_Control
https://itblogsogeti.com/2015/10/29/inyeccion-de-dependencias-vs-inversion-de-control-eduard-moret-sogeti/

## Ejemplo de codigo
https://www.adictosaltrabajo.com/tutoriales/spring-container-inyeccion-dependencias/#040
