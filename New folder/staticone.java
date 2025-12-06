//static method can call other static method from different class without creating an object from that class
//static method can call only static mehtods and static variables independent of object
class world{
    
    public  static void display(){
        System.out.println("yes");
    }
}

public class staticone {
    public static void main(String[] args) {
       world.display();
    }
}
//this is wrong
//main fucntion is a static method so we should not insert another method inside main method and main variable should be class level declaration but not in method level 
//inside main method we shouldnt declare static varable or methods they should be declared in a class level

// public class Main {
//     public static void main(String args[]) {
        
//         static int c=4;
//         void display(){
//         System.out.println(c);
//         }
    
//     }
    
//     }

//the correct one is this

public class Main {
    // Static variable declared at the class level
    static int c = 4;

    // Static method declared at the class level
    static void display() {
        System.out.println(c);
    }

    public static void main(String args[]) {
        // Call the static method from the main method
        display();
    }
}
