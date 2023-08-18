package no.nav.pensjon.regler.domain.beregning2011;

import no.nav.pensjon.regler.domain.beregning.Ytelseskomponent;
import no.nav.pensjon.regler.domain.kode.YtelsekomponentTypeCti;
import no.nav.pensjon.regler.domain.trygdetid.Brok;

public class Inntektspensjon extends Ytelseskomponent {

    private static final long serialVersionUID = -8278641159780687174L;
    /**
     * Br�ken angir PenB_EKSPORT / PenB_NORGE som inntektspensjonen er redusert med.
     */
    private Brok eksportBrok;

    public Inntektspensjon() {
        super();
        ytelsekomponentType = new YtelsekomponentTypeCti("IP");
    }

    public Inntektspensjon(Inntektspensjon ip) {
        super(ip);
        ytelsekomponentType = new YtelsekomponentTypeCti("IP");
        if ( ip.eksportBrok != null) {
            eksportBrok = new Brok(ip.eksportBrok);
        }
    }

    public Brok getEksportBrok() {
        return eksportBrok;
    }

    public void setEksportBrok(Brok eksportBrok) {
        this.eksportBrok = eksportBrok;
    }
}
