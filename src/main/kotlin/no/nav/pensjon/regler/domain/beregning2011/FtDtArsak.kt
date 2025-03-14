package no.nav.pensjon.regler.domain.beregning2011

import no.nav.pensjon.regler.domain.enum.ArsakFtDtEnum
import java.io.Serializable

class FtDtArsak : Serializable {
    // Angir årsaker til at delingstall eller forholdstall er benyttet i beregninger
    var ftDtArsakEnum: ArsakFtDtEnum? = null
}