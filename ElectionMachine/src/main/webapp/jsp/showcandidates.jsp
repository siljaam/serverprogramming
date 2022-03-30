<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page import="java.util.ArrayList" %>
<%@ page import="app.Candidates" %>
 <%@ include file="../header.html" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Ehdokkaat</title>
</head>
<body>

<table>
<tr>
	<th>Ehdokas Id</th>
	<th>Etunimi</th>
	<th>Sukunimi</th>
	<th>Puolue</th>
	<th>Kotikunta</th>
	<th>Ik�</th>
	<th>Ammatti</th>
	<th>Miksi l�hdit ehdolle eduskuntaan?</th>
	<th>Mit� asioita haluat edist��?</th>
</tr>

<c:forEach var="candidate" items="${requestScope.candidateslist}" >

<h2><b>${candidate.ehdokas_id}:</b> ${candidate.etunimi} ${candidate.sukunimi} </h2>

<b>Puolue: </b><br>

${candidate.puolue} <br>

<b>Kotipaikkakunta:</b><br>

${candidate.kotikunta}<br>

<b>Ik�: </b><br>

${candidate.ika}<br>

<b>Ammatti:</b><br>

${candidate.ammatti}<br>

<b>Miksi haluat eduskuntaan?</b><br>

${candidate.ehdolle}<br>

<b>Mit� asioita haluat edist��?</b><br>

${candidate.edistaa}<br>

<br> <br>



</c:forEach>
</table>

</body>
</html>