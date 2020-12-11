<html>
<head>
	<meta name="layout" content="${layoutRegister}"/>
	<s2ui:title messageCode='spring.security.ui.forgotPassword.title'/>
	<asset:stylesheet href="register.css" src=""></asset:stylesheet>
</head>
<body>
<div class="main">
	<section class="signup">
		<!-- <img src="images/signup-bg.jpg" alt=""> -->
		<div class="container">
			<div class="signup-content">
				<s2ui:form type='forgotPassword' focus='username' width='50%' >
					<s2ui:form beanName='forgotPasswordCommand' useToken="true">
						<g:if test='${emailSent}'>
							<br/>
							<g:message code='spring.security.ui.forgotPassword.sent'/>
						</g:if>
						<g:else>
							<br/>
							<h3>Introduce tu nombre de usuario y te enviaremos un enlace para restablecer tu contraseña a la dirección que tenemos para tu cuenta.</h3>
							<div class="form-group">
								<s2ui:textFieldRow type="text" class="form-input" name="username" id="username" placeholder="Nombre de usuario"/>
							</div>
							<input type="submit" name="submit" id="submit" class="form-submit" value="Modificar contraseña"/>
						</g:else>
					</s2ui:form>
				</s2ui:form>
			</div>
	    </div>
	</section>
</div>

</body>
</html>
