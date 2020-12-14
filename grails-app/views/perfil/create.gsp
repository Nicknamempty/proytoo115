<!DOCTYPE html>
<html>
    <head>
      <meta charset="UTF-8">
      <meta name="viewport" content="width=device-width, initial-scale=1.0">
      <meta http-equiv="X-UA-Compatible" content="ie=edge">
         <asset:stylesheet href="bootstrap.css" src=""></asset:stylesheet>
         <asset:stylesheet href="perfil.css" src=""></asset:stylesheet>
    </head>
    <body>
     <a href="#create-perfil" class="skip" tabindex="-1"></a>
         <div id="create-perfil" class="content scaffold-create" role="main">
          <div class="row"> 
           <div class="col-sm-8 col-md-8 col-lg-14 mx-auto">
            <div class="card card-signin my-7"  style="border-radius: 5px">  
            <div class="card-body">
             <h1 class="form-title" style="font-family: 'Berlin Sans FB">Preguntas de seguridad</h1>
              <g:hasErrors bean="${this.perfil}">
                <ul class="errors" role="alert">
                    <g:eachError bean="${this.perfil}" var="error">
                    <li <g:if test="${error in org.springframework.validation.FieldError}">data-field-id="${error.field}"</g:if>><g:message error="${error}"/></li>
                    </g:eachError>
                </ul>
              </g:hasErrors>   
              <s2ui:formContainer type='save' beanType='perfil'>
                <s2ui:form useToken="true"> 
                 <p>Estas preguntas nos ayudarán a verificar tu identidad si olvidas tu contraseña</p>
                    <div hidden>
                        <s2ui:selectRow name='user.id' class='form-control' from='${users}' labelCodeDefault='Usuario:' optionValue='${lookupProp}'/>
                    </div>

                    <div class="form-group">                
                       <select name="myQuestion1" class="form-control" required>
                        <option value="" selected="selected">- Selecciona aquí la pregunta No.1-</option>
                        <option>¿Cuál es el nombre de tu mascota?</option>
                        <option>¿En qué ciudad se conocieron sus padres?</option>
                        <option>Mejor amigo de la infancia</option>
                        <option>Lugar de nacimiento de tu madre</option>
                        <option>¿Cómo se llamaba la primera escuela a la que asististe?</option>
                        <option>¿Cómo se llama tu tio favorito?</option>
                        <option>¿Cuál es el nombre de su primer amor?</option>
                       </select>
               			    <!--<s2ui:textFieldRow name='myQuestion1' size='70' class="form-control" labelCodeDefault='Pregunta 1'/>-->                       
                       <s2ui:textFieldRow name='myAnswer1'  class="form-control" required placeholder='Respuesta'/>
                     </div>

                    <div class="form-group">  
                        <select name="myQuestion2" class="form-control" required>
                            <option value="" selected="selected">- Selecciona aqui la pregunta No.2 -</option>
                            <option>¿Cuál es el nombre de tu mascota?</option>
                            <option>Mejor amigo de la infancia</option>
                            <option>Lugar de nacimiento de tu madre</option>
                            <option>¿En qué ciudad se conocieron sus padres?</option>
                            <option>¿Cómo se llamaba la primera escuela a la que asististe?</option>
                            <option>¿Cómo se llama tu tio favorito?</option>
                            <option>¿Cuál es el nombre de su primer amor?</option>
                        </select>
            			      <!--<s2ui:textFieldRow name='myQuestion2' size='70' class="form-control" labelCodeDefault='Pregunta 2'/>-->
            		        <s2ui:textFieldRow name='myAnswer2' size='40' type="password" class="form-control" required placeholder='Respuesta'/>
                     </div>

                     <div class="form-group">  
                        <select name="myQuestion3" class="form-control">
                            <option>¿Cuál es el nombre de tu mascota?</option>
                            <option value="" selected="selected" required>- Selecciona aqui la pregunta No.3-</option>
                            <option>¿En qué ciudad se conocieron sus padres?</option>
                             <option>Mejor amigo de la infancia</option>
                            <option>Lugar de nacimiento de tu madre</option>
                            <option>¿Cómo se llamaba la primera escuela a la que asististe?</option>
                            <option>¿Cómo se llama tu tio favorito?</option>
                            <option>¿Cuál es el nombre de su primer amor?</option>
                        </select>
                        <s2ui:textFieldRow name='myAnswer3' class="form-control" required placeholder='Respuesta'/>
                      </div>  

            			    <div class="form-group">              
                        <select name="myQuestion4" class="form-control">
                          <option value="" selected="selected" required>- Selecciona aqui la pregunta No.4 -</option>
                            <option>¿Cuál es el nombre de tu mascota?</option>
                            <option>¿En qué ciudad se conocieron sus padres?</option>
                             <option>Mejor amigo de la infancia</option>
                            <option>Lugar de nacimiento de tu madre</option>
                            <option>¿Cómo se llamaba la primera escuela a la que asististe?</option>
                            <option>¿Cómo se llama tu tio favorito?</option>
                            <option>¿Cuál es el nombre de su primer amor?</option>
                        </select>
            			      <s2ui:textFieldRow name='myAnswer4' class="form-control" required placeholder='Respuesta' />
                      </div>
                     
                    <div class="row">
                      <div class="col">
                        <g:submitButton name="create" class="save btn btn-primary" id="button" value="Terminar" />
                      </div>
                    </div>
                </s2ui:form>
              </s2ui:formContainer>
              </div>
            </div>
         </div>
       </div>  
    </div> 
  </body>
</html>

