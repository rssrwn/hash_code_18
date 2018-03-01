package hashcode;

public class Vehicle {

  private Location location;
  private int index;

  public Vehicle(Location location, int index) {
    this.location = location;
    this.index = index;
  }

  public Location getLocation() {
    return location;
  }

  public void setLocation(Location location) {
    this.location = location;
  }

  public boolean canCompleteRide(Ride ride) {
    return false;
  }

  @Override
  public String toString() {
    return "hashcode.Vehicle{" +
        "location=" + location +
        "}\n";
  }
}
