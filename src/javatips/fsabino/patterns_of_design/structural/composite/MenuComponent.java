package javatips.fsabino.patterns_of_design.structural.composite;

import java.util.ArrayList;
import java.util.List;

public abstract class MenuComponent {
	
	String name;
	String url;
	List<MenuComponent> menuComponents = new ArrayList<MenuComponent>();
	
	public String getName() {
		return this.name;
	}
	public String getUrl() {
		return this.url;
	}
	
	public MenuComponent add (MenuComponent mc) {
		throw new UnsupportedOperationException("Feature not implemented at this level");
	}
	
	public MenuComponent remove (MenuComponent mc) {
		throw new UnsupportedOperationException("Feature not implemented at this level");
	}
	
	String print(MenuComponent menuComponent) {
		StringBuilder sb = new StringBuilder(name);
		sb.append(": ");
		sb.append(url);
		sb.append("\n");
		return sb.toString();
	}
	
	public abstract String toString();
}
