package hashcode.algo1;

import hashcode.City;
import hashcode.Ride;
import hashcode.RideAssignment;
import hashcode.Vehicle;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.PriorityQueue;

public class Greedy {

  private static class Pair<K, E> {
    K key;
    E elem;

    public Pair(K key, E elem) {
      this.key = key;
      this.elem = elem;
    }
  }

  public static RideAssignment greedySolution(City city) {
    ArrayList<Ride> sortedRidesByStartTime = new ArrayList<Ride>(city.getRideList());
    sortedRidesByStartTime.sort((r1, r2) -> Integer.compare(r1.getEarliestStartTime(), r2.getEarliestStartTime()));

    ArrayDeque<Vehicle> freeVehicles = new ArrayDeque<>(city.getVehicleList());
    PriorityQueue<Pair<Vehicle, Ride>> busyVehicles = new PriorityQueue<>(
        (p1, p2) -> Integer.compare(p1.elem.getLatestFinishTime(), p2.elem.getLatestFinishTime()));

    long step = 0;
    int curRideIndex = 0;
    int nextRideFinish;
    while (step < city.getMaxSteps()) {
      nextRideFinish = Integer.MAX_VALUE;

      Iterator<Pair<Vehicle, Ride>> busyIt = busyVehicles.iterator();
      while (busyIt.hasNext()) {
        Pair<Vehicle, Ride> ridePair = busyIt.next();
        if (step >= ridePair.elem.getLatestFinishTime()) {
          busyIt.remove();
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
          busyVehicles.add(new Pair<Vehicle, Ride>(vehicle, bestRide));
        }
      }

      step += nextRideFinish;
    }

    return null;
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
