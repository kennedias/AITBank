/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aitbank;

import com.aitbank.helper.DateTimeHelper;
import com.aitbank.model.Customer;
import com.aitbank.model.SavingsAccount;
import org.joda.time.DateTime;

/**
 *
 * @author 5399
 */
public class Aitbank {

    /**
     * @param args the command line arguments
     */
   public static void main(String[] args) {

String dateStart = "24/08/2016 00:00";
String dateStop = "10/08/2016 24:00";

try {
   
    DateTimeHelper dateHelper = new DateTimeHelper();
    
    DateTime dt1 = dateHelper.generateDateFromString(dateStart);
    DateTime dt2 = dateHelper.generateDateFromString(dateStop);
    

    Customer customer = new Customer();
    
    customer.setCustomerID(1);
    customer.setName("Bob");
    
    SavingsAccount savings = new SavingsAccount();
    savings.setCustomer(customer);
    savings.setAccountNumber(123);
    savings.setBranchNumber(99);
    savings.setBalance(100.00);
    savings.setDepositDate(dt1);
    savings.setInterestRate(0.10);
    savings.showAccountDetails();
    
    System.out.println("\n");
    System.out.println("Updating balance with account interest of the period... ");
    
    savings.updateActualBalanceWithInterest();
    savings.showAccountDetails();
    
    System.out.println("\n");
    
    System.out.println("Making a deposit and updating with account interest of the period... ");
    savings.makeAccountDeposit(100.0);
    savings.updateActualBalanceWithInterest();
    savings.showAccountDetails();
    
 } catch (Exception e) {
    e.printStackTrace();
 }

}
    
}
    