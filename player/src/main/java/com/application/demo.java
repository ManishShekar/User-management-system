package com.application;

import java.util.ArrayList;

import com.model.Player;
import com.userDAO.*;

public class demo {

	public static void main(String[] args) {
		Player p=new Player("a","adssd",34332,"pass");
		PlayerDAOimp imp=new PlayerDAOimp();
		int save = imp.save(p);
		System.out.println(save);
		ArrayList<Player> all = imp.getAll();
		for(Player p1:all) {
			System.out.println(p1);
		}
		Player player = imp.get("sadf");
		
		System.out.println(player);
	}

}
