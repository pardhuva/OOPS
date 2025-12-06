//inheritance
//one class all properties is inherited(taken) by another class is called as inheritance
//we will inherit by using extends

//four types of inheritance -single level inheritance,mutilevel

//until we invoke the base class in derived class even we extends it wont print the data in base class 
//it is just useful that we can access from another class and for the variables we no need to invoke the base class
class shape{
   String color;
}
class triangle extends shape {
    public void printcolor(){
    System.out.println(this.color);
    }
}
public class inheritance{
    public static void main(String args[]){
        triangle t1=new triangle();
        t1.color="red";            //setting the color
        t1.printcolor();
    } 
}

//single level inheritance contains one base class and the derived class  only once it extends

class shape{
    public void area(){
        System.out.println("displays area");
    }
}
 class triangle extends shape{
    public void area(int l,int h){
        System.out.println(0.5*l*h);
    }
 }

 public class inheritance{
    public static void main(String args[]){
        triangle t1= new triangle();
        t1.area(3,4);
    }
 }

 //mutilevel inheritance-one base class and many derived classes

 class shape{
    public void area(){
        System.out.println("displays area");
    }
}
 class triangle extends shape{
    public void area(int l,int h){
        System.out.println(0.5*l*h);
    }
 }
class equilateraltriangle extends triangle{
    System.out.println("it is not");
}

 public class inheritance{
    public static void main(String args[]){
        triangle t1= new triangle();
        t1.area(3,4);
    }
 }


 //heirachial inheritance   two derived extends the same base class
                             
 class shape{
    public void area(){
        System.out.println("displays area");
    }
}
 class triangle extends shape{
    public void area(int l,int h){
        System.out.println(0.5*l*h);
    }
 }

 class circle extends shape{[
    public void area(int r){
        System.out.println(3.14*r*r); 
    }
 ]}
 public class inheritance{
    public static void main(String args[]){
        triangle t1= new triangle();
        t1.area(3,4);
    }
 }

 //hybrid inheritance
 