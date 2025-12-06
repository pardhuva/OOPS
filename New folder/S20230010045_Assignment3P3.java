import java.util.Scanner;

class AccountCreation {
    private String accountNumber;
    private String accountName;
    private String password;
    private int balance;

    
    AccountCreation(String accountNumber, String accountName, String password, int balance) {
        this.accountNumber = accountNumber;
        this.accountName = accountName;
        this.password = password;
        this.balance = balance;
    }

    
    private boolean passwordCheck(String pass) {
        return pass.equals(password);
    }

    
    int balanceChecking(String pass) {
        if (passwordCheck(pass)) {
            return balance;
        } else {
            System.out.println("Incorrect password.");
            return -1; 
        }
    }

    
    int credit(int amount, String pass) {
        if (passwordCheck(pass)) {
            balance += amount;
            System.out.println(amount + " amount credited.");
            return balance;
        } else {
            System.out.println("Incorrect password.");
            return -1; 
        }
    }

    
    int debit(int amount, String pass) {
        if (passwordCheck(pass)) {
            if (amount <= balance) {
                balance -= amount;
                System.out.println(amount + " amount debited.");
                return balance;
            } else {
                System.out.println("Insufficient balance.");
                return -1; 
            }
        } else {
            System.out.println("Incorrect password.");
            return -1; 
        }
    }

    
    public String getAccountNumber() {
        return accountNumber;
    }
}

public class Account {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        
        AccountCreation account1 = new AccountCreation("001", "Alice", "password1", 5000);
        AccountCreation account2 = new AccountCreation("002", "Bob", "password2", 3000);
        AccountCreation account3 = new AccountCreation("003", "Charlie", "password3", 2000);
        AccountCreation account4 = new AccountCreation("004", "Diana", "password4", 4000);
        AccountCreation account5 = new AccountCreation("005", "Eve", "password5", 10000);

        while (true) {
            System.out.println("\nBanking Operations:");
            System.out.println("1. Login and Perform Operations");
            System.out.println("2. Exit");
            System.out.print("Choose an option: ");
            int option = sc.nextInt();
            sc.nextLine(); 

            if (option == 2) {
                break;
            }

            System.out.print("Enter account number: ");
            String accountNumber = sc.nextLine();
            System.out.print("Enter password: ");
            String password = sc.nextLine();

            
            AccountCreation account = null;
            switch (accountNumber) {
                case "001":
                    account = account1;
                    break;
                case "002":
                    account = account2;
                    break;
                case "003":
                    account = account3;
                    break;
                case "004":
                    account = account4;
                    break;
                case "005":
                    account = account5;
                    break;
                default:
                    System.out.println("Account not found.");
                    continue;
            }

            if (account != null) {
                System.out.println("Login successful.");
                while (true) {
                    System.out.println("\nSelect Operation:");
                    System.out.println("1. Check Balance");
                    System.out.println("2. Credit Amount");
                    System.out.println("3. Debit Amount");
                    System.out.println("4. Logout");
                    System.out.print("Choose an option: ");
                    int operation = sc.nextInt();
                    sc.nextLine(); 

                    if (operation == 4) {
                        break;
                    }

                    switch (operation) {
                        case 1:
                            int balance = account.balanceChecking(password);
                            if (balance != -1) {
                                System.out.println("Remaining balance: " + balance);
                            }
                            break;

                        case 2:
                            System.out.print("Enter amount to credit: ");
                            int creditAmount = sc.nextInt();
                            sc.nextLine(); 
                            int newBalance = account.credit(creditAmount, password);
                            if (newBalance != -1) {
                                System.out.println("Remaining balance: " + newBalance);
                            }
                            break;

                        case 3:
                            System.out.print("Enter amount to debit: ");
                            int debitAmount = sc.nextInt();
                            sc.nextLine(); 
                            int updatedBalance = account.debit(debitAmount, password);
                            if (updatedBalance != -1) {
                                System.out.println("Remaining balance: " + updatedBalance);
                            }
                            break;

                        default:
                            System.out.println("Invalid option. Please try again.");
                    }
                }
            }
        }

        sc.close();
        System.out.println("Exiting the application.");
    }
}
