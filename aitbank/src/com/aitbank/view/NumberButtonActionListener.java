/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aitbank.view;

import com.aitbank.constants.ConstantsAitBank;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author 5399
 */
public class NumberButtonActionListener implements ActionListener{
    
    public int numberButton;       
    public AtmUI atmUI;  

    public NumberButtonActionListener(int number, AtmUI ui) {
        this.numberButton = number;
        this.atmUI = ui;
    }

    @Override
    public void actionPerformed(ActionEvent e) {      
        try {
            switch (atmUI.stage) {
                case ConstantsAitBank.INPUT_OPERATION_AMOUNT_STAGE:
                    atmUI.amountOperation += numberButton;
                    atmUI.updateGUI(atmUI.line += numberButton);
                    break;
                case ConstantsAitBank.SELECT_ACCOUNT_STAGE:
                    atmUI.updateGUI("Select an account to continue.");
                    break;
                case ConstantsAitBank.SELECT_ACCOUNT_OPERATION_STAGE:
                    atmUI.updateGUI("Select an account operation to continue.");
                    break;
                case ConstantsAitBank.CONFIRM_CANCEL_STAGE:
                    atmUI.updateGUI("Confirm or Cancel operation to continue.");
                    break;           
                default:
                    atmUI.updateGUI("(ER230)System Error - Invalid Option. \nContact the branch.");
                    break;
            }           
        } catch (Exception exception) {
            atmUI.updateGUI("(ER231)System Error. \nContact the branch.");
            //Simulate the log
            System.out.println(exception.getMessage());
        } 
    }
}
