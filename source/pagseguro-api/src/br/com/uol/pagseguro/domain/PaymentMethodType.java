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

import br.com.uol.pagseguro.enums.EnumPaymentMethodType;

/**
 * Defines a list of known payment method types.
 */
public class PaymentMethodType {

    /**
     * Payment method type value Exemple : 1
     * 
     * @var Integer
     */
    private Integer value;

    /**
     * Construct Default
     */
    public PaymentMethodType() {
    }

    /**
     * Construct
     * 
     * @param value
     */
    public PaymentMethodType(Integer value) {
        this.value = value;
    }

    /**
     * Set Value By Type
     * 
     * @param type
     */
    public void setByType(String type) {

        Integer auxValue = 0;

        for (EnumPaymentMethodType paymentMethodType : EnumPaymentMethodType.values()) {
            if (type.equalsIgnoreCase(paymentMethodType.getType())) {
                auxValue = paymentMethodType.getValue();
            }
        }

        if (auxValue > 0) {
            value = auxValue;
        }
    }

    /**
     * 
     * @return PagSeguroPaymentMethodType the corresponding to the informed value
     */
    public String getTypeFromValue() {

        String type = "";

        for (EnumPaymentMethodType paymentMethodType : EnumPaymentMethodType.values()) {
            if (value.equals(paymentMethodType.getValue())) {
                type = paymentMethodType.getType();
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