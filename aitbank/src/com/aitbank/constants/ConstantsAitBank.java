package com.aitbank.constants;

import java.text.SimpleDateFormat;

/**
 * Constants class for AitBank project.
 * 
 * @author 5399 - Kennedy Oliveira
 */
public final class ConstantsAitBank {
    
    public static final String DATE_FORMAT_PATTERN = "dd/MM/yyyy HH:mm";
    public static final SimpleDateFormat SIMPLE_DATE_FORMAT_PATTERN = new SimpleDateFormat(DATE_FORMAT_PATTERN);

    public static final String ONLY_DATE_FORMAT_PATTERN = "dd/MM/yyyy";
    public static final SimpleDateFormat SIMPLE_DATE_FORMAT_PATTERN_ONLY_DATE = new SimpleDateFormat(ONLY_DATE_FORMAT_PATTERN);

    public static final int LOGIN_STAGE = 0;
    public static final int SELECT_ACCOUNT_STAGE = 1;
    public static final int SELECT_ACCOUNT_OPERATION_STAGE = 2;
    public static final int INPUT_OPERATION_AMOUNT_STAGE = 3;
    public static final int CONFIRM_CANCEL_STAGE = 4;
    
    public static final String LOGIN_OPERATION = "Login";
    public static final String LOGOUT_OPERATION = "Logout";
    
    public static final String CONFIRM_OPERATION = "Confirm";
    public static final String CANCEL_OPERATION = "Cancel";
    
    public static final String SAVINGS_ACCOUNT = "Savings";
    public static final String NET_ACCOUNT = "Net";
    public static final String FIXED_ACCOUNT = "Fixed";
    public static final String CHEQUE_ACCOUNT = "Cheque";
    
    public static final String BALANCE_OPERATION = "Balance";
    public static final String WITHDRAW_OPERATION = "Withdraw";
    public static final String DEPOSIT_OPERATION = "Deposit";
    public static final String WITHDRAWLIMIT_OPERATION = "Withdraw Daily Limit";
        
   
    
    
}
