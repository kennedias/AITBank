package com.aitbank.view;

import com.aitbank.exception.IllegalATMMachineOperationException;
import com.aitbank.exception.IllegalBankAccountOperationException;
import com.aitbank.model.ATMMachine;
import com.aitbank.model.ChequeAccount;
import com.aitbank.model.Customer;

/**
 * Simulates the view layer actions performing Cheque Account operations.
 *
 * @author 5399 - Kennedy Oliveira
 */
public class ChequeAccountView {

    public void ChequeAccountView(Customer customer) {

        ChequeAccount chequeAccount = new ChequeAccount();
        ATMMachine atmMachine = new ATMMachine();

        System.out.println("\n==========================================");
        System.out.println("Creating Cheque Account and making a initial "
                + "deposit of $500.");

        chequeAccount.setCustomer(customer);
        chequeAccount.setAccountNumber(123);
        chequeAccount.setBranchNumber(99);

        try {
            chequeAccount.makeAccountDeposit(500);
        } catch (IllegalBankAccountOperationException ex) {
            System.out.println(ex.getMessage());
        }
        chequeAccount.showAccountDetails();

        System.out.println("\nMaking a withdraw of $110 that is a valid amount, "
                + "enough balance and correct combination of notes. ");
        /**
         * A withdraw should be done in the account only if the ATM machine is
         * able to give the notes to the customer and if the account has enough
         * balance.
         */
        try {
            atmMachine.executeWithdraw(110);
            chequeAccount.makeAccountWithdraw(110);
        } catch (IllegalATMMachineOperationException | IllegalBankAccountOperationException ex) {
            System.out.println(ex.getMessage());
        }
        chequeAccount.showAccountDetails();

        
        System.out.println("\nMaking a withdraw of $1000 that is a valid amount, "
                + "not enough balance and correct combination of notes. ");
        atmMachine.ATMMachine();
        try {
            atmMachine.executeWithdraw(1000);
            chequeAccount.makeAccountWithdraw(1000);
        } catch (IllegalATMMachineOperationException | IllegalBankAccountOperationException ex) {
            System.out.println(ex.getMessage());
        }
        chequeAccount.showAccountDetails();

        
        System.out.println("\nMaking a withdraw of $0 that is a invalid amount, "
                + "enough balance and incorrect combination of notes. ");
        atmMachine.ATMMachine();
        try {
            atmMachine.executeWithdraw(0);
            chequeAccount.makeAccountWithdraw(0);
        } catch (IllegalATMMachineOperationException | IllegalBankAccountOperationException ex) {
            System.out.println(ex.getMessage());
        }
        chequeAccount.showAccountDetails();

        
        System.out.println("\nMaking a withdraw of $95 that is a valid amount, "
                + "enough balance and incorrect combination of notes. ");
        atmMachine.ATMMachine();
        try {
            atmMachine.executeWithdraw(95);
            chequeAccount.makeAccountWithdraw(95);
        } catch (IllegalATMMachineOperationException | IllegalBankAccountOperationException ex) {
            System.out.println(ex.getMessage());
        }
        chequeAccount.showAccountDetails();
    }
}

