package taxify;

import java.util.List;

public class AppSim implements IAppSim, IObserver {
    private ITaxiCompany company;
    private List<IUser> users;
    private List<IVehicle> vehicles;
    
    public AppSim(ITaxiCompany company, List<IUser> users, List<IVehicle> vehicles) {
        this.company = company;
        this.users = users;
        this.vehicles = vehicles;
    }
    
    @Override
    public void show() {
        // shows the status of the vehicles
        System.out.println("\n" + this.company.getName() + " status \n");
        

        for (int i=0; i<this.vehicles.size(); i++) {
           // System.out.println(this.vehicles.get(i).toString());
            System.out.println(String.format("%-15s", this.vehicles.get(i)).toString());
        }   
    }
    
    @Override
    public void showStatistics() {
        
            String s = "\n" + this.company.getName() + " statistics: \n";
            
            for (int i=0; i< this.vehicles.size(); i++) {
                s = s + "\n" + 
                    String.format("%-8s", this.vehicles.get(i).getClass().getSimpleName()) + this.vehicles.get(i).getId() + " " +
                    String.format("%2s", this.vehicles.get(i).getStatistics().getService()) + " services " + 
                    String.format("%3s", this.vehicles.get(i).getStatistics().getDistance()) + " km. " +
                    String.format("%3s", this.vehicles.get(i).getStatistics().getBilling()) + " eur. " +
                    String.format("%2s", this.vehicles.get(i).getStatistics().getReviews()) + " reviews " +
                    String.format("%-4s", this.vehicles.get(i).getStatistics().getStars()) + " stars";
            }
            
            System.out.println(s);
    }    

    @Override
    public void update() {
        // moves the vehicles to their next location
        for (int i=0; i<this.vehicles.size(); i++) {
               this.vehicles.get(i).move();
        }
    }
        
    @Override 
    public void requestService() {        					
        // finds a "free" user and requests a service to the Taxi Company
    	for(IUser u : this.users) {
    		if(u.getService() == false) {    // if the user doesnt have any service yet, we request a service from the company
    			u.requestService();
    		}
    	}
    	
    }
    
    @Override
    public int getTotalServices() {
        return this.company.getTotalServices();
    }
    
    @Override
    public void updateObserver(String message) {
        System.out.println(message);
    }
    
    
}