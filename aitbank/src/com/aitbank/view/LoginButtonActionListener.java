package com.aitbank.view;

import com.aitbank.constants.ConstantsAitBank;
import com.aitbank.helper.DateTimeHelper;
import com.aitbank.model.Customer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import com.aitbank.model.SavingsAccount;

/**
 *
 * @author 5399
 */
public class LoginButtonActionListener implements ActionListener {

    public String loginButton;       
    public AtmUI atmUI;  
    
    public LoginButtonActionListener(String login, AtmUI ui) {
        this.loginButton = login;
        this.atmUI = ui;
    }      
    
    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            atmUI.clearTextPanelGUI();

            switch (atmUI.operationStage) {
                case ConstantsAitBank.LOGIN_STAGE:
                    this.performLogin();
                    atmUI.initializeNewOperation();
                    break;                
                case ConstantsAitBank.SELECT_ACCOUNT_STAGE:
                    atmUI.updateGUI("Select an account to continue.");
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
        
        
        
        
    private void performLogin() {    
        
        try {
            DateTimeHelper dateHelper = new DateTimeHelper();
            Customer customer = new Customer();
            SavingsAccount savingsAccount = new SavingsAccount();            
            
            customer.setCustomerID(10012);
            customer.setName("Bob Dylan");
            savingsAccount.setAccountNumber(06541);
            savingsAccount.setBranchNumber(021);
            savingsAccount.setCustomer(atmUI.customerLogged);
            savingsAccount.setBalance(1000);
            savingsAccount.setDailyWithdrawLimit(100);
            savingsAccount.setDepositDate(dateHelper.generateDateFromString("01/08/2016 22:43"));
            savingsAccount.setInterestRate(0.001);
            
            atmUI.customerLogged = customer;
            atmUI.savingsAccount = savingsAccount; 
            
            atmUI.updateGUI("Welcome "+atmUI.customerLogged.getName()+
                    "\n Please select a account to start.");
            
        } catch (Exception ex) {
            atmUI.updateGUI("(ER104)System Error. \nContact the branch.");
            //Simulate the log
            System.out.println(ex.getMessage());
        }
    }
    
    
    
}
