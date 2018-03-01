package hashcode.algo1;

import hashcode.City;
import hashcode.Parser;
import hashcode.Ride;
import hashcode.RideAssignment;
import hashcode.Vehicle;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.PriorityQueue;

public class Greedy {

  private static class RidePair {
    Ride ride;
    Vehicle vehicle;
    int finishTime;

    public RidePair(Ride ride, Vehicle vehicle, int finishTime) {
      this.ride = ride;
      this.vehicle = vehicle;
      this.finishTime = finishTime;
    }
  }

  public static void main(String[] args) {
    City city = Parser.parseCity("input_data/a_example.in");
    greedySolution(city);
  }

  public static RideAssignment greedySolution(City city) {
    RideAssignment rideAssignment = new RideAssignment();

    ArrayList<Ride> sortedRidesByStartTime = new ArrayList<Ride>(city.getRideList());
    sortedRidesByStartTime.sort((r1, r2) -> Integer.compare(r1.getEarliestStartTime(), r2.getEarliestStartTime()));

    ArrayDeque<Vehicle> freeVehicles = new ArrayDeque<>(city.getVehicleList());
    PriorityQueue<RidePair> busyVehicles = new PriorityQueue<>(
        (p1, p2) -> Integer.compare(p1.finishTime, p2.finishTime));

    long step = 0;
    int curRideIndex = 0;
    int nextRideFinish;
    while (step < city.getMaxSteps()) {
      nextRideFinish = Integer.MAX_VALUE;
      //System.out.println("step " + step);

      Iterator<RidePair> busyIt = busyVehicles.iterator();
      while (busyIt.hasNext()) {
        RidePair ridePair = busyIt.next();

        if (step >= ridePair.finishTime) {
          busyIt.remove();
          freeVehicles.add(ridePair.vehicle);
          System.out.printf("vehicle %d ride %d removed from busy at step %d\n", ridePair.vehicle.getIndex(), ridePair.ride.getIndex(), step);
        } else {
          break;
        }
      }

      Iterator<Vehicle> freeIt = freeVehicles.iterator();
      while (freeIt.hasNext()) {
        Vehicle vehicle = freeIt.next();

        // Choose best ride for vehicle
        int bestScore = Integer.MIN_VALUE;
        Ride bestRide = null;
        for (int i = curRideIndex; i < sortedRidesByStartTime.size(); i++) {
          Ride ride = sortedRidesByStartTime.get(i);
          int rideScore = rideScore(city, (int) step, ride, vehicle);
          if (rideScore > bestScore) {
            bestScore = rideScore;
            bestRide = ride;
          }
        }
        if (bestRide != null) {
          nextRideFinish = Math.min(nextRideFinish, rideFinishTime((int) step, bestRide, vehicle));
          freeIt.remove();
          sortedRidesByStartTime.remove(bestRide);
          busyVehicles.add(new RidePair(bestRide, vehicle, nextRideFinish));
          rideAssignment.addAssignment(vehicle, bestRide);
          System.out.printf("vehicle %d ride %d added to busy at step %d\n", vehicle.getIndex(), bestRide.getIndex(), step);
        }
      }

      step += nextRideFinish;
    }

    return rideAssignment;
  }

  private static int rideScore(City city, int step, Ride ride, Vehicle vehicle) {
    int distanceToRideStart = vehicle.getLocation().distanceTo(ride.getStartLocation());
    int timeUntilStart = ride.getEarliestStartTime() - step;

    int bonus = distanceToRideStart < timeUntilStart ? city.getPerRideBonus() : 0;
    int waitTime = Integer.max(timeUntilStart, distanceToRideStart);

    int rideScore = ride.getDistance() + bonus - waitTime;
    return rideScore;
  }

  private static int rideFinishTime(int step, Ride ride, Vehicle vehicle) {
    int distanceToRideStart = vehicle.getLocation().distanceTo(ride.getStartLocation());
    int timeUntilStart = ride.getEarliestStartTime() - step;

    int waitTime = Integer.max(timeUntilStart, distanceToRideStart);

    return waitTime + ride.getDistance() + step;
  }

}
