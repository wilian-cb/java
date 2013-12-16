/*
 * ***********************************************************************
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
 * ***********************************************************************
 */

package br.com.uol.pagseguro.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * Represent a metadata
 */
public class MetaData {

    /**
     * Products/items
     */
    private List<MetaDataItem> items;

    /**
     * Construct Default
     */
    public MetaData() {

    }

    /**
     * Construct
     * 
     * @param items
     */
    public MetaData(List<MetaDataItem> items) {
        if (!items.isEmpty()) {
            this.items = items;
        }
    }

    public void addItem(MetaDataItem metaDataItem) {
        this.getItems().add(metaDataItem);
    }

    /**
     * Set Items
     * 
     * @param list
     *            items
     */
    public void setItems(List<MetaDataItem> items) {
        this.items = items;
    }

    /**
     * Get Items
     * 
     * @return list items
     */
    public List<MetaDataItem> getItems() {
        if (this.items == null) {
            this.items = new ArrayList<MetaDataItem>();
        }

        return this.items;
    }
}
