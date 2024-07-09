package com.application;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.model.Player;
import com.userDAO.PlayerDAOimp;

/**
 * Servlet implementation class playerprofile
 */
@WebServlet("/playerprofile")
public class playerprofile extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	
	PlayerDAOimp dao = new PlayerDAOimp();
	HttpSession session = req.getSession();
	Object mail = session.getAttribute("email");
	Player p = dao.get((String)mail);
	ArrayList<Player> all = dao.getAll();
	req.setAttribute("list",all );
	 PrintWriter out = res.getWriter();
		out.println(p);
//	}

	
	}

}
