package com.aitbank;

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
        
        System.out.println("\n------------------------- Cheque Account ----------"
                + "------------------------------");
        ChequeAccountView chequeAccountView = new ChequeAccountView();
        chequeAccountView.ChequeAccountView(customer);

        System.out.println("\n------------------------- Savings Account ---------"
                + "-------------------------------");        
        SavingsAccountView savingsAccountView = new SavingsAccountView();
        savingsAccountView.SavingsAccountView(customer);
        
        System.out.println("\n------------------------- Net-Saver Account --------"
                + "--------------------------------");
        NetSaverAccountView netSaverAccountView = new NetSaverAccountView();
        netSaverAccountView.NetSaverAccountView(customer);

        System.out.println("\n------------------------- Fixed Account --------"
                + "--------------------------------");
        FixedAccountView fixedAccountView = new FixedAccountView();
        fixedAccountView.FixedAccountView(customer);      

    }

}
