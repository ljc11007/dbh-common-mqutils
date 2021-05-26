package com.tydic.mqutils.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFormat {
    private static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    public static String dateFormat(Date date){
        String format = "1970-01-02 08:00:00";
        if (date!=null){
            format = simpleDateFormat.format(date);
        }
        return format;
    }
}
