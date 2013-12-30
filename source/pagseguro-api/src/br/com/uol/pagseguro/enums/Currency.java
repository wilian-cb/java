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
 * Currency
 */
public enum Currency {

    // ISO 4217 format
    BRL("BRL", 986);

    /**
     * Currency code
     */
    private String code;

    /**
     * Currency value
     */
    private Integer value;

    /**
     * Construct
     * 
     * @param code
     * @param value
     */
    Currency(String code, Integer value) {
        this.setCode(code);
        this.setValue(value);
    }

    /**
     * Get currency code
     * 
     * @return currency code
     */
    public String getCode() {
        return this.code;
    }

    /**
     * @param code
     *            currency code to set
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * Get currency value
     * 
     * @return currency value
     */
    public Integer getValue() {
        return this.value;
    }

    /**
     * @param value
     *            currency value to set
     */
    public void setValue(Integer value) {
        this.value = value;
    }
}