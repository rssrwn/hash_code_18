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

  public int getIndex() {
    return index;
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

  public int getIndex() {
    return index;
  }
}
