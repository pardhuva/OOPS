/* 
package Datestore;

public class Date { // lets make variables final as we are initializing with current date
    public final int day;
    public final   String month;
    public final long year;

    // Constructor to initialize with current date
    public Date(int day,String month,long year) {
      this.day=day;
      this.month=month;
      this.year=year;
    }

    // Method to display the date
    public void displayDate() {
        System.out.println("Current Date: " + day+ " " +  month +" "+  year);
    }

}
    */
package Datestore;
import java.util.Scanner;
import java.time.LocalDate;

public class S202300100045_Assignment5P1 {
    public static void main(String[] args) {
        // Get the current date
        LocalDate currentDate = LocalDate.now();
        int day = currentDate.getDayOfMonth();
        String month = currentDate.getMonth().name();  // Use the name of the month
        long year = currentDate.getYear();

        // Create the Date object with the current date
        Date date = new Date(day, month, year);
        date.displayDate();


    }
}

/* 
package java;
import java.time.LocalDateTime;


public class date{
      
       public int day;
       public String month;
       public long year;
       
       date(int day,String month,long year){
             this.day=day;
             this.month=month;
             this.year=year;
       }

       void display(){

          System.out.println(day+"/"+month+"/"+year);
       }

       public static void main(String args[]){
        LocalDateTime curr=LocalDateTime.now();
        String str=String.valueOf(curr);
        String[] parts=str.split("[-:T]+");
        long year=Long.valueOf(parts[0]);
        String month=parts[1];
        int day=Integer.valueOf(parts[2]);
        date d=new date(day,month,year);
        d.display();
       }
}
       */