package com.application;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.Player;
import com.userDAO.PlayerDAOimp;

/**
 * Servlet implementation class usersignup
 */
@WebServlet("/usersignup")
public class usersignup extends HttpServlet {
	private static final long serialVersionUID = 1L;

  

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		String phoneno = req.getParameter("phone");
		String password = req.getParameter("password");
		double mobno = Double.parseDouble(phoneno);
		
		PrintWriter out = res.getWriter();
		Player p = new Player(name,email,mobno,password);
		PlayerDAOimp dao = new PlayerDAOimp();
		int save = dao.save(p);
		
		res.sendRedirect("playerlogin.html");
	}

}
