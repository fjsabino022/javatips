# Immutable String Class

We should know that String objects are treated differently than other objects by the JVM. One difference is that String objects are immutable. It means that we can’t change them once we have created them. There are several reasons why they behave that way:

They are stored in the **string pool** which is a special part of the **heap memory**. It’s responsible for saving a lot of space.
The immutability of the String class guarantees that its hash code won’t change. Due to that fact, Strings can be effectively used as keys in hashing collections. We can be sure that we won’t overwrite any data because of a change in hash codes.
They can be used safely across several threads. No thread can change the value of a String object, so we get thread safety for free.
Strings are immutable to avoid serious security issues. Sensitive data such as passwords could be changed by an unreliable source or another thread.

## Hashcode Caching

Since String objects are abundantly used as a data structure, they are also widely used in hash implementations like HashMap, HashTable, HashSet, etc. When operating upon these hash implementations, hashCode() method is called quite frequently for bucketing.

The immutability guarantees Strings that their value won’t change. So the hashCode() method is overridden in String class to facilitate caching, such that the hash is calculated and cached during the first hashCode() call and the same value is returned ever since.

This, in turn, improves the performance of collections that uses hash implementations when operated with String objects.

On the other hand, mutable Strings would produce two different hashcodes at the time of insertion and retrieval if contents of String was modified after the operation, potentially losing the value object in the Map.

## Bibliography
https://www.baeldung.com/java-string-immutable
