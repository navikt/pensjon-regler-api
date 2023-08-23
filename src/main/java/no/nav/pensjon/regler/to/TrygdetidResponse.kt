package no.nav.pensjon.regler.to

import no.nav.pensjon.regler.domain.Pakkseddel
import no.nav.pensjon.regler.domain.Trygdetid
import java.io.Serializable

class TrygdetidResponse : Serializable {
    /**
     * Fastsatt trygdetid.
     */
    var trygdetid: Trygdetid? = null

    /**
     * Fastsatt trygdetid for AP2016 iht. kapittel 20 og AP2025.
     */
    var trygdetidKapittel20: Trygdetid? = null

    /**
     * Fastsatt trygdetid for annet uføretidspunkt.
     */
    var trygdetidAlternativ: Trygdetid? = null

    /**
     * Pakkseddel for beregningene.
     */
    var pakkseddel = Pakkseddel()
}