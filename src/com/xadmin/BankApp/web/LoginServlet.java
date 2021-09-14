package com.xadmin.BankApp.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;

import com.xadmin.BankApp.bean.*;
import com.xadmin.BankApp.dao.*;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private UserDao userdao;
    public void init(){
        userdao=new UserDao();
    }
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request,response);
    }
    
    public void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        String name =req.getParameter("name");
        String password=req.getParameter("password");
        int ssn=Integer.parseInt(req.getParameter("ssn"));
        User user = new User(name,password,"",ssn,0);
        
  
        if(userdao.validate(user))
        {
            res.sendRedirect("loginSuccess.jsp");
        }
        else
        {
            //HttpSession session = req.getSession();
            res.sendRedirect("login.jsp");
        }   
        
    }
}
