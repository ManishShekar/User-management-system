package com.application;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.Player;
import com.userDAO.PlayerDAOimp;

/**
 * Servlet implementation class updateplayerdetails
 */
@WebServlet("/updateplayerdetails")
public class updateplayerdetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		int id=Integer.parseInt(req.getParameter("id"));
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		String phoneno = req.getParameter("phone");
		String password = req.getParameter("password");
		double mobno = Double.parseDouble(phoneno);
		
		
		
		Player p = new Player(id,name,email,mobno,password);
		System.out.println(p.getId()+""+ p.getEmail() +""+p.getPassword()+""+ p.getPhoneno()+""+ p.getName());
		PlayerDAOimp dao = new PlayerDAOimp();
		int update = dao.update(p);
		res.sendRedirect("adminhomepage.html");
	
	
	
	}

}
