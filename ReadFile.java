import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner; 
import java.io.FileWriter; 
import java.io.IOException; 

public class ReadFile {
  public static void main(String[] args) {
    try {
      File myObj = new File(args[0]);
      Scanner myReader = new Scanner(myObj);
      while (myReader.hasNextLine()) {
        String data = myReader.nextLine();
        if (data.contains("<timestamp>")) {
          System.out.println(data);
        }
        if (data.contains("<description>Giltigt kort ")) {
          System.out.println(data);
        }
      }
      myReader.close();
    } catch (FileNotFoundException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
  }
}