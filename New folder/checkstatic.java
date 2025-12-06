//static method can only call static variables of sme class 
//static object is not created yet nonstatic object is created 
//non static can call both staic and nonstatic variables

class Bank {
    static int number_of_accounts;
    String phonenumber;

    public static void print() {
        System.out.println(number_of_accounts);    
        System.out.println(phonenumber);         //can only get num_of accoutns here pphno is non static but the function is static so it will give error
    }
    // public  void print() {
    //     System.out.println(number_of_accounts);    
    //     System.out.println(phonenumber);          // it wont give any error it read both the values as it is the nonstatic method it can access both static and non static vriables
    // }
}

class checkstatic {
    public static void main(String[] args) {
        Bank b1 = new Bank();
        b1.number_of_accounts = 3;
        b1.phonenumber = "8343422453";
        b1.print();
    }
}
