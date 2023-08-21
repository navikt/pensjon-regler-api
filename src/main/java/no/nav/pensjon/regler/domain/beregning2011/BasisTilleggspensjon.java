package no.nav.pensjon.regler.domain.beregning2011;

import no.nav.pensjon.regler.domain.beregning.Tilleggspensjon;

public class BasisTilleggspensjon extends Tilleggspensjon {

    /**
     * En versjon av Tilleggspensjon uten tilgang til brutto og netto siden Basispensjonsytelsene kun
     * er definert med årsbeløp
     */
    private static final long serialVersionUID = 1128727360249260005L;

    public BasisTilleggspensjon(Tilleggspensjon tilleggspensjon) {
        super(tilleggspensjon);
        // Fjerner brutto og netto
        brutto = 0;
        netto = 0;
    }

    public BasisTilleggspensjon(BasisTilleggspensjon bt) {
        super(bt);
    }

    public BasisTilleggspensjon() {
        super();
    }

    public Tilleggspensjon getTilleggspensjon() {
        return new Tilleggspensjon(this);
    }

    //Gettere og settere kaster exceptions
    @Override
    public int getBrutto() {
        return super.brutto;
    }

    @Override
    public void setBrutto(int brutto) {
        //throw  new IllegalArgumentException("For BasisTilleggspensjon er ikke brutto og netto tilgjengelig");
    }

    @Override
    public int getNetto() {
        return super.netto;
    }

    @Override
    public void setNetto(int netto) {
        //throw  new IllegalArgumentException("For BasisTilleggspensjon er ikke brutto og netto tilgjengelig");
    }
}
