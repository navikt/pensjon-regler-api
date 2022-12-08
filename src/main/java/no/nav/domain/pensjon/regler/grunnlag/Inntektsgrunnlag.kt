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
    @GuiPrompt(prompt = "Inntekt")
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
    @GuiPrompt(prompt = "Inntektstype")
    private var inntektType: InntektTypeCti? = null

    /**
     * fra-og-med dato for gyldigheten av inntektsgrunnlaget.
     */
    @GuiPrompt(prompt = "Fra og med dato")
    private var fom: Date? = null

    /**
     * til-og-med dato for gyldigheten av inntektsgrunnlaget.
     */
    @GuiPrompt(prompt = "Til og med dato")
    private var tom: Date? = null

    /**
     * Angir om inntektsgrunnlaget brukes som grunnlag på kravet.
     */
    private var bruk: Boolean

    /**
     * Kilden til inntektsgrunnlaget.
     */
    private var grunnlagKilde: GrunnlagKildeCti? = null

    /**
     * Copy Constructor
     *
     * @param inntektsgrunnlag a `Inntektsgrunnlag` object
     */
    constructor(inntektsgrunnlag: Inntektsgrunnlag) {
        if (inntektsgrunnlag.inntektsgrunnlagId != null) {
            inntektsgrunnlagId = inntektsgrunnlag.inntektsgrunnlagId
        }
        belop = inntektsgrunnlag.belop
        if (inntektsgrunnlag.inntektType != null) {
            inntektType = InntektTypeCti(inntektsgrunnlag.inntektType)
        }
        if (inntektsgrunnlag.fom != null) {
            fom = inntektsgrunnlag.fom!!.clone() as Date
        }
        if (inntektsgrunnlag.tom != null) {
            tom = inntektsgrunnlag.tom!!.clone() as Date
        }
        bruk = inntektsgrunnlag.bruk
        if (inntektsgrunnlag.grunnlagKilde != null) {
            grunnlagKilde = GrunnlagKildeCti(inntektsgrunnlag.grunnlagKilde)
        }
    }

    /**
     * Copy constructor
     * Brukes i spesialtilfeller der vi vil opprette et inntektsgrunnlag fra Blaze hvor ID skal være null.
     * Dette brukes i enkelte batchtjenester, og kan ikke gjøres direkte i Blaze fordi Long blir mappet til integer.
     *
     * @param inntektsgrunnlag
     * @param inntektsgrunnlagIdNull
     */
    constructor(inntektsgrunnlag: Inntektsgrunnlag, inntektsgrunnlagIdNull: Boolean) : this(inntektsgrunnlag) {
        if (inntektsgrunnlagIdNull) {
            inntektsgrunnlagId = null
        }
    }

    constructor(
        inntektsgrunnlagId: Long?,
        belop: Int,
        inntektType: InntektTypeCti?,
        fom: Date?,
        tom: Date?,
        bruk: Boolean,
        grunnlagKilde: GrunnlagKildeCti?
    ) : this() {
        this.inntektsgrunnlagId = inntektsgrunnlagId
        this.belop = belop
        this.inntektType = inntektType
        this.fom = fom
        this.tom = tom
        this.bruk = bruk
        this.grunnlagKilde = grunnlagKilde
    }

    /**
     * private boolean kopiertFraGammeltKrav;
     */
    constructor() : super() {
        bruk = true
    }
}