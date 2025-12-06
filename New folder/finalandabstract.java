//final keyword to prevent overriding
//is superclass method is declared final then in subclass same name method cant be as it cant be overridden
//if declared final overloading can happen but overriding cant happen

//run time polymorphiism means overriding the compiler cannot say which method to invoke at runtime it knows as same name and type  this is called a s late binidng
//compile tiem polymorphism means the method to invoke is known at compile time itself  overloading comes under this callled early binding

//you can even use final to class and prevent it from inheriting then all methods in that class becomes final 

// Abstract Classes:
// Must implement all abstract methods.
// Concrete methods(non absatct) can be inherited as is.

// Regular Classes:
// No enforcement of method implementation.
// Subclasses can choose whether to override methods or use them directly.

//there should not be any objects of an abstract class
//abstraction methods are declared without body
abstract class animal{
    abstract void  type();
    void display(){
        System.out.println("inside animal");
    }
}
class dog extends animal{
    void type(){
        System.out.println("sfds");
    }
}
public class finalandabstract {
       public static void main(String args[]){
             dog d=new dog();
             d.type();
             d.display();
       }   
}
