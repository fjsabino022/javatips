package javatips.fsabino.patterns_of_design.behavior.observer;

public class Subject extends Observable {
	private int state;

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
		
		// must update all dependencies
		this.executeObservers();
	}
}
