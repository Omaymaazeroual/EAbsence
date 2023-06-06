<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Affichage des matières</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js"></script>


</head>
<body>
<jsp:include page="../fragments/userheader.jsp" />
<div class="container">

    <nav class="navbar navbar-expand-lg navbar-light bg-light">
        <div class="container-fluid">
            <jsp:include page="../fragments/cadreadminmenu.jsp" />
        </div>
    </nav>

    <h1>Liste des Coordinations</h1>
    <table>
        <tr>
            <th>Id</th>
            <th>Date Debut</th>
            <th>Date Fin</th>
            <th>Filiere</th>
            <th>Coordinateur</th>
            <th>Actions</th>
        </tr>
        <c:forEach items="${coordinations}" var="coordination">
            <tr>
                <td>${coordination.idCoordination}</td>
                <td>${coordination.dateDebut}</td>
                <td>${coordination.dateFin}</td>
                <td>${coordination.filiere.titreFiliere}</td>
                <td>${coordination.coordonateur.nom}</td>
                <td>
                    <a href="${pageContext.request.contextPath}/structure-pedagogique/modifier-coordination/${coordination.idCoordination}" class="btn btn-primary">Modifier</a>
                    <a href="${pageContext.request.contextPath}/structure-pedagogique/supprimer-coordination/${coordination.idCoordination}" class="btn btn-danger">Supprimer</a> </td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
