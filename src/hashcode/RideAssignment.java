package hashcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RideAssignment {

  private static final char NEW_LINE = '\n';
  private static final char SPACE = ' ';

  private final Map<Vehicle, List<Ride>> rideAssignment;

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

  private static String getVehicleSolution(List<Ride> rides) {
    StringBuilder ridesSolution = new StringBuilder();

    ridesSolution.append(rides.size());
    for (Ride ride : rides) {
      ridesSolution.append(SPACE);
      ridesSolution.append(ride.getIndex());
    }
    return ridesSolution.toString();
  }

  public String getSolution() {
    StringBuilder solution = new StringBuilder();

    for (List<Ride> rides : rideAssignment.values()) {
      solution.append(getVehicleSolution(rides));
      solution.append(NEW_LINE);
    }
    return solution.toString();
  }
}
