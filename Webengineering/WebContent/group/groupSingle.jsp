<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:useBean id="singleGroup" class="main.java.beans.SingleGroupBean" scope="session"></jsp:useBean>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<!-- META-DATA -->
<head>
   <title>MyComp - einzelneGruppe</title>
   <meta name="viewport" content="width=device-width, initial-scale=1">
   <link rel="stylesheet" href="../mainStyle.css">
   <link rel="stylesheet" href="singleGroupStyle.css">
   <link rel="stylesheet"
         href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
   <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>
   <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
   <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
   <link rel="stylesheet"
         href="https://use.fontawesome.com/releases/v5.8.2/css/all.css"
         integrity="sha384-oS3vJWv+0UjzBfQzYUhtDYW+Pj2yciDJxpsK1OYPAYjqT085Qq/1cq5FLXAZQ7Ay"
         crossorigin="anonymous">
</head>
<body>
<!-- Navigationbar -->
<nav class="navbar navbar-expand-md bg-dark navbar-dark"> <!-- Navbar Toggle -->
   <button class="navbar-toggler" type="button" data-toggle="collapse"
           data-target="#collapsibleNavbar">
       <span class="navbar-toggler-icon"></span>
   </button>
   <!-- Navbar Toggle END -->
   <div class="collapse navbar-collapse" id="collapsibleNavbar">
       <!-- Navbar Items Links-->
       <ul class="navbar-nav">
           <!-- Home -->
           <li class="nav-item">
               <a class="nav-link" href="../Startseite/Index.jsp">Home <i class="fas fa-home"></i></a>
           </li>
           <!--c:if test="${loggedin}"  JSP SCRIPT TO HIDE ELEMENTS-->
           <!-- Gruppen Dropdown-->
           <li class="nav-item dropdown">
               <a class="nav-link dropdown-toggle" href="#asd" id="navbardrop1"
                  data-toggle="dropdown">Gruppen <i class="fas fa-users"></i></a>
               <div class="dropdown-menu">
                   <a class="dropdown-item" href="asd">Gruppe 1</a>
                   <a class="dropdown-item" href="asd">Gruppe 2</a>
                   <a class="dropdown-item" href="asd">Gruppe 3</a>
               </div>
           </li>
           <!-- Zahlungen -->
           <li class="nav-item"><a class="nav-link" href="../Zahlungsuebersicht/Zahlungsuebersicht.jsp">Zahlungen
               <i class="fas fa-receipt"></i>
           </a></li>
       </ul>
       <!-- Navbar Items Rechts-->
       <ul class="navbar-nav ml-auto">
           <!-- Profil -->
           <li class="nav-item dropdown">
               <a class="nav-link dropdown-toggle" href="#asd" id="navbardrop2"
                  data-toggle="dropdown">Benutzer <i class="fas fa-user"></i></a>
               <div class="dropdown-menu dropdown-menu-right">
                   <a class="dropdown-item" href="#asd">Profil bearbeiten <i
                           class="fas fa-user-edit"></i>
                   </a> <a class="dropdown-item" href="#asd">Abmelden <i class="fas fa-sign-in-alt"></i>
               </a>
               </div>
           </li>
           <!-- /c:if -->
       </ul>
       <!-- Navbar Items END -->
   </div>
</nav>
<!-- Navigationbar END-->

<!-- BODY -->
<div class="backgroundSide">
   <div class="container-fluid">
       <div class="backgroundMid">

		<div class="overView group bg-dark">
			<h5>
				Gruppendaten:
			</h5>
			<p>
				<c:out value="${singleGroup.name}"></c:out>
				<br>
				<c:out value="${singleGroup.description}"></c:out>
				<br>
				<c:out value="${singleGroup.users}"></c:out>
				<br>
				<button type="button">Teilnehmer Hinzufügen</button>
				
			</p>
		</div>
		
		<div class="overView payment bg-dark">
			
			<h5>
				Letzte Zahlungen der Gruppe:
			</h5>
			<p class="singlePaymentFromOverview">
				Beteiligte: CK, CK2, CK3, CK4, CK5, CK6
				<br>
				Betrag:500€
				<br>
				<button type="Button">Zur Zahlung</button>
				<br>
			</p>
			<p class="singlePaymentFromOverview">
				Beteiligte:CK, CK2, CK3, CK4, CK5, CK6
				<br>
				Betrag:500€
				<br>
				<button type="Button">Zur Zahlung</button>
				<br>
			</p>
			<p class="singlePaymentFromOverview">
				Beteiligte:CK, CK2, CK3, CK4, CK5, CK6
				<br>
				Betrag:500€
				<br>
				<button type="Button">Zur Zahlung</button>
				<br>
			</p>
			<p class="singlePaymentFromOverview">
				Beteiligte:CK, CK2, CK3, CK4, CK5, CK6
				<br>
				Betrag:500€
				<br>
				<button type="Button">Zur Zahlung</button>
				<br>
			</p>
			<p>
				Beteiligte:CK, CK2, CK3, CK4, CK5, CK6
				<br>
				Betrag:500€
				<br>
				<button type="Button">Zur Zahlung</button>
			</p>
		</div>
       </div>
   </div>
</div>
<!-- BODY ENDE -->


<!--  Footer  -->
	<div class="container-fluid footer">
		<div class="footerCompany col-xs-6 mt-3">
			<p>
				<a href="imprint.jsp">Impressum</a>
			</p>
			<p>Ⓒ 2019 MyCompName</p>
		</div>
	</div>
	<!--  Footer END  -->
</body>
</html>

