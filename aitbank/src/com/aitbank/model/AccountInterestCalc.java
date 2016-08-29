/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aitbank.model;

import com.aitbank.exception.IllegalBankAccountOperationException;

/**
 * This class its a interface for accounts that pays interest.
 * It is to delegate to the classes that implements this interface 
 * that should be some methods related with interest issues.
 * Its is an example of use of interfaces for this reason it is not a abstract
 * method from BankAccountInterest class.
 *
 * @author 5399 - Kennedy Oliveira
 */
public interface AccountInterestCalc {
    
    /**
     * The updateActualBalanceWithInterest have to me implemented on the account
     * classes that pay interest.
     * Each class have your rule to pay interest.
     * @throws IllegalBankAccountOperationException
     */
    public void updateActualBalanceWithInterest() throws IllegalBankAccountOperationException;
   
}
