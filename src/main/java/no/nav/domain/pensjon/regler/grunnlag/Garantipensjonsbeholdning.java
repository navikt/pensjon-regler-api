package no.nav.domain.pensjon.regler.grunnlag;

import no.nav.domain.pensjon.regler.beregning2011.JustertGarantipensjonsniva;
import no.nav.domain.pensjon.regler.kode.BeholdningsTypeCti;
import no.nav.domain.pensjon.regler.kode.GarantipenNivaCti;

public class Garantipensjonsbeholdning extends Beholdning {

    private JustertGarantipensjonsniva justertGarantipensjonsniva;
    private double pensjonsbeholdning;
    private double delingstall67;

    /**
     * Satstype brukt i garantipensjonsnivå.
     */
    private GarantipenNivaCti satsType;

    /**
     * Garantipensjonsnivå sats
     */
    private double sats;

    /**
     * Garantipensjonsnivå justert for trygdetid
     */
    private double garPN_tt_anv;

    /**
     * Garantipensjonsnivå fremskrevet.
     */
    private double garPN_justert;

    public Garantipensjonsbeholdning() {
        super();
        beholdningsType = new BeholdningsTypeCti("GAR_PEN_B");
    }

}
