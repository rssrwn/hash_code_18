package hashcode.algo2;

import hashcode.*;

import java.util.ArrayList;
import java.util.List;

public class TraverseRides {

  List<Integer> vehicleSimTimes;
  RideAssignment rideAssignment;
  City city;

  public TraverseRides(City city) {
    this.vehicleSimTimes = new ArrayList<>();
    this.city = city;
    for (int i=0; i<city.getVehicleList().size(); i++) {
      vehicleSimTimes.add(0);
    }
    rideAssignment = new RideAssignment();

    for (Ride ride : city.getRideList()) {
      assignRide(ride, city.getVehicleList());
    }
  }
  
  public RideAssignment getRideAssignment() {
    return rideAssignment;
  }

  public void assignRide(Ride ride, List<Vehicle> vehicles) {
    int bestScore = -1;
    Vehicle currVehicle = vehicles.get(0);
    for (Vehicle vehicle : vehicles) {
      int score = score(vehicle, ride, vehicleSimTimes, city);
      if (score > bestScore) {
        bestScore = score;
        currVehicle = vehicle;
      }
    }
    rideAssignment.addAssignment(currVehicle, ride);
  }

  public void updateSimTime(Vehicle vehicle, int addedTime) {
    int oldTime = vehicleSimTimes.get(vehicle.getIndex());
    vehicleSimTimes.set(vehicle.getIndex(), oldTime + addedTime);
  }

  public int getSimTime(Vehicle vehicle) {
    return vehicleSimTimes.get(vehicle.getIndex());
  }

  public static boolean canCompleteRide(Vehicle vehicle, Ride ride, List<Integer> simTimes) {
    int simTime = simTimes.get(vehicle.getIndex());
    return simTime - ride.getDistance() <= ride.getLatestFinishTime();
  }

  public static boolean canGetBonus(Vehicle vehicle, Ride ride, List<Integer> simTimes) {
    int simTime = simTimes.get(vehicle.getIndex());
    int dist = vehicle.getLocation().distanceTo(ride.getStartLocation());
    return simTime + dist == ride.getEarliestStartTime();
  }

  public static int waitTime(Vehicle vehicle, Ride ride, List<Integer> simTimes) {
    int simTime = simTimes.get(vehicle.getIndex());
    int dist = vehicle.getLocation().distanceTo(ride.getStartLocation());
    int wait = (simTime + dist) - ride.getEarliestStartTime();
    if (wait < 0) {
      wait = 0;
    }
    return wait;
  }

  public static int score(Vehicle vehicle, Ride ride, List<Integer> simTimes, City city) {
    if (canCompleteRide(vehicle, ride, simTimes)) {
      int wait = waitTime(vehicle, ride, simTimes);
      int dist = vehicle.getLocation().distanceTo(ride.getStartLocation());
      int totalDist = dist + ride.getDistance();
      int score = wait + totalDist;
      if (canGetBonus(vehicle, ride, simTimes)) {
        score += city.getPerRideBonus();
      }
      return score / totalDist;
    }
    return -1;
  }
}
