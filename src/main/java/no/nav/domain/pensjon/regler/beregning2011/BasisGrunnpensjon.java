package no.nav.domain.pensjon.regler.beregning2011;

import no.nav.domain.pensjon.regler.beregning.Grunnpensjon;

public class BasisGrunnpensjon extends Grunnpensjon {
    private static final long serialVersionUID = 4988135470015770169L;

    /**
     * En versjon av Grunnpensjon uten tilgang til brutto og netto siden Basispensjonsytelsene kun
     * er definert med årsbeløp
     */
    public BasisGrunnpensjon(Grunnpensjon gp) {
        super(gp);
        // Fjerner brutto og netto
        super.brutto = 0;
        super.netto = 0;
    }

    public BasisGrunnpensjon(BasisGrunnpensjon bg) {
        super(bg);
    }

    public BasisGrunnpensjon() {
        super();
    }

    public Grunnpensjon getGrunnpensjon() {
        return new Grunnpensjon(this);
    }

    //Gettere og settere kaster exceptions
    @Override
    public int getBrutto() {
        return super.brutto;
    }

    @Override
    public void setBrutto(int brutto) {
        //throw  new IllegalArgumentException("For BasisGrunnpensjon er ikke brutto og netto tilgjengelig");

    }

    @Override
    public int getNetto() {
        return super.netto;
    }

    @Override
    public void setNetto(int netto) {
        //throw  new IllegalArgumentException("For BasisGrunnpensjon er ikke brutto og netto tilgjengelig");
    }

}
