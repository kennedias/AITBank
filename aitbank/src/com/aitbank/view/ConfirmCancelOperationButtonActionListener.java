package com.aitbank.view;

import com.aitbank.constants.ConstantsAitBank;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 *
 * @author 5399
 */
public class ConfirmCancelOperationButtonActionListener implements ActionListener{
    
    public String confirmCancelOperationButton;       
    public AtmUI atmUI;  
    
    public ConfirmCancelOperationButtonActionListener(String confirmCancelOperation, AtmUI ui) {
        this.confirmCancelOperationButton = confirmCancelOperation;
        this.atmUI = ui;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (confirmCancelOperationButton == ConstantsAitBank.CONFIRM_OPERATION)
        {

        } else {
            atmUI.line = "\nOperation Canceled.";
            atmUI.updateGUI();
            atmUI.stage = ConstantsAitBank.SELECT_ACCOUNT_STAGE;
        }

    }
         
}
