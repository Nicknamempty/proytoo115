package proytoo115

import com.authy.AuthyApiClient
import com.authy.api.ApprovalRequestParams
import com.authy.api.OneTouch
import com.authy.api.OneTouchResponse
import com.authy.api.Token
import grails.gorm.transactions.Transactional
import grails.plugin.springsecurity.ui.strategy.UserStrategy
import proytoo115.co.RegistrationForm

@Transactional
class RegisterService {
    UserStrategy uiUserStrategy
    def grailsApplication

    boolean saveUser(String email, String phoneNumber,String countryCode,String username) {
        AuthyApiClient authyClient = new AuthyApiClient(grailsApplication.config.authy.apiKey)

        // Crea un usuario en la api authy
        com.authy.api.User authyUser = authyClient.getUsers().createUser(email,phoneNumber, countryCode);

        if (authyUser.isOk()) {
            Integer authyUserId = authyUser.getId();
            println "Este es el id de authy"
            println authyUserId.toString()
            // Create actualizar usuario
            /*Role role = Role.findByAuthority("ROLE_USER")
            User user = new User(
                    username: form.email,
                    password: form.password,
                    countryCode: form.countryCode,
                    phoneNumber: form.phoneNumber,
                    authyUserId: authyUserId).save()
            new UserRole(User: user, Role: role).save()
*/
            User user = User.findByUsername(username)
          //  user.phoneNumber = phoneNumber
          //  user.countryCode = countryCode
            user.authyUserId = authyUserId
            user.accountLocked = false
         //   String xdx = user.authyUserId.toString()
            user.save(flush: true)
         //   println "Estes el authy del usuario"
         //   println(xdx)
         //   User user2 = User.findByUsername(username)
         //   println(xdx)


            return Boolean.TRUE
        } else {
            log.error(authyUser.getStatus())
            log.error(authyUser.getError())
            return Boolean.FALSE
        }
    }

    Boolean verifyCode(String userName, String code) {
        User user = User.findByUsername(userName);


        AuthyApiClient authyClient = new AuthyApiClient(grailsApplication.config.authy.apiKey)
        Token token = authyClient.getTokens().verify(user.authyUserId, code);

        if (token.isOk()) {
            // Send SMS confirmation
            // sendMessage(user.getFullPhoneNumber(), "Login successful!");

            return Boolean.TRUE
        } else {
            return Boolean.FALSE
        }
    }

    def sendVerificationCode(String userName) {
        User user = User.findByUsername(userName);
        AuthyApiClient authyClient = new AuthyApiClient(grailsApplication.config.authy.apiKey)

        // Request SMS authentication
        authyClient.getUsers().requestSms(user.authyUserId);
    }

    def sendVerificationCodeByCall(String userName) {
        User user = User.findByUsername(userName);
        AuthyApiClient authyClient = new AuthyApiClient(grailsApplication.config.authy.apiKey)

        // Request Call authentication
        authyClient.getUsers().requestCall(user.authyUserId);
    }

    String requestOneTimeAuthentication(String userName) {
        User user = User.findByUsername(userName);
        AuthyApiClient authyClient = new AuthyApiClient(grailsApplication.config.authy.apiKey)

        ApprovalRequestParams approvalRequestParams = new ApprovalRequestParams.Builder(user.authyUserId, "Authorize OneTouch Test")
                .addDetail("username", user.username)
                .addLogo(ApprovalRequestParams.Resolution.Default, "https://media.glassdoor.com/sql/780298/jellyfish-technologies-squarelogo-1427198372245.png")
                .build();

        OneTouchResponse response = authyClient.getOneTouch().sendApprovalRequest(approvalRequestParams);
        // If the request was successfuly created.
        String uuid = response.getApprovalRequest().getUUID();
        System.out.println(uuid);

        return uuid;
    }

    String checkOTStatus(String uuid) {
        AuthyApiClient authyClient = new AuthyApiClient(grailsApplication.config.authy.apiKey)
        OneTouch oneTouch = authyClient.getOneTouch()
        OneTouchResponse response = oneTouch.getApprovalRequestStatus(uuid);
        OneTouchResponse.ApprovalRequest approvalRequest = response.getApprovalRequest();
        println approvalRequest.getStatus()
        return approvalRequest.getStatus()
    }
}
