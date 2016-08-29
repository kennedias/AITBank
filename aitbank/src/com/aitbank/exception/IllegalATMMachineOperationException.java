package com.aitbank.exception;

/**
 * This exception handle with invalid ATM Machine operations.
 * This is a business exception.
 * 
 * @author 5399 - Kennedy Oliveira
 */
public class IllegalATMMachineOperationException extends Exception{
    public IllegalATMMachineOperationException(String message){
        super("IllegalATMMachineOperationException: " + message);
    }
}
