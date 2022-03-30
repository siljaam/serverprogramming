<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
   <%@ page import="java.util.ArrayList" %>   
 <%@ page import="dao.Dao" %> 
 <%@ include file="../header.html" %> 



<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml" lang="en">
  <head>
    <meta http-equiv="content-type" content="application/xhtml+xml; charset=UTF-8" />
    <title>Vaalikone</title>
  </head>

  <body>
  
  <nav>
        <div class="container-fluid">
          <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarTogglerDemo01" aria-controls="navbarTogglerDemo01" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
          </button>
          <div class="collapse navbar-collapse" id="navbarTogglerDemo01">
            
            <ul class="navbar-nav mx-auto mb-2 mb-lg-0">
              <li class="nav-item">
                <a class="nav-link active" aria-current="page" href="#">Etusivu</a>
              </li>
              <li class="nav-item">
                <a class="nav-link active" href="jsp/showcandidates.jsp">Ehdokkaat</a>
              </li>
              <li class="nav-item">
                <a class="nav-link active" href="addCandidates.jsp">Lis�� ehdokas</a>
              </li>
              <li class="nav-item">
                <a class="nav-link active" href="">Yll�pito</a>
              </li>
            </ul>
            </div>
            </div>
      </nav>
  

  <h2>Tervetuloa vaalikoneeseen!</h2>
  
  <form action="">
    <input type="submit" value="Vastaa kysymyksiin" />
	</form>
 
 <footer>
 <p>Team 9 - Ville Lahtinen & Silja Markku </p>
 </footer>
  </body>
</html>