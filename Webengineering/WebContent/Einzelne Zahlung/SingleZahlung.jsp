<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<!-- META-DATA -->
<head>
    <title>MyComp - Zahlung</title>
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
<body>
<!-- Navigationbar -->
<nav class="navbar navbar-expand-md bg-dark navbar-dark">
    <!-- Navbar Toggle -->
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#collapsibleNavbar">
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
            <!-- Gruppen Dropdown -->
            <li class="nav-item dropdown">
                <span class="nav-link">
                    <a href="#yourlink">Gruppen </a>
                    <i class="fas fa-users dropdown-toggle" href="#" id="navbardrop1" data-toggle="dropdown"></i>
                    <div class="dropdown-menu">
                        <a class="dropdown-item" href="#gruppe1">Gruppe 1</a>
                        <a class="dropdown-item" href="#gruppe2">Gruppe 2</a>
                        <a class="dropdown-item" href="#gruppe3">Gruppe 3</a>
                    </div>
                </span>
            </li>
            <!-- Zahlungen -->
            <li class="nav-item">
                <a class="nav-link active" href="../Zahlungsuebersicht/Zahlungsuebersicht.jsp">Zahlungen <i class="fas fa-receipt"></i></a>
            </li>
        </ul>
        <!-- Navbar Items Rechts-->
        <ul class="navbar-nav ml-auto">
            <!-- Profil -->
            <li class="nav-item dropdown">
                <span class="nav-link">
                    <a href="#yourlink">Profil </a>
                    <i class="fas fa-user dropdown-toggle" href="#" id="navbardrop2" data-toggle="dropdown"></i>
                    <div class="dropdown-menu dropdown-menu-right">
                        <a class="dropdown-item" href="#asd">Profil bearbeiten <i class="fas fa-user-edit"></i></a>
                        <a class="dropdown-item" href="#asd">Abmelden <i class="fas fa-sign-in-alt"></i></a>
                    </div>
                </span>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="../Registrieren/Registrieren.jsp">Registrieren <i class="fas fa-sign-in-alt"></i></a>
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