package taxify;

public class Taxi extends Vehicle {

	public Taxi(int id, TaxiCompany company, Location location) {
		super(id, company, location);
	}
	
	
	@Override 
	public int calculateCost() {
		return super.calculateCost() * 2;
	}
	
	@Override
	public String toString() {
		return "Taxi: " + super.toString();
	}

}
