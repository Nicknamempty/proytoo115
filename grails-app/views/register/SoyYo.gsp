<%--
  Created by IntelliJ IDEA.
  User: Fernando
  Date: 06/12/2020
  Time: 07:58 p. m.
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta name="layout" content="main" />
    <asset:stylesheet href="bootstrap.css" src=""></asset:stylesheet>
    <asset:javascript src="form-style.js"/>
    <title>Elige la forma de verificar tu cuenta</title>
</head>
<body>
<g:if test='${params.emailSent}'>
    <br/>
    <g:message code='spring.security.ui.register.sent'/>
</g:if>
<g:elseif test='${params.numeroOk}'>
    <br/>
    <p>Rev</p>
</g:elseif>

<g:else>
<h1>Para usar tu cuenta debes autentificarte</h1>
<h4>Elige una forma de verificarte</h4>
<a class="btn btn-primary" controller="Register" action="PorCorreo" >Correo Eléctronico</a>
<form controller="register" action="PorCorreo">
<input name="user" value="${params.user}" hidden></input>

    <input name="email" value="${params.email}" disabled hidden></input>
    <input name="registrationCode" value="${params.registrationCode}" hidden></input>
    <g:submitButton name="create" class="save btn btn-primary" value="Correo" />
</form>
    <p>
        <a class="btn btn-primary" data-toggle="collapse" href="#collapseExample" role="button" aria-expanded="false" aria-controls="collapseExample">
           Vía Celular <i class="fas fa-phone"></i>
        </a>

    </p>
    <div class="collapse" id="collapseExample">
        <div class="card card-body">
            <form controller="Register" action="PorTelefono">
                <input name="user" value="${params.user}" ></input>
                <input name="email" value="${params.email}" disabled hidden></input>
                <input type="number" name="codPais" placeholder="código de país (+503)"  ></input>
                <input type="number" name="numero"  placeholder="72727281" ></input>
                <g:submitButton name="create" class="save btn btn-primary" value="Enviar" />
            </form>

        </div>
    </div>
</g:else>

</body>
</html>
