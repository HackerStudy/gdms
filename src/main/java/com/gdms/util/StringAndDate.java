package com.gdms.util;

import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;

public class StringAndDate {
    public static Date stringToDate(String s){
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        ParsePosition pos = new ParsePosition(0);//指向String转换为Date()时的索引位置
        Date date = format.parse(s,pos);
        return date;
    }

    public static String dateToString(Date date){
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String time =format.format(date);
        return time;
    }
}
