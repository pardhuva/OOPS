
import java.util.*;
class Employeeclass {
    String EmployeeId;
    double basicsalary;
    int allowancepercentage;
    boolean loaneligibility;
    float noofleaves;
    Employeeclass(String EmloyeeId,double basicsalary,int allowancepercentage,boolean loaneligibility,float noofleaves){
        this.EmployeeId=EmloyeeId;
        this.basicsalary=basicsalary;
        this.allowancepercentage=allowancepercentage;
        this.loaneligibility=loaneligibility;
        this.noofleaves=noofleaves;
    }
    static void DisplayEmployeebyRecords(List <Employeeclass>employees,String employeeid){
        boolean found=false;
        for(Employeeclass emp:employees){
            if(emp.EmployeeId.equals(employeeid)){
                emp.listemployees();
                found=true;
                break;
            }
        }
        if(!found){
            System.out.println("employeeid is invalid");
        }
    }
    double calculatesalary(){
        return basicsalary*(basicsalary*allowancepercentage/100.0);
    }
    void listemployees(){
            System.out.println("EmloyeeId:"+EmployeeId);
            System.out.println("basic_salary:"+basicsalary);
            System.out.println("allowance_percentage:"+allowancepercentage);
            System.out.println("loan_eligibility:"+loaneligibility);
            System.out.println("no_of_leaves:"+noofleaves);
    }
    void ShowNoOfLeaves(){
            System.out.println("no_of_leaves: of "+noofleaves);
    }
    
    
}



public class Emp{
    public static void main(String args[]){
        List<Employeeclass> employees = new ArrayList<>();
         Scanner sc=new Scanner(System.in);
        for(int i=0;i<3;i++){
            System.out.println("enter the deatils of employee "+(i+1)+" ");
            System.out.print("Employee ID: ");
            String EmployeeId=sc.nextLine();
            System.out.print("Basic Salary: ");
            double basicsalary=sc.nextDouble();
            System.out.print("Allowance Percentage: ");
            int allowancepercentage=sc.nextInt();
            System.out.print("Loan Eligibility (true/false): ");
            boolean loaneligibility=sc.nextBoolean();
            System.out.print("Number of Leaves: ");
            float noofleaves=sc.nextFloat();
            sc.nextLine(); 
            Employeeclass emp=new Employeeclass(EmployeeId,basicsalary,allowancepercentage,loaneligibility,noofleaves);
            employees.add(emp);
        }
        for(Employeeclass emp:employees){
           emp.listemployees();
           System.out.println();
        }
        for(Employeeclass emp:employees){
           emp.ShowNoOfLeaves();
           System.out.println();
        }
        for(Employeeclass emp:employees){
           double salary=emp.calculatesalary();
           System.out.println(salary);
        }
        String searchid=sc.nextLine();
        Employeeclass.DisplayEmployeebyRecords(employees,searchid);
    }
}