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

<br>

	<form method="get" action="AjouterContactServlet">
	
		<label for="civilite"> Civilite :</label> <select name="civilite" id="civilite">
														<option value="M">M</option>
														<option value="Mme">Mme</option>
														<option value="Dr">Dr</option>
														<option value="Me">Me</option>
														<option value="Mlle">Mlle</option>
													</select>
		<label for="nom"> Nom :</label> <input type="text" name="nom" id="nom">
		<label for="prenom"> Prenom :</label> <input type="text" name="prenom" id="prenom">												
													
	   <br> <input type="submit" value="Valider"/>
		
	
	</form>


<br>

<table>

<c:forEach items ="${contacts }" var= "contact">

	<tr><td> ${contact.nom} </td>
		<td> ${contact.prenom }</td>
		<td><a href="SupprimerContactServlet?id=${contact.id }">(X)</a></td>
	</tr>
	
</c:forEach>

</table>



</body>
</html>