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
        if (atmUI.stage == ConstantsAitBank.INPUT_OPERATION_AMOUNT_STAGE)
        {
            atmUI.line += numberButton;
            atmUI.updateGUI();
        } else {
            if (atmUI.stage == ConstantsAitBank.SELECT_ACCOUNT_STAGE)
            {
                atmUI.line += "\n Select an account to continue.";
                atmUI.updateGUI();
            } else if (atmUI.stage == ConstantsAitBank.SELECT_ACCOUNT_OPERATION_STAGE)
            {
                atmUI.line += "\n Select an account operation to continue.";
                atmUI.updateGUI();
            }            
        } 
        
      
    }
}
