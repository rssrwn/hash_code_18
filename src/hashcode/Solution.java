package hashcode;

import java.util.Arrays;
import java.util.List;

public class Solution {

  public static void main(String[] args) {
    City cityA = Parser.parseCity("input_data/a_example.in");
    City cityB = Parser.parseCity("input_data/b_should_be_easy.in");
    City cityC = Parser.parseCity("input_data/c_no_hurry.in");
    City cityD = Parser.parseCity("input_data/d_metropolis.in");
    City cityE = Parser.parseCity("input_data/e_high_bonus.in");
    List<City> cities = Arrays.asList(cityA, cityB, cityC, cityD, cityE);

    for (City city : cities) {
      RideAssignment assignment = alngo.getAssignment(city);
      System.out.println(assignment.outputSolution());
    }
  }

}
