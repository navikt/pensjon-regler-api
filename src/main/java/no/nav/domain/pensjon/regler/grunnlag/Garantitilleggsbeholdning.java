package no.nav.domain.pensjon.regler.grunnlag;

import no.nav.domain.pensjon.regler.beregning2011.GarantitilleggInformasjon;
import no.nav.domain.pensjon.regler.kode.BeholdningsTypeCti;

public class Garantitilleggsbeholdning extends Beholdning {
    private GarantitilleggInformasjon garantitilleggInformasjon;

    public Garantitilleggsbeholdning() {
        super();
        beholdningsType = new BeholdningsTypeCti("GAR_T_B");
    }


}
