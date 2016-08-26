/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aitbank.model;

import org.joda.time.DateTime;

/**
 *
 * @author 5399
 */
public abstract class BankAccount {
    protected int branchNumber;
    protected int accountNumber;
    protected Customer customer;
    protected double balance;
    protected DateTime depositDate;
    protected DateTime withdrawDate;

  
    public void showBalance() {
        System.out.println("Account balance...: " + balance);
    }

    public void showAccountDetails() {
        System.out.println("Savings Account Details");
        System.out.println("Branch Number.....: " + branchNumber);
        System.out.println("AccountNumber.....: " + accountNumber);
        System.out.println("Customer ID.......: " + customer.getCustomerID());
        System.out.println("Customer Name.....: " + customer.getName());
        System.out.println("Balance...........: " + balance);
        System.out.println("Deposit Date......: " + depositDate);
        System.out.println("WithdrawDate......: " + withdrawDate);

    } 
    
    public void makeAccountWithdraw(double withdrawAmount)
    {
        if (withdrawAmount <= 0)
        {
            //TODO error - invalid withdraw value
        }
        else if (withdrawAmount > balance)
        {
            //TODO error - insufficient funds
        } 
        else
        {
            setBalance(balance - withdrawAmount); 
            showBalance();
        }
    
    }

        public void makeAccountDeposit(double depositAmount)
    {
        if (depositAmount <= 0)
        {
            //TODO error - invalid withdraw value
        }
         else
        {
            setBalance(balance + depositAmount); 
            setDepositDate(new DateTime());
            showBalance();
        }
    
    }

    
    
    public int getBranchNumber() {
        return branchNumber;
    }

    public void setBranchNumber(int branchNumber) {
        this.branchNumber = branchNumber;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public DateTime getDepositDate() {
        return depositDate;
    }

    public void setDepositDate(DateTime depositDate) {
        this.depositDate = depositDate;
    }

    public DateTime getWithdrawDate() {
        return withdrawDate;
    }

    public void setWithdrawDate(DateTime withdrawDate) {
        this.withdrawDate = withdrawDate;
    }
    
    
    
}
