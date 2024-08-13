<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add ToDo's</title>
<%@include file="Common_content/css.jsp" %>
</head>
<body>
<%@include file="Common_content/nav_bar.jsp" %>
<div class="container">
<div class="row">
<div class="col-md-6 offset-md-3">
<div class="card">
<div class="card-body">
<form>
  <div class="mb-3">
    <label for="inputState" class="form-label">ToDo:</label>
    <input type="text" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp">
    
  </div>
  <div class="mb-3">
  <label for="inputState" class="form-label">Status:</label>
  <select class="form-select" aria-label="Default select example">
  <option selected>------Select-----------------------------------------</option>
  <option value="Pending">Pending</option>
  <option value="Complete">Complete</option>
</select>
  </div>
  
  <button type="submit" class="btn btn-primary">Submit</button>
</form>
</div>

</div>
</div>
</div>
</div>
</body>
</html>