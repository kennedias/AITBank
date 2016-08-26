/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aitbank.helper;

import com.aitbank.constants.ConstantsAitBank;
import java.text.ParseException;
import org.joda.time.DateTime;
import org.joda.time.Days;
import org.joda.time.Months;

/**
 *
 * @author Kennedy
 */
public class DateTimeHelper {
    

    public DateTime generateDateFromString(String dateString) throws ParseException{
        DateTime dateTime = new DateTime(ConstantsAitBank.SIMPLE_DATE_FORMAT_PATTERN.parse(dateString));
        return dateTime;
    }
    
    public int calculateDaysBetweenDates(DateTime initialDate, DateTime finalDate){
        int daysBetween = Days.daysBetween(initialDate, finalDate).getDays();
        return daysBetween;
    }

        public int calculateMonthsBetweenDates(DateTime initialDate, DateTime finalDate){
        int daysBetween = Months.monthsBetween(initialDate, finalDate).getMonths();
        return daysBetween;
    }


}
