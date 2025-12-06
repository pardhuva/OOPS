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
public class S20230010045_practice6p4{
    public static void main(String[] args) {
        Shape circle = new Circle(7);
        Shape rectangle = new Rectangle(7,7);

        circle.displayInfo();
        rectangle.displayInfo();
    }
}