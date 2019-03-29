/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.console.test;

import java.io.File;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.List;
import java.util.TimeZone;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.commons.lang.StringUtils;

/**
 *
 * @author DSB
 */
public class App {
    
    private App(){
        
    }
    
    public static String getFormattedHour(int rawOffSet) {
        Double hours = rawOffSet / (3600*1000*1.0);
        int hour = hours.intValue();
        long minutes = Math.abs(Math.round((hours-hour) * 60));
        DecimalFormat df = new DecimalFormat("00");        
        return df.format(hour) + ":" + df.format(minutes);
    }
    
    public static void test(){
        String codigo = "1|206|2018-08-15";
        String[] output = codigo.split("\\|");
        System.out.println("output: " + output.length);
        /*
        TimeZone timeZone = TimeZone.getDefault();
        System.out.println("getDisplayName: " + timeZone.getDisplayName());
        System.out.println("getID: " + timeZone.getID());
        System.out.println("getOffset: " + timeZone.getOffset(System.currentTimeMillis()) / (3600*1000*1.0));
        System.out.println("getRawOffset: " + timeZone.getRawOffset() / (3600*1000*1.0));
        System.out.println("getRawOffset cad: " + getFormattedHour(timeZone.getRawOffset()));
        
        System.out.println("");
        
        TimeZone tz = TimeZone.getTimeZone("America/St_Johns");
        System.out.println("getDisplayName2: " + tz.getDisplayName());
        System.out.println("getID2: " + tz.getID());
        System.out.println("getOffset2: " + tz.getOffset(System.currentTimeMillis()) / (3600*1000*1.0));
        System.out.println("getRawOffset2: " + tz.getRawOffset() / (3600*1000*1.0));
        System.out.println("getRawOffset2 cad: " + getFormattedHour(tz.getRawOffset()));
        
        System.out.println("");
        */
        
        // compares two Integer objects numerically
        Integer obj1 = new Integer("25");
        Integer obj2 = new Integer("25");
        int retval =  obj1.compareTo(obj2);
        System.out.println("retval: " + retval);
        if(retval > 0) {
            System.out.println("obj1 is greater than obj2");
        }
        else if(retval < 0) {
            System.out.println("obj1 is less than obj2");
        }
        else {
            System.out.println("obj1 is equal to obj2");
        }
                
        String code;
        List<String> list;
        code = "029392";
        list = Arrays.asList(code.split("-"));
        System.out.println("list1: " + list.toString());
        
        code = "148032-151003-152420-152434-152435-152436-152442";
        list = Arrays.asList(code.split("-"));
        System.out.println("list2: " + list.toString());
        
        String join = StringUtils.join(list, "-");
        System.out.println("join: " + join);
        
        String[] words = {"ace", "boom", "crew", "dog", "eon"};
        List<String> wordList = Arrays.asList(words);  
        for (String e : wordList)
        {
           System.out.println(e);
        }
        
        byte error = -1;
        System.out.println("byte: " + error);
        System.out.println("Inicio de test de files");
        String path = "/DATA/applications/utilBusinessServices/reports/reclamos/busqueda/";
        System.out.println(path);
        System.out.println(new File(path).getAbsoluteFile());
        System.out.println(new File(path).getAbsolutePath());
    }

    public static void main(String[] args) {
        testPattern();
        String cad = "VMX_CUOTA :: No se tiene cuota de bombas para metodo de programacion tradicional";
        if (cad.startsWith("VMX_CUOTA")) {
            System.out.println("OK");
            String[] parts = cad.split(" :: ");
            System.out.println("Result: " + parts[1]);
        } else {
            System.out.println("BAD");
        }
    }
    
    public static void testPattern() {
        // https://stackoverflow.com/questions/4662215/how-to-extract-a-substring-using-regex
        String cadPattern = "\\/[v]\\d+\\/";
        Pattern p = Pattern.compile(cadPattern);
        String url; Matcher m;
        
        url = "/api_mobile/rest/v3/seguridad/refresh";
        m = p.matcher(url);
        if (m.find()) {
            System.out.println("" + m.group(0));
        }
        
        url = "/api_mobile/rest/v30/seguridad/login";
        m = p.matcher(url);
        if (m.find()) {
            System.out.println("" + m.group(0));
        }
        
        url = "/api_mobile/rest/v434/seguridad/login";
        m = p.matcher(url);
        if (m.find()) {
            System.out.println("" + m.group(0));
        }
        
        url = "/api_mobile/rest/v3k/seguridad/refresh";
        m = p.matcher(url);
        if (m.find()) {
            System.out.println("" + m.group(0));
        } else {
            System.out.println("No encontrado");
        }
    }
}
