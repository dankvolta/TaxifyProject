package taxify;
import java.lang.Math;

public class Services implements IServices{
	private User user;
	private Location pickup;
	private Location dropoff;
	private double stars;
	
	
	public Services(User user, Location pickup, Location dropoff, double stars) {
		this.user = user;
		this.pickup = pickup;
		this.dropoff = dropoff;
		this.stars = 0.0;
	}
	
	@Override
	public User getUser() {
		return this.user;
	}
	
	@Override
	public Location getPickUp() {
		return this.pickup;
	}
	
	@Override
	public Location getDropOff() {
		return this.dropoff;
	}
	
	@Override
	public double getStars() {
		return this.stars;
	}
	
	@Override
	public void setStars(double s) {
		this.stars = s;
	}
	
	@Override
	// Manhattan Distance between two points (x1, y1) and (x2, y2) is: ABS( (x1 - x2)  + (y1 - y2) )
	public int calculateDistance() {
		return Math.abs( (this.pickup.getX() - this.dropoff.getX()) + (this.pickup.getY() - this.dropoff.getY()) );
	}
		
	@Override
	public String toString() {
		return "Service requested to go from " + this.getPickUp().toString() + this.getDropOff().toString();
 		
	}
	

}
