package com.aitbank.view;


import com.aitbank.constants.ConstantsAitBank;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 *
 * @author 5399
 */
public class AccountButtonActionListener implements ActionListener{

    public String accountButton;       
    public AtmUI atmUI;  
    
    public AccountButtonActionListener(String account, AtmUI ui) {
        this.accountButton = account;
        this.atmUI = ui;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        atmUI.clearTextPanelGUI();
        if (atmUI.stage == ConstantsAitBank.SELECT_ACCOUNT_STAGE)
        {
            atmUI.clearTextPanelGUI();
            atmUI.line += accountButton+"\n";
            atmUI.accountType = accountButton;
            atmUI.updateGUI();   
            atmUI.stage = ConstantsAitBank.SELECT_ACCOUNT_OPERATION_STAGE; 
        } else {
            if (atmUI.stage == ConstantsAitBank.SELECT_ACCOUNT_OPERATION_STAGE)
            {
                atmUI.line += "Select an account operation to continue. \n";
                atmUI.updateGUI();
            } else if (atmUI.stage == ConstantsAitBank.INPUT_OPERATION_AMOUNT_STAGE)
            {
                atmUI.line += "Input the amount operation to continue. \n";
                atmUI.updateGUI();
            }            
        }        

    }
    
}
