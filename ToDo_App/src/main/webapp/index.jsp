<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
<div class="container">
<table class="table table-striped" border="1px">
  <thead class="bg-success text-white">
    <tr>
      <th scope="col">ID</th>
      <th scope="col">ToDo</th>
      <th scope="col">Status</th>
      <th scope="col">Action</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <th scope="row">1</th>
      <td>Mark</td>
      <td>Pending</td>
      <td>
      <a href="edit.jsp" class="btn btn-sm btn-success">Edit</a>
      <a href="delete.jsp" class="btn btn-sm btn-danger">Delete</a>
      </td>
    </tr>
    
  </tbody>
</table>
</div>
</body>
</html>