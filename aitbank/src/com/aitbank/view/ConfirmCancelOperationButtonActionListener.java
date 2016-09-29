package com.aitbank.view;

import com.aitbank.constants.ConstantsAitBank;
import com.aitbank.exception.IllegalATMMachineOperationException;
import com.aitbank.exception.IllegalBankAccountOperationException;
import com.aitbank.model.ATMMachine;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author 5399
 */
public class ConfirmCancelOperationButtonActionListener implements ActionListener {

    public String confirmCancelOperationButton;
    public AtmUI atmUI;

    public ConfirmCancelOperationButtonActionListener(String confirmCancelOperation, AtmUI ui) {
        this.confirmCancelOperationButton = confirmCancelOperation;
        this.atmUI = ui;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        /* Verify the stage of the operation and do the respective
            action if it is the respective class operation.

            Operation -> Confirm or Cancel.
            The user can cancel an operation any time after logging on. Canceling
            means that the operation back to the choose account stage.
            For confirm button, it is necessary to check before proceed:
                - Type of account;
                - Account operation;
                - Amount, if applicable.
        **/     
        try {
            if ((confirmCancelOperationButton.equals(ConstantsAitBank.CANCEL_OPERATION)) &&
                (atmUI.operationStage != ConstantsAitBank.LOGIN_STAGE)) {
                atmUI.clearTextPanelGUI();
                atmUI.operationStage = ConstantsAitBank.SELECT_ACCOUNT_STAGE;
                atmUI.updateGUI("Operation Canceled.");
            } else if (confirmCancelOperationButton.equals(ConstantsAitBank.CONFIRM_OPERATION)){
                switch (atmUI.operationStage) {
                    case ConstantsAitBank.LOGIN_STAGE:
                        atmUI.updateGUI("You must be logged to continue.");
                        break; 
                    case ConstantsAitBank.INPUT_OPERATION_AMOUNT_STAGE:
                        this.executeConfirmOperation();                            
                        break;
                    case ConstantsAitBank.CONFIRM_CANCEL_STAGE:                        
                        this.executeConfirmOperation();
                        atmUI.initializeNewOperation();
                        break;
                    case ConstantsAitBank.SELECT_ACCOUNT_STAGE:
                        atmUI.updateGUI("Select an account to continue.");
                        break;
                    case ConstantsAitBank.SELECT_ACCOUNT_OPERATION_STAGE:
                        atmUI.updateGUI("Select an account operation to continue.");
                        break;
                    default:
                        atmUI.updateGUI("(ER190)System Error - Invalid Option. \nContact the branch.");
                        break;
                }                
            } 
        } catch (Exception exception) {
            atmUI.updateGUI("(ER191)System Error. \nContact the branch.");
            //Simulate the log
            System.out.println(exception.getMessage());
        }
    }

    private void executeConfirmOperation() {
        try {
            /*
            The operation for the others accounts type should be 
            implemented here.
            First delivery contains only Savings Account operations.
            */
            switch (atmUI.accountType) {
                case ConstantsAitBank.SAVINGS_ACCOUNT:
                    this.executeSavingsOperations();
                    break;
                default:
                    atmUI.accountType = "Invalid Account Type.";
                    break;
            }                
        } catch (Exception exception) {
            atmUI.updateGUI("(ER198)System Error - Invalid Option. \nContact the branch.");
            //Simulate the error logging
            System.out.println(exception.getMessage());
        }
    }
    
    private void executeSavingsOperations() {
        /* Executing Savings Account Operations */
        try {
            switch (atmUI.accountOperation) {
                case ConstantsAitBank.BALANCE_OPERATION:
                    atmUI.updateGUI("Balance: " + String.valueOf(atmUI.savingsAccount.getBalance()));
                    break;
                case ConstantsAitBank.DEPOSIT_OPERATION:
                    if (atmUI.amountOperation == null || atmUI.amountOperation.isEmpty()){
                        atmUI.updateGUI("Please, inform a valid amount to proceed.");
                    } else {
                        atmUI.savingsAccount.makeAccountDeposit(Double.parseDouble(atmUI.amountOperation));
                        atmUI.updateGUI("Deposit completed with success. \n New balance: " 
                                        + String.valueOf(atmUI.savingsAccount.getBalance()));
                        atmUI.initializeNewOperation();                            
                    }
                    break;
                case ConstantsAitBank.WITHDRAW_OPERATION:
                    if (atmUI.amountOperation == null || atmUI.amountOperation.isEmpty()){
                        atmUI.updateGUI("Please, inform a valid amount to proceed.");
                    } else {
                        /* Check if the amount inputed is possible to make a withdraw
                           considering the notes available.
                           Throws a business exception if not.     
                           If the amount is valid, the next step is check the
                           account requiriments to perform the withdraw.
                        */
                        ATMMachine atmMachine = new ATMMachine(); 
                        atmMachine.executeWithdraw(Double.parseDouble(atmUI.amountOperation));
                        atmUI.savingsAccount.makeAccountWithdraw(Double.parseDouble(atmUI.amountOperation));
                        atmUI.updateGUI("Withdraw completed with success. \n New balance: " 
                                        + String.valueOf(atmUI.savingsAccount.getBalance()));
                        atmUI.initializeNewOperation();                            
                    }
                    break;
                case ConstantsAitBank.WITHDRAWLIMIT_OPERATION:
                    atmUI.updateGUI("Daily withdraw limit..: " + 
                            String.valueOf(atmUI.savingsAccount.getDailyWithdrawLimit()) + 
                            "\nDaily withdraw done...: " + 
                            String.valueOf(atmUI.savingsAccount.getDailyWithdrawAmountRealized()));
                    break;
                default:
                    atmUI.updateGUI("(ER193)System Error - Invalid Option. \nContact the branch.");
                    break;
            }
        } catch (IllegalATMMachineOperationException exception) {
            atmUI.updateGUI(exception.getMessage() + "\nInform a valid amount.");
            atmUI.amountOperation = "";
            //Simulate error logging
            System.out.println(exception.getMessage());
        }catch (IllegalBankAccountOperationException exception) {
            atmUI.updateGUI(exception.getMessage());
            //Simulate error logging
            System.out.println(exception.getMessage());
            atmUI.initializeNewOperation();
        } catch (Exception exception) {
            atmUI.updateGUI("(ER194)System Error - Invalid Option. \nContact the branch.");
            //Simulate error logging
            System.out.println(exception.getMessage());
            atmUI.initializeNewOperation();
        }
    }
}
