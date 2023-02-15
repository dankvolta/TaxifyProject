package taxify;

import java.util.List;

public class Shuttle extends Vehicle {
	
	public Shuttle(int id, TaxiCompany company, Location location) {
		super(id, company, location);
		
		
	}
	
	@Override
	public int calculateCost() {
		return  (int) (super.calculateCost()   * 1.5);
		
	}
	
	@Override
	public String toString() {
		return "Shuttle: " + super.toString();
	}

}
