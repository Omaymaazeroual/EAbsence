<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
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

    <h1>Formulaire de création de matière</h1>

    <f:form action="${pageContext.request.contextPath}/structure-pedagogique/matiere/creer" method="POST" modelAttribute="matiereDTO">
        <label for="nom">Nom :</label>
        <f:input type="text" id="nom" path="nom" required="true" /><br><br>

        <label for="code">Code :</label>
        <f:input type="text" id="code" path="code" required="true" /><br><br>

        <label for="module">Module :</label>
        <f:select id="module" path="idModule">
            <c:forEach var="module" items="${modules}">
                <f:option value="${module.idModule}">${module.titre} - ${module.code}</f:option>
            </c:forEach>
        </f:select><br><br>

        <input type="submit" value="Créer">
    </f:form>
</div>
</body>
</html>
