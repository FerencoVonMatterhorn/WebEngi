<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<!-- META-DATA -->
<head>
<title>MyComp - Home</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="../mainStyle.css">
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
	<!--  Navigationbar  -->
<nav class="navbar navbar-expand-md bg-dark navbar-dark">
    <!--  Navbar Toggle  -->
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#collapsibleNavbar">
        <span class="navbar-toggler-icon"></span>
    </button>
    <!--  Navbar Toggle END  -->
    <div class="collapse navbar-collapse" id="collapsibleNavbar">
        <!--  Navbar Items Links  -->
        <ul class="navbar-nav">
            <!--  Home  -->
            <li class="nav-item">
                <a class="nav-link" href="../Startseite/Index.jsp">Home <i class="fas fa-home"></i></a>
            </li>
            <!--  Gruppen  -->
            <li class="nav-item">
                <a class="nav-link" href="../Gruppenuebersicht/Gruppenuebersicht.jsp">Gruppen <i class="fas fa-users"></i></a>
            </li>
            <!--  Zahlungen  -->
            <li class="nav-item">
                <a class="nav-link" href="../Zahlungsuebersicht/Zahlungsuebersicht.jsp">Zahlungen <i class="fas fa-receipt"></i></a>
            </li>
        </ul>
        <!--  Navbar Items Rechts  -->
        <ul class="navbar-nav ml-auto">
            <!--  Profil  -->
            <li class="nav-item">
                <a class="nav-link" href="../Profil/Profil.jsp">Profil <i class="fas fa-user"></i></a>
            </li>
            <!--  Abmelden; TODO: abmelden.jsp erstellen  -->
            <li class="nav-item">
                <a class="nav-link" href="#abmelden">Abmelden <i class="fas fa-sign-in-alt"></i></a>
            </li>
        </ul>
        <!--  Navbar Items END  -->
    </div>
