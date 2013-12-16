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

import br.com.uol.pagseguro.enums.EnumDocument;

/**
 * Class that represents all available documents type for sender
 */
public class Documents {
    
    private Documents() {
    }

    /**
     * List Document
     * 
     * @var Array
     */
    public static final EnumDocument[] LIST_DOCUMENTS = EnumDocument.values();

    /**
     * Get available document list for Sender use in PagSeguro transactions
     * 
     * @return array
     */
    public static EnumDocument[] getAvailableDocumentList() {
        return LIST_DOCUMENTS;
    }

    /**
     * Check if document type is available for PagSeguro
     * 
     * @param string
     *            documentType
     * @return boolean
     */
    public static boolean isDocumentTypeAvailable(String documentType) {
        boolean available = false;

        for (EnumDocument document : LIST_DOCUMENTS) {
            if (documentType.equalsIgnoreCase(document.getType())) {
                available = true;
            }
        }

        return available;
    }

    /**
     * Get description document by type
     * 
     * @param documentType
     * @return
     */
    public static String getDocumentByType(String documentType) {

        String description = "";

        for (EnumDocument doc : EnumDocument.values()) {
            if (documentType.equalsIgnoreCase(doc.getType())) {
                description = doc.getDescription();
            }
        }
        return description;
    }

    /**
     * Get type document by description
     * 
     * @param documentDescription
     * @return
     */
    public static String getDocumentByDescription(String documentDescription) {

        String type = "";

        for (EnumDocument doc : EnumDocument.values()) {
            if (doc.getDescription() != null && documentDescription.equalsIgnoreCase(doc.getDescription())) {
                type = doc.getType();
            }
        }
        
        return type;
    }

}