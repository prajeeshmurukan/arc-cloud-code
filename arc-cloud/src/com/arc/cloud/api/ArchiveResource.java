package com.arc.cloud.api;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.FileNameMap;
import java.net.URLConnection;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

import org.apache.commons.io.IOUtils;
import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataParam;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.GetObjectRequest;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.S3Object;
import com.amazonaws.services.s3.model.S3ObjectInputStream;
import com.arc.cloud.aws.auth.AWSAuthenticator;
import com.arc.cloud.aws.s3.S3Util;
import com.arc.cloud.dao.hib2.hib.codegen.Document;
import com.arc.cloud.dao.util.UIDBUtil;

@Path("/archive")
public class ArchiveResource {
	
	

	
    @GET
    @Path("/text/{name}")
    @Produces(MediaType.TEXT_PLAIN)
    public String world(@PathParam("name") String name) {
        return "fromm archive" + name;
    }

    @GET
    @Path("/xml/{name}")
    @Produces(MediaType.APPLICATION_XML)
    public ArchiveResponse xmlWorld(@PathParam("name") String name) {
        return new ArchiveResponse();
    }

    @GET
    @Path("/json/{attributename}/{attributeval}")
    @Produces(MediaType.APPLICATION_JSON)
    public List listDocuments(@PathParam("attributename") String attributeName,
    					  @PathParam("attributeval") String attributeVal
    					  ) {
    	List resList = UIDBUtil.getDocuments(attributeName, attributeVal);
    	return resList;
    }
    
    @GET
    @Path("/json/{docId}")
    @Produces(MediaType.APPLICATION_JSON)
    public List listSingDocument(@PathParam("docId") String docId		
    					  ) {
    	List resList = UIDBUtil.getSingDocument(docId);
    	return resList;
    }
    
    
    
    @GET
    @Path("/{docId}")
    @Produces("application/octet-stream")
    public Response downloadPdfFile(@PathParam("docId") String docId)
    {
    	
    	System.out.println("ArchiveResource.downloadPdfFile() doc id is " + docId);
		List list = UIDBUtil.getSingDocument(String.valueOf(docId));
		Document document = (Document) list.get(0);
		AWSAuthenticator authObj = AWSAuthenticator.getObject();
		AWSCredentials credentials = authObj.getCredentials();
		AmazonS3 s3client = new AmazonS3Client(credentials);
		S3Object s3object = s3client.getObject(new GetObjectRequest("acc-acc-weather-archive212",document.getTxSubDiv1()+"/"+document.getTxSubDiv2()+"/"+document.getDocid()));
		S3ObjectInputStream stream = s3object.getObjectContent();
		
		final ObjectMetadata  mdata; 
		mdata = s3object.getObjectMetadata();
		System.out.println("ArchiveResource.downloadPdfFile(...).new StreamingOutput() {...}.write()" + mdata.getContentType());
        //java.nio.file.Path path = Paths.get("C:/temp/output.pdf");
    	
        StreamingOutput fileStream =  new StreamingOutput()
        {
        	 
            @Override
            public void write(java.io.OutputStream output) throws IOException, WebApplicationException
            {
                try
                {
                  IOUtils.copy(stream, output);
                   // byte[] data = Files.readAllBytes(path);
                   // output.write(data);
                   
                    output.flush();
                }
                catch (Exception e)
                {
                    //throw new WebApplicationException("File Not Found !!");
                	e.printStackTrace();
                }
            }
            
        };
        //return Response.ok(fileStream, MediaType.APPLICATION_OCTET_STREAM).type(MediaType.APPLICATION_OCTET_STREAM + "; charset=utf-8").build();
        return Response.ok(fileStream,mdata.getContentType()).build();
    }
    
    
    @POST
    @Path("/upload")
    @Consumes({MediaType.MULTIPART_FORM_DATA})
    public Response createArchive(
    								@FormDataParam("file") InputStream fileInputStream,
    								@FormDataParam("file") FormDataContentDisposition fileMetaData,
    								
    								@FormDataParam("id") String formId,
    								@FormDataParam("userId") String userId,
    								@FormDataParam("orgId") String orgId,
    								@FormDataParam("objID") String formobjID,
    								@FormDataParam("projectName") String projectName,
    								@FormDataParam("tax1") String formtax1,
    								@FormDataParam("tax2") String formtax2,
    								@FormDataParam("documentName") String formdocumentName,
    								@FormDataParam("documentTitle") String formdocumentTitle,
    								@FormDataParam("documentcrDt") String formdocumentcrDt,
    								@FormDataParam("documentKeyWords") String formdocumentKeyWords,
    								@FormDataParam("documentMetadata") String formdocumentdocumentMetadata,
    								@FormDataParam("documentOrg") String formdocumentOrg
    ) throws Exception{
    	
    	System.out.println("ArchiveResource.createArchive()" + fileMetaData.getType()) ;
    	// part 1 create the database row
		Document doc = new  Document();
		//doc.setBucketid(100);
		doc.setCustid(Integer.parseInt(userId));
		doc.setDoccreatedt(new Date().toGMTString());
		doc.setDocid(Integer.parseInt(formobjID));
		doc.setDocname(formdocumentName);
		doc.setDoctitle(formdocumentTitle);
		
		doc.setKeywords(formdocumentKeyWords);
		doc.setMetadata(formdocumentdocumentMetadata);
		doc.setOrgid(Integer.parseInt(orgId));
		doc.setPurlurl("/api/archive/"+doc.getDocid());
		doc.setTxProject(projectName);
		doc.setTxSubDiv1(formtax1);
		doc.setTxSubDiv2(formtax2);	
		
    	S3Util aswS3util = new S3Util();
    	String mymeType = getMimeType(formdocumentName);
    	aswS3util.uploadDocumment(doc, fileInputStream,mymeType);
    	UIDBUtil.addDocument(doc);
    	

        return Response.ok("<html> <script> window.location.href='../../jsp/_08_admin-sidebar-content-upload.jsp?msg=Upload Successful'; </script></html>").type("text/html").build();
    }
    
   

    
     String getMimeType(String fileName) {
        // 1. first use java's built-in utils
        FileNameMap mimeTypes = URLConnection.getFileNameMap();
        String contentType = mimeTypes.getContentTypeFor(fileName);

        // 2. nothing found -> lookup our in extension map to find types like ".doc" or ".docx"
        if (contentType == null) {
            String extension = fileName.substring(fileName.lastIndexOf('.') + 1, fileName.length());;
            contentType = (String)fileExtensionMap.get(extension);
        }
        return contentType;
    }
     private static final Map fileExtensionMap;

