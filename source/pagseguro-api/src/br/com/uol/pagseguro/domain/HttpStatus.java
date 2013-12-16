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

import br.com.uol.pagseguro.enums.EnumHttpStatus;

/**
 * 
 * HTTP status that PagSeguro web services can return.
 */
public class HttpStatus {

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
     */
    public HttpStatus(Integer status) {
        if (status != null) {
            this.status = status;
            this.type = this.getTypeByStatus(this.status);
        }
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

    /**
     * Get type http status by status
     * 
     * @param status
     * @return string
     */
    private String getTypeByStatus(Integer status) {

        String httpType = "";

        for (EnumHttpStatus http : EnumHttpStatus.values()) {
            if (http.getStatus().compareTo(status) == 0) {
                httpType = http.getType();
            }
        }
        
        return httpType;
    }

}
