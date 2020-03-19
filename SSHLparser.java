import java.io.*;
import java.util.*;

public class SSHLparser{
    public static void main(String args[]){
        List<Person> P = new ArrayList<Person>();
        P.add(new Person("Raymond S", "666", "2020-xx-xx"));
        P.get(0).printAll();
        P.get(0).addDate("2020-1-2");
        P.get(0).countLunch("Pedagogisk");
        P.get(0).countLunch("Pedagogisk");
        P.get(0).countLunch("Representativ");
        P.get(0).countLunch("Personal");
        P.get(0).countLunch("Personal");
        P.get(0).countLunch("fuck");
        P.get(0).printAll();
    }
}
