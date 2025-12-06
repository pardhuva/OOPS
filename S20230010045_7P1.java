//for executing change the file name to Zoo_Simulation
import java.util.*;
abstract class AnimalBehaviour{
    abstract void makeSound();
    abstract void move();
}

class Mammal extends AnimalBehaviour{
    public void makeSound(){
        System.out.println("oooooo");
    }
    public void move(){
        System.out.println("on land");
    }
}

class Bird extends AnimalBehaviour{
    public void makeSound(){
        System.out.println("kaaaaaa");
    }
    public void move(){
        System.out.println("in air");
    }
}

class Lion extends Mammal{
    public void makeSound(){
        System.out.println("Lion: "+"Roar");
    }
    public void move(){
        System.out.println("Lion: "+" runs on the ground");
    }
}

class Eagle extends Bird{
    public void makeSound(){
        System.out.println("Eagle: "+"Screeech");
    }
    public void move(){
        System.out.println("Eagle: "+" soars high");
    }
}

class Zoo{
    ArrayList<AnimalBehaviour>animals=new ArrayList<>();
    public void addAnimal(AnimalBehaviour animal){
       animals.add(animal);
    }
    public void makeAllSounds(){
        System.out.println("printing sounds:");
        for(AnimalBehaviour a:animals){
            a.makeSound();
        }
    } 
    public void moveAll(){
        System.out.println("printing movements:");
        for(AnimalBehaviour a:animals){
            a.move();
        }
    }
    
}

public class Zoo_Simulation{

    public static void main(String args[]){
       Zoo z=new Zoo();
       Lion l=new Lion();
       Eagle e=new Eagle();
       
       z.addAnimal(l);
       z.addAnimal(e);

       z.makeAllSounds();
       z.moveAll();
    }
}