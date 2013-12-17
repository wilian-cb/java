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
 * ShippingType
 */
public enum ShippingType {

    PAC("PAC", 1),

    SEDEX("SEDEX", 2),

    NOT_SPECIFIED("NOT_SPECIFIED", 3);

    /**
     * String type shipping
     */
    private String type;

    /**
     * Integer value
     */
    private Integer value;

    /**
     * Construct
     * 
     * @param type
     * @param value
     */
    ShippingType(String type, Integer value) {
        this.setType(type);
        this.setValue(value);
    }

    public static ShippingType fromValue(Integer value) {

        for (ShippingType shippingType : values()) {
            if (shippingType.value.equals(value)) {
                return shippingType;
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