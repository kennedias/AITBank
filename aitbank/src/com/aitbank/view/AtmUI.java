/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aitbank.view;

import com.aitbank.constants.ConstantsAitBank;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 *
 * @author 5399
 */
public class AtmUI {
    JFrame frame;
    JTextArea infoPanel;
    JButton btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btn0;
    JButton btnCancel, btnConfirm, btnWithdraw, btnBalance, btnDeposit, btnHelp;
    JButton btnSavings, btnNet, btnFixed, btnCheque;
    
    JPanel bottomPanel, bottomLeftPanel, bottomMiddlePanel, bottomRightPanel;
    JPanel topPanel, topLeftPanel, topMiddlePanel, topRightPanel;

    String line="";
    String textAccount = "Select an account: ";
    String textAccountOperation="Select an operation: ";
    String numbers = "";
    int stage = ConstantsAitBank.SELECT_ACCOUNT_STAGE;
    
    public void setupUI(){
        frame = new JFrame("AIT ATM Machine");
        frame.setSize(800,250);
        
        setupButtons();
        setupPanels();
        
        //infoPanel.setText("dsfsdf\nsdfsdfdsf\ndsfdsfgdfgdgdgdgdgdgdgdgdgghjghjghjghjghjghjghjdgdgdg");
     //   infoPanel.i
     //   infoPanel.setText(textAccount);
     //   infoPanel.setLineWrap(true);
        
        frame.setVisible(true);
        
    }

        private void setupPanels(){
            topLeftPanel = new JPanel(new GridLayout(4,1));
            topLeftPanel.add(btnSavings);
            topLeftPanel.add(btnNet);
            topLeftPanel.add(btnFixed);
            topLeftPanel.add(btnCheque);

            topMiddlePanel = new JPanel(new GridLayout(1,1));
            infoPanel = new JTextArea();
            infoPanel.setEditable(false);
            topMiddlePanel.add(infoPanel);
            
            topRightPanel = new JPanel(new GridLayout(4,1));
            topRightPanel.add(btnBalance);
            topRightPanel.add(btnWithdraw);
            topRightPanel.add(btnDeposit);
            topRightPanel.add(btnHelp);
            
            topPanel = new JPanel(new GridLayout(1,3));
            topPanel.add(topLeftPanel);
            topPanel.add(topMiddlePanel);
            topPanel.add(topRightPanel);

            
            bottomMiddlePanel = new JPanel(new GridLayout(4,3));
            bottomMiddlePanel.add(btn1);
            bottomMiddlePanel.add(btn2);
            bottomMiddlePanel.add(btn3);
            bottomMiddlePanel.add(btn4);
            bottomMiddlePanel.add(btn5);
            bottomMiddlePanel.add(btn6);            
            bottomMiddlePanel.add(btn7);
            bottomMiddlePanel.add(btn8);
            bottomMiddlePanel.add(btn9);
            bottomMiddlePanel.add(btnCancel);
            bottomMiddlePanel.add(btn0);
            bottomMiddlePanel.add(btnConfirm);
            
            bottomLeftPanel = new JPanel(new GridLayout(1,1));
            bottomRightPanel = new JPanel(new GridLayout(1,1));
            
            bottomPanel = new JPanel(new GridLayout(1,1));
            bottomPanel.add(bottomLeftPanel);
            bottomPanel.add(bottomMiddlePanel);
            bottomPanel.add(bottomRightPanel);
            
            frame.add(topPanel, BorderLayout.NORTH);  
            frame.add(bottomPanel, BorderLayout.SOUTH);
                 
        
    }
        
    private void setupButtons(){
        /* Account buttons */
        btnSavings = new JButton(ConstantsAitBank.SAVINGS_ACCOUNT);
        btnNet = new JButton(ConstantsAitBank.NET_ACCOUNT);
        btnFixed = new JButton(ConstantsAitBank.FIXED_ACCOUNT);
        btnCheque = new JButton(ConstantsAitBank.CHEQUE_ACCOUNT);
        btnSavings.addActionListener(new AccountButtonActionListener(ConstantsAitBank.SAVINGS_ACCOUNT, this));
        btnNet.addActionListener(new AccountButtonActionListener(ConstantsAitBank.NET_ACCOUNT, this));
        btnFixed.addActionListener(new AccountButtonActionListener(ConstantsAitBank.FIXED_ACCOUNT, this));
        btnCheque.addActionListener(new AccountButtonActionListener(ConstantsAitBank.CHEQUE_ACCOUNT, this));
        
        /* Account Operations buttons */        
        btnBalance = new JButton(ConstantsAitBank.BALANCE_OPERATION);
        btnWithdraw = new JButton(ConstantsAitBank.WITHDRAW_OPERATION);
        btnDeposit = new JButton(ConstantsAitBank.DEPOSIT_OPERATION);
        btnHelp = new JButton(ConstantsAitBank.HELP_OPERATION);
        btnBalance.addActionListener(new AccountOperationButtonActionListener(ConstantsAitBank.BALANCE_OPERATION, this));
        btnWithdraw.addActionListener(new AccountOperationButtonActionListener(ConstantsAitBank.WITHDRAW_OPERATION, this));
        btnDeposit.addActionListener(new AccountOperationButtonActionListener(ConstantsAitBank.DEPOSIT_OPERATION, this));
        btnHelp.addActionListener(new AccountOperationButtonActionListener(ConstantsAitBank.HELP_OPERATION, this));
        
        
        /* Numbers buttons */
        btn1 = new JButton("1");
        btn2 = new JButton("2");
        btn3 = new JButton("3");
        btn4 = new JButton("4");
        btn5 = new JButton("5");
        btn6 = new JButton("6");
        btn7 = new JButton("7");
        btn8 = new JButton("8");
        btn9 = new JButton("9");
        btn0 = new JButton("0");
        btn1.addActionListener(new NumberButtonActionListener(1, this));
        btn2.addActionListener(new NumberButtonActionListener(2, this));
        btn3.addActionListener(new NumberButtonActionListener(3, this));
        btn4.addActionListener(new NumberButtonActionListener(4, this));
        btn5.addActionListener(new NumberButtonActionListener(5, this));
        btn6.addActionListener(new NumberButtonActionListener(6, this));
        btn7.addActionListener(new NumberButtonActionListener(7, this));
        btn8.addActionListener(new NumberButtonActionListener(8, this));
        btn9.addActionListener(new NumberButtonActionListener(9, this));
        btn0.addActionListener(new NumberButtonActionListener(0, this));
        
        /* Confirm and Cancel buttons */
        btnCancel = new JButton(ConstantsAitBank.CANCEL_OPERATION);
        btnConfirm = new JButton(ConstantsAitBank.CONFIRM_OPERATION);
        btnCancel.addActionListener(new ConfirmCancelOperationButtonActionListener(ConstantsAitBank.CANCEL_OPERATION, this));
        btnConfirm.addActionListener(new ConfirmCancelOperationButtonActionListener(ConstantsAitBank.CONFIRM_OPERATION, this));

   }
    
    public void updateGUI(){
        String output = line;
       // infoPanel.setText(output);
        infoPanel.setText(line);
    }
}
