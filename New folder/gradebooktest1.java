//constructors are type of methods but it doesnt have any type it takes the values directly while declaring object 
//it has same name as the object class
//constructor method which creating objects and initialising the objects at the same time
//stter methods in which aftercreating the objects the objects are intialised using setter metthods it kaes severaal call to set
import java.util.*;
 class gradebook{
    private String coursename; //instance should be private
    public void setcourseName(String name){
       coursename=name;
    }
    public String getcourseName(){   //as we are returning coursename so it should be string datatype
        return coursename;
    }
    public void display(){
        System.out.printf("%s",getcourseName());
    }
}
public class Gradebooktest{
    public static void main(String args[]){
      Scanner sc=new Scanner(System.in);
      String name=sc.nextLine();
      gradebook book1=new gradebook();
      System.out.printf("%s",book1.getcourseName());
      book1.setcourseName(name);
      book1.display();
    }
}
// if you dont create any constructor and dont use any setter methods it automatically storesnull which is called as default constructor
//setter methods also be used eventhough constructor is created because constructor only initialises when the object is created and when its data is there when creation it cant modify after creation
//setter methods be usedd to modify even after the creation of object and to create the object when the data is not present during creation
//gettermethod makes it safe and secure it makes encapsulation it makes the accesss of priveate variables safely
