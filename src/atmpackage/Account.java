package atmpackage;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Account {

    private int accountNumber;
    private int pinNumber;

    private double checkingBalance;
    private double savingBalance;

    Scanner scan = new Scanner(System.in);

    DecimalFormat moneyFormat = new DecimalFormat("'$' ###,##0.00");


    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public int getPinNumber() {
        return pinNumber;
    }

    public void setPinNumber(int pinNumber) {
        this.pinNumber = pinNumber;
    }

    public double getCheckingBalance() {
        return checkingBalance;
    }

    public void setCheckingBalance(double checkingBalance) {
        this.checkingBalance = checkingBalance;
    }

    public double getSavingBalance() {
        return savingBalance;
    }

    public void setSavingBalance(double savingBalance) {
        this.savingBalance = savingBalance;
    }


    //Calculate checking balance after withdraw
    private double calculateCheckingBalanceAfterWithdraw(double amount) {

        checkingBalance = checkingBalance - amount; //When user want to withdraw money, the balance will be updated
        return checkingBalance;
    }

    //Calculate checking balance after deposit
    private double calculateCheckingBalanceAfterDeposit(double amount) {

        checkingBalance = checkingBalance + amount;
        return checkingBalance;
    }


    //Calculate saving balance after withdraw
    private double calculateSavingBalanceAfterWithdraw(double amount) {

        savingBalance = savingBalance - amount;
        return savingBalance;
    }

    //Calculate saving balance after deposit
    private double calculateSavingBalanceAfterDeposit(double amount) {

        savingBalance = savingBalance + amount;
        return savingBalance;
    }


    //Interact with user to withdraw money from checking account
    public void getCheckingWithdraw() {

        System.out.println("Your checking balance is: " + moneyFormat.format(checkingBalance));
        System.out.println("Enter the amount you want to withdraw");
        double amount = scan.nextDouble();
        if (amount <= 0) {
            System.out.println("Negative or Zero amount is not accepted!");
            getCheckingWithdraw();
        } else if (checkingBalance >= amount) {
            calculateCheckingBalanceAfterWithdraw(amount);
            System.out.println("Your checking balance is: " + moneyFormat.format(checkingBalance));
        } else {
            System.out.println("You do not have enough money on your checking account");
        }
    }


    //Interact with user to deposit money to checking account
    public void getCheckingDeposit() {

        System.out.println("Your checking balance is: " + moneyFormat.format(checkingBalance));
        System.out.println("Enter the amount you want to deposit");
        double amount = scan.nextDouble();

        if (amount <= 0) {
            System.out.println("Negative or Zero amount is not accepted");
            getCheckingDeposit();
        } else {
            calculateCheckingBalanceAfterDeposit(amount);
            System.out.println("Your checking balance is: " + moneyFormat.format(checkingBalance));
        }
    }


    //Interact with user to withdraw money from saving account
    public void getSavingWithdraw() {

        System.out.println("Your saving balance is: " + moneyFormat.format(savingBalance));
        System.out.println("Enter the amount you want to withdraw");
        double amount = scan.nextDouble();
        if (amount <= 0) {
            System.out.println("Negative or Zero amount is not accepted!");
            getSavingWithdraw();
        } else if (savingBalance >= amount) {
            calculateSavingBalanceAfterWithdraw(amount);
            System.out.println("Your saving balance is: " + moneyFormat.format(savingBalance));
        } else {
            System.out.println("You do not have enough money on your saving account");
        }
    }


    //Interact with user to deposit money to saving account
    public void getSavingDeposit() {

        System.out.println("Your saving balance is: " + moneyFormat.format(savingBalance));
        System.out.println("Enter the amount you want to deposit");
        double amount = scan.nextDouble();

        if (amount <= 0) {
            System.out.println("Negative or Zero amount is not accepted");
            getSavingDeposit();
        } else {
            calculateSavingBalanceAfterDeposit(amount);
            System.out.println("Your saving balance is: " + moneyFormat.format(savingBalance));
        }
    }

}
