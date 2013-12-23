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
package br.com.uol.pagseguro.example;

import java.math.BigDecimal;

import br.com.uol.pagseguro.domain.PaymentRequest;
import br.com.uol.pagseguro.enums.Currency;
import br.com.uol.pagseguro.enums.ShippingType;
import br.com.uol.pagseguro.exception.PagSeguroServiceException;
import br.com.uol.pagseguro.properties.PagSeguroConfig;

public class CreatePayment {

    /**
     * Class with a main method to illustrate the usage of the domain class PaymentRequest
     */
    public static void main(String[] args) {

        // Instantiate a new payment request
        PaymentRequest paymentRequest = new PaymentRequest();

        // Sets the currency
        paymentRequest.setCurrency(Currency.REAL.getIso());

        // Add an item for this payment request
        paymentRequest.addItem("0001", "Notebook Prata", Integer.valueOf(1), new BigDecimal("2430.00"), new Long(1000),
                null);

        // Add another item for this payment request
        paymentRequest.addItem("0002", "Notebook Rosa", Integer.valueOf(2), new BigDecimal("2560.00"), new Long(750),
                null);

        // Sets a reference code for this payment request, it's useful to
        // identify this payment in future notifications.
        paymentRequest.setReference("REF1234");

        // Sets shipping information for this payment request
        paymentRequest.setShippingType(ShippingType.SEDEX);

        paymentRequest.setShippingAddress("BRA", "SP", "Sao Paulo", "Jardim Paulistano", "01452002",
                "Av. Brig. Faria Lima", "1384", "5o andar");

        // Sets value of shipping cost for this payment request
        paymentRequest.setShippingCost(new BigDecimal("2.00"));

        // Sets your customer information.
        paymentRequest.setSender("Joao Comprador", "comprador@uol.com.br", "11", "56273440", "CPF", "000.000.001-91");

        // Sets notificationURL information
        paymentRequest.setNotificationURL("http://www.meusite.com.br/notification");

        // Sets redirectURL
        paymentRequest.setRedirectURL("http://www.meusite.com.br/redir");

        // Another way to set checkout parameters
        paymentRequest.addParameter("senderBornDate", "07/05/1981");

        paymentRequest.addIndexedParameter("itemId", "0003", 3);
        paymentRequest.addIndexedParameter("itemDescription", "Notebook prata", 3);
        paymentRequest.addIndexedParameter("itemQuantity", "1", 3);
        paymentRequest.addIndexedParameter("itemAmount", "200.00", 3);

        // Add checkout metadata information
        paymentRequest.addMetaData("PASSENGER_CPF", "15600944276", 1);
        paymentRequest.addMetaData("GAME_NAME", "DOTA");
        paymentRequest.addMetaData("PASSENGER_PASSPORT", "23456", 1);

        try {

            Boolean onlyCheckoutCode = false;

            // Set your account credentials on src/pagseguro-config.properties
            String paymentURL = paymentRequest.register(PagSeguroConfig.getAccountCredentials(), onlyCheckoutCode);

            System.out.println(paymentURL);

        } catch (PagSeguroServiceException e) {
            System.out.println(e.getMessage());
        }
    }

    private CreatePayment() {
    }
}