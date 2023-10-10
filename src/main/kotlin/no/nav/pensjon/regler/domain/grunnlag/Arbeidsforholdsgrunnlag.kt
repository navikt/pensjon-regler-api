package no.nav.pensjon.regler.domain.grunnlag

import java.io.Serializable
import java.util.*

class Arbeidsforholdsgrunnlag : Serializable {
    /**
     * Fom dato for arbeidsforholdet.
     */
    var fomDato: Date? = null

    /**
     * Tom dato for arbeidsforholdet.
     */
    var tomDato: Date? = null

    /**
     * Stillingsandel i prosent.
     */
    var stillingsprosent = 0

    /**
     * Navn på arbeidsgiver.
     */
    var arbeidsgiver: String? = null

    /**
     * Arbeidsgivers juridiske organisasjonsnummer.
     */
    var orgNummer: String? = null

}