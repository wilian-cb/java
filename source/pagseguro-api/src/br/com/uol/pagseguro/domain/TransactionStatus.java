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

import br.com.uol.pagseguro.enums.EnumTransactionStatus;

/**
 * 
 * TransactionStatus
 */
public class TransactionStatus {

    /**
     * Integer value status
     */
    private Integer value;

    /**
     * Construct Default
     */
    public TransactionStatus() {
    }

    /**
     * Construct
     * 
     * @param value
     *            status
     */
    public TransactionStatus(Integer value) {
        this.value = value;
    }

    /**
     * 
     * @param type
     */
    public void setByType(String type) {

        Integer auxValue = 0;

        for (EnumTransactionStatus transactionStatus : getStatusList()) {
            if (type.equalsIgnoreCase(transactionStatus.getType())) {
                auxValue = transactionStatus.getValue();
            }
        }

        if (auxValue > 0) {
            this.value = auxValue;
        }
    }

    /**
     * 
     * @param value
     * @return String the transaction status corresponding to the informed status value
     */
    public String getTypeFromValue() {

        String type = "";

        for (EnumTransactionStatus transactionStatus : getStatusList()) {
            if (value.equals(transactionStatus.getValue())) {
                type = transactionStatus.getType();
            }
        }

        return type;
    }

    /**
     * Get status list
     * 
     * @return array
     */
    public EnumTransactionStatus[] getStatusList() {
        return EnumTransactionStatus.values();
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