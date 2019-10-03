import java.io.*;
import java.util.ArrayList;

public class Attempt1 {
    public static void main (String[] args) {
        try {
            File sample = new File("sample.txt");
            FileReader read = new FileReader(sample);
            BufferedReader reader = new BufferedReader(read);
            
            int datasets = Integer.parseInt(reader.readLine());
            String[][][] data = new String[datasets][2][];
            System.out.println("Analyzing " + datasets + " data sets\n");
            
            for(int i = 0; i < datasets; i++) {
                int numC = Integer.parseInt(reader.readLine());
                data[i][0] = new String[numC];
                for (int x = 0; x < numC; x++) {
                    data[i][0][x] = reader.readLine();
                }
                int numK = Integer.parseInt(reader.readLine());
                data[i][1] = new String[numK];
                for (int y = 0; y < numK; y++) {
                    data[i][1][y] = reader.readLine();
                }
            }
            System.out.println(data[0][0][0]);
            reader.close();
        } catch(Exception ex) {
            ex.printStackTrace();
        }
        for (int d = 0; d < data.length; d++) {
            System.out.println("Data Set " + d);
            System.out.println("Correct Words: " + data[d][0].length);
            System.out.println("Test Words: " + data[d][1].length);
        }
    }
}