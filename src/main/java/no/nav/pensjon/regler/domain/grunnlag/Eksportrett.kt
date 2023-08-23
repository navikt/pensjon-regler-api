package no.nav.pensjon.regler.domain.grunnlag

import no.nav.pensjon.regler.domain.kode.EksportlandCti
import java.io.Serializable

class Eksportrett : Serializable {
    /**
     * Angir om personen har eksportrett eller ikke.
     */
    var isEksportrett = false

    /**
     * Angir land personen bor i.
     */
    var bostedsland: EksportlandCti? = null

}