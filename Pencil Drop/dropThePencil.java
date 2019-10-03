import java.lang.Math;

public class dropThePencil {
    public static void main (String args []){ 
        double percent = 0;
        double radians;
        double xLength;
        double yLength;
        double area;
        double fraction;
        for (int theta = 0; theta < 90; theta++) {
            radians = Math.toRadians(theta);
            xLength = 12 - (6 * (Math.cos(radians)));
            yLength = 12 - (6 * (Math.sin(radians)));
            area = 144 - (xLength * yLength);
            fraction = area / 144;
            percent += (fraction / 90) * 100;
        }
        double roundedPercent = Math.round(percent * 1000.0) / 1000.0;
        System.out.println("The probability of a 6 in pencil landing on a crease of a floor with 12 by 12 in planes is " + roundedPercent + "%.");
    }
}