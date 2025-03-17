package no.nav.pensjon.regler.domain.beregning2011

open class BeregningsResultatAlderspensjon2025 : AbstraktBeregningsResultat() {
    var beregningKapittel20: AldersberegningKapittel20? = null
    var beregningsInformasjonKapittel20: BeregningsInformasjon? = null
    var afpOffentligLivsvarig: AfpOffentligLivsvarig? = null
}