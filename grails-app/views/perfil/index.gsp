<!DOCTYPE html>
<html>
    <head>
         <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'perfil.label', default: 'Perfil')}" />
         <title><g:message code="default.list.label" args="[entityName]" /></title>
         <asset:stylesheet href="bootstrap.css" src=""></asset:stylesheet>
    </head>
    <body>
     <a href="#list-perfil" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
        <div id="list-perfil" class="body" role="main">
        <h1 class="text-center">Administrar</h1>
           <div class="list">
           		<table>
           			<thead>
           			<tr>
           				<s2ui:sortableColumn property='id' titleDefault='ID'/>
                        
                        <s2ui:sortableColumn property='user' titleDefault='Usuario'/>
                     
                        <s2ui:sortableColumn property='myQuestion1' titleDefault='Pregunta1'/>
                        <s2ui:sortableColumn property='myAnswer1' titleDefault='Respuesta'/>
                     
                        <s2ui:sortableColumn property='myQuestion2' titleDefault='Pregunta2'/>
                        <s2ui:sortableColumn property='myAnswer2' titleDefault='Respuesta'/>
                     
                        <s2ui:sortableColumn property='myQuestion3' titleDefault='Pregunta3'/>
                        <s2ui:sortableColumn property='myAnswer3' titleDefault='Respuesta'/>
                     
                        <s2ui:sortableColumn property='myQuestion4' titleDefault='Pregunta4'/>
                        <s2ui:sortableColumn property='myAnswer4' titleDefault='Respuesta'/>
           			</tr>
           			</thead>
           			<tbody>
           			<g:each in='${results}' status='i' var='entry'>
           				<tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
           					<td><g:link action='edit' id='${entry.id}'>${entry.id}</g:link></td>
                            <td><g:link action='edit' controller='User' id='${entry.userId}'>${entry.user}</g:link></td>
           					 
                                                    <td>${entry.myQuestion1}</td>
                                                    <td>${entry.myAnswer1}</td>
                                                 
                                                    <td>${entry.myQuestion2}</td>
                                                    <td>${entry.myAnswer2}</td>
                                                 
                                                    <td>${entry.myQuestion3}</td>
                                                    <td>${entry.myAnswer3}</td>
                                                 
                                                    <td>${entry.myQuestion4}</td>
                                                    <td>${entry.myAnswer4}</td>
                                                 
           				</tr>
           			</g:each>
           			</tbody>
           		</table>
           	</div>
           	<s2ui:paginate total='${totalCount}'/>
               <div class="text-center form-group">
                 <g:link class="create btn btn-primary btn-create ml-3 mb-3" action="create">Agregar</g:link>
               </div>
        </div>
        
    </body>
</html>