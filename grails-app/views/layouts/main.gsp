<!doctype html>
<html lang="en" class="no-js">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <title>
        <g:layoutTitle default="Grails"/>
    </title>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <asset:link rel="icon" href="favicon.ico" type="image/x-ico"/>
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.1/css/all.css" integrity="sha384-50oBUHEmvpQ+1lW4y57PTFmhCaXp0ML5d60M1M7uH2+nqUivzIebhndOJK28anvf" crossorigin="anonymous">
    <asset:stylesheet src="application.css"/>

    <g:layoutHead/>
</head>

<body>

<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <a class="navbar-brand" href="/#"><asset:image src="favicon.ico"  alt="Grails Logo"/></a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <sec:ifLoggedIn>
        <ul class="navbar-nav ml-auto">
            <li class="nav-item active">
                <a class="nav-link" href="#">Home <span class="sr-only">(current)</span></a>
            </li>
            <li class="nav-item px-2 my-auto">
                <g:link controller="departamento">Departamento</g:link>
            </li>
            <li class="nav-item px-2 my-auto">
                <g:link controller="municipio">Municipio</g:link>
            </li>
            <li class="nav-item px-2 my-auto">
                <g:link controller="empleado">Empleado</g:link>
            </li>
            <li class="nav-item px-2 my-auto">
                <g:link controller="unidadOrganizacional">Unidad Organizacional</g:link>
            </li>
            <li class="nav-item px-2 my-auto">
                <a href="/requestmap/create">Gestión</a>
            </li>
            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                    <sec:username />
                </a>
                <div class="dropdown-menu bg-dark " aria-labelledby="navbarDropdown">
                    <div class="d-block">
                        <g:link action="Personal" controller="empleado">Ver Perfil</g:link>
                    </div>
                    <div class="d-block">

                            (<g:link controller='logout'>Salir</g:link>)
                        </sec:ifLoggedIn>
                        <sec:ifNotLoggedIn>
                            <g:link controller='login'>Entrar</g:link>
                        </sec:ifNotLoggedIn>
                    </div>
                </div>
            </li>
        </ul>
    </div>
</nav>





<g:layoutBody/>
<footer class="footer row" role="contentinfo">
    <div class="mx-auto">
        TOO115 - GP11 - SISTEMA DE SEGURIDAD
    </div>
</footer>


<div id="spinner" class="spinner" style="display:none;">
    <g:message code="spinner.alt" default="Loading&hellip;"/>
</div>

<asset:javascript src="application.js"/>

</body>
</html>
