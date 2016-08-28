/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aitbank.view;

import com.aitbank.helper.DateTimeHelper;
import com.aitbank.model.Customer;
import com.aitbank.model.SavingsAccount;

/**
 *
 * @author Kennedy
 */
public class SavingsAccountView {
    
    public void SavingsAccountView(Customer customer) {
        try {
            DateTimeHelper dateHelper = new DateTimeHelper();
            System.out.println("\n==========================================");
            System.out.println("Creating Savings Account... ");

            SavingsAccount savings = new SavingsAccount();
            
            savings.setCustomer(customer);
            savings.setAccountNumber(123);
            savings.setBranchNumber(99);
            savings.setBalance(100.00);
            savings.setDepositDate(dateHelper.generateDateFromString("01/08/2016 22:43"));
            savings.setInterestRate(0.010);
            savings.setDailyWithdrawLimit(2);
            savings.showAccountDetails();

            System.out.println("\n Deposit and Interest tests");
            System.out.println("\nUpdating balance with account interest of the period... ");

            savings.updateActualBalanceWithInterest();
            savings.showAccountDetails();

            System.out.println("\nMaking a deposit and updating with account interest of the period... ");
            savings.makeAccountDeposit(100.0);
            savings.updateActualBalanceWithInterest();
            savings.showAccountDetails();
            
            System.out.println("\n Withdraw tests");
            System.out.println("\nMaking a account withdraw of 1000.00 ");
            savings.makeAccountWithdraw(1000);
            savings.showAccountDetails();

            System.out.println("\nMaking a account withdraw of 80.00 ");            
            savings.makeAccountWithdraw(80);
            savings.showAccountDetails();

            System.out.println("\nMaking a account withdraw of 60.00 ");            
            savings.makeAccountWithdraw(60);
            savings.showAccountDetails();
            
            System.out.println("\nMaking a account withdraw of 50.00 ");            
            savings.makeAccountWithdraw(50);
            savings.showAccountDetails();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
