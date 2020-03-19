import java.util.*;

public class Person{

    String name;
    String id;
    int countPersonal;
    int countPedagogisk;
    int countRepresentativ;
    ArrayList<String> datesCounted = new ArrayList<String>(1);

    Person(String name, String id, String date){
        this.name = name;
        this.id = id;
        countPersonal = 0;
        countPedagogisk = 0;
        countRepresentativ = 0;
        datesCounted.add(date); 
    }
    
    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }
    
    public void setID(String id){
        this.id = id;
    }
    public String getID(){
        return id;
    }

    public void countLunch(String type){
        switch(type)
            {
            case "Personal":
                countPersonal++;
                break;
            case "Pedagogisk":
                countPedagogisk++;
                break;
            case "Representativ":
                countRepresentativ++;
                break;
            default:
                System.out.println("Error when incrementing countLunch (no case match for: " + type + ")");
            }
    }
    
    public int getPersonal(){
        return countPersonal;
    }
    public int getPedagogisk(){
        return countPedagogisk;
    }
    public int getRepresentativ(){
        return countRepresentativ;
    }


    public void addDate(String date){
        datesCounted.add(date);
    }
    public List getDates(){
        return datesCounted;
    }

    public void printAll(){
        System.out.println("Name: " + getName());
        System.out.println("ID: " + getID());
        System.out.println("Personal/Pedagogisk/Representativ: " + getPersonal() + " " + getPedagogisk() + " " + getRepresentativ());
        System.out.println("Dates: " + getDates());
    }
        
}
