<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:useBean id="userPojo" class="main.java.pojos.UserPojo" scope="session"></jsp:useBean>
<jsp:useBean id="groupPojo" class="main.java.pojos.GroupPojo" scope="session"></jsp:useBean>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<!-- META-DATA -->
<head>
<title>MyWG - Home</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="../mainstyle.css">
<script type="text/javascript" src="../scripts.js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.2/css/all.css"
	integrity="sha384-oS3vJWv+0UjzBfQzYUhtDYW+Pj2yciDJxpsK1OYPAYjqT085Qq/1cq5FLXAZQ7Ay" crossorigin="anonymous">
</head>
<body>
	<!--  Navigationbar  -->
	<nav class="navbar navbar-expand-md bg-dark navbar-dark"> <!--  Navbar Toggle  -->
	<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#collapsibleNavbar">
		<span class="navbar-toggler-icon"></span>
	</button>
	<!--  Navbar Toggle END  -->
	<div class="collapse navbar-collapse" id="collapsibleNavbar">
		<!--  Navbar Items Links  -->
		<ul class="navbar-nav">
			<c:choose>
				<c:when test="${empty userID}">
					<!--  Home  -->
					<li class="nav-item"><a class="nav-link" href="index.jsp">Home <i class="fas fa-home"></i></a></li>
				</c:when>
				<c:otherwise>
					<!-- Home LoggedIn -->
					<li class="nav-item"><a class="nav-link active" href="#">Home <i class="fas fa-home"></i></a></li>
					<!--  Gruppen  -->
					<li class="nav-item"><a class="nav-link" href="../group/groupOverview.jsp">Gruppen <i class="fas fa-users"></i></a></li>
					<!--  Zahlungen  -->
					<li class="nav-item"><a class="nav-link" href="../payment/paymentOverview.jsp">Zahlungen <i class="fas fa-receipt"></i></a></li>
				</c:otherwise>
			</c:choose>
		</ul>
		<!--  Navbar Items Rechts  -->
		<ul class="navbar-nav ml-auto">
			<c:choose>
				<c:when test="${empty userID}">
					<!-- Registrieren -->
					<li class="nav-item"><a class="nav-link" href="register.jsp">Registrieren <i class="fas fa-sign-in-alt"></i></a></li>
				</c:when>
				<c:otherwise>
					<!--  Profil  -->
					<li class="nav-item"><a class="nav-link" href="../user/profile.jsp">Profil <i class="fas fa-user"></i></a></li>
					<!-- Abmelden TODO: abmelden Servlet-->
					<li class="nav-item"><a class="nav-link" href="../signOut">Abmelden <i class="fas fa-sign-in-alt"></i></a></li>
				</c:otherwise>
			</c:choose>
		</ul>
		<!--  Navbar Items END  -->
	</div>
	</nav>
	<!-- Navigationbar END-->

	<!-- BODY -->
	<div class="backgroundSide">
		<div class="container-fluid">
			<div class="backgroundMid">
				<div class="row mb-4">
					<div class="text-center mx-auto">
						<h2 class="mt-5 mb-4">
							Willkommen zurück,
							<c:out value="${userName}"></c:out>
						</h2>
						<p>Hier ist ein überblick über deine letzte Zahlung und top Gruppe.</p>
						<p style="margin-top: -0.6rem">Du kannst hier auch eine Zahlung erstellen.</p>
					</div>
				</div>
				<div class="container">
					<div class="row justify-content-center">
						<div class="widget shadow">
							<div class="text-center">
								<h4>Deine Top-Gruppe</h4>
							</div>
							<p>
								Name:
								<c:out value="${groupPojo.groupName}"></c:out>
								<br> Beschreibung:
								<c:out value="${groupPojo.groupDescription}"></c:out>
								<br> Teilnehmer:
								<c:out value="${groupPojo.users}"></c:out>
								<br>
							</p>
						</div>
						<div class="widget shadow">
							<div class="text-center">
								<h4>Deine Letzte Zahlung</h4>
							</div>
							<p>
								Gruppe:
								<c:out value="${paymentGroup}"></c:out>
								<br> Betrag:
								<c:out value="${paymentAmount}"></c:out>
							</p>
						</div>
					</div>
				</div>
				<div class="row m-5">
					<div class="text-center mx-auto">
						<button class="btn btn-success mr-5" type="button" data-toggle="modal" data-target="#newGroupModal">Neue Gruppe</button>
						<button class="btn btn-success" type="button" data-toggle="modal" data-target="#newPaymentModal">Neue Zahlung</button>
						<!-- modal gruppe start -->
						<div class="modal fade" id="newGroupModal">
							<form name="creatGroup" action="createGroup" method="POST">
								<div class="modal-dialog">
									<div class="modal-content">

										<!-- Modal Header -->
										<div class="modal-header">
											<h4 class="modal-title mx-auto">Neue Gruppe Erstellen</h4>
											<button type="button" class="close" data-dismiss="modal" onclick="deleteEntries()">&times;</button>
										</div>
										<!-- Modal body -->
										<div class="modal-body">
											<div class="form-group">
												<label for="groupName">Gruppen Name:</label> <input type="text" class="form-control" id="groupName">
											</div>
											<div class="form-group">
												<label for="groupDescription">Gruppen Beschreibung:</label> <input type="text" class="form-control"
													id="groupDescription">
											</div>
											<div class="form-group">
												<label for="groupParticipants">Teilnehmer :</label> <input type="text" class="form-control" id="groupParticipants"
													onkeyup="searchUser()" name="participantsSearch">
											</div>
										</div>

										<!-- Modal footer -->
										<div class="modal-footer">
											<button type="button" class="btn btn-danger" data-dismiss="modal" onclick="deleteEntries()">Abbrechen</button>
											<button type="submit" class="btn btn-primary">Gruppe erstellen</button>
										</div>
									</div>
								</div>
							</form>
						</div>
						<!-- modal end -->
						<!-- modal zahlung start -->
						<div class="modal fade" id="newPaymentModal">
							<form name="createPayment" action="createPayment" method="POST">
								<div class="modal-dialog">
									<div class="modal-content">

										<!-- Modal Header -->
										<div class="modal-header">
											<h4 class="modal-title mx-auto">Neue Zahlung Erstellen</h4>
											<button type="button" class="close" data-dismiss="modal" onclick="deleteEntries()">&times;</button>
										</div>
										<!-- Modal body -->
										<div class="modal-body">
											<div class="form-group">
												<label for="paymentName">Muster-Text:</label> <input type="text" class="form-control" id="paymentName">
											</div>
											<div class="form-group">
												<label for="payment">Muster-Text:</label> <input type="text" class="form-control" id="payment">
											</div>


											<!-- Modal footer -->
											<div class="modal-footer">
												<button type="button" class="btn btn-danger" data-dismiss="modal" onclick="deleteEntries()">Abbrechen</button>
												<button type="submit" class="btn btn-primary">Zahlung erstellen</button>
											</div>
										</div>
									</div>
								</div>
							</form>
						</div>
						<!-- modal end -->
					</div>
				</div>
				<div class="placeholder mb-5"></div>
			</div>
		</div>
	</div>
	<div class="container-fluid footer">
		<div class="footerCompany col-xs-6 mt-3">
			<p>
				<a class="m-2" href="imprint.jsp">Impressum</a> <a class="m-2" href="privacyPolicy.jsp">Privace Policy</a>
			</p>
			<p>Ⓒ 2019 MyWG</p>
		</div>
	</div>
</body>
</html>

