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
import javax.servlet.http.HttpSession;

import com.arc.cloud.dao.hib2.hib.codegen.Customers;
import com.arc.cloud.dao.util.UIDBUtil;

/**
 * Servlet implementation class Login
 */
@WebServlet("/LoginServ")
public class LoginServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServ() {
        super();
        // TODO Auto-generated constructor stub
    }


@Override
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	// TODO Auto-generated method stub

	// TODO Auto-generated method stub
	System.out.println("LoginServ.service()");
	System.out.println("LoginServ.doPost() " + request.getParameter("email") + "\t passord"+ request.getParameter("password"));
	
	String email = request.getParameter("email");
	String password = request.getParameter("password");
//	email ="admin";password = "admin";
	String redirectURL = "";
	if(email.equals("admin@arc.cloud.com") && password.equals("admin")){
		 redirectURL = "jsp/start-screen-admin.jsp";
	}else{
		Customers user = UIDBUtil.login( email, password);
		if(user!=null){
			HttpSession session = request.getSession();
			session.setAttribute("user", user);
			 redirectURL = "jsp/start-screen-user.jsp";
		}else{
			request.setAttribute("loginfail", "Login failed");
			 redirectURL = "login.arc";
		}
		
	}
		
	

	RequestDispatcher dispatcher = request.getRequestDispatcher(redirectURL);
    dispatcher.forward(request, response);
	

	
}

}
