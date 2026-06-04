package no.nav.pensjon.regler.domain.grunnlag

import no.nav.pensjon.regler.domain.enum.AFPtypeEnum
import java.io.Serializable
import java.util.*
import java.time.LocalDate

class AfpHistorikk : Serializable {
    /**
     * Fremtidig pensjonspoeng
     */
    var afpFpp = 0.0
    var virkFomLd: LocalDate? = null
    var virkTomLd: LocalDate? = null
    var afpPensjonsgrad = 0
    var afpOrdningEnum: AFPtypeEnum? = null

}