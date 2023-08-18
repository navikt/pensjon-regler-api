package no.nav.pensjon.regler.domain.beregning2011;

/**
 * @author Magnus Bakken (Accenture), PK-20716
 */
public class BeregningsResultatAlderspensjon2011 extends AbstraktBeregningsResultat {
    private static final long serialVersionUID = -570027656872544580L;

    /**
     * Informasjon om pensjon under utbetaling, regnet uten gjenlevenderettighet.
     * Kommer ikke til utbetaling, da denne kun er regnet ut som del av beregningen av gjenlevendetillegget på AP2016.
     */
    private PensjonUnderUtbetaling pensjonUnderUtbetalingUtenGJR;

    private BeregningsInformasjon beregningsInformasjonKapittel19;

    private BeregningsInformasjon beregningsInformasjonAvdod;

    private AldersberegningKapittel19 beregningKapittel19;

    private boolean PREG_nullstilt;

    public BeregningsResultatAlderspensjon2011() {
        super();
    }

    public BeregningsResultatAlderspensjon2011(BeregningsResultatAlderspensjon2011 br) {
        super(br);

        if (br.pensjonUnderUtbetalingUtenGJR != null) {
            pensjonUnderUtbetalingUtenGJR = new PensjonUnderUtbetaling(br.pensjonUnderUtbetalingUtenGJR);
        }
        if (br.beregningsInformasjonKapittel19 != null) {
            beregningsInformasjonKapittel19 = new BeregningsInformasjon(br.beregningsInformasjonKapittel19);
        }
        if (br.beregningsInformasjonAvdod != null) {
            beregningsInformasjonAvdod = new BeregningsInformasjon(br.beregningsInformasjonAvdod);
        }
        if (br.beregningKapittel19 != null) {
            beregningKapittel19 = new AldersberegningKapittel19(br.beregningKapittel19);
        }
        PREG_nullstilt = br.PREG_nullstilt;
    }

    public PensjonUnderUtbetaling getPensjonUnderUtbetalingUtenGJR() {
        return pensjonUnderUtbetalingUtenGJR;
    }

    public void setPensjonUnderUtbetalingUtenGJR(PensjonUnderUtbetaling pensjonUnderUtbetalingUtenGJR) {
        this.pensjonUnderUtbetalingUtenGJR = pensjonUnderUtbetalingUtenGJR;
    }

    public AldersberegningKapittel19 getBeregningKapittel19() {
        return beregningKapittel19;
    }

    public void setBeregningKapittel19(AldersberegningKapittel19 beregningKapittel19) {
        this.beregningKapittel19 = beregningKapittel19;
    }

    public BeregningsInformasjon getBeregningsInformasjonKapittel19() {
        return beregningsInformasjonKapittel19;
    }

    public void setBeregningsInformasjonKapittel19(BeregningsInformasjon beregningsInformasjonKapittel19) {
        this.beregningsInformasjonKapittel19 = beregningsInformasjonKapittel19;
    }

    public BeregningsInformasjon getBeregningsInformasjonAvdod() {
        return beregningsInformasjonAvdod;
    }

    public void setBeregningsInformasjonAvdod(BeregningsInformasjon beregningsInformasjonAvdod) {
        this.beregningsInformasjonAvdod = beregningsInformasjonAvdod;
    }

    public boolean isPREG_nullstilt() {
        return PREG_nullstilt;
    }

    public void setPREG_nullstilt(boolean PREG_nullstilt) {
        this.PREG_nullstilt = PREG_nullstilt;
    }
}
