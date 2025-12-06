//for executing change the filename to Grade_Management
abstract class Student {
    protected String name;
    protected String studentID;

    public Student(String name, String studentID) {
        this.name = name;
        this.studentID = studentID;
    }

    abstract String calculateGrade();

    public void getDetails() {
        System.out.println("Name: " + name);
        System.out.println("Student ID: " + studentID);
    }
}

interface ScholarshipEligible {
    boolean isEligibleForScholarship(double GPA);
}

class UndergraduateStudent extends Student implements ScholarshipEligible {
    private double[] marks;

    public UndergraduateStudent(String name, String studentID, double[] marks) {
        super(name, studentID);
        this.marks = marks;
    }

    
    String calculateGrade() {
        double total = 0;
        for (double mark : marks) {
            total += mark;
        }
        double average = total / marks.length;

        if (average >= 90) return "A";
        else if (average >= 80) return "B";
        else if (average >= 70) return "C";
        else if (average >= 60) return "D";
        else return "F";
    }

    
    public void getDetails() {
        super.getDetails();
        System.out.println("Marks: ");
        for (double mark : marks) {
            System.out.print(mark + " ");
        }
        System.out.println();
    }

    
    public boolean isEligibleForScholarship(double GPA) {
        return GPA >= 3.5;
    }
}

class GraduateStudent extends UndergraduateStudent {
    private String thesisTopic;

    public GraduateStudent(String name, String studentID, double[] marks, String thesisTopic) {
        super(name, studentID, marks);
        this.thesisTopic = thesisTopic;
    }

    
    public void getDetails() {
        super.getDetails();
        System.out.println("Thesis Topic: " + thesisTopic);
    }

   
    public boolean isEligibleForScholarship(double GPA) {
        return GPA >= 3.5;
    }

    class Transcript {
        private String courseName;
        private int credits;
        private String grade;

        public Transcript(String courseName, int credits, String grade) {
            this.courseName = courseName;
            this.credits = credits;
            this.grade = grade;
        }

        public String getTranscriptDetails() {
            return "Course Name: " + courseName + ", Credits: " + credits + ", Grade: " + grade;
        }
    }
}

public class Main2{
    public static void main(String[] args) {
        double[] undergradMarks = {85, 90, 78, 92};
        UndergraduateStudent undergrad = new UndergraduateStudent("Pardhuva", "U123", undergradMarks);
        undergrad.getDetails();
        System.out.println("Grade: " + undergrad.calculateGrade());
        System.out.println("Eligible for Scholarship: " + undergrad.isEligibleForScholarship(3.6));

        double[] gradMarks = {88, 91, 85};
        GraduateStudent grad = new GraduateStudent("Jungkook", "G456", gradMarks, "AI Research");
        grad.getDetails();
        System.out.println("Grade: " + grad.calculateGrade());
        System.out.println("Eligible for Scholarship: " + grad.isEligibleForScholarship(3.8));

        GraduateStudent.Transcript transcript = grad.new Transcript("Machine Learning", 3, "A");
        System.out.println("Transcript Details: " + transcript.getTranscriptDetails());
    }
}
