import java.util.*;

class BankAccount {
    private String accNo;
    private double balance;

    public BankAccount(String accNo, double initialBalance) {
        this.accNo = accNo;
        this.balance = initialBalance;
    }

    public String getAccNo() {
        return accNo;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("₹" + amount + " deposited successfully. New balance: ₹" + balance);
        } else {
            System.out.println("Invalid deposit amount. Please try again.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0) {
            if (amount <= balance) {
                balance -= amount;
                System.out.println("₹" + amount + " withdrawn successfully. New balance: ₹" + balance);
            } else {
                System.out.println("Insufficient balance. Transaction failed.");
            }
        } else {
            System.out.println("Invalid withdrawal amount. Please try again.");
        }
    }

    public void checkBalance() {
        System.out.println("Account Number: " + accNo + ", Balance: ₹" + balance);
    }
}

public class ATMSystem {
    private ArrayList<BankAccount> accounts = new ArrayList<>();
    private Scanner sc = new Scanner(System.in);

    public BankAccount findAccount(String accNo) {
        for (BankAccount account : accounts) {
            if (account.getAccNo().equals(accNo)) {
                return account;
            }
        }
        return null;
    }

    public void runATM() {
        while (true) {
            System.out.println("\nATM System Main Menu:");
            System.out.println("1. Create Account");
            System.out.println("2. Access Account");
            System.out.println("3. Display All Accounts");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter account number: ");
                    String accNo = sc.next();
                    System.out.print("Enter initial balance: ");
                    double initialBalance = sc.nextDouble();

                    if (findAccount(accNo) == null) {
                        accounts.add(new BankAccount(accNo, initialBalance));
                        System.out.println("Account created successfully!");
                    } else {
                        System.out.println("Account with this number already exists.");
                    }
                    break;

                case 2:
                    System.out.print("Enter account number: ");
                    String accNoToAccess = sc.next();
                    BankAccount account = findAccount(accNoToAccess);

                    if (account != null) {
                        while (true) {
                            System.out.println("\nAccount Operations:");
                            System.out.println("1. Deposit");
                            System.out.println("2. Withdraw");
                            System.out.println("3. Check Balance");
                            System.out.println("4. Exit to Main Menu");
                            System.out.print("Choose an option: ");
                            int operationChoice = sc.nextInt();

                            if (operationChoice == 4) break;

                            switch (operationChoice) {
                                case 1:
                                    System.out.print("Enter deposit amount: ");
                                    double depositAmount = sc.nextDouble();
                                    account.deposit(depositAmount);
                                    break;

                                case 2:
                                    System.out.print("Enter withdrawal amount: ");
                                    double withdrawAmount = sc.nextDouble();
                                    account.withdraw(withdrawAmount);
                                    break;

                                case 3:
                                    account.checkBalance();
                                    break;

                                default:
                                    System.out.println("Invalid option. Please try again.");
                            }
                        }
                    } else {
                        System.out.println("Account not found. Please create an account first.");
                    }
                    break;

                case 3:
                    System.out.println("\nAll Accounts:");
                    if (accounts.isEmpty()) {
                        System.out.println("No accounts available.");
                    } else {
                        for (BankAccount acc : accounts) {
                            System.out.println("Account Number: " + acc.getAccNo() + ", Balance: ₹" + acc.getBalance());
                        }
                    }
                    break;

                case 4:
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    return;

                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }

    public static void main(String[] args) {
        ATMSystem atm = new ATMSystem();
        atm.runATM();
    }
}
