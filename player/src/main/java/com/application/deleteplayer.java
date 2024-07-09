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
 * Servlet implementation class deleteplayer
 */
@WebServlet("/deleteplayer")
public class deleteplayer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		int id = Integer.parseInt(req.getParameter("id"));
		Player p = new Player();
		PlayerDAOimp dao = new PlayerDAOimp();
		dao.delete(id);
	}

}
