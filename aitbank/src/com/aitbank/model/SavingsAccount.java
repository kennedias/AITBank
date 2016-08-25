/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aitbank.model;

/**
 *
 * @author 5399
 */
public class SavingsAccount extends BankAccount implements AccountInterestCalc{

    @Override
    public void showBalance() {
        System.out.println("Savings Account balance: " + balance);
    }

    @Override
    public void showAccountDetails() {
        System.out.println("Savings Account Details");
        System.out.println("Branch Number: " + branchNumber);
        System.out.println("AccountNumber: " + accountNumber);
        System.out.println("Customer ID  : " + customerID);
        System.out.println("Balance      : " + balance);
    }

    @Override
    public double calculateAccountInterest() {
        double accountInterest = 0;
        
        return accountInterest;
    }
    
}
