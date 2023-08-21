package no.nav.pensjon.regler.domain.beregning2011;

public class BeregningsResultatAfpPrivat extends AbstraktBeregningsResultat {
    private static final long serialVersionUID = -5934159759079967518L;

    private AfpPrivatBeregning afpPrivatBeregning;

    public BeregningsResultatAfpPrivat() {
        super();
    }

    public BeregningsResultatAfpPrivat(AfpPrivatBeregning afpPrivatBeregning) {
        this();
        this.afpPrivatBeregning = afpPrivatBeregning;
    }

    public BeregningsResultatAfpPrivat(BeregningsResultatAfpPrivat res) {
        super(res);
        if (res.afpPrivatBeregning != null) {
            afpPrivatBeregning = new AfpPrivatBeregning(res.afpPrivatBeregning);
        }
    }

    public AfpPrivatBeregning getAfpPrivatBeregning() {
        return afpPrivatBeregning;
    }

    public void setAfpPrivatBeregning(AfpPrivatBeregning afpPrivatBeregning) {
        this.afpPrivatBeregning = afpPrivatBeregning;
    }

}
