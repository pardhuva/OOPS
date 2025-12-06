//for executing change the file name to Bank_Management
abstract class BankAccount{
    protected String accountNumber;
    protected String accountHolder;
    protected double balance;
    
    BankAccount(String accountNumber,String accountHolder,double balance){
        this.accountNumber=accountNumber;
        this.accountHolder=accountHolder;
        this.balance=balance;
    }
    abstract void deposit(double amount);
    abstract void withdraw(double amount);
    public  double getBalance(){
        return balance;
    };
    public  void getAccountdetails(){
        System.out.println("accountnumber: "+accountNumber);
        System.out.println("accountholder: " +accountHolder);
        System.out.println("balance: "+balance);
    }
    

}

interface InterestBearing{
    public final double INTEREST_RATE=0.05;
    public void calculateInterest();
}

class SavingsAccount extends BankAccount implements InterestBearing{
    SavingsAccount(String accountNumber,String accountHolder,double balance){
        super(accountNumber,accountHolder,balance);
    }
     public void deposit(double amount){
         balance=balance+amount;
         System.out.println("deposit successfully");
     }
     public void withdraw(double amount){
        if(amount<balance){
        balance=balance-amount;
        System.out.println("withdraw successfully");
        }
        else{
            System.out.println("insufficient balance");
        }

     }
     public void calculateInterest(){
         double value=(balance*INTEREST_RATE);
         System.out.println("interst obtained: "+value);
         balance+=value;
     }
}

class CurrentAccount extends BankAccount{
    public double overdraftlimit;//in dollars

    CurrentAccount(String accountNumber,String accountHolder,double balance,double overdraftlimit){
        super(accountNumber,accountHolder,balance);
        this.overdraftlimit=overdraftlimit;
    }
    public void deposit(double amount){
        balance=balance+amount;
        System.out.println("deposit successfully");
    }
    public void withdraw(double amount){
        if(amount<=balance){
            balance-=amount;
            System.out.println("withdraw successfully");
        }
        else if(amount>balance&&overdraftlimit+balance>=amount){
            balance=0;
            overdraftlimit=overdraftlimit-(amount-balance);
            System.out.println("withdraw successfully using overdraft");
        }
        else {
            System.out.println("insufficient balance");
        }
    }
}

class Bank{
     public void performTransaction(BankAccount account){
        account.deposit(1000);
        account.withdraw(300);
        System.out.println(account.getBalance());
     }
}

public class Main1{
     
    public static void main(String args[]){
        Bank b=new Bank();

        SavingsAccount s=new SavingsAccount("12345","pardhuva",300);
        CurrentAccount c=new CurrentAccount("6789","jungkook",1000000,400);
        System.out.println("Savings_account_details: ");
        s.getAccountdetails();
        System.out.println();

        System.out.println("Currentaccount_details: ");
        c.getAccountdetails();
        System.out.println();

        b.performTransaction(s);
        b.performTransaction(c);

        s.deposit(500);
        s.withdraw(100);
        s.calculateInterest();

        System.out.println();
        System.out.println("printing balances:");
        System.out.println(s.getBalance());
        System.out.println(c.getBalance());
    }
}