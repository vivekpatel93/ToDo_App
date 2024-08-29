package com.Servlet;

import java.io.IOException;

import com.DAO.ToDo_DAO;
import com.DB.DBConnect;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
@WebServlet("/delete")
public class DeleteServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int Id=Integer.parseInt(req.getParameter("Id"));
		
		ToDo_DAO dao=new ToDo_DAO(DBConnect.getCon());
		boolean f=dao.deleteTodo(Id);    
		
		HttpSession session=req.getSession();
		
		if(f) {
			session.setAttribute("SucMsg","ToDo deleted Successfully");
			resp.sendRedirect("index.jsp");
		}else {
			session.setAttribute("FailMsg","ToDo Not deleted");
			resp.sendRedirect("index.jsp");
		}
	}
	
}
