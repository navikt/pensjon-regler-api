package no.nav.pensjon.regler.domain.beregning2011

import no.nav.pensjon.regler.domain.enum.YtelseVedDodEnum
import no.nav.pensjon.regler.domain.kode.YtelseVedDodCti
import no.nav.pensjon.regler.domain.trygdetid.AnvendtTrygdetid
import java.io.Serializable
import java.util.*

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
    var dodstidspunkt: Date? = null

    /**
     * Hvis ufør ved død er dette gjeldende uføretidspunkt.
     */
    var uforetidspunkt: Date? = null

    /**
     * Hvilken ytelse avdød mottok ved sin død.
     */
    var ytelseVedDod: YtelseVedDodCti? = null
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
    var skadetidspunkt: Date? = null

    /**
     * Avdødes yrkesskadegrad.
     */
    var yrkesskadegrad = 0

}