//for executing purpose change the file name into VehicleManagement


import java.util.*;

abstract class Vehicle{

    abstract public String getDescription();

    public void displayType(){
        String s=getDescription();
        System.out.println("Type of Vehicle: "+s);
    }
}
 class Car extends Vehicle{
    public int numberOfDoors;
    
    public String getDescription(){
        String vehicletype="Car";
        return vehicletype;
    }
    public void set(int numberOfDoors){
        this.numberOfDoors=numberOfDoors;
    }
    public int get(){
        return numberOfDoors;
    }
    protected void finalize() throws Throwable {
        try {
            System.out.println("Car:clean resources");
        } finally {
            super.finalize(); 
        }
    }
}

 class Truck extends Vehicle{
     public long loadCapacity;//(numberoftons)

     public String getDescription(){
        String type="truck";
        return type;
     }

    public void set(long loadcapacity){
        loadCapacity=loadcapacity;
    }
    public long get(){
        return loadCapacity;
    }
    protected void finalize() throws Throwable {
        try {
            System.out.println("Truck:clean resources");
        } finally {
            super.finalize(); 
        }
    }
}

public class  VehicleManagement{

    public static void main(String args[]){
        Car c = new Car();
        Truck t = new Truck();

        Scanner sc=new Scanner(System.in);

        System.out.println("enter the number of doors for a car:");
        int num=sc.nextInt();
        c.set(num);

        System.out.println("number of doors: "+c.get());
        c.displayType();

        System.out.println("enter the capacity: ");
        long capacity=sc.nextLong();
        t.set(capacity);

        System.out.println("load capacity: "+t.get());
        t.displayType();
         
        c=null;
        t=null;
        System.gc();

    }
} 