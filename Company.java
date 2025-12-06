class Employee {
    private String name;
    private String address;
    private double salary;
    private String jobTitle;

    public Employee(String name, String address, double salary, String jobTitle) {
        this.name = name;
        this.address = address;
        this.salary = salary;
        this.jobTitle = jobTitle;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public double getSalary() {
        return salary;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public double calculateBonus() throws Exception {
        if (salary <= 0) {
            throw new Exception("Salary cannot be zero or negative.");
        }
        return 0.0;
    }

    public String generatePerformanceReport() throws Exception {
        throw new Exception("No performance report available for generic employee.");
    }
}

class Manager extends Employee {
    public Manager(String name, String address, double salary) {
        super(name, address, salary, "Manager");
    }

    @Override
    public double calculateBonus() throws ArithmeticException {
        return getSalary() * 0.15;
    }

    @Override
    public String generatePerformanceReport() {
        return "Excellent";
    }
}

class Developer extends Employee {
    public Developer(String name, String address, double salary) {
        super(name, address, salary, "Developer");
    }

    @Override
    public double calculateBonus() throws ArithmeticException {
        return getSalary() * 0.15;
    }

    @Override
    public String generatePerformanceReport() {
        return "Average";
    }
}

class Programmer extends Employee {
    public Programmer(String name, String address, double salary) {
        super(name, address, salary, "Programmer");
    }

    @Override
    public double calculateBonus() throws ArithmeticException {
        return getSalary() * 0.15;
    }

    @Override
    public String generatePerformanceReport() {
        return "Poor";
    }
}

public class Company {
    public static void main(String[] args) {
        Employee manager = new Manager("Alice", "123 Manager St", 90000);
        Employee developer = new Developer("Bob", "456 Developer Rd", 80000);
        Employee programmer = new Programmer("Charlie", "789 Programmer Ln", 70000);

        try {
            System.out.println("Manager Bonus: $" + manager.calculateBonus());
            System.out.println("Developer Bonus: $" + developer.calculateBonus());
            System.out.println("Programmer Bonus: $" + programmer.calculateBonus());

            System.out.println("Manager Performance: " + manager.generatePerformanceReport());
            System.out.println("Developer Performance: " + developer.generatePerformanceReport());
            System.out.println("Programmer Performance: " + programmer.generatePerformanceReport());

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            System.out.println("Calculations complete.");
        }
    }
}
