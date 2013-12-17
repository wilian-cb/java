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

package br.com.uol.pagseguro.enums;

/**
 * Defines a list of known payment method codes.
 */
public enum PaymentCode {

    VISA_CREDIT_CARD("VISA_CREDIT_CARD", 101),

    MASTERCARD_CREDIT_CARD("MASTERCARD_CREDIT_CARD", 102),

    AMEX_CREDIT_CARD("AMEX_CREDIT_CARD", 103),

    DINERS_CREDIT_CARD("DINERS_CREDIT_CARD", 104),

    HIPERCARD_CREDIT_CARD("HIPERCARD_CREDIT_CARD", 105),

    AURA_CREDIT_CARD("AURA_CREDIT_CARD", 106),

    ELO_CREDIT_CARD("ELO_CREDIT_CARD", 107),

    PLENOCARD_CREDIT_CARD("PLENOCARD_CREDIT_CARD", 108),

    PERSONALCARD_CREDIT_CARD("PERSONALCARD_CREDIT_CARD", 109),

    JCB_CREDIT_CARD("JCB_CREDIT_CARD", 110),

    DISCOVER_CREDIT_CARD("DISCOVER_CREDIT_CARD", 111),

    BRASILCARD_CREDIT_CARD("BRASILCARD_CREDIT_CARD", 112),

    FORTBRASIL_CREDIT_CARD("FORTBRASIL_CREDIT_CARD", 113),

    CARDBAN_CREDIT_CARD("CARDBAN_CREDIT_CARD", 114),

    VALECARD_CREDIT_CARD("VALECARD_CREDIT_CARD", 115),

    CABAL_CREDIT_CARD("CABAL_CREDIT_CARD", 116),

    MAIS_CREDIT_CARD("MAIS_CREDIT_CARD", 117),

    AVISTA_CREDIT_CARD("AVISTA_CREDIT_CARD", 118),

    GRANDCARD_CREDIT_CARD("GRANDCARD_CREDIT_CARD", 119),

    BRADESCO_BOLETO("BRADESCO_BOLETO", 201),

    SANTANDER_BOLETO("SANTANDER_BOLETO", 202),

    BRADESCO_ONLINE_TRANSFER("BRADESCO_ONLINE_TRANSFER", 301),

    ITAU_ONLINE_TRANSFER("ITAU_ONLINE_TRANSFER", 302),

    UNIBANCO_ONLINE_TRANSFER("UNIBANCO_ONLINE_TRANSFER", 302),

    BANCO_BRASIL_ONLINE_TRANSFER("BANCO_BRASIL_ONLINE_TRANSFER", 304),

    REAL_ONLINE_TRANSFER("REAL_ONLINE_TRANSFER", 305),

    BANRISUL_ONLINE_TRANSFER("BANRISUL_ONLINE_TRANSFER", 306),

    HSBC_ONLINE_TRANSFER("HSBC_ONLINE_TRANSFER", 307),

    PS_BALANCE("PS_BALANCE", 401),

    OI_PAGGO("OI_PAGGO", 501),

    BANCO_BRASIL_DIRECT_DEPOSIT("BANCO_BRASIL_DIRECT_DEPOSIT", 701),

    HSBC_DIRECT_DEPOSIT("HSBC_DIRECT_DEPOSIT", 702);

    /**
     * The type method payment Exemple : BANRISUL_ONLINE_TRANSFER
     * 
     * @var string
     */
    private String type;

    /**
     * The value code method payment Exemple : 701
     * 
     * @var Integer
     */
    private Integer value;

    /**
     * Construct
     * 
     * @param type
     * @param value
     */
    PaymentCode(String type, Integer value) {
        this.setType(type);
        this.setValue(value);
    }

    public static PaymentCode fromValue(Integer value) {

        for (PaymentCode enumPaymentCode : values()) {
            if (enumPaymentCode.value.equals(value)) {
                return enumPaymentCode;
            }
        }

        return null;

    }

    /**
     * @return the type
     */
    public String getType() {
        return this.type;
    }

    /**
     * @param type
     *            the type to set
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * @return the value
     */
    public Integer getValue() {
        return this.value;
    }

    /**
     * @param value
     *            the value to set
     */
    public void setValue(Integer value) {
        this.value = value;
    }

}