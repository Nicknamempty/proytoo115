<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'direccion.label', default: 'Direccion')}" />
        <title><g:message code="default.edit.label" args="[entityName]" /></title>
        <asset:stylesheet href="bootstrap.css" src=""></asset:stylesheet>
    </head>
    <body>
        <a href="#edit-direccion" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
        <!--<div class="nav" role="navigation">
            <ul>
                <li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
                <li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
                <li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
            </ul>
        </div>-->
        <div id="edit-direccion" class="content scaffold-edit" role="main">
            <!--<h1><g:message code="default.edit.label" args="[entityName]" /></h1>-->
        <h1 class="border-0 text-center">Editar</h1>
            <g:if test="${flash.message}">
            <div class="message" role="status">${flash.message}</div>
            </g:if>
            <g:hasErrors bean="${this.direccion}">
            <ul class="errors" role="alert">
                <g:eachError bean="${this.direccion}" var="error">
                <li <g:if test="${error in org.springframework.validation.FieldError}">data-field-id="${error.field}"</g:if>><g:message error="${error}"/></li>
                </g:eachError>
            </ul>
            </g:hasErrors>
            <g:form resource="${this.direccion}" method="PUT">
                <g:hiddenField name="version" value="${this.direccion?.version}" />
                <div class="form-group">
                    <f:all bean="direccion"/>
                </div>
                <div class="form-group">
                    <input class="save btn btn-primary w-100" type="submit" value="${message(code: 'default.button.update.label', default: 'Update')}" />
                </div>
            </g:form>
        </div>
    </body>
</html>
