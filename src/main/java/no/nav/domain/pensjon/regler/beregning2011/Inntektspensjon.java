package no.nav.domain.pensjon.regler.beregning2011;

import no.nav.domain.pensjon.regler.beregning.Ytelseskomponent;
import no.nav.domain.pensjon.regler.kode.YtelsekomponentTypeCti;
import no.nav.domain.pensjon.regler.trygdetid.Brok;

public class Inntektspensjon extends Ytelseskomponent {

    /**
     * Brøken angir PenB_EKSPORT / PenB_NORGE som inntektspensjonen er redusert med.
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
