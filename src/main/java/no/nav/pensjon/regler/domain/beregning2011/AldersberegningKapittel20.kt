package no.nav.pensjon.regler.domain.beregning2011

import no.nav.pensjon.regler.domain.grunnlag.Beholdninger
import no.nav.pensjon.regler.domain.trygdetid.Brok

class AldersberegningKapittel20 : Beregning2011() {
    var delingstall = 0.0
    var beholdninger: Beholdninger? = null
    var pensjonUnderUtbetaling: PensjonUnderUtbetaling? = null
    var dtBenyttetArsakListe: List<FtDtArsak> = mutableListOf()

    /**
     * De faktiske beholdningene som ble brukt i beregningen ved Førstegangsuttaket
     */
    var beholdningerForForsteuttak: Beholdninger? = null

    /**
     * Anvendt proratabrøk i trygdeavtaleberegninger.
     */
    var prorataBrok: Brok? = null

}