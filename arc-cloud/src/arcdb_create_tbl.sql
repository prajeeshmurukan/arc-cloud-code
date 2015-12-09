
-- pgsqlds2_create_db.sql: DVD Store Database Version 2.1 Build Script - Postgres version
-- Copyright (C) 2011 Vmware, Inc. 
-- Last updated 2/13/11
-- Tables

DROP TABLE IF EXISTS "CUSTOMERS";

CREATE TABLE "CUSTOMERS" (
  id SERIAL PRIMARY KEY,
  CUSTOMERID integer NULL,
  FIRSTNAME varchar(255) default NULL,
  LASTNAME varchar(255) default NULL,
  ADDRESS1 varchar(255) default NULL,
  ADDRESS2 varchar(255) default NULL,
  CITY varchar(255),
  STATE varchar(255),
  ZIP varchar(10) default NULL,
  COUNTRY varchar(100) default NULL,
  REGION varchar(50) default NULL,
  EMAIL varchar(255) default NULL,
  PHONE varchar(100) default NULL,
  CREDITCARDTYPE integer NULL,
  CREDITCARD varchar(255),
  CREDITCARDEXPIRATION varchar(255),
  USERNAME varchar(255) default NULL,
  PASSWORD TEXT default NULL
);
  
CREATE TABLE CUST_HIST
  (
  CUSTOMERID INT NOT NULL, 
  BUCKETID INT NOT NULL, 
  DOCID INT NOT NULL 
  )
  ;
  
CREATE TABLE BUCKET
  (
  BUCKETID SERIAL PRIMARY KEY, 
  BUCKETNAME DATE NOT NULL, 
  CUSTOMERID INT
  )
  ; 
  
CREATE TABLE DOCUMENT
  (
  DOCID SMALLINT NOT NULL, 
  BUCKETID INT NOT NULL, 
  TITLE INT NOT NULL, 
  CUSTOMERID SMALLINT NOT NULL, 
  KEYWORD DATE NOT NULL,
  CONTENT_PATH 
  
  )
  ; 
  



  
   	