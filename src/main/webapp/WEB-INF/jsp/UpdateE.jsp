<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
    <label>Message:</label>
    <input  type="text" name="message"  value="${etudiant.getMessage()}" required><br>
    <button type="submit">Envoyer</button>
</form>
</body>
</html>
