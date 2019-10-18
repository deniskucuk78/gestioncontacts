<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<br>

	<form method="get" action="ModifierContactServlet2">
	
		<label for="civilite"> Civilite :</label> <select name="civilite" id="civilite">
														<option value="M">M</option>
														<option value="Mme">Mme</option>
														<option value="Dr">Dr</option>
														<option value="Me">Me</option>
														<option value="Mlle">Mlle</option>
													</select>
		<label for="nom"> Nom :</label> <input type="text" name="nom" id="nom" value="${contact.nom }">
		<label for="prenom"> Prenom :</label> <input type="text" name="prenom" id="prenom" value="${contact.prenom }">
		<input type="hidden" name="id" id="identifiant" value="${contact.id }">												
													
	   <br> <input type="submit" value="Valider"/>
	    <br>
		
	
	</form>


<br>

	



</body>
</html>