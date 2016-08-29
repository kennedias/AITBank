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
    private double fixedAmount;
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
        System.out.println("Fixed Amount......: " + fixedAmount);
        System.out.println("Interest rate.....: " + interestRate);

        if (interestAlreadyPayed){ // print the attribute from this class
            System.out.println("Interest paid.....: Yes");
        } else {
            System.out.println("Interest paid.....: No");
        }

        if (dueDateOfInterest != null){ // print the attribute from this class
            System.out.println("Due Date..........: " 
                    + dateTimeHelper.getDatetimeToString(dueDateOfInterest));
        } else {
            System.out.println("Due Date..........: No due date");
        }
        
        if (depositDate != null){ 
            System.out.println("Deposit Date..........: " 
                    + dateTimeHelper.getDatetimeToString(depositDate));
        } else {
            System.out.println("Deposit Date..........: No deposit");
        }

        if (withdrawDate != null){
            System.out.println("Withdraw Date.........: " 
                    + dateTimeHelper.getDatetimeToString(withdrawDate));
        } else {
            System.out.println("Withdraw Date.........: No withdraw");
        }
        
    }

    /**
     * Calculate the interest amount on the period and update the balance.
     * Fixed account pays interest based on contract period.
     * @throws com.aitbank.exception.IllegalBankAccountOperationException
     */    
    @Override
    public void updateActualBalanceWithInterest() throws IllegalBankAccountOperationException{

        DateTimeHelper dateTimeHelper = new DateTimeHelper();

        if (fixedAmount <= 0){
            throw new IllegalBankAccountOperationException("This account do not have a valid "
                    + "fixed amount to calculate and pay interest.");
        }
        
        if (interestRate <= 0){
            throw new IllegalBankAccountOperationException("The interest rate for this account"
                    + " is not valid to calculate and pay interest.");
        }
        
        if (dueDateOfInterest == null){
            throw new IllegalBankAccountOperationException("This account do not have a valid "
                    + "due date to calculate and pay interest.");
        }
        
        // If the account have already payed the interest it can not pay again.
        if(interestAlreadyPayed){ 
            throw new IllegalBankAccountOperationException("This account have already payed interest.");
        }

        // Verify if the account have any withdraw done.
        // If the withdraw was done before of the based data, the account do not
        // pay interest.      
        if (withdrawDate != null){
            //This block uses the "isBefore" function to show how it works.
            if ((dueDateOfInterest.isBefore(dateTimeHelper.getActualDateAndTime())) && 
                (dueDateOfInterest.isBefore(withdrawDate))){
                applyInterestOnBalance();
            } else {
                throw new IllegalBankAccountOperationException("The requirements for apply "
                    + "interest on this account have not been achieved.");
            }
                   //And this one uses the "isAfter" function to show how it works.
        } else if((dateTimeHelper.getActualDateAndTime().isAfter(dueDateOfInterest))){
            applyInterestOnBalance();
        } 
    }
    
    /**
     * Update the balance and set interestAlreadyPayed flag to true.
     * For security this is a private method, this attribute have to be updated 
     * only when the interest rule is achieved.
     */ 
    private void applyInterestOnBalance() {
        /** 
         * The calc is based in a fixed value of the initial deposit.
         * If a withdraw is done after the due date and before the system
         * update the account interest, the value considered for the calc
         * would be the correct one: the total amount contracted, before
         * any pos due date withdraw.
         * */
        double amountInterest = fixedAmount * interestRate;
        setBalance(balance + amountInterest);
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

    /**
     * Get the fixedAmount attribute.
     * @return fixedAmount
     */
    public double getFixedAmount() {
        return fixedAmount;
    }

    /**
     * Set the fixedAmount attribute.
     * @param fixedAmount
     */
    public void setFixedAmount(double fixedAmount) {
        this.fixedAmount = fixedAmount;
    }
    
    
    
}
