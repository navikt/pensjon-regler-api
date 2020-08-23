package no.nav.domain.pensjon.regler.beregning2011;

public class BeregningsResultatAlderspensjon2016 extends AbstraktBeregningsResultat {
    private static final long serialVersionUID = -3379888428416075355L;

    private int andelKapittel19;
    private BeregningsResultatAlderspensjon2011 beregningsResultat2011;
    private BeregningsResultatAlderspensjon2025 beregningsResultat2025;

    public BeregningsResultatAlderspensjon2016() {
        super();
    }

    public BeregningsResultatAlderspensjon2016(BeregningsResultatAlderspensjon2016 br) {
        super(br);
        if (br.beregningsResultat2011 != null) {
            beregningsResultat2011 = new BeregningsResultatAlderspensjon2011(br.beregningsResultat2011);
        }
        if (br.beregningsResultat2025 != null) {
            beregningsResultat2025 = new BeregningsResultatAlderspensjon2025(br.beregningsResultat2025);
        }
        andelKapittel19 = br.andelKapittel19;
    }

    public int getAndelKapittel19() {
        return andelKapittel19;
    }

    public void setAndelKapittel19(int andelKapittel19) {
        this.andelKapittel19 = andelKapittel19;
    }

    public BeregningsResultatAlderspensjon2011 getBeregningsResultat2011() {
        return beregningsResultat2011;
    }

    public void setBeregningsResultat2011(BeregningsResultatAlderspensjon2011 beregningsResultat2011) {
        this.beregningsResultat2011 = beregningsResultat2011;
    }

    public BeregningsResultatAlderspensjon2025 getBeregningsResultat2025() {
        return beregningsResultat2025;
    }

    public void setBeregningsResultat2025(BeregningsResultatAlderspensjon2025 beregningsResultat2025) {
        this.beregningsResultat2025 = beregningsResultat2025;
    }

}
