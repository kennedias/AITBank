/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aitbank.constants;

import java.text.SimpleDateFormat;

/**
 *
 * @author Kennedy
 */
public final class ConstantsAitBank {
    
    public static final String DATE_FORMAT_PATTERN = "dd/MM/yyyy HH:mm";
    public static final SimpleDateFormat SIMPLE_DATE_FORMAT_PATTERN = new SimpleDateFormat(DATE_FORMAT_PATTERN);

    public static final String ONLY_DATE_FORMAT_PATTERN = "dd/MM/yyyy";
    public static final SimpleDateFormat SIMPLE_DATE_FORMAT_PATTERN_ONLY_DATE = new SimpleDateFormat(ONLY_DATE_FORMAT_PATTERN);

    
}
