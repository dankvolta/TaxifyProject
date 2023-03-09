package taxify;

import java.util.ArrayList;
import java.util.List;

public class Subject implements ISubject{
	private List<IObserver> observers;
	
	public Subject(List<IObserver> observers) {
		this.observers = new ArrayList<IObserver>();
		
	}

	@Override
	public void addObserver(IObserver observer) {
		this.observers.add(observer);
	}

	@Override
	public void notifyObserver(String message) {
		for(IObserver o : this.observers) {
			o.updateObserver("An update has been made!");
		}
	}

}
