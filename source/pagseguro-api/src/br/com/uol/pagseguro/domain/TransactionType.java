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

import br.com.uol.pagseguro.enums.EnumTransactionType;

public class TransactionType {

    private Integer value;

    /**
     * Construct Default
     */
    public TransactionType() {
    }

    /**
     * Construct
     * 
     * @param value
     */
    public TransactionType(Integer value) {
        this.value = value;
    }

    /**
     * Set By Type
     * 
     * @param type
     */
    public void setByType(String type) {

        Integer auxValue = 0;

        for (EnumTransactionType transactionType : EnumTransactionType.values()) {
            if (type.equalsIgnoreCase(transactionType.getType())) {
                auxValue = transactionType.getValue();
            }
        }
        
        if (auxValue > 0) {
            this.value = auxValue;
        }
        
    }

    /**
     * 
     * @param value
     * @return the transaction type corresponding to the informed type value
     */
    public String getTypeFromValue(Integer value) {

        String type = "";

        for (EnumTransactionType transactionType : EnumTransactionType.values()) {
            if (value.equals(transactionType.getValue())) {
                type = transactionType.getType();
            }
        }
        
        return type;
        
    }

    /**
     * @return the value
     */
    public Integer getValue() {
        return this.value;
    }

    /**
     * @param value
     *            the value to set
     */
    public void setValue(Integer value) {
        this.value = value;
    }

}