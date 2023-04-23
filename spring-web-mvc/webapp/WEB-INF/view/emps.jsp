<%@ page isELIgnored="false" %>
<html>
   <head>
      <title>Spring MVC Form Handling</title>
      
   </head>
   <body>
      <h2>Submitted Employee Information</h2>
      <table>
         <tr>
            <td>Employee Id</td>
            <td>${empId}</td>
         </tr>
         <tr>
            <td>Name</td>
            <td>${name}</td>
         </tr>    
         <tr>
            <td>Address</td>
            <td>${address}</td>
         </tr>  
         <tr>
            <td>Subscribed to Newsletter</td>
            <td>${receivePaper}</td>
         </tr>    
         <tr>
            <td>Favorite Web Frameworks</td>
            <td> <% String[] favoriteFrameworks = (String[])request.getAttribute("favoriteFrameworks");
               for(String framework: favoriteFrameworks) {
                  out.println(framework);
               }
            %></td>
         </tr>     	 
         <tr>
            <td>Gender</td>
            <td>${(gender=="M"? "Male" : "Female")}</td>
         </tr>
         <tr>
            <td>Favourite Number</td>
            <td>${favoriteNumber}</td>
         </tr>   
         <tr>
            <td>Country</td>
            <td>${country}</td>
         </tr>   	  
      </table>  
   </body>
</html>