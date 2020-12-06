<html>
<head>
	<meta name="layout" content="${layoutRegister}"/>
	<s2ui:title messageCode='spring.security.ui.resetPassword.title'/>
	<asset:stylesheet href="register.css" src=""></asset:stylesheet>
</head>
<body>
<div class="main">
	<section class="signup">
		<!-- <img src="images/signup-bg.jpg" alt=""> -->
		<div class="container">
			<div class="signup-content">
				<s2ui:form type='resetPassword' focus='password' width='475px'>
					<s2ui:form beanName='resetPasswordCommand'>
						<g:hiddenField name='t' value='${token}'/>
						<div class="form-group">
							<h2 class="form-title" style="font-family: 'Berlin Sans FB'">Cambiar contraseña</h2>
							<h3>Ingresa tu nueva contraseña</h3>
						</div>
						<div class="form-group">
							<s2ui:passwordFieldRow name='password' class="form-input" labelCodeDefault='Contraseña'/>
						</div>
						<div class="form-group">
							<s2ui:passwordFieldRow name='password2' class="form-input" labelCodeDefault='Repite la contraseña'/>
						</div>
						<div class="form-group">
							<input type="submit" name="submit" id="submit" class="form-submit" value="Actualizar"/>
						</div>
					</s2ui:form>
				</s2ui:form>
			</div>
	    </div>
	</section>
</div>
</body>
</html>
