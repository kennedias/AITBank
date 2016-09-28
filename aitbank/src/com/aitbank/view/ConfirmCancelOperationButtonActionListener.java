package com.aitbank.view;

import com.aitbank.constants.ConstantsAitBank;
import com.aitbank.exception.IllegalATMMachineOperationException;
import com.aitbank.exception.IllegalBankAccountOperationException;
import com.aitbank.helper.DateTimeHelper;
import com.aitbank.model.ATMMachine;
import com.aitbank.model.Customer;
import com.aitbank.model.SavingsAccount;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;

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
        try {
            if (confirmCancelOperationButton.equals(ConstantsAitBank.CANCEL_OPERATION)) {
                atmUI.clearTextPanelGUI();
                atmUI.stage = ConstantsAitBank.SELECT_ACCOUNT_STAGE;
            } else if (confirmCancelOperationButton.equals(ConstantsAitBank.CONFIRM_OPERATION)){
                switch (atmUI.stage) {
                    case ConstantsAitBank.INPUT_OPERATION_AMOUNT_STAGE:
                        this.executeConfirmOperation();
                        break;
                    case ConstantsAitBank.CONFIRM_CANCEL_STAGE:
                        this.executeConfirmOperation();
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
        //    atmUI.updateGUI(atmUI.accountType + " " + atmUI.accountOperation + " " + atmUI.amountOperation);
            switch (atmUI.accountType) {
                case ConstantsAitBank.SAVINGS_ACCOUNT:
                    this.executeSavingsOperations();
                    break;
                default:
                    atmUI.accountType = "Invalid Account Type.";
                    break;
            }                
            atmUI.stage = ConstantsAitBank.SELECT_ACCOUNT_STAGE;
        } catch (Exception exception) {
            atmUI.updateGUI("(ER198)System Error - Invalid Option. \nContact the branch.");
            //Simulate the log
            System.out.println(exception.getMessage());
        }
    }
    
    private void executeSavingsOperations() {
        try {
            switch (atmUI.accountOperation) {
                case ConstantsAitBank.BALANCE_OPERATION:
                    atmUI.updateGUI("Balance: " + String.valueOf(atmUI.savingsAccount.getBalance()));
                    break;
                case ConstantsAitBank.DEPOSIT_OPERATION:
                    atmUI.savingsAccount.makeAccountDeposit(Double.parseDouble(atmUI.amountOperation));
                    atmUI.updateGUI("Deposit completed with success. \n New balance: " + String.valueOf(atmUI.savingsAccount.getBalance()));
                    break;
                case ConstantsAitBank.WITHDRAW_OPERATION:
                    ATMMachine atmMachine = new ATMMachine();
                    atmMachine.executeWithdraw(Double.parseDouble(atmUI.amountOperation));
                    atmUI.savingsAccount.makeAccountWithdraw(Double.parseDouble(atmUI.amountOperation));
                    atmUI.updateGUI("Withdraw completed with success. \n New balance: " + String.valueOf(atmUI.savingsAccount.getBalance()));
                    break;
                case ConstantsAitBank.WITHDRAWLIMIT_OPERATION:
                    atmUI.updateGUI("Daily withdraw limit..: " + String.valueOf(atmUI.savingsAccount.getDailyWithdrawLimit()) + "\n"
                            + "Daily withdraw done...: " + String.valueOf(atmUI.savingsAccount.getDailyWithdrawAmountRealized()));
                    break;
                default:
                    atmUI.updateGUI("(ER193)System Error - Invalid Option. \nContact the branch.");
                    break;
            }
        } catch (IllegalATMMachineOperationException | IllegalBankAccountOperationException exception) {
            atmUI.updateGUI(exception.getMessage());
        } catch (Exception exception) {
            atmUI.updateGUI("(ER194)System Error - Invalid Option. \nContact the branch.");
            //Simulate the log
            System.out.println(exception.getMessage());
        }
    }
}
