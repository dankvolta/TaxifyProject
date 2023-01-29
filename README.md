                     #                                      TAXIFY :
 This repository will include a software development project 

Taxify is an eco-friendly transportation company committed to operational excellence. Taxify offers
high-quality rides at affordable prices using modern low carbon emission taxis and shuttles. In the
short term, the company is planning to offer micro-mobility services with electric scooters and
bikes. The core values of Taxify are safety, sustainability, and innovation.

Users can choose taxis or shuttles, depending on their destinations. Taxis offer rides to any city
location, while shuttles only travel to specific destinations such as airports, attractions, or malls.
Vehicles have three different statuses: free, in service, or in a ride. Free vehicles are moving along
the city, ready to pick up a new ride. In-service vehicles are moving to pick up a user. Finally,
vehicles in a ride are moving to the user drop off location.

When a user requests a ride, the application finds the closest free vehicle to the user location.
Each service has a pickup and a drop off location. The rate for traveling one city block is 2 euros
for taxis and 1.5 euros for shuttles. Users can rate the service provided by the driver giving it 1 to
5 stars. Users can cancel a service if the vehicle has not reached the pickup location.
The application keeps track of the statistics of each vehicle. This includes the total services, the
total distance traveled, total billing, and the average user rating. When Taxify receives a service
request from a user, it books the closest vehicle to the user location and sets the status of the
vehicle to in service. When a vehicle arrives at a pickup location, the driver starts the ride, and the
company receives a notification. Similarly, when a user is dropped off, the vehicle is free, and the
company is notified.



Users can manage their taxi travel needs, keeping track of their rides and costs with simple and
usable reports.
The application randomly assigns the type of vehicle, taxi or shuttle, for each user request. User
requests are also random. Each time the application is run, it initializes randomly 5 vehicles and
15 users.
For simplicity, the city map is modeled using a 10𝑥10 grid. There are no obstacles in the map,
so map coordinates (0,0) to (9,9) are valid locations for users and vehicles. The test program
initializes the map with 5 to 10 vehicles and 10 to 15 users. Vehicles and users are randomly
located at any coordinate of the map. One or more user or vehicle may be at the same location at
the same time.



Vehicles are in constant movement on the map during the simulation. Free vehicles move along
the map, in-service vehicles move to a user pick up location, and vehicles on a ride move to the
user drop off location. In addition to the initial services requests, new users and service requests
may be created. The simulation ends when there are no more service requests and all the rides
reach their drop off locations. Finally, it shows the statistics.
