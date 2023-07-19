package co.com.metro.civicaweb.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class CalculateDate {

    public static String calculatePreviousDay()
    {
        Calendar calendar = Calendar.getInstance();
        calendar.add (Calendar.DATE, -1);
        Date date = calendar.getTime();
        DateFormat dateFormat = new SimpleDateFormat("/ddMMyyyy/");

        return dateFormat.format(date);
    }

    public static String calculateNextDay()
    {
        Calendar calendar = Calendar.getInstance();
        calendar.add (Calendar.DATE, +1);
        Date date = calendar.getTime();
        DateFormat dateFormat = new SimpleDateFormat("/ddMMyyyy/");

        return dateFormat.format(date);
    }

}
