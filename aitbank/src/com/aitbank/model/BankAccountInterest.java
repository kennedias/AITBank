package com.aitbank.model;

import com.aitbank.helper.DateTimeHelper;

/**
 * This class represents the Super Class Bank Account Interest.
 * It contains also the related methods to manipulate the account for accounts
 * that pay interest. This class extends Bank Account.
 *
 * @author 5399 - Kennedy Oliveira
 */
public abstract class BankAccountInterest extends BankAccount {
    
    protected double interestRate;
    
    /**
     * Print the Bank Account Interest details.
     */ 
    @Override
    public void showAccountDetails() {
        DateTimeHelper dateTimeHelper = new DateTimeHelper();
        System.out.println("\nAccount Details"); 
        System.out.println("Branch Number.....: " + branchNumber);
        System.out.println("AccountNumber.....: " + accountNumber);
        System.out.println("Customer ID.......: " + customer.getCustomerID());
        System.out.println("Customer Name.....: " + customer.getName());
        System.out.println("Balance...........: " + balance);
        System.out.println("Interest Rate.....: " + interestRate); // print the attribute from this class
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
     * Get the interestRate attribute.
     * @return interestRate
     */
    public double getInterestRate() {
        return interestRate;
    }

    /**
     * Set the interestRate attribute.
     * @param interestRate
     */
    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

}
