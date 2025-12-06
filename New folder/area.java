import static java.lang.Math.*;
import java.util.*;
public class area{

    public static void main(String args[]){
        System.out.println("Question 3: ");
        Scanner sc = new Scanner(System.in);
        float r=sc.nextFloat();

        double areaofcircle=Math.PI*pow(r,2);

        System.out.println("Area: "+areaofcircle);
        System.out.printf("Formatted area: %010.2f%n",areaofcircle);
    }
}