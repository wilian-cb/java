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

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import br.com.uol.pagseguro.enums.EnumInvalidURL;
import br.com.uol.pagseguro.exception.PagSeguroServiceException;
import br.com.uol.pagseguro.service.PaymentService;

/**
 * Represents a payment request
 */
public class PaymentRequest {

    /**
     * Party that will be sending the money
     */
    private Sender sender;

    /**
     * Payment currency.
     * 
     * @see Currencies
     */
    private String currency;

    /**
     * Products/items in this payment request
     */
    private List<Item> items;

    /**
     * Uri to where the PagSeguro payment page should redirect the user after
     * the payment information is processed. Typically this is a confirmation
     * page on your web site.
     */
    private String redirectURL;

    /**
     * Extra amount to be added to the transaction total
     * 
     * This value can be used to add an extra charge to the transaction or
     * provide a discount in the case ExtraAmount is a negative value.
     */
    private BigDecimal extraAmount;

    /**
     * Reference code
     * 
     * Optional. You can use the reference code to store an identifier so you
     * can associate the PagSeguro transaction to a transaction in your system.
     */
    private String reference;

    /**
     * Shipping information associated with this payment request
     */
    private Shipping shipping;

    /**
     * How long this payment request will remain valid, in seconds.
     * 
     * Optional. After this payment request is submitted, the payment code
     * returned will remain valid for the period specified here.
     */
    private BigInteger maxAge;

    /**
     * How many times the payment redirect uri returned by the payment web
     * service can be accessed.
     * 
     * Optional. After this payment request is submitted, the payment redirect
     * uri returned by the payment web service will remain valid for the number
     * of uses specified here.
     */
    private BigInteger maxUses;

    /**
     * Determines for which url PagSeguro will send the order related
     * notifications codes.
     * 
     * Optional. Any change happens in the transaction status, a new
     * notification request will be send to this url. You can use that for
     * update the related order.
     */
    private String notificationURL;

    /**
     * Extra parameters that user can add to a PagSeguro checkout request
     * 
     * Optional.
     * 
     * @var MetaData
     */
    private MetaData metaData;

    /**
     * Extra parameters that user can add to a PagSeguro checkout request
     * 
     * Optional
     * 
     * @var PagSeguroParameter
     */
    private Parameter parameter;

    /**
     * Initializes a new instance of the PaymentRequest class
     */
    public PaymentRequest() {
    }

    /**
     * @return the sender
     * 
     *         Party that will be sending the Uri to where the PagSeguro payment
     *         page should redirect the user after the payment information is
     *         processed. money
     */
    public Sender getSender() {
        return this.sender;
    }

    /**
     * Sets the Sender, party that will be sending the money
     * 
     * @param sender
     * @return
     */
    public PaymentRequest setSender(Sender sender) {
        this.sender = sender;
        return this;
    }

    /**
     * Sets the Sender, party that will be sending the money
     * 
     * @param name
     * @param email
     * @return
     */
    public PaymentRequest setSender(String name, String email) {
        
        if (this.sender == null) {
            this.sender = new Sender();
        }
        
        this.sender.setName(name);
        this.sender.setEmail(email);
        
        return this;
        
    }

    /**
     * Sets the Sender, party that will be sending the money
     * 
     * @param name
     * @param email
     * @param areaCode
     * @param number
     * @return
     */
    public PaymentRequest setSender(String name, String email, String areaCode, String number) {
        
        if (this.sender == null) {
            this.sender = new Sender();
        }
        
        this.sender.setName(name);
        this.sender.setEmail(email);
        this.sender.setPhone(new Phone(areaCode, number));
        
        return this;
    }

    /**
     * Sets the Sender, party that will be sending the money
     * 
     * @param name
     * @param email
     * @param areaCode
     * @param number
     * @param documentType
     * @param documentValue
     * @return
     */
    public PaymentRequest setSender(String name, String email, String areaCode, String number, String documentType, String documentValue) {
        
        if (this.sender == null) {
            this.sender = new Sender();
        }
        
        this.sender.setName(name);
        this.sender.setEmail(email);
        this.sender.setPhone(new Phone(areaCode, number));
        this.sender.addDocument(documentType, documentValue);
        
        return this;
        
    }

