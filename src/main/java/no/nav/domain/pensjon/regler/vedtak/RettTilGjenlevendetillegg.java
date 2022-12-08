package no.nav.domain.pensjon.regler.vedtak;

/**
 * @author Steinar Hjellvik Decisive - PK-9900
 */
public class RettTilGjenlevendetillegg extends AbstraktVilkar {


    /**
     * Angir om gjenlevendetillegget skal beregnes som konvertert eller ikke.
     */
    private boolean konvertert;

    public RettTilGjenlevendetillegg() {
        super();
    }

    public RettTilGjenlevendetillegg(RettTilGjenlevendetillegg rettTilGjenlevendetillegg) {
        super(rettTilGjenlevendetillegg);
        this.konvertert = rettTilGjenlevendetillegg.konvertert;
    }

    public boolean isKonvertert() {
        return konvertert;
    }

    public void setKonvertert(boolean konvertert) {
        this.konvertert = konvertert;
    }

    /**
     * @param abs RettTilGjenlevendetillegg som skal kopieres.
     * @return Kopi av input dersom av klassen RettTilGjenlevendetillegg, null ellers.
     */
    @Override
    public AbstraktVilkar dypKopi(AbstraktVilkar abs) {
        RettTilGjenlevendetillegg rettTilGjenlevendetillegg = null;
        if(abs.getClass() == RettTilGjenlevendetillegg.class) {
            rettTilGjenlevendetillegg = new RettTilGjenlevendetillegg((RettTilGjenlevendetillegg) abs);
        }
        return rettTilGjenlevendetillegg;
    }
}
