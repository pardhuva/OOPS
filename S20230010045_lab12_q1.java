class Bank_account{
    private double balance;
    Bank_account(double balance){
        this.balance=balance;
    }
    public synchronized void deposit(double amount){
        if(amount>0){
            balance +=amount;
            System.out.println(Thread.currentThread().getName()+ "   deposited amount:   "+amount+"   new balance :  "+balance);
        }
        else{
            System.out.println("Name:"+Thread.currentThread().getName()+"invalid amount");
        }
    }
    public  synchronized void withdraw(double amount){
        if(amount>0&&balance>amount){
            balance -=amount;
            System.out.println(Thread.currentThread().getName()+"   withdraw amount : "+amount+" balance : "+balance);
        }else if(amount>0) {
            System.out.println("Name:"+Thread.currentThread().getName()+"tried to withdraw"+amount+"Insufficent balance"+"current balance"+balance);
        } else{
            System.out.println("Name:"+Thread.currentThread().getName()+"tried to withdraw with an invalid amount"+amount);
        }
    }
public synchronized double getbalance(){
return balance;
}
}
class userThread implements Runnable{
    private final Bank_account account;
    userThread(Bank_account account){
        this.account=account;
    }
        public void run(){
            for(int i=0;i<3;i++){
                double deposit_amount=Math.random()*1000;
                double withdraw_amount=Math.random()*1000;
                account.deposit(deposit_amount);
                try{
                    Thread.sleep(200);
                }
                catch(Exception e){
                    System.out.println(e);
                }
                account.withdraw(withdraw_amount);
                try{
                    Thread.sleep(200);
                }
                catch(Exception e){
                    System.out.println(e);
                }
            }
        }
       
    }
        class S20230010090_lab12_q1 {
        public static void main(String[] args) {
            Bank_account newbank_account=new Bank_account(2500);
         Thread user1=new Thread(new userThread(newbank_account),"user1");
         Thread user2=new Thread(new userThread(newbank_account),"user2");
         Thread user3=new Thread(new userThread(newbank_account),"user3");
         user1.start();
         user2.start();
         user3.start();
         try{
            user1.join();
            user2.join();
            user3.join();
         }
         catch(Exception e){
            e.printStackTrace();
         }
         System.out.println("final account balance : "+newbank_account.getbalance());
    }
}
