<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
    <title>Formulaire de création de filière</title
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

    <h1>Formulaire de création de filière</h1>

    <f:form action="${pageContext.request.contextPath}/structure-pedagogique/filieres/creer" method="POST" modelAttribute="filiereDTO">
        <label for="titre">Titre :</label>
        <f:input type="text" id="titre" path="titreFiliere" required="true" /><br><br>

        <label for="code">Code :</label>
        <f:input type="text" id="code" path="codeFiliere" required="true" /><br><br>

        <label for="anneeaccreditation">Année d'accréditation :</label>
        <f:input type="number" id="anneeaccreditation" path="anneeaccreditation" required="true" /><br><br>

        <label for="anneeFinaccreditation">Année de fin d'accréditation :</label>
        <f:input type="number" id="anneeFinaccreditation" path="anneeFinaccreditation" required="true" /><br><br>

        <input type="submit" value="Créer">
    </f:form>
</div>
</body>
</html>