     static {
    	
         fileExtensionMap = new HashMap();
         // MS Office
         fileExtensionMap.put("doc", "application/msword");
         fileExtensionMap.put("dot", "application/msword");
         fileExtensionMap.put("docx", "application/vnd.openxmlformats-officedocument.wordprocessingml.document");
         fileExtensionMap.put("dotx", "application/vnd.openxmlformats-officedocument.wordprocessingml.template");
         fileExtensionMap.put("docm", "application/vnd.ms-word.document.macroEnabled.12");
         fileExtensionMap.put("dotm", "application/vnd.ms-word.template.macroEnabled.12");
         fileExtensionMap.put("xls", "application/vnd.ms-excel");
         fileExtensionMap.put("xlt", "application/vnd.ms-excel");
         fileExtensionMap.put("xla", "application/vnd.ms-excel");
         fileExtensionMap.put("xlsx", "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
         fileExtensionMap.put("xltx", "application/vnd.openxmlformats-officedocument.spreadsheetml.template");
         fileExtensionMap.put("xlsm", "application/vnd.ms-excel.sheet.macroEnabled.12");
         fileExtensionMap.put("xltm", "application/vnd.ms-excel.template.macroEnabled.12");
         fileExtensionMap.put("xlam", "application/vnd.ms-excel.addin.macroEnabled.12");
         fileExtensionMap.put("xlsb", "application/vnd.ms-excel.sheet.binary.macroEnabled.12");
         fileExtensionMap.put("ppt", "application/vnd.ms-powerpoint");
         fileExtensionMap.put("pot", "application/vnd.ms-powerpoint");
         fileExtensionMap.put("pps", "application/vnd.ms-powerpoint");
         fileExtensionMap.put("ppa", "application/vnd.ms-powerpoint");
         fileExtensionMap.put("pptx", "application/vnd.openxmlformats-officedocument.presentationml.presentation");
         fileExtensionMap.put("potx", "application/vnd.openxmlformats-officedocument.presentationml.template");
         fileExtensionMap.put("ppsx", "application/vnd.openxmlformats-officedocument.presentationml.slideshow");
         fileExtensionMap.put("ppam", "application/vnd.ms-powerpoint.addin.macroEnabled.12");
         fileExtensionMap.put("pptm", "application/vnd.ms-powerpoint.presentation.macroEnabled.12");
         fileExtensionMap.put("potm", "application/vnd.ms-powerpoint.presentation.macroEnabled.12");
         fileExtensionMap.put("ppsm", "application/vnd.ms-powerpoint.slideshow.macroEnabled.12");
         // Open Office
         fileExtensionMap.put("odt", "application/vnd.oasis.opendocument.text");
         fileExtensionMap.put("ott", "application/vnd.oasis.opendocument.text-template");
         fileExtensionMap.put("oth", "application/vnd.oasis.opendocument.text-web");
         fileExtensionMap.put("odm", "application/vnd.oasis.opendocument.text-master");
         fileExtensionMap.put("odg", "application/vnd.oasis.opendocument.graphics");
         fileExtensionMap.put("otg", "application/vnd.oasis.opendocument.graphics-template");
         fileExtensionMap.put("odp", "application/vnd.oasis.opendocument.presentation");
         fileExtensionMap.put("otp", "application/vnd.oasis.opendocument.presentation-template");
         fileExtensionMap.put("ods", "application/vnd.oasis.opendocument.spreadsheet");
         fileExtensionMap.put("ots", "application/vnd.oasis.opendocument.spreadsheet-template");
         fileExtensionMap.put("odc", "application/vnd.oasis.opendocument.chart");
         fileExtensionMap.put("odf", "application/vnd.oasis.opendocument.formula");
         fileExtensionMap.put("odb", "application/vnd.oasis.opendocument.database");
         fileExtensionMap.put("odi", "application/vnd.oasis.opendocument.image");
         fileExtensionMap.put("oxt", "application/vnd.openofficeorg.extension");
         // Other
         fileExtensionMap.put("txt", "text/plain");
         fileExtensionMap.put("rtf", "application/rtf");
         fileExtensionMap.put("pdf", "application/pdf");
     }
    
         
         
}