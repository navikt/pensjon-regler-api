package no.nav.pensjon.regler.domain.grunnlag

import no.nav.pensjon.regler.domain.enum.EksportlandEnum
import java.io.Serializable

class Eksportrett : Serializable {
    /**
     * Angir om personen har eksportrett eller ikke.
     */
    var eksportrett = false

    /**
     * Angir land personen bor i.
     */
    var bostedslandEnum: EksportlandEnum? = null

}