package taxify;

public interface IUser {  
	
	public int getID();
	public String getFirstName();
	public String getLastName();
	public TaxiCompany getCompany();
	public boolean getService();
	public void setService(boolean s);
	public void requestService();
	public void rateService(IServices service);  // we use the interface instead of the class itself
	public String toString();
	


}
