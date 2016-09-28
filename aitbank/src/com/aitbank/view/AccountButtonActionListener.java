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
        try {
            atmUI.clearTextPanelGUI();

            switch (atmUI.stage) {
                case ConstantsAitBank.SELECT_ACCOUNT_STAGE:
                    atmUI.clearTextPanelGUI();
                    atmUI.accountType = accountButton;
                    atmUI.updateGUI(accountButton);   
                    atmUI.stage = ConstantsAitBank.SELECT_ACCOUNT_OPERATION_STAGE;
                    break;
                case ConstantsAitBank.SELECT_ACCOUNT_OPERATION_STAGE:
                    atmUI.updateGUI("Select an account operation to continue.");
                    break;
                case ConstantsAitBank.INPUT_OPERATION_AMOUNT_STAGE:
                    atmUI.updateGUI("Input the amount operation to continue.");
                    break;
                case ConstantsAitBank.CONFIRM_CANCEL_STAGE:
                    atmUI.updateGUI("Confirm or Cancel operation to continue.");
                    break;           
                default:
                    atmUI.updateGUI("(ER253)System Error - Invalid Option. \nContact the branch.");
                    break;
            }            
        } catch (Exception exception) {
            atmUI.updateGUI("(ER254)System Error. \nContact the branch.");
                        //Simulate the log
            System.out.println(exception.getMessage());
        }
    }
    
}
