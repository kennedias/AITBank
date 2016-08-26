/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aitbank;

import com.aitbank.constants.ConstantsAitBank;
import com.aitbank.helper.DateTimeHelper;
import com.aitbank.model.Customer;
import com.aitbank.model.SavingsAccount;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import org.joda.time.DateTime;
import org.joda.time.Days;
import org.joda.time.Hours;
import org.joda.time.Minutes;
import org.joda.time.Months;
import org.joda.time.Weeks;
import org.joda.time.Years;

/**
 *
 * @author 5399
 */
public class Aitbank {

    /**
     * @param args the command line arguments
     */
   public static void main(String[] args) {

String dateStart = "01/08/2016 00:00";
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
    savings.setInterestRate(1.00);
       
    double value = savings.calculateAccountInterest();
    System.out.println(" Interest Amount : " + String.valueOf(value) );
    
    savings.showAccountDetails();
    
 } catch (Exception e) {
    e.printStackTrace();
 }

}
    
}
    