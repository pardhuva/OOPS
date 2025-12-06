//for running change file name to CollegeApplication
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.*;

class Person {
    String Name;
    String Aadhar_no;
    char gender;
    String date_of_birth;

    Person(String Name, String Aadhar_no, char gender, String date_of_birth) {
        this.Name = Name;
        this.Aadhar_no = Aadhar_no;
        this.gender = gender;
        this.date_of_birth = date_of_birth;
    }

    public String getName() {
        return Name;
    }

    public String getAadhar_no() {
        return Aadhar_no;
    }

    public char getgender() {
        return gender;
    }

    public int calculateAge() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate parsedDate = LocalDate.parse(this.date_of_birth, formatter);
        LocalDate today = LocalDate.now();
        return Period.between(parsedDate, today).getYears();
    }

    public LocalDate getDate() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        return LocalDate.parse(this.date_of_birth, formatter);
    }
}

class Student extends Person {
    int roll_no;
    String institute_name;
    String dept;
    String specialization;
    ArrayList<String> subjects = new ArrayList<>();
    HashMap<String, Integer> grades = new HashMap<>();

    Student(String Name, String Aadhar_no, char gender, String date_of_birth) {
        super(Name, Aadhar_no, gender, date_of_birth);
    }

    public void admitStudent(String institute_name) {
        this.institute_name = institute_name;
    }

    public void enrollStudent(String dept, String specialization, String[] subjects, int roll_no) {
        this.roll_no = roll_no;
        this.dept = dept;
        this.specialization = specialization;
        this.subjects.addAll(Arrays.asList(subjects));
    }

    public int getroll_no() {
        return roll_no;
    }

    public String getdept() {
        return dept;
    }

    public String getinstitute_name() {
        return institute_name;
    }

    public String getspecialization() {
        return specialization;
    }

    public HashMap<String, Integer> getGrades() {
        return grades;
    }
}

class Faculty extends Person {
    int Emp_id;
    String dept;
    String institute_name;
    String specialization;
    String subject;
    int salary;

    Faculty() {
        super("", "", ' ', "");
    }

    public void Join_Faculty(String Name, String Aadhar_no, char gender, String date_of_birth, int Emp_id, String institute_name) {
        super.Name = Name;
        super.Aadhar_no = Aadhar_no;
        super.gender = gender;
        super.date_of_birth = date_of_birth;
        this.Emp_id = Emp_id;
        this.institute_name = institute_name;
    }

    public void assignFaculty(String specialization, String dept, String subject) {
        this.specialization = specialization;
        this.dept = dept;
        this.subject = subject;
    }

    public void assignGrades(Student s, int grade) {
        s.grades.put(this.subject, grade);
    }

    public int getemp_id() {
        return Emp_id;
    }

    public String getdept() {
        return dept;
    }

    public String getinstitute_name() {
        return institute_name;
    }

    public String getspecialization() {
        return specialization;
    }

    public int getsalary() {
        return salary;
    }
}

public class CollegeApplication {
    public static void main(String[] args) {
        ArrayList<Student> studentList = new ArrayList<>();
        ArrayList<Faculty> facultyList = new ArrayList<>();
        Scanner sc = new Scanner(System.in);

        // Input for students
        for (int i = 0; i < 2; i++) {
            System.out.println("Enter the name:");
            String name = sc.nextLine();

            System.out.println("Enter the Aadhar number:");
            String aadharNo = sc.nextLine();

            System.out.println("Enter the gender:");
            char gender = sc.next().charAt(0);
            sc.nextLine(); // Consume newline

            System.out.println("Enter the date of birth (dd-MM-yyyy):");
            String dateOfBirth = sc.nextLine();

            Student student = new Student(name, aadharNo, gender, dateOfBirth);

            System.out.println("Enter the institute name:");
            String instituteName = sc.nextLine();
            student.admitStudent(instituteName);

            System.out.println("Enter the roll number:");
            int rollNo = sc.nextInt();
            sc.nextLine(); // Consume newline

            System.out.println("Enter the department:");
            String dept = sc.nextLine();

            System.out.println("Enter the specialization:");
            String specialization = sc.nextLine();

            System.out.println("Enter number of subjects:");
            int subjectCount = sc.nextInt();
            sc.nextLine(); // Consume newline
            
            String[] subjects = new String[subjectCount];
            for (int j = 0; j < subjectCount; j++) {
                System.out.println("Enter subject " + (j + 1) + ":");
                subjects[j] = sc.nextLine();
            }

            student.enrollStudent(dept, specialization, subjects, rollNo);
            studentList.add(student);
        }

        // Input for faculty
        for (int i = 0; i < 2; i++) {
            System.out.println("Enter the faculty name:");
            String name = sc.nextLine();

            System.out.println("Enter the Aadhar number:");
            String aadharNo = sc.nextLine();

            System.out.println("Enter the gender:");
            char gender = sc.next().charAt(0);
            sc.nextLine(); // Consume newline

            System.out.println("Enter the date of birth (dd-MM-yyyy):");
            String dateOfBirth = sc.nextLine();

            System.out.println("Enter the employee ID:");
            int empId = sc.nextInt();

            System.out.println("Enter the salary:");
            int salary = sc.nextInt();
            sc.nextLine(); // Consume newline

            System.out.println("Enter the institute name:");
            String instituteName = sc.nextLine();

            System.out.println("Enter the department:");
            String dept = sc.nextLine();

            System.out.println("Enter the specialization:");
            String specialization = sc.nextLine();

            System.out.println("Enter the subject:");
            String subject = sc.nextLine();

            System.out.println("Enter the grade:");
            int grade = sc.nextInt();
            sc.nextLine(); // Consume newline

            Faculty faculty = new Faculty();
            faculty.Join_Faculty(name, aadharNo, gender, dateOfBirth, empId, instituteName);
            faculty.assignFaculty(specialization, dept, subject);

            // Assign grades only if there is a corresponding student
            if (i < studentList.size()) {
                faculty.assignGrades(studentList.get(i), grade);
            } else {
                System.out.println("No student available for grade assignment.");
            }

            facultyList.add(faculty);
        }

        // Display student information
        for (Student student : studentList) {
            System.out.println("Student Name: " + student.getName());
            System.out.println("Department: " + student.getdept());
            System.out.println("Aadhar No: " + student.getAadhar_no());
            System.out.println("Gender: " + student.getgender());
            System.out.println("Date of Birth: " + student.getDate());
            System.out.println("Age: " + student.calculateAge());
            System.out.println("Roll No: " + student.getroll_no());
            System.out.println("Specialization: " + student.getspecialization());
            System.out.println("Institute: " + student.getinstitute_name());
            System.out.println("Grades: " + student.getGrades());
            System.out.println();
        }

        // Display faculty information
        for (Faculty faculty : facultyList) {
            System.out.println("Faculty Name: " + faculty.getName());
            System.out.println("Department: " + faculty.getdept());
            System.out.println("Aadhar No: " + faculty.getAadhar_no());
            System.out.println("Gender: " + faculty.getgender());
            System.out.println("Date of Birth: " + faculty.getDate());
            System.out.println("Employee ID: " + faculty.getemp_id());
            System.out.println("Specialization: " + faculty.getspecialization());
            System.out.println("Institute Name: " + faculty.getinstitute_name());
            System.out.println("Salary: " + faculty.getsalary());
            System.out.println();
        }

        sc.close();
    }
}