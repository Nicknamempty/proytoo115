<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'unidadOrganizacional.label', default: 'UnidadOrganizacional')}" />
        <title><g:message code="default.show.label" args="[entityName]" /></title>
        <asset:stylesheet href="bootstrap.css" src=""></asset:stylesheet>
        <asset:javascript src="form-style.js"/>
    </head>
    <body>
        <a href="#show-unidadOrganizacional" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
        <!--<div class="nav" role="navigation">
            <ul>
                <li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
                <li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
                <li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
            </ul>-->
        </div>
        <div id="show-unidadOrganizacional" class="content scaffold-show" role="main">
            <h1 class="border-0 text-center">Mostrar</h1>
            <!--<h1><g:message code="default.show.label" args="[entityName]" /></h1>-->
            <g:if test="${flash.message}">
                <div class="message" role="status">${flash.message}</div>
            </g:if>
            <f:display bean="unidadOrganizacional"/>
            <g:form resource="${this.unidadOrganizacional}" method="DELETE">
                <div class="form-group mx-auto text-center">
                    <g:link class="edit btn btn-primary " action="edit" resource="${this.unidadOrganizacional}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
                    <input class="delete btn btn-danger w-auto" type="submit" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
                </div>
                <div class="form-group mx-auto">
                    <h2>Sub Unidades:</h2>
                    <g:each in="${subUnidad}" var="su" status="i">
                        ${i+1}. <g:link resource="UnidadOrganizacional" action="show" id="${su.id}"> ${su.nombreUnidad} </g:link><br>
                    </g:each>
                </div>
            </g:form>
        </div>
    </body>
</html>
