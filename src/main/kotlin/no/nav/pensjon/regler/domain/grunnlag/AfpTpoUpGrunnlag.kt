package no.nav.pensjon.regler.domain.grunnlag

import java.io.Serializable
import java.util.*

class AfpTpoUpGrunnlag : Serializable {
    /**
     * Beløp som skal benyttes i AFP-beregning dersom bruker har hatt uførepensjon fra TPO
     */
    var belop = 0

    /**
     * Dato som beløpet ovenfor var gyldig
     */
    var virkFom: Date? = null

}