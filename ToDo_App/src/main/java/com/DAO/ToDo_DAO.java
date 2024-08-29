package com.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.entity.Entity;

public class ToDo_DAO {
	private Connection con;

	public ToDo_DAO(Connection con) {
		super();
		this.con = con;
	}
	
	public boolean addToDo(Entity e) {
		boolean f=false;
		try {
			String sql="insert into todo(Id,Name,ToDo,Status)values(?,?,?,?)";
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setInt(1, e.getId());
			ps.setString(2, e.getName());
			ps.setString(3, e.getToDo());
			ps.setString(4, e.getStatus());
			
			int i=ps.executeUpdate();
			if(i==1) {
				f=true;
			}
		}catch(Exception p) {
			p.printStackTrace();
		}
		return f;
	}
	
	public List<Entity> getToDo(){
		List<Entity> list=new ArrayList<Entity>();
		Entity en=null;
		
		try {
			String sql="select * from todo order by Id asc";
			PreparedStatement ps=con.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			
			while(rs.next()) {
			en = new Entity();
			en.setId(rs.getInt(1));
			en.setName(rs.getString(2));
			en.setToDo(rs.getString(3));
			en.setStatus(rs.getString(4));
			list.add(en);
			}
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return list;
	}
	
	public Entity getEntityById(int Id) {
		Entity ety=null;
		try {
			String sql="select*from todo where Id=?";
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setInt(1, Id);
			ResultSet rs=ps.executeQuery();
			
			while(rs.next()) {
				ety=new Entity();
				ety.setId(rs.getInt(1));
				ety.setName(rs.getString(2));
				ety.setToDo(rs.getString(3));
				ety.setStatus(rs.getString(4));
			}
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return ety;
	}
	
	public boolean updateToDo(Entity e) {
		boolean f=false;
		try {
			String sql="update todo set Name=?,ToDo=?,Status=? where Id=?";
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1,e.getName());
			ps.setString(2,e.getToDo());
			ps.setString(3,e.getStatus());
			ps.setInt(4,e.getId());
			int i=ps.executeUpdate();
			if(i==1) {
				f=true;
			}
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return f;
	}
	
	public boolean deleteTodo(int Id) {
		boolean f=false;
		try {
			String sql="delete from todo where Id=?";
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setInt(1,Id);
			int i = ps.executeUpdate();
			if(i==1) {
				f=true;
			}
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return f;
	}
}
