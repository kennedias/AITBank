package com.aitbank.model;

import com.aitbank.exception.IllegalBankAccountOperationException;
import com.aitbank.helper.DateTimeHelper;
import org.joda.time.DateTime;

/**
 * This class represents the Super Class Bank Account.
 * It contains also the related methods to manipulate the account.
 *
 * @author 5399 - Kennedy Oliveira
 */
public abstract class BankAccount {

    protected int branchNumber;
    protected int accountNumber;
    protected Customer customer;
    protected double balance;
    protected DateTime depositDate;
    protected DateTime withdrawDate;

    /**
     * Print the Bank Account details.
     */    
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

    /**
     * Print the Bank Account balance.
     */
    public void showBalance() {
        System.out.println("Account balance...: " + balance);
    }    
    
    /**
     * Make a account withdraw.
     * @param withdrawAmount
     * @throws IllegalBankAccountOperationException
     */
    public void makeAccountWithdraw(double withdrawAmount) throws IllegalBankAccountOperationException {
        if (withdrawAmount <= 0) {
            throw new IllegalArgumentException("Invalid withdraw amount.");
        } else if (withdrawAmount > balance) {
            throw new IllegalArgumentException("Insufficient funds.");
        } else {
            setBalance(balance - withdrawAmount);
            setWithdrawDate(new DateTime());
        }
    }

    /**
     * Make a account deposit.
     * @param depositAmount
     * @throws IllegalBankAccountOperationException
     */
    public void makeAccountDeposit(double depositAmount) throws IllegalBankAccountOperationException {
        if (depositAmount <= 0) {
            throw new IllegalArgumentException("Invalid deposit amount.");
        } else {
            setBalance(balance + depositAmount);
            setDepositDate(new DateTime());
        }
    }

    /**
     * Get the branchNumber attribute.
     * @return branchNumber
     */
    public int getBranchNumber() {
        return branchNumber;
    }

    /**
     * Set the branchNumber attribute.
     * @param branchNumber
     */
    public void setBranchNumber(int branchNumber) {
        this.branchNumber = branchNumber;
    }

    /**
     * Get the accountNumber attribute.
     * @return accountNumber
     */    
    public int getAccountNumber() {
        return accountNumber;
    }
    
    /**
     * Set the accountNumber attribute.
     * @param accountNumber
     */
    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    /**
     * Get the customer attribute.
     * @return Customer
     */ 
    public Customer getCustomer() {
        return customer;
    }

    /**
     * Set the customer attribute.
     * @param customer
     */
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    /**
     * Get the balance attribute.
     * @return balance
     */
    public double getBalance() {
        return balance;
    }

    /**
     * Set the balance attribute.
     * @param balance
     */ 
    public void setBalance(double balance) {
        this.balance = balance;
    }
    
    /**
     * Get the depositDate attribute.
     * @return depositDate
     */
    public DateTime getDepositDate() {
        return depositDate;
    }

    /**
     * Set the depositDate attribute.
     * @param depositDate
     */     
    public void setDepositDate(DateTime depositDate) {
        this.depositDate = depositDate;
    }

    /**
     * Get the withdrawDate attribute.
     * @return withdrawDate
     */
    public DateTime getWithdrawDate() {
        return withdrawDate;
    }

    /**
     * Set the withdrawDate attribute.
     * @param withdrawDate
     */ 
    public void setWithdrawDate(DateTime withdrawDate) {
        this.withdrawDate = withdrawDate;
    }

}
