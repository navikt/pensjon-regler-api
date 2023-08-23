package no.nav.pensjon.regler.domain.kode;

public class YrkeYrkesskadeCti extends TypeCti {
    private static final long serialVersionUID = -2845215287447604087L;

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

    public YrkeYrkesskadeCti() {
        super();
    }

    public YrkeYrkesskadeCti(String kode) {
        super(kode);
    }

    public YrkeYrkesskadeCti(YrkeYrkesskadeCti yrkeYrkesskadeCti) {
        super(yrkeYrkesskadeCti);
    }
}
