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
public abstract class BankAccount {
    protected int branchNumber;
    protected int accountNumber;
    protected int customerID;
    protected double balance;
    protected int withdrawalLimit;

  
    public void showBalance() {
        System.out.println("Account balance...: " + balance);
    }

    public void showAccountDetails() {
        System.out.println("Savings Account Details");
        System.out.println("Branch Number.....: " + branchNumber);
        System.out.println("AccountNumber.....: " + accountNumber);
        System.out.println("Customer ID.......: " + customerID);
        System.out.println("Balance...........: " + balance);
        System.out.println("Withdrawal Limit..: " + withdrawalLimit);
    } 
    
    
    
}
