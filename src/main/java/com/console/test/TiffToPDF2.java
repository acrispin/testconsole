/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.console.test;

import java.io.FileOutputStream;

import com.lowagie.text.Document;
import com.lowagie.text.Image;
import com.lowagie.text.PageSize;
import com.lowagie.text.Rectangle;
import com.lowagie.text.pdf.PdfContentByte;
import com.lowagie.text.pdf.PdfWriter;
import com.lowagie.text.pdf.RandomAccessFileOrArray;
import com.lowagie.text.pdf.codec.TiffImage;

/**
 *
 * @author acrispin http://www.rgagnon.com/javadetails/java-0645.html
 */
public class TiffToPDF2 {

    public static void main(String[] args) {
        convert2("D:\\DATA\\cumplimientoprogramacion.tif", "D:\\DATA\\cumplimientoprogramacion.pdf");
    }

    public static void convert2(String tiff, String pdf) {
        Document document = new Document(PageSize.LETTER, 0, 0, 0, 0);
        try {
            PdfWriter writer = PdfWriter.getInstance(document,
                    new FileOutputStream(pdf));
            int pages = 0;
            document.open();
            PdfContentByte cb = writer.getDirectContent();
            RandomAccessFileOrArray ra = null;
            int comps = 0;
            try {
                ra = new RandomAccessFileOrArray(tiff);
                comps = TiffImage.getNumberOfPages(ra);
            } catch (Throwable e) {
                System.out.println("Exception in " + tiff + " "
                        + e.getMessage());
            }
            System.out.println("Processing: " + tiff);
            for (int c = 0; c < comps; ++c) {
                try {
                    Image img = TiffImage.getTiffImage(ra, c + 1);
                    if (img != null) {
                        System.out.println("page " + (c + 1));
                        img.scalePercent(7200f / img.getDpiX(), 7200f / img.getDpiY());
                        document.setPageSize(new Rectangle(img.getScaledWidth(), img.getScaledHeight()));
                        img.setAbsolutePosition(0, 0);
                        cb.addImage(img);
                        document.newPage();
                        ++pages;
                    }
                } catch (Throwable e) {
                    System.out.println("Exception " + tiff + " page "
                            + (c + 1) + " " + e.getMessage());
                }
            }
            ra.close();
            document.close();
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }

    public static void convert(String[] args) {
        if (args.length < 1) {
            System.out
                    .println("Usage: Tiff2Pdf file1.tif [file2.tif ... fileN.tif]");
            System.exit(1);
        }
        String tiff;
        String pdf;
        for (int i = 0; i < args.length; i++) {
            tiff = args[i];
            pdf = tiff.substring(0, tiff.lastIndexOf('.') + 1) + "pdf";
            Document document = new Document(PageSize.LETTER, 0, 0, 0, 0);
            try {
                PdfWriter writer = PdfWriter.getInstance(document,
                        new FileOutputStream(pdf));
                int pages = 0;
                document.open();
                PdfContentByte cb = writer.getDirectContent();
                RandomAccessFileOrArray ra = null;
                int comps = 0;
                try {
                    ra = new RandomAccessFileOrArray(tiff);
                    comps = TiffImage.getNumberOfPages(ra);
                } catch (Throwable e) {
                    System.out.println("Exception in " + tiff + " "
                            + e.getMessage());
                    continue;
                }
                System.out.println("Processing: " + tiff);
                for (int c = 0; c < comps; ++c) {
                    try {
                        Image img = TiffImage.getTiffImage(ra, c + 1);
                        if (img != null) {
                            System.out.println("page " + (c + 1));
                            img.scalePercent(7200f / img.getDpiX(), 7200f / img.getDpiY());
                            document.setPageSize(new Rectangle(img.getScaledWidth(), img.getScaledHeight()));
                            img.setAbsolutePosition(0, 0);
                            cb.addImage(img);
                            document.newPage();
                            ++pages;
                        }
                    } catch (Throwable e) {
                        System.out.println("Exception " + tiff + " page "
                                + (c + 1) + " " + e.getMessage());
                    }
                }
                ra.close();
                document.close();
            } catch (Throwable e) {
                e.printStackTrace();
            }
            System.out.println("done");
        }
    }
}
