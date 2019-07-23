<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:useBean id="monthlyPayment"
	class="main.java.beans.MonthlyPaymentBean" scope="session"></jsp:useBean>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<!--  META-DATA  -->
<head>
<title>MyWG - Zahlung</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="../mainstyle.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.8.2/css/all.css"
	integrity="sha384-oS3vJWv+0UjzBfQzYUhtDYW+Pj2yciDJxpsK1OYPAYjqT085Qq/1cq5FLXAZQ7Ay"
	crossorigin="anonymous">

</head>
<body>

	<script language="javascript" type="text/javascript">
					
					function setPaymentID(paymentId){
						document.getElementById('paymentIDHidden').value = paymentId;
					}
	</script>

	<nav class="navbar navbar-expand-md bg-dark navbar-dark"> <!--  Navbar Toggle  -->
	<button class="navbar-toggler" type="button" data-toggle="collapse"
		data-target="#collapsibleNavbar">
		<span class="navbar-toggler-icon"></span>
	</button>
	<div class="collapse navbar-collapse" id="collapsibleNavbar">
		<ul class="navbar-nav">
			<c:choose>
				<c:when test="${empty userID}">
					<li class="nav-item"><a class="nav-link active"
						href="../official/index">Home <i class="fas fa-home"></i></a></li>
				</c:when>
				<c:otherwise>
					<li class="nav-item"><a class="nav-link"
						href="../official/IndexLoggedIn">Home <i class="fas fa-home"></i></a></li>
					<li class="nav-item"><a class="nav-link"
						href="../group/groupOverview">Gruppen <i class="fas fa-users"></i></a></li>
					<li class="nav-item"><a class="nav-link"
						href="../payment/paymentOverview">Zahlungen <i
							class="fas fa-receipt"></i></a></li>
				</c:otherwise>
			</c:choose>
		</ul>
		<ul class="navbar-nav ml-auto">
			<c:choose>
				<c:when test="${empty userID}">
					<li class="nav-item"><a class="nav-link" href="register.jsp">Registrieren
							<i class="fas fa-sign-in-alt"></i>
					</a></li>
				</c:when>
				<c:otherwise>
					<li class="nav-item"><a class="nav-link"
						href="../user/profile">Profil <i class="fas fa-user"></i></a></li>
					<li class="nav-item"><a class="nav-link" href="../signOut">Abmelden
							<i class="fas fa-sign-in-alt"></i>
					</a></li>
				</c:otherwise>
			</c:choose>
		</ul>
	</div>
	</nav>
	<div class="backgroundSide">
		<div class="container-fluid">
			<div class="backgroundMid">
				<div class="container">
					<!--  row Überschrift  -->
					<div class="row justify-content-center">
						<h1 class="pt-5 text-center">
							Monatszahlung vom <c:out value = "${monthlyPayment.getMonthlyPayment().getDateCreated().getMonth().getValue() }"/>.<c:out value="${monthlyPayment.getMonthlyPayment().getDateCreated().getYear()}"/>
						</h1>
					</div>
					<!--  row Überschrift END  -->
					<!--  row Table  -->
					<form action="../payment/SinglePayment">
						<div class="row col-10 mx-auto mt-5 mb-5">

							<input type="hidden" name="paymentID" id="paymentIDHidden" />
							<table class="table table-striped bg-dark text-white">
								<thead>
									<tr>
										<th>Zahlung</th>
										<th>Betrag</th>
										<th>Zur Zahlung</th>
									</tr>
								</thead>

								<tbody>
									<c:forEach items="${monthlyPayment.getPayments()}"
										var="payment" varStatus="loop">
										<tr>
											<td><c:out value="${payment.getPaymentDescription()}" /></td>
											<td><button class="paymentBtn btn btn-success"
													type="submit"
													onclick="setPaymentID(${payment.getPaymentID()})">Zur
													Zahlung</button></td>
											<td><c:out
													value="${monthlyPayment.getSingleAmount(monthlyPayment.getPaymentToUser().get(loop.index), payment)}" /></td>
										</tr>
									</c:forEach>


								</tbody>

								<tfooter>
								<tr>
									<td></td>
									<td>Zu zahlen:</td>
									<td><c:out value="${monthlyPayment.calculateTotal()}" /></td>
								</tr>
								</tfooter>
							</table>
						</div>
					</form>

					<!--  row Table END  -->
				</div>
			</div>
		</div>
	</div>
	<div class="container-fluid footer">
		<div class="footerCompany col-xs-6 mt-3">
			<p>
				<a class="m-2" href="imprint.jsp">Impressum</a> <a class="m-2"
					href="privacyPolicy.jsp">Privacy Policy</a>
			</p>
			<p>Ⓒ 2019 MyWG</p>
		</div>
	</div>
</body>
</html>