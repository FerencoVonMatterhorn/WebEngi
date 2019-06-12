<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:useBean id="paymentOverview" class="main.java.beans.PaymentOverviewBean" scope="session"></jsp:useBean>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>MyWG - Zahlungen</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="../mainstyle.css">
<link rel="stylesheet" href="paymentOverviewStyle.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.2/css/all.css"
	integrity="sha384-oS3vJWv+0UjzBfQzYUhtDYW+Pj2yciDJxpsK1OYPAYjqT085Qq/1cq5FLXAZQ7Ay" crossorigin="anonymous">
</head>
<body>
	<nav class="navbar navbar-expand-md bg-dark navbar-dark"> <!--  Navbar Toggle  -->
	<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#collapsibleNavbar">
		<span class="navbar-toggler-icon"></span>
	</button>
	<div class="collapse navbar-collapse" id="collapsibleNavbar">
		<ul class="navbar-nav">
			<c:choose>
				<c:when test="${empty userID}">
					<li class="nav-item"><a class="nav-link" href="../official/index.jsp">Home <i class="fas fa-home"></i></a></li>
				</c:when>
				<c:otherwise>
					<li class="nav-item"><a class="nav-link" href="../official/IndexLoggedIn">Home <i class="fas fa-home"></i></a></li>
					<li class="nav-item"><a class="nav-link" href="../group/groupOverview.jsp">Gruppen <i class="fas fa-users"></i></a></li>
					<li class="nav-item"><a class="nav-link active" href="#">Zahlungen <i class="fas fa-receipt"></i></a></li>
				</c:otherwise>
			</c:choose>
		</ul>
		<ul class="navbar-nav ml-auto">
			<c:choose>
				<c:when test="${empty userID}">
					<li class="nav-item"><a class="nav-link" href="register.jsp">Registrieren <i class="fas fa-sign-in-alt"></i></a></li>
				</c:when>
				<c:otherwise>
					<li class="nav-item"><a class="nav-link" href="../user/profile.jsp">Profil <i class="fas fa-user"></i></a></li>
					<li class="nav-item"><a class="nav-link" href="../signOut">Abmelden <i class="fas fa-sign-in-alt"></i></a></li>
				</c:otherwise>
			</c:choose>
		</ul>
	</div>
	</nav>
	<div class="backgroundSide">
		<div class="container-fluid">
			<div class="backgroundMid">
				<div class="container pt-5">
					<div class="row justify-content-center">
					
						<c:forEach items="${paymentOverview.payments}" var="payment">
							<p class="widget">
								Gruppe: <c:out value="${payment.getGroupName()}"/><br>
								Beteiligte: <c:out value="${payment.getUsers()}"/> <br> Betrag:<c:out value="${payment.getAmount()}"/> <br>
								Typ: <br> Erstellt am: <c:out value="${payment.getDateCreated()}"/><br>
								<!-- if für Typ=Monatsabrechnung wenn -> Bezahlen bis -->
								<button class="btn btn-success"type="button">Zur Zahlung</button>
							</p>
						</c:forEach>
								
					</div>	
				</div>
				<div class="row justify-content-center mb-5 mt-3">
				
					<script language="javascript" type="text/javascript">
					
					function setPageSite(page){
						document.getElementById('page').value = page;
					}
					</script>
				
					<div class="row">
						<form>
							<ul class="pagination">
								<c:forEach begin="1" end="${paymentOverview.pages}" varStatus="loop">
									<input type="hidden" name="page" id="page" value="1" />
									<li class="page-item"><button type="submit" onclick="setPageSite(${loop.index})"><c:out value="${loop.index}"/></button></li>
								</c:forEach>
							</ul>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
	<div class="container-fluid footer">
		<div class="footerCompany col-xs-6 mt-3">
			<p>
				<a class="m-2" href="../official/imprint.jsp"">Impressum</a> <a class="m-2" href="../official/privacyPolicy.jsp">Privacy
					Policy</a>
			</p>
			<p>Ⓒ 2019 MyWG</p>
		</div>
	</div>
</body>
</html>

