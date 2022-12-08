package no.nav.domain.pensjon.regler.kode;

/**
 * Angir søsken type. Se arkfane K_SOSKEN_T
 * pr sept 2007 så tabellen slik ut
 * HEL Helsøsken
 * HALV Halvsøsken
 */
public class SoskenTypeCti extends TypeCti {



    public SoskenTypeCti() {
        super();
    }

    public SoskenTypeCti(String kode) {
        super(kode);
    }

    public SoskenTypeCti(SoskenTypeCti soskenTypeCti) {
        super(soskenTypeCti);
    }
}
