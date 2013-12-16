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
 * EnumTransactionStatus
 */
public enum EnumTransactionStatus {

    INITIATED("INITIATED", 0),
    WAITING_PAYMENT("WAITING_PAYMENT", 1),
    IN_ANALYSIS("IN_ANALYSIS", 2),
    PAID("PAID", 3),
    AVAILABLE("AVAILABLE", 4),
    IN_DISPUTE("IN_DISPUTE", 5),
    REFUNDED("REFUNDED", 6),
    CANCELLED("CANCELLED", 7);

    /**
     * String type status
     */
    private String type;

    /**
     * Integer value status
     */
    private Integer value;

    /**
     * Construct
     * 
     * @param type
     * @param value
     */
    EnumTransactionStatus(String type, Integer value) {
        this.setType(type);
        this.setValue(value);
    }
    
    public static EnumTransactionStatus fromValue(Integer value) {
        
        for (EnumTransactionStatus enumTransactionStatus : values()) {
            if (enumTransactionStatus.value.equals(value)) {
                return enumTransactionStatus;
            }
        }
        
        return null;
        
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