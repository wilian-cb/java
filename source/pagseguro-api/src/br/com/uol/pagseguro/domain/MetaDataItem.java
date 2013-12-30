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

import br.com.uol.pagseguro.enums.MetaDataItems;
import br.com.uol.pagseguro.helper.PagSeguroUtil;

/**
 * Represent a metadata item
 */
public class MetaDataItem {

    private static final int MAX_VALUE_STRING = 100;

    /**
     * Allow add extra information to order String key
     */
    private MetaDataItems key;

    /**
     * Value of corresponding key String value
     */
    private String value;

    /**
     * Used for grouping values of metadata items Integer group
     */
    private Integer group;

    public MetaDataItem() {
    }

    /**
     * Construct MetaDataItem
     * 
     * @param key
     * @param value
     */
    public MetaDataItem(MetaDataItems key, String value) {
        this.key = key;
        this.value = value;
    }

    /**
     * Construct MetaDataItem
     * 
     * @param key
     * @param value
     * @param group
     */
    public MetaDataItem(MetaDataItems key, String value, Integer group) {
        this.key = key;
        this.value = value;
        this.group = group;
    }

    /**
     * Normalize metadata item value
     * 
     * @param string
     *            parameterValue
     * @return string
     */
    private String normalizeParameter(String parameterValue) {

        parameterValue = PagSeguroUtil.formatString(parameterValue, MAX_VALUE_STRING, "");

        if (this.getKey().equals(MetaDataItems.PASSENGER_CPF.getKey())) {
            parameterValue = PagSeguroUtil.getOnlyNumbers(parameterValue);
        }

        if (this.getKey().equals(MetaDataItems.TIME_IN_GAME_DAYS.getKey())) {
            parameterValue = PagSeguroUtil.getOnlyNumbers(parameterValue);
        }

        return parameterValue;
    }

    /**
     * Get Key
     * 
     * @return key
     */
    public MetaDataItems getKey() {
        return this.key;
    }

    /**
     * Set Key
     * 
     * @param key
     */
    public void setKey(MetaDataItems key) {
        this.key = key;
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
        this.value = normalizeParameter(value);
    }

    /**
     * Get Group
     * 
     * @return group
     */
    public Integer getGroup() {
        return this.group;
    }

    /**
     * Set Group
     * 
     * @param group
     */
    public void setGroup(Integer group) {
        this.group = group;
    }

}