package taxify;


public interface ITaxiCompany {
	public String getName();    
    public int getTotalServices();
 //  public int getAvailableUserForRequest();
    public boolean requestService(int user);
    
    public void arrivedAtPickupLocation(IVehicle vehicle);
    public void arrivedAtDropoffLocation(IVehicle vehicle);
    public String getname();
//    public void addUser(int id, String firstName, String lastName);
//    public void addApplication(AppSim application);
//    
//    public void notifyApplication(String message);
//    
//    public User getUser(int id);
//    
//    public String show();
//    public String showStatistics();
//    
//    public void update();
	
}
