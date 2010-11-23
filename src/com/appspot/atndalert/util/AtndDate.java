package com.appspot.atndalert.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AtndDate {

    public static String getDateString(Date date){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy'”N'MM'ŒŽ'dd'“ú'");
        return sdf.format(date);
    }
    
    public static String getDateString(String dateStr){
        Date date = getDate(dateStr);
        return getDateString(date);
    }
    
    private static Date getDate(String dateStr) {
        Date value = null;
        if (dateStr == null || dateStr.equals(""))
            return null;
        try {
            SimpleDateFormat sdf = new SimpleDateFormat();
            sdf.applyPattern("yyyy-MM-dd'T'HH:mm:ssZ");
            // escape SimpleDateFormat unsupported ISO8601 problem
            String noColon = "";
            noColon += dateStr.substring(0, 22);
            noColon += dateStr.substring(23);
            value = sdf.parse(noColon);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return value;
    }

}
