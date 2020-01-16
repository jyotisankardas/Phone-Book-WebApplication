<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<center><b><a href="/">+Add New Contact</a></b>
<table border="1" rules="all"style="background-color: cyan">
	<thead>
		<tr>
			<td>S.No</td>
			<td>Name</td>
			<td>Email</td>
			<td>Phno</td>
			<td>Action</td>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${contactList}" var="v" varStatus="status">
			<tr>
				<td>${status.index+1 }</td>
				<td>${v.contactName}</td>
				<td>${v.contactEmail }</td>
				<td>${v.phoneNo }</td>
				<td><a href="edit?contactId=${v.contactId}">Edit</a>&nbsp;&nbsp;<a href="delet?contactId=${v.contactId}"onclick="return deletpop()">Delete</a></td> 
			</tr>
		</c:forEach>
	</tbody>

</table></center>
<script>
function deletpop(){
	return confirm("Do you really want to delete this record ? ");
}

</script>
