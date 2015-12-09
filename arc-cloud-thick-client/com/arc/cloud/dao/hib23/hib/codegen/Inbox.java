package com.arc.cloud.dao.hib23.hib.codegen;
// Generated 4-Dec-2015 8:37:10 PM by Hibernate Tools 4.3.1.Final

import java.util.Date;

/**
 * Inbox generated by hbm2java
 */
public class Inbox implements java.io.Serializable {

	private int id;
	private String title;
	private String content;
	private Boolean status;
	private Date createdt;
	private Integer custid;

	public Inbox() {
	}

	public Inbox(int id) {
		this.id = id;
	}

	public Inbox(int id, String title, String content, Boolean status, Date createdt, Integer custid) {
		this.id = id;
		this.title = title;
		this.content = content;
		this.status = status;
		this.createdt = createdt;
		this.custid = custid;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Boolean getStatus() {
		return this.status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public Date getCreatedt() {
		return this.createdt;
	}

	public void setCreatedt(Date createdt) {
		this.createdt = createdt;
	}

	public Integer getCustid() {
		return this.custid;
	}

	public void setCustid(Integer custid) {
		this.custid = custid;
	}

}
