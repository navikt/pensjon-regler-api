package no.nav.pensjon.regler.domain.vedtak

import no.nav.pensjon.regler.domain.Merknad
import java.io.Serializable

abstract class AbstraktBeregningsvilkar protected constructor() : Serializable {
    var merknadListe: MutableList<Merknad> = mutableListOf()
}