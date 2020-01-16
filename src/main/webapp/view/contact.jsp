<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
</head>
<h1 style="color:red;text-align:center">PHONE BOOK REGISTE FORM PAGE</h1>
<font color="green"><b>${ msg }</b></font>

<center><form:form
 action="register" method="POST" modelAttribute="beans">
 <table border="2" rules="all" width="400" height="200" style="background-color: yellow">
<form:hidden path="contactId"/>
<tr><td><b>Contact Name::</b></td><td><form:input size="30"  path="contactName" /></td></tr>
<tr><td><b>Contact Email::</b></td><td><form:input size="30" path="contactEmail" /></td></tr>
<tr><td><b>Contact PhoneNo::</b></td><td><form:input size="30" path="phoneNo" /></td></tr>
<tr><td align="center"><input type="reset" value="Reset"></td><td align="center"><input type="submit" value="Submit"></td></tr>
<tr><td align="center" colspan="2"><a href="getalldata">View All Contacts</a></tr></td>
</table>
</form:form></center>
<body>

</body>
</html>