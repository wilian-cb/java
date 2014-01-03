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

import br.com.uol.pagseguro.enums.DocumentType;
import br.com.uol.pagseguro.helper.PagSeguroUtil;

/**
 * Represents document
 */
public class Document {

    /**
     * The type document
     */
    private DocumentType type;

    /**
     * The value document
     */
    private String value;

    /**
     * Construct Default
     */
    public Document() {
    }

    /**
     * Construct
     * 
     * @param type
     * @param value
     */
    public Document(DocumentType type, String value) {
        this.setType(type);
        this.setValue(PagSeguroUtil.getOnlyNumbers(value));
    }

    /**
     * @return the type
     */
    public DocumentType getType() {
        return this.type;
    }

    /**
     * @param type
     *            the type to set
     */
    private void setType(DocumentType type) {
        this.type = type;
    }

    /**
     * @return the value
     */
    public String getValue() {
        return this.value;
    }

    /**
     * @param value
     *            the value to set
     */
    private void setValue(String value) {
        this.value = value;
    }

}
