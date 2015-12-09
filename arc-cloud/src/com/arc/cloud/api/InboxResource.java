package com.arc.cloud.api;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.rmi.server.UID;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.StreamingOutput;

import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataParam;

import com.arc.cloud.aws.s3.S3Util;
import com.arc.cloud.dao.hib2.hib.codegen.Document;
import com.arc.cloud.dao.util.UIDBUtil;

@Path("/inbox")
public class InboxResource {
   
   
    
    
    @GET
    @Path("/json/{custId}")
    @Produces(MediaType.APPLICATION_JSON)
    public List listSingDocument(@PathParam("custId") String custId		
    					  ) {
    	
    	List resList = UIDBUtil.getAllItemsInbox(custId);
    	
    	return resList;
    }
  
}