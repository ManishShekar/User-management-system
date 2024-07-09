package com.userDAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.model.Player;

public class PlayerDAOimp implements PlayerDAO {
	
	static private String url = "jdbc:mysql://localhost:3306/jdbc";
	static private String username = "root";
	static private String password = "Manish23*#";
	static private Connection con=null;
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			con = DriverManager.getConnection(url, username, password);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	@Override
	public int save(Player p) {
	PreparedStatement pstm =null;
	try {
		pstm = con.prepareStatement(INSERT_QUERY);
		pstm.setString(1,p.getName() );
		pstm.setString(2,p.getEmail() );
		pstm.setDouble(3,p.getPhoneno() );
		pstm.setString(4, p.getPassword());
		return pstm.executeUpdate();
	} catch (SQLException e) {
		e.printStackTrace();
	}
	return -1;
		
	}
	

	@SuppressWarnings("null")
	@Override
	public int update(Player p) {
		PreparedStatement pstm=null;
		
		try {
			 pstm = con.prepareStatement(UPDATE_QUERY);
			pstm.setInt(5, p.getId());
			pstm.setString(1, p.getName());
			pstm.setString(2,p.getEmail());
			pstm.setDouble(3, p.getPhoneno());
			pstm.setString(4,p.getPassword());
			return pstm.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		return -1;
	}

	@Override
	public int delete(int id) {
		
		try {
			PreparedStatement pstm = con.prepareStatement(DELETE_QUERY);
			pstm.setInt(1,id );
			pstm.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return -1;
	}
	
	
	

	@Override
	public Player get(String mail) {
		PreparedStatement pstm;
		try {
			pstm = con.prepareStatement(SELECT_QUERY);
			pstm.setString(1,mail);
			ResultSet res = pstm.executeQuery();
			ArrayList<Player> playerr = new ArrayList<Player>();
			while(res.next()) {
				String name = res.getString("name");
				String email = res.getString("email");
				double phoneno = res.getDouble("phoneno");
				String password=res.getString("password");
				Player player=new Player(name,email,phoneno,password);
				return player;
			
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}



	@Override
	public ArrayList<Player> getAll() {
		ArrayList<Player> playerr = new ArrayList<Player>();
		Statement stm=null;
		ResultSet res=null;
		try {
			stm=con.createStatement();
			res = stm.executeQuery(SELECTALL_QUERY);
			while(res.next()) {
				String name = res.getString("name");
				String email = res.getString("email");
				double phoneno = res.getDouble("phoneno");
				String password=res.getString("password");
				Player player=new Player(name,email,phoneno,password);
				playerr.add(player);
			
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return playerr;
		
	}


	@Override
	public String pass(String email) {
		PreparedStatement pstm=null;
		try {
			pstm=con.prepareStatement(PASS_QUERY);
			pstm.setString(1, email);
			ResultSet res = pstm.executeQuery();
			if(res.next()) {
				return res.getString("password");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}


	@Override
	public String admin_pass(String email) {
		PreparedStatement pstm=null;
		try {
			pstm=con.prepareStatement(ADMIN_PASS);
			pstm.setString(1, email);
			ResultSet res = pstm.executeQuery();
			if(res.next()) {
				return res.getString("password");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}
		
		
	}