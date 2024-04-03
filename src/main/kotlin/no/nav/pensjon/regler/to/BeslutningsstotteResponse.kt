package no.nav.pensjon.regler.to


import no.nav.pensjon.regler.domain.beregning2011.InntektsberegningsResultat
import no.nav.pensjon.regler.domain.vedtak.AbstraktBeregningsvilkar


class BeslutningsstotteResponse : ServiceResponse() {
    var beregningsvilkarListe: List<AbstraktBeregningsvilkar> = ArrayList()

    /** Resultat av beregning av forventet inntekt  */
    var inntektsberegningsResultat: InntektsberegningsResultat? = null

}