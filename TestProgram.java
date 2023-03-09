package taxify;

import java.util.ArrayList;
import java.util.List;

public class TestProgram {

    public static void main(String[] args) {
    	
    	// lets declare a list of 15 users 
    	List<IUser> users = new ArrayList<IUser>();

    	IUser u1 = new User(0, "Misa", "Amane", false);
    	IUser u2 = new User(1, "Josh", "Jackson", false);
    	IUser u3 = new User(2, "Lia", "Thompson", false);
    	IUser u4 = new User(3, "Noel", "Miller", false);
    	IUser u5 = new User(4, "Brad", "Cohen", false);
    	IUser u6 = new User(5, "Nelly", "Adams", false);
    	IUser u7 = new User(6, "Lia", "Thompson", false);
    	IUser u8 = new User(7, "Noel", "Miller", false);
    	IUser u9 = new User(8, "Brad", "Cohen", false);
    	IUser u10 = new User(9, "Nelly", "Adams", false);
    	IUser u11 = new User(10, "Lia", "Thompson", false);
    	IUser u12 = new User(11, "Noel", "Miller", false);
    	IUser u13 = new User(12, "Brad", "Cohen", false);
    	IUser u14 = new User(13, "Nelly", "Adams", false);
    	IUser u15 = new User(14, "Lia", "Thompson", false);
    	
    	users.add(u1);
    	users.add(u2);
    	users.add(u3);
    	users.add(u4);
    	users.add(u5);
    	users.add(u6);
    	users.add(u7);
    	users.add(u8);
    	users.add(u9);
    	users.add(u10);
    	users.add(u11);
    	users.add(u12);
    	users.add(u13);
    	users.add(u14);
    	users.add(u15);
    	
    	// Lets declare a list of at least 10 vehicles and set them up in different locations
    	List<IVehicle> vehicles = new ArrayList<IVehicle>();
    	
    	IVehicle v1 = new Taxi(123, ApplicationLibrary.randomLocation());
    	IVehicle v2 = new Taxi(578, ApplicationLibrary.randomLocation());
    	IVehicle v3 = new Shuttle(144, ApplicationLibrary.randomLocation());
    	IVehicle v4 = new Taxi(123, ApplicationLibrary.randomLocation());
    	IVehicle v5 = new Shuttle(113, ApplicationLibrary.randomLocation());
    	IVehicle v6 = new Shuttle(183, ApplicationLibrary.randomLocation());
    	IVehicle v7 = new Taxi(923, ApplicationLibrary.randomLocation());
    	IVehicle v8 = new Taxi(178, ApplicationLibrary.randomLocation());
    	IVehicle v9 = new Shuttle(453, ApplicationLibrary.randomLocation());
    	IVehicle v10 = new Taxi(199, ApplicationLibrary.randomLocation());
    	IVehicle v11 = new Shuttle(345, ApplicationLibrary.randomLocation());
    	IVehicle v12 = new Taxi(783, ApplicationLibrary.randomLocation());
    	
    	vehicles.add(v1);
    	vehicles.add(v2);
    	vehicles.add(v3);
    	vehicles.add(v4);
    	vehicles.add(v5);
    	vehicles.add(v6);
    	vehicles.add(v7);
    	vehicles.add(v8);
    	vehicles.add(v9);
    	vehicles.add(v10);
    	vehicles.add(v11);
    	vehicles.add(v12);
    	
//    	 3. Instantiate the taxi company and the application simulator. Ad the application simulator as an observer of the taxy company	
    	TaxiCompany taxify = new TaxiCompany("Taxify", users, vehicles);
    	AppSim application = new AppSim(taxify, users, vehicles);
    	
    	taxify.addObserver(application);
    	
    	
//    	  4. Start the simulation
//          
//          a. Show the status of the application
//          b. Simulate at least 5 requests of service
//          c. Run the simulation while there are vehicles in a service
//          
//             Show the status of the application
//             Update the state of the application
//             Simulate a request of service (randomly, to avoid request a service each iteration)
//    
        
    	application.show();
    	
    	for(int i = 1; i< 6; i++) {
    		application.requestService();
    		
    		do {
    			// we show the status of the simulation
    			application.show();
    			System.out.println("\n");
    			
    			application.update();
    			
    			
    			if(ApplicationLibrary.rand() % 4 == 0) {
    				application.requestService();
    			}
    			
    		}while(application.getTotalServices() != 0);
    		
    		// finally we show the statistics
    		application.showStatistics();
    	}
    
    	
    	
    	
	
    	
    	
    	/*
        
         1. Declare a list of users. Instantiate at least 15 users
         
            List<IUser> users = new ArrayList<IUser>()
                     
         2. Declare a list of vehicles. Instantiate at least 10 vehicles (Taxis and Shuttles) and place them at random locations of the city map
         
            List<IVehicle> vehicles = new ArrayList<IVehicle>();
         
         3. Instantiate the taxi company and the application simulator. Ad the application simulator as an observer of the taxy company

            TaxiCompany taxify = new TaxiCompany("Taxify", users, vehicles);
            ApplicationSimulator application = new AppSim(taxify, users, vehicles);
        
            taxify.addObserver(application);
         
         4. Start the simulation
         
            a. Show the status of the application
            b. Simulate at least 5 requests of service
            c. Run the simulation while there are vehicles in a service
            
               Show the status of the application
               Update the state of the application
               Simulate a request of service (randomly, to avoid request a service each iteration)
               
            d. Finally, show the statistics of the simulation as shown below
            
            Taxify statistics 

            Shuttle  1  8 services  57 km.  83 eur.  4 reviews 2.25 stars
            Taxi     2  6 services  59 km. 118 eur.  3 reviews 3.33 stars
            Shuttle  3  4 services  24 km.  35 eur.  1 reviews 3.0  stars
            Taxi     4  3 services  18 km.  36 eur.  1 reviews 4.0  stars
            Taxi     5  1 services   6 km.  12 eur.  0 reviews 0.0  stars
            Shuttle  6  1 services   7 km.  10 eur.  1 reviews 4.0  stars
            Taxi     7  1 services   3 km.   6 eur.  0 reviews 0.0  stars
            Shuttle  8  5 services  48 km.  71 eur.  3 reviews 3.33 stars
            Shuttle  9  5 services  35 km.  51 eur.  2 reviews 2.5  stars
            Shuttle 10  8 services  60 km.  87 eur.  4 reviews 3.5  stars
         
         */

    }

}