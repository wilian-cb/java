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

import java.util.ArrayList;
import java.util.List;

import br.com.uol.pagseguro.enums.MetaDataItemKey;
import br.com.uol.pagseguro.helper.PagSeguroUtil;

/**
 * Represents a metaDataItem in a transaction
 */
public class MetaDataItem {

    private MetaDataItemKey key;

    private String value;

    private Integer group;

    private List<MetaDataItem> item;

    /**
     * Initializes a newly created object of this type
     * 
     */
    public MetaDataItem() {
    }

    /**
     * Initializes a newly created object of this type with the specified arguments
     * 
     * @param key
     *            - the metaDataItemKey of the object
     * @param value
     *            - the metaDataItemValue of the object
     */
    public MetaDataItem(MetaDataItemKey key, String value) {
        this.setKey(key);
        this.setValue(value);
    }

    /**
     * Initializes a newly created object of this type with the specified arguments
     * 
     * @param key
     *            - the metaDataItemKey of the object
     * @param value
     *            - the metaDataItemValue of the object
     * @param group
     *            - the metaDataItemGroup of the object
     */
    public MetaDataItem(MetaDataItemKey key, String value, Integer group) {
        this.setKey(key);
        this.setValue(value);
        this.setGroup(group);
    }

    /**
     * @param item
     *            - add a new item on the end of this list
     */
    public void addItem(MetaDataItem item) {
        this.getItem().add(item);
    }

    /**
     * @param item
     *            - new item list for this MetaDataItem
     */
    public void setItem(List<MetaDataItem> item) {
        this.item = item;
    }

    /**
     * @return a list of MetaDataItems
     */
    public List<MetaDataItem> getItem() {
        if (this.item == null) {
            this.item = new ArrayList<MetaDataItem>();
        }

        return this.item;
    }

    /**
     * Normalize a given metaDataItemValue
     * 
     * @param value
     *            - the metaDataItemValue of the object
     */
    private String normalizeValue(String value) {

        if (this.getKey().equals(MetaDataItemKey.PASSENGER_CPF)) {
            value = PagSeguroUtil.getOnlyNumbers(value);
        }

        if (this.getKey().equals(MetaDataItemKey.TIME_IN_GAME_DAYS)) {
            value = PagSeguroUtil.getOnlyNumbers(value);
        }

        return value;
    }

    /**
     * @return this MetaDataItem key
     */
    public MetaDataItemKey getKey() {
        return this.key;
    }

    /**
     * @param key
     *            - new key for this MetaDataItem
     */
    public void setKey(MetaDataItemKey key) {
        this.key = key;
    }

    /**
     * @return this MetaDataItem value
     */
    public String getValue() {
        return this.value;
    }

    /**
     * @param value
     *            - new normalized value for this MetaDataItem
     */
    public void setValue(String value) {
        this.value = normalizeValue(value);
    }

    /**
     * @return this MetaDataItem group
     */
    public Integer getGroup() {
        return this.group;
    }

    /**
     * @param group
     *            - new group for this MetaDataItem
     */
    public void setGroup(Integer group) {
        this.group = group;
    }

}