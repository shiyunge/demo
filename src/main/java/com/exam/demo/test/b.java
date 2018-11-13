package com.exam.demo.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by syg on ${Date}
 */
public class b {

    public static void main(String[] args) {
        Calendar c = Calendar.getInstance();
        c.setTime(new Date());
        c.add(Calendar.DATE, 14);
        Date date = c.getTime();
        System.out.println(date);

        String date1 = "2017-10";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM");
        try {
            System.out.print(simpleDateFormat.parse(date1));
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

}
