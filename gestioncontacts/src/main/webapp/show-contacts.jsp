<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> <!-- J'importe la lib des taglib -->
 <!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h2> Contacts </h2>

<table>

<c:forEach items ="${contacts }" var= "contact">

	<tr><td> ${contact.nom} </td>
		<td> ${contact.prenom }</td>
	</tr>
	
</c:forEach>

</table>



</body>
</html>