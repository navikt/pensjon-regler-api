package no.nav.domain.pensjon.regler.trygdetid;

import no.nav.domain.pensjon.regler.GuiPrompt;

import java.io.Serializable;

/**
 * Anvendt trygdetid i beregning av grunnpensjon med mer.
 */
public class AnvendtTrygdetid implements Serializable {

    private static final long serialVersionUID = -5220320097290531994L;

    /**
     * Anvendt trygdetid i antall år.
     */
    @GuiPrompt(prompt = "Anvendt trygdetid i antall år")
    private int tt_anv;

    /**
     * Anvendt pro rata brøk hvis grunnpensjon er pro rata beregnet.
     * Teller er lik antall måneder faktisk trygdetid i Norge.
     * Nevner er lik antall måneder faktisk trygdetid i Norge og i avtaleland.
     */
    @GuiPrompt(prompt = "Pro rata brøk")
    private Brok pro_rata;

    public AnvendtTrygdetid() {
        super();
    }

    public AnvendtTrygdetid(int tt_anv, Brok pro_rata) {
        super();
        this.tt_anv = tt_anv;
        this.pro_rata = pro_rata;
    }

    public AnvendtTrygdetid(AnvendtTrygdetid anvendtTrygdetid) {
        super();
        tt_anv = anvendtTrygdetid.tt_anv;
        if (anvendtTrygdetid.pro_rata != null) {
            pro_rata = new Brok(anvendtTrygdetid.pro_rata);
        }
    }

    public int getTt_anv() {
        return tt_anv;
    }

    public void setTt_anv(int tt_anv) {
        this.tt_anv = tt_anv;
    }

    public Brok getPro_rata() {
        return pro_rata;
    }

    public void setPro_rata(Brok pro_rata) {
        this.pro_rata = pro_rata;
    }

}
