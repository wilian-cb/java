/*
 ************************************************************************
 Copyright [2013] [PagSeguro Internet Ltda.]

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

import br.com.uol.pagseguro.enums.EnumCurrency;

/**
 * Class tha represents available currencies on PagSeguro
 */
public class Currencies {
    
    private Currencies() {
    }

    /**
     * List Currency
     */
    private static final EnumCurrency[] LIST_CURRENCY = EnumCurrency.values();

    /**
     * Check if currency is available by informed iso code for PagSeguro
     * transactions
     * 
     * @param string
     *            currencyIso
     * @return boolean
     */
    public static boolean checkCurrencyAvailabilityByIsoCode(String currencyIso) {

        boolean available = false;

        for (EnumCurrency currency : LIST_CURRENCY) {
            if (currencyIso.equalsIgnoreCase(currency.getIso())) {
                available = true;
            }
        }

        return available;
    }

    /**
     * Check if currency is available by informed currency name for PagSeguro
     * transactions
     * 
     * @param string
     *            currencyName
     * @return boolean
     */
    public static boolean checkCurrencyAvailabilityByName(String currencyName) {
        boolean available = false;

        for (EnumCurrency currency : LIST_CURRENCY) {
            if (currencyName.equalsIgnoreCase(currency.getName())) {
                available = true;
            }
        }

        return available;
    }

    /**
     * Return currencies list
     * 
     * @return array
     */
    public static EnumCurrency[] getCurrenciesList() {
        return LIST_CURRENCY;
    }

    /**
     * Return iso code by currency name Default return BRL (Brazilian Real) iso
     * code
     * 
     * @param string
     *            currencyName
     * @return string
     */
    public static String getIsoCodeByName(String currencyName) {
        String currencyIso = EnumCurrency.REAL.getIso();
        for (EnumCurrency currency : LIST_CURRENCY) {
            if (currencyName.equalsIgnoreCase(currency.getName())) {
                currencyIso = currency.getIso();
            }
        }

        return currencyIso;
    }

    /**
     * Return currency name by iso code
     * 
     * @param string
     *            currencyIso
     * @return string
     */
    public static String getCurrencyNameByIsoCode(String currencyIso) {
        String currencyName = "";
        for (EnumCurrency currency : LIST_CURRENCY) {
            if (currencyIso.equalsIgnoreCase(currency.getIso())) {
                currencyName = currency.getName();
            }
        }

        return currencyName;
    }
}