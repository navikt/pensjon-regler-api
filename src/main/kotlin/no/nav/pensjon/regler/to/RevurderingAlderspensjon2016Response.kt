package no.nav.pensjon.regler.to

import no.nav.pensjon.regler.domain.Pakkseddel
import no.nav.pensjon.regler.domain.beregning2011.BeregningsResultatAlderspensjon2016
import java.io.Serializable

class RevurderingAlderspensjon2016Response : Serializable {
    var revurdertBeregningsResultat: BeregningsResultatAlderspensjon2016? = null
    var beregningsresultatTilRevurdering: BeregningsResultatAlderspensjon2016? = null
    var pakkseddel: Pakkseddel? = null
}