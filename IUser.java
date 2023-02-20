package taxify;

public interface IUser {  
	
	public int getID();
	
	public String getFirstName();
	public String getLastName();
	
	public ITaxiCompany getCompany();
	public void setCompany(ITaxiCompany company);
	
	public boolean getService();
	public void setService(boolean s);
	
	public void requestService();
	public void rateService(IServices service);
	
	public String toString();
	


}
