package com.pdf;

/**
 * Example written by Bruno Lowagie in answer to:
 * http://stackoverflow.com/questions/21575630/adding-watermark-directly-to-the-stream
 * 
 * Adding a watermark to the document immediately using a page event.
 */

 
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Date;
import java.util.StringTokenizer;
 
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.TabStop.Alignment;
import com.itextpdf.text.pdf.Barcode39;
import com.itextpdf.text.pdf.BarcodePDF417;
import com.itextpdf.text.pdf.BarcodeQRCode;
import com.itextpdf.text.pdf.ColumnText;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfPageEventHelper;
import com.itextpdf.text.pdf.PdfWriter;
import com.lowagie.text.Chunk;
import com.lowagie.text.HeaderFooter;
 
public class Watermarking {
 
    public static final String DEST = "C:\\temp\\united_states.pdf";
   // public static final String DATA = "resources/data/united_states.csv";
    public static final Font FONT = new Font();
    public static final Font BOLD = new Font(FontFamily.HELVETICA, 12, Font.BOLD);
 
    public static void main(String[] args) throws IOException, DocumentException {
        File file = new File(DEST);
        file.getParentFile().mkdirs();
        new Watermarking().createPdf(DEST);
    }
 
    public class Watermark extends PdfPageEventHelper {
 
        protected Phrase watermark = new Phrase("ARCHIVED !", new Font(FontFamily.HELVETICA, 90, Font.ITALIC, BaseColor.RED.darker()));
       
        @Override
        public void onEndPage(PdfWriter writer, Document document) {
            PdfContentByte canvas = writer.getDirectContentUnder();
            ColumnText.showTextAligned(canvas, Element.ALIGN_CENTER, watermark, 298, 421, 45);
        }
    }
 
    public void createPdf(String dest) throws IOException, DocumentException {
    	  Document document = new Document(PageSize.A4);
    	  File files = new File(dest);
    	  if (files.exists()) {
      		if (files.mkdirs()) {
      			System.out.println("Multiple directories are created!");
      		} else {
      			System.out.println("Failed to create multiple directories!");
      		}
      	}
        PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(dest));
        writer.setPageEvent(new Watermark());
        document.open();
        Image imgLogo = Image.getInstance("C:\\temp\\Logo.jpg");
        imgLogo.setScaleToFitLineWhenOverflow(true);
        imgLogo.setScaleToFitHeight(true);
        imgLogo.setAbsolutePosition(30, 750);
      
        document.add(imgLogo);
    
        
        document.add(new Paragraph("\n\n\n"));
     // Image in color space DeviceGray
        byte gradient[] = new byte[256];
        for (int i = 0; i < 256; i++)
            gradient[i] = (byte) i;
        
        Image img1 = Image.getInstance(256, 1, 1, 8, gradient);
        img1.scaleAbsolute(656, 1);
        document.add(img1);

        
        BarcodePDF417 pdf417 = new BarcodePDF417();
        Image img = pdf417.getImage();
        document.add(new Paragraph("Report QRCode"));
        BarcodeQRCode qrcode = new BarcodeQRCode("Moby Dick by Herman Melville", 1, 1, null);
        img = qrcode.getImage();
        document.add(img);
        
        document.add(createFirstTable());
        
