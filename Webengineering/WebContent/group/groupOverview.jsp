<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<!-- META-DATA -->
<head>
<title>MyComp - Home</title>
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
	<!--  Navigationbar  -->
	<nav class="navbar navbar-expand-md bg-dark navbar-dark"> <!--  Navbar Toggle  -->
	<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#collapsibleNavbar">
		<span class="navbar-toggler-icon"></span>
	</button>
	<!--  Navbar Toggle END  -->
	<div class="collapse navbar-collapse" id="collapsibleNavbar">
		<!--  Navbar Items Links  -->
		<ul class="navbar-nav">
			<!--  Home  -->
			<li class="nav-item"><a class="nav-link" href="../Startseite/Index.jsp">Home <i class="fas fa-home"></i></a></li>
			<!--  Gruppen  -->
			<li class="nav-item"><a class="nav-link active" href="../Gruppenuebersicht/Gruppenuebersicht.jsp">Gruppen <i
					class="fas fa-users"></i></a></li>
			<!--  Zahlungen  -->
			<li class="nav-item"><a class="nav-link" href="../Zahlungsuebersicht/Zahlungsuebersicht.jsp">Zahlungen <i
					class="fas fa-receipt"></i></a></li>
		</ul>
		<!--  Navbar Items Rechts  -->
		<ul class="navbar-nav ml-auto">
			<!--  Profil  -->
			<li class="nav-item"><a class="nav-link" href="../Profil/Profil.jsp">Profil <i class="fas fa-user"></i></a></li>
			<!--  Abmelden; TODO: abmelden.jsp erstellen  -->
			<li class="nav-item"><a class="nav-link" href="#abmelden">Abmelden <i class="fas fa-sign-in-alt"></i></a></li>
		</ul>
		<!--  Navbar Items END  -->
	</div>
	</nav>
	<!-- Navigationbar END-->

	<!-- BODY -->
	<div class="backgroundSide">
		<div class="container-fluid">
			<div class="backgroundMid">
				<div class="container">
					<div class="row row-offcanvas row-offcanvas-right">
						<div class="col-12 col-md-9">
							<div class="jumbotron">
								<h1>Gruppenübersicht</h1>
								<p>This is an example to show the potential of an offcanvas layout pattern in Bootstrap. Try some responsive-range
									viewport sizes to see it in action.</p>
							</div>
							<div class="row">
								<div class="col-6 col-lg-4">
									<h2>Gruppe 1</h2>
									<p>Donec id elit non mi porta gravida at eget metus. Fusce dapibus, tellus ac cursus commodo, tortor mauris
										condimentum nibh, ut fermentum massa justo sit amet risus. Etiam porta sem malesuada magna mollis euismod. Donec sed
										odio dui.</p>
									<p>
										<a class="btn btn-secondary" href="#" role="button">Mehr anzeigen &raquo;</a>
									</p>
								</div>
								<!--/span-->
								<div class="col-6 col-lg-4">
									<h2>Gruppe 2</h2>
									<p>Donec id elit non mi porta gravida at eget metus. Fusce dapibus, tellus ac cursus commodo, tortor mauris
										condimentum nibh, ut fermentum massa justo sit amet risus. Etiam porta sem malesuada magna mollis euismod. Donec sed
										odio dui.</p>
									<p>
										<a class="btn btn-secondary" href="#" role="button">Mehr anzeigen &raquo;</a>
									</p>
								</div>
								<!--/span-->
								<div class="col-6 col-lg-4">
									<h2>Gruppe 3</h2>
									<p>Donec id elit non mi porta gravida at eget metus. Fusce dapibus, tellus ac cursus commodo, tortor mauris
										condimentum nibh, ut fermentum massa justo sit amet risus. Etiam porta sem malesuada magna mollis euismod. Donec sed
										odio dui.</p>
									<p>
										<a class="btn btn-secondary" href="#" role="button">Mehr anzeigen &raquo;</a>
									</p>
								</div>
							</div>
							<!--/row-->
						</div>
					</div>
					<!--/row-->
				</div>
				<!--/.container-->


				<!-- Bootstrap core JavaScript
    ================================================== -->
				<!-- Placed at the end of the document so the pages load faster -->
				<script src="https://code.jquery.com/jquery-3.1.1.slim.min.js"
					integrity="sha384-A7FZj7v+d/sdmMqp/nOQwliLvUsJfDHW+k9Omg/a/EheAdgtzNs3hpfag6Ed950n" crossorigin="anonymous"></script>
				<script>
					window.jQuery
							|| document
									.write('<script src="../../assets/js/vendor/jquery.min.js"><\/script>')
				</script>
				<script src="https://cdnjs.cloudflare.com/ajax/libs/tether/1.4.0/js/tether.min.js"
					integrity="sha384-DztdAPBWPRXSA/3eYEEUWrWCy7G5KFbe8fFjk5JAIxUYHKkDx6Qin1DkWx51bBrb" crossorigin="anonymous"></script>
				<script src="../../dist/js/bootstrap.min.js"></script>
				<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
				<script src="../../assets/js/ie10-viewport-bug-workaround.js"></script>
				<script src="offcanvas.js"></script>
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