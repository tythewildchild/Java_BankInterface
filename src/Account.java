import java.util.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Account {
    int previousTransaction;
    private double balance;
    static int customerID;
    static String customerName;
    static String dateCreated;

    Account(String name){
        customerName = name;
        Account.customerID++;
        balance = 0.00;
        LocalDate currentDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        dateCreated = currentDate.format(formatter);
    }

    double getBalance(){
        return balance;
    }

    void makeDeposit(double deposit){
        balance += deposit;
    }

    void makeWithdrawal(double withdrawal){
        balance -= withdrawal;
    }

    double calculateInterest(int years){
        return (balance * Math.pow((1 + .01), years) - balance);
    }
    double calculateLoanInterest(double loanAmount, int years){
        return (loanAmount * Math.pow((1 + .06), years) - loanAmount);
    }

}
