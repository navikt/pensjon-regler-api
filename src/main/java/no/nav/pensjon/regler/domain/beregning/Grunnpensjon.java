package no.nav.pensjon.regler.domain.beregning;


import no.nav.pensjon.regler.domain.kode.FormelKodeCti;
import no.nav.pensjon.regler.domain.kode.GPSatsTypeCti;
import no.nav.pensjon.regler.domain.kode.YtelsekomponentTypeCti;
import no.nav.pensjon.regler.domain.trygdetid.AnvendtTrygdetid;

/**
 * Grunnpensjon
 */
public class Grunnpensjon extends Ytelseskomponent {

    private static final long serialVersionUID = -5302448331299075296L;

    /**
     * Prosentsatsen.
     */

    protected double pSats_gp;

    /**
     * Ordinær, forhøyet
     */

    protected GPSatsTypeCti satsType;


    protected boolean ektefelleInntektOver2G;

    /**
     * Denne er beholdt av hensyn til bakoverkompatibilitet med xml filer.
     * Skal ikke ha get/set og skal ikke brukes fra Blaze regelkoden.
     */
    protected double PREG_prorata_gp;

    /**
     * Trygdetid anvendt i beregning av grunnpensjon.
     */

    protected AnvendtTrygdetid anvendtTrygdetid;

    /**
     * Copy Constructor
     */
    public Grunnpensjon(Grunnpensjon gp) {
        super(gp);
        pSats_gp = gp.pSats_gp;
        if (gp.satsType != null) {
            satsType = new GPSatsTypeCti(gp.satsType);
        }
        ektefelleInntektOver2G = gp.ektefelleInntektOver2G;
        if (gp.anvendtTrygdetid != null) {
            anvendtTrygdetid = new AnvendtTrygdetid(gp.anvendtTrygdetid);
        }
    }

    public Grunnpensjon(double sats_gp) {
        pSats_gp = sats_gp;
    }

    public Grunnpensjon() {
        super();
        ytelsekomponentType = new YtelsekomponentTypeCti("GP");
        setFormelKode(new FormelKodeCti("GPx"));
    }

    public double getPSats_gp() {
        return pSats_gp;
    }

    public void setPSats_gp(double pSats_gp) {
        this.pSats_gp = pSats_gp;
    }

    public boolean isEktefelleInntektOver2G() {
        return ektefelleInntektOver2G;
    }

    public void setEktefelleInntektOver2G(boolean ektefelleInntektOver2G) {
        this.ektefelleInntektOver2G = ektefelleInntektOver2G;
    }

    public GPSatsTypeCti getSatsType() {
        return satsType;
    }

    public void setSatsType(GPSatsTypeCti satsType) {
        this.satsType = satsType;
    }

    public AnvendtTrygdetid getAnvendtTrygdetid() {
        return anvendtTrygdetid;
    }

    public void setAnvendtTrygdetid(AnvendtTrygdetid anvendtTrygdetid) {
        this.anvendtTrygdetid = anvendtTrygdetid;
    }
}
