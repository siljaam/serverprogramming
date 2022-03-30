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
	<th>Ikä</th>
	<th>Ammatti</th>
	<th>Miksi lähdit ehdolle eduskuntaan?</th>
	<th>Mitä asioita haluat edistää?</th>
</tr>
<c:forEach var="candidates" items="${sessionScope.allcandidates }">
	<tr>
		<td>${candidates.ehdokas_id }</td>
		<td>${candidates.etunimi }</td>
		<td>${candidates.sukunimi }</td>
		<td>${candidates.puolue }</td>
		<td>${candidates.kotikunta }</td>
		<td>${candidates.ika }</td>
		<td>${candidates.ammatti }</td>
		<td>${candidates.ehdolle }</td>
		<td>${candidates.edistaa }</td>

	</tr>
</c:forEach>
</table>

</body>
</html>