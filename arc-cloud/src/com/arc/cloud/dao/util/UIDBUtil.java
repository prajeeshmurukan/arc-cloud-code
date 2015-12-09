package com.arc.cloud.dao.util;

import java.io.File;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.table.DefaultTableModel;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.arc.cloud.api.AuditResource;
import com.arc.cloud.dao.hib2.hib.codegen.Archiveaudit;
import com.arc.cloud.dao.hib2.hib.codegen.ArchiveauditHome;
import com.arc.cloud.dao.hib2.hib.codegen.Customers;
import com.arc.cloud.dao.hib2.hib.codegen.CustomersHome;
import com.arc.cloud.dao.hib2.hib.codegen.Custpurl;
import com.arc.cloud.dao.hib2.hib.codegen.CustpurlHome;
import com.arc.cloud.dao.hib2.hib.codegen.Document;
import com.arc.cloud.dao.hib2.hib.codegen.DocumentHome;
import com.arc.cloud.dao.hib2.hib.codegen.Inbox;
import com.arc.cloud.dao.hib2.hib.codegen.InboxHome;
import com.arc.cloud.dao.hib2.hib.codegen.Organization;
import com.arc.cloud.dao.hib2.hib.codegen.OrganizationHome;
import com.arc.cloud.dao.hib2.hib.codegen.Projecttaxonomy;
import com.arc.cloud.dao.hib2.hib.codegen.ProjecttaxonomyHome;

