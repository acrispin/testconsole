/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.console.test;

//This object will hold our Tiff File
import com.itextpdf.text.pdf.RandomAccessFileOrArray;
//Read Tiff File, Get number of Pages
import com.itextpdf.text.pdf.codec.TiffImage;
//We need the library below to write the final 
//PDF file which has our image converted to PDF
import java.io.FileOutputStream;
//The image class to extract separate images from Tiff image
import com.itextpdf.text.Image;
//PdfWriter object to write the PDF document
import com.itextpdf.text.pdf.PdfWriter;
//Document object to add logical image files to PDF
import com.itextpdf.text.Document;

/**
 *
 * @author acrispin 
 * https://dzone.com/articles/tiff-to-pdfjpeg-conversation
 * https://github.com/shrisowdhaman/Tiff_to_PDF/blob/master/src/com/so/Tiff2Pdf.java
 * http://thinktibits.blogspot.com/2011/06/convert-tiff-to-pdf-itext-java-example.html
 */
public class TiffToPDF {

    public static void main(String[] args) {
        try {
            //Read the Tiff File
            RandomAccessFileOrArray myTiffFile = new RandomAccessFileOrArray("D:\\DATA\\cumplimientoprogramacion.tif");
            //Find number of images in Tiff file
            int numberOfPages = TiffImage.getNumberOfPages(myTiffFile);
            System.out.println("Number of Images in Tiff File" + numberOfPages);
            Document TifftoPDF = new Document();
            PdfWriter.getInstance(TifftoPDF, new FileOutputStream("D:\\DATA\\cumplimientoprogramacion.pdf"));
            TifftoPDF.open();
            //Run a for loop to extract images from Tiff file
            //into a Image object and add to PDF recursively
            for (int i = 1; i <= numberOfPages; i++) {
                Image tempImage = TiffImage.getTiffImage(myTiffFile, i);
                tempImage.scaleToFit(TifftoPDF.getPageSize());
                TifftoPDF.add(tempImage);
            }
            TifftoPDF.close();
            System.out.println("Tiff to PDF Conversion in Java Completed");
        } catch (Exception i1) {
            i1.printStackTrace();
        }
    }

}
