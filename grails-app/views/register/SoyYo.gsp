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
    <div style="margin-left: 100px;margin-top: 100px;margin-right: 100px;" class="shadow p-3 mb-5 bg-white rounded row d-flex justify-content-center">
    <div class="col-12 justify-content-center">
<h1>Para usar tu cuenta debes autentificarte</h1>
<h4>Elige una forma de verificarte</h4>
</div>

    <div  class="col-6">


<form controller="register" action="PorCorreo">
<input name="user" value="${params.user}" hidden></input>

    <input name="email" value="${params.email}" hidden></input>
    <input name="registrationCode" value="${params.registrationCode}" hidden ></input>
    <p class="d-flex justify-content-center">



        <button class="btn btn-dark" type="button" data-toggle="collapse" data-target="#collapseExample" aria-expanded="false" aria-controls="collapseExample">
            Vía Celular  <i class="fas fa-sms"></i>
        </button>
        <g:submitButton name="enviar" class="save btn btn-dark" value="Correo" />
    </p>
    </form>





    <div class="collapse" id="collapseExample">
        <div class="card card-body">
            <form controller="Register" action="PorTelefono">
                <input name="user" value="${params.user}"  hidden></input>
                <input name="email" value="${params.email}"  hidden></input>
                <input type="number" name="codPais" placeholder="código de país (+503)"  ></input>
                <input type="number" name="numero"  placeholder="72727281" ></input>
                <g:submitButton name="enviar" class="save btn btn-outline-dark" value="Enviar" />
            </form>

        </div>
    </div>
    </div>
</g:else>
</div>
</body>
</html>
