package taxify;

public class User implements IUser { // attributes: int id, string fname and lname, taxicompany comp, 
	private int id;
	private String firstName;
	private String lastName;
	private ITaxiCompany company;
	private boolean service;
	
	public User(int id, String firstName, String lastName, boolean service) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.service = false;	// all users start by having no service yet
			
	}
	
	
	@Override
	public int getID() {
		return this.id;
	}
	
	@Override
	public String getFirstName() {
		return this.firstName;
	}
	
	@Override
	public String getLastName() {
		return this.lastName;
	}
	
	@Override
	public ITaxiCompany getCompany() {
		return this.company;
	}
	
	@Override
	public void setCompany(ITaxiCompany company) {
		this.company = company;
	}
	
	@Override
	public boolean getService() {
		return this.service;
	}
	
	@Override
	public void setService(boolean s) {
		this.service = s;
	}
	
	@Override
	public void requestService() {
		this.company.requestService(this.id);
	}
	
	 @Override
	    public void rateService(IServices service) {
	        // users rate around 50% of the services (1 to 5 stars)
	        
	        if (ApplicationLibrary.rand() % 2 == 0)
	            service.setStars(ApplicationLibrary.rand(5) + 1);
	    }
	
	public String toString() {
		return this.getID() + " " + String.format("%-20s", this.getFirstName() + " " + this.getLastName());
	}
	
	
	
}
