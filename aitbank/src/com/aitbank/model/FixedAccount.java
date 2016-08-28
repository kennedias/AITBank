/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aitbank.model;

import com.aitbank.constants.ConstantsAitBank;
import org.joda.time.DateTime;
import com.aitbank.helper.DateTimeHelper;

/**
 *
 * @author Kennedy
 */
public class FixedAccount extends BankAccountInterest implements AccountInterestCalc{

    private DateTime dueDateOfInterest;
    private boolean interestAlreadyPayed = false;
   
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
    
    @Override
    public void updateActualBalanceWithInterest() {

        DateTimeHelper dateTimeHelper = new DateTimeHelper();

        if(interestAlreadyPayed){
            System.out.println("This account have already payed interest.");
            return;
        }
        
        if (dueDateOfInterest == null){
            System.out.println("This account do not have a valid due date to pay interest.");
            return;
        }
        
        if (withdrawDate != null){
            if ((dueDateOfInterest.isBefore(dateTimeHelper.getActualDateAndTime())) &&
                (dueDateOfInterest.isBefore(withdrawDate))){
                System.out.println("Due Date and time is before of the last withdraw and now");
                this.applyInterestOnBalance();
            }
        } else if((dateTimeHelper.getActualDateAndTime().isAfter(dueDateOfInterest))){
            System.out.println("Date and time of the last withdraw and now is after due date");
            this.applyInterestOnBalance();
        } else {
            System.out.println("The requirements for apply interest on this account have not been achieved.");
        }

    }
    
    private void applyInterestOnBalance(){
        balance = balance * (1 + interestRate);
        interestAlreadyPayed = true;
    }

    public DateTime getDueDateOfInterest() {
        return dueDateOfInterest;
    }

    public void setDueDateOfInterest(DateTime dueDateOfInterest) {
        this.dueDateOfInterest = dueDateOfInterest;
    }
        
    
}
