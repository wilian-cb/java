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

import br.com.uol.pagseguro.enums.EnumShippingType;

/**
 * Defines a list of known shipping types. this class is not an enum to enable
 * the introduction of new shipping types without breaking this version of the
 * library.
 */
public class ShippingType {

    /**
     * Integer value
     */
    private Integer value;

    /**
     * Array EnumShippingType
     */
    private static EnumShippingType[] listType = EnumShippingType.values();

    /**
     * Construct Default
     */
    public ShippingType() {
    }

    /**
     * Construct
     * 
     * @param value
     */
    public ShippingType(Integer value) {
        this.value = value;
    }

    /**
     * setByType
     * 
     * @param type
     */

    public void setByType(String type) {

        Integer auxValue = 0;

        for (EnumShippingType shippingType : getListType()) {
            if (type.equalsIgnoreCase(shippingType.getType())) {
                auxValue = shippingType.getValue();
            }
        }

        if (auxValue > 0) {
            this.value = auxValue;
        }
    }

    /**
     * 
     * @param value
     * @return PagSeguroShippingType the PagSeguroShippingType corresponding to
     *         the informed value
     */
    public static String getTypeFromValue(Integer value) {

        String type = "";

        for (EnumShippingType shippingType : getListType()) {
            if (value.equals(shippingType.getValue())) {
                type = shippingType.getType();
            }
        }
        return type;
    }

    /**
     * 
     * @param type
     * @return integer the code corresponding to the informed shipping type
     */
    public static Integer getCodeByType(String type) {

        Integer value = null;

        for (EnumShippingType shippingType : EnumShippingType.values()) {
            if (type.equalsIgnoreCase(shippingType.getType())) {
                value = shippingType.getValue();
            }
        }
        return value;
    }

    /**
     * 
     * @param type
     * @return PagSeguroShippingType a PagSeguroShippingType object
     *         corresponding to the informed type
     */
    public static ShippingType createByType(String type) {
        ShippingType shippingType = new ShippingType();
        shippingType.setByType(type);
        return shippingType;
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

    /**
     * @return the listType
     */
    public static EnumShippingType[] getListType() {
        return listType;
    }

    /**
     * @param listType
     *            the listType to set
     */
    public void setListType(EnumShippingType[] listType) {
        ShippingType.listType = listType.clone(); 
    }

}