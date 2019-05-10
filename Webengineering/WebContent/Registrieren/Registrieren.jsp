<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<!-- META-DATA -->
<head>
    <title>MyComp - Registrieren</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="../mainStyle.css">
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
<body style="min-width: 100%; min-height: 70%; overflow-x: hidden;">
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
                <a class="nav-link dropdown-toggle" href="../Gruppenuebersicht/Gruppenuebersicht.jsp" id="navbardrop1"
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
                <a class="nav-link dropdown-toggle" href="../Profil/Profil.jsp" id="navbardrop2"
                   data-toggle="dropdown">Benutzer <i class="fas fa-user"></i></a>
                <div class="dropdown-menu dropdown-menu-right">
                    <a class="dropdown-item" href="#asd">Profil bearbeiten <i
                            class="fas fa-user-edit"></i>
                    </a> <a class="dropdown-item" href="#asd">Abmelden <i class="fas fa-sign-in-alt"></i>
                </a>
                </div>
            </li>
            <!-- /c:if -->
            <li class="nav-item">
                <a class="nav-link active" href="#">Registrieren <i class="fas fa-sign-in-alt"></i></a>
            </li>
        </ul>
        <!-- Navbar Items END -->
    </div>
</nav>
<!-- Navigationbar END-->

<!-- BODY -->
<div class="backgroundSide">
    <div class="container-fluid">
        <div class="backgroundMid">
            <!-- Register Form -->
            <div class="row pt-5">
                <div class="card mx-auto shadow mb-4 mt-4" style="border-radius: 8px;">
                    <article class="card-body">
                        <h4 class="card-title text-center mb-4 mt-1">Sign up</h4>
                        <hr class="myWGHR">
                        <!-- <p class="text-success text-center">Status</p> -->
                        <form action="" method="POST">
                            <!-- First input -->
                            <div class="form-group">
                                <div class="input-group">
                                    <div class="input-group-prepend">
                                        <span class="input-length input-group-text"> First name:</span>
                                    </div>
                                    <input type="text" class="form-control" id="fname" required>
                                </div>
                            </div>
                            <!-- Second input -->
                            <div class="form-group">
                                <div class="input-group">
                                    <div class="input-group-prepend">
                                        <span class="input-length input-group-text"> Last name:</span>
                                    </div>
                                    <input type="text" class="form-control" id="lname" required>
                                </div>
                            </div>
                            <!-- Third input -->
                            <div class="form-group">
                                <div class="input-group">
                                    <div class="input-group-prepend">
                                        <span class="input-length input-group-text"> Username:</span>
                                    </div>
                                    <input type="text" class="form-control" id="uname" required>
                                </div>
                            </div>
                            <!-- Fourth input -->
                            <div class="form-group">
                                <div class="input-group">
                                    <div class="input-group-prepend">
                                        <span class="input-length input-group-text"> Email address:</span>
                                    </div>
                                    <input type="email" class="form-control" id="email" required>
                                </div>
                            </div>
                            <!-- Fifth input -->
                            <div class="form-group">
                                <div class="input-group">
                                    <div class="input-group-prepend">
                                        <span class="input-length input-group-text"> Password:</span>
                                    </div>
                                    <input type="password" class="form-control" id="password1" required>
                                </div>
                            </div>
                            <!-- Sixth input -->
                            <div class="form-group">
                                <div class="input-group">
                                    <div class="input-group-prepend">
                                        <span class="input-length input-group-text"> Retype password:</span>
                                    </div>
                                    <input type="password" class="form-control" id="password2" required>
                                </div>
                            </div>
                            <hr class="MyWGHR">
                            <!-- Actions -->
                            <div class="form-group">
                                <button type="submit" class="btn btn-primary btn-block">Register</button>
                            </div>
                        </form>
                    </article>
                    <!-- Register Form ENDE -->
                </div>
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