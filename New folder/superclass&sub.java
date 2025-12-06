//a class from where another class extends or inherits the parent class is superclass and the child class is sub class
//subclass and superclass can have same methods the subclass can override the superclass methods

//subobj can access super class fields unles until they are declared private if private it cant access only public or protected 
//as we know private can be inheriited it can be accessed only within that class 


/* 
class A{
    String name;
    int age;
    void display(){
        System.out.println(name);
        System.out.println(age);
    }
    void update(){
        System.out.println("age:"+age+1);

    }
}

class B extends A{

    String nickname;
    void display(){
        System.out.println(name);
        System.out.println(age);
    }
    void append(){
        super.display
        System.out.println(name+"kook");
    }
}
    */
class superclass&sub{
    public static void main(String args[]){
        A a=new A();
        B b=new B();
        a.name="paru";
        a.age=18;
        b.name="jung";
        b.age=27;
        a.display();   //out: paru 18
        a.update();    //out age:19
        a.append();    //compile time error parent cant access child fields 
        b.display();   //jung 27
        b.append();    //jung kook
        b.update();    //age:28
    }
}

//dont declare the same varables in child which are in parent then overiding wont happen
//then shadowing wont happen
//super keyword refers to parent class reference either variaable or constructor or method

//inheritance is is-a relation   object of subclass can be treated as onject of superclass
//compositon means like attributes is has-a relaion

//if super is not used for constructors it will call default constructor 
//so in case of parameterized constructor explicitily call using super keyword

//when subclass and superclass ahs same name and type then the subclass overides the superclass
//if same name and type signatures different then we call it simply overloading

//When a subclass is instantiated, its constructor must invoke the constructor of its superclass. 
//This is done using the super() call. If you do not explicitly call super(), Java automatically calls the no-argument constructor of the superclass.
//it will only invoke the default constructor if no constructor is called

class employee{
    String name;
    int salary;
    employee(String name,int salary){
        this.name=name;
        this.salary=salary;
    }
    void print(){
        System.out.println(name);
        System.out.println(salary);
    }
}

class manager extends employee{
    String department;
    manager(String name,int salary,String department){
        super(name,salary);
        this.department=department;
    }
    void print(){
        System.out.println(name);
        System.out.println(salary);
        System.out.println(department);
    }
}


public class employeetest{
    public static void main(String args[]){
        manager m1=new manager("pary",200000,"software");
        m1.print();
    }
}

//variables then no need to call but constructors they should be called explicitily

//superclass cannot access subclass methods or variables 
//and if parent and child same methods and type then overiding which is run time 
//innorder to avoid this problem to make it determine during compile tiem references were created 
//a reference variable can be created which refers to subclass then superclass can access subclass methods and fields
//A r here r is reference then r can be a,b,c which are subclasses of A

