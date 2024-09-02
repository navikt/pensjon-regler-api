package no.nav.pensjon.regler.domain.grunnlag

import no.nav.pensjon.regler.domain.enum.GrunnlagkildeEnum
import no.nav.pensjon.regler.domain.enum.InntekttypeEnum
import no.nav.pensjon.regler.domain.kode.GrunnlagKildeCti
import no.nav.pensjon.regler.domain.kode.InntektTypeCti
import java.io.Serializable
import java.util.*

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
    var inntektType: InntektTypeCti? = null
    var inntektTypeEnum: InntekttypeEnum? = null

    /**
     * fra-og-med dato for gyldigheten av inntektsgrunnlaget.
     */
    var fom: Date? = null

    /**
     * til-og-med dato for gyldigheten av inntektsgrunnlaget.
     */
    var tom: Date? = null

    /**
     * Angir om inntektsgrunnlaget brukes som grunnlag på kravet.
     */
    var bruk: Boolean = true

    /**
     * Kilden til inntektsgrunnlaget.
     */
    var grunnlagKilde: GrunnlagKildeCti? = null
    var grunnlagKildeEnum: GrunnlagkildeEnum? = null

}