<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Etudiants</title>
</head>
<body>
<h2>Liste des Etudiants</h2>
<table>
    <tr>
        <th>ID</th>
        <th>Nom</th>
        <th>Email</th>
        <th>Message</th>
        <th>Action</th>
    </tr>
    <c:forEach var="etudiant" items="${Etudiants}">
        <tr>
            <td>${etudiant.id}</td>
            <td>${etudiant.nom}</td>
            <td>${etudiant.email}</td>
            <td>${etudiant.message}</td>
            <td>
                <a href="deleteEtudiant/${etudiant.id}">Supprimer</a>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
