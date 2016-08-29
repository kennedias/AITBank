package com.aitbank.view;

import com.aitbank.exception.IllegalATMMachineOperationException;
import com.aitbank.exception.IllegalBankAccountOperationException;
import com.aitbank.helper.DateTimeHelper;
import com.aitbank.model.ATMMachine;
import com.aitbank.model.Customer;
import com.aitbank.model.NetSaverAccount;
import java.text.ParseException;

/**
 * Simulates the view layer actions performing Net-Saver Account operations.
 * @author 5399 - Kennedy Oliveira
 */
public class NetSaverAccountView {
   
    public void NetSaverAccountView(Customer customer){

        try {
            DateTimeHelper dateHelper = new DateTimeHelper();
            ATMMachine atmMachine = new ATMMachine();
            
            System.out.println("\n==========================================");
            System.out.println("Creating Net-Saver Account... ");
            NetSaverAccount netSaverAccount = new NetSaverAccount();
            
            netSaverAccount.setCustomer(customer);
            netSaverAccount.setAccountNumber(123);
            netSaverAccount.setBranchNumber(99);
            netSaverAccount.setBalance(50);
            netSaverAccount.setDepositDate(dateHelper.generateDateFromString("20/07/2016 22:43"));

            /**
             * Net-Server account higher interest than Savings Account.
             * However I am assuming that each account have their interest
             * rate setted in the proper account.
             */
            netSaverAccount.setInterestRate(0.25);
            netSaverAccount.showAccountDetails();
            
            System.out.println("\n======== Deposit and Interest tests ========");
            System.out.println("\nUpdating balance with account interest of the "
                    + "period since the deposit date: 20/07/2016");
            try {
                netSaverAccount.updateActualBalanceWithInterest();
            } catch (IllegalBankAccountOperationException ex) {
                System.out.println(ex.getMessage());
            }
            netSaverAccount.showAccountDetails();
            
            
            System.out.println("\nMaking a deposit of $100 that is a valid amount"
                    + " and updating balance with account since the deposit "
                    + "date: Today. "
                    + "\nNo update of interest have to be done as it is the same period.");
            try {
                netSaverAccount.makeAccountDeposit(100.0);
                netSaverAccount.updateActualBalanceWithInterest();
            } catch (IllegalBankAccountOperationException ex) {
                System.out.println(ex.getMessage());
            }
            netSaverAccount.showAccountDetails();


            System.out.println("\nMaking a deposit of $0 that is a invalid amount.");
            try {
                netSaverAccount.makeAccountDeposit(0.0);
            } catch (IllegalBankAccountOperationException ex) {
                System.out.println(ex.getMessage());
            }
            netSaverAccount.showAccountDetails();
            
            
            System.out.println("\n===== Withdraw tests =======");
            System.out.println("\nMaking a withdraw of $190 that is a valid "
                    + "amount, not enough balance  and has a correct combination of notes. ");
            atmMachine.ATMMachine();
            try {
                atmMachine.executeWithdraw(190);
                netSaverAccount.makeAccountWithdraw(190);
            } catch (IllegalATMMachineOperationException | IllegalBankAccountOperationException ex) {
                System.out.println(ex.getMessage());
            }
            netSaverAccount.showAccountDetails();

            
            System.out.println("\nMaking a deposit of $500 that is a valid amount.");
            try {
                netSaverAccount.makeAccountDeposit(500.0);
            } catch (IllegalBankAccountOperationException ex) {
                System.out.println(ex.getMessage());
            }
            netSaverAccount.showAccountDetails();
            
            
            System.out.println("\nMaking a withdraw of $300 that is a valid "
                    + "amount, enough balance and has a correct combination of notes. ");
            atmMachine.ATMMachine();
            try {
                atmMachine.executeWithdraw(300);
                netSaverAccount.makeAccountWithdraw(300);
            } catch (IllegalATMMachineOperationException | IllegalBankAccountOperationException ex) {
                System.out.println(ex.getMessage());
            }
            netSaverAccount.showAccountDetails();
            
            System.out.println("\nMaking a withdraw of $25 that is a valid "
                    + "amount, enough balance, and has a incorrect combination of notes. ");
            atmMachine.ATMMachine();
            try {
                atmMachine.executeWithdraw(25);
                netSaverAccount.makeAccountWithdraw(25);
            } catch (IllegalATMMachineOperationException | IllegalBankAccountOperationException ex) {
                System.out.println(ex.getMessage());
            }
            netSaverAccount.showAccountDetails();
            
        } catch (ParseException ex) {
            System.out.println(ex.getMessage());
        } 
     }
        
}
