# Volatile

It declares that the field value must be read from and written to main memory – bypassing the CPU cache.

###All reads and writes for a volatile variable are atomic.

What are atomic variables?
https://www.baeldung.com/java-atomic-variables

Info sobre operacion atomica: Una operación atómica es una operación en la que un procesador puede simultáneamente leer una ubicación y escribirla en la misma operación del bus. Esto previene que cualquier otro procesador o dispositivo de E/S escriba o lea la memoria hasta que la operación se haya completado.

Caching and reordering are among those optimizations that may surprise us in concurrent contexts. Java and the JVM provide many ways to control memory order, and the volatile keyword is one of them.

https://www.baeldung.com/java-volatile

### 3.1. Memory Visibility
In this simple example, we have two application threads: the main thread and the reader thread. Let's imagine a scenario in which the OS schedules those threads on two different CPU cores, where:

The main thread has its copy of ready and number variables in its core cache
The reader thread ends up with its copies, too
The main thread updates the cached values
On most modern processors, write requests won't be applied right away after they're issued. In fact, processors tend to queue those writes in a special write buffer. After a while, they will apply those writes to main memory all at once.

With all that being said, when the main thread updates the number and ready variables, there is no guarantee about what the reader thread may see. In other words, the reader thread may see the updated value right away, or with some delay, or never at all!

This memory visibility may cause liveness issues in programs that are relying on visibility.

### 3.2. Reordering
To make matters even worse, the reader thread may see those writes in any order other than the actual program order. For instance, since we first update the number variable:

public static void main(String[] args) { 
    new Reader().start();
    number = 42; 
    ready = true; 
}
We may expect the reader thread prints 42. However, it's actually possible to see zero as the printed value!

The reordering is an optimization technique for performance improvements. Interestingly, different components may apply this optimization:

- The processor may flush its write buffer in any order other than the program order
- The processor may apply out-of-order execution technique
- The JIT compiler may optimize via reordering

### volatile Memory Order

To ensure that updates to variables propagate predictably to other threads, we should apply the volatile modifier to those variables:

public class TaskRunner {

    private volatile static int number;
    private volatile static boolean ready;

    // same as before
}

This way, we communicate with runtime and processor to not reorder any instruction involving the volatile variable. Also, processors understand that they should flush any updates to these variables right away.

### volatile and Thread Synchronization
For multithreaded applications, we need to ensure a couple of rules for consistent behavior:

Mutual Exclusion – only one thread executes a critical section at a time
Visibility – changes made by one thread to the shared data are visible to other threads to maintain data consistency
synchronized methods and blocks provide both of the above properties, at the cost of application performance.

volatile is quite a useful keyword because it can help ensure the visibility aspect of the data change without, of course, providing mutual exclusion. Thus, it's useful in the places where we're ok with multiple threads executing a block of code in parallel, but we need to ensure the visibility property.


### Happens-Before Ordering
The memory visibility effects of volatile variables extend beyond the volatile variables themselves.

To make matters more concrete, let's suppose thread A writes to a volatile variable, and then thread B reads the same volatile variable. In such cases, the values that were visible to A before writing the volatile variable will be visible to B after reading the volatile variable


# Technically speaking, any write to a volatile field happens before every subsequent read of the same field. This is the volatile variable rule of the Java Memory Model (JMM).



Info: https://www.baeldung.com/java-volatile