        //document.add(new Paragraph("Hello World!Hello World!Hello World!Hello World!Hello World!Hello World!Hello World!Hello World!Hello World!Hello World!Hello World!Hello World!Hello World!Hello World!Hello World!Hello World!Hello World!Hello World!Hello World!Hello World!Hello World!Hello World!Hello World!Hello World!Hello World!Hello World!Hello World!Hello World!Hello World!Hello World!Hello World!Hello World!Hello World!Hello World!Hello World!Hello World!Hello World!Hello World!Hello World!Hello World!Hello World!Hello World!Hello World!Hello World!Hello World!Hello World!Hello World!Hello World!Hello World!Hello World!Hello World!Hello World!Hello World!Hello World!Hello World!Hello World!Hello World!Hello World!Hello World!Hello World!Hello World!Hello World!Hello World!Hello World!Hello World!Hello World!Hello World!Hello World!Hello World!Hello World!Hello World!Hello World!Hello World!Hello World!Hello World!Hello World!Hello World!Hello World!Hello World!Hello World!Hello World!Hello World!Hello World!Hello World!Hello World!Hello World!Hello World!Hello World!Hello World!Hello World!Hello World!Hello World!Hello World!Hello World!Hello World!Hello World!Hello World!Hello World!Hello World!Hello World!Hello World!Hello World!Hello World!Hello World!Hello World!Hello World!Hello World!Hello World!Hello World!Hello World!Hello World!Hello World!"));

        
        PdfContentByte cb = writer.getDirectContent();
        document.add(new Paragraph("Barcode 3 of 9 extended"));
        Barcode39 code39ext = new Barcode39();
        code39ext.setCode("Weather for canada full");
        code39ext.setStartStopText(false);
        code39ext.setExtended(true);
        document.add(code39ext.createImageWithBarcode(cb, null, null));
        
        
        document.close();
    }
    
    public static PdfPTable createFirstTable() {
    	// a table with three columns
        PdfPTable table = new PdfPTable(2);
      //  table.getDefaultCell().setBorder(5);
        // the cell object
        PdfPCell cell;
        // we add a cell with colspan 3
        cell = new PdfPCell(new Phrase("Cell with colspan 3"));
        cell.setColspan(2);
        cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(cell);
        // now we add a cell with rowspan 2
        cell = new PdfPCell(new Phrase("Cell with rowspan 2"));
        cell.setRowspan(1);
        table.addCell(cell);
        // we add the four remaining cells with addCell()
        table.addCell("row 1; cell 1");
        table.addCell("row 1; cell 2");
        table.addCell("row 2; cell 1");
        table.addCell("row 2; cell 2");
        table.addCell("row 1; cell 1");
        table.addCell("row 1; cell 2");
        table.addCell("row 2; cell 1");
        table.addCell("row 2; cell 2");
        table.addCell("row 1; cell 1");
        table.addCell("row 1; cell 2");
        table.addCell("row 2; cell 1");
        table.addCell("row 2; cell 2");
        table.addCell("row 1; cell 1");
        table.addCell("row 1; cell 2");
        table.addCell("row 2; cell 1");
        table.addCell("sdsdsdsds");
        table.addCell("sdsdsdsdssdsdsdsdssdsdsdsdssdsdsdsdssdsdsdsds");
        table.addCell("sdsdsdsds");
        table.addCell("sdsdsdsds");
        table.addCell("sdsdsdsds");
        table.addCell("sdsdsdsds");
        return table;
    }
    
    public void createPdf(String dest,
    		String country,
    		String city,
    		String cityID ,
    		String   date,
    		String mainEvent,
    		String Description,
    		String Cloudy,
    		String Humiduty,
    		String Pressure,
    		String Snow,
    		String Wind,
    		String tempMorning,
    		String tempDay,
    		String tempEve,
    		String tempNight,
    		String tempMax,
    		String tempMin
    		) throws IOException, DocumentException {
  	  Document document = new Document(PageSize.A4);
      PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(dest));
      writer.setPageEvent(new Watermark());
      document.open();
      Image imgLogo = Image.getInstance("C:\\temp\\Logo.jpg");
      imgLogo.setScaleToFitLineWhenOverflow(true);
      imgLogo.setScaleToFitHeight(true);
      imgLogo.setAbsolutePosition(30, 750);
    
      document.add(imgLogo);
  
      
      document.add(new Paragraph("\n\n\n"));
   // Image in color space DeviceGray
      byte gradient[] = new byte[256];
      for (int i = 0; i < 256; i++)
          gradient[i] = (byte) i;
      
      Image img1 = Image.getInstance(256, 1, 1, 8, gradient);
      img1.scaleAbsolute(656, 1);
      document.add(img1);

      
      BarcodePDF417 pdf417 = new BarcodePDF417();
      Image img = pdf417.getImage();
      document.add(new Paragraph("Report QRCode"));
      BarcodeQRCode qrcode = new BarcodeQRCode(cityID, 1, 1, null);
      img = qrcode.getImage();
      document.add(img);
      
      document.add(createFirstTableWeather(country,city,
    		  cityID ,
    		  date,
    		  mainEvent,
    		  Description,
    		  Cloudy,
    		  Humiduty,
    		  Pressure,
    		  Snow,
    		  Wind,
    		  tempMorning,
    		  tempDay,
    		  tempEve,
    		  tempNight,
    		  tempMax,
    		  tempMin
));
      
      //document.add(new Paragraph("Hello World!Hello World!Hello World!Hello World!Hello World!Hello World!Hello World!Hello World!Hello World!Hello World!Hello World!Hello World!Hello World!Hello World!Hello World!Hello World!Hello World!Hello World!Hello World!Hello World!Hello World!Hello World!Hello World!Hello World!Hello World!Hello World!Hello World!Hello World!Hello World!Hello World!Hello World!Hello World!Hello World!Hello World!Hello World!Hello World!Hello World!Hello World!Hello World!Hello World!Hello World!Hello World!Hello World!Hello World!Hello World!Hello World!Hello World!Hello World!Hello World!Hello World!Hello World!Hello World!Hello World!Hello World!Hello World!Hello World!Hello World!Hello World!Hello World!Hello World!Hello World!Hello World!Hello World!Hello World!Hello World!Hello World!Hello World!Hello World!Hello World!Hello World!Hello World!Hello World!Hello World!Hello World!Hello World!Hello World!Hello World!Hello World!Hello World!Hello World!Hello World!Hello World!Hello World!Hello World!Hello World!Hello World!Hello World!Hello World!Hello World!Hello World!Hello World!Hello World!Hello World!Hello World!Hello World!Hello World!Hello World!Hello World!Hello World!Hello World!Hello World!Hello World!Hello World!Hello World!Hello World!Hello World!Hello World!Hello World!Hello World!Hello World!Hello World!Hello World!"));

      
      PdfContentByte cb = writer.getDirectContent();
      document.add(new Paragraph("Weather Code"));
      Barcode39 code39ext = new Barcode39();
      code39ext.setCode(cityID);
      code39ext.setStartStopText(false);
      code39ext.setExtended(true);
      document.add(code39ext.createImageWithBarcode(cb, null, null));
      
      
      document.close();
  }
    
    
    
    
    public static PdfPTable createFirstTableWeather(
    		String country,
    		String city,
    		String cityID ,
    		String date,
    		String mainEvent,
    		String Description,
    		String Cloudy,
    		String Humiduty,
    		String Pressure,
    		String Snow,
    		String Wind,
    		String tempMorning,
    		String tempDay,
    		String tempEve,
    		String tempNight,
    		String tempMax,
    		String tempMin
    		) {
    	// a table with three columns
        PdfPTable table = new PdfPTable(2);
      //  table.getDefaultCell().setBorder(5);
        // the cell object
        PdfPCell cell;
        // we add a cell with colspan 3
        cell = new PdfPCell(new Phrase("Weather Report : " + city));
        cell.setColspan(2);
        cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(cell);
        // now we add a cell with rowspan 2
        cell = new PdfPCell(new Phrase("country"));
        cell.setRowspan(1);
        table.addCell(cell);
        // we add the four remaining cells with addCell()
        table.addCell(country);
        table.addCell("cityID");
        table.addCell(cityID);
        table.addCell("date");
        table.addCell(date.toString());
        table.addCell("mainEvent");
        table.addCell(mainEvent);
        table.addCell("Description");
        table.addCell(Description);
        table.addCell("Cloudy");
        table.addCell(Cloudy);
        table.addCell("Humiduty");
        table.addCell(Humiduty);
        table.addCell("Pressure");
        table.addCell(Pressure);
        table.addCell("Snow");
        table.addCell(Snow);
        table.addCell("Wind");
        table.addCell(Wind);
        table.addCell("Morning Temp");
        table.addCell(tempMorning);
        table.addCell("tempDay");
        table.addCell(tempDay);
        table.addCell("tempEve");
        table.addCell(tempEve);
        table.addCell("tempNight");
        table.addCell(tempNight);
        table.addCell("tempMax");
        table.addCell(tempMax);
        table.addCell("tempMin");
        table.addCell(tempMin);
        return table;
    }
    
 
    public void process(PdfPTable table, String line, Font font) {
        StringTokenizer tokenizer = new StringTokenizer(line, ";");
        int c = 0;
        while (tokenizer.hasMoreTokens() && c++ < 3) {
            table.addCell(new Phrase(tokenizer.nextToken(), font));
        }
    }
}