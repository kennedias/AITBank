package com.aitbank.model;

import com.aitbank.exception.IllegalATMMachineOperationException;

/**
 * This class represents the ATM Machine.
 * It contains also the related methods to manipulate the ATM Machine.
 *
 * @author 5399 - Kennedy Oliveira
 */
public class ATMMachine {
    private int note20;
    private int note50;
    private int note100;
    private int withdrawAmount;

    /**
     *ATMMachine class constructor.
     */
    public void ATMMachine() {
        note20=0;
        note50=0;
        note100=0;
        withdrawAmount=0;
    }

    /**
     * Print the total of each note given to the customer.
     */
    public void printGivenNotes() {
        System.out.println("\nThe total of notes to be delivered are:");
        System.out.println("Notes of 20...: " + this.note20);
        System.out.println("Notes of 50...: " + this.note50);
        System.out.println("Notes of 100..: " + this.note100);
    }
    
    /**
     * Make a account withdraw.
     * @param totalWithdraw double
     * @throws IllegalATMMachineOperationException
     */
    public void executeWithdraw(double totalWithdraw) throws IllegalATMMachineOperationException {

        withdrawAmount = (int) totalWithdraw;
        
        if (withdrawAmount < 20){
            throw new IllegalATMMachineOperationException("Withdraw amount is lower than $20.");
        }

        int remainder = 0;
        int division = 0;

        /** It will be deducting the note value depending on the division and
         * reminder values.
         * Example: For the amount of 60.00
         * It is possible be done only by 20 notes even know that the division
         * by 50 is possible. However if the ATM gets a 50 note for this 
         * withdraw there is not a 10 note to complete. As same for a withdraw
         * of 110.00. If the ATM gets a 100 note is not a 10 note to complete.
         * 
         * Always that a division it is possible and the remainder is greater
         * than zero a minor note value will be deducted.
         */
        while (true)
        {
            if (withdrawAmount >= 100) {
                division = withdrawAmount / 100;
                if (division >= 1){
                    remainder = withdrawAmount % 100;
                    if (remainder > 0){
                        remainder = withdrawAmount % 50;
                        if(remainder > 0){
                            deduct20FromWithdraw();
                        }else{
                            deduct50FromWithdraw();
                        }
                    }else{
                        deduct100FromWithdraw();
                    }
                }
            } else if (withdrawAmount >= 50){
                division = withdrawAmount / 50;
                if (division >= 1){
                    remainder = withdrawAmount % 50;
                    if(remainder > 0){
                        deduct20FromWithdraw();
                    }else{
                        deduct50FromWithdraw();
                    }
                }
            } else if (withdrawAmount >= 20){
                division = withdrawAmount / 20;
                if (division >= 1){
                    deduct20FromWithdraw();
               }
            }  
            if (withdrawAmount == 0 || withdrawAmount < 20) {
                break;
            } 
        }

        if (withdrawAmount != 0) {
            throw new IllegalATMMachineOperationException("Invalid withdraw combination amount.");
        }else{
            printGivenNotes();
        } 
    }    
    
    
    private void deduct20FromWithdraw(){
        note20++;
        withdrawAmount = withdrawAmount - 20;
    }
 
    private void deduct50FromWithdraw(){
        note50++;
        withdrawAmount = withdrawAmount - 50;
    }

    private void deduct100FromWithdraw(){
        note100++;
        withdrawAmount = withdrawAmount - 100;
    }
    
}
