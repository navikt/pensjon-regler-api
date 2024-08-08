package no.nav.pensjon.regler.domain.beregning2011

import no.nav.pensjon.regler.domain.enum.ArsakFtDtEnum
import no.nav.pensjon.regler.domain.kode.FtDtArsakCti
import java.io.Serializable

class FtDtArsak : Serializable {
    // Angir årsaker til at delingstall eller forholdstall er benyttet i beregninger
    var ftDtArsak: FtDtArsakCti? = null
    var ftDtArsakEnum: ArsakFtDtEnum? = null
}