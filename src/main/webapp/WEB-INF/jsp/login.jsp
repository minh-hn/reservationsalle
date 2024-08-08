<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
    
    
<!doctype html>
<html>
<meta http-equiv="X-UA-Compatible" content="IE=11"> 
<head>
<title>Réservation</title>



</head>
<body>

	<div class="background">
    <div class="bg-color"> 
			<div class="container loginDiv">
				Bonjour, <br/>
				Veuillez vous identifier.
				
				<div class="panel-body">
					<div class="img-title row justify-content-center">
						
					</div>
				</div>
				<form action="${pageContext.request.contextPath}/login" method="post">
					<div class="row justify-content-center">
						<div class="col-6 input_connection">
							<input id="username" class="form-control" maxLength="30" name="username" placeholder="Utilisateur" autofocus>
						</div>
					</div>
					<div class="row justify-content-center">
						<div class="col-6 input_connection">
							<input id="password" class="form-control" type="password" maxLength="40" name="password" placeholder="Mot de passe">
						</div>
					</div>
					
					<div class="row justify-content-center input_connection">
						<input type="submit" class="btn-connect" value="Connexion"> 
					</div>
					
				</form>
				
			</div>
    </div>
  </div>
</body>
</html>