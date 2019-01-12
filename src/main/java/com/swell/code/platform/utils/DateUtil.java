package com.swell.code.platform.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {

    public static final class PatternTypes {
        public static final String date = "yyyy-MM-dd";
        public static final String datetime = "yyyy-MM-dd HH:mm:ss:S";
        public static final String datetime_compact = "yyyyMMddHHmmss";

        public static final String month = "yyyy-MM";
    }

    public static Date currentTime() {
        return new Date();
    }

    public static Date str2date(String source, String pattern) {
        Date date = null;
        try {
            SimpleDateFormat sdf = new SimpleDateFormat(pattern);
            date = sdf.parse(source);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    public static Date str2date(String source) {
        return str2date(source, PatternTypes.date);
    }

    public static String date2str(Date date) {
        return date2str(date, PatternTypes.date);
    }

    public static String date2str(Date date, String pattern) {
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        return sdf.format(date);
    }

    public static String formatNow(String pattern) {
        return date2str(currentTime(), pattern);
    }

    public static String getLastMonth() {
        Calendar c = Calendar.getInstance();
        c.add(Calendar.MONTH, -1);
        return date2str(c.getTime(), PatternTypes.month);
    }

    public static String getYesterday() {
        Calendar c = Calendar.getInstance();
        c.add(Calendar.DAY_OF_MONTH, -1);
        return date2str(c.getTime(), PatternTypes.date);
    }

    public static String getDayBefore(int num) {
        Calendar c = Calendar.getInstance();
        c.add(Calendar.DAY_OF_MONTH, 0 - num);
        return date2str(c.getTime(), PatternTypes.date);
    }

    public static void main(String[] args) {
        String a = "关于010098";
        int len = a.split("").length;
        System.out.println(a.substring(len - 6));
        System.out.println(a.substring(0, len - 6));

    }

}
