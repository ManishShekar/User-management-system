package com.application;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.userDAO.PlayerDAOimp;


@WebServlet("/playerlogin")
public class playerlogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String username = req.getParameter("email");
		String password = req.getParameter("password");
		
		PlayerDAOimp dao = new PlayerDAOimp();
		String pass = dao.pass(username);
		
		PrintWriter out = res.getWriter();
		System.out.println(password);
		System.out.println(pass);
		
		if(password.equals(pass)) {
			
			HttpSession session = req.getSession();
			session.setAttribute("email", username);
			res.sendRedirect("PlayerHomepage.html");
		}
		else {
			out.println("invalid details");
		}
		

	}

}
