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
 * EnumState
 * 
 */
public enum EnumStates {

    ACRE("acre", "AC"), 
    ALAGOAS("alagoas", "AL"), 
    AMAPA("amapa", "AP"), 
    AMAZONAS("amazonas", "AM"), 
    BAHIA("bahia", "BA"), 
    CEARA("ceara", "CE"), 
    ESPIRITO_SANTO("espiritosanto", "ES"), 
    GOIAS("goias", "GO"), 
    MARANHAO("maranhao", "MA"), 
    MATO_GROSSO("matogrosso", "MT"), 
    MATO_GROSSO_DO_SUL("matogrossodosul", "MS"), 
    MATO_GROSSO_SUL("matogrossosul", "MS"), 
    MINAS_GERAIS("minasgerais", "MG"), 
    PARA("para", "PA"), 
    PARAIBA("paraiba", "PB"), 
    PARANA("parana", "PR"), 
    PERNAMBUCO("pernambuco", "PE"), 
    PIAUI("piaui", "PI"), 
    RIO_DE_JANEIRO("riodejaneiro", "RJ"), 
    RIO_JANEIRO("riojaneiro", "RJ"), 
    RIO_GRANDE_DO_NORTE("riograndedonorte", "RN"), 
    RIO_GRANDE_NORTE("riograndenorte", "RN"), 
    RIO_GRANDE_DO_SUL("riograndedosul", "RS"), 
    RIO_GRANDE_SUL("riograndesul", "RS"), 
    RONDONIA("rondonia", "RO"), 
    RORAIMA("roraima", "RR"), 
    SANTA_CATARINA("santacatarina", "SC"), 
    SAO_PAULO("saopaulo", "SP"), 
    SERGIPE("sergipe", "SE"), 
    TOCANTIS("tocantins", "TO"), 
    DISTRITO_FEDERAL("distritofederal", "DF");
    
    /**
     * State name
     */
    private String name;

    /**
     * State acronym
     */
    private String acronym;

    /**
     * EnumState
     * 
     * @param name
     * @param acronym
     */
    EnumStates(String name, String acronym) {
        this.name = name;
        this.acronym = acronym;
    }
    
    public static EnumStates fromValue(String acronym) {
        
        for (EnumStates enumStates : values()) {
            if (enumStates.acronym.equals(acronym)) {
                return enumStates;
            }
        }
        
        return null;
        
    }

    /**
     * Get name
     * 
     * @return name
     */
    public String getName() {
        return this.name;
    }

    /**
     * Get Acronym
     * 
     * @return acronym
     */
    public String getAcronym() {
        return this.acronym;
    }
}