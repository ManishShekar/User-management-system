package com.application;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.userDAO.PlayerDAOimp;


@WebServlet("/adminlogin")
public class adminlogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		String username = req.getParameter("admin-email");
		String password = req.getParameter("admin-password");
		
		PlayerDAOimp dao = new PlayerDAOimp();
		String pass = dao.admin_pass(username);
		
		PrintWriter out = res.getWriter();
		
		if(password.equals(pass)) {
			res.sendRedirect("adminhomepage.html");
		}
		else {
			out.println("invalid details");
		}
	
	
	
	}

}
