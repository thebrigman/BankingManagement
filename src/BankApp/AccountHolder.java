/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BankApp;

/**
 * The AccountHolder class represents the account holder
 *
 * @author Damon Morgan and Elliot Paulsen
 */
public class AccountHolder {

    private static int num = 1;
    private int accountNum;
    private String firstName;
    private String lastName;
    private int balance;
    private int creditBalance;

    /**
     * Creates an account with the account number, first name, last name,
     * balance, and creditBalance set to default values.
     */
    public AccountHolder() {
        this.accountNum = 0;
        this.firstName = "none";
        this.lastName = "none";
        this.balance = 0;
        this.creditBalance = 0;
    }

    /**
     * Creates an account with the account number, first name, last name,
     * balance, and creditBalance set to default values.
     * @param firstName
     * @param lastName
     * @param balance
     */
    public AccountHolder(String firstName, String lastName, int balance) {

        this.firstName = firstName;
        this.lastName = lastName;
        this.balance = balance;
        this.accountNum = num;
        this.creditBalance = 0;
        num++;
    }

    /**
     * Gets credit balance.
     *
     * @return the credit balance.
     */
    public int getCreditBalance() {
        return creditBalance;
    }

    /**
     * Sets Credit Balance.
     *
     * @param creditBalance
     */
    public void setCreditBalance(int creditBalance) {
        this.creditBalance = creditBalance;
    }

    /**
     * Gets account number.
     *
     * @return the account number.
     */
    public int getAccountNum() {
        return accountNum;
    }

    /**
     * Gets the first name.
     *
     * @return first name.
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets the first name.
     *
     * @param firstName
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Gets the last name.
     *
     * @return last name.
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets the last name.
     *
     * @param lastName
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Gets the balance.
     *
     * @return balance.
     */
    public int getBalance() {
        return balance;
    }

    /**
     * Sets the balance.
     *
     * @param balance
     */
    public void setBalance(int balance) {
        this.balance = balance;
    }

    /**
     * Outputs a account information. 
     */
    public String toString() {
        
        //If creditBalance is greater than zero, output creditBalance information.
        //Else print account information without creditBalance information.
        if (getCreditBalance() > 0) {
            return "Account number: " + getAccountNum() + "\nFirst name: " + getFirstName() + ""
                    + "\nLast name: " + getLastName() + "\nBalance: $" + getBalance() + "\nLoan balance: $" + getCreditBalance();
        } else {
            return "Account number: " + getAccountNum() + "\nFirst name: " + getFirstName() + ""
                    + "\nLast name: " + getLastName() + "\nBalance: $" + getBalance();
        }

    }

}
