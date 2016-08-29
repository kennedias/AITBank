package com.aitbank.exception;

/**
 * This exception handle with invalid account operations.
 * This is a business exception.
 * 
 * @author 5399 - Kennedy Oliveira
 */
public class IllegalBankAccountOperationException extends Exception{
    public IllegalBankAccountOperationException(String message){
        super("IllegalBankAccountOperationException: " + message);
    }
}
