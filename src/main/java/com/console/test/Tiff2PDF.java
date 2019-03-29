/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.console.test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Image;
import com.itextpdf.text.io.FileChannelRandomAccessSource;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.RandomAccessFileOrArray;
import com.itextpdf.text.pdf.codec.TiffImage;

/**
 *
 * @author acrispin https://gist.github.com/szahn/6454209
 */
public class Tiff2PDF {

    public static void main(String[] args) throws DocumentException, IOException {
        Convert2("D:\\DATA\\cumplimientoprogramacion.tif", "D:\\DATA\\cumplimientoprogramacion.pdf");
    }
    
    public static void Convert2(String tiffFilename, String pdfFilename) throws DocumentException, FileNotFoundException, IOException {
        Document pdf = new Document();
        PdfWriter.getInstance(pdf, new FileOutputStream(pdfFilename));
        pdf.open();
        
        int filesAdded = 0;
        FileChannelRandomAccessSource source = new FileChannelRandomAccessSource(
                new FileInputStream(tiffFilename).getChannel());
        RandomAccessFileOrArray file = new RandomAccessFileOrArray(source);
        int pages = TiffImage.getNumberOfPages(file);
        for (int page = 1; page <= pages; page++) {
            Image img = TiffImage.getTiffImage(file, page);
            img.scaleToFit(pdf.getPageSize());
            if (pdf.add(img)) {
                filesAdded++;
            }
        }
        
        pdf.close();
    }

    public static boolean Convert(List<String> files, String pdfFilename) throws FileNotFoundException, IOException, DocumentException {
        boolean converted = false;
        try {
            Document pdf = new Document();
            PdfWriter.getInstance(pdf, new FileOutputStream(pdfFilename));
            pdf.open();

            int filesAdded = 0;
            for (String tiffFilename : files) {
                try {
                    FileChannelRandomAccessSource source = new FileChannelRandomAccessSource(
                            new FileInputStream(tiffFilename).getChannel());
                    RandomAccessFileOrArray file = new RandomAccessFileOrArray(source);
                    int pages = TiffImage.getNumberOfPages(file);
                    for (int page = 1; page <= pages; page++) {
                        Image img = TiffImage.getTiffImage(file, page);
                        if (pdf.add(img)) {
                            filesAdded++;
                        }
                    }

                } catch (IOException ex) {
                    throw ex;
                }
            }

            pdf.close();

            // converted = IOHelper.DoesFileExist(pdfFilename) && filesAdded == files.size();
            converted = true && filesAdded == files.size();

        } catch (FileNotFoundException | DocumentException e1) {
            throw e1;
        }

        return converted;
    }
}
