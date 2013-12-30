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
 * Represent available metadata item keys EnumMetaDataItemKeys
 */
public enum MetaDataItems {

    PASSENGER_CPF("PASSENGER_CPF", "CPF do passageiro"),

    PASSENGER_PASSPORT("PASSENGER_PASSPORT", "Passaporte do passageiro"),

    ORIGIN_CITY("ORIGIN_CITY", "Cidade de origem"),

    DESTINATION_CITY("DESTINATION_CITY", "Cidade de destino"),

    ORIGIN_AIRPORT_CODE("ORIGIN_AIRPORT_CODE", "Código do aeroporto de origem"),

    DESTINATION_AIRPORT_CODE("DESTINATION_AIRPORT_CODE", "Código do aeroporto de destino"),

    GAME_NAME("GAME_NAME", "Nome do jogo"),

    PLAYER_ID("PLAYER_ID", "Id do jogador"),

    TIME_IN_GAME_DAYS("TIME_IN_GAME_DAYS", "Tempo no jogo em dias"),

    MOBILE_NUMBER("MOBILE_NUMBER", "Celular de recarga"),

    PASSENGER_NAME("PASSENGER_NAME", "Nome do passageiro");

    /**
     * String key
     */
    private String key;

    /**
     * String description
     */
    private String description;

    /**
     * Construct EnumMetaDataItemKeys
     * 
     * @param key
     * @param description
     */
    MetaDataItems(String key, String description) {
        this.key = key;
        this.description = description;
    }

    public static MetaDataItems fromValue(String key) {

        for (MetaDataItems enumMetaDataItemKeys : values()) {
            if (enumMetaDataItemKeys.key.equals(key)) {
                return enumMetaDataItemKeys;
            }
        }

        return null;

    }

    /**
     * Get available item key list for metadata use in PagSeguro transactions
     * 
     * @return array EnumMetaDataItemKeys
     */
    public static MetaDataItems[] getAvailableItemKeysList() {
        return MetaDataItems.values();
    }

    /**
     * Check if item key is available for PagSeguro
     * 
     * @param key
     * @return true is available
     */
    public static boolean isItemKeyAvailable(String key) {

        boolean available = false;

        for (MetaDataItems itemKey : getAvailableItemKeysList()) {
            if (key.equalsIgnoreCase(itemKey.getKey())) {
                available = true;
            }
        }

        return available;

    }

    /**
     * Gets item description by key
     * 
     * @param key
     * @return string description
     */
    public static String getItemDescriptionByKey(String key) {

        String description = "";

        for (MetaDataItems itemKey : getAvailableItemKeysList()) {
            if (key.equalsIgnoreCase(itemKey.getKey())) {
                description = itemKey.getDescription();
            }
        }

        return description;

    }

    /**
     * Gets item key type by description
     * 
     * @param description
     * @return string key
     */
    public static String getItemKeyByDescription(String description) {

        String key = "";

        for (MetaDataItems itemDescription : getAvailableItemKeysList()) {
            if (description.equalsIgnoreCase(itemDescription.getDescription())) {
                key = itemDescription.getKey();
            }
        }

        return key;

    }

    /**
     * Get Key
     * 
     * @return key
     */
    public String getKey() {
        return key;
    }

    /**
     * Set Key
     * 
     * @param key
     */
    public void setKey(String key) {
        this.key = key;
    }

    /**
     * Get Description
     * 
     * @return description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Set Description
     * 
     * @param description
     */
    public void setDescription(String description) {
        this.description = description;
    }
}