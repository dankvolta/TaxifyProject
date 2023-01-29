package taxify;

public interface IService {
    public User getUser();
    public Location getPickupLocation();
    public Location getDropoffLocation();
    public int getStars();
    public void setStars(int stars);
    public int calculateDistance();
    public String toString();

}
