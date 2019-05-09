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
			<li class="nav-item active"><a class="nav-link" href="#asd">Home
					<i class="fas fa-home"></i>
			</a></li>
			<!--c:if test="${loggedin}"  JSP SCRIPT TO HIDE ELEMENTS-->
			<!-- Gruppen Dropdown-->
			<li class="nav-item dropdown"><a
				class="nav-link dropdown-toggle" href="#asd" id="navbardrop1"
				data-toggle="dropdown">Gruppen <i class="fas fa-users"></i></a>
				<div class="dropdown-menu">
					<a class="dropdown-item" href="asd">Gruppe 1</a> <a
						class="dropdown-item" href="asd">Gruppe 2</a> <a
						class="dropdown-item" href="asd">Gruppe 3</a>
				</div></li>
			<!-- Zahlungen -->
			<li class="nav-item"><a class="nav-link" href="#asd">Zahlungen
					<i class="fas fa-receipt"></i>
			</a></li>
		</ul>
		<!-- Navbar Items Rechts-->
		<ul class="navbar-nav ml-auto">
			<!-- Profil -->
			<li class="nav-item dropdown"><a
				class="nav-link dropdown-toggle" href="#asd" id="navbardrop2"
				data-toggle="dropdown">Benutzer <i class="fas fa-user"></i></a>
				<div class="dropdown-menu dropdown-menu-right">
					<a class="dropdown-item" href="#asd">Profil bearbeiten <i
						class="fas fa-user-edit"></i>
					</a> <a class="dropdown-item" href="#asd">Abmelden <i
						class="fas fa-sign-in-alt"></i>
					</a>
				</div></li>
			<!-- /c:if -->
			<li class="nav-item"><a class="nav-link" href="#asd">Registrieren
					<i class="fas fa-sign-in-alt"></i>
			</a></li>
		</ul>
		<!-- Navbar Items END -->
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
						Max Muster <br> Musterweg<br> 12345 Musterstadt <br>
					</p>
					<p>
						<strong>Vertreten durch: </strong><br> Max Muster<br>
						Christian idk<br>
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
						<br> <br> <strong>Google Analytics</strong><br> <br>
						Diese Website benutzt Google Analytics, einen Webanalysedienst der
						Google Inc. (''Google''). Google Analytics verwendet sog.
						''Cookies'', Textdateien, die auf Ihrem Computer gespeichert
						werden und die eine Analyse der Benutzung der Website durch Sie
						ermöglicht. Die durch den Cookie erzeugten Informationen über Ihre
						Benutzung dieser Website (einschließlich Ihrer IP-Adresse) wird an
						einen Server von Google in den USA übertragen und dort
						gespeichert. Google wird diese Informationen benutzen, um Ihre
						Nutzung der Website auszuwerten, um Reports über die
						Websiteaktivitäten für die Websitebetreiber zusammenzustellen und
						um weitere mit der Websitenutzung und der Internetnutzung
						verbundene Dienstleistungen zu erbringen. Auch wird Google diese
						Informationen gegebenenfalls an Dritte übertragen, sofern dies
						gesetzlich vorgeschrieben oder soweit Dritte diese Daten im
						Auftrag von Google verarbeiten. Google wird in keinem Fall Ihre
						IP-Adresse mit anderen Daten der Google in Verbindung bringen. Sie
						können die Installation der Cookies durch eine entsprechende
						Einstellung Ihrer Browser Software verhindern; wir weisen Sie
						jedoch darauf hin, dass Sie in diesem Fall gegebenenfalls nicht
						sämtliche Funktionen dieser Website voll umfänglich nutzen können.
						Durch die Nutzung dieser Website erklären Sie sich mit der
						Bearbeitung der über Sie erhobenen Daten durch Google in der zuvor
						beschriebenen Art und Weise und zu dem zuvor benannten Zweck
						einverstanden.<br> <br> <strong>Google AdSense</strong><br>
						<br> Diese Website benutzt Google Adsense, einen
						Webanzeigendienst der Google Inc., USA (''Google''). Google
						Adsense verwendet sog. ''Cookies'' (Textdateien), die auf Ihrem
						Computer gespeichert werden und die eine Analyse der Benutzung der
						Website durch Sie ermöglicht. Google Adsense verwendet auch sog.
						''Web Beacons'' (kleine unsichtbare Grafiken) zur Sammlung von
						Informationen. Durch die Verwendung des Web Beacons können
						einfache Aktionen wie der Besucherverkehr auf der Webseite
						aufgezeichnet und gesammelt werden. Die durch den Cookie und/oder
						Web Beacon erzeugten Informationen über Ihre Benutzung dieser
						Website (einschließlich Ihrer IP-Adresse) werden an einen Server
						von Google in den USA übertragen und dort gespeichert. Google wird
						diese Informationen benutzen, um Ihre Nutzung der Website im
						Hinblick auf die Anzeigen auszuwerten, um Reports über die
						Websiteaktivitäten und Anzeigen für die Websitebetreiber
						zusammenzustellen und um weitere mit der Websitenutzung und der
						Internetnutzung verbundene Dienstleistungen zu erbringen. Auch
						wird Google diese Informationen gegebenenfalls an Dritte
						übertragen, sofern dies gesetzlich vorgeschrieben oder soweit
						Dritte diese Daten im Auftrag von Google verarbeiten. Google wird
						in keinem Fall Ihre IP-Adresse mit anderen Daten der Google in
						Verbindung bringen. Das Speichern von Cookies auf Ihrer Festplatte
						und die Anzeige von Web Beacons können Sie verhindern, indem Sie
						in Ihren Browser-Einstellungen ''keine Cookies akzeptieren''
						wählen (Im MS Internet-Explorer unter ''Extras > Internetoptionen
						> Datenschutz > Einstellung''; im Firefox unter ''Extras >
						Einstellungen > Datenschutz > Cookies''); wir weisen Sie jedoch
						darauf hin, dass Sie in diesem Fall gegebenenfalls nicht sämtliche
						Funktionen dieser Website voll umfänglich nutzen können. Durch die
						Nutzung dieser Website erklären Sie sich mit der Bearbeitung der
						über Sie erhobenen Daten durch Google in der zuvor beschriebenen
						Art und Weise und zu dem zuvor benannten Zweck einverstanden.
					</p>
					<br> Impressum vom <a
						href="https://www.impressum-generator.de">Impressum Generator</a>
					der <a href="https://www.kanzlei-hasselbach.de/">Kanzlei
						Hasselbach, Rechtsanwälte für Arbeitsrecht und Familienrecht</a>
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