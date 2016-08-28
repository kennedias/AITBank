/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aitbank.model;

import com.aitbank.helper.DateTimeHelper;
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
        DateTimeHelper dateTimeHelper = new DateTimeHelper();
        
        System.out.println("\nAccount Details"); 
        System.out.println("Branch Number.....: " + branchNumber);
        System.out.println("AccountNumber.....: " + accountNumber);
        System.out.println("Customer ID.......: " + customer.getCustomerID());
        System.out.println("Customer Name.....: " + customer.getName());
        System.out.println("Balance...........: " + balance);
        if (depositDate != null){
            System.out.println("Deposit Date......: " + dateTimeHelper.getDatetimeToString(depositDate));
        } else {
            System.out.println("Deposit Date......: No deposit");
        }

        if (withdrawDate != null){
            System.out.println("Withdraw Date.....: " + dateTimeHelper.getDatetimeToString(withdrawDate));
        } else {
            System.out.println("Withdraw Date.....: No withdraw");
        }
    }

    public void makeAccountWithdraw(double withdrawAmount) {
        if (withdrawAmount <= 0) {
            System.out.println("This transaction can not be completed. Withdraw amount invalid.");
        } else if (withdrawAmount > balance) {
            //TODO error - insufficient funds
            System.out.println("This transaction can not be completed. Insufficient funds.");
        } else {
            setBalance(balance - withdrawAmount);
            setWithdrawDate(new DateTime());
            
        }

    }

    public void makeAccountDeposit(double depositAmount) {
        if (depositAmount <= 0) {
            //TODO error - invalid withdraw value
            System.out.println("This transaction can not be completed. Deposit amount invalid.");
        } else {
            setBalance(balance + depositAmount);
            setDepositDate(new DateTime());
            
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