    /**
     * Sets the Sender phone number, phone of the party that will be sending the
     * money
     * 
     * @param areaCode
     * @param number
     * @return
     */
    public PaymentRequest setSenderPhone(String areaCode, String number) {
        
        if (this.sender == null) {
            this.sender = new Sender();
        }
        
        this.sender.setPhone(new Phone(areaCode, number));
        
        return this;
        
    }

    /**
     * @return the currency Example: BRL
     * @see Currencies
     */
    public String getCurrency() {
        return this.currency;
    }

    /**
     * Sets the currency
     * 
     * @see Currencies
     * 
     * @param currency
     * @return
     */
    public PaymentRequest setCurrency(String currency) {
        this.currency = currency;
        return this;
    }

    /**
     * @return the items/products list in this payment request
     * @see Item
     */
    public List<Item> getItems() {
        
        if (this.items == null) {
            this.items = new ArrayList<Item>();
        }
        
        return this.items;
        
    }

    /**
     * Sets the items/products list in this payment request
     * 
     * @see Item
     * 
     * @param items
     * @return
     */
    public PaymentRequest setItems(List<Item> items) {
        this.items = items;
        return this;
    }

    /**
     * Adds a new product/item in this payment request
     * 
     * @see Item
     * 
     * @param id
     * @param description
     * @param quantity
     * @param amount
     * @param weight
     * @param shippingCost
     */
    public void addItem(String id, String description, Integer quantity, BigDecimal amount, Long weight, BigDecimal shippingCost) {
        this.getItems().add(new Item(id, description, quantity, amount, weight, shippingCost));
    }

    /**
     * Adds a new product/item in this payment request
     * 
     * @see Item
     * 
     * @param item
     */
    public void addItem(Item item) {
        this.getItems().add(item);
    }

    /**
     * Uri to where the PagSeguro payment page should redirect the user after
     * the payment information is processed. Typically this is a confirmation
     * page on your web site.
     * 
     * @return the redirectURL
     */
    public String getRedirectURL() {
        return this.redirectURL;
    }

    /**
     * Sets the redirect URL
     * 
     * Uri to where the PagSeguro payment page should redirect the user after
     * the payment information is processed. Typically this is a confirmation
     * page on your web site.
     * 
     * @param redirectURL
     * @return
     */
    public PaymentRequest setRedirectURL(String redirectURL) {
        this.redirectURL = this.verifyURLTest(redirectURL);
        return this;
    }

    /**
     * This value can be used to add an extra charge to the transaction or
     * provide a discount in the case ExtraAmount is a negative value.
     * 
     * @return the extra amount
     */
    public BigDecimal getExtraAmount() {
        return this.extraAmount;
    }

    /**
     * Sets the extra amount This value can be used to add an extra charge to
     * the transaction or provide a discount in the case <b>extraAmount</b> is a
     * negative value.
     * 
     * @param extraAmount
     * @return
     */
    public PaymentRequest setExtraAmount(BigDecimal extraAmount) {
        this.extraAmount = extraAmount;
        return this;
    }

    /**
     * @return the reference of this payment request
     */
    public String getReference() {
        return this.reference;
    }

    /**
     * Sets the reference of this payment request
     * 
     * @param reference
     * @return
     */
    public PaymentRequest setReference(String reference) {
        this.reference = reference;
        return this;
    }

    /**
     * @return the shipping information for this payment request
     * @see Shipping
     */
    public Shipping getShipping() {
        return this.shipping;
    }

    /**
     * Sets the shipping information for this payment request
     * 
     * @see Shipping
     * 
     * @param shipping
     */
    public PaymentRequest setShipping(Shipping shipping) {
        this.shipping = shipping;
        return this;
    }

