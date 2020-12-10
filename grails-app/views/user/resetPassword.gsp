<html>
<head>
	<meta name="layout" content="${layoutRegister}"/>
	<s2ui:title messageCode='spring.security.ui.resetPassword.title'/>
	<asset:stylesheet href="register.css" src=""></asset:stylesheet>
</head>
<body>
<div id="login" class="main">
	<section class="signup">
		<!-- <img src="images/signup-bg.jpg" alt=""> -->
		<div class="container">
			<div class="signup-content justify-content-center align-items-center">
				<g:if test='${flash.message}'>
					<div class='login_message'>${flash.message}</div>
				</g:if>
				<h2 class="form-title" style="font-family: 'Berlin Sans FB'">Por favor actualiza tu contraseña...</h2>
				<g:form action='updatePassword' id='passwordResetForm' class='cssform' autocomplete='off'>
					<div class="form-group">
						<g:textField name="username" class="form-input" placeholder="Nombre de usuario"/>
					</div>
					<div class="form-group">
						<g:passwordField name='password' class="form-input" placeholder="Contraseña antigua" />
					</div>
					<div class="form-group">
						<g:passwordField name='password_new' class="form-input" placeholder="Nueva contraseña" />
					</div>
					<div class="form-group">
						<g:passwordField name='password_new_2' class="form-input" placeholder="Nueva contraseña (otra vez)"/>
					</div>
					<div class="form-group">
						<input type='submit' value='Actualizar' class="form-submit"/>
					</div>
				</g:form>
			</div>
	    </div>
	</section>
</div>
</body>
</html>
