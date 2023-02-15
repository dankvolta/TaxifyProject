package taxify;

import java.util.List;



public interface IVehicle {
	
	public int getId();
	public Location getLocation();
	public Location getDestination();
	
	public IServices getService();
	public Statistics getStatistics();
	
	public void pickService(IServices s);
	public void startService();
	public void endService();
	
	public void notifyArrivalPickUp(IVehicle v);
	public void notifyArrivalDropOff();
	
	public boolean isFree();
	public void move();
	
	public int calculateCost();
	
	public String showDrive(List<Location> drive);
	public String toString();

}
