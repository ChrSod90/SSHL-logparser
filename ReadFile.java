import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner; 
import java.io.FileWriter; 
import java.io.IOException; 
import java.util.regex.*;


public class ReadFile {
    public static void main(String[] args) {
        String date = "0";
        try {
            File myObj = new File(args[0]);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                
                if (data.contains("<timestamp>")) {
                    date = data;
                }
                if (data.contains("<description>Giltigt kort ")) {
                    System.out.println(date);
                    System.out.println(data);
                    Matcher m = Pattern.compile("\\(([^)]+)\\)").matcher(data);
                    while(m.find()) {
                        System.out.println("employee ID: " + m.group(1));    
                    }
                    System.out.println("");
                                       
                }
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}


