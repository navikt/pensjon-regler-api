package no.nav.pensjon.regler.domain.vedtak

import no.nav.pensjon.regler.domain.Trygdetid

class TrygdetidBeregningsvilkar : AbstraktBeregningsvilkar() {
    /**
     * Trygdetiden.
     */
    var trygdetid: Trygdetid? = null

}