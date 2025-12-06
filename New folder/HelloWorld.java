//inheritance

class human{
    String  name;
    int age;
    void display(){
        System.out.println(name);
        System.out.println(age);
    }
}
class student extends human{
    String nickname;
    void show(){
        System.out.println(nickname);
        System.out.println(name);
        System.out.println(age);
    }
}
public class HelloWorld {
    
    public static void main(String args[]){
        
        human h1=new human();
        student s1=new student();
         h1.name="paru";
         h1.age=18;
         s1.nickname="pa";
         s1.name="jk";
         s1.age=27;
         s1.show();
         h1.display();
    }
    
}


class animal{
    animal(){
    System.out.println("y");
    }
}
class dog extends animal{
    
}
class dog1 extends dog{
    
}
public class HelloWorld {
    public static void main(String[] args) {
        dog1 d=new dog1();
    }
}