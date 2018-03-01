package hashcode;

import hashcode.Ride;
import hashcode.Vehicle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RideAssignment {

  Map<Vehicle, List<Ride>> rideAssignment;

  public RideAssignment() {
    this.rideAssignment = new HashMap<>();
  }

  public void addAssignment(Vehicle vehicle, Ride ride) {
    if (rideAssignment.containsKey(vehicle)) {
      List<Ride> rides = rideAssignment.get(vehicle);
      rides.add(ride);
      return;
    }

    List<Ride> rides = new ArrayList<>();
    rides.add(ride);
    rideAssignment.put(vehicle, rides);
  }

  public List<Ride> getRides(Vehicle vehicle) {
    return rideAssignment.get(vehicle);
  }
}
