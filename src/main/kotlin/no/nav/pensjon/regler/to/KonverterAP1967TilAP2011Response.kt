package no.nav.pensjon.regler.to

import no.nav.pensjon.regler.domain.Pakkseddel
import no.nav.pensjon.regler.domain.beregning2011.BeregningsResultatAlderspensjon2011
import no.nav.pensjon.regler.domain.beregning2011.PensjonUnderUtbetaling
import java.io.Serializable

class KonverterAP1967TilAP2011Response : Serializable {
    var revurdertBeregningsresultat: BeregningsResultatAlderspensjon2011? = null

    /**
     * Pakkseddel for beregningene.
     */
    var pakkseddel = Pakkseddel()
}