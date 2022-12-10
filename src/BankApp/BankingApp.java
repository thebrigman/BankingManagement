/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package BankApp;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * The BankingApp program allows the user to add, remove, and manage money and
 * credit through various accounts.
 *
 * @author Damon Morgan and Elliot Paulsen
 */
public class BankingApp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        AccountHolder user;
        AccountsManager accnts = new AccountsManager();
        ManagementSystem manSys = new ManagementSystem(accnts);
        Scanner scnr = new Scanner(System.in);
        int amount;
        int acctInput;
        int num = 6;

        System.out.println("**BankingApp**");

        //Output a menu showing options to the user.
        //Program will execute various functions based on the usere input.
        while (num > 0) {

            switch (num) {
                case 1:
                    //Output accounts
                    accnts.printAccounts();
                    break;
                case 2:
                    //Deposit funds.
                    manSys.deposit();
                    break;
                case 3:
                    //Withdraw funds.
                    manSys.withdraw();
                    break;
                case 4:
                    //Transfer funds.
                    manSys.transfer();
                    break;
                case 5:
                    //Delete account.
                    accnts.deleteAccount();
                    break;
                case 6:
                    //Add Account.
                    accnts.addAccounts();
                    break;
                case 7:
                    //Borrow funds.
                    manSys.borrow();
                    break;
                case 8:
                    //Pay loan.
                    manSys.LoanPayment();
                    break;
                case 9:
                    //Pay loan.
                    manSys.changeName();
                    break;
            }
            //Output menu and scan for user input.
            System.out.println(
                    "--------------------------------------------------------------------------------------\n"
                    + "**BankingApp** \n"
                    + "MENU OPTIONS: \n"
                    + "1 - See Accounts\n"
                    + "2 - Deposit money\n"
                    + "3 - Withdraw money\n"
                    + "4 - Transfer money into another account\n"
                    + "5 - Delete account\n"
                    + "6 - Add accounts\n"
                    + "7 - Take out a loan\n"
                    + "8 - Make a payment on loan\n"
                    + "9 - Change name on account\n"
                    + "0 - Exit \n"
                    + "");
            num = accnts.isNum();
        }

    }

}
