package no.nav.domain.pensjon.regler.vedtak;

/**
 * @author Magnus Bakken (Accenture), PK-10597, PKPYTON-1063
 */
public class Uforegrad extends AbstraktBeregningsvilkar {

    private static final long serialVersionUID = 3601777774309137278L;

    /**
     * Angir uføregraden UFG.
     */
    private int uforegrad;

    /**
     * Angir hvilende rett til garantigrad.
     */
    private boolean erGarantigrad;

    public Uforegrad() {
        super();
    }

    public Uforegrad(int uforegrad) {
        super();
        this.uforegrad = uforegrad;
    }

    public Uforegrad(Uforegrad uforegrad) {
        super(uforegrad);
        this.uforegrad = uforegrad.uforegrad;
        this.erGarantigrad = uforegrad.erGarantigrad;
    }

    public int getUforegrad() {
        return uforegrad;
    }

    public void setUforegrad(int uforegrad) {
        this.uforegrad = uforegrad;
    }

    public boolean isErGarantigrad() {
        return erGarantigrad;
    }

    public void setErGarantigrad(boolean erGarantigrad) {
        this.erGarantigrad = erGarantigrad;
    }

    public AbstraktBeregningsvilkar dypKopi(AbstraktBeregningsvilkar abs) {
        Uforegrad ufg = null;
        if(abs.getClass() == Uforegrad.class) {
            ufg = new Uforegrad((Uforegrad) abs);
        }
        return ufg;
    }
}
