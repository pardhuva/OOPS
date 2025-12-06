import java.util.*;
class student{
      String name;
      int rollno;
      int age;
    void intialise(String name,int rollno,int age){

        this.name = name;
        this.age=age;
        this.rollno=rollno;
    }

     String printname(){
         
         return name;           //method without parmeters and a return type;
     }
     
     boolean eligible(String name,int age){
        boolean result;
        System.out.println("student name: "+name);
        if(age>18){
            result = true;
        }
        else{
            result = false;    //method with two parameters and a return type
        }
        return result;
     }

    void iseven(){

        if(this.rollno%2==0){
            System.out.println("even");
        }                                         //method without parameters and without return type
        else{
            System.out.println("odd");
        }
    }

    static String category(int age){
        String result;

        if(age>18){
           result="major";                     //static method accept data and return result
        }
        else{
            result="minor";
        }
        return result;
    }
    
    void printrollno(){

        System.out.println(this.rollno);         //method that can access instance variables
    }                                               

}

class studentclass{
     
    public static void main(String args[]){
        System.out.println("Question 4: ");
        Scanner sc=new Scanner(System.in);
        student stud=new student();
        String name=sc.nextLine();
        int rollno=sc.nextInt();
        int age=sc.nextInt();

        stud.intialise(name,rollno,age);

        String strname=stud.printname();
        System.out.println(strname);

        boolean bool=stud.eligible(name,age);
        System.out.println(bool);

        String cat=stud.category(age);
        System .out.println(cat);

        stud.printrollno();

         stud.iseven();
    }
}