package com.xadmin.BankApp.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.xadmin.BankApp.dao.*;
import com.xadmin.BankApp.bean.*;

/**
 * Servlet implementation class Register
 */
@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User user;
		UserDao userdao= new UserDao();
		String name=request.getParameter("username");
		String password=request.getParameter("password");
		String email=request.getParameter("email");
		int balance =Integer.parseInt(request.getParameter("balance"));
		
		user=new User(name,password,email,balance);
		if(userdao.insertUser(user)) {
			response.sendRedirect("regSuccess.jsp");
		}
		else
			response.sendRedirect("");
		
	}

}
