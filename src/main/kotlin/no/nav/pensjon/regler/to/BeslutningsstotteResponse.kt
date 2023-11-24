package no.nav.pensjon.regler.to

import no.nav.pensjon.regler.domain.Pakkseddel
import no.nav.pensjon.regler.domain.beregning2011.InntektsberegningsResultat
import no.nav.pensjon.regler.domain.vedtak.AbstraktBeregningsvilkar
import java.io.Serializable

class BeslutningsstotteResponse : Serializable {
    var beregningsvilkarListe: MutableList<AbstraktBeregningsvilkar> = mutableListOf()
    var pakkseddel: Pakkseddel? = null

    /** Resultat av beregning av forventet inntekt  */
    var inntektsberegningsResultat: InntektsberegningsResultat? = null

}