package no.nav.pensjon.regler.domain.beregning2011

import no.nav.pensjon.regler.domain.kode.FtDtArsakCti
import java.io.Serializable

/**
 * @author Lars Hartvigsen (Decisive), PK-9169
 * @author Magnus Bakken (Accenture), PK-9169
 */
class FtDtArsak : Serializable {
    // Angir årsaker til at delingstall eller forholdstall er benyttet i beregninger
    var ftDtArsak: FtDtArsakCti? = null

}