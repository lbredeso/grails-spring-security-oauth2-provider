/* Copyright 2006-2011 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the 'License');
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an 'AS IS' BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import org.codehaus.groovy.grails.plugins.springsecurity.SecurityFilterPosition

import org.springframework.security.oauth2.provider.InMemoryClientDetailsService
import org.springframework.security.oauth2.provider.code.InMemoryAuthorizationCodeServices
import org.springframework.security.oauth2.provider.token.InMemoryTokenStore

security {
	oauthProvider {
		clientDetailsServiceClass = InMemoryClientDetailsService
		tokenStoreClass = InMemoryTokenStore
		authorizationCodeServicesClass = InMemoryAuthorizationCodeServices
		active = true
		filterStartPosition = SecurityFilterPosition.EXCEPTION_TRANSLATION_FILTER.order
		endpointUrlFilterPosition = filterStartPosition + 1
		exceptionHandlerFilterPosition = filterStartPosition + 2
		protectedResourceFilterPosition = filterStartPosition + 3
		
		authorizationCode {
			approvalParameterName = "user_oauth_approval"
		}
		tokenServices {
			accessTokenValiditySeconds = 60 * 60 * 12 //default 12 hours
			refreshTokenValiditySeconds = 60 * 60 * 24 * 60 //default 60 days
			reuseRefreshToken = true
			supportRefreshToken = true
		}
		authorizationEndpointUrl = "/oauth/authorize"
		tokenEndpointUrl = "/oauth/token"
		userApprovalEndpointUrl = "/oauth/confirm"
		
		// Decides which grant types are enabled or not
		grantTypes {
			authorizationCode = true
			implicit = true
			refreshToken = true
			clientCredentials = true
			password = true
		}
		defaultClientConfig {
			resourceIds = []
			authorizedGrantTypes = ["authorization_code", "refresh_token"]
			scope = []
			registeredRedirectUri = null
			authorities = []
		}
		clients = []
	}
}

environments {
	test {
		security.oauthProvider.active = false
	}
}