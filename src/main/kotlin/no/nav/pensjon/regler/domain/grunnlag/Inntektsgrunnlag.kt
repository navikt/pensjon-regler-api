package no.nav.pensjon.regler.domain.grunnlag

import no.nav.pensjon.regler.domain.enum.GrunnlagkildeEnum
import no.nav.pensjon.regler.domain.enum.InntekttypeEnum
import java.io.Serializable
import java.util.*
import java.time.LocalDate

class Inntektsgrunnlag() : Serializable {
    /*
     * Unik identifikator for Inntektsgrunnlag. Endres ikke av regelmotoren,
     * men Inntektsgrunnlag med null id kan opprettes av batchtjenestene,
     * derfor settes den til typen wrapperobjekt Long i stedet for primitiven long.
     */
    var inntektsgrunnlagId: Long? = null

    /**
     * Inntektens størrelse, i hele kroner.
     */
    var belop = 0

    /**
     * Kode som angir type inntekt. Se K_INNTEKT_T.
     * Pr september 2007 så tabellen slik ut:
     * FPI Forventet arbeidsinntekt
     * FKI Forventet kapitalinntekt
     * PENT Forventet tjenestepensjonsinntekt (ikke folketrygd)
     * FBI Forventet bidrag o.l
     * HYPF Hypotetisk forventet arbeidsinntekt
     * HYPF2G Hypotetisk forventet arbeidsinntekt 2G
     * PGI Foreløpig pensjonsgivende inntekt
     * IMFU Inntekt Mnd før Uttak
     * PENF Pensjonsinntekt fra folketrygden
     * ARBLTO Arbeidsinntekt (Lønn og trekk)
     * ARBLIGN Arbeidsinntekt (Ligning)
     * PENSKD Pensjonsinntekt (ikke folketrygd)
     * KAP Kapitalinntekt
     */
    var inntektTypeEnum: InntekttypeEnum? = null

    /**
     * fra-og-med dato for gyldigheten av inntektsgrunnlaget.
     */
    @Deprecated("Use fomLd instead")
    var fom: Date? = null
    var fomLd: LocalDate? = null

    /**
     * til-og-med dato for gyldigheten av inntektsgrunnlaget.
     */
    @Deprecated("Use tomLd instead")
    var tom: Date? = null
    var tomLd: LocalDate? = null

    /**
     * Angir om inntektsgrunnlaget brukes som grunnlag på kravet.
     */
    var bruk: Boolean = true

    /**
     * Kilden til inntektsgrunnlaget.
     */
    var grunnlagKildeEnum: GrunnlagkildeEnum? = null

}