    /**
     * Sets the shipping type for this payment request
     * 
     * @see ShippingType
     * 
     * @param type
     * @return
     */
    public PaymentRequest setShippingType(ShippingType type) {
        
        if (this.shipping == null) {
            this.shipping = new Shipping();
        }
        
        this.shipping.setType(type);
        
        return this;
        
    }

    /**
     * Sets the value of the shipping. <br />
     * Use it when you calculate the value of the shipping.
     * 
     * @param cost
     * @return
     */
    public PaymentRequest setShippingCost(BigDecimal cost) {
        
        if (this.shipping == null) {
            this.shipping = new Shipping();
        }
        
        this.shipping.setCost(cost);
        
        return this;
        
    }

    /**
     * Sets the shipping information for this payment
     * 
     * @param type
     * @param country
     * @param state
     * @param city
     * @param district
     * @param postalCode
     * @param street
     * @param number
     * @param complement
     * @return
     */
    public PaymentRequest setShipping(ShippingType type, String country,
            String state, String city, String district, String postalCode,
            String street, String number, String complement) {
        
        if (this.shipping == null) {
            this.shipping = new Shipping();
        }
        
        this.shipping.setType(type);
        this.shipping.setAddress(new Address(country, state, city, district, postalCode, street, number, complement));
        
        return this;
        
    }

    /**
     * /** Sets the shipping information for this payment
     * 
     * @param type
     * @param country
     * @param state
     * @param city
     * @param district
     * @param postalCode
     * @param street
     * @param number
     * @param complement
     * @param cost
     * @return
     */
    public PaymentRequest setShipping(ShippingType type, String country,
            String state, String city, String district, String postalCode,
            String street, String number, String complement, BigDecimal cost) {

        this.setShipping(type, country, state, city, district, postalCode, street, number, complement);
        this.shipping.setCost(cost);
        
        return this;

    }

    /**
     * Sets the shipping address for this payment request
     * 
     * @param country
     * @param state
     * @param city
     * @param district
     * @param postalCode
     * @param street
     * @param number
     * @param complement
     * @return
     */
    public PaymentRequest setShippingAddress(String country, String state,
            String city, String district, String postalCode, String street,
            String number, String complement) {
        
        if (this.shipping == null) {
            this.shipping = new Shipping();
        }
        
        this.shipping.setAddress(new Address(country, state, city, district, postalCode, street, number, complement));
        
        return this;
        
    }

    /**
     * Sets the shipping address for this payment request
     * 
     * @param address
     * @return
     */
    public PaymentRequest setShippingAddress(Address address) {
        
        if (this.shipping == null) {
            this.shipping = new Shipping();
        }
        
        this.shipping.setAddress(address);
        
        return this;
        
    }

    /**
     * @return the max age of this payment request
     * 
     *         After this payment request is submitted, the payment code
     *         returned will remain valid for the period specified.
     */
    public BigInteger getMaxAge() {
        return this.maxAge;
    }

    /**
     * Sets the max age of this payment request After this payment request is
     * submitted, the payment code returned will remain valid for the period
     * specified here.
     * 
     * @param maxAge
     * @return
     */
    public PaymentRequest setMaxAge(BigInteger maxAge) {
        this.maxAge = maxAge;
        return this;
    }

    /**
     * After this payment request is submitted, the payment redirect uri
     * returned by the payment web service will remain valid for the number of
     * uses specified here.
     * 
     * @return the max uses configured for this payment request
     */
    public BigInteger getMaxUses() {
        return this.maxUses;
    }

    /**
     * Sets the max uses of this payment request
     * 
     * After this payment request is submitted, the payment redirect uri
     * returned by the payment web service will remain valid for the number of
     * uses specified here.
     * 
     * @param maxUses
     * @return
     */
    public PaymentRequest setMaxUses(BigInteger maxUses) {
        this.maxUses = maxUses;
        return this;
    }

    /**
     * Get the notification status url
     * 
     * @return String
     */
    public String getNotificationURL() {
        return this.notificationURL;
    }

