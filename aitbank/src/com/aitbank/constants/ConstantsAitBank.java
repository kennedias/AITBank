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

    
}
