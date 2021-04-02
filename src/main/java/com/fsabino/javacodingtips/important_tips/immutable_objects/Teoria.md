# Immutable Objects

The definition of an immutable object is rather short:

## An object whose state cannot be changed after construction is called an immutable object.

Since immutable fields usually use the "final" keyword, compilers can tell us when such a field has not been initialized.
The compiler will point out all the places where we have to add that new field in the client code.

A very basic immutable class looks like this:

class User {

  private final Long id;
  private final String name;

  User(Long id, String name) {
    this.id = id;
    this.name = name;
  }
}

The main features are that the fields are final, telling the compiler that their values must not change once initialized and that all field values are passed into the constructor.

### Concurrency
If we’re working with concurrent threads that access the same objects, it’s best if those objects are immutable. This way, we can not introduce any bugs that arise from accidentally modifying the state of an object in one of the threads.

In concurrency code, we should make objects mutable only if we have to.

### DTO 
Another use case for immutables is when we need to transport data between systems or components that do not share the same data model. In this case, we can create a shared Data Transfer Object (DTO) that is created from the data of the source component and then passed to the target component.

Although DTOs don’t necessarily have to be immutable, it helps to keep the state of a DTO in a single place instead of scattered over the codebase.

Imagine we have a large DTO with tens of fields which are set and re-set over hundreds of lines of code, depending on certain conditions, before the DTO is sent over the line to a remote system (I’ve seen it happen!). In case of an error, we’ll have a hard time finding out where the value of a specific field came from.

If we make the DTO immutable (or close to immutable) instead, with dedicated factory methods for valid state combinations, there are only a few entry points for the state of the object, easing debugging and maintenance considerably.

### “Stateless” Service Objects
Even so-called “stateless” service objects usually have some kind of state. 
Usually, a service has dependencies to components that provide database access for loading and updating data:

@RequiredArgsConstructor
@Service
@Transactional
public class SendMoneyService {

  private final LoadAccountPort loadAccountPort;
  private final UpdateAccountStatePort updateAccountStatePort;
  
  // stateless methods omitted
}

In this service, the objects in loadAccountPort and updateAccountStatePort provide database access. These fields don’t make the service “stateful”, though, because their value doesn’t usually change during the runtime of the application.

If the values don’t change, why not make them immutable from the start? We can simply make the fields final and provide a matching constructor (in this case with Lombok’s @RequiredArgsConstructor). What we get from this is the compiler complaining about missing dependencies at compile time instead of the JRE complaining later at runtime.


------------------
Info: https://reflectoring.io/java-immutables/