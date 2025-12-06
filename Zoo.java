//question 3
class Animal {
    private String name;
    private int age;

    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void makeSound() {
        System.out.println("This animal makes a sound.");
    }

    public void displayInfo() {
        System.out.println("Animal Name: " + name + ", Age: " + age);
    }
}

class Dog extends Animal {
    public Dog(String name, int age) {
        super(name, age);
    }

    public void makeSound() {
        System.out.println("Woof!");
    }

    public void displayInfo() {
        super.displayInfo();
        System.out.println("Sound: Woof!");
    }
}

class Cat extends Animal {
    public Cat(String name, int age) {
        super(name, age);
    }

    public void makeSound() {
        System.out.println("Meow!");
    }

    public void displayInfo() {
        super.displayInfo();
        System.out.println("Sound: Meow!");
    }
}

public class Zoo {
    public static void main(String[] args) {
        Dog dog = new Dog("Bam", 8);
        Cat cat = new Cat("Yeontan", 5);

        dog.makeSound();
        dog.displayInfo();

        cat.makeSound();
        cat.displayInfo();
    }
}

//question 4

abstract class Shape{
    abstract double area();
    abstract double perimeter();
    public void displayInfo(){
        System.out.println("Shape Type: " + this.getClass().getSimpleName());
        System.out.println("Area: " + area());
        System.out.println("Perimeter: " + perimeter());
        System.out.println();
    }
}
class Circle extends Shape{
    private double radius;
Circle(double radius){
        this.radius = radius;
    }

    public double area(){
        return Math.PI * radius * radius;
    }

    public double perimeter(){
        return 2 * Math.PI * radius;
    }
}
class Rectangle extends Shape {
    private double width;
    private double height;
    public Rectangle(double width,double height){
        this.width = width;
        this.height = height;
    }
    public double area(){
        return width * height;
    }
    public double perimeter(){
        return 2 * (width + height);
    }
}
public class ShapeTest{
    public static void main(String[] args) {
        Shape circle = new Circle(7);
        Shape rectangle = new Rectangle(7,7);

        circle.displayInfo();
        rectangle.displayInfo();
    }
}