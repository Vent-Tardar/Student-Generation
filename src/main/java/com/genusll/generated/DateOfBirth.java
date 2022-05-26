package com.genusll.generated;

import java.time.LocalDate;

public class DateOfBirth {
    public LocalDate generatedDateOfBirth(){
        return createRandomDate();
    }

    private static int createRandomIntBetween(int start, int end) {
        return start + (int) Math.round(Math.random() * (end - start));
    }

    private static LocalDate createRandomDate() {
        int day = createRandomIntBetween(1, 28);
        int month = createRandomIntBetween(1, 12);
        int year = createRandomIntBetween(1970, 2000);
        return LocalDate.of(year, month, day);
    }
//    public String generatedDateOfBirth(){
//        GregorianCalendar gc = new GregorianCalendar();
//        int year = randBetween(1980, 2000);
//        gc.set(Calendar.YEAR, year);
//        int dayOfYear = randBetween(1, gc.getActualMaximum(Calendar.DAY_OF_YEAR));
//        gc.set(Calendar.DAY_OF_YEAR, dayOfYear);
//        String mm_dd = checkMonthAndDay(gc.get(Calendar.MONTH) + 1, gc.get(Calendar.DAY_OF_MONTH));
//        return gc.get(Calendar.YEAR) + "-" + mm_dd;
//    }
//    private static int randBetween(int start, int end) {
//        return start + (int)Math.round(Math.random() * (end - start));
//    }
//    private String checkMonthAndDay(int monthTemp, int dayTemp){
//        String month = "";
//        String day = "";
//        if (monthTemp < 10) month = "0"+monthTemp;
//        else month = String.valueOf(monthTemp);
//        if (dayTemp < 10) day = "0"+dayTemp;
//        else day = String.valueOf(dayTemp);
//        return month + "-" + day;
//    }
}



