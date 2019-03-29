/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.console.test;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;

/**
 *
 * @author acrispin
 */
public class TestDecimalFormatter {
    public static void main(String[] args) {
                
        // https://www.mkyong.com/java/java-display-double-in-2-decimal-points/
        DecimalFormat df2 = new DecimalFormat(".##");
        double input = 13482.46785;
        System.out.println("double Original : " + input);
        System.out.println("double 1: " + df2.format(input));
        System.out.println("double 2: " + String.format("%.2f", input));
        System.out.println("double 3: " + String.valueOf(input));
        System.out.println("double 4: " + redondear(input, 2));
        System.out.println("double 4: " + redondear(input, 1));
        System.out.println("double 5: " + round(input, 2));
        System.out.println("double 5: " + round(input, 1));
        
        System.out.println("-----------------");        
        
        // https://stackoverflow.com/questions/7187877/math-ceil-and-math-floor-returning-same-value
        System.out.println(Math.floor(input));
        System.out.println(Math.ceil(input));
        System.out.println(Math.ceil(Math.ceil(input)));
        
        System.out.println("-----------------");
        
        double montoRestoUnDecimal = redondear(7.00, 2);
        System.out.println("redondear: " + montoRestoUnDecimal);
        System.out.println("redondear2: " + redondear(montoRestoUnDecimal, 2));
        montoRestoUnDecimal = round(7.47, 1);
        System.out.println("round: " + montoRestoUnDecimal);
        System.out.println("round2: " + round(montoRestoUnDecimal, 2));
        
        
        System.out.println("-----------------");
        
        DecimalFormatSymbols simbolo = new DecimalFormatSymbols();
        simbolo.setDecimalSeparator('.');
        simbolo.setGroupingSeparator(',');
        NumberFormat formatter = new DecimalFormat("#,###.00", simbolo);
        NumberFormat formatterOk = new DecimalFormat("#,##0.00", simbolo);
        
        double lineaCredito = 0;
        double deudaTotalB = 7000000, deudaPorFacturar = 282842.46, deudaTotalD = 2814482.46, 
                saldoAdelantado = 4388108.35, saldoPorEntregar = 1280069.61, saldoFacturaAdelantada = 10713.82, 
                saldoTotal = 694.96, sobregiro = 23659.52, otro = 0.00;
        // formatter.setGroupingUsed(false); // https://stackoverflow.com/questions/6693785/how-to-format-numbers-with-no-grouping-separator
        System.out.println("lineaCredito: " + formatter.format(lineaCredito));
        System.out.println("deudaTotalB: " + formatter.format(deudaTotalB));
        System.out.println("deudaPorFacturar: " + formatter.format(deudaPorFacturar));
        System.out.println("deudaTotalD: " + formatter.format(deudaTotalD));
        System.out.println("saldoAdelantado: " + formatter.format(saldoAdelantado));
        System.out.println("saldoPorEntregar: " + formatter.format(saldoPorEntregar));
        System.out.println("saldoFacturaAdelantada: " + formatter.format(saldoFacturaAdelantada));
        System.out.println("saldoTotal: " + formatter.format(saldoTotal));
        System.out.println("sobregiro: " + formatter.format(sobregiro));
        System.out.println("otro: " + formatter.format(otro));
        
        System.out.println("-----------------");
        
        System.out.println("lineaCredito: " + formatterOk.format(lineaCredito));
        System.out.println("deudaTotalB: " + formatterOk.format(deudaTotalB));
        System.out.println("deudaPorFacturar: " + formatterOk.format(deudaPorFacturar));
        System.out.println("deudaTotalD: " + formatterOk.format(deudaTotalD));
        System.out.println("saldoAdelantado: " + formatterOk.format(saldoAdelantado));
        System.out.println("saldoPorEntregar: " + formatterOk.format(saldoPorEntregar));
        System.out.println("saldoFacturaAdelantada: " + formatterOk.format(saldoFacturaAdelantada));
        System.out.println("saldoTotal: " + formatterOk.format(saldoTotal));
        System.out.println("sobregiro: " + formatterOk.format(sobregiro));
        System.out.println("otro: " + formatterOk.format(otro));
    }
    
    /**
     * https://stackoverflow.com/a/2808648
     * @param value
     * @param places
     * @return
     */
    public static double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();
        BigDecimal bd = new BigDecimal(value);
        bd = bd.setScale(places, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }
    
    public static double redondear(double nD, int nDec) {
        
        Integer a = new Integer("10");
        return Math.round(nD * Math.pow(a, nDec)) / Math.pow(a, nDec);
    }
}
