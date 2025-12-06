import java.util.*;
class apply{
    public String name;
    private int age;
    public  String college;
    private final String dob="13/08/1995";
    private  String branch;
    protected String city;
    protected  char grade;
    
    apply(String college,String city,char grade){
       this.college=college;
       this.city=city;
       this.grade=grade;

    }
    apply(String name){
        this.name=name;
    }
    apply(int age,String branch){
        this.branch=branch;
        this.age=age;
    }
    apply(){
        System.out.println();
    }
    void display(){
    System.out.println("name:"+name);
    System.out.println("age:"+age);
    System.out.println("college:"+college);
    System.out.println("branch:"+branch);
    System.out.println("city:"+city);
    System.out.println("grade:"+grade);
    }
}
public class application{
    public static void main(String args[]){
       Scanner sc=new Scanner(System.in);
       System.out.println("name:");
       String name=sc.nextLine();
       System.out.println("age:");
       int age=sc.nextInt();
       sc.nextLine();
       System.out.println("college:");
       String college=sc.nextLine();
       System.out.println("branch:");
       String branch=sc.nextLine();
       System.out.println("city:");
       String city=sc.nextLine();
       System.out.println("grade:");
       char grade=sc.next().charAt(0);
       apply a1=new apply(name);
       apply a2=new apply();
       apply a3=new apply(age,branch);
       apply a4=new apply(college,city,grade);
       System.out.println("a1:");
       a1.display();
       System.out.println("a2:");
       a2.display();
       System.out.println("a3:");
       a3.display();
       System.out.println("a4:");
       a4.display();
    }
}