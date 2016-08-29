package com.aitbank.view;

import com.aitbank.exception.IllegalBankAccountOperationException;
import com.aitbank.helper.DateTimeHelper;
import com.aitbank.model.Customer;
import com.aitbank.model.SavingsAccount;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Simulates the view layer actions performing Savings Account operations.
 * @author 5399 - Kennedy Oliveira
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
      //      savings.setBalance(0.00);
            savings.setDepositDate(dateHelper.generateDateFromString("01/08/2016 22:43"));
            savings.setInterestRate(0.010);
            savings.setDailyWithdrawLimit(200);
            savings.showAccountDetails();
            
            System.out.println("\n======== Deposit and Interest tests ========");
            System.out.println("\nUpdating balance with account interest of the period... ");
            
            savings.updateActualBalanceWithInterest();
            savings.showAccountDetails();
            
            System.out.println("\nMaking a deposit and updating with account interest of the period... ");
            try {
                savings.makeAccountDeposit(100.0);
            } catch (IllegalBankAccountOperationException ex) {
                System.out.println(ex.getMessage());
            }
            savings.updateActualBalanceWithInterest();
            savings.showAccountDetails();
            
            System.out.println("\n===== Withdraw tests =======");
            System.out.println("\nMaking a account withdraw of 1000.00 ");
            try {
                savings.makeAccountWithdraw(1000);
            } catch (IllegalBankAccountOperationException ex) {
                System.out.println(ex.getMessage());
            }
            savings.showAccountDetails();
            
            System.out.println("\nMaking a account withdraw of 80.00 ");
            try {
                savings.makeAccountWithdraw(80);
            } catch (IllegalBankAccountOperationException ex) {
                System.out.println(ex.getMessage());
            }
            savings.showAccountDetails();
            
            System.out.println("\nMaking a account withdraw of 60.00 ");
            try {
                savings.makeAccountWithdraw(60);
            } catch (IllegalBankAccountOperationException ex) {
                System.out.println(ex.getMessage());
            }
            savings.showAccountDetails();
            
            System.out.println("\nMaking a account withdraw of 150.00 ");
            try {
                savings.makeAccountWithdraw(150);
            } catch (IllegalBankAccountOperationException ex) {
                System.out.println(ex.getMessage());
            }
            savings.showAccountDetails();
        } catch (ParseException ex) {
            Logger.getLogger(SavingsAccountView.class.getName()).log(Level.SEVERE, null, ex);
        } 
            

    }
    
}
