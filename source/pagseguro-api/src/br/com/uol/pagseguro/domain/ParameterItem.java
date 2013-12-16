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

/**
 * 
 * Represent a parameter item*
 */
public class ParameterItem {

    /**
     * String key
     */
    private String key;

    /**
     * String value
     */
    private String value;

    /**
     * Integer group
     */
    private Integer group;

    /**
     * Construct Default
     */
    public ParameterItem() {
    }

    /**
     * Construct ParameterItem
     * 
     * @param key
     * @param value
     */
    public ParameterItem(String key, String value) {
        this.key = key;
        this.value = value;
    }

    /**
     * Construct ParameterItem
     * 
     * @param key
     * @param value
     * @param group
     */
    public ParameterItem(String key, String value, Integer group) {
        this.key = key;
        this.value = value;
        this.group = group;
    }

    /**
     * Get Key
     * 
     * @return key
     */
    public String getKey() {
        return this.key;
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