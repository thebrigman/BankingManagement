/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BankApp;

import java.util.Scanner;

/**
 * The ManagementSystem class manages funds going in and out of accounts
 *
 * @author Damon Morgan and Elliot Paulsen
 */
public class ManagementSystem {

    private AccountsManager accounts;

    /**
     * Constructor that assigns accounts field
     *
     * @param account
     */
    public ManagementSystem(AccountsManager account) {
        this.accounts = account;
    }

    /**
     * Change the accounts first and last name.
     */
    public void changeName() {
        AccountHolder user;
        String name;
        
        //Ask user for the account number and find correct account.
        System.out.println("Enter account number: ");
        user = accountFinder();
        
        //Ask user for the new first name and set first name based the on user input.
        System.out.println("Enter new first name: ");
        name = accounts.isAlphabet();
        user.setFirstName(name);

        //Ask user for the new last name and set last name based the on user input.
        System.out.println("Enter new last name: ");
        name = accounts.isAlphabet();
        user.setLastName(name);
        
        //Output user information.
        System.out.println(user.toString());
    }

    /**
     * Withdraws money from the account.
     */
    public void withdraw() {
        int amount;
        int acctInput;
        AccountHolder user;

        //Ask the user for the account number to withdraw from and find the correct account
        System.out.println("Enter account number: ");
        user = accountFinder();

        //Print the account requested
        System.out.println(user.toString());

        //Ask the user withdraw amount and ensure the there are enough funds to withdraw
        //If funds are inadequate, loop through until and adequate amount is entered
        System.out.println("How much to withdraw? ");
        amount = accounts.isNum();
        while ((user.getBalance() - amount) < 0) {
            System.out.println("Inadequate funds.\n"
                    + "Current Balance: " + user.getBalance() + "\n"
                    + "Enter valid amount: ");
            amount = accounts.isNum();
        }

        //Subtract user input from the balance within the account and output the account to the screen
        user.setBalance(user.getBalance() - amount);
        System.out.println(user.toString());
    }

    /**
     * Deposits money into the account.
     */
    public void deposit() {
        int amount;
        int acctInput;
        AccountHolder user;

        //Ask the user for the account number to withdraw from and find the correct account
        System.out.println("Enter account number? ");
        user = accountFinder();

        //Print the account requested
        System.out.println(user.toString());

        //Ask the user how much to deposit and add user input with the balance in the account
        //then output the account information to the screen
        System.out.println("How much to deposit? ");
        amount = accounts.isNum();
        user.setBalance(user.getBalance() + amount);
        System.out.println(user.toString());

    }

    /**
     * Transfers money between accounts
     */
    public void transfer() {
        int amount;
        int acctInput;
        AccountHolder accountFrom;
        AccountHolder accountTo;

        //Ask the user to enter the account number to withraw from, finds the correct account
        //and outputs the correct account.
        System.out.println("Enter account number to transfer from? ");
        accountFrom = accountFinder();
        System.out.println(accountFrom.toString());

        //Ask the user to enter the account number to deposit to, finds the correct account
        //and outputs the correct account 
        System.out.println("Enter account number to transfer to? ");
        accountTo = accountFinder();
        System.out.println(accountTo.toString());

        //Asks the user how much they would like to deposit, ensure there are adequate funds within
        //the account beint withdrawn. If not, ask the user to input an adequate amount.
        System.out.println("How much? ");
        amount = accounts.isNum();
        while ((accountFrom.getBalance() - amount) < 0) {
            System.out.println("Inadequate funds.\n"
                    + "Current Balance: " + accountFrom.getBalance() + "\n"
                    + "Enter valid amount: ");
            amount = accounts.isNum();
        }

        //Subtract the user input from the balance of the withdraw account and
        // deposit the user input to the deposit accout.
        accountFrom.setBalance(accountFrom.getBalance() - amount);
        accountTo.setBalance(accountTo.getBalance() + amount);

        //Output both accounts.
        System.out.println(accountFrom.toString());
        System.out.println(accountTo.toString());
    }

    /**
     * Allows the user to take out a loan on an account.
     */
    public void borrow() {
        int amount;
        int acctInput;
        AccountHolder user;

        //Ask user for account number to borrow from,
        //find correct account, and output the account requested.
        System.out.println("Enter account number: ");
        user = accountFinder();
        System.out.println(user.toString());

        //Ask the user for the amount to borrow set the amount entered
        //to the account credit balance and output the account.
        System.out.println("How much to borrow? ");
        amount = accounts.isNum();
        user.setCreditBalance(amount);
        System.out.println(user.toString());
    }

    /**
     * Allows the user to make a payment on a loan on an account.
     */
    public void LoanPayment() {
        int amount;
        int acctInput;
        AccountHolder user;

        //Ask the user for account number make a payment on,
        //find correct account.
        System.out.println("Enter account number: ");
        user = accountFinder();

        //If the account does not have an existing loan then it will return to the menu
        if (user.getCreditBalance() <= 0) {
            System.out.println("This account does not have an existing loan");
        } else {

            //Output the correct account
            System.out.println(user.toString());

            //Ask the user for the amount to pay set the amount entered
            //to the account credit balance and output the account.
            System.out.println("How much to pay? ");
            amount = accounts.isNum();

            //Check if balance on the account has adequate funds based on users payment.
            // If not, loop until the user enters adequate funds.
            while ((user.getBalance() - amount) < 0) {
                System.out.println("Inadequate funds.\n"
                        + "Current Balance: " + user.getBalance() + "\n"
                        + "Enter valid amount: ");
                amount = accounts.isNum();
            }

            //If the accounts credit balance is less than payment, then pay off loan and deduct loan 
            //payoff from the account balance.
            if ((user.getCreditBalance() - amount) < 0) {
                user.setBalance(user.getBalance() - user.getCreditBalance());
                user.setCreditBalance(0);

            } else {

                //Subtract user input from loan balance and account balance.
                user.setCreditBalance(user.getCreditBalance() - amount);
                user.setBalance(user.getBalance() - amount);
            }

            //Output the account information.
            System.out.println(user.toString());
        }
    }

    /**
     * Finds the account requested by the user
     *
     * @return the correct user.
     */
    public AccountHolder accountFinder() {
        int acctInput;
        AccountHolder user;

        //Scan user input and check if it is an integer.
        acctInput = accounts.isNum();

        //Find account based on users input 
        acctInput = accounts.isAccount(acctInput);
        user = accounts.findHolder(acctInput);
        return user;
    }

}
