package com.arc.cloud.dao.hib2.hib.codegen;
// Generated 23-Nov-2015 8:39:18 AM by Hibernate Tools 4.3.1.Final



/**
 * Custpurl generated by hbm2java
 */
public class Custpurl  implements java.io.Serializable {


     private int id;
     private String purlurl;
     private Integer custid;

    public Custpurl() {
    }

	
    public Custpurl(int id) {
        this.id = id;
    }
    public Custpurl(int id, String purlurl, Integer custid) {
       this.id = id;
       this.purlurl = purlurl;
       this.custid = custid;
    }
   
    public int getId() {
        return this.id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    public String getPurlurl() {
        return this.purlurl;
    }
    
    public void setPurlurl(String purlurl) {
        this.purlurl = purlurl;
    }
    public Integer getCustid() {
        return this.custid;
    }
    
    public void setCustid(Integer custid) {
        this.custid = custid;
    }




}

