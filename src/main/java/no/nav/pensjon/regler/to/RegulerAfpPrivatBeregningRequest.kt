package no.nav.pensjon.regler.to

import no.nav.pensjon.regler.domain.beregning2011.BeregningsResultatAfpPrivat
import java.util.*

class RegulerAfpPrivatBeregningRequest() {
    var virkFom: Date? = null
    var virkFomAfpFrivatUttak: Date? = null
    var beregningsResultat: BeregningsResultatAfpPrivat? = null

    constructor(
        virkFom: Date?,
        virkFomAfpFrivatUttak: Date?,
        beregningsResultat: BeregningsResultatAfpPrivat?
    ) : this() {
        this.virkFom = virkFom
        this.virkFomAfpFrivatUttak = virkFomAfpFrivatUttak
        this.beregningsResultat = beregningsResultat
    }
}