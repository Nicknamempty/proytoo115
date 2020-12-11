

// Added by the Spring Security Core plugin:
grails.plugin.springsecurity.userLookup.userDomainClassName = 'proytoo115.User'
grails.plugin.springsecurity.userLookup.authorityJoinClassName = 'proytoo115.UserRole'
grails.plugin.springsecurity.authority.className = 'proytoo115.Role'
grails.plugin.springsecurity.requestMap.className = 'proytoo115.Requestmap'
grails.plugin.springsecurity.securityConfigType = "Requestmap"
grails.plugin.springsecurity.logout.postOnly = false
grails.plugin.springsecurity.controllerAnnotations.staticRules = [

		[pattern: '/register/**',    access: ['permitAll']],
		[pattern: '/register/**',    access: ['permitAll']],
		[pattern: '/login/**',         access: ['permitAll']],
		[pattern: '/error',          access: ['permitAll']],
		[pattern: '/index',          access: ['permitAll']],
		[pattern: '/index.gsp',      access: ['permitAll']],
		[pattern: '/shutdown',       access: ['permitAll']],
		[pattern: '/assets/**',      access: ['permitAll']],
		[pattern: '/**/js/**',       access: ['permitAll']],
		[pattern: '/**/css/**',      access: ['permitAll']],
		[pattern: '/**/images/**',   access: ['permitAll']],
		[pattern: '/**/favicon.ico', access: ['permitAll']],

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

authy.accountSID = "AC7d4a5385da25d6fd66488c4d4d5e387c"
authy.authToken = "d83f16e422cbe8e9d919063253f85923"
authy.fromPhoneNumber = "+15104789443"
authy.apiKey = "WjcbriE7S1ifY9E4p6Evo0JXR32epC47"



