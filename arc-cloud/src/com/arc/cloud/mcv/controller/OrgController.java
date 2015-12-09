package com.arc.cloud.mcv.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.arc.cloud.dao.hib2.hib.codegen.Organization;
import com.arc.cloud.dao.hib2.hib.codegen.OrganizationHome;
import com.arc.cloud.dao.util.UIDBUtil;
import com.arc.cloud.vo.OrganizationVO;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@WebServlet("/orgserv")
public class OrgController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private HashMap<String, Object> JSONROOT = new HashMap<String, Object>();


	public void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String action = (String)request.getParameter("action");
	
	System.out.println("OrgController.doGet()" + request.getRequestURI() +"\t"+ action);
	if ( action != null) 
	{
		
		if(action.equals("create")){
			String id =(String)request.getAttribute("");
			String orgname =(String)request.getParameter("orgname");
			String orgaddr1 =(String)request.getParameter("address1");
			String orgaddr2 =(String)request.getParameter("address2");
			String orgstate =(String)request.getParameter("state");
			String orgzip =(String)request.getParameter("zip");
			String orgcountry =(String)request.getParameter("country");
			String creditcardno =(String)request.getParameter("creditno");
			String creditcardexpdt =(String)request.getParameter("creditdt");
			String creditcardcvv =(String)request.getParameter("creditcvv");
			String orgcode =(String)request.getParameter("orgcode");
			String contactfirstname =(String)request.getParameter("contactFirstname");
			String contactlastname =(String)request.getParameter("contactLastname");
			String contactemail =(String)request.getParameter("contactEmail");
			String contactphone =(String)request.getParameter("contactPhone");
			
			UIDBUtil.createOrganization(orgname, orgaddr1, orgaddr2, orgstate, orgzip, orgcountry, creditcardno, creditcardexpdt, creditcardcvv, orgcode, contactfirstname, contactlastname, contactemail, contactphone, false);
			response.sendRedirect("jsp/_09_admin-sidebar-org.jsp");
			
			
		}else if(action.equals("delete")){
			System.out.println("OrgController.doPost()");
			
			String id =(String)request.getParameter("id");
			System.out.println("OrgController.doPost()" + id);
			new OrganizationHome().delete(new Long(id));
			response.sendRedirect("jsp/_09_admin-sidebar-org.jsp");

		}
	}
		
		
		}

}