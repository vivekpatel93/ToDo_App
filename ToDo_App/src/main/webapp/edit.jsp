 <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.DAO.ToDo_DAO" %>
<%@ page import="com.DB.DBConnect" %>
<%@ page import="com.entity.Entity" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add ToDo's</title>
<%@include file="Common_content/css.jsp" %>
</head>
<body style="background-color:#f0f1f2">
<%@include file="Common_content/nav_bar.jsp" %>
<div class="container">
<div class="row p-5">
<div class="col-md-6 offset-md-3">
<div class="card">
<div class="card-body">
<h3 class="text-center text-success">Add ToDo</h3>
 <%
  int Id=Integer.parseInt(request.getParameter("Id"));
  ToDo_DAO dao=new ToDo_DAO(DBConnect.getCon());
  Entity en=dao.getEntityById(Id);
  %>
<form action="update" method="post">
<input type="hidden" name="Id" value="<%=en.getId() %>">
<div class="mb-3">
    <label for="inputState" class="form-label">Name:</label>
    <input type="text" class="form-control" id="exampleInputEmail1" name="name" aria-describedby="emailHelp" value="<%= en.getName() %>" required>
    
  </div>
  
  <div class="mb-3">
    <label for="inputState" class="form-label">ToDo:</label>
    <input type="text" class="form-control" id="exampleInputEmail1" name="todo" aria-describedby="emailHelp" value="<%= en.getToDo() %>" required>
    
  </div>
  
  <div class="mb-3">
  <label for="inputState" class="form-label">Status:</label>
  <select class="form-select" aria-label="Default select example" name="status">
  <%
  if("Pending".equals(en.getStatus()))
  {
  %>
   <option value="Pending">Pending</option>
  <option value="Complete">Complete</option>
  <%   
  }else{
  %>
  <option value="Complete">Complete</option>
  <option value="Pending">Pending</option>
  <%  
  }
  %>
  
</select>
  </div>
  
  <div class="text-center">
  <button type="submit" class="btn btn-primary">Update</button>
 
  </div>
</form>
</div>

</div>
</div>
</div>
</div>
</body>
</html>