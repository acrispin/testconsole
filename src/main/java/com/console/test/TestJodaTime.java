/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.console.test;

import org.joda.time.DateTime;
import org.joda.time.Interval;
import org.joda.time.format.PeriodFormatter;
import org.joda.time.format.PeriodFormatterBuilder;

/**
 *
 * @author acrispin
 */
public class TestJodaTime {
    public static void main(String[] args) {
        // https://stackoverflow.com/questions/13328912/java-getting-time-interval
        DateTime start = new DateTime(2012, 11, 11, 23, 30, 0, 0);
        DateTime end = new DateTime(2012, 11, 12, 1, 30, 0, 0);
        Interval interval = new Interval(start, end);
        org.joda.time.Period toPeriod = interval.toPeriod();

        PeriodFormatter dateFormat = new PeriodFormatterBuilder()
                        .printZeroAlways().minimumPrintedDigits(2)
            .appendHours().minimumPrintedDigits(2)
            .appendSeparator(":")
            .appendMinutes().minimumPrintedDigits(2)
            .toFormatter();        
        System.out.println(toPeriod.toString(dateFormat));
    }
}
