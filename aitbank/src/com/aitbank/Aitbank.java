package com.aitbank;

import com.aitbank.helper.DateTimeHelper;
import com.aitbank.model.Customer;
import com.aitbank.view.ChequeAccountView;
import com.aitbank.view.FixedAccountView;
import com.aitbank.view.NetSaverAccountView;
import com.aitbank.view.SavingsAccountView;

/**
 * The main class
 * @author 5399 - Kennedy Oliveira
 */
public class Aitbank {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Customer customer = new Customer();
        customer.setCustomerID(1);
        customer.setName("Bob");
        
        try {
        DateTimeHelper dateHelper = new DateTimeHelper();
        
       if (dateHelper.verifyIfDateTimeIsToday(dateHelper.generateDateFromString("28/08/2016 23:00")))
            System.out.println("Today");
       else
           System.out.println("NOT Today");
        
        } catch (Exception e){
            
        }
        ChequeAccountView chequeAccountView = new ChequeAccountView();
 //       chequeAccountView.ChequeAccountView(customer);
        
        SavingsAccountView savingsAccountView = new SavingsAccountView();
 //       savingsAccountView.SavingsAccountView(customer);
        
        NetSaverAccountView netSaverAccountView = new NetSaverAccountView();
 //       netSaverAccountView.NetSaverAccountView(customer);

        FixedAccountView fixedAccountView = new FixedAccountView();
//        fixedAccountView.FixedAccountView(customer);      


                




    }

}
