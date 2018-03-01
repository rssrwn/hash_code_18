package hashcode;

public class Vehicle {

  private Location location;

  public Vehicle(Location location) {
    this.location = location;
  }

  public Location getLocation() {
    return location;
  }

  public void setLocation(Location location) {
    this.location = location;
  }

  @Override
  public String toString() {
    return "hashcode.Vehicle{" +
        "location=" + location +
        "}\n";
  }
}
