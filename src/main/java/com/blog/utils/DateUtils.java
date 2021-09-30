package com.blog.utils;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
  
    
    public static Date getCur() {
    	long millis=System.currentTimeMillis();   
        java.sql.Date date=new java.sql.Date(millis);   
        System.out.println(date); 
        return date;
    }
    
    public static Date getCurHH() {
    	Date now = new Date();
        return now;
    }
    
    public static String getTime() {
    	DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
    	Date date = new Date();
    	System.out.println(dateFormat.format(date));
		return dateFormat.format(date);
    }
    
   // public static String dateDisplay(String date) throws ParseException { 
//    	Format formatter = new SimpleDateFormat("dd/MM/yyyy");
//    	String s = formatter.format(date);
//    	System.out.println(s);
//		return s;
    	
//    	Date myDate = new Date();
//        System.out.println(myDate);
//
//        SimpleDateFormat mdyFormat = new SimpleDateFormat("MM-dd-yyyy");
//        SimpleDateFormat dmyFormat = new SimpleDateFormat("yyyy-MM-dd");
//
//        // Format the date to Strings
//        String mdy = mdyFormat.format(date);
//        String dmy = dmyFormat.format(date);
//
//        // Results...
//        System.out.println(mdy);
//        System.out.println(dmy);
//		return mdy;
    	
//    	 SimpleDateFormat df=new SimpleDateFormat("dd/MM/yyyy");
//    	    System.out.println(df.format(date));
//    	    String s=df.format(date);
//    	    return s;
    	
//    	DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy");
//    	LocalDate localDate =  LocalDate.parse(date, format);
//    	        
//    	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEEE, MMM d, yyyy",Locale.forLanguageTag("sw-TZ"));
//    	System.out.println(localDate.format(formatter));
//		return date;
    //}
    
    

    
    
}
