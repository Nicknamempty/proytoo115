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
</g:else>

</body>
</html>
