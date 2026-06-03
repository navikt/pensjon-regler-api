package no.nav.pensjon.regler.domain.grunnlag

import java.io.Serializable
import java.util.*
import java.time.LocalDate

class Arbeidsforholdsgrunnlag : Serializable {
    /**
     * Fom dato for arbeidsforholdet.
     */
    var fomDatoLd: LocalDate? = null

    /**
     * Tom dato for arbeidsforholdet.
     */
    var tomDatoLd: LocalDate? = null

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