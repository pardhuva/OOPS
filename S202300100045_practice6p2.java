class Employee {
    String name;
    int id;

    Employee(String name, int id) {
        this.name = name;
        this.id = id;
    }

    void displayInfo() {
        System.out.println("Employee Name: " + name + " | ID: " + id);
    }

    @Override
    protected void finalize() {
        System.out.println("Employee " + name + " with ID " + id + " is being garbage collected.");
    }
}

class GarbageCollectionDemo {

    void demonstrateGarbageCollection() {

        Employee emp1 = new Employee("Alice", 101);
        Employee emp2 = new Employee("Bob", 102);
        Employee emp3 = new Employee("Charlie", 103);


        System.out.println("Employees created:");
        emp1.displayInfo();
        emp2.displayInfo();
        emp3.displayInfo();


        emp1 = null;
        emp2 = null;
        emp3 = null;

        System.out.println("\nRequesting garbage collection...");
        System.gc();
        

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

public class S202300100045_practice6p2 {
    public static void main(String[] args) {
        GarbageCollectionDemo demo = new GarbageCollectionDemo();
        demo.demonstrateGarbageCollection();
    }
}

