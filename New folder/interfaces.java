//the main use is multiple inheritance  and also loose coupling and tfor abstraction
//one class can implement many number of interfaces and many classes can implement an interface
//interface also a is-a relationship

//it follows abstraction all methods in a class that implements interface must implement and in interface all the methods are declared with the empty body
interface animaltype{
     void type();
}
interface breedtype{
    void breed();
}
class A implements animaltype,breedtype{
    public void type(){
        System.out.println("sdf");
    }
    public void breed(){
        System.out.println("asfds");
    }
}
public class interfaces {
    public static void main(String args[]){
        A a=new A();
        a.type();
        a.breed();  
    } 
}
