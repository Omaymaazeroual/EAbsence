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

    <h1>Formulaire de Modification de matière</h1>

    <form:form action="${pageContext.request.contextPath}/structure-pedagogique/modifier-matiere/${matiere.getIdMatiere()}" method="POST" modelAttribute="matiere">
        <input type="hidden" name="idMatiere" value="${matiere.idMatiere}" />
        <input type="hidden" name="idModule" value="${matiere.getModule().getIdModule()}" />
        <label for="nom">Nom :</label>
        <form:input type="text" id="nom" path="nom" required="true" /><br><br>

        <label for="code">Code :</label>
        <form:input type="text" id="code" path="code" required="true" /><br><br>

        <label for="module">Module :</label>
        <form:select id="module" path="module.idModule" name="idModule">
            <c:forEach var="module" items="${modules}">
                <form:option value="${module.idModule}">${module.titre} - ${module.code}</form:option>
            </c:forEach>
        </form:select><br><br>

        <input type="submit" value="Modifier">
    </form:form>

</div>
</body>
</html>
