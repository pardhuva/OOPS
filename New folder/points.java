//compiling time errors means errors occured while converting from source code to machine code means during compiling time
//run time errors means errors during running means it wont give any compiling error like syntax errors it can be like memory is exceeded
// 

//constructors wont return anything they have same name as class 
//constructor intialises the object itself at the time of creation
//in default constructor intialize with some default values
//there can be only one public class in one class file 

//we have to create package by package pack;
//in main class also we will make it in another pack and we will import by import pack.before pack name which the object is created in that class
//private access means we cant access from outside only within the class 
//default means the object class is not declared the modifier as public then we wont get output
//default means it can be accesible within package but we cant access for another package
//protected means it can be accessed within apckage but in another package we cant access

//creating method or constructors that have same name and different parameters and different definitions is called method overloading and constructor iverloading

//this keyword is used if the attributes(instance variable) and the parameters are same like if the instance variable and the parameter of a function are same then we use this.variable to specify the instance variable
//this()is also used to call the constructor again actually we call the constructor only once but with using this() we can call it again
//this also used as an argument in method and constructor

//in java or oops arrays arre also treated as object because there we are using keyword new and every element after declaring the array is intialised to zero
//it has attributes called length that gives the size of an array

//int arr[] or int[] arr both represents the array of integers
//after calling nextInt() it will leave newline character('\n') in the input buffer so if we use nextLine after this the newLine() will also read the previous character
//when the array lenght is varying then it is better to use .length
//System.out.println("courses:"+Arrays.toString(courses));

//in java there wont be structures there are only classes same as structure we creeate and call the structure using some stud arrays in the same way create a clas that stores these structure attributes and call this class when objects created
//for storing multiple objects use arraylists

//in stack the objects can be stored or in aprogram code the variable will be stored and memory will be stored in heap


//you cannot call a class until you create an object from that class
//but static method such as main is special without first creating an object of the class in which the method is declared

//whenever new is used it creating an object of the class next to new 

//in uml diagram top contains class 
//                middle contains the attributes means instance variables
//              bottom contains class methods
//if method has parameters then in paranthesis it should mentiion the instance variable follwed by colon and parameter type like courseName:string
//if a mehtod is returning you heave to mention the data type of the returning one 
//+means public  - means private whether it is methods or the attributes
//for constructors we use <<constructor>>constructorname(attribute:datatype)

//max instance variables will be declared as private as private variables can be accessed only in the  same class 
//only set and get methods can access instance variables these methods can be called outisde from any other class

//every instance of the class contains one copy of the instance variable

// a class private fields can be manipulated only by the classs methods

// class dont have memory for it when an object is created then itself the memory is allocated 

//static variables are common to all the object and can be accessed without using a particualrr object they are called as class variables and class methods

// an instance field  declared with keyword final is constant its value cannot change after the field is intialized like pi and e

//class variables(static variables)+instance variables together called as the field of the class


//a non static method can call any method of same class directly and can manipulate any class variable directly
//a static method can call only other static methods of the diferent class directly using class name and can manipulate only static fields in the same class

//creating methods with the same name but differnt parameters  called as method overload

//access specifiers private,default,protected,public
//private it can only be accessed within the class outside the class it cannot be accessed
//defaultif we dont use anything it comes under default it is only accessible within package eventhough you import the package it cant be accessed
//protected accessible within the package and can be accessible outside the package but through inheritance only(the main class should inherit the onject class to access)
//public can be accessed from anywhere


//this is a reference variable that refers to the current object

//in java for arrays the values will be automatically initialized to zero and array is considered to be object in java(new) it has .length attribute builtin it

//packages in java are grouping of variety of classes together two classes can have saame name in different packages

// String data = "apple,banana,cherry";
// String[] fruits = data.split(","); now it stores as sperate words seperated by delimiters

//if there are two main methods one method will execute it wont give any error
//you can also call another main fucntion from any one one any main fucntion

//when the object is created but the variables are not initialised the variables gives output 0 we know in java the variables are first initialised to 0

//if no package is mentioned consider it as default package

//package private means default

//main fucntion is a static method so we should not insert another method inside main method and main variable should be class level declaration but not in method level 
//inside main method we shouldnt declare static varable or methods they should be declared in a class level

//in java we dont use ld for long as format specifier in c aand c++ we use "%ld" to print the the long variable 
//in java we use "%d" but the variable should end with l or L ex:8374358489L
//in int +-2147483648 so for 10 digits we use long L

//has-a and is-a realtions  is-a is simply inheriatance whereas has -a is one onject referring to another object
//like consider two classes one is parent class and the child class is referring parent class as parent is human class and child is student then we say student is human that is isey realtion and the student can have some dateof birth which is seperate class of date class then we say student has date this is hasey realtion


/*
   Interfaces 

   an interface is a blueprint of a class that defines a set of methods that a class must implement.
   An interface is declared using the interface keyword.

   Abstract Methods:

    All methods in an interface were abstract by default (until Java 7).
    Starting from Java 8, interfaces can also have:
    Default methods (with body)
    Static methods (with body)
    From Java 9, private methods (with body) are allowed.

    Variables:

    All variables in an interface are implicitly:
    public
    static
    final (constants)
    it cannot have instance variables

 */

 /*
    Abstract Classes
    
    An abstract class in Java is a class that is declared with the abstract keyword. 
    It is used as a blueprint for other classes and cannot be instantiated on its own. Abstract classes are used to define a common structure and behavior that subclasses must follow or extend.

    An abstract class is defined using the abstract keyword.
    An abstract class can contain abstract methods (methods without a body).
    Subclasses are required to provide implementations for these methods.
    abstract classes can also have concrete methods (methods with a body).
    Subclasses can use or override these methods.
    Unlike interfaces, abstract classes can have instance variables.
    Abstract classes can have constructors, which can be used to initialize fields of the abstract class
    You cannot create objects of an abstract class directly.
    Abstract classes must be extended by a subclass.
    The subclass must implement all abstract methods of the parent abstract class unless it is also declared abstract.

  */
    /*   
    Feature	                    Abstract Class	                                  Interface
    Methods	             Can have both abstract and concrete methods.	      Can have abstract, default, static, and private methods.
   Variables	         Can have instance variables.	                      Can only have public static final constants.
   Access Modifiers	      Methods and fields can use any modifier.	         Methods are public by default; fields are public static final by default.
   Constructors	           Can have constructors.	                         Cannot have constructors.
   Multiple Inheritance	   A class can extend only one abstract class.	     A class can implement multiple interfaces
   */