<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'empleado.label', default: 'Empleado')}" />
        <title><g:message code="default.create.label" args="[entityName]" /></title>
        <asset:stylesheet href="bootstrap.css" src=""></asset:stylesheet>
        <asset:javascript src="form-style.js"/>
    </head>
    <body>
    <div class="mb-2">
        <a class="btn btn-outline-dark font-weight-bold btn-sm" href="/empleado">Regresar</a>
    </div>
      <div class="container align-items-center justify-content-center">
        <div class="card card-body shadow">
            <a href="#create-empleado" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
            <!--<div class="nav" role="navigation">
            <ul>
                <li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
                <li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
            </ul>
        </div>-->
            <div id="create-empleado" class="content scaffold-create" role="main">
                <!--<h1><g:message code="default.create.label" args="[entityName]" /></h1>-->
                <h1 class="border-0 text-center">Agregar</h1>
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
                <g:form resource="${this.empleado}" method="POST">
                    <div class="form-group">
                        <f:field property="nombre" bean="empleado"/>
                        <f:field property="apellido" bean="empleado"/>
                        <f:field property="dui" bean="empleado"/>
                        <f:field property="nit" bean="empleado"/>
                        <f:field property="isss" bean="empleado"/>
                        <f:field property="nup" bean="empleado"/>
                        <select class="mdb-select md-form" property="estadoCivil" bean="empleado">
                            <option value="" disabled selected>Choose your option</option>
                            <option value="Casado">Casado</option>
                            <option value="Soltero">Soltero</option>
                            <option value="Divorciado">Divorciado</option>
                        <option value="Viudo">Viudo</option>
                        </select>
                        <select class="mdb-select md-form" property="genero" bean="empleado">
                            <option value="" disabled selected>Choose your option</option>
                            <option value="Mujer">Mujer</option>
                            <option value="Hombre">Hombre</option>
                            <option value="None">Perfiero no dedicir</option>

                        </select>
                      <!--  <//f:field property="genero" bean="empleado"/>-->
                      <!--  <//f:field property="estadoCivil" bean="empleado"/>-->
                        <f:field property="phoneNumber" bean="empleado"/>
                        <f:field property="countryCode" bean="empleado"/>
                        <f:field property="email" bean="empleado"/>
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
                        <g:submitButton name="create" class="save btn btn-primary" value="${message(code: 'default.button.create.label', default: 'Create')}" />
                    </div>
                </g:form>
            </div>
            <g:javascript>
                var selects = document.getElementsByTagName("select");
                cambiarMunicipio()
                function cambiarMunicipio(){
                    var idDepartamento = selects[0].value;
                    var municipios = JSON.parse('${(raw(municipios))}');
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
                selects[0].addEventListener("change",cambiarMunicipio,false);
            </g:javascript>
        </div>
      </div>
    </body>
</html>
