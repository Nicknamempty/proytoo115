<g:set var='securityConfig' value='${applicationContext.springSecurityService.securityConfig}'/>
<!DOCTYPE html>
<html lang="es">
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<meta http-equiv="X-UA-Compatible" content="ie=edge">
	<asset:stylesheet href="bootstrap.css" src=""></asset:stylesheet>
	<asset:stylesheet href="login.css" src=""></asset:stylesheet>
</head>
<body>
<p/>
<div class="row"> 
 <div class="col-sm-10 col-md-10 col-lg-7 mx-auto">
  <div class="card card-signin my-5"  style="border-radius: 5px">
   <div class="card-body">
		<s2ui:form type='login' focus='username'>
			  <g:img dir="images" file="across.jpg" width="250" height="150" class="mx-auto d-block"/>
			  <p></p>
				    <div class="form-group">
						<input type="text" name="${securityConfig.apf.usernameParameter}" id="username" class="form-control" placeholder="Usuario" size="20" required/>
					</div>

					<div class="form-group">
					     <input type="password" name="${securityConfig.apf.passwordParameter}" id="password" class="form-control" placeholder="Contraseña" size="20" required />
					</div>
					<div class="form-check">	
							<input type="checkbox" class="form-check-input" name="${securityConfig.rememberMe.parameter}" id="remember_me" checked="checked" />
							<label for='remember_me' class="form-check-label">Mantener la sesión iniciada</label> 
					</div>	
					<p></p>
					<button id="loginButton" elementId="loginButton" class="button" type="submit" messageCode="spring.security.ui.login.login">Iniciar Sesion</button>
					<!--<s2ui:submitButton elementId='loginButton' class="submit" type="submit" messageCode='spring.security.ui.login.login'/>-->
					<p></p>
					<div class="text-center form-group">	
					<span class="forgot-link" >
						<g:link controller='register' action='forgotPassword'>¿Olvidaste tu contraseña?</g:link>
					</span>
					<p>¿No tienes una cuenta? <g:link controller='register' elementId='register'>Registrate ahora</g:link></p>
				  </div>		
		</s2ui:form>
		</div>
		</div>
	</div>
</div>
</body>
</html>
