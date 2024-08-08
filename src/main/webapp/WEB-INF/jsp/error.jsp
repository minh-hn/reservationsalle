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

	<body>
		<div class="panel panel-default container">
		 <div class="panel-body">
		   <div class="row justify-content-center error-title">
		        <h2>Une erreur a eu lieu. Merci de contacter le HelpDesk</h2>
		   </div>
	   </div>
		  <div class="panel-body error-body">
	      
		    <div class="row">
		      <div class="col-md-3">code de l'erreur : </div> <div class="col-4">${error_code}</div>
		    </div>
		    <div class="row">
		      <div class="col-md-3">URL demand:</div> <div class="col-4">${error_uri}</div>
		    </div>
		    <div class="row">
	        <div class="col-md-3">Params :</div> <div class="col-4">${params}</div>
	      </div>
		    <div class="row error-detail">
		       <div class="col-sm-3">detail de l'erreur :</div>
		       <div class="col-9 border"><pre><code><c:out value="${error_message}"/></code></pre></div>
		    </div>
			</div>
		 <div class="row justify-content-center">
			 Merci de fournir ces ddans votre ticket.
		 </div>
			
		</div>

</body>
</html>