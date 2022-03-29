<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.Candidates" %> 


    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Muokkaa ehdokkaita</title>
</head>
<body>
<h2>Muokkaa ehdokkaiden tietoja</h2>
<form action='./editgame' method='post'>
		Etunimi: <input type='text' name='breed' value='${sessionScope.candidates.etunimi }'><br>
		Sukunimi: <input type='text' name='weight' value='${sessionScope.candidates.sukunimi }'><br>
		Puolue: <input type='text' name='breed' value='${sessionScope.candidates.puolue }'><br>
		Kotikunta: <input type='text' name='breed' value='${sessionScope.candidates.kotikunta }'><br>
		Ikä: <input type='text' name='breed' value='${sessionScope.candidates.ika }'><br>
		Ammatti: <input type='text' name='breed' value='${sessionScope.candidates.ammatti }'><br>
		Miksi ehdolle: <input type='text' name='breed' value='${sessionScope.candidates.ehdolle}'><br>
		Mitä haluat edistää: <input type='text' name='breed' value='${sessionScope.candidates.edistaa }'><br>
		
		<input type="hidden" name="id" value="${sessionScope.candidates.id }">
				
		<input type='submit' name='ok' value='Muokkaa'>
	</form>

</body>
</html>