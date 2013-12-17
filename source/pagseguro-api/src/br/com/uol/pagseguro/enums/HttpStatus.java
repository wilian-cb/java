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
 * HttpStatus
 */
public enum HttpStatus {

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
    private Integer code;

    /**
     * The type http status Exemple : BAD_REQUEST
     * 
     * @var string
     */
    private String status;

    /**
     * Construct
     * 
     * @param status
     * @param type
     */
    HttpStatus(Integer status, String type) {
        setStatus(status);
        setType(type);
    }

    public static HttpStatus fromCode(Integer code) {

        for (HttpStatus httpStatus : values()) {
            if (httpStatus.code.equals(code)) {
                return httpStatus;
            }
        }

        return null;

    }

    /**
     * @return the status
     */
    public Integer getStatus() {
        return this.code;
    }

    /**
     * @param status
     *            the status to set
     */
    public void setStatus(Integer status) {
        this.code = status;
    }

    /**
     * @return the type
     */
    public String getType() {
        return this.status;
    }

    /**
     * @param type
     *            the type to set
     */
    public void setType(String type) {
        this.status = type;
    }

}