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

import br.com.uol.pagseguro.domain.Documents;

/**
 * 
 * EnumDocument
 */
public enum EnumDocument {

    CPF("CPF", "Cadastro de Pessoa Física");

    /**
     * The type document
     * 
     * @var string
     */
    private String type;

    /**
     * The description document
     * 
     * @var string
     */
    private String description;

    /**
     * Construct
     * 
     * @param type
     * @param description
     * @see Documents
     */
    EnumDocument(String type, String description) {
        setType(type);
        setDescription(description);
    }
    
    public static EnumDocument fromValue(String type) {
        
        for (EnumDocument enumDocument : values()) {
            if (enumDocument.type.equals(type)) {
                return enumDocument;
            }
        }
        
        return null;
        
    }

    /**
     * @return the type
     */
    public String getType() {
        return type;
    }

    /**
     * @param type
     *            the type to set
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description
     *            the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }
}