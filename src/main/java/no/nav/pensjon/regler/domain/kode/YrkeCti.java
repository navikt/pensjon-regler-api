package no.nav.pensjon.regler.domain.kode;

public class YrkeCti extends TypeCti {

    private static final long serialVersionUID = -1359402436242656547L;

    /**
     * Koder for yrker brukt ved uførepensjon uten yrkesskade.
     * Arkfane: k_yrke_t
     * pr sept 2007 så tabellen slik ut
     * INTET Intet yrke
     * ARB Arbeider
     * FUNK Funksjonær
     * GB Gårdbruker
     * SKOLE Skoleelev
     * FISKER Fisker
     * SJO Sjømann
     * SELVN Selvstendig næringsdrivende
     * PENS Pensjonist
     * ANDRE Andre
     * KOMB_YRK Er faktisk i en kombinert yrkessituasjon
     * ANTA_KOMB Antas å ville ha vært i en kombinert yrkesaktiv/-hjemmearbeidende situasjon om uførheten ikke hadde oppstøtt
     * ANTA_YRK Antas å ville ha vært yrkesaktiv om ikke uførheten hadde inntruffet
     * SKILT Er skilt
     * GJENL Er gjenlevende
     * SEP Formelt eller faktisk separert
     * INNT_2G Ektefellens inntekt er mindre enn 2G
     * HJEM_ARB Vurdert som utelukkende hjemmearbeidende
     */

    public YrkeCti() {
        super();
    }

    public YrkeCti(String kode) {
        super(kode);
    }

    public YrkeCti(YrkeCti yrkeCti) {
        super(yrkeCti);
    }
}