    /**
     * Sets the url that PagSeguro will send the new notifications statuses
     * 
     * @param notificationURL
     */
    public void setNotificationURL(String notificationURL) {
        this.notificationURL = verifyURLTest(notificationURL);
    }

    /**
     * Add document for sender documents list
     * 
     * @param document
     */
    public void addSenderDocument(SenderDocument document) {
        this.getSender().addDocument(document);
    }

    /**
     * Add document for sender documents list
     * 
     * @param type
     * @param value
     */
    public void addSenderDocument(String type, String value) {
        this.getSender().addDocument(type, value);
    }

    /**
     * Get MetaData
     * 
     * @return MetaData
     */
    public MetaData getMetaData() {
        
        if (this.metaData == null) {
            this.metaData = new MetaData();
        }
        
        return this.metaData;
        
    }

    /**
     * Sets metadata for PagSeguro checkout requests
     * 
     * @param MetaData
     *            metaData
     */
    public void setMetaData(MetaData metaData) {
        this.metaData = metaData;
    }

    /**
     * add a parameter for PagSeguro metadata checkout request
     * 
     * @param key
     * @param value
     * @param group
     */
    public void addMetaData(String key, String value, Integer group) {
        this.getMetaData().addItem(new MetaDataItem(key, value, group));
    }

    /**
     * add a parameter for PagSeguro metadata checkout request
     * 
     * @param key
     * @param value
     */
    public void addMetaData(String key, String value) {
        this.getMetaData().addItem(new MetaDataItem(key, value));
    }

    /**
     * Gets parameter for PagSeguro checkout requests
     * 
     * @return Parameter
     */
    public Parameter getParameter() {
        
        if (this.parameter == null) {
            this.parameter = new Parameter();
        }
        
        return this.parameter;
        
    }

    /**
     * Sets parameter for PagSeguro checkout requests
     * 
     * @param parameter
     */
    public void setParameter(Parameter parameter) {
        this.parameter = parameter;
    }

    /**
     * add a parameter for PagSeguro checkout request
     * 
     * @param key
     * @param value
     */
    public void addParameter(String key, String value) {
        this.getParameter().addItem(new ParameterItem(key, value));
    }

    /**
     * add a parameter for PagSeguro checkout request
     * 
     * @param key
     * @param value
     * @param group
     */
    public void addIndexedParameter(String key, String value, Integer group) {
        this.getParameter().addItem(new ParameterItem(key, value, group));
    }

    /**
     * Calls the PagSeguro web service and register this request for payment
     * 
     * @param credentials
     * @return The URL to where the user needs to be redirected to in order to
     *         complete the payment process
     * @throws PagSeguroServiceException
     */
    public String register(Credentials credentials) throws PagSeguroServiceException {
        return this.register(credentials, false);
    }

    /**
     * Calls the PagSeguro web service and register this request for payment
     * 
     * @param credentials
     * @param isCheckoutLightbox
     * @return The URL to where the user needs to be redirected to in order to
     *         complete the payment process
     * @throws PagSeguroServiceException
     */
    public String register(Credentials credentials, Boolean isCheckoutLightbox) throws PagSeguroServiceException {
        return PaymentService.createCheckoutRequest(credentials, this, isCheckoutLightbox);
    }

    /**
     * @return string
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("PaymentRequest(Reference=");
        sb.append(reference);
        sb.append(",SenderEmail=");
        sb.append(sender != null ? sender.getEmail() : null);
        sb.append(")");
        return sb.toString();
    }

    /**
     * Verify if the adress of NotificationURL or RedirectURL is for tests and
     * return empty
     * 
     * @param type
     *            url
     * @return type
     */
    public String verifyURLTest(String url) {

        String urlReturn = url;

        for (EnumInvalidURL invalid : EnumInvalidURL.values()) {
            if (url.toLowerCase().contains(invalid.getValue().toLowerCase())) {
                urlReturn = "";
            }
        }
        
        return urlReturn;
        
    }

}