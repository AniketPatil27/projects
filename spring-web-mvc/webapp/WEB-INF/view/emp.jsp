<%@taglib uri = "http://www.springframework.org/tags/form" prefix = "form"%>
<%@ page isELIgnored="false" %>
<html>
   <head>
      <title>Spring MVC Form Handling</title>
   </head>
   <body>

   <h2>Employee Information</h2>
      <form:form method = "POST" action = "addemp">
         <table>
            <tr>
               <td><form:label path = "empId">Employee Id</form:label></td>
               <td><form:input path = "empId" /></td>
            </tr>
            <tr>
               <td><form:label path = "name">Name</form:label></td>
               <td><form:input path = "name" /></td>
            </tr>  
             
            <tr>
               <td><form:label path = "languages">Favorite Languages</form:label></td>
               <td><form:checkboxes items = "${webFrameworkList}" path = "languages" /></td>       
            </tr>
            <tr>
               <td><form:label path = "gender">Gender</form:label></td>
               <td>
                  <form:radiobutton path = "gender" value = "M" label = "Male" />
                  <form:radiobutton path = "gender" value = "F" label = "Female" />
               </td>
            </tr>	  
            <tr>
               <td colspan = "2">
                  <input type = "submit" value = "Submit"/>
               </td>
            </tr>
         </table>  
      </form:form>
   </body>
</html>