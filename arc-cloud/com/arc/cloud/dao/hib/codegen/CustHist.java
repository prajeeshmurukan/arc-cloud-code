package com.arc.cloud.dao.hib.codegen;
// Generated 10-Nov-2015 7:33:19 PM by Hibernate Tools 4.3.1.Final

/**
 * CustHist generated by hbm2java
 */
public class CustHist implements java.io.Serializable {

	private int id;
	private Integer custid;
	private String documentid;
	private String uploaddt;

	public CustHist() {
	}

	public CustHist(int id) {
		this.id = id;
	}

	public CustHist(int id, Integer custid, String documentid, String uploaddt) {
		this.id = id;
		this.custid = custid;
		this.documentid = documentid;
		this.uploaddt = uploaddt;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Integer getCustid() {
		return this.custid;
	}

	public void setCustid(Integer custid) {
		this.custid = custid;
	}

	public String getDocumentid() {
		return this.documentid;
	}

	public void setDocumentid(String documentid) {
		this.documentid = documentid;
	}

	public String getUploaddt() {
		return this.uploaddt;
	}

	public void setUploaddt(String uploaddt) {
		this.uploaddt = uploaddt;
	}

}
