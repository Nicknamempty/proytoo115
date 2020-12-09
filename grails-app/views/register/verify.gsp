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
<p>
    Account verification for security. Please enter the security code (check your phone).
</p>



<g:form controller="register" action="verifyCode" method="post">
    <div class="form-group">
        <label for="code">Verificar código:</label>
        <input type="text" class="form-control" name="code" id="code">
    </div>
    <button class="btn btn-primary">Verificar</button>
</g:form>

<g:form controller="register" action="resendVerificationCode" method="post" class="btn pull-right">
    <button class="btn">Reenviar Mensaje</button>
</g:form>

<!--<g:form controller="register" action="resendVerificationCodeViaCall" method="post" class="btn pull-right">
    <button class="btn">Resend Security Code Via Phone Call</button>
</g:form>

<g:form controller="register" action="oneTouchAuthenticationRequest" method="post" class="btn pull-right">
    <button class="btn">Request One Touch Authentication</button> -->
</g:form>
</body>
</html>