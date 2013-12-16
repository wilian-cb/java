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

import br.com.uol.pagseguro.enums.EnumNotificationType;

/**
 * Defines a list of known notification types. This class is not an enum to
 * enable the introduction of new shipping types without breaking this version
 * of the library.
 */
public class NotificationType {

    /**
     * Array EnumNotificationType
     */
    private EnumNotificationType[] listNotification = EnumNotificationType.values();

    /**
     * String value notification
     */
    private String value;

    /**
     * Construct Default
     */
    public NotificationType() {
    }

    /**
     * Construct
     * 
     * @param value
     *            notification
     */
    public NotificationType(String value) {
        this.value = value;
    }

    /**
     * Set value notification by type of notification
     * 
     * @param type
     *            string
     */
    public void setByType(String type) {

        for (EnumNotificationType notificationType : listNotification) {
            if (type.equals(notificationType.getType())) {
                this.setValue(notificationType.getValue());
            }
        }
    }

    /**
     * Return type notification by value of notification
     * 
     * @param value
     * @return notification value
     */
    public String getTypeFromValue(String value) {

        String notificationValue = "";

        for (EnumNotificationType notificationType : listNotification) {
            if (value.equals(notificationType.getValue())) {
                notificationValue = notificationType.getType();
            }
        }

        return notificationValue;
    }

    /**
     * Set Value notification
     * 
     * @param value
     *            notification
     */
    public void setValue(String value) {
        this.value = value;
    }

    /**
     * Get value notification
     * 
     * @return value notification
     */
    public String getValue() {
        return this.value;
    }
}