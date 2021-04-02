# How can we build a thread safe application

Consumer-Producer problem:
https://crunchify.com/java-producer-consumer-example-handle-concurrent-read-write/

### ConcurrentHashMap vs Collections synchronized Map method.
Initially, we should now that HashMap is a non-synchronized collection.

//synchronizedMap
synchronizedHashMap = Collections.synchronizedMap(new HashMap<String, String>());

//ConcurrentHashMap
concurrentHashMap = new ConcurrentHashMap<String, String>();

#### ConcurrentHashMap
1. You should use ConcurrentHashMap when you need very high concurrency in your project.
2. It is thread safe without synchronizing the whole map.
3. Reads can happen very fast while write is done with a lock.
4. There is no locking at the object level.
5. The locking is at a much finer granularity at a hashmap bucket level.
6. ConcurrentHashMap doesn’t throw a ConcurrentModificationException if one thread tries to modify it while another is iterating over it.
7. ConcurrentHashMap uses multitude of locks.

#### SynchronizedHashMap
1- Synchronization at Object level.
2- Every read/write operation needs to acquire lock.
3- Locking the entire collection is a performance overhead.
4- This essentially gives access to only one thread to the entire map & blocks all the other threads.
5- It may cause contention.
6- SynchronizedHashMap returns Iterator, which fails-fast on concurrent modification.

Interesting topic: https://crunchify.com/how-to-create-your-own-non-blocking-queue-in-java-same-as-evictingqueue/