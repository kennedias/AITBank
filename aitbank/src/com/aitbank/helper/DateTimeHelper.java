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
    
    public DateTime getActualDateAndTime()
    {
        return new DateTime();
    }
    
   public double calculateDaysBetweenDates(DateTime initialDate, DateTime finalDate){
        double daysBetween = Days.daysBetween(initialDate, finalDate).getDays();
        return daysBetween;
    }

    public double calculateMonthsBetweenDates(DateTime initialDate, DateTime finalDate){
        double daysBetween = Months.monthsBetween(initialDate, finalDate).getMonths();
        return daysBetween;
    }

    public String getDatetimeToString(DateTime dateTime){
        return dateTime.toString(ConstantsAitBank.DATE_FORMAT_PATTERN);
        
    }
    
    public boolean verifyDatetimeIsToday(DateTime dateTime){
        
        DateTime actualDateTime = getActualDateAndTime();
        double daysBetween = Days.daysBetween(actualDateTime, dateTime).getDays();
        
        if (daysBetween == 0 ){
            return true;
        } else {
            return false;
        }
        
    }
}
