package  proytoo115

import grails.events.annotation.gorm.Listener
import grails.plugin.springsecurity.SpringSecurityService
import groovy.transform.CompileStatic
import org.grails.datastore.mapping.engine.event.PreInsertEvent
import org.grails.datastore.mapping.engine.event.PreUpdateEvent

@CompileStatic
class PerfilListenerService {

    SpringSecurityService springSecurityService

    @Listener(Perfil)
    void onPerfilPreInsert(PreInsertEvent event) {
        
           event.entityAccess.setProperty('myAnswer1' , springSecurityService.encodePassword((event.entityAccess.getProperty('myAnswer1') as String).toLowerCase()))
          
           event.entityAccess.setProperty('myAnswer2' , springSecurityService.encodePassword((event.entityAccess.getProperty('myAnswer2') as String).toLowerCase()))
          
           event.entityAccess.setProperty('myAnswer3' , springSecurityService.encodePassword((event.entityAccess.getProperty('myAnswer3') as String).toLowerCase()))
          
           event.entityAccess.setProperty('myAnswer4' , springSecurityService.encodePassword((event.entityAccess.getProperty('myAnswer4') as String).toLowerCase()))
          
    }

    @Listener(Perfil)
    void onPerfilPreUpdate(PreUpdateEvent event) {
        Perfil prof = ((Perfil) event.entityObject)
        
        if ( prof.isDirty('myAnswer1') ) {
            event.entityAccess.setProperty('myAnswer1' , springSecurityService.encodePassword((event.entityAccess.getProperty('myAnswer1') as String).toLowerCase()))
        }
        
        if ( prof.isDirty('myAnswer2') ) {
            event.entityAccess.setProperty('myAnswer2' , springSecurityService.encodePassword((event.entityAccess.getProperty('myAnswer2') as String).toLowerCase()))
        }
        
        if ( prof.isDirty('myAnswer3') ) {
            event.entityAccess.setProperty('myAnswer3' , springSecurityService.encodePassword((event.entityAccess.getProperty('myAnswer3') as String).toLowerCase()))
        }
        
        if ( prof.isDirty('myAnswer4') ) {
            event.entityAccess.setProperty('myAnswer4' , springSecurityService.encodePassword((event.entityAccess.getProperty('myAnswer4') as String).toLowerCase()))
        }
        

    }


}
