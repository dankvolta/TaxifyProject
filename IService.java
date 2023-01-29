package taxify;

public interface IService {
    public User getUser();
    public Location getPickupLocation();
    public Location getDropoffLocation();
    public double getStars();
    public void setStars(double stars);
    public int calculateDistance();
    public String toString();

}
