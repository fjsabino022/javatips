package javatips.fsabino.lambda;

@FunctionalInterface
public interface Predicate<T> {
	
	//abstract method
	public boolean test( T t);
	
	// default and implement method
	public default  Predicate<T> and(Predicate<T> predicate) {
		return t -> test(t) && predicate.test(t);
	}
	
	//static and implement method
	public static Predicate<String> isEqualsTo (String string) {
		return s -> s.equals(string);
	}
	
	//static and implement method with generic
	public static <U> Predicate<U> isEqualsToGen (U string) {
		return s -> s.equals(string);
	}
}
