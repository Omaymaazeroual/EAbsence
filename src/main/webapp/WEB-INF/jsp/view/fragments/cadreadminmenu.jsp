<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<div class="collapse navbar-collapse" id="navbarNav">
    <ul class="navbar-nav">
        <li class="nav-item"><a class="nav-link active" aria-current="page" href="${pageContext.request.contextPath}/structure-pedagogique">Structure Pedagogique</a></li>

        <li class="nav-item dropdown">
            <a class="nav-link dropdown-toggle" href="#" id="navbarScrollingDropdownCadreAdmin3" role="button" data-bs-toggle="dropdown" aria-expanded="false">Matiere</a>
            <ul class="dropdown-menu" aria-labelledby="navbarScrollingDropdownCadreAdmin3">
                <li class="dropdown-item">
                    <a class="nav-link" href="${pageContext.request.contextPath}/structure-pedagogique/matiere/creer">Creer Matiere</a>
                </li>
                <li class="dropdown-item">
                    <a class="nav-link" href="${pageContext.request.contextPath}/structure-pedagogique/afficher-matiere">Afficher Matieres</a>
                </li>
            </ul>
        </li>

        <li class="nav-item dropdown">
            <a class="nav-link dropdown-toggle" href="#" id="navbarScrollingDropdownCadreAdmin1" role="button" data-bs-toggle="dropdown" aria-expanded="false">Modules</a>
            <ul class="dropdown-menu" aria-labelledby="navbarScrollingDropdownCadreAdmin1">
                <li class="dropdown-item">
                    <a class="nav-link" href="${pageContext.request.contextPath}/structure-pedagogique/modules/creer">Creer Module</a>
                </li>
                <li class="dropdown-item">
                    <a class="nav-link" href="${pageContext.request.contextPath}/structure-pedagogique/afficher-module">Afficher Modules</a>
                </li>

            </ul>
        </li>

        <li class="nav-item dropdown">
            <a class="nav-link dropdown-toggle" href="#" id="navbarScrollingDropdownCadreAdmin2" role="button" data-bs-toggle="dropdown" aria-expanded="false">Niveaux</a>
            <ul class="dropdown-menu" aria-labelledby="navbarScrollingDropdownCadreAdmin2">
                <li class="dropdown-item">
                    <a class="nav-link" href="${pageContext.request.contextPath}/structure-pedagogique/niveaux/creer">Creer Niveau</a>
                </li>
                <li class="dropdown-item">
                    <a class="nav-link" href="${pageContext.request.contextPath}/structure-pedagogique/afficher-niveau">Afficher Niveaux</a>
                </li>

            </ul>
        </li>

        <li class="nav-item dropdown">
            <a class="nav-link dropdown-toggle" href="#" id="navbarScrollingDropdownCadreAdmin" role="button" data-bs-toggle="dropdown" aria-expanded="false">Filieres</a>
            <ul class="dropdown-menu" aria-labelledby="navbarScrollingDropdownCadreAdmin">
                <li class="dropdown-item">
                    <a class="nav-link" href="${pageContext.request.contextPath}/structure-pedagogique/filieres/creer">Creer Filiere</a>
                </li>
                <li class="dropdown-item">
                    <a class="nav-link" href="${pageContext.request.contextPath}/structure-pedagogique/afficher-filiere">Afficher Filieres</a>
                </li>
            </ul>
        </li>

        <li class="nav-item dropdown">
            <a class="nav-link dropdown-toggle" href="#" id="navbarScrollingDropdownCadreAdmin4" role="button" data-bs-toggle="dropdown" aria-expanded="false">Coordinateurs</a>
            <ul class="dropdown-menu" aria-labelledby="navbarScrollingDropdownCadreAdmin4">
                <li class="dropdown-item">
                    <a class="nav-link" href="${pageContext.request.contextPath}/structure-pedagogique/coordinateurs/creer">Creer Coordinateur</a>
                </li>
                <li class="dropdown-item">
                    <a class="nav-link" href="${pageContext.request.contextPath}/structure-pedagogique/afficher-coordination">Afficher Coordinateur</a>
                </li>
            </ul>
        </li>
        </li>
        <li class="nav-item dropdown"><a class="nav-link dropdown-toggle"
                                         href="#" id="navbarScrollingDropdown" role="button"
                                         data-bs-toggle="dropdown" aria-expanded="false">Export Data </a>
            <ul class="dropdown-menu" aria-labelledby="navbarScrollingDropdown">
                <li class="dropdown-item"><a class="nav-link"
                                             href="${pageContext.request.contextPath}/structure-pedagogique/exportFilieres">Export
                    Filieres</a></li>
            </ul></li>

        <li class="nav-item"><f:form
                action="${pageContext.request.contextPath}/logout" method="POST">

            <button type="submit" class="btn btn-link">logout</button>

        </f:form></li>
    </ul>
</div>
