<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Etudiants</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.2/css/all.min.css" integrity="sha512-SnH5WK+bZxgPHs44uWIX+LLJAJ9/2PkPKZ5QiAj6Ta86w+fsb2TkcmfRyVX3pBnMFcV7oQPJkl9QevSCWr3W6A==" crossorigin="anonymous" referrerpolicy="no-referrer" />
    <style>
        <%@include file="../css/show.css"%>
    </style>
</head>
<body>
<div id="loader">
    <div class="loader-circle"></div>
</div>
<header>
    <div class="img-header">
        <img src="https://i.ibb.co/vLYpBq6/orange-brown-minimalist-school-logo.png" width="100%">
    </div>
</header>

<form action="searchByName" method="GET" id="formSearch">
    <input type="text" name="search" placeholder="Search By Name "/>
    <button type="submit"><i class="fa-brands fa-searchengin"></i></button>
</form>

<section>
    <div class="main">
<c:forEach var="etudiant" items="${Etudiants}">
        <div class="card">
            <div class="img-card">
                <img src="" alt="">
            </div>
            <div class="name">
                <p>${etudiant.nom}</p>
            </div>
            <div class="phone" id="phone">
                <p>+212 ${etudiant.telephone}</p>
            </div>
            <div class="email" id="email">
                <p>${etudiant.email}</p>
            </div>
        </div>
</c:forEach>
    </div>
</section>
<script>
    function showLoader() {
        document.getElementById("loader").style.display = "flex";
        document.querySelector(".main").style.display = "none";
    }
    function hideLoader() {
        document.getElementById("loader").style.display = "none";
        document.querySelector(".main").style.display = "flex";
    }
    function Rpage() {
        showLoader();
    }
    window.addEventListener("load", function() {
        hideLoader();
    });
    window.addEventListener("pageshow", function(event) {

        if (event.persisted) {
            hideLoader();
        }
    });

    document.querySelectorAll(".card").forEach((card) => {
        const email = card.querySelector(".email");
        const phone = card.querySelector(".phone");
        let check = true;

        card.addEventListener("mouseenter", () => {
            if (check) {
                phone.style.transition = "0.6s";
                phone.style.transform = "rotate(50deg) rotate(-25deg) translateY(40px) translateX(18px)";
                email.style.transition = "0.6s";
                email.style.transform = "rotate(90deg) rotate(-45deg) translateY(80px) translateX(30px)";
                check = false;
            }
        });

        card.addEventListener("mouseleave", () => {
            if (!check) {
                phone.style.transition = "0.6s";
                phone.style.transform = "rotate(0) rotate(0) translateY(0) translateX(0)";
                email.style.transition = "0.6s";
                email.style.transform = "rotate(0) rotate(0) translateY(0) translateX(0)";
                check = true;
            }
        });
    });

</script>
</body>
</html>


<!--
    <a href="deleteEtudiant/${etudiant.id}">Supprimer</a>
    </td>
    <td>
    <a href="updateEtudiant/${etudiant.id}">update</a>
    </td>
    </tr>
-->