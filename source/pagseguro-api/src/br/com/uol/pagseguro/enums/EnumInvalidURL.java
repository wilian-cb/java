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
 * EnumInvalidURL
 */
public enum EnumInvalidURL {

    LOCALHOST("localhost"),
    IP_V4("127.0.0.1"),
    IP_V6("::1");

    /**
     * String value url
     */
    private String value;

    /**
     * Construct EnumInvalidURL
     * 
     * @param value
     */
    EnumInvalidURL(String value) {
        this.setValue(value);
    }

    /**
     * Get EnumInvalidURL
     * 
     * @return array EnumInvalidURL
     */
    public EnumInvalidURL[] getEnumInvalidURL() {
        return EnumInvalidURL.values();
    }

    /**
     * Get Value
     * 
     * @return value
     */
    public String getValue() {
        return this.value;
    }

    /**
     * Set Value
     * 
     * @param value
     */
    public void setValue(String value) {
        this.value = value;
    }

}