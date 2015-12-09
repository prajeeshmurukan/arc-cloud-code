package com.arc.cloud.swing.uploader.ui;

public class JXLUploadVO {

	
	private String orgID = null;
	private String projectName = null;
	private String taxonomy1 = null;
	private String taxonomy2 = null;
	private String documentName = null;
	private String documentTitle = null;

	public String getDocumentName() {
		return documentName;
	}
	public void setDocumentName(String documentName) {
		this.documentName = documentName;
	}
	public String getDocumentTitle() {
		return documentTitle;
	}
	public void setDocumentTitle(String documentTitle) {
		this.documentTitle = documentTitle;
	}
	public String getKeywords() {
		return keywords;
	}
	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}
	public String getMetadata() {
		return metadata;
	}
	public void setMetadata(String metadata) {
		this.metadata = metadata;
	}
	private String keywords = null;
	private String metadata = null;

	
	
	
	public String getOrgID() {
		return orgID;
	}
	public void setOrgID(String orgID) {
		this.orgID = orgID;
	}
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public String getTaxonomy1() {
		return taxonomy1;
	}
	public void setTaxonomy1(String taxonomy1) {
		this.taxonomy1 = taxonomy1;
	}
	public String getTaxonomy2() {
		return taxonomy2;
	}
	public void setTaxonomy2(String taxonomy2) {
		this.taxonomy2 = taxonomy2;
	}
	

	
}
