import java.util.*;

public class ATMSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Creating a mock user account for demonstration
        ATM atm = new ATM();
        if (atm.login()) {
            int choice;
            do {
                System.out.println("\n--- ATM System ---");
                System.out.println("1. View Transaction History");
                System.out.println("2. Withdraw");
                System.out.println("3. Deposit");
                System.out.println("4. Transfer");
                System.out.println("5. Quit");
                System.out.print("Enter your choice: ");
                choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline
                
                switch (choice) {
                    case 1:
                        atm.viewTransactionHistory();
                        break;
                    case 2:
                        atm.withdraw();
                        break;
                    case 3:
                        atm.deposit();
                        break;
                    case 4:
                        atm.transfer();
                        break;
                    case 5:
                        System.out.println("Exiting...");
                        break;
                    default:
                        System.out.println("Invalid choice, please try again.");
                        break;
                }
            } while (choice != 5);
        } else {
            System.out.println("Invalid login. Exiting...");
        }
    }
}

class UserAccount {
    private String userId;
    private String pin;
    private double balance;
    private TransactionHistory transactionHistory;

    public UserAccount(String userId, String pin, double balance) {
        this.userId = userId;
        this.pin = pin;
        this.balance = balance;
        this.transactionHistory = new TransactionHistory();
    }

    public boolean authenticate(String enteredPin) {
        return this.pin.equals(enteredPin);
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        this.balance += amount;
        transactionHistory.addTransaction(new Transaction("Deposit", amount));
    }

    public boolean withdraw(double amount) {
      
