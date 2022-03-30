<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page import="java.util.ArrayList" %>
<%@ page import="app.Candidates" %>

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
<c:forEach var="candidate" items="${sessionScope.allcandidates }">
	<tr>
		<td>${candidate.ehdokas_id }</td>
		<td>${candidate.etunimi }</td>
		<td>${candidate.sukunimi }</td>
		<td>${candidate.puolue }</td>
		<td>${candidate.kotikunta }</td>
		<td>${candidate.ika }</td>
		<td>${candidate.ammatti }</td>
		<td>${candidate.ehdolle }</td>
		<td>${candidate.edistaa }</td>

	</tr>
</c:forEach>
</table>

</body>
</html>