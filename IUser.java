package taxify;

public interface IUser {  
	
	public int getID();
	public String getFirstName();
	public String getLastName();
	public TaxiCompany getCompany();
	public boolean getService();
	public void setService(boolean s);
	public void requestService();
	public void rateService(Services service);
	public String toString();
	


}
