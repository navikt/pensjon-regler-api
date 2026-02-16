package no.nav.pensjon.regler.to

import no.nav.pensjon.regler.domain.vedtak.AbstraktBeregningsvilkar

class BeslutningsstotteBeregningsvilkarResponse : ServiceResponse() {
    var beregningsvilkarListe: List<AbstraktBeregningsvilkar> = ArrayList()
}
