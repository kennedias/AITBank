package com.aitbank.model;

import com.aitbank.exception.IllegalBankAccountOperationException;
import com.aitbank.helper.DateTimeHelper;
import org.joda.time.DateTime;

/**
 * This class represents the Saving Account.
 * It contains also the related methods to manipulate the account.
 *
 * @author 5399 - Kennedy Oliveira
 */
public class SavingsAccount extends BankAccountInterest implements AccountInterestCalc {

    private double dailyWithdrawLimit;
    private double dailyWithdrawAmountRealized;
    
    /**
     * Print the Savings Account details .
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
        System.out.println("Interest Rate.....: " + interestRate);
        if (depositDate != null){
            System.out.println("Deposit Date......: " 
                    + dateTimeHelper.getDatetimeToString(depositDate));
        } else {
            System.out.println("Deposit Date......: No deposit");
        }

        if (withdrawDate != null){
            System.out.println("Withdraw Date.....: " 
                    + dateTimeHelper.getDatetimeToString(withdrawDate));
        } else {
            System.out.println("Withdraw Date.....: No withdraw");
        }
        System.out.println("Daily Withdraw Limit...........  : " 
                + dailyWithdrawLimit);
        System.out.println("Daily Withdraw Limit Realised....: " 
                + dailyWithdrawAmountRealized);
    }

    /**
     * Calculate the interest amount on the period and update the balance.
     * @throws com.aitbank.exception.IllegalBankAccountOperationException
     */
    @Override
    public void updateActualBalanceWithInterest() 
            throws IllegalBankAccountOperationException {

        DateTimeHelper dateTimeHelper = new DateTimeHelper();

        if (balance <= 0){
            throw new IllegalBankAccountOperationException("This account do not have a valid "
                    + "balance date to calculate and pay interest.");
        }
        
        if (depositDate == null){
            throw new IllegalBankAccountOperationException("This account do not have a valid "
                    + "deposit date to calculate and pay interest.");
        }
        
        // If the account do not have an positive and greater than zero
        // interest value it is not to calculate and pay interest.
        if (interestRate > 0){
            double daysOfDeposit = dateTimeHelper.calculateDaysBetweenDates(depositDate, 
                    dateTimeHelper.getActualDateAndTime());
            setBalance(balance * (Math.pow(1 + interestRate, daysOfDeposit)));
        } else {
            throw new IllegalBankAccountOperationException("The interest rate for this account"
                    + " is not valid do calculate and pay interest.");
        }
    }

    /**
     * Make a account withdraw.
     * @param withdrawAmount the withdraw amount
     * @throws com.aitbank.exception.IllegalBankAccountOperationException
     */
    @Override
    public void makeAccountWithdraw(double withdrawAmount) 
            throws IllegalBankAccountOperationException {
              
        if (withdrawAmountLimitVerify(withdrawAmount)){
            setBalance(balance - withdrawAmount);
            setWithdrawDate(new DateTime());
            setDailyWithdrawAmountRealized(dailyWithdrawAmountRealized + withdrawAmount);
            System.out.println("Withdraw realised with success");
        }
    }
    
    /**
     * Verify if its possible to perform a withdraw based on the withdraw 
     * account rules.
     * @param withdrawAmount the withdraw amount
     * @return boolean says if the withdraw can be performed
     * @throws com.aitbank.exception.IllegalBankAccountOperationException
     */
    public boolean withdrawAmountLimitVerify(double withdrawAmount) 
            throws IllegalBankAccountOperationException{

        DateTimeHelper dateTimeHelper = new DateTimeHelper();
        
        if (withdrawAmount <= 0) {
            throw new IllegalBankAccountOperationException("Withdraw amount invalid.");
        } else if (withdrawAmount > dailyWithdrawLimit){
            throw new IllegalBankAccountOperationException("Withdraw exceeds "
                    + "the daily withdraw limit.");
        } else if (withdrawDate != null && 
                dateTimeHelper.verifyIfDateTimeIsToday(withdrawDate)){
            if ((dailyWithdrawAmountRealized + withdrawAmount) > dailyWithdrawLimit) {
                throw new IllegalBankAccountOperationException("Withdraw exceeds"
                        + " the daily withdraw limit.");
            }
        } 
        if (withdrawAmount > balance) {
            throw new IllegalBankAccountOperationException("Insufficient funds.");
        }
       
        return true;

    }

    /**
     * Get the dailyWithdrawLimit attribute.
     * @return dailyWithdrawLimit the withdraw amount limit
     */
    public double getDailyWithdrawLimit() {
        return dailyWithdrawLimit;
    }

    /**
     * Set the dailyWithdrawLimit attribute.
     * @param dailyWithdrawLimit the withdraw amount limit
     */
    public void setDailyWithdrawLimit(double dailyWithdrawLimit) {
        this.dailyWithdrawLimit = dailyWithdrawLimit;
    }

    /**
     * Get the dailyWithdrawAmountRealized attribute.
     * @return dailyWithdrawLimit the withdraw amount realized
     */
    public double getDailyWithdrawAmountRealized() {
        return dailyWithdrawAmountRealized;
    }

    /**
     * Set the dailyWithdrawAmountRealized attribute.
     * For security this is a private method, this attribute have to be updated 
     * only when a withdraw is realized.
     * @param dailyWithdrawAmountRealized the withdraw amount realized
     */
    private void setDailyWithdrawAmountRealized(double dailyWithdrawAmountRealized) {
        this.dailyWithdrawAmountRealized = dailyWithdrawAmountRealized;
    }

}
