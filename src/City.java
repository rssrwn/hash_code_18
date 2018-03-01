import java.util.ArrayList;
import java.util.List;

public class City {

  private final int rows;
  private final int cols;
  private final int perRideBonus;
  private List<Vehicle> vehicleList;
  private List<Ride> rideList;
  private int maxSteps;

  public City(int rows, int cols, int perRideBonus, int maxSteps,
      int numVehicles, List<Ride> rideList) {
    this.rows = rows;
    this.cols = cols;
    this.perRideBonus = perRideBonus;
    this.maxSteps = maxSteps;
    this.vehicleList = initVehicleList(numVehicles);
    this.rideList = rideList;
  }

  private List<Vehicle> initVehicleList(int numVehicles) {
    List<Vehicle> vehicles = new ArrayList<>();
    for (int i = 0; i < numVehicles; i++) {
      vehicles.add(new Vehicle(new Location(0, 0)));
    }
    return vehicles;
  }

  @Override
  public String toString() {
    return "City{" +
        "\nrows=" + rows +
        "\ncols=" + cols +
        "\nperRideBonus=" + perRideBonus +
        "\nvehicleList=" + vehicleList +
        "\nrideList=" + rideList +
        "\nmaxSteps=" + maxSteps +
        "\n}";
  }
}
