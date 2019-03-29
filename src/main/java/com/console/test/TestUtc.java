/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.console.test;

import java.text.DecimalFormat;
import java.util.TimeZone;

/**
 *
 * @author Anton
 */
public class TestUtc {
    
    public static String getFormattedHour(int rawOffSet) {
        Double hours = rawOffSet / (3600*1000*1.0);
        int hour = hours.intValue();
        long minutes = Math.abs(Math.round((hours-hour) * 60));
        DecimalFormat df = new DecimalFormat("00");
        return (hour >= 0 ? "+" : "") + df.format(hour) + ":" + df.format(minutes);
    }
    
    public static void main(String[] args) {
        TimeZone timeZone = TimeZone.getDefault();
        System.out.println("getDisplayName: " + timeZone.getDisplayName());
        System.out.println("getID: " + timeZone.getID()); // 'America/Lima'
        System.out.println("getRawOffset: " + timeZone.getRawOffset() / (3600*1000*1.0));
        System.out.println("getRawOffset formatted: " + getFormattedHour(timeZone.getRawOffset()));
        
        System.out.println("");
        
        TimeZone tz = TimeZone.getTimeZone("America/St_Johns");
        System.out.println("getDisplayName2: " + tz.getDisplayName());
        System.out.println("getID2: " + tz.getID());
        System.out.println("getRawOffset2: " + tz.getRawOffset() / (3600*1000*1.0));
        System.out.println("getRawOffset2 formatted: " + getFormattedHour(tz.getRawOffset()));
        
        System.out.println("");
        
        tz = TimeZone.getTimeZone("Asia/Kolkata");
        System.out.println("getDisplayName3: " + tz.getDisplayName());
        System.out.println("getID3: " + tz.getID());
        System.out.println("getRawOffset3: " + tz.getRawOffset() / (3600*1000*1.0));
        System.out.println("getRawOffset3 formatted: " + getFormattedHour(tz.getRawOffset()));
        
        System.out.println("");
        
        tz = TimeZone.getTimeZone("UTC");
        System.out.println("getDisplayName4: " + tz.getDisplayName());
        System.out.println("getID4: " + tz.getID());
        System.out.println("getRawOffset4: " + tz.getRawOffset() / (3600*1000*1.0));
        System.out.println("getRawOffset4 formatted: " + getFormattedHour(tz.getRawOffset()));
        
        System.out.println("");
    }
}
