package hashcode.algo1;

import hashcode.City;
import hashcode.Vehicle;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class Greedy {

  public static RideAssignment greedySolution(City city) {
    ArrayDeque<Vehicle> freeVehicles = new ArrayDeque<>(city.getVehicleList());
    ArrayDeque<Vehicle> busyVehicles = new ArrayDeque<>();

    int step = 0;
    while (step < city.getMaxSteps()) {

      while (freeVehicles.size() > 0) {
        Vehicle vehicle = freeVehicles.pop();
      }

    }

    return null;
  }

}
