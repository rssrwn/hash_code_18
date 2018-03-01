package hashcode;

public class Ride {

  private final int rideNumber;
  private final Location startLocation;
  private final Location finishLocation;
  private final int distance;
  private final int earliestStartTime;
  private final int latestFinishTime;

  public Ride(int i, Location start, Location finish, int earliestStart,
      int latestFinish) {
    this.rideNumber = i;
    this.startLocation = start;
    this.finishLocation = finish;
    this.distance = Location.calculateDistance(start, finish);
    this.earliestStartTime = earliestStart;
    this.latestFinishTime = latestFinish;
  }

  public int getRideNumber() {
    return rideNumber;
  }

  public Location getStartLocation() {
    return startLocation;
  }

  public Location getFinishLocation() {
    return finishLocation;
  }

  public int getEarliestStartTime() {
    return earliestStartTime;
  }

  public int getLatestFinishTime() {
    return latestFinishTime;
  }

  @Override
  public String toString() {
    return "hashcode.Ride{" +
        "rideNumber=" + rideNumber +
        ", startLocation=" + startLocation +
        ", finishLocation=" + finishLocation +
        ", earliestStartTime=" + earliestStartTime +
        ", latestFinishTime=" + latestFinishTime +
        "}\n";
  }
}
