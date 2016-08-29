package com.aitbank.view;

import com.aitbank.helper.DateTimeHelper;
import com.aitbank.model.Customer;
import com.aitbank.model.NetSaverAccount;

/**
 * Simulates the view layer actions performing Net-Saver Account operations.
 * @author 5399 - Kennedy Oliveira
 */
public class NetSaverAccountView {
   
    public void NetSaverAccountView(Customer customer){

        try {
            DateTimeHelper dateHelper = new DateTimeHelper();
            
            System.out.println("\n==========================================");
            System.out.println("Creating Net-Saver Account... ");

            NetSaverAccount netSaver = new NetSaverAccount();
            
            netSaver.setCustomer(customer);
            netSaver.setAccountNumber(123);
            netSaver.setBranchNumber(99);
            netSaver.setBalance(100.00);
            netSaver.setDepositDate(dateHelper.generateDateFromString("27/06/2016 00:00"));
            netSaver.setInterestRate(0.10);
            netSaver.showAccountDetails();

            System.out.println("\nUpdating balance with account interest of the period... ");

            netSaver.updateActualBalanceWithInterest();
            netSaver.showAccountDetails();

            System.out.println("\nMaking a deposit and updating with account interest of the period... ");
            netSaver.makeAccountDeposit(100.0);
            netSaver.updateActualBalanceWithInterest();

            netSaver.showAccountDetails();

        } catch (Exception e) {
            e.printStackTrace();
        }
     
    }
    
    
    
}
