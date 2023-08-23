package no.nav.pensjon.regler.domain.grunnlag

import java.io.Serializable
import java.util.*

class ArbeidsforholdEtterUforgrunnlag : Serializable {
    /**
     * Fom date for arbeidsforholdet.
     */
    var fomDato: Date? = null

    /**
     * Work load.
     */
    var stillingsprosent = 0

    /**
     * if it is lasting facilitated work
     */
    var isVarigTilrettelagtArbeid = false

}