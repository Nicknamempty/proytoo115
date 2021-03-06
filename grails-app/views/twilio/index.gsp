<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta name="layout" content="main" />
    <title>Twilio</title>
</head>

<body>
<h1>Twilio Demo</h1>



<p><g:link controller="twilio" action="createMessage" class="btn btn-default nounderline">Send SMS</g:link></p>

<p><g:link controller="twilio" action="createMessage" params="[mms: true]" class="btn btn-default nounderline">Send MMS</g:link></p>

<p><g:link controller="twilio" action="messages" class="btn btn-default nounderline">Sent Messages</g:link></p>

<p><g:link controller="twilio" action="clickToCall" class="btn btn-default nounderline">Click To Call</g:link></p>

<p><g:link controller="twilio" action="recordings" class="btn btn-default nounderline">Voice Recordings</g:link></p>
</body>
</html>