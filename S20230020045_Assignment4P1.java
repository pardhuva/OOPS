
class student{
    public String name;
    private int age;

    student(String name,int age){
        this.name=name;
        this.age=age;
    }

    //compute method with three times overloading and four different operations
    void  compute(int age){

        if(age>18){
            System.out.println("adult");
        }
        else{
            System.out.println("minor");
        }
    }

    void compute(){
        System.out.println(this.name+" " +this.age);

    }

    int compute(String name){

        System.out.println(name);
                                        //one method with two different operations
        return (name.length());
    }
}


public class Test{
    public static void main(String args[]){

     student stud1=new student("paru",18);
     student stud2=new student("hope",20);
     System.out.println("Question 1: ");

    
    stud1.compute();

     stud2.compute(20);

     int strlen;
     strlen = stud2.compute(stud2.name);
     System.out.println(strlen);

    }
}