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
 * @author Kennedy
 */
public class NetSaverAccount extends BankAccountInterest implements AccountInterestCalc {

    @Override
    public void updateActualBalanceWithInterest() {
        DateTimeHelper dateTimeHelper = new DateTimeHelper();
        
        double monthsOfDeposit = dateTimeHelper.calculateMonthsBetweenDates(depositDate, new DateTime());
        balance = balance * (Math.pow(1+interestRate, (double) monthsOfDeposit));
    }

}
