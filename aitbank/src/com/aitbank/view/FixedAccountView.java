package com.aitbank.view;

import com.aitbank.exception.IllegalATMMachineOperationException;
import com.aitbank.exception.IllegalBankAccountOperationException;
import com.aitbank.helper.DateTimeHelper;
import com.aitbank.model.ATMMachine;
import com.aitbank.model.Customer;
import com.aitbank.model.FixedAccount;
import java.text.ParseException;

/**
 * Simulates the view layer actions performing Fixed Account operations.
 * @author 5399 - Kennedy Oliveira
 */
public class FixedAccountView {
    
    public void FixedAccountView(Customer customer){

        try {
            DateTimeHelper dateHelper = new DateTimeHelper();
            ATMMachine atmMachine = new ATMMachine();
            
            System.out.println("\n==========================================");
            System.out.println("Creating Fixed Account... ");
            
            FixedAccount fixedAccount = new FixedAccount();
            
            fixedAccount.setCustomer(customer);
            fixedAccount.setAccountNumber(123);
            fixedAccount.setBranchNumber(99);
            fixedAccount.setBalance(800.00);
            fixedAccount.setFixedAmount(fixedAccount.getBalance());
            fixedAccount.setDepositDate(dateHelper.generateDateFromString("01/08/2016 00:00"));
            fixedAccount.setInterestRate(0.15);
            fixedAccount.setDueDateOfInterest(dateHelper.generateDateFromString("26/08/2016 23:59"));
            fixedAccount.showAccountDetails();
           
            
            System.out.println("\nUpdating balance with account interest of the "
                    + "period. Interest have to be paid once the due date"
                    + "\nhave been achieved and no withdraw have been done");
            try {
                fixedAccount.updateActualBalanceWithInterest();
            } catch (IllegalBankAccountOperationException ex) {
                System.out.println(ex.getMessage());
            }
            fixedAccount.showAccountDetails();

            
            System.out.println("\nTrying to apply interest in an already interest"
                    + " updated account. It can not be updated once it"
                    + "\n have been paid.");
            try {
                fixedAccount.updateActualBalanceWithInterest();
            } catch (IllegalBankAccountOperationException ex) {
                System.out.println(ex.getMessage());
            }
            fixedAccount.showAccountDetails();
            
            System.out.println("\nCreating a new Fixed account.");
            FixedAccount fixedAccount2 = new FixedAccount();
            
            fixedAccount2.setCustomer(customer);
            fixedAccount2.setAccountNumber(541);
            fixedAccount2.setBranchNumber(99);
            fixedAccount2.setBalance(500.00);
            fixedAccount2.setFixedAmount(fixedAccount2.getBalance());
            fixedAccount2.setDepositDate(dateHelper.generateDateFromString("01/08/2016 00:00"));
            fixedAccount2.setInterestRate(0.15);
            fixedAccount2.setDueDateOfInterest(dateHelper.generateDateFromString("26/08/2016 23:59"));
            fixedAccount2.setWithdrawDate(dateHelper.generateDateFromString("25/08/2016 23:59"));
            fixedAccount2.showAccountDetails();
            
            
            System.out.println("\nUpdating balance with account interest of the "
                    + "period. Interest have NOT to be paid once it had a "
                    + "\n withdraw been done before the due date.");
            try {
                fixedAccount2.updateActualBalanceWithInterest();
            } catch (IllegalBankAccountOperationException ex) {
                System.out.println(ex.getMessage());
            }
            fixedAccount2.showAccountDetails();

            
            System.out.println("\nCreating a new Fixed account.");
            FixedAccount fixedAccount3 = new FixedAccount();
            
            fixedAccount3.setCustomer(customer);
            fixedAccount3.setAccountNumber(58551);
            fixedAccount3.setBranchNumber(99);
            fixedAccount3.setBalance(800.00);
            fixedAccount3.setFixedAmount(fixedAccount3.getBalance());
            fixedAccount3.setDepositDate(dateHelper.generateDateFromString("01/08/2016 00:00"));
            fixedAccount3.setInterestRate(0.15);
            fixedAccount3.setDueDateOfInterest(dateHelper.generateDateFromString("26/08/2016 23:59"));
            fixedAccount3.showAccountDetails();
            

            System.out.println("\nMaking a withdraw of $170 that is a valid "
                    + "amount, enough balance and has a correct"
                    + "\ncombination of notes. ");
            atmMachine.ATMMachine();
            try {
                atmMachine.executeWithdraw(170);
                fixedAccount3.makeAccountWithdraw(170);
            } catch (IllegalATMMachineOperationException | IllegalBankAccountOperationException ex) {
                System.out.println(ex.getMessage());
            }
            fixedAccount3.showAccountDetails();

            
            System.out.println("\nUpdating balance with account interest of the "
                    + "period. Interest have to be paid once the due date"
                    + "\nhave been achieved and no withdraw have been done "
                    + "before the due date.");
            System.out.println("\nNOTE! A withdraw was made after the due date "
                    + "but before the system update the account interest."
                    + "\n However for the calc the system will consider the total"
                    + " amount fixed for the period.");
            try {
                fixedAccount3.updateActualBalanceWithInterest();
            } catch (IllegalBankAccountOperationException ex) {
                System.out.println(ex.getMessage());
            }
            fixedAccount3.showAccountDetails();            

        } catch (ParseException ex) {
            System.out.println(ex.getMessage());
        }
     
    }
    
}
