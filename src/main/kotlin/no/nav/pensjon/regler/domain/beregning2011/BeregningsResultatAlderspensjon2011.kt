package no.nav.pensjon.regler.domain.beregning2011

class BeregningsResultatAlderspensjon2011 : AbstraktBeregningsResultat() {
    /**
     * Informasjon om pensjon under utbetaling, regnet uten gjenlevenderettighet.
     * Kommer ikke til utbetaling, da denne kun er regnet ut som del av beregningen av gjenlevendetillegget på AP2016.
     */
    var pensjonUnderUtbetalingUtenGJR: PensjonUnderUtbetaling? = null
    var beregningsInformasjonKapittel19: BeregningsInformasjon? = null
    var beregningsInformasjonAvdod: BeregningsInformasjon? = null
    var beregningKapittel19: AldersberegningKapittel19? = null

}