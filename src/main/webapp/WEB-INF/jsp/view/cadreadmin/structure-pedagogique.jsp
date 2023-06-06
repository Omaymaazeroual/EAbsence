<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Structure Pédagogique</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js"></script>

    <style>
        table {
            border-collapse: collapse;
            width: 100%;
        }
        th, td {
            border: 1px solid black;
            padding: 8px;
            text-align: left;
        }
        th {
            background-color: #f2f2f2;
        }
        tr:nth-child(even) {
            background-color: #f9f9f9;
        }
    </style>
</head>
<body>
<jsp:include page="../fragments/userheader.jsp" />
<div class="container">
    <nav class="navbar navbar-expand-lg navbar-light bg-light">
        <div class="container-fluid">
            <jsp:include page="../fragments/cadreadminmenu.jsp" />
        </div>
    </nav>
</div>
<h1>Structure Pédagogique</h1>

<!-- Affichage de la liste des modules -->
<h2>Modules</h2>
<table>
    <tr>
        <th>Titre</th>
        <th>Code</th>
    </tr>
    <c:forEach var="module" items="${modules}">
        <tr>
            <td>${module.titre}</td>
            <td>${module.code}</td>
        </tr>
    </c:forEach>
</table>

<!-- Affichage de la liste des niveaux -->
<h2>Niveaux</h2>
<table>
    <tr>
        <th>Alias</th>
        <th>Titre</th>
    </tr>
    <c:forEach var="niveau" items="${niveaux}">
        <tr>
            <td>${niveau.alias}</td>
            <td>${niveau.titre}</td>
        </tr>
    </c:forEach>
</table>

<!-- Affichage de la liste des filières -->
<h2>Filières</h2>
<table>
    <tr>
        <th>Titre</th>
        <th>Code</th>
    </tr>
    <c:forEach var="filiere" items="${filieres}">
        <tr>
            <td>${filiere.titreFiliere}</td>
            <td>${filiere.codeFiliere}</td>
        </tr>
    </c:forEach>
</table>

<!-- Liens vers les formulaires de création -->
<h2>Création</h2>
<ul>
    <li><a href="${pageContext.request.contextPath}/structure-pedagogique/modules/creer">Créer un module</a></li>
    <li><a href="${pageContext.request.contextPath}/structure-pedagogique/niveaux/creer">Créer un niveau</a></li>
    <li><a href="${pageContext.request.contextPath}/structure-pedagogique/filieres/creer">Créer une filière</a></li>
</ul>
</body>
</html>
