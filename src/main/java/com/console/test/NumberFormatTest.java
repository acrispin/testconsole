/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.console.test;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.util.Locale;

/**
 *
 * @author acrispin
 */
public class NumberFormatTest {
    
    private static void f1(double num, char groupS, char decimalS) {
        DecimalFormatSymbols simbolo = new DecimalFormatSymbols();
        simbolo.setGroupingSeparator(groupS);
        simbolo.setDecimalSeparator(decimalS);
        NumberFormat formatter = new DecimalFormat("#,##0.00", simbolo);
        formatter.setGroupingUsed(true);
        System.out.println("F1: " + formatter.format(num));
    }
    
    
    public static void main(String[] args) {
        
        DecimalFormatSymbols symbols = new DecimalFormatSymbols(new Locale("es", "CL"));
        DecimalFormat format = new DecimalFormat("#,##0.00", symbols);
        System.out.println("" + format.format(16588792.39));
        
        System.out.println("US: " + String.format(Locale.US, "%.2f", 387549.39));
        System.out.println("US2: " + String.format(Locale.US, "%1$,.2f", 387549.39));
        System.out.println("CL: " + String.format(new Locale("es", "CL"), "%.2f", 387549.39));
        System.out.println("CL2: " + String.format(new Locale("es", "CL"), "%1$,.2f", 387549.39));
        System.out.println("PE: " + String.format(new Locale("es", "PE"), "%.2f", 387549.39));
        System.out.println("PE2: " + String.format(new Locale("es", "PE"), "%1$,.2f", 387549.39));
        
        f1(92344.52, ',', '.');
        f1(92344.52, '.', ',');
        f1(92344.52, '.', '.');
        f1(92344.52, ',', ',');
        f1(92344.52, ';', ',');
        f1(92344.52, ' ', '.');
        
        String cad = "92,344.52";
        System.out.println("Replace " + cad.replace(".", ","));
        System.out.println("Index" + cad.indexOf("."));
        System.out.println("Part Int: " + cad.substring(0, cad.indexOf(".")));
        System.out.println("Part Decimal: " + cad.substring(cad.indexOf("."), cad.length()));
        System.out.println("" + cad.substring(cad.indexOf(".") + 1, cad.length()));
        
        System.out.println("F1: " + formatNumber("92,344.52", "CHI"));
        System.out.println("F1: " + formatNumber("", "PER"));
        System.out.println("F1: " + formatNumber("92.344,52", "PER"));
    }
    
    public static String formatNumber(String value, String codPais) {
        if (value == null || value.isEmpty()) {
            return "";
        }
        
        if ("PER".equals(codPais)) {
            return value;
        }
        
        String groupSeparator = ".";
        String decimalSeparator = ",";
        int index = value.indexOf(groupSeparator);
        String part1 = value.substring(0, index);
        part1 = part1.replace(decimalSeparator, groupSeparator);
        String part2 = value.substring(index, value.length());
        part2 = part2.replace(groupSeparator, decimalSeparator);
        return part1 + part2;
    }
}
