package com.arc.cloud.dao.hib23.hib.codegen;
// Generated 4-Dec-2015 8:37:10 PM by Hibernate Tools 4.3.1.Final

/**
 * Document generated by hbm2java
 */
public class Document implements java.io.Serializable {

	private int id;
	private Integer docid;
	private String docname;
	private String doctitle;
	private String doccreatedt;
	private Integer custid;
	private Integer bucketid;
	private String txProject;
	private String txSubDiv1;
	private String txSubDiv2;
	private String keywords;
	private String purlurl;
	private String metadata;
	private Integer orgid;

	public Document() {
	}

	public Document(int id) {
		this.id = id;
	}

	public Document(int id, Integer docid, String docname, String doctitle, String doccreatedt, Integer custid,
			Integer bucketid, String txProject, String txSubDiv1, String txSubDiv2, String keywords, String purlurl,
			String metadata, Integer orgid) {
		this.id = id;
		this.docid = docid;
		this.docname = docname;
		this.doctitle = doctitle;
		this.doccreatedt = doccreatedt;
		this.custid = custid;
		this.bucketid = bucketid;
		this.txProject = txProject;
		this.txSubDiv1 = txSubDiv1;
		this.txSubDiv2 = txSubDiv2;
		this.keywords = keywords;
		this.purlurl = purlurl;
		this.metadata = metadata;
		this.orgid = orgid;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Integer getDocid() {
		return this.docid;
	}

	public void setDocid(Integer docid) {
		this.docid = docid;
	}

	public String getDocname() {
		return this.docname;
	}

	public void setDocname(String docname) {
		this.docname = docname;
	}

	public String getDoctitle() {
		return this.doctitle;
	}

	public void setDoctitle(String doctitle) {
		this.doctitle = doctitle;
	}

	public String getDoccreatedt() {
		return this.doccreatedt;
	}

	public void setDoccreatedt(String doccreatedt) {
		this.doccreatedt = doccreatedt;
	}

	public Integer getCustid() {
		return this.custid;
	}

	public void setCustid(Integer custid) {
		this.custid = custid;
	}

	public Integer getBucketid() {
		return this.bucketid;
	}

	public void setBucketid(Integer bucketid) {
		this.bucketid = bucketid;
	}

	public String getTxProject() {
		return this.txProject;
	}

	public void setTxProject(String txProject) {
		this.txProject = txProject;
	}

	public String getTxSubDiv1() {
		return this.txSubDiv1;
	}

	public void setTxSubDiv1(String txSubDiv1) {
		this.txSubDiv1 = txSubDiv1;
	}

	public String getTxSubDiv2() {
		return this.txSubDiv2;
	}

	public void setTxSubDiv2(String txSubDiv2) {
		this.txSubDiv2 = txSubDiv2;
	}

	public String getKeywords() {
		return this.keywords;
	}

	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}

	public String getPurlurl() {
		return this.purlurl;
	}

	public void setPurlurl(String purlurl) {
		this.purlurl = purlurl;
	}

	public String getMetadata() {
		return this.metadata;
	}

	public void setMetadata(String metadata) {
		this.metadata = metadata;
	}

	public Integer getOrgid() {
		return this.orgid;
	}

	public void setOrgid(Integer orgid) {
		this.orgid = orgid;
	}

}