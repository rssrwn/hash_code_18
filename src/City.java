import java.util.List;

public class City {

  private final int rows;
  private final int cols;
  private final int perRideBonus;
  private List<Vehicle> vehicleList;
  private List<Ride> rideList;
  private int steps;

  public City(int rows, int cols, int perRideBonus,
      List<Vehicle> vehicleList, List<Ride> rideList) {
    this.rows = rows;
    this.cols = cols;
    this.perRideBonus = perRideBonus;
    this.vehicleList = vehicleList;
    this.rideList = rideList;
    this.steps = 0;
  }
}
