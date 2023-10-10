package no.nav.pensjon.regler.domain.kode

class YrkeYrkesskadeCti : TypeCti {
    /**
     * Koder for yrker brukt ved uførepensjon med yrkesskade.
     * Arkfane: k_yrke_yrkesskad
     * pr september 2007 ser tabellen slik ut:
     * EL Elev
     * EL_UTEN_YRK Elev uten yrkesutdanning
     * FISK Fiskere, fagnstmenn
     * MIL militæreperson
     * UNG Ungdom
     * ARB Vanlig arbeidstagere
     * SELV_NAER Selvstendig nåringsdrivende
     */
    constructor() : super()
    constructor(kode: String?) : super(kode)
    constructor(yrkeYrkesskadeCti: YrkeYrkesskadeCti) : super(yrkeYrkesskadeCti)
}