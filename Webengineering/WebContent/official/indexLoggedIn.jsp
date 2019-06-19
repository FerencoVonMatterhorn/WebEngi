<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:useBean id="userPojo" class="main.java.pojos.UserPojo" scope="session"></jsp:useBean>
<jsp:useBean id="groupPojo" class="main.java.pojos.GroupPojo" scope="session"></jsp:useBean>
<jsp:useBean id="paymentPojo" class="main.java.pojos.PaymentPojo" scope="session"></jsp:useBean>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
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
	<nav class="navbar navbar-expand-md bg-dark navbar-dark">
	<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#collapsibleNavbar">
		<span class="navbar-toggler-icon"></span>
	</button>
	<div class="collapse navbar-collapse" id="collapsibleNavbar">
		<ul class="navbar-nav">
			<c:choose>
				<c:when test="${empty userID}">
					<li class="nav-item"><a class="nav-link" href="../official/index">Home <i class="fas fa-home"></i></a></li>
				</c:when>
				<c:otherwise>
					<li class="nav-item"><a class="nav-link active" href="#">Home <i class="fas fa-home"></i></a></li>
					<li class="nav-item"><a class="nav-link" href="../group/groupOverview.jsp">Gruppen <i class="fas fa-users"></i></a></li>
					<li class="nav-item"><a class="nav-link" href="../payment/paymentOverview">Zahlungen <i class="fas fa-receipt"></i></a></li>
				</c:otherwise>
			</c:choose>
		</ul>
		<ul class="navbar-nav ml-auto">
			<c:choose>
				<c:when test="${empty userID}">
					<li class="nav-item"><a class="nav-link" href="register.jsp">Registrieren <i class="fas fa-sign-in-alt"></i></a></li>
				</c:when>
				<c:otherwise>
					<li class="nav-item"><a class="nav-link" href="../user/profile">Profil <i class="fas fa-user"></i></a></li>
					<li class="nav-item"><a class="nav-link" href="../signOut">Abmelden <i class="fas fa-sign-in-alt"></i></a></li>
				</c:otherwise>
			</c:choose>
		</ul>
	</div>
	</nav>
	<div class="backgroundSide">
		<div class="container-fluid">
			<div class="backgroundMid">
				<div class="row mb-4">
					<div class="text-center mx-auto">
						<h2 class="mt-5 mb-4">
							Willkommen zurück,
							<c:out value="${userPojo.username}"></c:out>
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
								<c:out value="${paymentPojo.groupName}"></c:out>
								<br> Betrag:
								<c:out value="${paymentPojo.amount} €"></c:out>
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
							<form name="createGroup" action="createGroup" method="POST" autocomplete="off">
								<div class="modal-dialog">
									<div class="modal-content">

										<!-- Modal Header -->
										<div class="modal-header">
											<h4 class="modal-title mx-auto">Neue Gruppe Erstellen</h4>
											<button type="button" class="close" data-dismiss="modal" onclick="clearGroupModal()">&times;</button>
										</div>
										<!-- Modal body -->
										<div class="modal-body">
											<div class="form-group">
												<label for="groupName">Gruppen Name:</label> <input type="text" class="form-control" id="groupName" name="groupName">
											</div>
											<div class="form-group">
												<label for="groupDescription">Gruppen Beschreibung:</label>
												<textarea class="form-control" id="groupDescription" name="groupDescription"></textarea>
											</div>
											<div class="form-group">
												<label for="groupParticipants">Teilnehmer:</label> <input type="text" class="form-control autocomplete"
													id="groupParticipants" name="groupParticipants">
											</div>
											<p id="testOut"></p>
										</div>
										<!-- Modal footer -->
										<div class="modal-footer">
											<button type="button" class="btn btn-danger" data-dismiss="modal" onclick="clearGroupModal()">Abbrechen</button>
											<button type="submit" class="btn btn-primary">Gruppe erstellen</button>
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
				<a class="m-2" href="imprint.jsp">Impressum</a> <a class="m-2" href="privacyPolicy.jsp">Privacy Policy</a>
			</p>
			<p>Ⓒ 2019 MyWG</p>
		</div>
	</div>
</body>
<script>
	var inp = document.getElementById("groupParticipants");
	searchUser(inp, inp.value);
</script>
</html>

