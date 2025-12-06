import java.time.*;
import java.util.*;
class Person{
    String Name;
    String Aadhar_no;
    char gender;
    String date_of_birth;

    Person(String Name,String Aadhar_no,char gender,String date_of_birth){
        this.Name=Name;
        this.Aadhar_no=Aadhar_no;
        this.gender=gender;
        this.date_of_birth=date_of_birth;
    }
    public String getName(){
        return Name;
    }
    public String getAadhar_no(){
        return Aadhar_no;
    }
    public char getgender(){
        return gender;
    }
   
    public int calculateAge(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate parsedDate = LocalDate.parse(this.date_of_birth, formatter);
        LocalDate today = LocalDate.now();
        return Period.between(parsedDate,today).getYears();

    }
    public LocalDate getDate(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate parsedDate = LocalDate.parse(this.date_of_birth, formatter);
        return parsedDate;
    }
}

class Student extends Person{
       int roll_no;
       String institute_name;
       String dept;
       String specialization;
       ArrayList<String>subjects=new ArrayList<>();
       HashMap<String,Integer>grades=new HashMap<>();
       
       
       public void Admit_student(String Name,String Aadhar_no,char gender,String date_of_birth,String institute_name){
        
           super(Name,Aadhar_no,gender,date_of_birth);

           this.institute_name=institute_name;
       }

       public void Enroll_student(String dept,String specialization,ArrayList<String>subjects,int roll_no){
        this.roll_no=roll_no;
        this.dept=dept;
        this.specialization=specialization;

        for(String i:subjects){
            this.subjects.add(i);
        }
       }
    public int getroll_no(){
        return roll_no;
    }
    public String getdept(){
        return dept;
    }
    public String getinstitute_name(){
        return institute_name;
    }
    public String getspecialization(){
        return specialization;
    }
    public HashMap<String,Integer> getGrades(){
        return grades;
    }
}

class Faculty extends Person{
    int Emp_id;
    String dept;
    String institute_name;
    String specialization;
    String subject;
    int salary;
    
    public void Join_Faculty(String Name,String Aadhar_no,char gender,String date_of_birth,int Emp_id,String institute_name){
      super(Name,Aadhar_no,gender,date_of_birth);
      this.Emp_id=Emp_id;
      this.institute_name=institute_name;

    }
    public void Assign_Faculty(String specialization,String department,String subject){
        this.specialization=specialization;
        this.department=department;
        this.subject=subject;
    }

    public void Assign_Grades(Student s,int grade){
          s.grades.put(this.subject,grade);
    }
    public int getemp_id(){
        return Emp_id;
    }
    public String getdept(){
        return dept;
    }
    public String getinstitute_name(){
        return institute_name;
    }
    public String getspecialization(){
        return specialization;
    }
    public int getsalary(){
        return salary;
    }

}
public class CollegeApplication{
    public static void main(String args[]){
        ArrayList<Student>studentlist=new Arraylist<>();
        ArrayList<Faculty>facultylist=new ArrayList<>();

       Scanner sc=new Scanner(System.in);
     for(int i=0;i<2;i++){
       
       System.out.println("enter the name:");
       String name=sc.nextLine();

       System.out.println("enter the aadhar_no:");
       String aadhar_no=sc.nextLine();

       System.out.println("enter the gender:");
       char  gender=sc.next().charAt(0);

       System.out.println("enter the dateofbirth(dd-mm-yyyy):");
       String dateofbirth=sc.nextLine();


       System.out.println("enter the rollno:");
       int roll_no=sc.nextInt();
       sc.nextLine();

       System.out.println("enter the institutename:");
       String institute_name=sc.nextLine();

       System.out.println("enter the department:");
       String dept=sc.nextLine();

       System.out.println("enter the specialization:");
       String spec=sc.nextLine();

       ArrayList<String>subjects=new ArrayList<>();
       for(int i=0;i<2;i++){
       System.out.println("enter the subject"+i+":");
       subjects.add(sc.nextLine());
       }
       
       Student S=new Student();
       studentlist.add(S);
       S.Admit_student(name,aadhar_no,gender,dateofbirth,institute_name);
       S.Enroll_student(dept,spec,subjects,roll_no);

       
     }
     for(int i=0;i<2;i++){
        System.out.println("enter the name:");
        String name=sc.nextLine();
 
        System.out.println("enter the aadhar_no:");
        String aadhar_no=sc.nextLine();
 
        System.out.println("enter the gender:");
        char  gender=sc.next().charAt(0);
 
        System.out.println("enter the dateofbirth(dd-mm-yyyy):");
        String dateofbirth=sc.nextLine();
 
 
        System.out.println("enter the emp_id:");
        int emp_id=sc.nextInt();
    

        System.out.println("enter the salary:");
        int salary=sc.nextInt();
        sc.nextLine();

        System.out.println("enter the institutename:");
        String institute_name=sc.nextLine();
 
        System.out.println("enter the department:");
        String dept=sc.nextLine();
 
        System.out.println("enter the specialization:");
        String spec=sc.nextLine();
         
        System.out.println("enter the specialization:");
        String spec=sc.nextLine();
        
        System.out.println("enter the subject:");
        String subject=sc.nextLine();
        
        for(int i=0;i<2;i++){
        System.out.println("enter the grade for student"+i+":");
        int[] grade=sc.nextInt();
        }
        
        Faculty F=new Faculty();
        facultylist1.add(F);
        F.Join_Faculty(name,aadhar_no,gender,dateofbirth,emp_id,institute_name);
        F.Assign_Faculty(dept,spec,subject);
        F.Assign_Grades(list.get(i),grade);
     }
    

    for(Student student:studentlist){
      
      System.out.println("student name: "+getName());
      System.out.println("department name: "+getdept());
      System.out.println("aadhar no: "+getAadhar_no());
      System.out.println("gender:"+getgender());
      System.out.println("date of birth: "+getDate());
      System.out.println("age :"+calculateAge());
      System.out.println("rollno: "+getroll_no());
      System.out.println("specialisation: "+getspecializtion());
      System.out.println("institute: "+getinstitute_name());
      System.out.println("grades: "+getgrades());
    }
    for(Faculty faculty:facultylist){
        System.out.println("name:"+getName());
        System.out.println("dept: "+getdept());
        System.out.println("aadharno: "+getAadhar_no());
        System.out.println("gender: "+getgender());
        System.out.println("dateofbirth: "+getDate());
        System.out.println("employee id: "+emp_id());
        System.out.println("specialisation: "+getspecializtion());
        System.out.println("insitute name: "+getinstitute_name());
        System.out.println("salary: "+getsalary());      
        
    }
}
}

