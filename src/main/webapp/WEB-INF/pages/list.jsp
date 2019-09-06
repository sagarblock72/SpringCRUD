
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
  
    
<h1>Employees List</h1>  
<table border="2" width="70%" cellpadding="2">  
<tr><th>Id</th><th>Name</th><th>Addr</th><th>email</th><th>Edit</th><th>Delete</th></tr>  
   <c:forEach var="emp" items="${list}">   
   <tr>  
   <td>${emp.id}</td>  
   <td>${emp.ename}</td>  
   <td>${emp.addr}</td>  
   <td>${emp.email}</td>  
   <td><a href="editemp/${emp.id}">Edit</a></td>  
   <td><a href="deleteemp/${emp.id}" onclick="myFunction()">Delete</a></td>  
   </tr>  
   </c:forEach>  
   </table>  
   <br/> 
   <div style="color:green;align:center">
   ${msg}
   </div>
   <a style="color:blue" href="add">click here to add new employee</a><br><br>
   <a style="color:blue" href="/JustForTest/">click here to go back</a> 
   <html>
   <script type="text/javascript">
   function myFunction() {
	alert("are you comform you want to delete ");
}
   
   </script>
   </html>