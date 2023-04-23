<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Employment Portal</title>
</head>
<body>

		<form action="edit" method="get">
		
		Emp. Id: <input type="text" name="id" value="${param.id}"/> <br><br>
		Emp. Name: <input type="text" name="name"/> <br><br>
		Emp. Salary: <input type="number" name="salary"/> <br><br>
		<input type="submit" value="Edit"/>
		
		
		</form>
</body>
</html>