<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
  <style> 
		table,th,td{
		border: 1px solid black;
		}
</style>
<head>
<meta charset="ISO-8859-1">
<title>Employee Portal</title>
</head>
<body>
     
		<h1>Employee Management</h1>
        <h2>
        	<a href="add.jsp">Add New User</a>
        	&nbsp;&nbsp;&nbsp;
        	<a href="list">List All Users</a>
        	
        </h2>
    <div align="center">
        <table border="1" cellpadding="5">
           <h2> <caption>List of Employees</caption></h2>
            
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Salary</th>
            </tr>
            <c:forEach var="emp" items="${employee}">
                <tr>
                    <td><c:out value="${emp.id}" /></td>
                    <td><c:out value="${emp.name}" /></td>
                    <td><c:out value="${emp.salary}" /></td>
                    <td>
                    	<a href="edit.jsp?id=<c:out value="${emp.id}"/>">Edit</a>
                    	&nbsp;&nbsp;&nbsp;&nbsp;
                    	<a href="delete?id=<c:out value="${emp.id}" />">Delete</a>                    	
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>
</body>
</html>