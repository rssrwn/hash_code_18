package hashcode.algo1;

import hashcode.City;
import hashcode.Ride;
import hashcode.RideAssignment;
import hashcode.Vehicle;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Iterator;

public class Greedy {

  public static RideAssignment greedySolution(City city) {
    ArrayList<Ride> sortedRidesByStartTime = new ArrayList<Ride>(city.getRideList());
    sortedRidesByStartTime.sort((r1, r2) -> Integer.compare(r1.getEarliestStartTime(), r2.getEarliestStartTime()));

    ArrayDeque<Vehicle> freeVehicles = new ArrayDeque<>(city.getVehicleList());
    ArrayDeque<Vehicle> busyVehicles = new ArrayDeque<>();

    int step = 0;
    while (step < city.getMaxSteps()) {

      Iterator<Vehicle> it = freeVehicles.iterator();
      while (it.hasNext()) {
        Vehicle vehicle = it.next();
        it.remove();


      }

    }

    return null;
  }

  private static int rideScore(City city, Ride ride, Vehicle vehicle) {
    int distanceToRideStart = vehicle.getLocation().distanceTo(ride.getStartLocation());
    int rideDistance = ride.getDistance();
    return 0;
  }

}
