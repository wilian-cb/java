/*
 ************************************************************************
 Copyright [2011] [PagSeguro Internet Ltda.]

 Licensed under the Apache License, Version 2.0 (the "License");
 you may not use this file except in compliance with the License.
 You may obtain a copy of the License at

 http://www.apache.org/licenses/LICENSE-2.0

 Unless required by applicable law or agreed to in writing, software
 distributed under the License is distributed on an "AS IS" BASIS,
 WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 See the License for the specific language governing permissions and
 limitations under the License.
 ************************************************************************
 */

package br.com.uol.pagseguro.domain;

import java.util.HashMap;
import java.util.Map;

import br.com.uol.pagseguro.exception.PagSeguroServiceException;

/**
 * Identifies a PagSeguro account
 */
public class AccountCredentials extends Credentials {

    private static final int HASH_SIZE = 3;

    /**
     * Primary email associated with this account
     */
    private String email;

    /**
     * PagSeguro token
     */
    private String token;

    /**
     * Initializes a new instance of the AccountCredentials class
     * 
     * @param email
     * @param token
     */
    public AccountCredentials(String email, String token)throws PagSeguroServiceException {

        if (email == null || "".equals(email.trim()) || token == null || "".equals(token.trim())) {
            throw new PagSeguroServiceException("Credentials not set.");
        }

        this.email = email.trim();
        this.token = token.trim();
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return this.email;
    }

    /**
     * @param email
     *            the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the token
     */
    public String getToken() {
        return this.token;
    }

    /**
     * @param token
     *            the token to set
     */
    public void setToken(String token) {
        this.token = token;
    }

    /**
     * @return array a map of name value pairs that compose this set of
     *         credentials
     */
    @Override
    public Map<Object, Object> getAttributes() {
        
        Map<Object, Object> attributeMap = new HashMap<Object, Object>(HASH_SIZE);
        attributeMap.put("email", this.email);
        attributeMap.put("token", this.token);
        
        return attributeMap;
        
    }

    /**
     * @return string a string that represents the current object
     */
    @Override
    public String toString() {
        return this.email + " - " + this.token;
    }
}
