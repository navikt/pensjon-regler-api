package no.nav.pensjon.regler.domain.beregning2011

class BeregningsgrunnlagKonvertert : AbstraktBeregningsgrunnlag() {
    var skattekompensertbelop: Skattekompensertbelop? = null
    var inntektVedSkadetidspunkt = 0
}