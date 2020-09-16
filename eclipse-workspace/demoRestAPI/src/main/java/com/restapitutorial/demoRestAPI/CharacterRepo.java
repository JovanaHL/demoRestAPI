package com.restapitutorial.demoRestAPI;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CharacterRepo {
	
	
	
	Connection con = null;
	
	public CharacterRepo() {
		
		String url = "jdbc:mysql://localhost:3306/restdb";
		String user = "root";
		String pass = "0000";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(url, user, pass);
			System.out.println("Driver Connected");
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		}
	}
	
	public List<Character> getCharacters(){
		
		System.out.println("Starting getCharacters..");
		List<Character> characters = new ArrayList<Character>();
		String sql = "select * from characters";
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			
			while(rs.next()) {
				
				System.out.println("Trying to add character");
				
				Character ch = new Character();
				ch.setId(rs.getInt(1));
				ch.setName(rs.getString(2));
				ch.setType(rs.getString(3));
				ch.setAbility(rs.getString(4));
				
				characters.add(ch);
				
				
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
		return characters;
	}
	
	public Character getCharacter(int id) {
		
		Character ch = new Character();
		String sql = "select * from characters where id=" + id;
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			
			if(rs.next()) {
				
				ch.setId(rs.getInt(1));
				ch.setName(rs.getString(2));
				ch.setType(rs.getString(3));
				ch.setAbility(rs.getString(4));
				
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
		return ch;
		
	}
	
	public void create(Character ch) {
		
		String sql = "insert into characters values (?, ?, ?, ?)";
		try {
			
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1,  ch.getId());
			st.setString(2, ch.getName());
			st.setString(3,  ch.getType());
			st.setString(4,  ch.getAbility());
			st.executeUpdate();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
	
	
	public void update(Character ch) {
		
		String sql = "update characters set name=?, type=?, ability=? where id=?";
		try {
			
			PreparedStatement st = con.prepareStatement(sql);
			
			st.setString(1, ch.getName());
			st.setString(2,  ch.getType());
			st.setString(3,  ch.getAbility());
			st.setInt(4,  ch.getId());
			st.executeUpdate();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
	
public void delete(int id) {
		
		String sql = "delete from characters where id=?";
		try {
			
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1,  id);
			st.executeUpdate();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
	
	
	

}
