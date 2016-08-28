package com.aitbank;

import com.aitbank.model.Customer;
import com.aitbank.view.ChequeAccountView;
import com.aitbank.view.FixedAccountView;
import com.aitbank.view.NetSaverAccountView;
import com.aitbank.view.SavingsAccountView;

/**
 *
 * @author 5399
 */
public class Aitbank {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Customer customer = new Customer();
        customer.setCustomerID(1);
        customer.setName("Bob");
        
        ChequeAccountView chequeAccountView = new ChequeAccountView();
        chequeAccountView.ChequeAccountView(customer);
        
        SavingsAccountView savingsAccountView = new SavingsAccountView();
        savingsAccountView.SavingsAccountView(customer);
        
        NetSaverAccountView netSaverAccountView = new NetSaverAccountView();
        netSaverAccountView.NetSaverAccountView(customer);

        FixedAccountView fixedAccountView = new FixedAccountView();
        fixedAccountView.FixedAccountView(customer);        
                

    }

}
