package taxify;

// each service needs a users pick up and drop off locations
// provides services to users such as: Rating a service

public interface IServices {
	public IUser getUser();
	
	public ILocation getPickUp();
	public ILocation getDropOff();
	
	
	public double getStars();
	public void setStars(double s);
	
	public int calculateDistance();
	public String toString();
	

}
