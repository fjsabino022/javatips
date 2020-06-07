# Autoboxing and Unboxing

**Autoboxing** is the automatic conversion that the Java compiler makes between the primitive types and their corresponding object wrapper classes. For example, converting an int to an Integer, a double to a Double, and so on. 
If the conversion goes the other way, this is called **unboxing**.

Here is the simplest example of autoboxing:

Consider the following code:

List<Integer> li = new ArrayList<>();
for (int i = 1; i < 50; i += 2)
    li.add(i);

Although you add the int values as primitive types, rather than Integer objects, to li, the code compiles. Because li is a list of Integer objects, not a list of int values, you may wonder why the Java compiler does not issue a compile-time error. The compiler does not generate an error because it creates an Integer object from i and adds the object to li. Thus, the compiler converts the previous code to the following at runtime:

List<Integer> li = new ArrayList<>();
for (int i = 1; i < 50; i += 2)
    li.add(Integer.valueOf(i));
    
Converting a primitive value (an int, for example) into an object of the corresponding wrapper class (Integer) is called **autoboxing**. 

The Java compiler applies autoboxing when a primitive value is:
   * Passed as a parameter to a method that expects an object of the corresponding wrapper class.
   * Assigned to a variable of the corresponding wrapper class.
		Example: Character ch = 'a';

Consider the following method:

public static int sumEven(List<Integer> li) {
    int sum = 0;
    for (Integer i: li)
        if (i % 2 == 0)
            sum += i;
        return sum;
}

Because the remainder (%) and unary plus (+=) operators do not apply to Integer objects, you may wonder why the Java compiler compiles the method without issuing any errors. The compiler does not generate an error because it invokes the intValue method to convert an Integer to an int at runtime:

public static int sumEven(List<Integer> li) {
    int sum = 0;
    for (Integer i : li)
        if (i.intValue() % 2 == 0)
            sum += i.intValue();
        return sum;
}

Converting an object of a wrapper type (Integer) to its corresponding primitive (int) value is called **unboxing**. 
The Java compiler applies unboxing when an object of a wrapper class is:

   * Passed as a parameter to a method that expects a value of the corresponding primitive type.
   * Assigned to a variable of the corresponding primitive type.

## Bibliografía
https://docs.oracle.com/javase/tutorial/java/data/autoboxing.html

## Ejemplo de codigo
https://www.geeksforgeeks.org/autoboxing-unboxing-java/
