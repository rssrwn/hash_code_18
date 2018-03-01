import java.io.BufferedReader;
import java.io.FileReader;

public class Parser {

  public Parser() {

  }

  public void readFile(String fileName) {
    BufferedReader br;
    try {
      br = new BufferedReader(new FileReader(fileName));

      String line;
      while ((line = br.readLine()) != null) {
        System.out.println(line);
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

}
