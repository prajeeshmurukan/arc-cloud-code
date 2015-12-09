package com.arc.fileupload.client;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.commons.io.IOUtils;


import org.glassfish.jersey.media.multipart.FormDataMultiPart;
import org.glassfish.jersey.media.multipart.MultiPartFeature;
import org.glassfish.jersey.media.multipart.file.FileDataBodyPart;


public class FileUploadClient {

	  public static void main(String[] args) {
		  
		  new FileUploadClient().uploadMultipart();
	  }
	  
	  public void uploadMultipart(){
		  final Client client = ClientBuilder.newBuilder().register(MultiPartFeature.class).build();
		  
		  String id = "100";
		  String objID = "2467839";
		  String projectName = "prjName";
		  String tax1 = "tax1";
		  String tax2 = "tax2";
		  String documentName = "docuName";
		  String documentTitle = "title";
		  String documentcrDt = "docCrDt";
		  String documentKeyWords = "keyword";
		  String documentMetadata = "metadat";
		  String documentOrg = "org";

		  
		  
	    final FileDataBodyPart filePart = new FileDataBodyPart("file", new File("C:/temp/output.pdf"));
	    FormDataMultiPart formDataMultiPart = new FormDataMultiPart();
	    
	    formDataMultiPart = formDataMultiPart
	    .field("objID", objID)
	    .field("projectName", projectName)
	    .field("tax1", tax1)
	    .field("tax2", tax2)
	    .field("documentName", documentName)
	    .field("documentTitle", documentTitle)
	    .field("documentcrDt", documentcrDt)
	    .field("documentKeyWords", documentKeyWords)
	    .field("documentMetadata", documentMetadata)
	    .field("documentOrg", documentOrg);

	    
	    final FormDataMultiPart multipart = (FormDataMultiPart) formDataMultiPart.field("foo", "bar").bodyPart(filePart);
	      
	    WebTarget target = client.target("http://localhost/arc-cloud/api/").path("archive/upload");
	    final Response response = target.request().post(Entity.entity(multipart, multipart.getMediaType()));
	     System.out.println("FileUploadClient.uploadMultipart() " + response.getStatus());
		    //Use response object to verify upload success
		     

			
		  
	  }
	  
	  public void getFile(){

			try {
					/*
					InputStream stream = getClass().getClassLoader().getResourceAsStream(fileNameToUpload);
					
					FormDataMultiPart part = new FormDataMultiPart();
					part.field("String_key", "String_value");
					part.field("fileToUpload", stream, MediaType.TEXT_PLAIN_TYPE);
					String response = WebResource.type(MediaType.MULTIPART_FORM_DATA_TYPE).post(String.class, part);
					*/
				
				javax.ws.rs.client.Client client = ClientBuilder.newClient();
				WebTarget target = client.target("http://localhost/arc-cloud/api/").path("hello/pdf");
				 

				Response response = target.request(MediaType.APPLICATION_OCTET_STREAM).get();
				 if(response.getStatus() == Response.Status.OK.getStatusCode())
				    {
				        InputStream is = response.readEntity(InputStream.class);
				        OutputStream out = new FileOutputStream(new File("C:\\tmp\\a.pdf"));
				        IOUtils.copy(is,out);
				        is.close();
				        out.close();
				    } 
				    else{
				       System.out.println("FileUploadClient.main() ERR" + response.getStatus());
				    }
			  } catch (Exception e) {

				e.printStackTrace();

			  }

			
		  
	  }
	}
