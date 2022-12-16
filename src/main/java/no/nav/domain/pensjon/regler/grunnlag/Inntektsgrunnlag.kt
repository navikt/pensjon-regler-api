package no.nav.domain.pensjon.regler.grunnlag

import no.nav.domain.pensjon.regler.GuiPrompt
import no.nav.domain.pensjon.regler.kode.GrunnlagKildeCti
import no.nav.domain.pensjon.regler.kode.InntektTypeCti
import java.io.Serializable
import java.util.*

class Inntektsgrunnlag : Serializable {
    /**
     * Unik identifikator for Inntektsgrunnlag. Endres ikke av regelmotoren,
     * men Inntektsgrunnlag med null id kan opprettes av batchtjenestene,
     * derfor settes den til typen wrapperobjekt Long i stedet for primitiven long.
     */
    private var inntektsgrunnlagId: Long? = null

    /**
     * Inntektens størrelse, i hele kroner.
     */
    private var belop = 0

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
     * IMFU Inntekt Mnd Før Uttak
     * PENF Pensjonsinntekt fra folketrygden
     * ARBLTO Arbeidsinntekt (Lønn og trekk)
     * ARBLIGN Arbeidsinntekt (Ligning)
     * PENSKD Pensjonsinntekt (ikke folketrygd)
     * KAP Kapitalinntekt
     */
    private var inntektType: InntektTypeCti? = null

    /**
     * fra-og-med dato for gyldigheten av inntektsgrunnlaget.
     */
    private var fom: Date? = null

    /**
     * til-og-med dato for gyldigheten av inntektsgrunnlaget.
     */
    private var tom: Date? = null

    /**
     * Angir om inntektsgrunnlaget brukes som grunnlag på kravet.
     */
    private var bruk: Boolean = true

    /**
     * Kilden til inntektsgrunnlaget.
     */
    private var grunnlagKilde: GrunnlagKildeCti? = null

}