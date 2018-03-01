public class Ride {

  private Location startLocation;
  private Location finishLocation;
  private int earliestStartTime;
  private int latestFinishTime;

  public Ride(Location start, Location finish, int earliestStart,
      int latestFinish) {
    this.startLocation = start;
    this.finishLocation = finish;
    this.earliestStartTime = earliestStart;
    this.latestFinishTime = latestFinish;
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

}
