<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
    <title>Formulaire de création de niveau</title>
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
<h1>Formulaire de création de niveau</h1>

<f:form action="${pageContext.request.contextPath}/structure-pedagogique/niveaux/creer" method="POST" modelAttribute="niveauDTO">
    <label for="titre">Titre :</label>
    <f:input type="text" id="titre" path="titre" required="true" /><br><br>

    <label for="alias">Alias :</label>
    <f:input type="text" id="alias" path="alias" required="true" /><br><br>

    <label for="filiere">Filière :</label>
    <f:select id="filiere" path="filiere">
        <c:forEach var="filiere" items="${filieres}">
            <f:option value="${filiere.idFiliere}">${filiere.titreFiliere}</f:option>
        </c:forEach>
    </f:select><br><br>

    <input type="submit" value="Créer">
</f:form>
</div>
</body>
</html>
