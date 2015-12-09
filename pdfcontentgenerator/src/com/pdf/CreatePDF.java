package com.pdf;

import java.io.File;
import java.io.FileOutputStream;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Font.FontFamily;
import com.lowagie.text.*;
import com.lowagie.text.pdf.*;
import com.lowagie.text.pdf.draw.LineSeparator;

public class CreatePDF extends PdfPageEventHelper {
	 protected Phrase watermark = new Phrase("WATERMARK");
	 
	 @Override
     public void onEndPage(PdfWriter writer, Document document) {
         PdfContentByte canvas = writer.getDirectContentUnder();
         ColumnText.showTextAligned(canvas, Element.ALIGN_CENTER, watermark, 298, 421, 45);
     }
	 
	public static void main(String[] args) throws Exception {
	Document document=new Document();
    FileOutputStream fos=new FileOutputStream("C:\\temp\\output.pdf");
    PdfWriter writer = PdfWriter.getInstance(document, fos);
    document.open();
    com.lowagie.text.Image image1 = com.lowagie.text.Image.getInstance("C:\\temp\\image1.jpg");
    com.lowagie.text.Image image2 = com.lowagie.text.Image.getInstance("C:\\temp\\image1.jpg");


    image2.setAbsolutePosition(10, 10);

    com.lowagie.text.pdf.PdfContentByte byte1 = writer.getDirectContent();
    com.lowagie.text.pdf.PdfTemplate tp1 = byte1.createTemplate(600, 150);
    tp1.addImage(image2);

    com.lowagie.text.pdf.PdfContentByte byte2 = writer.getDirectContent();
    com.lowagie.text.pdf.PdfTemplate tp2 = byte2.createTemplate(600, 150);


    byte1.addTemplate(tp1, 0, 715);
    byte2.addTemplate(tp2, 0, 0);

    Phrase phrase1 = new Phrase(byte1 + "", FontFactory.getFont(FontFactory.TIMES_ROMAN, 7, Font.NORMAL));
    Phrase phrase2 = new Phrase(byte2 + "", FontFactory.getFont(FontFactory.TIMES_ROMAN, 7, Font.NORMAL));
    
    HeaderFooter header = new HeaderFooter(phrase1, true);
    HeaderFooter footer = new HeaderFooter(phrase2, true);

    document.setHeader(header);


    Paragraph paragraph = new Paragraph();

    paragraph.add(Chunk.NEWLINE);
    paragraph.add(Chunk.NEWLINE);
    paragraph.add(Chunk.NEWLINE);
    paragraph.add(Chunk.NEWLINE);
    paragraph.add(Chunk.NEWLINE);
    paragraph.add(Chunk.NEWLINE);
    paragraph.add(Chunk.NEWLINE);
    paragraph.add(Chunk.NEWLINE);
    paragraph.add(Chunk.NEWLINE);
  

    
    for(int i=10; i<50; i++){
      Chunk chunk = new Chunk("This is a sentence which is long " + i + ". ");
      
      paragraph.add(chunk);
    }

    document.add(paragraph);

    document.setFooter(footer);
    document.close();
    System.out.println("Filereated successfully showing header and footer.");
  }}
