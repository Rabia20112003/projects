import java.util.Scanner;

public class BasicBankingSystem 
{
    public static void main(String[] args) 
    {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your name: ");
        String name = scanner.nextLine();

        System.out.print("Enter your account number: ");
        String accountNumber = scanner.nextLine();

        System.out.print("Enter your initial balance: ");
        double balance = scanner.nextDouble();

        while (true) 
        {
            System.out.println("\nMenu:");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Balance Inquiry");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) 
            {
                case 1:
                    System.out.print("Enter amount to deposit: ");
                    double depositAmount = scanner.nextDouble();
                    if (depositAmount > 0) 
                    {
                        balance += depositAmount;
                        System.out.println("Deposit successful! Updated balance: $" + balance);
                    } 
                    else 
                    {
                        System.out.println("Invalid amount. Please try again.");
                    }
                    break;

                case 2:
                    System.out.print("Enter amount to withdraw: ");
                    double withdrawalAmount = scanner.nextDouble();
                    if (withdrawalAmount > 0 && withdrawalAmount <= balance) 
                    {
                        balance -= withdrawalAmount;
                        System.out.println("Withdrawal successful! Updated balance: $" + balance);
                    } 
                    else if (withdrawalAmount > balance) 
                    {
                        System.out.println("Insufficient balance. Please try again.");
                    } 
                    else 
                    {
                        System.out.println("Invalid amount. Please try again.");
                    }
                    break;

                case 3:
                    System.out.println("Account Holder: " + name);
                    System.out.println("Account Number: " + accountNumber);
                    System.out.println("Current Balance: $" + balance);
                    break;

                case 4:
                    System.out.println("Thank you for using our banking system. Goodbye!");
                    scanner.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
