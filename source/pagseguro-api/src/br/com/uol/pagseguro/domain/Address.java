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

import br.com.uol.pagseguro.enums.States;
import br.com.uol.pagseguro.helper.PagSeguroUtil;

/**
 * Represents an address location, typically for shipping or charging purposes.
 * 
 * @see Shipping
 */
public class Address {

    /**
     * Postal/Zip code
     */
    private String postalCode;

    /**
     * Street name
     */
    private String street;

    /**
     * Number
     */
    private String number;

    /**
     * Apartment, suite number or any other qualifier after the street/number
     * pair. Example: Apt 274, building A.
     */
    private String complement;

    /**
     * District, country or neighborhood, if applicable
     */
    private String district;

    /**
     * City
     */
    private String city;

    /**
     * State or province
     */
    private String state;

    /**
     * Country
     */
    private String country;

    /**
     * Initializes a new instance of the Address class
     */
    public Address() {
    }

    /**
     * Initializes a new instance of the Address class
     * 
     * @param country
     * @param state
     * @param city
     * @param district
     * @param postalCode
     * @param street
     * @param number
     * @param complement
     */
    public Address(String country, String state, String city, String district,
            String postalCode, String street, String number, String complement) {
        this.street = street;
        this.number = number;
        this.complement = complement;
        this.district = district;
        this.city = city;
        this.state = state;
        this.country = country;
        this.postalCode = postalCode;
    }

    /**
     * @return the street
     */
    public String getStreet() {
        return this.street;
    }

    /**
     * @return the number
     */
    public String getNumber() {
        return this.number;
    }

    /**
     * @return the complement
     */
    public String getComplement() {
        return this.complement;
    }

    /**
     * @return the district
     */
    public String getDistrict() {
        return this.district;
    }

    /**
     * @return the city
     */
    public String getCity() {
        return this.city;
    }

    /**
     * @return the state
     */
    public String getState() {
        return this.state;
    }

    /**
     * @return the postal code
     */
    public String getPostalCode() {
        return this.postalCode;
    }

    /**
     * @return the country
     */
    public String getCountry() {
        return this.country;
    }

    /**
     * Sets the street
     * 
     * @param street
     */
    public void setStreet(String street) {
        this.street = street;
    }

    /**
     * Sets the number
     * 
     * @param number
     */
    public void setNumber(String number) {
        this.number = number;
    }

    /**
     * Sets the complement
     * 
     * @param complement
     */
    public void setComplement(String complement) {
        this.complement = complement;
    }

    /**
     * Sets the district
     * 
     * @param district
     */
    public void setDistrict(String district) {
        this.district = district;
    }

    /**
     * sets the city
     * 
     * @param city
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * Sets the state
     * 
     * @param state
     */
    public void setState(String state) {
        this.state = treatState(state);
    }

    /**
     * Sets the postalCode
     * 
     * @param postalCode
     */
    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    /**
     * Sets the country
     * 
     * @param country
     */
    public void setCountry(String country) {
        this.country = country;
    }

    /**
     * Treat the state to pass in format waited of the PagSeguro
     * 
     * @param type
     *            $defaultState
     * @return string
     */
    public String treatState(String defaultState) {

        if (defaultState.length() == 2) {
            return treatAcronym(defaultState);
        }

        defaultState = PagSeguroUtil.removeAccents(defaultState);
        defaultState = defaultState.replaceAll(" ", "");
        String stateName = "";

        for (States state : States.values()) {
            if (defaultState.equalsIgnoreCase(state.getName())) {
                stateName = state.getAcronym();
            }
        }

        return stateName;
    }

    /**
     * Treat the acronym to pass in format waited of the PagSeguro
     * 
     * @param acronym
     * @return string
     */
    public String treatAcronym(String acronym) {

        String defaultAcronym = "";

        for (States state : States.values()) {
            if (acronym.equalsIgnoreCase(state.getAcronym())) {
                defaultAcronym = state.getAcronym();
            }
        }
        return defaultAcronym;
    }
}