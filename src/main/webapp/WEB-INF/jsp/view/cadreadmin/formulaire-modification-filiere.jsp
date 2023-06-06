<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
    <title>Formulaire de création de matière</title>
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

    <h1>Formulaire de Modification de filiere</h1>

    <form:form action="${pageContext.request.contextPath}/structure-pedagogique/modifier-filiere/${filiere.getIdFiliere()}" method="POST" modelAttribute="filiere">
        <input type="hidden" name="idFiliere" value="${filiere.idFiliere}" />
        <label for="titreFiliere">Titre :</label>
        <form:input type="text" id="titreFiliere" path="titreFiliere" required="true" /><br><br>

        <label for="codeFiliere">Code :</label>
        <form:input type="text" id="codeFiliere" path="codeFiliere" required="true" /><br><br>

        <label for="anneeaccreditation">Année d'accréditation :</label>
        <form:input type="number" id="anneeaccreditation" path="anneeaccreditation" required="true" /><br><br>

        <label for="anneeFinaccreditation">Année de fin d'accréditation :</label>
        <form:input type="number" id="anneeFinaccreditation" path="anneeFinaccreditation" required="true" /><br><br>


        <input type="submit" value="Modifier">
    </form:form>

</div>
</body>
</html>
