package com.arc.cloud.dao.hib2.hib.codegen;
// Generated 11-Nov-2015 9:40:26 AM by Hibernate Tools 4.3.1.Final

/**
 * Projecttaxonomy generated by hbm2java
 */
public class Projecttaxonomy implements java.io.Serializable {

	private int id;
	private Organization organization;
	private String projectname;
	private String projectdesc;
	private String taxonomylevel1;
	private String taxonomylevel2;

	public Projecttaxonomy() {
	}

	public Projecttaxonomy(int id) {
		this.id = id;
	}

	public Projecttaxonomy(int id, Organization organization, String projectname, String projectdesc,
			String taxonomylevel1, String taxonomylevel2) {
		this.id = id;
		this.organization = organization;
		this.projectname = projectname;
		this.projectdesc = projectdesc;
		this.taxonomylevel1 = taxonomylevel1;
		this.taxonomylevel2 = taxonomylevel2;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Organization getOrganization() {
		return this.organization;
	}

	public void setOrganization(Organization organization) {
		this.organization = organization;
	}

	public String getProjectname() {
		return this.projectname;
	}

	public void setProjectname(String projectname) {
		this.projectname = projectname;
	}

	public String getProjectdesc() {
		return this.projectdesc;
	}

	public void setProjectdesc(String projectdesc) {
		this.projectdesc = projectdesc;
	}

	public String getTaxonomylevel1() {
		return this.taxonomylevel1;
	}

	public void setTaxonomylevel1(String taxonomylevel1) {
		this.taxonomylevel1 = taxonomylevel1;
	}

	public String getTaxonomylevel2() {
		return this.taxonomylevel2;
	}

	public void setTaxonomylevel2(String taxonomylevel2) {
		this.taxonomylevel2 = taxonomylevel2;
	}

}