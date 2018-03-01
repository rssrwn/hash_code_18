package hashcode;

import hashcode.algo1.Greedy;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;


public class Solution {

  private static final String INPUT_EXT = ".in";
  private static final String OUTPUT_EXT = ".out";

  public static void main(String[] args) {
    List<String> filenames = new ArrayList<>();
    filenames.add("input_data/a_example");
    filenames.add("input_data/b_should_be_easy");
    filenames.add("input_data/c_no_hurry");
    filenames.add("input_data/d_metropolis");
    filenames.add("input_data/e_high_bonus");

    for (String filename : filenames) {
      generateSolution(filename);
    }
  }

  private static void generateSolution(String filename) {
    City city = Parser.parseCity(filename + INPUT_EXT);
    RideAssignment assignment = Greedy.greedySolution(city);
    String solution = assignment.getSolution();

    try {
      PrintWriter printWriter = new PrintWriter(filename + OUTPUT_EXT);
      printWriter.println(solution);
      printWriter.close();
    } catch (FileNotFoundException e) {
      throw new RuntimeException("generateSolution error");
    }
  }

}
