//nested class-class innside class
//the class outside is called enclosing class and the class inside is called nested class
//so the nested class can have access to all the variables even the private memebers  in both enclosing class and the nested class but the enclosing class cannot acces the variables from nested class 

//two cases the nested class can be static aand non static

//if nestedclass is static

//if static then no need of object creation so we dont create any object of outerclass
//even without creating the instances of the outerclass we can access 
//here we creating object just to access the methods otherwise as a static class no need instance of that class
class outerclass{
    static int number_of_accounts=3;
    String phonenumber="2874345";
    private int pass=34;
    static class nestedclass{
    void print(){
        System.out.println(number_of_accounts);
    }
    }
}

public class nesteddemo{
    public static void main(String args[]) {
        outerclass.nestedclass object=new outerclass.nestedclass();
        object.print();
    }
}

//if nestedclass is not static

//then we have to create the instance of outerclass to access the inside non static class
//outerclasses cannot be static only we can make the nested classes as static outerclasses always should be non static
// if both are non static we should create an instance of outerclass outside of outerclass with name outerclass.innerclass otherwise it gives an error

class outerclass{
    static int number_of_accounts=3;
    String phonenumber="2874345";
    private int pass=34;
    class nestedclass{
    void print(){
        System.out.println(number_of_accounts);
        System.out.println(phonenumber);
        System.out.println(pass);
    }
    }
}

public class nesteddemo{
    public static void main(String args[]) {
        outerclass outer=new outerclass();
        outerclass.nestedclass object=outer.new nestedclass();
        object.print();
    }
}

//non static in naother way

class outerclass{
    static int number_of_accounts=3;
    String phonenumber="2874345";
    private int pass=34;
    void test(){
        nestedclass inner =new nestedclass();
        inner.print();
    }
    class nestedclass{
    void print(){
        System.out.println(number_of_accounts);
        System.out.println(phonenumber);
        System.out.println(pass);
    }
    }
}

public class nesteddemo{
    public static void main(String args[]) {
        outerclass outer=new outerclass();
       outer.test();
    }
}


//example 
class outerclass{
    int outer_x=100;
    void test(){
    for(int i=0;i<10;i++){
    class nestedclass{
    void print(){
        System.out.println(outer_x);
    }
    }
    nestedclass inner=new nestedclass();
    inner.print();
    }
}
}

public class nesteddemo{
    public static void main(String args[]) {
        outerclass outer=new outerclass();
       outer.test();
    }
}