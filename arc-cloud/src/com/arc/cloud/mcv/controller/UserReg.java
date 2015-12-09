package com.arc.cloud.mcv.controller;

import java.io.IOException;

import javax.servlet.GenericServlet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.arc.cloud.dao.util.UIDBUtil;

/**
 * Servlet implementation class Login
 */
@WebServlet("/registerServ")
public class UserReg extends GenericServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserReg() {
        super();
        // TODO Auto-generated constructor stub
    }



	@Override
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("LoginServ.service()");
		System.out.println("LoginServ.doPost() " + request.getParameter("email") + "\t passord"+ request.getParameter("password"));
		String orgname = request.getParameter("orgname");
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");

		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		String password = request.getParameter("password");
		String rpassword = request.getParameter("rpassword");
		RequestDispatcher dispatcher = null;
		if(! password.equals(rpassword)){
			request.setAttribute("loginfail", "Password Do not Match");
			dispatcher = request.getRequestDispatcher("login.arc");
		}
		try{
			UIDBUtil.userRegistration(orgname, firstName, lastName, email, phone, email, rpassword);
			request.setAttribute("loginfail", "User Registration Successful . Please login");
			 dispatcher = request.getRequestDispatcher("login.arc");
			 
		}catch(Exception e){
			request.setAttribute("loginfail", "User registration Failed"+e);
			dispatcher = request.getRequestDispatcher("login.arc");
		}
	    dispatcher.forward(request, response);
		
	}

}
