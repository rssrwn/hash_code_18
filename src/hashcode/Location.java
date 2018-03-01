package hashcode;

import static java.lang.Math.abs;

public class Location {

  private int c;
  private int r;

  public Location(int x, int y) {
    this.c = x;
    this.r = y;
  }

  public static int calculateDistance(Location start, Location finish) {
    return abs(start.c - finish.c) + abs(start.r - finish.r);
  }

  public int distanceTo(Location location) {
    return calculateDistance(this, location);
  }

  public int getC() {
    return c;
  }

  public void setC(int c) {
    this.c = c;
  }

  public int getR() {
    return r;
  }

  public void setR(int r) {
    this.r = r;
  }

  @Override
  public String toString() {
    return "hashcode.Location{" +
        "c=" + c +
        ", r=" + r +
        "}\n";
  }
}
