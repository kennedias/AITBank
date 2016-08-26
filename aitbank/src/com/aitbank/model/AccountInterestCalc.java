/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aitbank.model;

/**
 *
 * @author 5399
 */
public interface AccountInterestCalc {
    
    public void setInterestRate(double interestRate);
    public double calculateAccountInterest();
    
}
