<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <%@ page import="java.util.ArrayList" %>   
 <%@ page import="dao.Dao" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Lisää ehdokas</title>
</head>
<body>
<h2>Lisää uusi ehdokas</h2>
<form action='../addCandidate' method='post'>
Etunimi: <input type='text' name='etunimi' value=''><br>
Sukunimi:<input type='text' name='sukunimi' value=''><br>
Puolue:<input type='text' name='puolue' value=''><br>
Kotikunta:<input type='text' name='kotikunta' value=''><br>
Ikä:<input type='text' name='ika' value=''><br>
Ammatti:<input type='text' name='ammatti' value=''><br>
Miksi haluat ehdolle?:<input type='text' name='miksi_haluat_ehdolle' value=''><br>
Mitä haluat edistää?:<input type='text' name='mita_haluat_edistaa' value=''><br>
<input type='submit' name='Tallenna' value='Send'>
</form>
</body>
</html>