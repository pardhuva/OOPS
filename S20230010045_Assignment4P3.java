

import static java.lang.Math.*;
import java.text.DecimalFormat;
import java.util.Scanner;

public class Area {

    public static void main(String[] args) {
        System.out.println("Question 3: ");
        Scanner sc = new Scanner(System.in);
        float r = sc.nextFloat();

        // Calculate the area of the circle
        double areaOfCircle = PI * pow(r, 2);

        // Format the area with 7 integer digits and 2 decimal places
        DecimalFormat decimalFormat = new DecimalFormat("0000000.00");
        String formattedArea = decimalFormat.format(areaOfCircle);

        // Print the area with full precision
        System.out.println("Area: " + areaOfCircle);
        
        // Print the formatted area
        System.out.println("Formatted area: " + formattedArea);

        sc.close();
    }
}
