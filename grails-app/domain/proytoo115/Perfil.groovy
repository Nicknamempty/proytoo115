package  proytoo115

import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString


@EqualsAndHashCode(includes='user')
@ToString(includes='user', includeNames=true, includePackage=false)
class Perfil implements Serializable {

    private static final long serialVersionUID = 1

     
    String myQuestion1
    String myAnswer1
     
    String myQuestion2
    String myAnswer2
     
    String myQuestion3
    String myAnswer3
     
    String myQuestion4
    String myAnswer4
     
    User user

     static constraints = {
         
             myQuestion1 nullable: true, blank: false
             myAnswer1 nullable: false, blank: false
         
             myQuestion2 nullable: true, blank: false
             myAnswer2 nullable: false, blank: false
         
             myQuestion3 nullable: true, blank: false
             myAnswer3 nullable: false, blank: false
         
             myQuestion4 nullable: true, blank: false
             myAnswer4 nullable: false, blank: false
         
            user nullable: false, blank: false, unique: true
        }

    static belongsTo = [ user: User]


}