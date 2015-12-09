package com.arc.cloud.api;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "archive-response")
public final class ArchiveResponse {
	public ArchiveResponse() {
		// TODO Auto-generated constructor stub
	}
	

	private String id;
	private String docid;
	private String docname;
	private String doctitle;
	private String doccreatedt;
	private String custid;
	private String bucketid;
	private String txProject;
	private String txSubDiv1;
	private String txSubDiv2;
	private String keywords;
	private String purlurl;
	private String metadata;
	private String orgid;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getDocid() {
		return docid;
	}
	public void setDocid(String docid) {
		this.docid = docid;
	}
	public String getDocname() {
		return docname;
	}
	public void setDocname(String docname) {
		this.docname = docname;
	}
	public String getDoctitle() {
		return doctitle;
	}
	public void setDoctitle(String doctitle) {
		this.doctitle = doctitle;
	}
	public String getDoccreatedt() {
		return doccreatedt;
	}
	public void setDoccreatedt(String doccreatedt) {
		this.doccreatedt = doccreatedt;
	}
	public String getCustid() {
		return custid;
	}
	public void setCustid(String custid) {
		this.custid = custid;
	}
	public String getBucketid() {
		return bucketid;
	}
	public void setBucketid(String bucketid) {
		this.bucketid = bucketid;
	}
	public String getTxProject() {
		return txProject;
	}
	public void setTxProject(String txProject) {
		this.txProject = txProject;
	}
	public String getTxSubDiv1() {
		return txSubDiv1;
	}
	public void setTxSubDiv1(String txSubDiv1) {
		this.txSubDiv1 = txSubDiv1;
	}
	public String getTxSubDiv2() {
		return txSubDiv2;
	}
	public void setTxSubDiv2(String txSubDiv2) {
		this.txSubDiv2 = txSubDiv2;
	}
	public String getKeywords() {
		return keywords;
	}
	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}
	public String getPurlurl() {
		return purlurl;
	}
	public void setPurlurl(String purlurl) {
		this.purlurl = purlurl;
	}
	public String getMetadata() {
		return metadata;
	}
	public void setMetadata(String metadata) {
		this.metadata = metadata;
	}
	public String getOrgid() {
		return orgid;
	}
	public void setOrgid(String orgid) {
		this.orgid = orgid;
	}
	
}