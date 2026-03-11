package no.nav.pensjon.regler.domain.grunnlag

import java.io.Serializable
import java.util.*
import java.time.LocalDate

class ArbeidsforholdEtterUforgrunnlag : Serializable {
    /**
     * Fom date for arbeidsforholdet.
     */
    @Deprecated("Use fomDatoLd instead")
    var fomDato: Date? = null
    var fomDatoLd: LocalDate? = null

    /**
     * Work load.
     */
    var stillingsprosent = 0

    /**
     * if it is lasting facilitated work
     */
    var varigTilrettelagtArbeid = false

}