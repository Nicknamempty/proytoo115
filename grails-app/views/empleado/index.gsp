<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'empleado.label', default: 'Empleado')}" />
        <title><g:message code="default.list.label" args="[entityName]" /></title>
        <asset:stylesheet href="bootstrap.css" src=""></asset:stylesheet>
        <asset:javascript src="form-style.js"/>
    </head>
    <body>
        <a href="#list-empleado" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
        <div class="nav" role="navigation">
            <!--<ul>
                <li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
                <li><g:link class="create " action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
            </ul>-->

        </div>
        <div id="list-empleado" class="content scaffold-list" role="main">
            <!--<h1><g:message code="default.list.label" args="[entityName]" /></h1>-->
            <h1 class="text-center">Administrar</h1>
            <g:if test="${flash.message}">
                <div class="message" role="status">${flash.message}</div>
            </g:if>
            <g:link class="create btn btn-primary btn-create ml-3 mb-3" action="create">Agregar</g:link>
            <f:table collection="${empleadoList}" />

            <div class="pagination">
                <g:paginate total="${empleadoCount ?: 0}" />
            </div>
        </div>
    </body>
</html>