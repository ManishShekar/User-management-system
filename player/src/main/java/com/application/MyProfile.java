package com.application;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.Player;
import com.userDAO.PlayerDAOimp;

/**
 * Servlet implementation class MyProfile
 */
@WebServlet("/MyProfile")
public class MyProfile extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

	
	PlayerDAOimp dao = new PlayerDAOimp();
	ArrayList<Player> list = dao.getAll();
	PrintWriter out = res.getWriter();
	
//	for( int i=0; i<list.size(); i++) {
//		
//		out.print(list.get(i));
//	}
//	
	out.println(list);
	
	
	
	
	}

}