</nav>
<!-- Navigationbar END-->

	<!-- BODY -->
	<div class="backgroundSide">
		<div class="container-fluid">
			<div class="backgroundMid">
				<div class='impressum'>
					<h1>Impressum</h1>
					<p>Angaben gemäß § 5 TMG</p>
					<p>
						Bengt Joachimson <br> Ferenc Horvay<br> Christian Koller<br>
					</p>
					<p>
						<strong>Kontakt:</strong> <br> Telefon: 01234-789456<br>
						Fax: 1234-56789<br> E-Mail: <a href='mailto:max@muster.de'>max@muster.de</a><br>
					</p>
					<p>
						<strong>Umsatzsteuer-ID: </strong> <br>
						Umsatzsteuer-Identifikationsnummer gemäß §27a Umsatzsteuergesetz:
						Musterustid.<br> <br> <strong>Wirtschafts-ID: </strong><br>
						Musterwirtschaftsid<br>
					</p>
					<p>
						<strong>Aufsichtsbehörde:</strong><br> Musteraufsicht
						Musterstadt<br>
					</p>
					<p>
						<strong>Haftungsausschluss: </strong><br> <br> <strong>Haftung
							für Inhalte</strong><br> <br> Die Inhalte unserer Seiten wurden
						mit größter Sorgfalt erstellt. Für die Richtigkeit,
						Vollständigkeit und Aktualität der Inhalte können wir jedoch keine
						Gewähr übernehmen. Als Diensteanbieter sind wir gemäß § 7 Abs.1
						TMG für eigene Inhalte auf diesen Seiten nach den allgemeinen
						Gesetzen verantwortlich. Nach §§ 8 bis 10 TMG sind wir als
						Diensteanbieter jedoch nicht verpflichtet, übermittelte oder
						gespeicherte fremde Informationen zu überwachen oder nach
						Umständen zu forschen, die auf eine rechtswidrige Tätigkeit
						hinweisen. Verpflichtungen zur Entfernung oder Sperrung der
						Nutzung von Informationen nach den allgemeinen Gesetzen bleiben
						hiervon unberührt. Eine diesbezügliche Haftung ist jedoch erst ab
						dem Zeitpunkt der Kenntnis einer konkreten Rechtsverletzung
						möglich. Bei Bekanntwerden von entsprechenden Rechtsverletzungen
						werden wir diese Inhalte umgehend entfernen.<br> <br> <strong>Haftung
							für Links</strong><br> <br> Unser Angebot enthält Links zu
						externen Webseiten Dritter, auf deren Inhalte wir keinen Einfluss
						haben. Deshalb können wir für diese fremden Inhalte auch keine
						Gewähr übernehmen. Für die Inhalte der verlinkten Seiten ist stets
						der jeweilige Anbieter oder Betreiber der Seiten verantwortlich.
						Die verlinkten Seiten wurden zum Zeitpunkt der Verlinkung auf
						mögliche Rechtsverstöße überprüft. Rechtswidrige Inhalte waren zum
						Zeitpunkt der Verlinkung nicht erkennbar. Eine permanente
						inhaltliche Kontrolle der verlinkten Seiten ist jedoch ohne
						konkrete Anhaltspunkte einer Rechtsverletzung nicht zumutbar. Bei
						Bekanntwerden von Rechtsverletzungen werden wir derartige Links
						umgehend entfernen.<br> <br> <strong>Urheberrecht</strong><br>
						<br> Die durch die Seitenbetreiber erstellten Inhalte und
						Werke auf diesen Seiten unterliegen dem deutschen Urheberrecht.
						Die Vervielfältigung, Bearbeitung, Verbreitung und jede Art der
						Verwertung außerhalb der Grenzen des Urheberrechtes bedürfen der
						schriftlichen Zustimmung des jeweiligen Autors bzw. Erstellers.
						Downloads und Kopien dieser Seite sind nur für den privaten, nicht
						kommerziellen Gebrauch gestattet. Soweit die Inhalte auf dieser
						Seite nicht vom Betreiber erstellt wurden, werden die
						Urheberrechte Dritter beachtet. Insbesondere werden Inhalte
						Dritter als solche gekennzeichnet. Sollten Sie trotzdem auf eine
						Urheberrechtsverletzung aufmerksam werden, bitten wir um einen
						entsprechenden Hinweis. Bei Bekanntwerden von Rechtsverletzungen
						werden wir derartige Inhalte umgehend entfernen.<br> <br>
						<strong>Datenschutz</strong><br> <br> Die Nutzung
						unserer Webseite ist in der Regel ohne Angabe personenbezogener
						Daten möglich. Soweit auf unseren Seiten personenbezogene Daten
						(beispielsweise Name, Anschrift oder eMail-Adressen) erhoben
						werden, erfolgt dies, soweit möglich, stets auf freiwilliger
						Basis. Diese Daten werden ohne Ihre ausdrückliche Zustimmung nicht
						an Dritte weitergegeben. <br> Wir weisen darauf hin, dass die
						Datenübertragung im Internet (z.B. bei der Kommunikation per
						E-Mail) Sicherheitslücken aufweisen kann. Ein lückenloser Schutz
						der Daten vor dem Zugriff durch Dritte ist nicht möglich. <br>
						Der Nutzung von im Rahmen der Impressumspflicht veröffentlichten
						Kontaktdaten durch Dritte zur Übersendung von nicht ausdrücklich
						angeforderter Werbung und Informationsmaterialien wird hiermit
						ausdrücklich widersprochen. Die Betreiber der Seiten behalten sich
						ausdrücklich rechtliche Schritte im Falle der unverlangten
						Zusendung von Werbeinformationen, etwa durch Spam-Mails, vor.<br>
					</p>
				</div>
			</div>
		</div>
	</div>
	<!-- BODY ENDE -->



	<!-- Footer -->
	<div class="container-fluid footer">
		<div class="footerCompany col-xs-6 mt-3">
			<p>
				<a href="#impressum">Impressum</a>
			</p>
			<p>Ⓒ 2019 MyCompName</p>
		</div>
	</div>
	<!-- Footer ENDE-->
</body>
</html>