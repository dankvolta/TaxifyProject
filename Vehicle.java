package taxify;

import java.util.ArrayList;

// implement Functions 
import java.util.List;


public abstract class Vehicle implements IVehicle{
	private int id;
	private ITaxiCompany company;
	private VehicleStatus status;
	private ILocation location;
	private ILocation destination;
	private IStatistics statistics;
	private IServices service;
	private List<ILocation> drive;
	
	public Vehicle(int id,  ILocation location) {
		this.id = id;
		this.service = null;
		this.location = location;
		this.status = VehicleStatus.FREE;
		this.location = location;
		this.destination =  ApplicationLibrary.randomLocation(this.location);
		this.statistics = new Statistics();		// we initialize this as new so all attributes are 0
		this.drive = setDrivePathToDestination(this.location, this.destination);
	}

	@Override
	public int getId() {
		return this.id;
	}

	@Override
	public ILocation getLocation() {
		return this.location;
	}

	@Override
	public ILocation getDestination() {
		return this.destination;
	}

	@Override
	public IServices getService() {
		return this.service;
	}

	@Override
	public IStatistics getStatistics() {
		return this.statistics;
	}
	
	@Override
	public void setCompany(ITaxiCompany company) {
		this.company = company;
	}
	
	@Override
	public void pickService(IServices s) {
		this.service = s;
		this.destination = service.getPickUp();
		this.drive = setDrivePathToDestination(this.location, this.destination);
		this.status = VehicleStatus.PICKUP;
		
	}

	@Override
	public void startService() {
		this.destination = this.service.getDropOff();		// we set the destination to the drop off location
		this.drive =  setDrivePathToDestination(this.location, this.destination);
        this.status = VehicleStatus.SERVICE;
	}

	@Override
	public void endService() {
		// update the vehicles stats in terms of billing, distance and service
		this.statistics.updateBilling(this.calculateCost());
		this.statistics.updateDistance(this.service.calculateDistance());
		this.statistics.updateService(); 
		
		// if the users rates the service, then we update the stars as well as the reviews
		if(this.service.getStars() != 0) {
			this.statistics.updateStars(this.service.getStars());
			this.statistics.updateReviews();
			
		}
		// we update the distance, the drive the service and the status
		this.destination = ApplicationLibrary.randomLocation(this.location);
		this.drive = setDrivePathToDestination(this.location, this.destination); 		// we set a new path for the drive
		this.service = null;
		this.status = VehicleStatus.FREE;
	}
	
	
	 
     //When the Vehicle arrives at pick-up location the company is notified
     // Starts ride service  
	@Override
	public void notifyArrivalPickUp(IVehicle v) {
		this.company.arrivedAtPickupLocation(this);
		this.startService();
		
	}

	@Override
	public void notifyArrivalDropOff() {
		this.company.arrivedAtDropoffLocation(this);
		this.endService();
		
	}

	@Override
	public boolean isFree() {
		return (this.status == VehicleStatus.FREE);
	}

	// Simulates a vehicle moving from location to location 
	@Override
	public void move() {
		// lets get the next location from the drive path
		this.location = this.drive.get(0);
		this.drive.remove(0);
		
		if(this.drive.isEmpty()) {
			if(this.service == null) {
				// then the vehicle will continue its random drive
				this.destination =  ApplicationLibrary.randomLocation(this.location);
				this.drive = setDrivePathToDestination(this.location, this.destination);
			}
		}
		else {
			// we check is the vehicle has arrived to a pickup or dropp off
			ILocation origin = this.service.getPickUp();
			ILocation destination = this.service.getDropOff();
			
			// if the currents services origin and destination coincide with either the coordinates of the pick up or the drop off locations
			if(this.location.getX() == origin.getX() && this.location.getY() == origin.getY()) {
				notifyArrivalPickUp(this);
			}
			else if(this.destination.getX() == destination.getX() && this.destination.getY() == destination.getY()){}
				this.notifyArrivalDropOff();
			}
		
		
	}

	@Override
	public int calculateCost() {
		return this.service.calculateDistance();
	}

	
	@Override
    public String showDrive() {
        String s = "";
       
           for (ILocation l : this.drive)
               s = s + l.toString() + " ";
       
           return s;
    }

	
	private List<ILocation> setDrivePathToDestination(ILocation location, ILocation destination) { 
        List<ILocation> drive = new ArrayList<ILocation>();
        
        // we set the coordinates
        int x1 = location.getX();
        int y1 = location.getY();
        
        int x2 = destination.getX();
        int y2 = destination.getY();
        
        // we calculate the distances 
        int dx = Math.abs(x1 - x2);
        int dy = Math.abs(y1 - y2);
       
        for (int i=1; i<=dx; i++) {
            x1 = (x1 < x2) ? x1 + 1 : x1 - 1;

            drive.add(new Location(x1, y1));
        }
        
        for (int i=1; i<=dy; i++) {
            y1 = (y1 < y2) ? y1 + 1 : y1 - 1;
            
            drive.add(new Location(x1, y1));
        }
        
        return drive;
    } 
	
	 @Override
	    public String toString() {
		 return  this.id + " at " + this.location + " driving to " + this.destination +
	               ((this.status == VehicleStatus.FREE) ? " is free with path " + showDrive() : 
	                ((this.status == VehicleStatus.PICKUP) ? " to pickup user " + this.service.getUser().getID() : " in service "));
	    }
}
