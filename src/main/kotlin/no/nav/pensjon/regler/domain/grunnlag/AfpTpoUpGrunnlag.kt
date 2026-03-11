package no.nav.pensjon.regler.domain.grunnlag

import java.io.Serializable
import java.util.*
import java.time.LocalDate

class AfpTpoUpGrunnlag : Serializable {
    /**
     * Beløp som skal benyttes i AFP-beregning dersom bruker har hatt uførepensjon fra TPO
     */
    var belop = 0

    /**
     * Dato som beløpet ovenfor var gyldig
     */
    @Deprecated("Use virkFomLd instead")
    var virkFom: Date? = null
    var virkFomLd: LocalDate? = null

}