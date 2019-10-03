import java.lang.Math;
import java.util.Scanner;

public class nameLength{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] names = new String[10];
        boolean moreNames = true;
        for (int x = 0; moreNames && x < 10; x++) {
            String moreNamesString = "";
            System.out.println("Input Up To 10 Names: ");
            names[x] = sc.next();
            System.out.println("Do you have more names to enter?");
            if (moreNamesString.toLowerCase() == "yes" || moreNamesString.toLowerCase() == "true" || moreNamesString.toLowerCase() == "1"){
                moreNames = true;
            else if (moreNamesString.toLowerCase() == "yes" || moreNamesString.toLowerCase() == "true" || moreNamesString.toLowerCase() == "0")
            }
        }
    }  
}