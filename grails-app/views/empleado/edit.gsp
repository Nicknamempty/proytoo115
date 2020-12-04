<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'empleado.label', default: 'Empleado')}" />
        <title><g:message code="default.edit.label" args="[entityName]" /></title>
        <asset:stylesheet href="bootstrap.css" src=""></asset:stylesheet>
    </head>
    <body>
        <a href="#edit-empleado" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
        <!--<div class="nav" role="navigation">
            <ul>
                <li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
                <li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
                <li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
            </ul>
        </div>-->
        <div id="edit-empleado" class="content scaffold-edit" role="main">
            <!--<h1><g:message code="default.edit.label" args="[entityName]" /></h1>-->
        <h1 class="border-0 text-center">Editar</h1>
            <g:if test="${flash.message}">
            <div class="message" role="status">${flash.message}</div>
            </g:if>
            <g:hasErrors bean="${this.empleado}">
            <ul class="errors" role="alert">
                <g:eachError bean="${this.empleado}" var="error">
                <li <g:if test="${error in org.springframework.validation.FieldError}">data-field-id="${error.field}"</g:if>><g:message error="${error}"/></li>
                </g:eachError>
            </ul>
            </g:hasErrors>
            <g:form resource="${this.empleado}" method="PUT">
                <g:hiddenField name="version" value="${this.empleado?.version}" />
                <div class="form-group">
                    <f:field property="nombre" bean="empleado"/>
                    <f:field property="apellido" bean="empleado"/>
                    <f:field property="dui" bean="empleado"/>
                    <f:field property="nit" bean="empleado"/>
                    <f:field property="isss" bean="empleado"/>
                    <f:field property="nup" bean="empleado"/>
                    <f:field property="genero" bean="empleado"/>
                    <f:field property="estadoCivil" bean="empleado"/>
                    <p>Direccion:</p>
                    <div class="fieldcontain required">
                        <label for="departamentos" class="text-left">Departamento</label>
                        <select name="departamentos" id="departamentos" class="form-control">
                            <g:each var="departamento" in="${departamentos}">
                                <option value="${departamento.id}">${departamento}</option>
                            </g:each>
                        </select>
                    </div>
                    <div class="fieldcontain required">
                        <label for="direccion.municipio" class="text-left">Municipio</label>
                        <select name="direccion.municipio.id" id="direccion.municipio" class="form-control">

                        </select>
                    </div>
                    <f:field property="direccion.calle" bean="empleado"/>
                    <f:field property="direccion.avenida" bean="empleado"/>
                    <f:field property="direccion.colonia" bean="empleado"/>
                    <f:field property="direccion.numeroCasa" bean="empleado"/>


                </div>
                <div class="form-group">
                    <input class="save btn btn-primary w-100" type="submit" value="${message(code: 'default.button.update.label', default: 'Update')}" />
                </div>
            </g:form>
        </div>

    <g:javascript>
            var selects = document.getElementsByTagName("select");
            var municipios = JSON.parse('${(raw(municipios))}');
            iniciar()
            function cambiarMunicipio(){
                var idDepartamento = selects[0].value;
                console.log(municipios);
                for (var i=selects[1].options.length;i-->0;){
                    selects[1].options.remove(i);
                }
                for (var i=0; i<municipios.length;i++){
                    if (municipios[i].departamento.id==idDepartamento){
                        var opt = document.createElement('option');
                        opt.value = municipios[i].id;
                        opt.innerHTML = municipios[i].nombre;
                        selects[1].appendChild(opt);
                    }
                }
            }
            function iniciar(){
                var idDepartamento = ${empleado.direccion.municipio.departamento.id};
                var idMunicipio = ${empleado.direccion.municipio.id};
                selects[0].value=idDepartamento;
                for (var i=0; i<municipios.length;i++){
                    if (municipios[i].departamento.id==idDepartamento){
                        var opt = document.createElement('option');
                        opt.value = municipios[i].id;
                        opt.innerHTML = municipios[i].nombre;
                        selects[1].appendChild(opt);
                    }
                }
                selects[1].value=idMunicipio;
            }
            selects[0].addEventListener("change",cambiarMunicipio,false);
    </g:javascript>
    </body>
</html>
