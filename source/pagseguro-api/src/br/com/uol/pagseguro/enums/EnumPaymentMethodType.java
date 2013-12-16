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
 * EnumPaymentMethodType
 */
public enum EnumPaymentMethodType {

    CREDIT_CARD("CREDIT_CARD", 1),
    BOLETO("BOLETO", 2),
    ONLINE_TRANSFER("ONLINE_TRANSFER", 3),
    BALANCE("BALANCE", 4),
    OI_PAGGO("OI_PAGGO",5),
    DIRECT_DEPOSIT("DIRECT_DEPOSIT", 7);

    /**
     * String type method payment
     */
    private String type;

    /**
     * Integer valye type payment
     */
    private Integer value;

    /**
     * Construct
     * 
     * @param type
     * @param value
     */
    EnumPaymentMethodType(String type, Integer value) {
        setType(type);
        setValue(value);
    }
    
    public static EnumPaymentMethodType fromValue(Integer value) {
        
        for (EnumPaymentMethodType enumPaymentMethodType : values()) {
            if (enumPaymentMethodType.value.equals(value)) {
                return enumPaymentMethodType;
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