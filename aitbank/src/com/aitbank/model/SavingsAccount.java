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
public class SavingsAccount extends BankAccountInterest implements AccountInterestCalc {

    private int dailyWithdrawLimit;
    private int dailyWithdrawLimitRealised;
    
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
            System.out.println("Deposit Date......: " + dateTimeHelper.getDatetimeToString(depositDate));
        } else {
            System.out.println("Deposit Date......: No deposit");
        }

        if (withdrawDate != null){
            System.out.println("Withdraw Date.....: " + dateTimeHelper.getDatetimeToString(withdrawDate));
        } else {
            System.out.println("Withdraw Date.....: No withdraw");
        }
        System.out.println("Daily Withdraw Limit...........  : " + dailyWithdrawLimit);
        System.out.println("Daily Withdraw Limit Realised....: " + dailyWithdrawLimitRealised);
    }

    
    @Override
    public void updateActualBalanceWithInterest() {

        DateTimeHelper dateTimeHelper = new DateTimeHelper();

        double daysOfDeposit = dateTimeHelper.calculateDaysBetweenDates(depositDate, dateTimeHelper.getActualDateAndTime());
        balance = balance * (Math.pow(1 + interestRate, daysOfDeposit));

    }

    @Override
    public void makeAccountWithdraw(double withdrawAmount) {
        DateTimeHelper dateTimeHelper = new DateTimeHelper();
      
        if (withdrawAmount <= 0) {
            //TODO error - invalid withdraw value
        } else if (withdrawDate != null && 
                dateTimeHelper.verifyDatetimeIsToday(withdrawDate)){
            if (dailyWithdrawLimitRealised < dailyWithdrawLimit) {
                if (withdrawAmount > balance) {
                    //TODO error - insufficient funds
                    System.out.println("This transaction can not be completed. Insufficient funds.");
                } else {
                    setBalance(balance - withdrawAmount);
                    setWithdrawDate(new DateTime());
                    dailyWithdrawLimitRealised++;
                    System.out.println("Withdraw realised with success");
                } 
            } else {
                System.out.println("This transaction can not be completed. Daily withdraws limit achieved.");
            }  
        } else if (withdrawAmount > balance) {
            //TODO error - insufficient funds
            System.out.println("This transaction can not be completed. Insufficient funds.");
        } else {
            setBalance(balance - withdrawAmount);
            setWithdrawDate(new DateTime());
            dailyWithdrawLimitRealised = 1;
            System.out.println("Withdraw realised with success");
        }
    }
    
    public boolean dailyWithdrawLimitAchieved(){
        
    //    if (depositDate)
        
        return false;
    }

    public int getDailyWithdrawLimit() {
        return dailyWithdrawLimit;
    }

    public void setDailyWithdrawLimit(int dailyWithdrawLimit) {
        this.dailyWithdrawLimit = dailyWithdrawLimit;
    }

    
    
}
