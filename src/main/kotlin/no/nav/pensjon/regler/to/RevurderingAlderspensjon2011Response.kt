package no.nav.pensjon.regler.to

import no.nav.pensjon.regler.domain.Pakkseddel
import no.nav.pensjon.regler.domain.beregning2011.BeregningsResultatAlderspensjon2011
import java.io.Serializable

class RevurderingAlderspensjon2011Response : Serializable {
    var revurdertBeregningsResultat: BeregningsResultatAlderspensjon2011? = null
    var beregningsresultatTilRevurdering: BeregningsResultatAlderspensjon2011? = null
    var pakkseddel: Pakkseddel? = null
}