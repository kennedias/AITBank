package com.aitbank.view;

import com.aitbank.exception.IllegalATMMachineOperationException;
import com.aitbank.exception.IllegalBankAccountOperationException;
import com.aitbank.helper.DateTimeHelper;
import com.aitbank.model.ATMMachine;
import com.aitbank.model.Customer;
import com.aitbank.model.SavingsAccount;
import java.text.ParseException;

/**
 * Simulates the view layer actions performing Savings Account operations.
 * @author 5399 - Kennedy Oliveira
 */
public class SavingsAccountView {
    
    public void SavingsAccountView(Customer customer) {

        try {
            DateTimeHelper dateHelper = new DateTimeHelper();
            ATMMachine atmMachine = new ATMMachine();
            
            System.out.println("\n==========================================");
            System.out.println("Creating Savings Account... ");
            
            SavingsAccount savings = new SavingsAccount();
            
            savings.setCustomer(customer);
            savings.setAccountNumber(123);
            savings.setBranchNumber(99);
            savings.setBalance(50);
            savings.setDepositDate(dateHelper.generateDateFromString("01/08/2016 22:43"));
            savings.setInterestRate(0.001);
            savings.setDailyWithdrawLimit(200);
            savings.showAccountDetails();
            
            System.out.println("\n======== Deposit and Interest tests ========");
            System.out.println("\nUpdating balance with account interest of the "
                    + "period since the deposit date: 01/08/2016");
            try {
                savings.updateActualBalanceWithInterest();
            } catch (IllegalBankAccountOperationException ex) {
                System.out.println(ex.getMessage());
            }
            savings.showAccountDetails();
            
            
            System.out.println("\nMaking a deposit of $100 that is a valid amount"
                    + " and updating balance with account since the deposit "
                    + "date: Today. "
                    + "\nNo update of interest have to be done as it is the same day.");
            try {
                savings.makeAccountDeposit(100.0);
                savings.updateActualBalanceWithInterest();
            } catch (IllegalBankAccountOperationException ex) {
                System.out.println(ex.getMessage());
            }
            savings.showAccountDetails();


            System.out.println("\nMaking a deposit of $0 that is a invalid amount.");
            try {
                savings.makeAccountDeposit(0.0);
            } catch (IllegalBankAccountOperationException ex) {
                System.out.println(ex.getMessage());
            }
            savings.showAccountDetails();
            
            
            System.out.println("\n===== Withdraw tests =======");
            System.out.println("\nMaking a withdraw of $190 that is a valid "
                    + "amount, not enough balance, not exceed the daiyly amount "
                    + "\nwithdraw and has a correct combination of notes. ");
            atmMachine.ATMMachine();
            try {
                atmMachine.executeWithdraw(190);
                savings.makeAccountWithdraw(190);
            } catch (IllegalATMMachineOperationException | IllegalBankAccountOperationException ex) {
                System.out.println(ex.getMessage());
            }
            savings.showAccountDetails();

            
            System.out.println("\nMaking a deposit of $500 that is a valid amount.");
            try {
                savings.makeAccountDeposit(500.0);
            } catch (IllegalBankAccountOperationException ex) {
                System.out.println(ex.getMessage());
            }
            savings.showAccountDetails();
            
            
            System.out.println("\nMaking a withdraw of $80 that is a valid "
                    + "amount, enough balance, not exceed the daiyly amount "
                    + "\nwithdraw and has a correct combination of notes. ");
            atmMachine.ATMMachine();
            try {
                atmMachine.executeWithdraw(80);
                savings.makeAccountWithdraw(80);
            } catch (IllegalATMMachineOperationException | IllegalBankAccountOperationException ex) {
                System.out.println(ex.getMessage());
            }
            savings.showAccountDetails();
            
            
            System.out.println("\nMaking a withdraw of $60 that is a valid "
                    + "amount, enough balance, not exceed the daiyly amount "
                    + "\nwithdraw and has a correct combination of notes. ");
            atmMachine.ATMMachine();
            try {
                atmMachine.executeWithdraw(60);
                savings.makeAccountWithdraw(60);
            } catch (IllegalATMMachineOperationException | IllegalBankAccountOperationException ex) {
                System.out.println(ex.getMessage());
            }
            savings.showAccountDetails();
            
            
            System.out.println("\nMaking a withdraw of $150 that is a valid "
                    + "amount, enough balance, exceed the daiyly amount "
                    + "\nwithdraw and has a correct combination of notes. ");
            atmMachine.ATMMachine();
            try {
                atmMachine.executeWithdraw(150);
                savings.makeAccountWithdraw(150);
            } catch (IllegalATMMachineOperationException | IllegalBankAccountOperationException ex) {
                System.out.println(ex.getMessage());
            }
            savings.showAccountDetails();
            
            
            System.out.println("\nMaking a withdraw of $45 that is a valid "
                    + "amount, enough balance, not exceed the daiyly amount "
                    + "\nwithdraw and has a incorrect combination of notes. ");
            atmMachine.ATMMachine();
            try {
                atmMachine.executeWithdraw(45);
                savings.makeAccountWithdraw(45);
            } catch (IllegalATMMachineOperationException | IllegalBankAccountOperationException ex) {
                System.out.println(ex.getMessage());
            }
            savings.showAccountDetails();
            
        } catch (ParseException ex) {
            System.out.println(ex.getMessage());
        } 
     }
}
