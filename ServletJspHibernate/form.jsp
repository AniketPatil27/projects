<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Employee</title>
</head>
<body>
	
	   <jsp:include page="hello.jsp"/>
	   
		<form action="add" method="GET">
		
		Emp. Id: <input type="text" name="id"><br><br>
		Emp. Name: <input type="text" name="name"><br><br>
		Emp. Salary:<input type="text" id="salary" name="salary"><br><br>
		
		<input type="submit" value="Add"/>
		
		</form>
</body>
</html>