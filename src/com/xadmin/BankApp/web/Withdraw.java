package com.xadmin.BankApp.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.xadmin.BankApp.bean.*;
import com.xadmin.BankApp.dao.*;

/**
 * Servlet implementation class Withdraw
 */
@WebServlet("/Withdraw")
public class Withdraw extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int amountW=Integer.parseInt(request.getParameter("amount"));
		int ssn=Integer.parseInt(request.getParameter("ssn"));
		UserDao userdao =new UserDao();
		if(userdao.updateW(ssn, amountW))
			response.sendRedirect("debitSuccess.jsp");
		else
			response.sendRedirect("loginSuccess.jsp");
	}

}
