<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
  
<!doctype html>
<html>
<head>
<title>Reservation</title>


</head>
<body>
	<h1>A faire une seule fois. (à gérer la suppression automatique)</h1>
	<div >
		<form:form action="${pageContext.request.contextPath}/admin/uploadFiles"  enctype="multipart/form-data" >
		 	<label>fichier excel pour créer les salles et équipements</label>
				<br/>	<br/>
			<input id="singleFileUploadInput" type="file" name="file" required />
			<br/>
		    <button type="submit" class=" submit-btn">Valider</button>
		</form:form>
 	 </div>		
	 <br/><br/>
	 <div >
				<form:form action="${pageContext.request.contextPath}/admin/uploadFiles"  enctype="multipart/form-data" >
				 	<label>fichier excel pour faire la réservation</label>
						<br/>
					<input id="singleFileUploadInput" type="file" name="file" required />
						<br/>
				    <button type="submit" class=" submit-btn">Valider</button>
				</form:form>
		 	 </div>
	 
  
  <hr/>
</body>
</html>