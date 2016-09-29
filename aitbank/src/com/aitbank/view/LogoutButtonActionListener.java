package com.aitbank.view;

import com.aitbank.constants.ConstantsAitBank;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author 5399
 */
public class LogoutButtonActionListener implements ActionListener {

    public String logoutButton;       
    public AtmUI atmUI;  
    
    public LogoutButtonActionListener(String logout, AtmUI ui) {
        this.logoutButton = logout;
        this.atmUI = ui;
    }  
    
    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            if(atmUI.stage != ConstantsAitBank.LOGIN_STAGE){            
                atmUI.clearTextPanelGUI();
                atmUI.stage = ConstantsAitBank.LOGIN_STAGE;
                atmUI.updateGUI("Logout done with success. \n Thank you for come to us.");
            }
        } catch (Exception exception) {
            atmUI.updateGUI("(ER074)System Error. \nContact the branch.");
            //Simulate the log
            System.out.println(exception.getMessage());
        }
    }
    
}
