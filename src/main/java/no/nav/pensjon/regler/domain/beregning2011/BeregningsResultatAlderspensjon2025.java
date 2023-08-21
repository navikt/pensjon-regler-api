package no.nav.pensjon.regler.domain.beregning2011;

public class BeregningsResultatAlderspensjon2025 extends AbstraktBeregningsResultat {
    private static final long serialVersionUID = -8918119616628608073L;

    private AldersberegningKapittel20 beregningKapittel20;
    private BeregningsInformasjon beregningsInformasjonKapittel20;

    public BeregningsResultatAlderspensjon2025() {
        super();
    }

    public BeregningsResultatAlderspensjon2025(BeregningsResultatAlderspensjon2025 br) {
        super(br);
        if (br.beregningKapittel20 != null) {
            beregningKapittel20 = new AldersberegningKapittel20(br.beregningKapittel20);
        }
        if (br.beregningsInformasjonKapittel20 != null) {
            beregningsInformasjonKapittel20 = br.beregningsInformasjonKapittel20;
        }
    }

    public AldersberegningKapittel20 getBeregningKapittel20() {
        return beregningKapittel20;
    }

    public void setBeregningKapittel20(AldersberegningKapittel20 beregningKapittel20) {
        this.beregningKapittel20 = beregningKapittel20;
    }

    public BeregningsInformasjon getBeregningsInformasjonKapittel20() {
        return beregningsInformasjonKapittel20;
    }

    public void setBeregningsInformasjonKapittel20(BeregningsInformasjon beregningsInformasjonKapittel20) {
        this.beregningsInformasjonKapittel20 = beregningsInformasjonKapittel20;
    }

}
