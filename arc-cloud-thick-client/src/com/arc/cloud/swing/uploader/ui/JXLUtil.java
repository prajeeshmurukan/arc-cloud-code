package com.arc.cloud.swing.uploader.ui;

import java.io.File;
import java.io.IOException;

import jxl.Cell;
import jxl.CellType;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class JXLUtil {
	
	public static void main(String[] args)throws Exception {
		new JXLUtil().readSheet("C:\\temp\\JExcelExample.xls");
	}
	public void readSheet(String inputFile) throws IOException {
		File inputWorkbook = new File(inputFile);
		Workbook w;
		try {
			w = Workbook.getWorkbook(inputWorkbook);
			// Get the first sheet
			Sheet sheet = w.getSheet(0);
			System.out.println("JXLUtil.no of rows " + sheet.getRows()) ;
			for (int i = 0; i < sheet.getRows(); i++) {
				
					Cell idCell = sheet.getCell(0, i);
					Cell orgCell = sheet.getCell(1,i);
					Cell projectNamCell = sheet.getCell(2,i);
					Cell projectDescCell = sheet.getCell(3,i);
					Cell taxonomy1cell = sheet.getCell(4,i);
					Cell taxonomy2cell = sheet.getCell(5,i);
					System.out.println("Row is " + idCell.getContents()+"\t"+orgCell.getContents()+"\t"+projectNamCell.getContents()+"\t"+projectDescCell.getContents()+"\t"+taxonomy1cell.getContents()+"\t"+taxonomy2cell.getContents());
			}

		} catch (BiffException e) {
			e.printStackTrace();
		}
	}

}
