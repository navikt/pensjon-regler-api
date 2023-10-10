package no.nav.pensjon.regler.domain

import no.nav.pensjon.regler.domain.beregning.Poengtall
import no.nav.pensjon.regler.domain.beregning2011.LonnsvekstInformasjon
import java.io.Serializable

/**
 * Dataholderklasse for opptjening. Objektet vil være både input og output fra regeltjenester.
 */
class Opptjening : Serializable {
    var ar = 0
    var opptjeningsgrunnlag = 0.0
    var anvendtOpptjeningsgrunnlag = 0.0
    var arligOpptjening = 0.0
    var lonnsvekstInformasjon: LonnsvekstInformasjon? = null
    var pSatsOpptjening = 0.0
    var poengtall: Poengtall? = null
    var inntektUtenDagpenger = 0.0
    var uforeOpptjening: Uforeopptjening? = null
    var dagpenger = 0.0
    var dagpengerFiskerOgFangstmenn = 0.0
    var omsorg = 0.0
    var forstegangstjeneste = 0.0
    var arligOpptjeningOmsorg = 0.0
    var arligOpptjeningUtenOmsorg = 0.0
}