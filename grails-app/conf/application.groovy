

// Added by the Spring Security Core plugin:
grails.plugin.springsecurity.userLookup.userDomainClassName = 'proytoo115.User'
grails.plugin.springsecurity.userLookup.authorityJoinClassName = 'proytoo115.UserRole'
grails.plugin.springsecurity.authority.className = 'proytoo115.Role'
grails.plugin.springsecurity.password.algorithm = 'SHA-512'
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

authy.accountSID = "ACd3acca9dfd777d98a45b8b9c2612103c"
authy.authToken = "ffc707501dc6ab013aa7bfdcf41a3d77"
authy.fromPhoneNumber = "+15104789443"
authy.apiKey = "WjcbriE7S1ifY9E4p6Evo0JXR32epC47"