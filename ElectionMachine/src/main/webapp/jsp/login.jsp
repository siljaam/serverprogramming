<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ include file="../header.html" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Vaalikone</title>
</head>
<body>
    <div style="text-align: center">
        <h1>Ylläpito</h1>
        <form action="login" method="post">
            <label for="email">Sähköposti:</label>
            <input name="email" size="30" />
            <br><br>
            <label for="password">Salasana:</label>
            <input type="password" name="password" size="30" />
            <br>${message}
            <br><br>           
            <button type="submit">Kirjaudu</button>
        </form>
    </div>
</body>
</html>