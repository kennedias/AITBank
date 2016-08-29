package com.aitbank.model;

import com.aitbank.exception.IllegalBankAccountOperationException;
import org.joda.time.DateTime;
import com.aitbank.helper.DateTimeHelper;

/**
 * This class represents the Fixed Account.
 * It contains also the related methods to manipulate the account.
 *
 * @author 5399 - Kennedy Oliveira
 */
public class FixedAccount extends BankAccountInterest implements AccountInterestCalc{

    private DateTime dueDateOfInterest;
    private boolean interestAlreadyPayed = false;
   
    /**
     * Print the Fixed Account details.
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
        System.out.println("Interest rate.....: " + interestRate);

        if (interestAlreadyPayed){
            System.out.println("Interest paid.....: Yes");
        } else {
            System.out.println("Interest paid.....: No");
        }

        if (dueDateOfInterest != null){
            System.out.println("Due Date..........: " + dateTimeHelper.getDatetimeToString(dueDateOfInterest));
        } else {
            System.out.println("Due Date..........: No due date");
        }
        
        if (depositDate != null){
            System.out.println("Deposit Date..........: " + dateTimeHelper.getDatetimeToString(depositDate));
        } else {
            System.out.println("Deposit Date..........: No deposit");
        }

        if (withdrawDate != null){
            System.out.println("Withdraw Date.........: " + dateTimeHelper.getDatetimeToString(withdrawDate));
        } else {
            System.out.println("Withdraw Date.........: No withdraw");
        }
        
    }

    /**
     * Calculate the interest amount on the period and update the balance.
     * @throws com.aitbank.exception.IllegalBankAccountOperationException
     */    
    @Override
    public void updateActualBalanceWithInterest() throws IllegalBankAccountOperationException{

        DateTimeHelper dateTimeHelper = new DateTimeHelper();
    
        if (dueDateOfInterest == null){
            throw new IllegalArgumentException("This account do not have a valid due date to pay interest.");
        }

        if(interestAlreadyPayed){
            throw new IllegalArgumentException("This account have already payed interest.");
        }
        
        if (withdrawDate != null){
            if ((dueDateOfInterest.isBefore(dateTimeHelper.getActualDateAndTime())) &&
                (dueDateOfInterest.isBefore(withdrawDate))){
                applyInterestOnBalance();
            }
        } else if((dateTimeHelper.getActualDateAndTime().isAfter(dueDateOfInterest))){
            applyInterestOnBalance();
        } else {
            throw new IllegalArgumentException("The requirements for apply interest on this account have not been achieved.");
        }
    }
    
    /**
     * Update the balance and set interestAlreadyPayed flag to true.
     * For security this is a private method, this attribute have to be updated 
     * only when the interest rule is achieved.
     */ 
    private void applyInterestOnBalance() {
        setBalance(balance * (1 + interestRate));
        interestAlreadyPayed = true;
    }

    /**
     * Get the dueDateOfInterest attribute.
     * @return dueDateOfInterest
     */
    public DateTime getDueDateOfInterest() {
        return dueDateOfInterest;
    }

    /**
     * Set the dueDateOfInterest attribute.
     * @param dueDateOfInterest
     */
    public void setDueDateOfInterest(DateTime dueDateOfInterest) {
        this.dueDateOfInterest = dueDateOfInterest;
    }
}
