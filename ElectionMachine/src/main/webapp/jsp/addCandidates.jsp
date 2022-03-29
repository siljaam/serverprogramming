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

<form>
<label for="etunimi">Etunimi</label> <br>
<input type="text" id="etunimi" name="etunimi"> <br><br>
<label for="sukunimi">Sukunimi</label> <br>
<input type="text" id="sukunimi" name="sukunimi"> <br><br>
<label for="puolue">Puolue</label> <br>
<input type="text" id="puolue" name="puolue"> <br><br>
<label for="kotipaikkakunta">Kotikunta</label> <br>
<input type="text" id="kotipaikkakunta" name="kotipaikkakunta"> <br><br>
<label for="Ika">Ikä</label> <br>
<input type="text" id="ika" name="ika"> <br><br>
<label for="ammatti">Ammatti</label> <br>
<input type="text" id="ammatti" name="ammatti"> <br><br>
<label for="miksi_eduskuntaan">Miksi haluat ehdolle?</label> <br>
<textarea id="ehdolle" name="ehdolle" rows="3" cols="40">
</textarea> <br><br>
<label for="edistaa">Mitä asioita haluat edistää?</label> <br>
<textarea id="edistaa" name="edistaa" rows="3" cols="40">
</textarea> <br><br>
<input type='submit' name='Tallenna' value='Send'>
</form>
</body>
</html>