/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aitbank.view;

import com.aitbank.helper.DateTimeHelper;
import com.aitbank.model.Customer;
import com.aitbank.model.FixedAccount;

/**
 *
 * @author Kennedy
 */
public class FixedAccountView {
    
    public void FixedAccountView(Customer customer){

        try {
            DateTimeHelper dateHelper = new DateTimeHelper();
            
            System.out.println("\n==========================================");
            System.out.println("Creating Fixed Account... ");
            
            FixedAccount fixedAccount = new FixedAccount();
            
            fixedAccount.setCustomer(customer);
            fixedAccount.setAccountNumber(123);
            fixedAccount.setBranchNumber(99);
            fixedAccount.setBalance(100.00);
            fixedAccount.setDepositDate(dateHelper.generateDateFromString("27/06/2016 00:00"));
            fixedAccount.setInterestRate(0.10);
            fixedAccount.setDueDateOfInterest(dateHelper.generateDateFromString("26/08/2016 23:59"));
//            fixedAccount.setWithdrawDate(dateHelper.generateDateFromString("30/08/2016 23:59"));
            fixedAccount.showAccountDetails();
            
            System.out.println("\nUpdating balance with account interest of the period... ");

            fixedAccount.updateActualBalanceWithInterest();
            fixedAccount.showAccountDetails();

            System.out.println("\nTrying to apply interest in a already interest updated account... ");
            fixedAccount.updateActualBalanceWithInterest();

            fixedAccount.showAccountDetails();

        } catch (Exception e) {
            e.printStackTrace();
        }
     
    }
    
}
