package no.nav.pensjon.regler.domain.beregning2011

/**
 * @author Aasmund Nordstoga (Accenture) PK-5549
 */
class BeregningsgrunnlagKonvertert : AbstraktBeregningsgrunnlag() {
    var skattekompensertbelop: Skattekompensertbelop? = null
    var inntektVedSkadetidspunkt = 0
}