<!DOCTYPE html>
<html lang="es">
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<meta http-equiv="X-UA-Compatible" content="ie=edge">
	<title>Registrar</title>
	<!-- Main css -->
	<asset:stylesheet href="register.css" src=""></asset:stylesheet>
</head>
<body>
<div class="main">
	<section class="signup">
		<!-- <img src="images/signup-bg.jpg" alt=""> -->
		<div class="container">
			<div class="signup-content">
				<s2ui:form type='register' focus='username'>
					<s2ui:form id="signup-form" class="signup-form" beanName='registerCommand'>
						<g:if test='${emailSent}'>
							<br/>
							<g:message code='spring.security.ui.register.sent'/>
						</g:if>
						<g:else>
							<h2 class="form-title" style="font-family: 'Berlin Sans FB'">Crear Cuenta</h2>
							<div class="form-group">
								<s2ui:textFieldRow type="text" class="form-input" name="username" id="username" placeholder="Nombre de usuario"/>
							</div>
							<div class="form-group">
								<s2ui:textFieldRow type="email" class="form-input" name="email" id="email" placeholder="Email"/>
							</div>
							<div class="form-group">
								<s2ui:passwordFieldRow type="password" class="form-input" name="password" id="password" placeholder="Contraseña"/>
								<span toggle="#password" class="zmdi zmdi-eye field-icon toggle-password"></span>
							</div>
							<div class="form-group">
								<s2ui:passwordFieldRow type="password" class="form-input" name="password2" id="password2" placeholder="Repite tu contraseña"/>
							</div>
							<div class="form-group">
								<input type="submit" name="submit" messageCode="spring.security.ui.register.submit" id="submit" class="form-submit" value="Registrar"/>
							</div>
						</g:else>
					</s2ui:form>
				</s2ui:form>
				<p class="loginhere" style="font-family: 'Berlin Sans FB'">
					¿Ya tienes una cuenta? <a href="/login" class="loginhere-link" style="font-family: 'Montserrat'">Entra aquí</a>
				</p>
			</div>
		</div>
	</section>
</div>
</body><!-- This templates was made by Colorlib (https://colorlib.com) -->
</html>