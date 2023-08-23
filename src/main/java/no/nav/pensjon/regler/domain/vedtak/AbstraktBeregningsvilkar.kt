package no.nav.pensjon.regler.domain.vedtak

import no.nav.pensjon.regler.domain.Merknad
import java.io.Serializable

/**
 * @author Magnus Bakken (Accenture), PK-10597
 * @author Lars Hartviksen (Decisive), PK-6180
 */
abstract class AbstraktBeregningsvilkar protected constructor() : Serializable {
    var merknadListe: List<Merknad> = mutableListOf()
}