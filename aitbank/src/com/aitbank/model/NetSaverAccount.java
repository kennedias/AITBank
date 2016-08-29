package com.aitbank.model;

import com.aitbank.helper.DateTimeHelper;
import org.joda.time.DateTime;

/**
 * This class represents the Net-Saver Account.
 * It contains also the related methods to manipulate the account.
 *
 * @author 5399 - Kennedy Oliveira
 */
public class NetSaverAccount extends BankAccountInterest implements AccountInterestCalc {

    /**
     * Calculate the interest amount on the period and update the balance.
     */
    @Override
    public void updateActualBalanceWithInterest() {
        DateTimeHelper dateTimeHelper = new DateTimeHelper();
        
        double monthsOfDeposit = dateTimeHelper.calculateMonthsBetweenDates(depositDate, new DateTime());
        setBalance(balance * (Math.pow(1+interestRate, (double) monthsOfDeposit)));
    }

}
