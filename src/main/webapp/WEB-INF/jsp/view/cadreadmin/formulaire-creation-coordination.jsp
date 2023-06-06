<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
    <title>Formulaire de création de coordination</title>
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

    <h1>Formulaire de création de coordination</h1>

    <f:form action="${pageContext.request.contextPath}/structure-pedagogique/coordinateurs/creer" method="POST" modelAttribute="coordinationDTO">
        <label for="dateDebut">Date de début :</label>
        <f:input type="date" id="dateDebut" path="dateDebut" required="true" /><br><br>

        <label for="dateFin">Date de fin :</label>
        <f:input type="date" id="dateFin" path="dateFin" required="true" /><br><br>

        <label for="coordonateur">Coordonnateur :</label>
        <f:select id="coordonateur" path="idCoordonateur">
            <c:forEach var="enseignant" items="${enseignants}">
                <f:option value="${enseignant.idUtilisateur}">${enseignant.nom} ${enseignant.prenom}</f:option>
            </c:forEach>
        </f:select><br><br>

        <label for="filiere">Filière :</label>
        <f:select id="filiere" path="idFiliere">
            <c:forEach var="filiere" items="${filieres}">
                <f:option value="${filiere.idFiliere}">${filiere.titreFiliere}</f:option>
            </c:forEach>
        </f:select><br><br>

        <input type="submit" value="Créer">
    </f:form>
</div>
</body>
</html>
