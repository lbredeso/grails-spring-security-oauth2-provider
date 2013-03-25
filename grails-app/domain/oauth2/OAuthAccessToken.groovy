/*
 * Copyright 2013 Physical Graph Corporation
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package oauth2

class OAuthAccessToken {
	
	String tokenId
	byte[] token
	byte[] authentication
	String refreshToken
	String username
	
	Date dateCreated
	
	static constraints = {
		tokenId blank: false, nullable: false, unique: true
	}
	
	static mapping = {
		version false
	}
}