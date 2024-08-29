package com.Servlet;

import java.io.IOException;

import com.DAO.ToDo_DAO;
import com.DB.DBConnect;
import com.entity.Entity;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/add_todo")
public class AddServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			
			int Id=Integer.parseInt(req.getParameter("Id"));
			String Name=req.getParameter("name");
			String ToDo=req.getParameter("todo");
			String Status=req.getParameter("status");
//			System.out.println(Id+" "+Name+" "+ToDo+" "+Status);
			
			Entity en=new Entity();
			en.setId(Id);
			en.setName(Name);
			en.setToDo(ToDo);
			en.setStatus(Status);
			

			
			ToDo_DAO td=new ToDo_DAO(DBConnect.getCon());
			boolean f=td.addToDo(en);
			HttpSession session=req.getSession();
			
			if(f) {
				session.setAttribute("SucMsg","ToDo Added Successfully");
				resp.sendRedirect("index.jsp");
			}else {
				session.setAttribute("FailMsg","ToDo Not Added");
				resp.sendRedirect("index.jsp");
			}
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		
	}
	
	
}
