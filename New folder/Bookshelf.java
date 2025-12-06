//these are called methods where after calling this it wont return anything it just do its task in printing
//it does not contain any main fucntion


//this method can be used for any other objects
//now creating an object called bookshelf and and invoking(calling) the method book 
import java.util.Scanner;
public class Bookshelf {
    public static void main (String[] args){
        Scanner input=new Scanner(System.in);
        String name=input.nextLine();
          Book book1=new Book();
          book1.printMybook(name);
    }
}
class Book {
    public  void printMybook(String bookName){
        System.out.printf("bookname:%s%n",bookName);  
    }
}
//here book and bookshelf are classes like a blueprint
//here book is a class it does its task it calls the printMybook method on it
// you cannot call a method until you create an object of that class
//bookshelf is the class 
//book1 is instance of the object of class book
//here book1  is the instance of book means it has the attributes and it and can perform the functions in class book
//book1: Has attributes and methods of the Book class (e.g., title, printMyBook()).
//Bookshelf: Manages program execution and can create Book objects but does not directly share attributes or methods with Book.
//In this way, book1 is an instance of the Book class and has the properties and methods defined in Book, not in Bookshelf.
//means book1 has nothing to do with bookshelf it just creates an book objects and make it available to use the book class

//The Bookshelf class creates and manages Book objects but does not inherit or directly interact with their specific attributes or methods.


//inside method the variaable are called local variabels
//in the class outside the methods the variables aree instance varaibles
//instance fields same as instance variables that are inside class but outside methods
//Class: Defines the structure and behavior of objects. It is the blueprint for creating instances of that class.
//Constructor: A special method within a class that is used to initialize objects when they are created

//if we wnat to access the methods we have to create to create an object in the class which has method then we can access the method