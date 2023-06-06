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

    <h1>Formulaire de Modification de coordination</h1>

    <form:form action="${pageContext.request.contextPath}/structure-pedagogique/modifier-coordination/${coordination.getIdCoordination()}" method="POST" modelAttribute="coordination">
        <input type="hidden" name="idCoordination" value="${coordination.idCoordination}" />
        <input type="hidden" name="idCoordonateur" value="${coordination.coordonateur.idUtilisateur}" />
        <input type="hidden" name="idFiliere" value="${coordinantion.filiere.idFiliere}" />
        <label for="dateDebut">Date de début :</label>
        <form:input type="date" id="dateDebut" path="dateDebut" required="true" /><br><br>

        <label for="dateFin">Date de fin :</label>
        <form:input type="date" id="dateFin" path="dateFin" required="true" /><br><br>
        <label for="filiere">Filière :</label>
        <form:select id="filiere" path="filiere.idFiliere">
            <c:forEach var="filiere" items="${filieres}">
                <form:option value="${filiere.idFiliere}">${filiere.titreFiliere}</form:option>
            </c:forEach>
        </form:select><br><br>

        <label for="coordonateur">Coordonnateur :</label>
        <form:select id="coordonateur" path="coordonateur.idUtilisateur" name="idCoordonateur">
            <c:forEach var="enseignant" items="${enseignants}">
                <form:option value="${enseignant.idUtilisateur}">${enseignant.nom} ${enseignant.prenom}</form:option>
            </c:forEach>
        </form:select><br><br>
        <input type="submit" value="Modifier">
    </form:form>

</div>
</body>
</html>
