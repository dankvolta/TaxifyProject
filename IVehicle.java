package taxify;

import java.util.List;



public interface IVehicle {
	
	public int getId();
	public ILocation getLocation();
	public ILocation getDestination();
	
	public IServices getService();
	public IStatistics getStatistics();
	
	public void setCompany(ITaxiCompany company);
	public void pickService(IServices s);
	public void startService();
	public void endService();
	
	public void notifyArrivalPickUp(IVehicle v);
	public void notifyArrivalDropOff();
	
	public boolean isFree();
	public void move();
	
	public int calculateCost();
	
	public String showDrive(List<ILocation> drive);
	public String toString();

}
