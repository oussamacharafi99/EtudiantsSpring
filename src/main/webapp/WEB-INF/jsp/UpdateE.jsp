<!--<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Etudiant Form</title>
</head>
<body>
<h2>Etudiant Form</h2>
<form action="${pageContext.request.contextPath}/updateEtudiant" method="post">
    <label>Matricule:</label>
    <input type="number" name="id" value="${etudiant.getId()}" required><br>
    <label>Nom:</label>
    <input type="text" name="nom"  value="${etudiant.getNom()}" required><br>
    <label>Email:</label>
    <input type="email" name="email"  value="${etudiant.getEmail()}" required><br>
    <label>Address:</label>
    <input type="text" name="address" value="${etudiant.getAddress()}" required><br>
    <label>Telephone:</label>
    <input type="number" name="telephone" value="${etudiant.getTelephone()}" required><br>
    <button type="submit">Envoyer</button>
</form>
</body>
</html>-->


<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <style>
        <%@include file="../css/add.css"%>
    </style>
    <title>Document</title>
</head>
<body>
<a id="return" href="${pageContext.request.contextPath}"><img src="https://i.ibb.co/vcns5BS/6.png" width="100%"/></a>
<a id="show" href="etudiants"><img src="https://i.ibb.co/9c632W2/7.png" width="100%"/></a>
<div id="loader">
    <div class="loader-circle"></div>
</div>
<header>
    <div class="img-header">
        <img src="https://i.ibb.co/vLYpBq6/orange-brown-minimalist-school-logo.png" width="100%">
    </div>
</header>
<div class="main">
    <h1 id="titre">Update !</h1>
    <form action="${pageContext.request.contextPath}/updateEtudiant" method="post">
        <div>
            <label style="display: none">Matricule:</label><br>
            <input type="number" name="id" value="${etudiant.getId()}" style="display: none"><br>

            <label>Nom</label><br>
            <input type="text" name="nom" value="${etudiant.getNom()}" required placeholder="Full Name">
        </div><br>
        <div>
            <label>Email</label><br>
            <input type="email" name="email" value="${etudiant.getEmail()}" required placeholder="Email"><br>
            <label>Address</label><br>
            <input type="text" name="address" value="${etudiant.getAddress()}" required placeholder="Address">
        </div><br>
        <div>
            <label>Telephone:</label><br>
            <input type="number" name="telephone" value="${etudiant.getTelephone()}" required placeholder="Phone Number"><br><br>
            <button type="submit" id="addS">
                <img src="https://i.ibb.co/TT8gHpt/orange-brown-minimalist-school-logo-6.png" width="100%">
            </button>
        </div>
    </form>
</div>

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
</script>

</body>
</html>

