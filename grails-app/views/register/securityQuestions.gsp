<html>
<head>
    <meta name="layout" content="${layoutRegister}"/>
    <s2ui:title messageCode='spring.security.ui.securityQuestions.title'/>
    <asset:stylesheet href="register.css" src=""></asset:stylesheet>
</head>
<body>
<div class="main">
    <section class="signup">
        <!-- <img src="images/signup-bg.jpg" alt=""> -->
        <div class="container">
            <div class="signup-content">
                <s2ui:form type='securityQuestions' width='50%' >
                    <s2ui:form beanName='securityQuestionsCommand' useToken="true">
                        <input type="hidden" value="${securityQuestionsCommand?.username}" name="username" id="username" />
                        <br/>
                        <h3>Responde a las preguntas y te enviaremos un enlace para restablecer tu contraseña a la dirección que tenemos para tu cuenta.</h3>
                        <s2ui:cmdValidationFields domainClassName="${forgotPasswordExtraValidationDomainClassName}" validations="${securityQuestionsCommand.validations}" myfields="${forgotPasswordExtraValidation}"  user="${user}" validationUserLookUpProperty="${validationUserLookUpProperty}" />
                        <s2ui:submitButton elementId='submit' messageCode='Validar mis preguntas'/>
                    </s2ui:form>
                </s2ui:form>
            </div>
        </div>
    </section>
</div>
</body>
</html>