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
@WebServlet("/update")
public class UpdateServlet extends HttpServlet {

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
		
		Entity ety=new Entity();
		ety.setId(Id);
		ety.setName(Name);
		ety.setToDo(ToDo);
		ety.setStatus(Status);
		
		ToDo_DAO dao=new ToDo_DAO(DBConnect.getCon());
		boolean f=dao.updateToDo(ety);    
		
		HttpSession session=req.getSession();
		
		if(f) {
			session.setAttribute("SucMsg","ToDo Updated Successfully");
			resp.sendRedirect("index.jsp");
		}else {
			session.setAttribute("FailMsg","ToDo Not Updated");
			resp.sendRedirect("index.jsp");
		}
		
	}catch(Exception ex) {
		ex.printStackTrace();
	}
	}
	

}
