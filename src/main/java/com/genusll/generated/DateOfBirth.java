package com.genusll.generated;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class DateOfBirth {
    public String generatedDateOfBirth(){
        GregorianCalendar gc = new GregorianCalendar();
        int year = randBetween(1980, 2000);
        gc.set(Calendar.YEAR, year);
        int dayOfYear = randBetween(1, gc.getActualMaximum(Calendar.DAY_OF_YEAR));
        gc.set(Calendar.DAY_OF_YEAR, dayOfYear);
        String mm_dd = checkMonthAndDay(gc.get(Calendar.MONTH) + 1, gc.get(Calendar.DAY_OF_MONTH));
        return gc.get(Calendar.YEAR) + "-" + mm_dd;
    }
    private static int randBetween(int start, int end) {
        return start + (int)Math.round(Math.random() * (end - start));
    }
    private String checkMonthAndDay(int monthTemp, int dayTemp){
        String month = "";
        String day = "";
        if (monthTemp < 10) month = "0"+monthTemp;
        else month = String.valueOf(monthTemp);
        if (dayTemp < 10) day = "0"+dayTemp;
        else day = String.valueOf(dayTemp);
        return month + "-" + day;
    }
}



