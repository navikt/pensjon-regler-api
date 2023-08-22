package no.nav.pensjon.regler.domain;

import no.nav.pensjon.regler.domain.util.ToStringUtil;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Trygdetid for EØS-tilfeller.
 */
public class TTUtlandEOS implements Serializable {

    private static final long serialVersionUID = -4225440287502472443L;

    /**
     * Framtidig trygdetid EØS i antall måneder.
     */
    private int ftt_eos;

    /**
     * Om framtidig trygdetid EØS er redusert. Dersom faktisk trygdetid
     * medregnet tid i Norge og EØS er mindre enn 4/5 av opptjeningstiden skal
     * framtidig trygdetid for EØS beregnes med reduksjon.
     */
    private boolean ftt_eos_redusert;

    /**
     * Teoretisk trygdetid EØS i antall måneder.
     */
    private int tt_eos_anv_mnd;

    /**
     * Teoretisk trygdetid EØS i antall år.
     */
    private int tt_eos_anv_ar;

    /**
     * Pro-rata trygdetid i EØS land utenfor Norge i antall måneder.
     */
    private int tt_eos_pro_rata_mnd;

    /**
     * Teoretisk trygdetid i EØS land utenfor Norge i antall måneder.
     */
    private int tt_eos_teoretisk_mnd;

    /**
     * Teller i EØS pro-rata brøk, i antall måneder.
     */
    private int tt_eos_teller;

    /**
     * Nevner i EØS pro-rata brøk, i antall måneder.
     */
    private int tt_eos_nevner;

    // usikker på om disse skal ligge begge steder
    /**
     * Trygdetid skal være lik antall poengår. Har bare betydning for personer
     * som har vært bosatt i utlandet.
     */
    private boolean tt_lik_pa;

    /**
     * Trygdetiden settes lik antall år som blir tastet inn i feltet.
     */
    private int tt_konvensjon_ar;

    /**
     * Liste av merknader.
     */
    private List<Merknad> merknadListe;

    /**
     * Copy Constructor
     * 
     * @param tTUtlandEOS a <code>TTUtlandEOS</code> object
     */
    public TTUtlandEOS(TTUtlandEOS tTUtlandEOS) {
        ftt_eos = tTUtlandEOS.ftt_eos;
        ftt_eos_redusert = tTUtlandEOS.ftt_eos_redusert;
        tt_eos_anv_mnd = tTUtlandEOS.tt_eos_anv_mnd;
        tt_eos_anv_ar = tTUtlandEOS.tt_eos_anv_ar;
        tt_eos_pro_rata_mnd = tTUtlandEOS.tt_eos_pro_rata_mnd;
        tt_eos_teoretisk_mnd = tTUtlandEOS.tt_eos_teoretisk_mnd;
        tt_eos_teller = tTUtlandEOS.tt_eos_teller;
        tt_eos_nevner = tTUtlandEOS.tt_eos_nevner;
        tt_lik_pa = tTUtlandEOS.tt_lik_pa;
        tt_konvensjon_ar = tTUtlandEOS.tt_konvensjon_ar;
        merknadListe = new ArrayList<Merknad>();
        if (tTUtlandEOS.merknadListe != null) {
            for (Merknad merknad : tTUtlandEOS.merknadListe) {
                merknadListe.add(new Merknad(merknad));
            }
        }
    }

    public TTUtlandEOS(int ftt_eos, boolean ftt_eos_redusert, int tt_eos_anv_mnd, int tt_eos_anv_ar, int tt_eos_pro_rata_mnd, int tt_eos_teoretisk_mnd, int tt_eos_teller,
                       int tt_eos_nevner, boolean tt_lik_pa, int tt_konvensjon_ar) {
        this();
        this.ftt_eos = ftt_eos;
        this.ftt_eos_redusert = ftt_eos_redusert;
        this.tt_eos_anv_mnd = tt_eos_anv_mnd;
        this.tt_eos_anv_ar = tt_eos_anv_ar;
        this.tt_eos_pro_rata_mnd = tt_eos_pro_rata_mnd;
        this.tt_eos_teoretisk_mnd = tt_eos_teoretisk_mnd;
        this.tt_eos_teller = tt_eos_teller;
        this.tt_eos_nevner = tt_eos_nevner;
        this.tt_lik_pa = tt_lik_pa;
        this.tt_konvensjon_ar = tt_konvensjon_ar;
    }

    public TTUtlandEOS() {
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

    public int getFtt_eos() {
        return ftt_eos;
    }

    public void setFtt_eos(int ftt_eos) {
        this.ftt_eos = ftt_eos;
    }

    public boolean isFtt_eos_redusert() {
        return ftt_eos_redusert;
    }

    public void setFtt_eos_redusert(boolean ftt_eos_redusert) {
        this.ftt_eos_redusert = ftt_eos_redusert;
    }

    public List<Merknad> getMerknadListe() {
        return merknadListe;
    }

    public void setMerknadListe(List<Merknad> merknadListe) {
        this.merknadListe = merknadListe;
    }

    public int getTt_eos_anv_ar() {
        return tt_eos_anv_ar;
    }

    public void setTt_eos_anv_ar(int tt_eos_anv_ar) {
        this.tt_eos_anv_ar = tt_eos_anv_ar;
    }

    public int getTt_eos_anv_mnd() {
        return tt_eos_anv_mnd;
    }

    public void setTt_eos_anv_mnd(int tt_eos_anv_mnd) {
        this.tt_eos_anv_mnd = tt_eos_anv_mnd;
    }

    public int getTt_eos_nevner() {
        return tt_eos_nevner;
    }

    public void setTt_eos_nevner(int tt_eos_nevner) {
        this.tt_eos_nevner = tt_eos_nevner;
    }

    public int getTt_eos_pro_rata_mnd() {
        return tt_eos_pro_rata_mnd;
    }

    public void setTt_eos_pro_rata_mnd(int tt_eos_pro_rata_mnd) {
        this.tt_eos_pro_rata_mnd = tt_eos_pro_rata_mnd;
    }

    public int getTt_eos_teller() {
        return tt_eos_teller;
    }

    public void setTt_eos_teller(int tt_eos_teller) {
        this.tt_eos_teller = tt_eos_teller;
    }

    public int getTt_eos_teoretisk_mnd() {
        return tt_eos_teoretisk_mnd;
    }

    public void setTt_eos_teoretisk_mnd(int tt_eos_teoretisk_mnd) {
        this.tt_eos_teoretisk_mnd = tt_eos_teoretisk_mnd;
    }

    public int getTt_konvensjon_ar() {
        return tt_konvensjon_ar;
    }

    public void setTt_konvensjon_ar(int tt_konvensjon_ar) {
        this.tt_konvensjon_ar = tt_konvensjon_ar;
    }

    public boolean isTt_lik_pa() {
        return tt_lik_pa;
    }

    public void setTt_lik_pa(boolean tt_lik_pa) {
        this.tt_lik_pa = tt_lik_pa;
    }

}
