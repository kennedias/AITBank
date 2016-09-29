package com.aitbank.view;

import com.aitbank.constants.ConstantsAitBank;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 *
 * @author 5399
 */
public class AccountOperationButtonActionListener implements ActionListener{
    
    public String accountOperationButton;       
    public AtmUI atmUI;  
    
    public AccountOperationButtonActionListener(String accountOperation, AtmUI ui) {
        this.accountOperationButton = accountOperation;
        this.atmUI = ui;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {      
        try {
            atmUI.clearTextPanelGUI();

            /* Verify the stage of the operation and do the respective
                action if it is the respective class operation.
            
                Operation -> Select a account operation.
                The user have to choose an account operation to execute.
                For Balance and Withdraw Limit it is necessary only confirm
                the operation pressing Confirm button.
                For Deposit and Withdraw it is necessary to inform a valid
                operation amount to proceed.
            **/
            switch (atmUI.operationStage) {
                case ConstantsAitBank.SELECT_ACCOUNT_OPERATION_STAGE:
                    atmUI.accountOperation = accountOperationButton;
                    atmUI.updateGUI(accountOperationButton);
                    if (accountOperationButton.equals(ConstantsAitBank.BALANCE_OPERATION) ||
                        accountOperationButton.equals(ConstantsAitBank.WITHDRAWLIMIT_OPERATION)){
                        
                        atmUI.operationStage = ConstantsAitBank.CONFIRM_CANCEL_STAGE;
                        
                    }else{
                        atmUI.operationStage = ConstantsAitBank.INPUT_OPERATION_AMOUNT_STAGE;
                        
                        if (accountOperationButton.equals(ConstantsAitBank.WITHDRAW_OPERATION)){
                            atmUI.updateGUI("Notes available for withdraw: 20, 50, 100." +
                                            "\nMake sure the amount is valid.");
                        }else if(accountOperationButton.equals(ConstantsAitBank.DEPOSIT_OPERATION)){
                            atmUI.updateGUI("Inform the amount of deposit");
                        }
                    }
                    break;                    
                case ConstantsAitBank.LOGIN_STAGE:
                    atmUI.updateGUI("You must be logged to continue.");
                    break;  
                case ConstantsAitBank.SELECT_ACCOUNT_STAGE:
                    atmUI.updateGUI("Select an account to continue.");
                    break;
                case ConstantsAitBank.INPUT_OPERATION_AMOUNT_STAGE:
                    atmUI.updateGUI("Input the amount operation to continue.");
                    break;
                case ConstantsAitBank.CONFIRM_CANCEL_STAGE:
                    atmUI.updateGUI("Confirm or Cancel operation to continue.");
                    break;           
                default:
                    atmUI.updateGUI("(ER280)System Error - Invalid Option. \nContact the branch.");
                    break;
            }           
        } catch (Exception exception) {
            atmUI.updateGUI("(ER281)System Error. \nContact the branch.");
            //Simulate the error logging
            System.out.println(exception.getMessage());
        }        
    }
            
}
