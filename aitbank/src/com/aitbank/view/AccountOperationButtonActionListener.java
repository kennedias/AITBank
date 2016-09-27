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
        
        if (atmUI.stage == ConstantsAitBank.SELECT_ACCOUNT_OPERATION_STAGE)
        {            
            atmUI.line += accountOperationButton+"\n";
            atmUI.accountOperation = accountOperationButton;
            atmUI.updateGUI();
            atmUI.stage = ConstantsAitBank.INPUT_OPERATION_AMOUNT_STAGE;

        } else {
            atmUI.clearTextPanelGUI();
            if (atmUI.stage == ConstantsAitBank.SELECT_ACCOUNT_STAGE)
            {
                atmUI.line += "Select an account to continue. \n";
                atmUI.updateGUI();
            } else if (atmUI.stage == ConstantsAitBank.INPUT_OPERATION_AMOUNT_STAGE)
            {
                atmUI.line += "Input the amount operation to continue. \n";
                atmUI.updateGUI();
            }
            
        }

    }
            
}
