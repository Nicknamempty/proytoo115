<html>
<head>
	<meta name="layout" content="${layoutUi}"/>
	<s2ui:title messageCode='Agregar rol' entityNameMessageCode='role.label' entityNameDefault='Role'/>
	<asset:stylesheet href="crear.css" src=""></asset:stylesheet>
</head>
<body>
 <div class="mb-2">
	<a class="btn btn-outline-dark font-weight-bold btn-sm" href="/role">Regresar</a>
 </div>
 <div class="main">
	<section class="signup">
		<!-- <img src="images/signup-bg.jpg" alt=""> -->
		<div class="container">
			<div class="signup-content">
				<s2ui:form type='save' beanType='role' focus='authority' height='300'>
					<s2ui:form useToken="true" beanName="role">
						<h2 class="form-title" style="font-family: 'Berlin Sans FB'">Agregar Rol</h2>
						<div class="form-group">
							<s2ui:textFieldRow name='authority' class="form-input" size='50' labelCodeDefault='Nombre'/>
						</div>
						<div class="form-group">
							<input type="submit" name="submit" id="submit" class="save btn btn-primary" value="Crear"/>
						</div>
					</s2ui:form>
				</s2ui:form>
			</div>
	    </div>
	</section>
 </div>
</body>
</html>
