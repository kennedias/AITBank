/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aitbank.exception;

/**
 *
 * @author Kennedy
 */
public class IllegalBankAccountOperationException extends Exception{
    public IllegalBankAccountOperationException(String message){
        super("This transaction can not be completed. " + message);
    }
}
