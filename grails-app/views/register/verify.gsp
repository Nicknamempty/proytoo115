<%--
  Created by IntelliJ IDEA.
  User: Fernando
  Date: 08/12/2020
  Time: 01:27 p. m.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta name="layout" content="main" />
    <title>Verify Code</title>

    <asset:javascript src="jquery-2.2.0.min.js" />
    <asset:javascript src="spring-websocket" />

    <script type="text/javascript">
        $(function () {
            checkOTStatus();
            var client = Stomp.over(new SockJS("${createLink(uri: '/stomp')}"));
            client.connect({}, function () {
                client.subscribe("/topic/checkOTStatus", function () {
                    checkOTStatus();
                });
            });
        });

        function checkOTStatus() {
            $.ajax({
                url: "${g.createLink(controller: 'registration', action: 'checkOTStatus')}",
                type: 'POST',
                contentType: 'application/json',
                dataType: 'json',
                success: function (result) {
                    if (result.status == 'approved') {
                        window.location.href = result.url;
                    } else if (result.status == 'denied') {
                        alert(result.message)
                    } else {
                        console.error(result);
                    }
                }
            });
        }
    </script>
</head>

<body>

<g:if test='${NoPhone}'>
    <br/>
    <div class="alert alert-error" style="display: block">${flash.error}</div>

    <div class="card card-body">
        <form controller="Register" action="PorTelefono">
            <input name="user" value="${params.user}"  hidden></input>
            <input name="email" value="${params.email}"  hidden></input>
            <input type="number" name="codPais" placeholder="código de país (+503)"  ></input>
            <input type="number" name="numero"  placeholder="72727281" ></input>
            <g:submitButton name="enviar" class="save btn btn-outline-dark" value="Enviar" />
        </form>

    </div>
</g:if>
<g:else>
    <g:if test="${flash.error}">
        <div class="alert alert-error" style="display: block">${flash.error}</div>
    </g:if>
    <g:if test="${flash.message}">
        <div class="" style="display: block">${flash.message}</div>
    </g:if>
<div style="padding-bottom: 40em; margin: 250px;" class="shadow p-3 mb-5 bg-white rounded d-flex justify-content-center " >
   <div>
       <h1>
           Verifica tu cuenta
       </h1>
   </div>

<g:form controller="register" action="verifyCode" method="post">
    <div class="form-group">
        <label for="code">Verificar código:</label>
        <input type="text" class="form-control" name="code" id="code">
    </div>
    <button class="btn btn-primary">Verificar</button>
    <g:form controller="register" action="resendVerificationCode" method="post" class="btn pull-right">
        <button class="btn">Reenviar Mensaje</button>
    </g:form>
</g:form>


</div>
</g:else>
</body>
</html>