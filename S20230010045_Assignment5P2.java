import Datestore.Date;
import java.util.ArrayList;
import java.util.Scanner;

public class EmailAccount {
    private String user_name;
    private String pass;
    private ArrayList<String> send_message;
    private Date DOB; // Here DOB is initialized to current date for now
    private ArrayList<String> receive_message;
    public static int total_no_of_Accs = 0;

    // Constructor to initialize EmailAccount
    public EmailAccount(String user_name, String pass) {
        this.user_name = user_name;
        this.pass = pass;
        this.send_message = new ArrayList<>();
        this.receive_message = new ArrayList<>();
        this.DOB = new Date();
        total_no_of_Accs++;
    }

    public String getUser_name() {
        return user_name;
    }

    public Date getDOB() {
        return DOB;
    }

    public ArrayList<String> getSendMessages() {
        return send_message;
    }

    public ArrayList<String> getReceivedMessages() {
        return receive_message;
    }

    public static int getTotal_no_of_Accs() {
        return total_no_of_Accs;
    }

    // To update the password
    public void update_account(String user_name, String old_pass, String new_pass) {
        if (this.user_name.equals(user_name) && this.pass.equals(old_pass)) {
            this.pass = new_pass;
        } else {
            System.out.println("Authentication failed!");
        }
    }

    // To check messages
    public void check_message(String user_name, String pass) {
        if (this.user_name.equals(user_name) && this.pass.equals(pass)) {
            System.out.println("Received Messages:");
            for (String message : receive_message) {
                System.out.println(message);
            }
        } else {
            System.out.println("Authentication failed!");
        }
    }

    // To send a message
    public void send_message(String user_name, String pass, EmailAccount recipient, String message) {
        if (this.user_name.equals(user_name) && this.pass.equals(pass)) {
            this.send_message.add(message);
            recipient.receive_message.add(message);
            System.out.println("Message sent successfully!");
        } else {
            System.out.println("Authentication failed!");
        }
    }

    // Main method for testing
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<EmailAccount> accs = new ArrayList<>();

        System.out.print("Enter the number of accounts to create: ");
        int number_of_accounts = scanner.nextInt();
        scanner.nextLine();

        for (int k = 0; k < number_of_accounts; k++) {
            System.out.print("Enter username for account " + (k + 1) + ": ");
            String user_name = scanner.nextLine();
            System.out.print("Enter password for account " + (k + 1) + ": ");
            String pass = scanner.nextLine();
            accs.add(new EmailAccount(user_name, pass));
        }

        System.out.println("\nTotal Accounts Created: " + EmailAccount.getTotal_no_of_Accs());
        System.out.println("Account Details:");
        for (EmailAccount acc : accs) {
            System.out.println("Username: " + acc.getUser_name());
            System.out.println("Date of Birth: " + acc.getDOB());
        }

        // Sending messages
        System.out.print("Enter sender username: ");
 
            }
}