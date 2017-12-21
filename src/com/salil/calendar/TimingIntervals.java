package com.salil.calendar;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

/**
 * Created by Salil on 14/07/17.
 */
public class TimingIntervals {

  public static void main(String args []){
      Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("IST"));
      calendar.setTimeInMillis(System.currentTimeMillis());
      int year = calendar.get(Calendar.YEAR);
      int month = calendar.get(Calendar.MONTH);
      int day = calendar.get(Calendar.DAY_OF_MONTH);
      int hours = calendar.get(Calendar.HOUR_OF_DAY);
      int minutes = calendar.get(Calendar.MINUTE);
      String bn = "00";
      int bc = Integer.parseInt(bn);

      System.out.println("Current Hour : "+ hours);
      System.out.println("Current Minute : "+minutes);
      System.out.println("Current Day : "+day);
      System.out.println("Current Month : "+month);
      System.out.println("Current Year : "+year);
      System.out.println("Current BC : "+bc);
      System.out.println(calendar.getTimeInMillis());
      SimpleDateFormat formatter00 = new SimpleDateFormat("dd-MM-yyyy hh:mm");
      System.out.println( "formatter  :  " + formatter00.format(calendar.getTime()));


      Date date = new Date();
      System.out.println("Cuurent Datea : "+date);
      SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
      String strDate = formatter.format(date);
      System.out.println("Date Format with MM/dd/yyyy : "+strDate);

      formatter = new SimpleDateFormat("dd-MM-yyyy hh:mm");
      strDate = formatter.format(date);
      System.out.println("Date Format with dd-M-yyyy hh:mm:ss : "+strDate);

      formatter = new SimpleDateFormat("dd MMMM yyyy");
      strDate = formatter.format(date);
      System.out.println("Date Format with dd MMMM yyyy : "+strDate);

      formatter = new SimpleDateFormat("dd MMMM yyyy zzzz");
      strDate = formatter.format(date);
      System.out.println("Date Format with dd MMMM yyyy zzzz : "+strDate);

      formatter = new SimpleDateFormat("E, dd MMM yyyy HH:mm:ss z");
      strDate = formatter.format(date);
      System.out.println("Date Format with E, dd MMM yyyy HH:mm:ss z : "+strDate);
  }


}


