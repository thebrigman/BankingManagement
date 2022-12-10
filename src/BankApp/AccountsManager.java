/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BankApp;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * AccountManager class adds and deletes accounts on the ArrayList. As well as
 * prints the account information, finds the correct account, checks if the user
 * input is an integer or a letter.
 *
 * @author Damon Morgan and Elliot Paulsen.
 */
public class AccountsManager {

    private ArrayList<AccountHolder> accountList = new ArrayList<>();

    public ArrayList<AccountHolder> getAccountList() {
        return accountList;
    }

    //Adds account to the ArrayList
    public void addAccounts() {
        String firstName;
        String lastName;
        int deposit = 0;
        int num;

        //Ask user how many accounts they would like to add
        System.out.println("How many accounts would you like to add?");
        num = isNum();

        //Ask user for account information and add to the accountList. 
        //Loop through as many times as the user requested.
        for (int i = 0; i < num; i++) {
            System.out.println("Enter First Name: ");
            firstName = isAlphabet();

            System.out.println("Enter Last Name: ");
            lastName = isAlphabet();

            System.out.println("Enter deposit amount: ");
            deposit = isNum();

            AccountHolder account = new AccountHolder(firstName, lastName, deposit);

            accountList.add(account);
        }

    }

    //Deletes account from the accountList.
    public void deleteAccount() {
        int accountNum;
        AccountHolder account;

        //Ask user for the account number,
        //scan for an integer, and find the account holder.
        System.out.println("Enter account number: ");
        accountNum = isNum();
        account = findHolder(accountNum);

        //Remove account from accountList.
        accountList.remove(account);

    }
    
    /**
     * Finds the correct holder based on user input.
     * @param num
     * @return the correct account.
     */
    public AccountHolder findHolder(int num) {
        AccountHolder user = new AccountHolder();

        //Loop through accountList and find the account number that matches user input.
        for (int i = 0; i < accountList.size(); i++) {
            if (num == accountList.get(i).getAccountNum()) {
                user = accountList.get(i);
            }
        }
        //Return user.
        return user;
    }

    /**
     * Outputs the account information.
     */
    public void printAccounts() {

        //Loop through the accountList and output the accounts int the accountList.
        for (int i = 0; i < accountList.size(); i++) {
            System.out.println("--------------------------------------------------------------------------------------");

            //If the accountHolder has a credit balance, output the credit balance.
            //Else output the accountHolder information without the credit balance.
            if (accountList.get(i).getCreditBalance() > 0) {
                System.out.println(" Account number: " + accountList.get(i).getAccountNum() + "\n First name: " + accountList.get(i).getFirstName()
                        + "\n Last name: " + accountList.get(i).getLastName() + "\n Balance: $" + accountList.get(i).getBalance() + "\n Loan balance: $" + accountList.get(i).getCreditBalance());
            } else {
                System.out.println(" Account number: " + accountList.get(i).getAccountNum() + "\n First name: " + accountList.get(i).getFirstName()
                        + "\n Last name: " + accountList.get(i).getLastName() + "\n Balance: $" + accountList.get(i).getBalance());
            }
        }
    }

    /**
     * Checks if user input is a letter.
     */
    public String isAlphabet() {
        Scanner scnr = new Scanner(System.in);
        String name = scnr.next();
        
        //If user input is not a letter, the program will repeatedly ask the user
        //to enter a letter. 
        while (!name.matches("^[a-zA-Z]*$") || name.isEmpty()) {
            System.out.println("Invalid. Please enter letters only. Try again: ");
            name = scnr.next();
        }
       //return name.
        return name;
    }

    /**
     * Checks if user input is and integer.
     * @return the integer entered by the user. 
     */
    public int isNum() {
        boolean error = false;
        int x = 0;
        do {
            try {
                // create object of scanner class.
                Scanner KB = new Scanner(System.in);

                // enter here.
//                System.out.print("Enter integer : ");
                x = KB.nextInt();
                error = false;
            } catch (Exception e) {
                // accept integer only.
                System.out.println("Invalid Input. Enter numbers only: ");
                error = true;
            }
        } while (error);
        return (x);
    }

    /**
     * Checks if the account number entered exists int the accountList.
     * @param num
     * @return the user input that matches the account number in the accountList;
     */
    public int isAccount(int num) {
        
        int[] accounts = new int[accountList.size()];
        
        //Loop through accountList and add getAccountNum to the accounts array.
        for (int i = 0; i < accountList.size(); i++) {
            accounts[i] = accountList.get(i).getAccountNum();

        }
        
        //If userInput is a valid number in the accounts array, it will return user input.
        //Otherwise it will loop through until the user inputs a valid account number.
        while (true) {
            for (int x : accounts) {

                if (x == num) {

                    return num;
                }

            }
            System.out.println("Invalid account. Accounts available: ");
            System.out.println(accounts.length);
            System.out.println("Enter valid account ");
            num = isNum();
        }

        
    }

}
