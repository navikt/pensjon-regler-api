package no.nav.pensjon.regler.to

import no.nav.pensjon.regler.domain.Pakkseddel
import no.nav.pensjon.regler.domain.beregning2011.BeregningsResultatAlderspensjon2025
import java.io.Serializable

class BeregnAlderspensjon2025ForsteUttakResponse : Serializable {
    var beregningsResultat: BeregningsResultatAlderspensjon2025? = null
    var beregningsResultatTilRevurdering: BeregningsResultatAlderspensjon2025? = null
    var pakkseddel: Pakkseddel? = null
}