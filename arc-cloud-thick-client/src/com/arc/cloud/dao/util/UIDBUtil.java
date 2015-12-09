package com.arc.cloud.dao.util;

import java.io.File;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.swing.table.DefaultTableModel;

import org.hibernate.Session;

import com.arc.cloud.dao.hib2.hib.codegen.Customers;
import com.arc.cloud.dao.hib2.hib.codegen.CustomersHome;
import com.arc.cloud.dao.hib2.hib.codegen.Organization;
import com.arc.cloud.dao.hib2.hib.codegen.Projecttaxonomy;
import com.arc.cloud.dao.hib2.hib.codegen.ProjecttaxonomyHome;

import jxl.Cell;
import jxl.CellType;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class UIDBUtil {

	public static Customers login(String loginID, String password) {
		boolean retval = false;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		Customers user = new Customers();


		user.setUsername(loginID);
		user.setPassword(password);
		List result = new CustomersHome().findByExample(user);
		if (result != null && result.size() > 0) {
			user = (Customers)result.get(0);
		}

		session.close();
		return user;
	}

	public static DefaultTableModel populateModel(DefaultTableModel pmodel, File file)throws Exception {
		
		Workbook w;
		try {
			w = Workbook.getWorkbook(file);
			// Get the first sheet
			Sheet sheet = w.getSheet(0);
			System.out.println("JXLUtil.no of rows " + sheet.getRows()) ;
			
			
			for (int i = 2; i < sheet.getRows(); i++) {
					Object rowArr[] = new Object[6];
					Cell idCell = sheet.getCell(0, i);
					rowArr[0] = idCell.getContents();
					Cell orgCell = sheet.getCell(1,i);
					rowArr[1] = orgCell.getContents();
					Cell projectNamCell = sheet.getCell(2,i);
					rowArr[2] = projectNamCell.getContents();
					Cell projectDescCell = sheet.getCell(3,i);
					rowArr[3] = projectDescCell.getContents();
					Cell taxonomy1cell = sheet.getCell(4,i);
					rowArr[4] = taxonomy1cell.getContents();
					Cell taxonomy2cell = sheet.getCell(5,i);
					rowArr[5] = taxonomy2cell.getContents();
					System.out.println("Row is " + idCell.getContents()+"\t"+orgCell.getContents()+"\t"+projectNamCell.getContents()+"\t"+projectDescCell.getContents()+"\t"+taxonomy1cell.getContents()+"\t"+taxonomy2cell.getContents());
					pmodel.addRow(rowArr);
			}

		} catch (BiffException e) {
			e.printStackTrace();
		}
		
		return pmodel;
	}
	
	public static DefaultTableModel populateModelUpload(DefaultTableModel pmodel, File file)throws Exception {
		
		Workbook w;
		try {
			w = Workbook.getWorkbook(file);
			// Get the first sheet
			Sheet sheet = w.getSheet(0);
			System.out.println("JXLUtil.no of rows " + sheet.getRows()) ;
			
			/*
			 * 	pmodel.addColumn("id");
				pmodel.addColumn("Document Obj ID");
				pmodel.addColumn("Project");
				pmodel.addColumn("Taxonomy 1 ");
				pmodel.addColumn("Taxonomy 2");
				pmodel.addColumn("Document Name");
				pmodel.addColumn("Document TItle");
				pmodel.addColumn("Create Date");
				pmodel.addColumn("Keywords");
				pmodel.addColumn("Metadata");
				pmodel.addColumn("Organization");
				
			 */
			
			for (int i = 2; i < sheet.getRows(); i++) {
					Object rowArr[] = new Object[11];
					Cell idCell = sheet.getCell(0, i);
					rowArr[0] =idCell.getContents();
					
					Cell objIDCell = sheet.getCell(1,i);
					rowArr[1] = Math.abs(objIDCell.hashCode()+ new Date().hashCode());
					
					Cell projectNameCell = sheet.getCell(2,i);
					rowArr[2] = projectNameCell.getContents();
					
					Cell tax1Cell = sheet.getCell(3,i);
					rowArr[3] = tax1Cell.getContents();
					
					Cell tax2Cell = sheet.getCell(4,i);
					rowArr[4] = tax2Cell.getContents();
					
					File f = new File("C:\\temp\\"+projectNameCell.getContents() +"\\" + tax1Cell.getContents() +"\\" + tax2Cell.getContents());
					File[] files = f.listFiles();
					
					Cell documentNameCell = sheet.getCell(5,i);
					rowArr[5] = files[0].getAbsolutePath();
					
					
					Cell documentTitleCell = sheet.getCell(6,i);
					rowArr[6] = files[0].getName();
					
					
					SimpleDateFormat sdf = new SimpleDateFormat("dd/M/yyyy");
					String date = sdf.format(new Date()); 
					
					
					
					Cell documentCreateDtCell = sheet.getCell(7,i);
					rowArr[7] =date ;
					
					Cell KeyWordCell = sheet.getCell(8,i);
					rowArr[8] = KeyWordCell.getContents();
					
					Cell metadataCell = sheet.getCell(9,i);
					rowArr[9] = metadataCell.getContents();
					
					Cell orgCell = sheet.getCell(10,i);
					rowArr[10] = orgCell.getContents();
					//System.out.println("Row is " + idCell.getContents()+"\t"+orgCell.getContents()+"\t"+projectNamCell.getContents()+"\t"+projectDescCell.getContents()+"\t"+taxonomy1cell.getContents()+"\t"+taxonomy2cell.getContents());
					pmodel.addRow(rowArr);
			}

		} catch (BiffException e) {
			e.printStackTrace();
		}
		
		return pmodel;
	}	

	public static void main(String[] args) {
		
		for(int i=0;i<100;i++){
		Projecttaxonomy taxonomyObj = new Projecttaxonomy();
		Organization org = new Organization();
		
		org.setId(10);
		taxonomyObj.setOrganization(org);
		taxonomyObj.setProjectname("Epic".toString()+i);
		taxonomyObj.setProjectdesc(null);
		taxonomyObj.setTaxonomylevel1("Division");
		taxonomyObj.setTaxonomylevel2("Source Disp");
		try{
			addProjectTaxonomy(taxonomyObj);	
		}catch(Exception ex){
			Throwable cause = ex.getCause();
	        if (cause instanceof SQLException) {
	        	String msg = cause.getMessage();
	            System.out.println(msg);
	        }
		}
		
		}
		

	}
	
	public static boolean validateProjectTaxonomy(Projecttaxonomy taxObj) {
		boolean retval = false;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		Projecttaxonomy taxonomy  = taxObj;
		
		Organization org = new Organization();
	
		List result = new ProjecttaxonomyHome().findByExample(taxObj);
		if (result != null && result.size() > 0) {
			retval = true;
		}
		session.flush();
		
		session.close();
		return retval;
	}
	
	
	public static void addProjectTaxonomy(Projecttaxonomy taxObj){

		new ProjecttaxonomyHome().persist(taxObj);
		
		
	}

}
