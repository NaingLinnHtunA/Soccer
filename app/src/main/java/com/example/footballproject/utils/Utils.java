package com.example.footballproject.utils;


import java.text.DateFormat;
import java.text.DateFormatSymbols;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public class Utils
{
    public static String DateToTimeFormat(String oldstringDate) {
        //PrettyTime p = new PrettyTime(new Locale(getCountry()));
        String isTime = null;
        String newDate,Date;

        try {

            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'",Locale.getDefault());
            sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
            Date = sdf.parse(oldstringDate)+"";
            newDate = Date;
            SimpleDateFormat dateParser = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy");
            Date date = dateParser.parse(Date);
            SimpleDateFormat dateFormatter = new SimpleDateFormat("EEE, MMM dd, yyyy, hh:mm aa");
            return dateFormatter.format(date);

        } catch (Exception e) {
            e.printStackTrace();
            newDate = oldstringDate;

        }

        return newDate;

    }

    public static String DateFormat(String oldstringDate) {

        String newDate,Date;
        //SimpleDateFormat dateFormat = new SimpleDateFormat("hh:mm a");
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'",Locale.getDefault());
            sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
            Date = sdf.parse(oldstringDate)+"";
            newDate = Date;
            SimpleDateFormat dateParser = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy");
            Date date = dateParser.parse(Date);
            SimpleDateFormat dateFormatter = new SimpleDateFormat("hh : mm a");
            return dateFormatter.format(date);

        } catch (ParseException e) {
            e.printStackTrace();
            newDate = oldstringDate;
        }
        return newDate;
    }

    public static String getCountry() {

        Locale locale = Locale.getDefault();
        String country = String.valueOf(locale.getCountry());
        return country.toLowerCase();

    }


    public static String getLanguage() {
        Locale locale = Locale.getDefault();
        String country = String.valueOf(locale.getLanguage());
        return country.toLowerCase();
    }


}