import java.util.*;
class accountcreation{
    private String accountnumber;
    public String accountname;
    private String password;
    private int balance;
    accountcreation(String accountname,int balance){
        this.accountname=accountname;
        this.balance=balance;
    }
    void accountlogin(String accountnumber,String password){
        this.accountnumber=accountnumber;
        this.password=password;
        System.out.println("account login successfully");
    }
    boolean passwordcheck(String pass){
        return pass.equals(password);
    }
    int balance_checking(String pass){
        if(passwordcheck(pass)){
        return balance;
        }
        else{
            System.out.println("incorrect password:");
            return 0;
        }
    }
    int credit(int bal,String pass){
        if(passwordcheck(pass)){
        balance=balance+bal;
        System.out.println(bal+" " + "amount credited");
        return balance;
        }
        else{
            System.out.println("incorrect password:");
            return 0;
        }
    }
    int debit(int bal,String pass){
        if(passwordcheck(pass)){
        balance=balance-bal;
        System.out.println(bal+" "+"amount debited");
        return balance;
        }
        else{
            System.out.println("incorrect password:");   
        return 0;
        }
    }

}

public class bankaccount{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        System.out.println("name:");
        String name=sc.nextLine();
        System.out.println("balance:");
        int ba=sc.nextInt();
        sc.nextLine();
        System.out.println("accoutnnumber:");
        String accountnumber=sc.nextLine();
        System.out.println("password:");
        String password=sc.nextLine();

        accountcreation a1=new accountcreation(name,ba);
        a1.accountlogin(accountnumber,password);
        
        System.out.println("enter the password to check balance:");
        String pass=sc.nextLine();
        int balance=a1.balance_checking(pass);
        System.out.println("remaining balance:"+balance);

        System.out.println("enter the password to credit amount:");
        pass=sc.nextLine();
        System.out.println("enter the amount to credit:");
        int amount=sc.nextInt();
        sc.nextLine();
        a1.credit(amount,pass);
        int bal=a1.credit(amount,pass);
        System.out.println("remaining balance:"+bal);

        System.out.println("enter the password to debit amount:");
        pass=sc.nextLine();
        System.out.println("enter the amount to debit:");
        int amount1=sc.nextInt();
        sc.nextLine();
        int bal1=a1.debit(amount1,pass);
        System.out.println("remaining balance:"+bal1);
        

    }
}