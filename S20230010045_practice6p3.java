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

public class S20230010045_practice6p3 {
    public static void main(String[] args) {
        Dog dog = new Dog("Bam", 8);
        Cat cat = new Cat("Yeontan", 5);

        dog.makeSound();
        dog.displayInfo();

        cat.makeSound();
        cat.displayInfo();
    }
}
