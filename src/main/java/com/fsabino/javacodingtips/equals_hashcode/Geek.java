package com.fsabino.javacodingtips.equals_hashcode;

public class Geek {
	
	public String name;
    public int id;
	
    public Geek(String name, int id) {
		super();
		this.name = name;
		this.id = id;
	}
    
	@Override
	public int hashCode() {
		// We are returning the Geek_id 
        // as a hashcode value.
        // we can also return some 
        // other calculated value or may
        // be memory address of the 
        // Object on which it is invoked. 
        // it depends on how you implement 
        // hashCode() method.
        return this.id;
	}
	
	@Override
	public boolean equals(Object obj) {
		
		// checking if both the object references are 
	    // referring to the same object.
		if (this == obj) return true;
		
		// it checks if the argument is of the 
        // type Geek by comparing the classes 
        // of the passed argument and this object.
        // if(!(obj instanceof Geek)) return false; ---> avoid.
		if (obj == null) return false;
		if (getClass() != obj.getClass()) return false;
		
		// type casting of the argument. 
		Geek other = (Geek) obj;
		if (id != other.id) return false;
		if (name == null) {
			if (other.name != null) return false;
		} else if (!name.equals(other.name)) return false;
		
		return true;
	}
}
