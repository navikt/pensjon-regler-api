package no.nav.domain.pensjon.regler.kode;

public class YrkeYrkesskadeCti extends TypeCti {
    

    /**
     * Koder for yrker brukt ved uf�repensjon med yrkesskade.
     * Arkfane: k_yrke_yrkesskad
     * pr september 2007 ser tabellen slik ut:
     * EL Elev
     * EL_UTEN_YRK Elev uten yrkesutdanning
     * FISK Fiskere, fagnstmenn
     * MIL Milit�reperson
     * UNG Ungdom
     * ARB Vanlig arbeidstagere
     * SELV_NAER Selvstendig n�ringsdrivende
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
