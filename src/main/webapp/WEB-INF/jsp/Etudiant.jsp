<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Etudiant Form</title>
</head>
<body>
<h2>Etudiant Form</h2>
<form action="<c:url value='/saveEtudiant'/>" method="post">
    <label>Matricule:</label>
    <input type="number" name="id" required><br>
    <label>Nom:</label>
    <input type="text" name="nom" required><br>
    <label>Email:</label>
    <input type="email" name="email" required><br>
    <label>Message:</label>
    <textarea name="message" required></textarea><br>
    <button type="submit">Envoyer</button>
</form>
</body>
</html>
