package com.aitbank.view;

import com.aitbank.helper.DateTimeHelper;
import com.aitbank.model.ChequeAccount;
import com.aitbank.model.Customer;


/**
 * Simulates the view layer actions performing Cheque Account operations.
 * @author 5399 - Kennedy Oliveira
 */
public class ChequeAccountView {
    
    public void ChequeAccountView(Customer customer){
        
        try {
            DateTimeHelper dateHelper = new DateTimeHelper();

            
            System.out.println("\n==========================================");
            System.out.println("Creating Cheque Account... ");
            
            ChequeAccount chequeAccount = new ChequeAccount();
            
            chequeAccount.setCustomer(customer);
            chequeAccount.setAccountNumber(123);
            chequeAccount.setBranchNumber(99);
            chequeAccount.setBalance(100.00);
            //chequeAccount.setDepositDate(dateHelper.generateDateFromString("27/06/2016 00:00"));
            
            chequeAccount.makeAccountDeposit(100);
            
            
            chequeAccount.showAccountDetails();
//        } catch (ParseException ex) {
//            Logger.getLogger(ChequeAccountView.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            
        }
         
    }
    
}