import jxl.Cell;
import jxl.CellType;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class UIDBUtil {

	public static Customers login( String loginID, String password) {
		boolean retval = false;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		Customers user = new Customers();
		Customers retUser =null;
		user.setUsername(loginID);
		user.setPassword(password);
		List result = new CustomersHome().findByExample(user);
		if (result != null && result.size() > 0) {
			retUser = (Customers)result.get(0);
		}

		session.close();
		return retUser;
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
					
					Cell documentNameCell = sheet.getCell(5,i);
					rowArr[5] = documentNameCell.getContents();
					

					
					Cell documentTitleCell = sheet.getCell(6,i);
					rowArr[6] = documentTitleCell.getContents();
					
					Cell documentCreateDtCell = sheet.getCell(7,i);
					rowArr[7] = documentCreateDtCell.getContents();
					
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
		for(int i = 0;i<100;i++){
			//createOrganization(new Long(i).longValue(), "orgnname", "orgAddr1", "orgaddr2", "orgstate", "orgzip", "orgcountry", "creditcardno", "creditcardexpdt", "creditcardcvv", "orgcode", "contactfirstname", "contactlastname", "contactemail", "contactphone", false);
			
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
	
	public static void addDocument(Document document){
		
		new DocumentHome().persist(document);
		Inbox inbox = new Inbox();
		inbox.setCustid(document.getCustid());
		inbox.setCreatedt(new Date());
		inbox.setContent("Document " + document.getDocname() + "Has been created successful !");
		inbox.setTitle( document.getDocname()  + " Created !");
		inbox.setStatus(true);
		new InboxHome().persist(inbox);

	}
	
	public static List  getDocuments(String attributeName, String AttributeVal){
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		StringBuffer qur = new StringBuffer();

		
		if(attributeName.equals("custid")){
			qur.append("from Document where ");
			qur.append(attributeName );
			qur.append("=");
			qur.append(AttributeVal);
			qur.append("");
		}else{
			
			qur.append("from Document where ");
			qur.append(attributeName );
			qur.append(" like '%");
			qur.append(AttributeVal);
			qur.append("%'");
		}
		System.out.println("UIDBUtil.getDocuments()" + qur.toString());
		
		Query queryObject = session.createQuery(qur.toString());
		List<Document> resultList= queryObject.list();
		tx.commit();
		if(resultList !=null ){
			System.out.println("UIDBUtil.getDocuments()" + resultList.size());
			for(int i=0;i<resultList.size() ;i++){
				Object docId = resultList.get(i).getDocid();
				//String strDocID = "<a href='showDialogOpenDoc('#openpurl','"+docId+"');'>"+ docId +"</a>";
				//String strDocID = "<a href='#' onClick='showDialogOpenDoc('#openpurl','"+docId+"');'>"+ docId +"</a>";
				
				String strDocID = "<a href='#' onclick=showDialogOpenDoc('#openpurl','"+docId+"');>"+ docId +"</a>";

				System.out.println("UIDBUtil.getDocuments()" +strDocID);
				resultList.get(i).setDocid(strDocID);
			}
		}
		
		
		return resultList;
		
	}
	

	public static List  getSingDocument(String docId){
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		StringBuffer qur = new StringBuffer();
		
		qur.append("from Document where ");
		qur.append(" docid " );
		qur.append(" = ");
		qur.append(docId);
		qur.append("");
		
		System.out.println("UIDBUtil.getDocuments()" + qur.toString());
		
		Query queryObject = session.createQuery(qur.toString());
		List<Document> resultList= queryObject.list();
		tx.commit();
		
		
		
		return resultList;
		
	}
	
	public static List  getAddDocsforOrg(String orgId){
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		StringBuffer qur = new StringBuffer();
		
		qur.append("from Document where ");
		qur.append(" orgId " );
		qur.append(" = ");
		qur.append(orgId);
		qur.append("");
		
		System.out.println("UIDBUtil.getDocuments()" + qur.toString());
		
		Query queryObject = session.createQuery(qur.toString());
		List<Document> resultList= queryObject.list();
		tx.commit();
		
		
		
		return resultList;
		
	}
	
	public static List  getAllPurlsForCust(String custId){
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		StringBuffer qur = new StringBuffer();
		
		qur.append("from Custpurl where ");
		qur.append(" custid " );
		qur.append(" = ");
		qur.append(custId);
		qur.append("");
		
		System.out.println("UIDBUtil.getAllPurlsForCust()" + qur.toString());
		
		Query queryObject = session.createQuery(qur.toString());
		List<Custpurl> resultList= queryObject.list();
		tx.commit();
		
		
		
		return resultList;
		
	}
	
	public static List  getAllItemsInbox(String custId){
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		StringBuffer qur = new StringBuffer();
		
		qur.append("from Inbox where ");
		qur.append(" custid " );
		qur.append(" = ");
		qur.append(custId);
		qur.append("");
		
		System.out.println("UIDBUtil.getAllPurlsForCust()" + qur.toString());
		
		Query queryObject = session.createQuery(qur.toString());
		List<Inbox> resultList= queryObject.list();
		tx.commit();
		
		
		
		return resultList;
		
	}
	
	
	
	
	
	public static void createPurlUserMap(String userId,String purlId){
		
		Custpurl purl = new Custpurl();
		purl.setCustid(Integer.parseInt(userId));
		String strDocID = "<a href='#' onclick=showDialogOpenPurlWIn('"+purlId+"');>"+ purlId +"</a>";
		purl.setPurlurl(strDocID);
		createInbox("New Purl URL Created", "New PURL URL has been created", true, new Date(), Integer.parseInt(userId));
		System.out.println("Inbox entry created");
		new CustpurlHome().persist(purl);
		
		
	}
	public static void createAudit(String userId,String archId,String auditText){
		
		Archiveaudit audit = new Archiveaudit();
		audit.setArchiveid(Integer.parseInt(archId));
		audit.setAuditedby(userId);
		audit.setAudittime(new Date());
		audit.setOperationtext(auditText);
		new ArchiveauditHome().persist(audit);
		
	}
	
	public static void createInbox( String title, String content, boolean status, Date createdt, Integer custid){
		
		Inbox inbox = new Inbox();
		inbox.setContent(content);
		inbox.setCreatedt(createdt);
		inbox.setCustid(custid);
		inbox.setStatus(status);
		inbox.setTitle(title);
		new InboxHome().persist(inbox);
		
	}	
	
	public static void createOrganization( String orgname, String orgaddr1, String orgaddr2, String orgstate, String orgzip,
			String orgcountry, String creditcardno, String creditcardexpdt, String creditcardcvv, String orgcode,
			String contactfirstname, String contactlastname, String contactemail, String contactphone,
			Boolean isdeleted){
		
		Organization org = new Organization();
		org.setContactemail(contactemail);
		org.setContactfirstname(contactfirstname);
		org.setContactlastname(contactlastname);
		org.setContactphone(contactphone);
		org.setCreditcardcvv(creditcardcvv);
		org.setCreditcardexpdt(creditcardexpdt);
		org.setCreditcardno(creditcardno);
		org.setIsdeleted(isdeleted);
		org.setOrgaddr1(orgaddr1);
		org.setOrgaddr2(orgaddr2);
		org.setOrgcode(orgcode);
		org.setOrgcountry(orgcountry);
		org.setOrgname(orgname);
		org.setOrgstate(orgstate);
		org.setOrgzip(orgzip);
		
		new OrganizationHome().persist(org);
		
	}	
	
	
	public static void editOrganization( String orgname, String orgaddr1, String orgaddr2, String orgstate, String orgzip,
			String orgcountry, String creditcardno, String creditcardexpdt, String creditcardcvv, String orgcode,
			String contactfirstname, String contactlastname, String contactemail, String contactphone,
			Boolean isdeleted){
		
		Organization org = new Organization();
		org.setContactemail(contactemail);
		org.setContactfirstname(contactfirstname);
		org.setContactlastname(contactlastname);
		org.setContactphone(contactphone);
		org.setCreditcardcvv(creditcardcvv);
		org.setCreditcardexpdt(creditcardexpdt);
		org.setCreditcardno(creditcardno);
		org.setIsdeleted(isdeleted);
		org.setOrgaddr1(orgaddr1);
		org.setOrgaddr2(orgaddr2);
		org.setOrgcode(orgcode);
		org.setOrgcountry(orgcountry);
		org.setOrgname(orgname);
		org.setOrgstate(orgstate);
		org.setOrgzip(orgzip);
		
		new OrganizationHome().merge(org);
		
	}	
	
	public static List  getAllItemsOrg(){
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		StringBuffer qur = new StringBuffer();
		
		qur.append("from Organization  ");

		
		System.out.println("UIDBUtil.getAllPurlsForCust()" + qur.toString());
		
		Query queryObject = session.createQuery(qur.toString());
		List<Organization> resultList= queryObject.list();
		tx.commit();
		
		
		
		return resultList;
		
	}
	
	public static void userRegistration(String orgCode, String firstname, String lastname, String email, String phone, String username, String password) throws Exception{
		String passwordHash = "";
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		StringBuffer qur = new  StringBuffer();
		qur.append("from Organization where ");
		qur.append(" orgcode " );
		qur.append(" = '");
		qur.append(orgCode);
		qur.append("'");
		
		System.out.println("UIDBUtil.getAllPurlsForCust()" + qur.toString());
		
		Query queryObject = session.createQuery(qur.toString());
		List<Organization> resultList= queryObject.list();
		
		
		Organization organization = resultList.get(0);
		if(organization == null){
			throw new Exception("Organization not found");
		}else{
			Customers cust = new Customers(organization, firstname, lastname, email, phone, username, password, passwordHash, null);
			new CustomersHome().persist(cust);
		}
		
		
		
	}
	
	

}
