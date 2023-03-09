package taxify;

import java.util.List;

public class TaxiCompany implements ITaxiCompany, ISubject {
    private String name;
    private List<IUser> users;
    private List<IVehicle> vehicles;
    private int totalServices;
    private IObserver observer;
    
    public TaxiCompany(String name, List<IUser> users, List<IVehicle> vehicles) {
        this.name = name;
        this.users = users;
        this.vehicles = vehicles;        
        this.totalServices = 0;
        
        // set the taxi company for users and vehicles
        
        for (int i=0; i<this.users.size(); i++)
            this.users.get(i).setCompany(this);
        
        for (int i=0; i<this.vehicles.size(); i++)
            this.vehicles.get(i).setCompany(this);
    }
    
    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getTotalServices() {
        return this.totalServices;
    }
        
    @Override
    public boolean requestService(int user) {
        int userIndex = indexOfUserId(user);        
        int vehicleIndex = findFreeVehicle();
        
        // if there is a free vehicle, assign a random pickup and drop-off location to the new service
        // the distance between the pickup and the drop-off location should be at least 3 blocks
        
        if (vehicleIndex != -1) {
            ILocation origin, destination;
            
            do {
                
                origin = ApplicationLibrary.randomLocation();
                destination = ApplicationLibrary.randomLocation(origin);
                
            } while (ApplicationLibrary.distance(origin, this.vehicles.get(vehicleIndex).getLocation()) < 3);
            
            // update the user status
                       
            this.users.get(userIndex).setService(true);
            
            // create a service with the user, the pickup and the drop-off location

            Services service = new Services(this.users.get(userIndex), origin, destination);
            
            // assign the new service to the vehicle
            
            this.vehicles.get(vehicleIndex).pickService(service);            
             
            notifyObserver("User " + this.users.get(userIndex).getID() + " requests a service from " + service.toString() + ", the ride is assigned to " +
                           this.vehicles.get(vehicleIndex).getClass().getSimpleName() + " " + this.vehicles.get(vehicleIndex).getId() + " at location " +
                           this.vehicles.get(vehicleIndex).getLocation().toString());
            
            // update the counter of services
            
            this.totalServices++;
            
            return true;
        }
        
        return false;
    }

    @Override
    public void arrivedAtPickupLocation(IVehicle vehicle) {
        // a vehicle arrives at the pickup location
        
        notifyObserver(String.format("%-8s",vehicle.getClass().getSimpleName()) + vehicle.getId() + " loads user " + vehicle.getService().getUser().getID());
    }
    
    @Override
    public void arrivedAtDropoffLocation(IVehicle vehicle) {
        // a vehicle arrives at the drop-off location
        
        IServices service = vehicle.getService();       
        int user = service.getUser().getID();
        int userIndex = indexOfUserId(user);
       
        // the taxi company requests the user to rate the service, and updates its status

        this.users.get(userIndex).rateService(service);
        this.users.get(userIndex).setService(false);

        // update the counter of services
        
        this.totalServices--;    
        
        notifyObserver(String.format("%-8s",vehicle.getClass().getSimpleName()) + vehicle.getId() + " drops off user " + user);         
    }
        
    @Override
    public void addObserver(IObserver observer) {
        this.observer = observer;
    }
    
    @Override
    public void notifyObserver(String message) {
        this.observer.updateObserver(message);
    }
    
    private int findFreeVehicle() {
        // finds a free vehicle and returns the index of the vehicle in the list, otherwise it returns -1
    	// we find a free vehicle, the initial position is going to be different every time we perform a search
    	// lower positions of the array are returned 50% of the time the search is done
    	// higher positions of the array are returned 50% of the time the search is done
    	
    	if(ApplicationLibrary.rand() % 2 == 0) {
    		for(IVehicle v : this.vehicles) {
    			if(v.isFree()) 
    				return this.vehicles.indexOf(v);     // returns the index of the vehicle v in the list 	
    		}
    	}
    	else {
    		for(int i = this.vehicles.size() -1 ; i >=0; i--) {
    			if(this.vehicles.get(i).isFree()) 
    				return i;			
    		}
    	}
    	return -1;
    	
    }
    
    
    private int indexOfUserId(int id) {
        // finds the index of a user with the input id in the list, otherwise it returns -1
    	// we traverse the list and check if the id is the same as in the current position being searched
    	
    	for(int i = 0; i < this.users.size(); i++) {
    		if(this.users.get(i).getID() == id) {   // if id = the id of the user at position i
    			return i;
    		}	
    	}

    	return -1; // if we break out of the search without finding the corresponding index to the id, we return -1
    }

	@Override
	public String getname() {
		return this.name;
	}
    
}