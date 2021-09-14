package com.xadmin.BankApp.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.xadmin.BankApp.bean.*;
import com.xadmin.BankApp.dao.*;

/**
 * Servlet implementation class Account
 */
@WebServlet("/Account")
public class Account extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int ssn=Integer.parseInt(request.getParameter("ssn"));
		response.setContentType("text/html");
		UserDao userdao=new UserDao();
		User user=userdao.selectUser(ssn);
		String name=user.getUsername();
		String pass=user.getPassword();
		String email=user.getEmail();
		int b=user.getBalance();
		
		String bal=Integer.toString(b);
		PrintWriter pw = response.getWriter();
		pw.println("<html>");
		pw.println("<body><table border='1'><tr><td>SSN</td><td>Username</td><td>Password</td><td>Email</td><td>Balance</td></tr>");
		pw.println("<tr><td>"+ssn+"</td><td>"+name+"</td><td>"+pass+"</td><td>"+email+"</td><td>"+bal+"</td></tr></table></body>");
		pw.println("</html>");
	}

}
