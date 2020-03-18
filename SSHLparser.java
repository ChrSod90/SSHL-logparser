import java.io.*;

public class SSHLparser{
    public static void main(String args[]){
        Person P = new Person("Raymond S", "666", "2020-xx-xx");
        P.addDate("2020-1-2");
        P.countLunch("pedagogisk");
        P.countLunch("pedagogisk");
        P.countLunch("representativ");
        P.countLunch("personal");
        P.countLunch("personal");
        P.countLunch("fuck");
        P.printAll();
    }
}
