package no.nav.domain.pensjon.regler.beregning2011;

/**
 * @author Magnus Bakken (Accenture), PK-20716
 */
public class BeregningsResultatAlderspensjon2011 extends AbstraktBeregningsResultat {


    /**
     * Informasjon om pensjon under utbetaling, regnet uten gjenlevenderettighet.
     * Kommer ikke til utbetaling, da denne kun er regnet ut som del av beregningen av gjenlevendetillegget på AP2016.
     */
    private PensjonUnderUtbetaling pensjonUnderUtbetalingUtenGJR;

    private BeregningsInformasjon beregningsInformasjonKapittel19;

    private BeregningsInformasjon beregningsInformasjonAvdod;

    private AldersberegningKapittel19 beregningKapittel19;

    private boolean PREG_nullstilt;


}
