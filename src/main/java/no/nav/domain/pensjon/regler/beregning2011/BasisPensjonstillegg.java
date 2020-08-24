package no.nav.domain.pensjon.regler.beregning2011;

public class BasisPensjonstillegg extends Pensjonstillegg {

    /**
     * En versjon av Pensjonstillegg uten tilgang til brutto og netto siden Basispensjonsytelsene kun
     * er definert med årsbeløp
     */
    private static final long serialVersionUID = 6009420588469081827L;

    public BasisPensjonstillegg(Pensjonstillegg pt) {
        super(pt);
        // Fjerner brutto og netto
        brutto = 0;
        netto = 0;
    }

    public BasisPensjonstillegg(BasisPensjonstillegg bp) {
        super(bp);
    }

    public BasisPensjonstillegg() {
        super();
    }

    public Pensjonstillegg getPensjonstillegg() {
        return new Pensjonstillegg(this);
    }

    //Gettere og settere kaster exceptions
    @Override
    public int getBrutto() {
        return super.brutto;
    }

    @Override
    public void setBrutto(int brutto) {
        //throw  new IllegalArgumentException("For BasisPensjonsTillegg er ikke brutto og netto tilgjengelig");
    }

    @Override
    public int getNetto() {
        return super.netto;
    }

    @Override
    public void setNetto(int netto) {
        //throw  new IllegalArgumentException("For BasisPensjonsTillegg er ikke brutto og netto tilgjengelig");
    }
}
