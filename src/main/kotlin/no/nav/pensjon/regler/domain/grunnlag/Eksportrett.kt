package no.nav.pensjon.regler.domain.grunnlag

import no.nav.pensjon.regler.domain.enum.EksportlandEnum
import no.nav.pensjon.regler.domain.enum.LandkodeEnum
import no.nav.pensjon.regler.domain.kode.EksportlandCti
import java.io.Serializable

class Eksportrett : Serializable {
    /**
     * Angir om personen har eksportrett eller ikke.
     */
    var eksportrett = false

    /**
     * Angir land personen bor i.
     */
    var bostedsland: EksportlandCti? = null
    var bostedslandEnum: EksportlandEnum? = null

}