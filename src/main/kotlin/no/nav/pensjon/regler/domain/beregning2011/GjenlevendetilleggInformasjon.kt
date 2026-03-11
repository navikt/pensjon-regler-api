package no.nav.pensjon.regler.domain.beregning2011

import no.nav.pensjon.regler.domain.enum.YtelseVedDodEnum
import no.nav.pensjon.regler.domain.trygdetid.AnvendtTrygdetid
import java.io.Serializable
import java.util.*
import java.time.LocalDate

class GjenlevendetilleggInformasjon : Serializable {
    /**
     * Avdødes beregningsgrunnlag.
     */
    var beregningsgrunnlagAvdodOrdiner: AbstraktBeregningsgrunnlag? = null

    /**
     * Avdødes anvendte trygdetid.
     */
    var anvendtTrygdetid: AnvendtTrygdetid? = null

    /**
     * dødsdato.
     */
    @Deprecated("Use dodstidspunktLd instead")
    var dodstidspunkt: Date? = null
    var dodstidspunktLd: LocalDate? = null

    /**
     * Hvis ufør ved død er dette gjeldende uføretidspunkt.
     */
    @Deprecated("Use uforetidspunktLd instead")
    var uforetidspunkt: Date? = null
    var uforetidspunktLd: LocalDate? = null

    /**
     * Hvilken ytelse avdød mottok ved sin død.
     */
    var ytelseVedDodEnum: YtelseVedDodEnum? = null

    /**
     * Angir om avdøde ga opphav til gjenlevendepensjon.
     */
    var gjenlevendepensjon = false

    /**
     * Angir om ung ufør ble anvendt for avdøde.
     */
    var minsteYtelseBenyttetUngUfor = false

    /**
     * Minsteytelsen med avdødes egen trygdetid.
     */
    var minsteYtelseArsbelop = 0

    /**
     * Avdødes minsteytelsesats basert på gjenlevendes sivilstand.
     */
    var minsteYtelseSats = 0.0

    /**
     * Yrkesskade beregnet for avdød.
     */
    var yrkesskade = false

    /**
     * Avdødes beregningsgrunnlag for yrkesskade.
     */
    var beregningsgrunnlagAvdodYrkesskade: AbstraktBeregningsgrunnlag? = null

    /**
     * Skadetidspunkt ved yrkesskade.
     */
    @Deprecated("Use skadetidspunktLd instead")
    var skadetidspunkt: Date? = null
    var skadetidspunktLd: LocalDate? = null

    /**
     * Avdødes yrkesskadegrad.
     */
    var yrkesskadegrad = 0

}