
//constructors
import java.util.*;
class person{
    private String name;
    person(String name){
        this.name=name;
    }
    void displayName(){
        System.out.println(name);
    }
}

public class student{
    public static void main(String args[]){
        Scanner input=new Scanner(System.in);
        System.out.print("enter your name:");
        String sc=input.nextLine();
        person person1=new person(sc);
        person1.displayName();
        input.close();
    }
}