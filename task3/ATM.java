import java.util.Scanner;

public class ATM {
    private double balance;
    private final String pin = "1234"; 

    public ATM() {
        balance = 1000.0; 
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the ATM!");

        if (!authenticate(scanner)) {
            System.out.println("Too many failed attempts. Exiting.");
            return;
        }

        int choice;
        do {
            System.out.println("\nATM Menu:");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    checkBalance();
                    break;
                case 2:
                    deposit(scanner);
                    break;
                case 3:
                    withdraw(scanner);
                    break;
                case 4:
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        } while (choice != 4);

        scanner.close();
    }

    private boolean authenticate(Scanner scanner) {
        int attempts = 3;
        while (attempts > 0) {
            System.out.print("Enter your PIN: ");
            String inputPin = scanner.next();

            if (inputPin.equals(pin)) {
                return true;
            } else {
                attempts--;
                System.out.println("Incorrect PIN. Attempts left: " + attempts);
            }
        }
        return false;
    }

    private void checkBalance() {
        System.out.printf("Your current balance is: $%.2f\n", balance);
    }

    private void deposit(Scanner scanner) {
        System.out.print("Enter amount to deposit: ");
        double amount = scanner.nextDouble();
        if (amount <= 0) {
            System.out.println("Invalid deposit amount.");
        } else {
            balance += amount;
            System.out.println("Deposit successful.");
            checkBalance();
        }
    }

    private void withdraw(Scanner scanner) {
        System.out.print("Enter amount to withdraw: ");
        double amount = scanner.nextDouble();
        if (amount <= 0) {
            System.out.println("Invalid withdrawal amount.");
        } else if (amount > balance) {
            System.out.println("Insufficient balance.");
        } else {
            balance -= amount;
            System.out.println("Withdrawal successful.");
            checkBalance();
        }
    }

    public static void main(String[] args) {
        ATM atm = new ATM();
        atm.start();
    }
}
