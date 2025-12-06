import java.util.*;
class student{
    int rollno;
    String name;
    float marks;
    String[] courses;//String courses[] or String[] courses are same
    student(int rollno,String name,float marks,String[] courses){
        this.rollno=rollno;
        this.name=name;
        this.marks=marks;
        this.courses=courses;
        // this.courses = new String[courses.length]; //when length is variable you can simply use this
        // System.arraycopy(courses, 0, this.courses, 0, courses.length);
    }
    void displaydetails(){
        System.out.println("roll no:"+rollno);
        System.out.println("name:"+name);
        System.out.println("marks:"+marks);
        System.out.println("courses:"+Arrays.toString(courses));
        // for (String course : courses) {
        //     System.out.print(course + " ");
        // }
        // System.out.println(); 
    }
}
class stud{
    public static void main(String args[]){
        List <student>students=new ArrayList<>();
        Scanner sc=new Scanner(System.in);
        System.out.println("enter the size:");
        int size=sc.nextInt();
        for(int i=0;i<size;i++){
            System.out.println("enter the details of "+(i+1)+":");
            System.out.println("enter the rollno:");
            int rollno=sc.nextInt();
            sc.nextLine();
            System.out.println("enter the name:");
            String name=sc.nextLine();
            System.out.println("enter the marks:");
            float marks=sc.nextFloat();
            System.out.println("enter number of courses:");
            int num=sc.nextInt();
            sc.nextLine();
            String[] courses=new String[num];
            for(int j=0;j<num;j++){
            System.out.println("enter the course"+(j+1)+":");
            courses[j]=sc.nextLine();
            }

            student stude=new student(rollno,name,marks,courses);
            students.add(stude);
            sc.nextLine();
        }
    
    for(student stude : students){
        System.out.println("student details");
        stude.displaydetails();
        System.out.println();
    }
    }
}
