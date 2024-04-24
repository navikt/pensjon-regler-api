package no.nav.pensjon.regler.domain.grunnlag

import java.io.Serializable
import java.util.*

class PersonOpptjeningsgrunnlag : Serializable {
    /**
     * Brukes ikke av pensjon-regler
     */
    var fnr: String? = null

    /**
     * Opptjeningen det skal beregnes pensjonspoeng for.
     * Feltene ar, opptjeningType er påkrevd. Dersom opptjeningType er lik PPI så er pi også påkrevd.
     */
    var opptjening: Opptjeningsgrunnlag? = null

    /**
     * Brukers Fødselsdato
     */
    var fodselsdato: Date? = null
}