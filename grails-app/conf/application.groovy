import org.springframework.security.authentication.*;

// Added by the Spring Security Core plugin:
grails.plugin.springsecurity.userLookup.userDomainClassName = 'proytoo115.User'
grails.plugin.springsecurity.userLookup.authorityJoinClassName = 'proytoo115.UserRole'
grails.plugin.springsecurity.authority.className = 'proytoo115.Role'
grails.plugin.springsecurity.logout.postOnly = false
grails.plugin.springsecurity.controllerAnnotations.staticRules = [
		[pattern: '/h2-console/**',  access: ['ROLE_ADMIN']],
		[pattern: '/user/**',        access: ['permitAll']],
		[pattern: '/role/**',        access: ['permitAll']],
		[pattern: '/securityInfo/**',access: ['ROLE_ADMIN']],
		[pattern: '/registrationCode/**',access: ['ROLE_ADMIN']],
		[pattern: '/plugins/**',     access: ['ROLE_USER']],
		[pattern: '/register/**',    access: ['permitAll']],
		[pattern: '/',               access: ['permitAll']],
		[pattern: '/error',          access: ['permitAll']],
		[pattern: '/index',          access: ['permitAll']],
		[pattern: '/index.gsp',      access: ['permitAll']],
		[pattern: '/shutdown',       access: ['permitAll']],
		[pattern: '/assets/**',      access: ['permitAll']],
		[pattern: '/**/js/**',       access: ['permitAll']],
		[pattern: '/**/css/**',      access: ['permitAll']],
		[pattern: '/**/images/**',   access: ['permitAll']],
		[pattern: '/**/favicon.ico', access: ['permitAll']],
		[pattern: '/**',    access: ['permitAll']]


]


grails.plugin.springsecurity.filterChain.chainMap = [
	[pattern: '/assets/**',      filters: 'none'],
	[pattern: '/**/js/**',       filters: 'none'],
	[pattern: '/**/css/**',      filters: 'none'],
	[pattern: '/**/images/**',   filters: 'none'],
	[pattern: '/**/favicon.ico', filters: 'none'],
	[pattern: '/**',             filters: 'JOINED_FILTERS']
]


// Added by the Spring Security UI plugin:



// Added by the Spring Security UI plugin:
grails.plugin.springsecurity.ui.forgotPassword.forgotPasswordExtraValidationDomainClassName = 'proytoo115.Perfil'
grails.plugin.springsecurity.ui.forgotPassword.forgotPasswordExtraValidation = [
	[labelDomain: 'myQuestion1', prop:'myAnswer1'],
	[labelDomain: 'myQuestion2', prop:'myAnswer2'],
	[labelDomain: 'myQuestion3', prop:'myAnswer3'],
	[labelDomain: 'myQuestion4', prop:'myAnswer4'],
]

grails.plugin.springsecurity.useSecurityEventListener = true
grails.plugin.springsecurity.onInteractiveAuthenticationSuccessEvent = { e, appCtx ->
	// Handle successful login
}
grails.plugin.springsecurity.onAbstractAuthenticationFailureEvent = { e, appCtx ->
	// Handle failed login
	// example of how to obtain the session if you need it

}
grails.plugin.springsecurity.failureHandler.exceptionMappings = [
		[exception: LockedException.name,             url: '/user/resetPassword'],
		[exception: DisabledException.name,           url: '/user/resetPassword'],
		[exception: AccountExpiredException.name,     url: '/user/resetPassword'],
		[exception: CredentialsExpiredException.name, url: '/user/resetPassword']
]
