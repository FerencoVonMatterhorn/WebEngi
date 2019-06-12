<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>MyWG - Impressum</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="../mainstyle.css">
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
					<li class="nav-item"><a class="nav-link" href="index.jsp">Home <i class="fas fa-home"></i></a></li>
				</c:when>
				<c:otherwise>
					<li class="nav-item"><a class="nav-link" href="../official/IndexLoggedIn">Home <i class="fas fa-home"></i></a></li>
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
				<div class="row mx-auto justify-content-center">
					<h1 class="mt-5 mb-3">Impressum</h1>
				</div>
				<div class="row mx-auto justify-content-center mb-5">
					<div class="card m-3" style="width: 400px">
						<img class="card-img-top" src="../resources/p1.jpeg" style="border-bottom: 2px solid black;">
						<div class="card-body">
							<h4 class="card-title">Bengt Joachimsohn</h4>
							<p class="card-text">
								Adresse: Kiefernweg 11, 76149 Karlsruhe <br>Tlf. Nr.:+0049 157-789-948 32<br>Role: Frontend-Management x)
							</p>
							<a href="mailto:bengt@joachimsohn.de" class="btn btn-primary">Email me</a>
						</div>
					</div>
					<!-- Ferenc Horvay FIXME: Email einfüge, Text einfügen-->
					<div class="card m-3" style="width: 400px">
						<img class="card-img-top" src="../resources/p2.png" style="border-bottom: 2px solid black;">
						<div class="card-body">
							<h4 class="card-title">Ferenc Horvay</h4>
							<p class="card-text">Some example text.</p>
							<a href="#" class="btn btn-primary">Email me</a>
						</div>
					</div>
					<!-- Christian Koller FIXME: Email einfügen, Text einfügen-->
					<div class="card m-3" style="width: 400px">
						<img class="card-img-top" src="../resources/p3.jpeg" style="border-bottom: 2px solid black;">
						<div class="card-body">
							<h4 class="card-title">Christian Koller</h4>
							<p class="card-text">Some example text.</p>
							<a href="mailto:" class="btn btn-primary">Email me</a>
						</div>
					</div>
				</div>
				<div class="row mx-auto justify-content-center">
					<p>Angaben gemäß § 5 TMG</p>
				</div>
				<div class="row mx-auto justify-content-center">
					<h1>Haftungsausschluss:</h1>
				</div>
				<div class="row mx-auto justify-content-center" style="width: 60%">
					<h2>Haftung für Inhalte</h2>
					<p>Die Inhalte unserer Seiten wurden mit größter Sorgfalt erstellt. Für die Richtigkeit, Vollständigkeit und Aktualität
						der Inhalte können wir jedoch keine Gewähr übernehmen. Als Diensteanbieter sind wir gemäß § 7 Abs.1 TMG für eigene Inhalte
						auf diesen Seiten nach den allgemeinen Gesetzen verantwortlich. Nach §§ 8 bis 10 TMG sind wir als Diensteanbieter jedoch
						nicht verpflichtet, übermittelte oder gespeicherte fremde Informationen zu überwachen oder nach Umständen zu forschen, die
						auf eine rechtswidrige Tätigkeit hinweisen. Verpflichtungen zur Entfernung oder Sperrung der Nutzung von Informationen nach
						den allgemeinen Gesetzen bleiben hiervon unberührt. Eine diesbezügliche Haftung ist jedoch erst ab dem Zeitpunkt der
						Kenntnis einer konkreten Rechtsverletzung möglich. Bei Bekanntwerden von entsprechenden Rechtsverletzungen werden wir diese
						Inhalte umgehend entfernen.</p>
				</div>
				<div class="row mx-auto justify-content-center" style="width: 60%">
					<h2>Haftung für Links</h2>
					<p>Unser Angebot enthält Links zu externen Webseiten Dritter, auf deren Inhalte wir keinen Einfluss haben. Deshalb können
						wir für diese fremden Inhalte auch keine Gewähr übernehmen. Für die Inhalte der verlinkten Seiten ist stets der jeweilige
						Anbieter oder Betreiber der Seiten verantwortlich. Die verlinkten Seiten wurden zum Zeitpunkt der Verlinkung auf mögliche
						Rechtsverstöße überprüft. Rechtswidrige Inhalte waren zum Zeitpunkt der Verlinkung nicht erkennbar. Eine permanente
						inhaltliche Kontrolle der verlinkten Seiten ist jedoch ohne konkrete Anhaltspunkte einer Rechtsverletzung nicht zumutbar.
						Bei Bekanntwerden von Rechtsverletzungen werden wir derartige Links umgehend entfernen.</p>
				</div>
				<div class="row mx-auto justify-content-center" style="width: 60%">
					<h2>Urheberrecht</h2>
					<p>Die durch die Seitenbetreiber erstellten Inhalte und Werke auf diesen Seiten unterliegen dem deutschen Urheberrecht.
						Die Vervielfältigung, Bearbeitung, Verbreitung und jede Art der Verwertung außerhalb der Grenzen des Urheberrechtes bedürfen
						der schriftlichen Zustimmung des jeweiligen Autors bzw. Erstellers. Downloads und Kopien dieser Seite sind nur für den
						privaten, nicht kommerziellen Gebrauch gestattet. Soweit die Inhalte auf dieser Seite nicht vom Betreiber erstellt wurden,
						werden die Urheberrechte Dritter beachtet. Insbesondere werden Inhalte Dritter als solche gekennzeichnet. Sollten Sie
						trotzdem auf eine Urheberrechtsverletzung aufmerksam werden, bitten wir um einen entsprechenden Hinweis. Bei Bekanntwerden
						von Rechtsverletzungen werden wir derartige Inhalte umgehend entfernen.</p>
				</div>
				<div class="row mx-auto justify-content-center" style="width: 60%">
					<h2>Datenschutz</h2>
					<p>Die Nutzung unserer Webseite ist in der Regel ohne Angabe personenbezogener Daten möglich. Soweit auf unseren Seiten
						personenbezogene Daten (beispielsweise Name, Anschrift oder eMail-Adressen) erhoben werden, erfolgt dies, soweit möglich,
						stets auf freiwilliger Basis. Diese Daten werden ohne Ihre ausdrückliche Zustimmung nicht an Dritte weitergegeben.</p>
					<p>Wir weisen darauf hin, dass die Datenübertragung im Internet (z.B. bei der Kommunikation per E-Mail) Sicherheitslücken
						aufweisen kann. Ein lückenloser Schutz der Daten vor dem Zugriff durch Dritte ist nicht möglich.</p>
					<p>Der Nutzung von im Rahmen der Impressumspflicht veröffentlichten Kontaktdaten durch Dritte zur Übersendung von nicht
						ausdrücklich angeforderter Werbung und Informationsmaterialien wird hiermit ausdrücklich widersprochen. Die Betreiber der
						Seiten behalten sich ausdrücklich rechtliche Schritte im Falle der unverlangten Zusendung von Werbeinformationen, etwa durch
						Spam-Mails, vor.</p>
				</div>
				<div class="placeholder mb-5"></div>
			</div>
		</div>
	</div>
	<div class="container-fluid footer">
		<div class="footerCompany col-xs-6 mt-3">
			<p>
				<a class="m-2" href="#">Impressum</a> <a class="m-2" href="privacyPolicy.jsp">Privacy Policy</a>
			</p>
			<p>Ⓒ 2019 MyWG</p>
		</div>
	</div>
</body>
</html>