package com.arc.cloud.dao.hib23.hib.codegen;
// Generated 4-Dec-2015 8:37:10 PM by Hibernate Tools 4.3.1.Final

import java.util.Date;

/**
 * Archiveaudit generated by hbm2java
 */
public class Archiveaudit implements java.io.Serializable {

	private int id;
	private String operationtext;
	private String auditedby;
	private Date audittime;
	private Integer archiveid;

	public Archiveaudit() {
	}

	public Archiveaudit(int id) {
		this.id = id;
	}

	public Archiveaudit(int id, String operationtext, String auditedby, Date audittime, Integer archiveid) {
		this.id = id;
		this.operationtext = operationtext;
		this.auditedby = auditedby;
		this.audittime = audittime;
		this.archiveid = archiveid;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getOperationtext() {
		return this.operationtext;
	}

	public void setOperationtext(String operationtext) {
		this.operationtext = operationtext;
	}

	public String getAuditedby() {
		return this.auditedby;
	}

	public void setAuditedby(String auditedby) {
		this.auditedby = auditedby;
	}

	public Date getAudittime() {
		return this.audittime;
	}

	public void setAudittime(Date audittime) {
		this.audittime = audittime;
	}

	public Integer getArchiveid() {
		return this.archiveid;
	}

	public void setArchiveid(Integer archiveid) {
		this.archiveid = archiveid;
	}

}