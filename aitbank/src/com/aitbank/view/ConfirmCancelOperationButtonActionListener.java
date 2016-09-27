package com.aitbank.view;

import com.aitbank.constants.ConstantsAitBank;
import com.aitbank.exception.IllegalBankAccountOperationException;
import com.aitbank.helper.DateTimeHelper;
import com.aitbank.model.ATMMachine;
import com.aitbank.model.Customer;
import com.aitbank.model.SavingsAccount;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
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
        if (confirmCancelOperationButton.equals(ConstantsAitBank.CONFIRM_OPERATION))
        {
            atmUI.clearTextPanelGUI();
            atmUI.line = atmUI.accountType + " " + atmUI.accountOperation + " " + atmUI.amountOperation;
            atmUI.updateGUI();
            
            try {
                DateTimeHelper dateHelper = new DateTimeHelper();
                ATMMachine atmMachine = new ATMMachine();
            
                System.out.println("\n==========================================");
                System.out.println("Creating Savings Account... ");
            
                Customer customer = new Customer();
                customer.setCustomerID(1);
                customer.setName("Bob");
                
                switch (atmUI.accountType) {
                    case ConstantsAitBank.SAVINGS_ACCOUNT:  
                        
                        break;
                    default: atmUI.accountType = "Invalid month";
                        break;
                }
                
                SavingsAccount savings = new SavingsAccount();
            
                savings.setCustomer(customer);
                savings.setAccountNumber(123);
                savings.setBranchNumber(99);
                savings.setBalance(100);
                
                savings.setDepositDate(dateHelper.generateDateFromString("01/08/2016 22:43"));
                savings.setInterestRate(0.001);
                savings.setDailyWithdrawLimit(200);
                savings.showAccountDetails();
                savings.updateActualBalanceWithInterest();
            } catch (IllegalBankAccountOperationException ex) {
                System.out.println(ex.getMessage());
            } catch (ParseException ex) {
                Logger.getLogger(ConfirmCancelOperationButtonActionListener.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else{
            try {
                atmUI.clearTextPanelGUI();
                atmUI.line = "Operation Canceled. \n";
                atmUI.updateGUI();
                atmUI.stage = ConstantsAitBank.SELECT_ACCOUNT_STAGE;
            } catch (Exception ex) {
                atmUI.line = "System Error. Please contact the branch. \n";
                atmUI.updateGUI();
            }
        }

    }
         
}
