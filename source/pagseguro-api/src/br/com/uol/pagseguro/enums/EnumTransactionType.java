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

public enum EnumTransactionType {

    PAYMENT("PAYMENT", 1),
    TRANSFER("TRANSFER", 2),
    FUND_ADDITION("FUND_ADDITION", 3),
    WITHDRAW("WITHDRAW", 4),
    CHARGE("CHARGE", 5),
    DONATION("DONATION", 6),
    BONUS("BONUS", 7),
    BONUS_REPASS("BONUS_REPASS", 8),
    OPERATIONAL("OPERATIONAL", 9),
    POLITICAL_DONATION("POLITICAL_DONATION", 10);

    /**
     * String type
     */
    private String type;

    /**
     * Integer value;
     */
    private Integer value;

    EnumTransactionType(String type, Integer value) {
        setType(type);
        setValue(value);
    }
    
    public static EnumTransactionType fromValue(Integer value) {
        
        for (EnumTransactionType enumTransactionType : values()) {
            if (enumTransactionType.value.equals(value)) {
                return enumTransactionType;
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
     * @return the value
     */
    public Integer getValue() {
        return value;
    }

    /**
     * @param value
     *            the value to set
     */
    public void setValue(Integer value) {
        this.value = value;
    }

}