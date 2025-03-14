package no.nav.pensjon.regler.domain.grunnlag

import no.nav.pensjon.regler.domain.enum.InntekttypeEnum
import java.io.Serializable

class FaktiskInntektsgrunnlag : Serializable {
    /** Akkumulert inntekt hittil i år.  */
    var faktiskeInntekterHittilIAr = 0

    /** Angir hvilken type inntekt som er akkumulert.  */
    var inntektTypeEnum = InntekttypeEnum.UKJENT
}