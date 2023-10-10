package no.nav.pensjon.regler.domain.grunnlag

import no.nav.pensjon.regler.domain.kode.AfpOrdningTypeCti
import java.io.Serializable
import java.util.*

class AfpHistorikk : Serializable {
    /**
     * Fremtidig pensjonspoeng
     */
    var afpFpp = 0.0
    var virkFom: Date? = null
    var virkTom: Date? = null
    var afpPensjonsgrad = 0
    var afpOrdning: AfpOrdningTypeCti? = null

}