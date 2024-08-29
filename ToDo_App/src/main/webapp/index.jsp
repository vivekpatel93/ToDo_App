<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.DAO.ToDo_DAO" %>
<%@ page import="com.DB.DBConnect" %>
<%@ page import="com.entity.Entity" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ToDo App</title>
<%@include file="Common_content/css.jsp" %>
</head>
<body>
<%@include file="Common_content/nav_bar.jsp" %>
<h1 class="text-center text-success">TODO-APP</h1>

<% 
String SucMsg=(String)session.getAttribute("SucMsg");
if(SucMsg!=null){
%>
<div class="alert alert-success text-center" role="alert"><%=SucMsg %></div>
<%
session.removeAttribute("SucMsg");
}
%>

<% 
String FailMsg=(String)session.getAttribute("FailMsg");
if(FailMsg!=null){
%>
<div class="alert alert-danger text-center" role="alert"><%=FailMsg %></div>
<%
session.removeAttribute("FailMsg");
}
%>

<div class="container">
<table class="table table-striped" border="1px">
  <thead class="bg-success text-white">
    <tr>
      <th scope="col">ID</th>
      <th scope="col">Name</th>
      <th scope="col">ToDo</th>
      <th scope="col">Status</th>
      <th scope="col">Action</th>
    </tr>
  </thead>
  <tbody>
  
  <%
  ToDo_DAO dao=new ToDo_DAO(DBConnect.getCon());
  List<Entity> enty=dao.getToDo();
  for(Entity en:enty){
  %>
  <tr>
      <th scope="row"><%=en.getId() %></th>
      <td><%=en.getName() %></td>
      <td><%=en.getToDo() %></td>
      <td><%=en.getStatus() %></td>
      <td>
      <a href="edit.jsp?Id=<%=en.getId() %> " class="btn btn-sm btn-success">Edit</a>
      <a href="delete?Id=<%=en.getId() %>" class="btn btn-sm btn-danger">Delete</a>
      </td>
    </tr>
  <%	  
  }
  %>
  
    
    
  </tbody>
</table>
</div>
</body>
</html>