package no.nav.domain.pensjon.regler.kode;

public class YrkeYrkesskadeCti extends TypeCti {
    private static final long serialVersionUID = -2845215287447604087L;

    /**
     * Koder for yrker brukt ved uførepensjon med yrkesskade.
     * Arkfane: k_yrke_yrkesskad
     * pr september 2007 ser tabellen slik ut:
     * EL Elev
     * EL_UTEN_YRK Elev uten yrkesutdanning
     * FISK Fiskere, fagnstmenn
     * MIL Militæreperson
     * UNG Ungdom
     * ARB Vanlig arbeidstagere
     * SELV_NAER Selvstendig næringsdrivende
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
