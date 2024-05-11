<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <style>
        <%@include file="../css/home.css"%>
    </style>
    <title>Document</title>
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

<div class="main">
    <div class="left">
        <p>Welcome to Ena's management space</p>
        <h2><em>This</em> space is designated for registering <i>new</i> students</h2>
        <a href="add" onclick="Rpage()">Get started</a><br><br>
        <span>You can use it for free</span>
    </div>
    <div class="right">
        <img src="https://i.ibb.co/hg8wNP2/Social-Media-Profile-Picture.png" width="100%">
    </div>
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
