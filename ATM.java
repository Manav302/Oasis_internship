import java.util.Scanner;

public class ATM {
    private static double balance = 5000;
    private static String transactionHistory = "";
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your User ID: ");
        String userId = sc.nextLine();
        System.out.println("Enter your PIN: ");
        String pin = sc.nextLine();

        if (authenticate(userId, pin)) {
            showMenu(sc);
        } else {
            System.out.println("Invalid User ID or PIN. Exiting...");
        }
    }
    public static boolean authenticate(String userId, String pin) {
        return userId.equals("manav") && pin.equals("3756");
    }
    public static void showMenu(Scanner sc) {
        int choice;
        do {
            System.out.println("\nATM Menu:");
            System.out.println("1. Transaction History");
            System.out.println("2. Withdraw");
            System.out.println("3. Deposit");
            System.out.println("4. Transfer");
            System.out.println("5. Quit");
            System.out.println("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    showTransactionHistory();
                    break;
                case 2:
                    withdraw(sc);
                break;
                case 3:
                    deposit(sc);
                    break;
                case 4:
                    transfer(sc);
                break;
                case 5:
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 5);
    }

    public static void showTransactionHistory() {
        if (transactionHistory.isEmpty()) {
            System.out.println("No transactions available.");
        } 
        else {
            System.out.println("Transaction History:\n" + transactionHistory);
        }
    }
    public static void withdraw(Scanner sc) {
        System.out.println("Enter amount to withdraw: ");
        double amount = sc.nextDouble();
        if (amount > balance) {
            System.out.println("Insufficient balance!");

        } else {
            balance -= amount;
            transactionHistory += "Withdrew: $" + amount + "\n";

            System.out.println("Withdrawal successful! \n Current balance: $" + balance);
        }
    }

    public static void deposit(Scanner sc) {
        System.out.println("Enter amount to deposit: ");
        double amount = sc.nextDouble();
        balance += amount;
        transactionHistory += "Deposited: $" + amount + "\n";

        System.out.println("Deposit successful! Current balance: $" + balance);
    }

    public static void transfer(Scanner sc) {
        System.out.println("Enter amount to transfer: ");
        double amount = sc.nextDouble();
        if (amount > balance) {
            System.out.println("Insufficient balance!");
        } 
        else {
            balance -= amount;
            transactionHistory += "Transferred: $" + amount + "\n";
            System.out.println("Transfer successful! Current balance: $" + balance);
        }
    }
}
