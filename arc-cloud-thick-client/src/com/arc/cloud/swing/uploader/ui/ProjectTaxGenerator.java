package com.arc.cloud.swing.uploader.ui;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;

import org.hibernate.mapping.List;

import com.arc.cloud.dao.hib2.hib.codegen.Organization;

import jxl.Workbook;
import jxl.format.Colour;
import jxl.write.Label;
import jxl.write.WritableCell;
import jxl.write.WritableCellFormat;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

public class ProjectTaxGenerator {
	public static void main(String[] args) throws Exception {
		new  ProjectTaxGenerator().createExcel();
	}
	
	public static void createExcel()throws Exception{
		String projectName [] =new String[]{"abalone","abandon","abandoned","abandonment","abandons","abase","abased","abasement","abash","abashed","assents","assert","asserted","asserting","assertion","assertions","assertive","assertively","assertiveness","asserts","breadwinner","breadwinners","break","breakable","breakage","breakages","breakaway","breakaways","breakdown","breakdowns","clowning","clownish","clowns","cloying","cloyingly","club","clubbed","clubbing","clubfooted","clubhouse","criminalisation","criminalise","criminalised","criminalising","criminality","criminally","criminals","criminological","criminologist","criminologists","discolour","discolouration","discoloured","discolours","discomfit","discomfited","discomfiture","discomfort","discomforting","discomforts","entertainments","entertains","enthalpies","enthalpy","enthralled","enthralling","enthrone","enthroned","enthronement","enthuse","foothold","footholds","footing","footings","footless","footlights","footloose","footman","footmarks","footmen","handle","handlebar","handlebars","handled","handler","handlers","handles","handling","handmade","handmaiden","indicate","indicated","indicates","indicating","indication","indications","indicative","indicator","indicators","indices","lass","lasses","lassie","lassies","lassitude","lasso","lassoed","lassoing","last","lasted","migrating","migration","migrations","migratory","mike","mikes","milady","milan","mild","milder","ophthalmologist","ophthalmologists","ophthalmology","opiate","opiates","opine","opined","opines","opining","opinion","pithy","pitiable","pitiably","pitied","pities","pitiful","pitifully","pitiless","pitilessly","piton","questionnaires","questions","quests","queue","queued","queueing","queues","queuing","quibble","quibbles","retry","retrying","retsina","retted","retune","retuning","return","returnable","returned","returnees","showing","showings","showjumpers","showman","showmanship","showmen","shown","showoff","showpiece","showpieces"};
		String taxLevel1[] = new String[]{"Project Integration Management ","Project Scope Management","Project Cost Management","Project Quality Management","Project Human Resource Management","Project Communication Management","Project Risk Management","Project Procurement Management"};
		String taxLevel2[] = new String[]{"Initiation Process Group","Planning Process Group","Execution Process Group","Monitoring & Controlling Process Group","Closing Process Group"};
		ArrayList<ProjectTaxVO> list = new ArrayList<ProjectTaxVO>();
		int counter = 1;
		for(int i=0;i<projectName.length;i++){
			for(int j=0;j<taxLevel1.length;j++){
				for(int k=0;k<taxLevel2.length;k++){
					ProjectTaxVO vo = new ProjectTaxVO();
					vo.setId(counter++);
					vo.setOrganization("ACC");
					vo.setProjectname(projectName[i]);
					vo.setProjectdesc("Project Description");
					vo.setTaxonomylevel1(taxLevel1[j]);
					vo.setTaxonomylevel2(taxLevel2[k]);
					list.add(vo);
				}
			}
		}
		
		
		WritableWorkbook workbook; 
		workbook = Workbook.createWorkbook(new File("C:\\Temp\\JExcelExample.xls"));
		//Creating sheet
		WritableSheet sheet = workbook.createSheet("Project", 0);
		 String Header[] = new String[6];
         Header[0] = "ID";
         Header[1] = "Organization";
         Header[2] = "Project Name";
         Header[3] = "Project Desc";
         Header[4] = "Taxonomy level1";
         Header[5] = "Taxonomy level2";
         
         
         Colour bckcolor = Colour.DARK_GREEN;
         WritableCellFormat cellFormat = new WritableCellFormat();
         cellFormat.setBackground(bckcolor);
         
		for (int i = 0; i < Header.length; i++) {
            Label label = new Label(i, 0, Header[i]);
            sheet.addCell(label);
        }
		
		Iterator<ProjectTaxVO>  itr = list.iterator();
		int rowcounter = 1;
		while(itr.hasNext()){
			rowcounter ++;
			ProjectTaxVO vo = itr.next();
			
            sheet.addCell( new Label(0, rowcounter,String.valueOf(vo.getId())));
            sheet.addCell( new Label(1, rowcounter,String.valueOf(vo.getOrganization())));
            sheet.addCell( new Label(2, rowcounter,String.valueOf(vo.getProjectname())));
            sheet.addCell( new Label(3, rowcounter,String.valueOf(vo.getProjectdesc())));
            sheet.addCell( new Label(4, rowcounter,String.valueOf(vo.getTaxonomylevel1())));
            sheet.addCell( new Label(5, rowcounter,String.valueOf(vo.getTaxonomylevel2())));
            
		}


		
		workbook.write();
		workbook.close();
		System.out.println("Project Details file created");
	}
	
	

}

class ProjectTaxVO{
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getOrganization() {
		return organization;
	}
	public void setOrganization(String organization) {
		this.organization = organization;
	}
	public String getProjectname() {
		return projectname;
	}
	public void setProjectname(String projectname) {
		this.projectname = projectname;
	}
	public String getProjectdesc() {
		return projectdesc;
	}
	public void setProjectdesc(String projectdesc) {
		this.projectdesc = projectdesc;
	}
	public String getTaxonomylevel1() {
		return taxonomylevel1;
	}
	public void setTaxonomylevel1(String taxonomylevel1) {
		this.taxonomylevel1 = taxonomylevel1;
	}
	public String getTaxonomylevel2() {
		return taxonomylevel2;
	}
	public void setTaxonomylevel2(String taxonomylevel2) {
		this.taxonomylevel2 = taxonomylevel2;
	}
	private int id;
	private String organization;
	private String projectname;
	private String projectdesc;
	private String taxonomylevel1;
	private String taxonomylevel2;
}
