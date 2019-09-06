<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    
  <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
  
<form:form method="post" action="saveagain" modelAttribute="cmd">    
        <table > 
         <tr>    
          <td>No : </td>   
          <td><form:input path="id"  /></td>  
         </tr>    
         <tr>    
          <td>Name : </td>   
          <td><form:input path="ename"  /></td>  
         </tr>    
         <tr>    
          <td>Addr :</td>    
          <td><form:input path="addr" /></td>  
         </tr>   
         <tr>    
          <td>email :</td>    
          <td><form:input path="email" /></td>  
         </tr>   
         <tr>    
          <td> </td>    
          <td><input type="submit" value="Save" /></td>    
         </tr>    
        </table>   <br>
        <div>
        ${msg}
        </div> 
       </form:form>