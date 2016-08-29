package com.aitbank.model;

import com.aitbank.exception.IllegalBankAccountOperationException;
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
     * Fixed account pays monthly interest.
     * @throws com.aitbank.exception.IllegalBankAccountOperationException
     */
    @Override
    public void updateActualBalanceWithInterest() 
            throws IllegalBankAccountOperationException{
        DateTimeHelper dateTimeHelper = new DateTimeHelper();
        
        if (balance <= 0){
            throw new IllegalArgumentException("This account do not have a valid "
                    + "balance date to calculate and pay interest.");
        }
        
        if (depositDate == null){
            throw new IllegalArgumentException("This account do not have a valid "
                    + "deposit date to calculate and pay interest.");
        }
        
        // If the account do not have an positive and greater than zero
        // interest value it is not to calculate and pay interest.
        if (interestRate > 0){
            double monthsOfDeposit =
                    dateTimeHelper.calculateMonthsBetweenDates(depositDate, new DateTime());
            setBalance(balance * (Math.pow(1+interestRate, (double) monthsOfDeposit)));
            
        } else {
            throw new IllegalArgumentException("The interest rate for this account"
                    + " is not valid do calculate and pay interest.");
        }
    }
}
