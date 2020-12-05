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
            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                    <sec:username />
                </a>
                <div class="dropdown-menu bg-dark " aria-labelledby="navbarDropdown">
                    <div class="d-block">
                        <g:link action="index" controller="empleado">Ver Perfil</g:link>
                    </div>
                    <div class="d-block">
                        <sec:ifLoggedIn>
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

<!--<nav class="navbar navbar-expand-lg navbar-dark navbar-static-top" role="navigation">
    <a class="navbar-brand" href="/#"><asset:image src="grails.svg" alt="Grails Logo"/></a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarContent" aria-controls="navbarContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" aria-expanded="false" style="height: 0.8px;" id="navbarContent">
        <ul class="nav navbar-nav ml-auto">
            <g:pageProperty name="page.nav"/>
        </ul>
    </div>

</nav>-->

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
