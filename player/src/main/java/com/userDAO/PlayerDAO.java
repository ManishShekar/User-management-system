package com.userDAO;

import java.util.ArrayList;
import java.util.List;

import com.model.Player;

public interface PlayerDAO {

		
		String INSERT_QUERY="INSERT INTO `player`(`name`,`email`,`phoneno`,`password`) values(?,?,?,?)";
		String UPDATE_QUERY="UPDATE `player` set `name`=?, `email`=?, `phoneno`=?, `password`=? where id=?";
		String SELECT_QUERY="SELECT * from `player` where `email`=?";
		String SELECTALL_QUERY="SELECT * FROM `player`";
		String DELETE_QUERY="DELETE FROM `player` where `id`=?";
		
		String PASS_QUERY="SELECT `password` from player where `email`=?";
		String ADMIN_PASS="SELECT `password` from admin where `email`=?";
		
		
		
		
		int save(Player p);
	
		int update(Player p);
		Player get(String mail);
		int delete(int id);
		ArrayList<Player> getAll();
		String pass(String email);
		String admin_pass(String email);
		

	}


