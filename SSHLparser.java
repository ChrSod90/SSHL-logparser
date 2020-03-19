import java.io.*;
import java.util.*;

public class SSHLparser{
    public static void main(String args[]){
        List<Person> P = new ArrayList<Person>();
        HashMap<String, Person> sshl = new HashMap<String, Person>();
        sshl.put("666", new Person("Raymond S", "666", "2020-xx-xx"));
        sshl.put("777", new Person("Dalle", "777", "2020-xx-xx"));
        P.add(new Person("Raymond S", "666", "2020-xx-xx"));
        // P.get(0).printAll();
        // P.get(0).addDate("2020-1-2");
        // P.get(0).countLunch("Pedagogisk");
        // P.get(0).countLunch("Pedagogisk");
        // P.get(0).countLunch("Representativ");
        // P.get(0).countLunch("Personal");
        // P.get(0).countLunch("Personal");
        // P.get(0).countLunch("fuck");
        // P.get(0).printAll();
        sshl.get("666").printAll();
        sshl.get("777").printAll();
        sshl.get("666").countLunch("Personal");
        sshl.get("777").countLunch("Representativ");
        sshl.get("666").printAll();
        sshl.get("777").printAll();
    }
}
