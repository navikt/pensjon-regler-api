package no.nav.domain.pensjon.regler.beregning2011;

import no.nav.domain.pensjon.regler.beregning.Ytelseskomponent;
import no.nav.domain.pensjon.regler.kode.YtelsekomponentTypeCti;
import no.nav.domain.pensjon.regler.trygdetid.Brok;

public class Inntektspensjon extends Ytelseskomponent {

    /**
     * Br�ken angir PenB_EKSPORT / PenB_NORGE som inntektspensjonen er redusert med.
     */
    private Brok eksportBrok;

    public Inntektspensjon() {
        super();
        ytelsekomponentType = new YtelsekomponentTypeCti("IP");
    }

}
