import java.util.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.text.DecimalFormat;


public class BankInterface {
    Scanner scanner = new Scanner(System.in);
    BankInterface(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to online banking! If you would like to create an account, type 'create'.");
    }

    //TODO: may add a feature where there are existing accounts
    void searchAccount(String accountName){

    }

    static void menu(Account account){
        char input = ' ';
        while(input != 'G'){
            System.out.println("\nWhat would you like to do?\n");
            System.out.println("A. Check your balance");
            System.out.println("B. Make a deposit");
            System.out.println("C. Make a withdrawal");
            System.out.println("D. Take out a loan");
            System.out.println("E. Calculate Interest");
            System.out.println("F. Account Details");
            System.out.println("G. Exit");

            Scanner scanner = new Scanner(System.in);
            input = scanner.next().charAt(0);
            input = Character.toUpperCase(input);
            switch (input) {
                case 'A' -> {
                    System.out.println("===================");
                    System.out.println("Balance = " + String.format("$%.2f", account.getBalance()));
                    System.out.println("===================\n");
                }
                case 'B' -> {
                    System.out.println("Enter amount to deposit: ");
                    double deposit = scanner.nextDouble();
                    account.makeDeposit(deposit);
                    System.out.println("You have deposited " + String.format("$%.2f", deposit));
                }
                case 'C' -> {
                    System.out.println("Enter amount to withdraw: ");
                    double withdraw = scanner.nextDouble();
                    account.makeWithdrawal(withdraw);
                    System.out.println("You have withdrawn " + String.format("$%.2f", withdraw));

                }
                case 'D' -> {
                    //TODO
                    System.out.println("How much would you like to take out a loan on?");
                    double loanAmount = scanner.nextInt();
                    System.out.println("How many years until you pay off the loan?");
                    int years = scanner.nextInt();
                    double loanInterest = account.calculateLoanInterest(loanAmount, years);
                    System.out.println("Your loan of " + String.format("$%.2f", loanAmount) + " will accrue " + String.format("$%.2f", loanInterest) + " interest in " + years + " years.");
                    System.out.println("This will cost a total of " + String.format("$%.2f", loanAmount + loanInterest));
                }
                case 'E' -> {
                    System.out.println("Your bank account has a 1% interest return rate. How many years do you want to calculate for?");
                    int yearsOfInterest = scanner.nextInt();
                    double interest = account.calculateInterest(yearsOfInterest);
                    System.out.println("Your interest on " + String.format("$%.2f", account.getBalance()) + " will earn you " + String.format("$%.2f", interest) + " in " + yearsOfInterest + " years.");
                }
                case 'F' -> {
                    System.out.println("Here are your account details: ");
                    System.out.println("Name: " + Account.customerName);
                    System.out.println("Date Created: " + Account.dateCreated);
                    System.out.println("Account Id: " + Account.customerID);

                }
                case 'G' -> {
                    System.out.print("Thank you for banking! Have a great day");
                    for(int i = 0; i < 3; i++) {
                        try {
                            Thread.sleep(300);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                        System.out.print(".");
                    }
                }
            }
        }
    }

}
