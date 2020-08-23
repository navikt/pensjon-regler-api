package no.nav.domain.pensjon.regler.grunnlag;

import no.nav.domain.pensjon.regler.beregning2011.GarantitilleggInformasjon;
import no.nav.domain.pensjon.regler.kode.BeholdningsTypeCti;

public class Garantitilleggsbeholdning extends Beholdning {
    private static final long serialVersionUID = 7715086125200506314L;
    private GarantitilleggInformasjon garantitilleggInformasjon;

    public Garantitilleggsbeholdning() {
        super();
        beholdningsType = new BeholdningsTypeCti("GAR_T_B");
    }

    public Garantitilleggsbeholdning(Garantitilleggsbeholdning gb) {
        super(gb);
        if (gb.garantitilleggInformasjon != null) {
            garantitilleggInformasjon = new GarantitilleggInformasjon(gb.garantitilleggInformasjon);
        }
    }

    public GarantitilleggInformasjon getGarantitilleggInformasjon() {
        return garantitilleggInformasjon;
    }

    public void setGarantitilleggInformasjon(GarantitilleggInformasjon garantitilleggInformasjon) {
        this.garantitilleggInformasjon = garantitilleggInformasjon;
    }

}
