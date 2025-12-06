//S20230010045_Assignment_10P2 {
 

//a
/* 
import java.io.Serializable;

public class TransactionRecord implements Serializable {
    private int accountNumber;
    private double amount;

    public TransactionRecord(int accountNumber, double amount) {
        this.accountNumber = accountNumber;
        this.amount = amount;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public double getAmount() {
        return amount;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}

//b
import java.io.Serializable;

public class AccountRecord implements Serializable {
    private int accountNumber;
    private String firstName;
    private String lastName;
    private double balance;

    public AccountRecord(int accountNumber, String firstName, String lastName, double balance) {
        this.accountNumber = accountNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.balance = balance;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public double getBalance() {
        return balance;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void combine(TransactionRecord transactionRecord) {
        this.balance += transactionRecord.getAmount();
    }
}


//c
 
import java.io.*;
import java.util.*;

public class CreateTestData {

    public static void createTransactionFile() {
        try (ObjectOutputStream transFile = new ObjectOutputStream(new FileOutputStream("trans.txt"))) {
            // Sample transaction records (AccountNumber, Amount)
            transFile.writeObject(new TransactionRecord(101, 150.75));
            transFile.writeObject(new TransactionRecord(102, -50.50));
            transFile.writeObject(new TransactionRecord(103, 200.00));
            transFile.writeObject(new TransactionRecord(104, -120.00));
            transFile.writeObject(new TransactionRecord(105, 80.50));

            System.out.println("Transaction file (trans.txt) created successfully.");
        } catch (IOException e) {
            System.out.println("Error creating transaction file: " + e);
        }
    }

    public static void createMasterFile() {
        try (ObjectOutputStream mastFile = new ObjectOutputStream(new FileOutputStream("oldmast.txt"))) {
            // Sample account records (AccountNumber, FirstName, LastName, Balance)
            mastFile.writeObject(new AccountRecord(101, "Paru", "Madhu", 1000.00));
            mastFile.writeObject(new AccountRecord(102, "Teju", "Sneha", 1200.00));
            mastFile.writeObject(new AccountRecord(103, "Paru", "Teju", 1300.00));
            mastFile.writeObject(new AccountRecord(104, "Sneha", "Teju", 800.00));
            mastFile.writeObject(new AccountRecord(105, "Madhu", "Paru", 600.00));

            System.out.println("Master file (oldmast.txt) created successfully.");
        } catch (IOException e) {
            System.out.println("Error creating master file: " + e);
        }
    }

    public static void main(String[] args) {
        // Create test data files
        createTransactionFile();
        createMasterFile();
    }
}
*/

//d

import java.io.*;
import java.util.*;

public class Q2_S20230010045_Assignment10//FileMatch  {

    public static void performFileMatch() {
        try (ObjectInputStream mastFile = new ObjectInputStream(new FileInputStream("oldmast.txt"));
             ObjectInputStream transFile = new ObjectInputStream(new FileInputStream("trans.txt"));
             ObjectOutputStream newMastFile = new ObjectOutputStream(new FileOutputStream("newmast.txt"));
             PrintWriter logFile = new PrintWriter(new FileWriter("log.txt", true))) {

            AccountRecord masterRecord;
            TransactionRecord transactionRecord;
            boolean matched;

            // Read records from master file and transaction file
            List<TransactionRecord> transactionRecords = new ArrayList<>();
            while (true) {
                try {
                    transactionRecord = (TransactionRecord) transFile.readObject();
                    transactionRecords.add(transactionRecord);
                } catch (EOFException e) {
                    break; // End of transaction file
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }

            // Perform matching of transaction records with account records
            while (true) {
                try {
                    masterRecord = (AccountRecord) mastFile.readObject();
                } catch (EOFException e) {
                    break; // End of master file
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }

                matched = false;
                for (TransactionRecord tRecord : transactionRecords) {
                    if (masterRecord.getAccountNumber() == tRecord.getAccountNumber()) {
                        // Apply the transaction to the account
                        masterRecord.combine(tRecord);
                        matched = true;
                        break; // Stop looking for matching transactions once found
                    }
                }

                // Write to newmast.txt
                if (matched) {
                    newMastFile.writeObject(masterRecord);
                } else {
                    newMastFile.writeObject(masterRecord);
                    logFile.println("Unmatched transaction record for account number: " + masterRecord.getAccountNumber());
                }
            }

            System.out.println("File matching completed. Updated master file created.");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error during file matching: " + e);
        }
    }

    public static void main(String[] args) {
        // Run the file-matching operation
        performFileMatch();
    }
}
