package no.nav.pensjon.regler.to

import no.nav.pensjon.regler.domain.Pakkseddel
import no.nav.pensjon.regler.domain.beregning2011.BeregningsResultatAlderspensjon2025
import java.io.Serializable

class RevurderingAlderspensjon2025Response : Serializable {
    var revurdertBeregningsResultat: BeregningsResultatAlderspensjon2025? = null
    var beregningsresultatTilRevurdering: BeregningsResultatAlderspensjon2025? = null
    var pakkseddel: Pakkseddel? = null
}