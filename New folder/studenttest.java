class Student{
    private int rollno;
    private String name;
    private char grade;
    private int yearofstudy;
    private String branch;

    Student(int rollno,String name,char grade,int yearofstudy,String branch){
        this.rollno=rollno;
        this.name=name;
        this.grade=grade;
        this.yearofstudy=yearofstudy;
        this.branch=branch;
    }
    Student(){
        System.out.println();
    }
    //set fucntions
    public void setValues(int rollno,String name,char grade,int yearofstudy,String branch){
        this.rollno=rollno;
        this.name=name;
        this.grade=grade;
        this.yearofstudy=yearofstudy;
        this.branch=branch;
    }

    //get functions
    public int getRollno(){
        return rollno;
    }
    public String getName(){
        return name;
    }
    public char getGrade(){
        return grade;
    }
    public int getYearofstudy(){
        return yearofstudy;
    }
    public String getBranch(){
        return branch;
    }

}

public class studenttest{
    public static void main(String args[]){

        Student s1=new Student(45,"jk",'A',2020,"cse");
        Student s2=new Student(35,"ram",'B',2019,"ece");
        Student s3=new Student();
        s3.setValues(25,"hope",'O',2021,"eee");
        int roll=s1.getRollno();
        System.out.println("Rollno :"+roll);
        String name=s1.getName();
        System.out.println("Name :"+name);
        char grade=s1.getGrade();
        System.out.println("Grade :"+grade);
        int year=s1.getYearofstudy();
        System.out.println("Yearofstudy :"+year);
        String branch=s1.getBranch();
        System.out.println("Branch :"+branch);

    }
}