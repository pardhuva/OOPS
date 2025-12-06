//polymorphism-different forms(same function for different purposes)
import java.util.*;
class student{
     String name;
     int rollno;
     
     student(){
                                            //default constructor
     }        
     student(student s1){
        this.name=s1.name;                  //copy constructor
        this.rollno=s1.rollno;
    }
    student(String name,int rollno){
        this.name=name;                      //parameterised constructor
        this.rollno=rollno;
    }
    public void printinfo(){
        System.out.println(this.name);
        System.out.println(this.rollno);             //method
    }

    public printinfo(String name){
        System.out.println(this.name);
    }
}

public class polymorphism{
    public static void main(String args[]){
       student s1=new student();
       s1.name="paru";            
       s1.rollno=45;       
       s1.printinfo();     //after declaring object  to initialise  the objects  no need to pass the attributes you can initilise s1.name int that way also
       student s2=new student(s1);
       s2.printinfo();
       student s3=new student("madhu",69);
       s3.printinfo();
    }
}