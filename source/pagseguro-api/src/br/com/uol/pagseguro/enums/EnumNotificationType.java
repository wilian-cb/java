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
 * EnumNotificationType
 */
public enum EnumNotificationType {

    TRANSACTION("TRANSACTION", "transaction");

    /**
     * String type notification
     */
    private String type;

    /**
     * String value Notification
     */
    private String value;

    /**
     * Construct EnumNotificationType
     * 
     * @param type
     * @param value
     */
    EnumNotificationType(String type, String value) {
        this.type = type;
        this.value = value;
    }
    
    public static EnumNotificationType fromValue(String value) {
        
        for (EnumNotificationType enumNotificationType : values()) {
            if (enumNotificationType.type.equals(value)) {
                return enumNotificationType;
            }
        }
        
        return null;
        
    }

    /**
     * Get Type
     * 
     * @return type notification
     */
    public String getType() {
        return this.type;
    }

    /**
     * Get Value
     * 
     * @return value notification
     */
    public String getValue() {
        return this.value;
    }
}