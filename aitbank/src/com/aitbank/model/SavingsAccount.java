/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aitbank.model;

import com.aitbank.helper.DateTimeHelper;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.joda.time.DateTime;

/**
 *
 * @author 5399
 */
public class SavingsAccount extends BankAccount implements AccountInterestCalc{

    private double interestRate;
    private double accountInterestAmount;
    
    @Override
    public void showAccountDetails() {
        System.out.println("Savings Account Details");
        System.out.println("Branch Number           : " + branchNumber);
        System.out.println("AccountNumber           : " + accountNumber);
        System.out.println("Balance                 : " + balance);
        System.out.println("Deposit Date            : " + depositDate);
        System.out.println("Account Interest Amount : " + accountInterestAmount);
    }

    @Override
    public double calculateAccountInterest() {
        
        DateTimeHelper dateTimeHelper = new DateTimeHelper();
        
        try {
            DateTime currentTime = dateTimeHelper.generateDateFromString("27/08/2016 24:00");
            int daysOfDeposit = dateTimeHelper.calculateDaysBetweenDates(depositDate, currentTime);
            accountInterestAmount = balance * Math.pow(1 + interestRate, daysOfDeposit);

        } catch (ParseException ex) {
            Logger.getLogger(SavingsAccount.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return accountInterestAmount;
    }

    public double getInterestRate() {
        return interestRate;
    }

    @Override
    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    public double getAccountInterestAmount() {
        return accountInterestAmount;
    }

    public void setAccountInterestAmount(double accountInterestAmount) {
        this.accountInterestAmount = accountInterestAmount;
    }
    
    
}
