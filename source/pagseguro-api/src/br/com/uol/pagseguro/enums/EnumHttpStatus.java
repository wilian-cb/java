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

package br.com.uol.pagseguro.enums;

/**
 * 
 * Class Enum HttpStatus
 */
public enum EnumHttpStatus {

    OK(200, "OK"), 
    BAD_REQUEST(400, "BAD_REQUEST"), 
    UNAUTHORIZED(401, "UNAUTHORIZED"), 
    FORBIDDEN(403, "FORBIDDEN"), 
    NOT_FOUND(404, "NOT_FOUND"), 
    INTERNAL_SERVER_ERROR(500, "INTERNAL_SERVER_ERROR"), 
    BAD_GATEWAY(502, "BAD_GATEWAY");

    /**
     * The status http Exemple 200
     * 
     * @var Integer
     */
    private Integer status;

    /**
     * The type http status Exemple : BAD_REQUEST
     * 
     * @var string
     */
    private String type;

    /**
     * Construct
     * 
     * @param status
     * @param type
     */
    EnumHttpStatus(Integer status, String type) {
        setStatus(status);
        setType(type);
    }
    
    public static EnumHttpStatus fromValue(Integer value) {
        
        for (EnumHttpStatus enumHttpStatusa : values()) {
            if (enumHttpStatusa.status.equals(value)) {
                return enumHttpStatusa;
            }
        }
        
        return null;
        
    }

    /**
     * @return the status
     */
    public Integer getStatus() {
        return this.status;
    }

    /**
     * @param status
     *            the status to set
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * @return the type
     */
    public String getType() {
        return this.type;
    }

    /**
     * @param type
     *            the type to set
     */
    public void setType(String type) {
        this.type = type;
    }

}