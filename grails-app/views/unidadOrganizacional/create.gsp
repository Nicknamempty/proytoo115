<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'unidadOrganizacional.label', default: 'UnidadOrganizacional')}" />
        <title><g:message code="default.create.label" args="[entityName]" /></title>
        <asset:stylesheet href="bootstrap.css" src=""></asset:stylesheet>
        <asset:javascript src="form-style.js"/>
    </head>
    <body>
      <div class="mb-2">
        <a class="btn btn-outline-dark font-weight-bold btn-sm" href="/unidadOrganizacional">Regresar</a>
      </div>
      <div class="container align-items-center justify-content-center">
        <div class="card card-body shadow">
            <a href="#create-unidadOrganizacional" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
            <!--<div class="nav" role="navigation">
            <ul>
                <li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
                <li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
            </ul>
        </div>-->
            <div id="create-unidadOrganizacional" class="content scaffold-create" role="main">
                <!--<h1><g:message code="default.create.label" args="[entityName]" /></h1>-->
                <h1 class="border-0 text-center">Agregar</h1>
                <g:if test="${flash.message}">
                    <div class="message" role="status">${flash.message}</div>
                </g:if>
                <g:hasErrors bean="${this.unidadOrganizacional}">
                    <ul class="errors" role="alert">
                        <g:eachError bean="${this.unidadOrganizacional}" var="error">
                            <li <g:if test="${error in org.springframework.validation.FieldError}">data-field-id="${error.field}"</g:if>><g:message error="${error}"/></li>
                        </g:eachError>
                    </ul>
                </g:hasErrors>
                <g:form resource="${this.unidadOrganizacional}" method="POST">
                    <div class="form-group">
                        <f:all bean="unidadOrganizacional"/>
                    </div>
                    <div class="form-group">
                        <g:submitButton name="create" class="save btn btn-primary" value="${message(code: 'default.button.create.label', default: 'Create')}" />
                    </div>
                </g:form>
            </div>
        </div>
      </div>
    </body>
</html>
