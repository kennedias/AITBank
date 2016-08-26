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
    
    @Override
    public void showAccountDetails() {
        System.out.println("Savings Account Details");
        System.out.println("Branch Number....................: " + branchNumber);
        System.out.println("AccountNumber....................: " + accountNumber);
        System.out.println("Balance..........................: " + balance);
        System.out.println("Deposit Date.....................: " + depositDate);
    }

    @Override
    public void updateActualBalanceWithInterest() {
        
        DateTimeHelper dateTimeHelper = new DateTimeHelper();

      //  DateTime currentTime = dateTimeHelper.generateDateFromString(new DateTime());
        int daysOfDeposit = dateTimeHelper.calculateDaysBetweenDates(depositDate, new DateTime());
        balance = balance * (Math.pow(1 + interestRate,(double) daysOfDeposit));
     
    }

    public double getInterestRate() {
        return interestRate;
    }

    @Override
    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }
    
}
