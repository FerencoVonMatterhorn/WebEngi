<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<!--  META-DATA  -->
<head>
    <title>MyComp - Home</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="../mainstyle.css">
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
<!--  Navigationbar  -->
<nav class="navbar navbar-expand-md bg-dark navbar-dark">
    <!--  Navbar Toggle  -->
    <button class="navbar-toggler" type="button" data-toggle="collapse"
            data-target="#collapsibleNavbar">
        <span class="navbar-toggler-icon"></span>
    </button>
    <!--  Navbar Toggle END  -->
    <div class="collapse navbar-collapse" id="collapsibleNavbar">
        <!--  Navbar Items Links  -->
        <ul class="navbar-nav">
            <!--  Home  -->
            <li class="nav-item active">
                <a class="nav-link" href="#">Home <i class="fas fa-home"></i></a>
            </li>
        </ul>
        <!--  Navbar Items Rechts  -->
        <ul class="navbar-nav ml-auto">
            <li class="nav-item">
                <a class="nav-link" href="../Registrieren/Registrieren.jsp">Registrieren <i
                        class="fas fa-sign-in-alt"></i></a>
            </li>
        </ul>
        <!--  Navbar Items END  -->
    </div>
</nav>
<!--  Navigationbar END  -->

<!--  BODY  -->
<div class="backgroundSide">
    <div class="container-fluid">
        <div class="backgroundMid">
            <!--  Erste ROW  -->
            <div class="row center-block">
                <div class="col-7 mt-5 ml-5">
                    <h1>MyWG - Was machen wir?</h1>
                    <div class="ml-5 mt-4">
                        <p>Wir verschaffen Ihnen einen überblick im Chaos.</p>
                        <p>Monatliche Abrechnungen im Überblick.</p>
                        <p>Rechnung abfotografieren, hochladen und sagen wer dir Geld schuldet.</p>
                        <p>Ab jetzt zurücklehnen, denn den Rest übernehmen wir!</p>
                    </div>
                </div>
                <!--  Login Form  -->
                <div class="col-3 card shadow mb-5 mt-5">
                    <article class="card-body">
                        <h4 class="card-title text-center mb-4 mt-1">Sign in</h4>
                        <hr>
                        <%--                <p class="text-success text-center">Status</p>--%>

                        <form action="" method="POST">
                            <!--  First input  -->
                            <div class="form-group">
                                <div class="input-group">
                                    <div class="input-group-prepend">
                                        <span class="input-group-text"> <i class="fa fa-user"></i></span>
                                    </div>
                                    <input name="" class="form-control" placeholder="Email or Username" type="text" required>
                                </div>
                            </div>
                            <!--  Second input  -->
                            <div class="form-group">
                                <div class="input-group">
                                    <div class="input-group-prepend">
                                        <span class="input-group-text"> <i class="fa fa-lock"></i></span>
                                    </div>
                                    <input class="form-control" placeholder="********" type="password" required>
                                </div>
                            </div>
                            <!--  Actions  -->
                            <div class="form-group">
                                <button type="submit" class="btn btn-primary btn-block">
                                    Login
                                </button>
                            </div>
                            <p class="text-center">
                                <a href="#" class="btn">Forgot password?</a>
                            </p>
                        </form>
                    </article>
                </div>
                <!--  Login Form END  -->
            </div>
            <!--  Erste ROW END  -->


            <!--  Carousel Preview  -->
            <div id="myCarousel" class="carousel slide container" data-ride="carousel">

                <!--  Indicators  -->
                <ul class="carousel-indicators">
                    <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
                    <li data-target="#myCarousel" data-slide-to="1"></li>
                </ul>

                <!--  The slideshow  -->
                <div class="carousel-inner">
                    <div class="carousel-item active">
                        <img src="../resources/test1.jpg" width="1100" height="500">
                    </div>
                    <div class="carousel-item">
                        <img src="../resources/test2.jpg" width="1100" height="500">
                    </div>
                </div>

                <!--  Left and right controls  -->
                <a class="carousel-control-prev" href="#myCarousel" data-slide="prev">
                    <span class="carousel-control-prev-icon"></span>
                </a>
                <a class="carousel-control-next" href="#myCarousel" data-slide="next">
                    <span class="carousel-control-next-icon"></span>
                </a>
            </div>
            <!--  Carousel Preview END  -->
            <!--  SPACE TO FOOTER  -->
            <div class="placeholder mb-5"></div>
        </div>
    </div>
</div>
<!--  BODY END  -->

<!--  Footer  -->
<div class="container-fluid footer">
    <div class="footerCompany col-xs-6 mt-5">
        <p><a href="#impressum">Impressum</a></p>
        <p>Ⓒ 2019 MyCompName</p>
    </div>
</div>
<!--  Footer END  -->
</body>
</html>