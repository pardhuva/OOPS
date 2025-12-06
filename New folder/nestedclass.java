//nested classes

//the nested class can be static and non static
//the inner class can access outer class fields but outer cant access inner class fields without creating instance of inner class 
//static class or methods can access only static variables if it want to access non static fileds it ahve to create the instance of that class like below age
// if inner is static object declaration is outer.inner out=new outer.inner(); to access inner 
//if inner is static no need to create instance of outer class outer.inner meanss we are creating the inner instance
//if for non static then  need to create instance of inner and outer too
//if outer class wants diplay the inner class methods then in outer class there should be inner class insatnce(object)
class outer{
    
    public static String name="paru";
    private  int age=18;

    // void test(){
    //     inner in=new inner();  //to access inner from outer
    //     in.display();
    // }
    
    static class inner{
        
        public String nick="pa";
        void display(){
            System.out.println(name);
            outer outing=new outer();
            System.out.println(outing.age);
            System.out.println(nick);
        }
    }
}
public class hello{
    public static void main(String args[]){
        
        outer.inner out=new outer.inner();
        
        out.display();
        }
}

//non static

class outer{
    
    public static String name="paru";
    private  int age=18;
    
    class inner{
        
        public String nick="pa";
        void display(){
            System.out.println(name);
            
            System.out.println(age);
            System.out.println(nick);
        }
    }
}
public class hello{
    public static void main(String args[]){
        
        outer out=new outer();
        outer.inner in=out.new inner();
        in.display();
    }
}