import java.util.ArrayList;
import java.util.List;
import java.util.List;

 abstract class Vehicle {
    private String registrationNumber;
    private String brand;
    private double rentalPricePerDay;
    public Vehicle(String registrationNumber, String brand, double rentalPricePerDay) {
        this.registrationNumber = registrationNumber;
        this.brand = brand;
        this.rentalPricePerDay = rentalPricePerDay;
    }
    public String getRegistrationNumber() {
        return registrationNumber;
    }
    public String getBrand() {
        return brand;
    }
    public double getRentalPricePerDay() {
        return rentalPricePerDay;
    }
    @Override
    public String toString() {
        return "Brand: " + brand + ", Registration: " + registrationNumber + ", Price per day: " + rentalPricePerDay;
    }
}
 class Car extends Vehicle {
    private int seatingCapacity;
    public Car(String registrationNumber, String brand, double rentalPricePerDay, int seatingCapacity) {
        super(registrationNumber, brand, rentalPricePerDay);
        this.seatingCapacity = seatingCapacity;
    }
    @Override
    public String toString() {
        return super.toString() + ", Seating Capacity: " + seatingCapacity;
    }
}
 class Bike extends Vehicle {
    private boolean hasCarrier;
    public Bike(String registrationNumber, String brand, double rentalPricePerDay, boolean hasCarrier) {
        super(registrationNumber, brand, rentalPricePerDay);
        this.hasCarrier = hasCarrier;
    }
    @Override
    public String toString() {
        return super.toString() + ", Has Carrier: " + hasCarrier;
    }
}
 class Truck extends Vehicle {
    private double loadCapacity;
    public Truck(String registrationNumber, String brand, double rentalPricePerDay, double loadCapacity) {
        super(registrationNumber, brand, rentalPricePerDay);
        this.loadCapacity = loadCapacity;
    }
    @Override
    public String toString() {
        return super.toString() + ", Load Capacity: " + loadCapacity + " tons";
    }
}
 class RentalBox<T extends Vehicle> {
    private T vehicle;
    private boolean isRented;

    public RentalBox(T vehicle) {
        this.vehicle = vehicle;
        this.isRented = false;
    }
    public T getVehicle() {
        return vehicle;
    }
    public boolean isRented() {
        return isRented;
    }
    public boolean rentVehicle() {
        if (isRented) {
            return false;  
        }
        isRented = true;
        return true;  
    }
    public void returnVehicle() {
        isRented = false;
    }
    public double getRentalPrice(int days) {
        return vehicle.getRentalPricePerDay() * days;
    }
}
 class RentalUtils {

    public static void printAvailableVehicles(List<RentalBox<? extends Vehicle>> vehicles) {
        for (RentalBox<? extends Vehicle> rentalBox : vehicles) {
            if (!rentalBox.isRented()) { 
                System.out.println(rentalBox.getVehicle());
            }
        }
    }

    public static void applyDiscountToTrucks(List<? super Truck> vehicles, double discount) {
        for (Object vehicleObj : vehicles) {
            if (vehicleObj instanceof Truck) {
                Truck truck = (Truck) vehicleObj;
                double originalPrice = truck.getRentalPricePerDay();
                double discountedPrice = originalPrice - (originalPrice * discount / 100);
                System.out.println("New rental price for truck " + truck.getRegistrationNumber() + ": " + discountedPrice);
            }
        }
    }
}
 class Main {
    public static void main(String[] args) {
        Car car1 = new Car("TUV6543", "Mercedes", 110.0, 1);
        Bike bike1 = new Bike("456DEF", "Yamaha", 20.0, true);
        Truck truck1 = new Truck("789GHI","Ford", 100.0,5.0);

        RentalBox<Car> carRentalBox = new RentalBox<>(car1);
        RentalBox<Bike> bikeRentalBox = new RentalBox<>(bike1);
        RentalBox<Truck> truckRentalBox = new RentalBox<>(truck1);

        List<RentalBox<? extends Vehicle>> rentalList = new ArrayList<>();
        rentalList.add(carRentalBox);
        rentalList.add(bikeRentalBox);
        rentalList.add(truckRentalBox);

        System.out.println("Available vehicles before rental:");
        RentalUtils.printAvailableVehicles(rentalList);

        System.out.println("\nRenting the Mercedes car...");
        carRentalBox.rentVehicle();

        System.out.println("\nAvailable vehicles after rental:");
        RentalUtils.printAvailableVehicles(rentalList);

        System.out.println("\nApplying discount to trucks...");
        List<Truck> truckList = new ArrayList<>();
        truckList.add(truck1);
        RentalUtils.applyDiscountToTrucks(truckList,10.0);

        carRentalBox.returnVehicle();
        
        System.out.println("\nAvailable vehicles after returning the car:");
        RentalUtils.printAvailableVehicles(rentalList);
    }
}
