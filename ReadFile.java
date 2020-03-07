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
                    //System.out.println(data);
                    System.out.println(data.substring(data.indexOf("kort ")+5, data.indexOf(" vid")));

                    Matcher m = Pattern.compile("\\(([^)]+)\\)").matcher(data);
                    while(m.find()) {
                        System.out.println("employee ID: " + m.group(1));    
                    }
                    if (data.contains("Personal lunchläsare")){
                        System.out.println("Personal Lunch");
                    }else if(data.contains("Representativ lunchläsare")){
                        System.out.println("Representativ Lunch");
                    }else if(data.contains("Pedagogisk lunchläsare")){
                        System.out.println("Pedagogisk Lunch");
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
