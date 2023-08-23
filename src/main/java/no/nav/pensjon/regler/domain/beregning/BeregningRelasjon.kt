package no.nav.pensjon.regler.domain.beregning

import no.nav.pensjon.regler.domain.beregning2011.Beregning2011
import java.io.Serializable

class BeregningRelasjon : Serializable {
    /**
     * 1967 beregningen som det relateres til
     */
    var beregning: Beregning? = null

    /**
     * Beregning 2011 som det relateres til
     */
    var beregning2011: Beregning2011? = null

    /**
     * Angir om beregningen er brukt (helt eller delvis) i beregningen den tilhører.
     */
    var isBruk = false

    /**
     * Referanse tilbake til beregning hvor beregningsrelasjon inngår i delberegningslisten.
     */
    var pREG_parentBeregning: Beregning? = null

    /**
     * Referanse tilbake til beregning2011 hvor beregningsrelasjon inngår i delberegningslisten.
     */
    var pREG_parentBeregning2011: Beregning2011? = null
}