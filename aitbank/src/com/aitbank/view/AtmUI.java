/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aitbank.view;

import com.aitbank.constants.ConstantsAitBank;
import com.aitbank.model.Customer;
import com.aitbank.model.SavingsAccount;
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
    JButton btnCancel, btnConfirm, btnWithdraw, btnBalance, btnDeposit, btnWithdrawLimit;
    JButton btnSavings, btnNet, btnFixed, btnCheque;
    JButton btnLogin, btnLogout;
    
    JPanel bottomPanel, loginPanel, numberPadPanel, logoutPanel;
    JPanel topPanel, accountPanel, textScreenPanel, accountOperationPanel;

    String amountInputed="";
    String numbers = "";
    String accountType = "";
    String accountOperation = "";
    String amountOperation ="";
    int stage = ConstantsAitBank.LOGIN_STAGE;
    
    Customer customerLogged = new Customer();
    SavingsAccount savingsAccount = new SavingsAccount();
    
    
    public void setupUI(){
        frame = new JFrame("AIT ATM Machine");
        frame.setSize(800,250);
        
        this.setupButtons();
        this.setupPanels();
        this.updateGUI("Welcome! \n Please, do a login to start.");
        frame.setVisible(true);        
    }
        private void setupPanels(){
            accountPanel = new JPanel(new GridLayout(4,1));
            accountPanel.add(btnSavings);
            accountPanel.add(btnNet);
            accountPanel.add(btnFixed);
            accountPanel.add(btnCheque);

            textScreenPanel = new JPanel(new GridLayout(1,1));
            infoPanel = new JTextArea();
            infoPanel.setEditable(false);
            textScreenPanel.add(infoPanel);
            
            accountOperationPanel = new JPanel(new GridLayout(4,1));
            accountOperationPanel.add(btnBalance);
            accountOperationPanel.add(btnWithdraw);
            accountOperationPanel.add(btnDeposit);
            accountOperationPanel.add(btnWithdrawLimit);
            
            topPanel = new JPanel(new GridLayout(1,3));
            topPanel.add(accountPanel);
            topPanel.add(textScreenPanel);
            topPanel.add(accountOperationPanel);
            
            numberPadPanel = new JPanel(new GridLayout(4,3));
            numberPadPanel.add(btn1);
            numberPadPanel.add(btn2);
            numberPadPanel.add(btn3);
            numberPadPanel.add(btn4);
            numberPadPanel.add(btn5);
            numberPadPanel.add(btn6);            
            numberPadPanel.add(btn7);
            numberPadPanel.add(btn8);
            numberPadPanel.add(btn9);
            numberPadPanel.add(btnCancel);
            numberPadPanel.add(btn0);
            numberPadPanel.add(btnConfirm);
            
            loginPanel = new JPanel(new GridLayout(1,1));
            loginPanel.add(btnLogin);
            
            logoutPanel = new JPanel(new GridLayout(1,1));
            logoutPanel.add(btnLogout);
            
            bottomPanel = new JPanel(new GridLayout(1,1));
            bottomPanel.add(loginPanel);
            bottomPanel.add(numberPadPanel);
            bottomPanel.add(logoutPanel);
            
            frame.add(topPanel, BorderLayout.NORTH);  
            frame.add(bottomPanel, BorderLayout.SOUTH);                 
        
    }
        
    private void setupButtons(){
        /* Login button */
        btnLogin = new JButton(ConstantsAitBank.LOGIN_OPERATION);
        btnLogin.addActionListener(new LoginButtonActionListener(ConstantsAitBank.LOGIN_OPERATION, this));
        
        /* Logout button */
        btnLogout = new JButton(ConstantsAitBank.LOGOUT_OPERATION);
        btnLogout.addActionListener(new LogoutButtonActionListener(ConstantsAitBank.LOGOUT_OPERATION, this));
        
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
        btnWithdrawLimit = new JButton(ConstantsAitBank.WITHDRAWLIMIT_OPERATION);
        btnBalance.addActionListener(new AccountOperationButtonActionListener(ConstantsAitBank.BALANCE_OPERATION, this));
        btnWithdraw.addActionListener(new AccountOperationButtonActionListener(ConstantsAitBank.WITHDRAW_OPERATION, this));
        btnDeposit.addActionListener(new AccountOperationButtonActionListener(ConstantsAitBank.DEPOSIT_OPERATION, this));
        btnWithdrawLimit.addActionListener(new AccountOperationButtonActionListener(ConstantsAitBank.WITHDRAWLIMIT_OPERATION, this));
        
        
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
    
    public void updateGUI(String lineToShow){
        infoPanel.setText(" "+lineToShow+"\n");  
    }
    
    public void clearTextPanelGUI(){
        infoPanel.setText("");
        amountInputed = "";
    }
    
    public void initializeNewOperation()
    {
      //  this.amountInputed = "";
        this.numbers = "";
        this.accountType = "";
        this.accountOperation = "";
        this.amountOperation ="";
        this.stage = ConstantsAitBank.SELECT_ACCOUNT_STAGE;
    }
}
