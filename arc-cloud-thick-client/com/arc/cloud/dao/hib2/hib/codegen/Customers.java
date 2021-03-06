package com.arc.cloud.dao.hib2.hib.codegen;
// Generated 23-Nov-2015 8:39:18 AM by Hibernate Tools 4.3.1.Final


import java.util.HashSet;
import java.util.Set;

/**
 * Customers generated by hbm2java
 */
public class Customers  implements java.io.Serializable {


     private int id;
     private Organization organization;
     private String firstname;
     private String lastname;
     private String email;
     private String phone;
     private String username;
     private String password;
     private String passwordHash;
     private Set<Inbox> inboxes = new HashSet<Inbox>(0);

    public Customers() {
    }

	
    public Customers(int id, String passwordHash) {
        this.id = id;
        this.passwordHash = passwordHash;
    }
    public Customers(int id, Organization organization, String firstname, String lastname, String email, String phone, String username, String password, String passwordHash, Set<Inbox> inboxes) {
       this.id = id;
       this.organization = organization;
       this.firstname = firstname;
       this.lastname = lastname;
       this.email = email;
       this.phone = phone;
       this.username = username;
       this.password = password;
       this.passwordHash = passwordHash;
       this.inboxes = inboxes;
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
    public String getFirstname() {
        return this.firstname;
    }
    
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }
    public String getLastname() {
        return this.lastname;
    }
    
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
    public String getEmail() {
        return this.email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPhone() {
        return this.phone;
    }
    
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public String getUsername() {
        return this.username;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return this.password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    public String getPasswordHash() {
        return this.passwordHash;
    }
    
    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }
    public Set<Inbox> getInboxes() {
        return this.inboxes;
    }
    
    public void setInboxes(Set<Inbox> inboxes) {
        this.inboxes = inboxes;
    }




}


