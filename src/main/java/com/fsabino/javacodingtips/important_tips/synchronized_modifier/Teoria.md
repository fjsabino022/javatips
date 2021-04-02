# Synchronized modifier

We can use it with "the instance" as well as with "static methods" and "code blocks". When we use this keyword, we make Java use a monitor lock to provide synchronization on a "given code fragment".

Race Condition: occurs when two or more threads attempt to update mutable shared data at the same time.

We should use synchronized when we have a multi-thread environment or when "the race condition" occurs.

#####A piece of logic marked with synchronized becomes a synchronized block, allowing only one thread to execute at any given time.

The synchronized keyword can be used on different levels:

1. Instance methods
2. Static methods
3. Code blocks

When we use a synchronized block, internally Java uses a monitor also known as monitor lock or intrinsic lock, to provide synchronization. These monitors are bound to "an object", thus all synchronized blocks of the same object can have only one thread executing them at the same time.

####1. Instance methods
public synchronized void synchronisedCalculate() {
    setSum(getSum() + 1);
}

Instance methods are synchronized over the instance of the class owning the method. Which means only one thread per instance of the class can execute this method.

####2. Static methods
public static synchronized void syncStaticCalculate() {
     staticSum = staticSum + 1;
 }
 
These methods are synchronized on the Class object associated with the class and since only one Class object exists per JVM per class, only one thread can execute inside a static synchronized method per class, irrespective of the number of instances it has.

####3. Synchronized Blocks Within Methods
Sometimes we do not want to synchronize the entire method but only some instructions within it. 
This can be achieved by applying synchronized to a block:

public void performSynchronisedTask() {
    synchronized (this) {
        setCount(getCount()+1);
    }
}

Notice that we passed a parameter this to the synchronized block. This is the monitor object, the code inside the block gets synchronized on the monitor object. Simply put, only one thread per monitor object can execute inside that block of code.
s
In case the method is static, we would pass the class name in place of the object reference. And the class would be a monitor for synchronization of the block:

public static void performStaticSyncTask(){
    synchronized (SynchronisedBlocks.class) {
        setStaticCount(getStaticCount() + 1);
    }
}

####Additional: Reentrancy
Se dice que una zona de exclusión mutua es reentrante cuando un mismo thread puede adquirir el mismo cerrojo varias veces; es decir, cuando un thread no se excluye a sí mismo. En java, el mecanismo synchonized es reentrante.

Esta propiedad permite que varios métodos synchronized se llamen entre sí, incluso recursivamente.

Por regla general, una clase es siempre reentrant puesto que solo una instancia de la clase tiene acceso a sus datos (que debe ser privados) siempre y cuando cada hilo de ejecución ejecute su propia instancia de la clase.

Por otro lado, para que una clase o alguno de sus métodos sea thread-safe es necesario que se implemente algún mecanismo de sincronización de acceso a sus datos. Una clase o método thread-safe es siempre reentrant pero no tiene por que ser cierto al contrario.

Reentrancy means that locks are acquired on a per-thread rather than per-invocation basis.

The lock behind the synchronized methods and blocks is reentrant. That is, the current thread can acquire the same synchronized lock over and over again while holding it:

Object lock = new Object();
synchronized (lock) {
    System.out.println("First time acquiring it");

    synchronized (lock) {
        System.out.println("Entering again");

         synchronized (lock) {
             System.out.println("And again");
         }
    }
}

function A():
  - lock (X)
  - B()
  - unlock (X)

function B():
  - A()

Now we call A. The following happens:
  We enter A, locking X
  We enter B
  We enter A again, locking X again

Since we never exited the first invocation of A, X is still locked. This is called re-entrance - while function A has not yet returned, function A is called again. If A relies on some global, static state, this can cause a 're-entrance bug', where before the static state is cleaned up from the function's exit, the function is run again, and the half computed values collide with the start of the second call.

In this case, we run into a lock we are already holding. If the lock is re-entrance aware, it will realize we are the same thread holding the lock already and let us through. Otherwise, it will deadlock forever - it will be waiting for a lock it already holds.

In java, lock and synchronized are re-entrance aware - if a lock is held by a thread, and the thread tries to re-acquire the same lock, it is allowed. So if we wrote the above pseudocode in Java, it would not deadlock.

https://stackoverflow.com/questions/16504231/what-is-the-meaning-of-reentrantlock-in-java#:~:text=Reentrancy%20means%20(in%20general%20CS,a%20lock%20on%20%22foo%22.
