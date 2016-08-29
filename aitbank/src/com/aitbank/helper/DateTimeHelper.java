package com.aitbank.helper;

import com.aitbank.constants.ConstantsAitBank;
import java.text.ParseException;
import org.joda.time.DateTime;
import org.joda.time.Days;
import org.joda.time.Months;

/**
 * This class encapsulates all issues related with dates.
 * All date treatment should be done here.
 * Also gives any transparency of what component is used for deal with dates
 * and in this case should generate less reworking if a component change is 
 * necessary to be done.
 * @author Kennedy
 */
public class DateTimeHelper {
    
    /**
     * Generate a DateTime object from a String formated date.
     * @param dateString
     * @return DateTime
     * @throws ParseException
     */
    public DateTime generateDateFromString(String dateString) throws ParseException{
        DateTime dateTime = new DateTime(ConstantsAitBank.SIMPLE_DATE_FORMAT_PATTERN.parse(dateString));
        return dateTime;
    }
    
    /**
     * Generate a DateTime object with the actual Date and Time
     * @return DateTime
     */
    public DateTime getActualDateAndTime()
    {
        return new DateTime();
    }
    
    /**
     * Calculate the amount of days between two DateTime objects.
     * It consider also the time to count or not a day.
     * @param initialDate
     * @param finalDate
     * @return daysBetween
     */
    public double calculateDaysBetweenDates(DateTime initialDate, DateTime finalDate){
        double daysBetween = Days.daysBetween(initialDate, finalDate).getDays();
        return daysBetween;
    }

    /**
     * Calculate the amount of months between two DateTime objects.
     * @param initialDate
     * @param finalDate
     * @return monthsBetween
     */
    public double calculateMonthsBetweenDates(DateTime initialDate, DateTime finalDate){
        double monthsBetween = Months.monthsBetween(initialDate, finalDate).getMonths();
        return monthsBetween;
    }

    /**
     * Generate a String from a DateTime object.
     * @param dateTime
     * @return String
     */
    public String getDatetimeToString(DateTime dateTime){
        return dateTime.toString(ConstantsAitBank.DATE_FORMAT_PATTERN);
    }
    
    /**
     * Verify if the DateTime received is Today.
     * @param dateTime
     * @return boolean
     */
    public boolean verifyIfDateTimeIsToday(DateTime dateTime){
        boolean isToday = false;
        DateTime actualDateTime = getActualDateAndTime();
        double daysBetween = calculateDaysBetweenDates(actualDateTime,dateTime );
        
        if (daysBetween == 0 ){
            isToday = true;
        } 
        return isToday;
    }
}
