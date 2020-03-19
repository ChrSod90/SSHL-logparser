import java.io.*;
import java.util.*;
import java.util.regex.*;

public class SSHLparser{
    public static void main(String args[]){
        String date = "N/A";
        HashMap<String, Person> sshl = new HashMap<String, Person>();

        try {
            File myObj = new File(args[0]);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                String name = " ";
                String id = " ";
                String lunch = " ";
                if (data.contains("<timestamp>")) {
                    date = data.substring(11, 22);
                }
                
                if (data.contains("<description>Giltigt kort "))
                    {
                        name = data.substring(data.indexOf("kort ")+5, data.indexOf(" vid"));

                        Matcher m = Pattern.compile("\\(([^)]+)\\)").matcher(data);
                        while(m.find()) {
                            id = m.group(1);
                        }

                        if (data.contains("Personal lunchläsare")){
                            lunch = "Personal";
                        }else if(data.contains("Pedagogisk lunchläsare")){
                            lunch = "Pedagogisk";
                        }else if(data.contains("Representativ lunchläsare")){
                            lunch = "Representativ";
                        }else{
                            lunch = "ERROR";
                        }
                        //System.out.println(name + " " + id + " " + lunch + " " + date);

                        if(sshl.containsKey(id)){
                            sshl.get(id).countLunch(lunch);
                            sshl.get(id).addDate(date);
                        }else{
                            sshl.put(id, new Person(name, id, date));
                            sshl.get(id).countLunch(lunch);
                        }
                        
                        //sshl.get(id).printAll();
                    }
            }
            myReader.close();
            for (String i : sshl.keySet()) {
                sshl.get(i).printAll();
                System.out.println(" ");
            }
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
