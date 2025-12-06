class student{
      String name;
      int roll_no;
      int age;
    void intialise(String anme,int roll_no,int age){

        this.name=name;
        this.age=age;
        this.roll_no=roll_no;
    }

     String printname(){
         
         return name;
     }
     
     
}

class studentclass{
     
    public static void main(SString args[]){
        Scanner sc=new Scanner(System.in);
        student stud=new student();
        String name=sc.nextLine();
        int roll_no=sc.nextInt();
        int age=sc.nextInt();

        stud.intialise(name,roll_no,age);

        
    }
}