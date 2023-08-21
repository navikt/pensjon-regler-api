package no.nav.pensjon.regler.domain;

import no.nav.pensjon.regler.domain.kode.AvtalelandCti;
import no.nav.pensjon.regler.domain.util.ToStringUtil;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Trygdetid for land med bilaterale avtaler.
 */
public class TTUtlandTrygdeavtale implements Serializable {

    private static final long serialVersionUID = -1700418099502408637L;

    /**
     * Framtidig trygdetid i avtaleland i antall måneder.
     */
    private int ftt;

    /**
     * Om framtidig trygdetid er redusert etter 4/5-dels regel.
     */
    private boolean ftt_redusert;

    /**
     * Faktisk trygdetid i avtaleland i antall måneder.
     */
    private int tt_fa_mnd;

    /**
     * Anvendt trygdetid i avtaleland i antall år.
     */
    private int tt_anv_ar;

    /**
     * Anvendt trygdetid i avtaleland i antall måneder.
     */
    private int tt_anv_mnd;

    /**
     * Teller i pro-rata brøk.
     */
    private int pro_rata_teller;

    /**
     * Nevner i pro-rata brøk.
     */
    private int pro_rata_nevner;

    /**
     * Avtaleland som trygdetid er opptjent i.
     */
    private AvtalelandCti avtaleland;

    /**
     * Liste av merknader.
     */
    private List<Merknad> merknadListe;

    /**
     * Copy Constructor
     * 
     * @param tTUtlandKonvensjon a <code>TTUtlandKonvensjon</code> object
     */
    public TTUtlandTrygdeavtale(TTUtlandTrygdeavtale tTUtlandTrygdeavtale) {
        ftt = tTUtlandTrygdeavtale.ftt;
        ftt_redusert = tTUtlandTrygdeavtale.ftt_redusert;
        tt_fa_mnd = tTUtlandTrygdeavtale.tt_fa_mnd;
        tt_anv_ar = tTUtlandTrygdeavtale.tt_anv_ar;
        tt_anv_mnd = tTUtlandTrygdeavtale.tt_anv_mnd;
        pro_rata_teller = tTUtlandTrygdeavtale.pro_rata_teller;
        pro_rata_nevner = tTUtlandTrygdeavtale.pro_rata_nevner;
        if (tTUtlandTrygdeavtale.avtaleland != null) {
            avtaleland = new AvtalelandCti(tTUtlandTrygdeavtale.avtaleland);
        }
        merknadListe = new ArrayList<Merknad>();
        if (tTUtlandTrygdeavtale.merknadListe != null) {
            for (Merknad merknad : tTUtlandTrygdeavtale.merknadListe) {
                merknadListe.add(new Merknad(merknad));
            }
        }
    }

    /**
     * Default constructor.
     */
    public TTUtlandTrygdeavtale() {
        super();
        merknadListe = new ArrayList<Merknad>();
    }

    /*
     * Generic version. Uses reflection to print field names and values.
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return ToStringUtil.toString(this);
    }

    public AvtalelandCti getAvtaleland() {
        return avtaleland;
    }

    public void setAvtaleland(AvtalelandCti avtaleland) {
        this.avtaleland = avtaleland;
    }

    public int getFtt() {
        return ftt;
    }

    public void setFtt(int ftt) {
        this.ftt = ftt;
    }

    public boolean isFtt_redusert() {
        return ftt_redusert;
    }

    public void setFtt_redusert(boolean ftt_redusert) {
        this.ftt_redusert = ftt_redusert;
    }

    public int getPro_rata_nevner() {
        return pro_rata_nevner;
    }

    public void setPro_rata_nevner(int pro_rata_nevner) {
        this.pro_rata_nevner = pro_rata_nevner;
    }

    public int getPro_rata_teller() {
        return pro_rata_teller;
    }

    public void setPro_rata_teller(int pro_rata_teller) {
        this.pro_rata_teller = pro_rata_teller;
    }

    public int getTt_anv_ar() {
        return tt_anv_ar;
    }

    public void setTt_anv_ar(int tt_anv_ar) {
        this.tt_anv_ar = tt_anv_ar;
    }

    public int getTt_anv_mnd() {
        return tt_anv_mnd;
    }

    public void setTt_anv_mnd(int tt_anv_mnd) {
        this.tt_anv_mnd = tt_anv_mnd;
    }

    public int getTt_fa_mnd() {
        return tt_fa_mnd;
    }

    public void setTt_fa_mnd(int tt_fa_mnd) {
        this.tt_fa_mnd = tt_fa_mnd;
    }

    public List<Merknad> getMerknadListe() {
        return merknadListe;
    }

    public void setMerknadListe(List<Merknad> merknadListe) {
        this.merknadListe = merknadListe;
    }

}
