package com.arc.cloud.mcv.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import org.apache.commons.fileupload.FileItemIterator;
import org.apache.commons.fileupload.FileItemStream;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.fileupload.util.Streams;
import org.glassfish.grizzly.http.server.Session;

import com.arc.cloud.aws.s3.S3Util;
import com.arc.cloud.dao.hib2.hib.codegen.Customers;
import com.arc.cloud.dao.hib2.hib.codegen.Document;
import com.arc.cloud.dao.util.UIDBUtil;
import com.google.common.io.CharStreams;

/**
 * Servlet implementation class ContentUpload
 */
@WebServlet("/ContentUpload")
public class ContentUpload extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ContentUpload() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {  
		
	PrintWriter out = response.getWriter();
    out.print("Request content length is " + request.getContentLength() + "<br/>"); 
    out.print("Request content type is " + request.getHeader("Content-Type") + "<br/>");
    boolean isMultipart = ServletFileUpload.isMultipartContent(request);
    if(isMultipart){
               ServletFileUpload upload = new ServletFileUpload();
        try{
            FileItemIterator iter = upload.getItemIterator(request);
            FileItemStream item = null;
            String name = "";
            InputStream stream = null;
            //
    		Document doc = new  Document();
    		HttpSession session = request.getSession();
    		Customers user = (Customers)session.getAttribute("user");
    		if(user !=null){
    			doc.setCustid(user.getId());
    			Long orgid = user.getOrganization().getId();
    			doc.setOrgid(orgid.intValue());
    			
    		}
    		 doc.setDocid(request.getParameter("docid"));

    		 doc.setTxProject(request.getParameter("projectName"));
    		 System.out.println("ContentUpload.doPost()");
      	  // out.write("Form field " + name + ": "+ Streams.asString(stream));
//      	   if(name.equals("docid")){
//      		   doc.setDocid(value);
//      		   break;
//      	   }else  if(name.equals("projectName")){
//      		   doc.setTxProject(value);
//      	   }else  if(name.equals("tax1")){
//      		   doc.setTxSubDiv1(value);
//      	   }else  if(name.equals("tax2")){
//      		   doc.setTxSubDiv2(value);
//      	   }else  if(name.equals("docname")){
//      		   doc.setDocname(value);
//      	   }else  if(name.equals("doctitle")){
//      		   doc.setDoctitle(value);
//      	   }else  if(name.equals("createDt")){
//      		   doc.setDoccreatedt(value);
//      	   }else  if(name.equals("metadata")){
//      		   doc.setMetadata(value);
//      	   }else  if(name.equals("keywords")){
//      		   doc.setKeywords(value);
//      	   }
         
    		
	            while (iter.hasNext()){
	              item = iter.next();
	              name = item.getFieldName();
	              stream = item.openStream();
	             
	               if(item.isFormField()){
	            	   
	            	   
	               }else {
	                   name = item.getName();
	                   System.out.println("name==" + name);
	                   if(name != null && !"".equals(name)){
	                      String fileName = new File(item.getName()).getName();
	                      out.write("Client file: " + item.getName() + " <br/>with file name "+ fileName + " was uploaded.<br/>");
	                      File file = new File(getServletContext().getRealPath("/" + fileName));
	                      FileOutputStream fos = new FileOutputStream(file);
	                      long fileSize = Streams.copy(stream, fos, true);
	                      S3Util aswS3util = new S3Util();
	                      try{
	                    	  //aswS3util.uploadDocumment(doc, new FileInputStream(file));
	                      }catch(Exception e){
	                    	  e.printStackTrace();
	                      }
		                	
		                	
	                      
	                      out.write("Size was " + fileSize + " bytes <br/>");
	                      out.write("File Path is " + file.getPath() + "<br/>");
	                   }
	                   
	                   UIDBUtil.addDocument(doc);
	                 	
	               }
	            }
        } catch(FileUploadException fue) {
        	out.write("fue!!!!!!!!!");
        }
        
        response.sendRedirect("jsp/_08_admin-sidebar-content-upload.jsp");
    } 
}



	
	
	
}
