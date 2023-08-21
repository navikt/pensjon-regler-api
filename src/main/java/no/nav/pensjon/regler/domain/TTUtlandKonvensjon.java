package no.nav.pensjon.regler.domain;

import no.nav.pensjon.regler.domain.util.ToStringUtil;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Trygdetid for utenlandssaker, men ikke EØS. Dvs nordisk konvensjon (artikkel
 * 10) og andre land med bilaterale avtaler.
 */
public class TTUtlandKonvensjon implements Serializable {

    private static final long serialVersionUID = 1783665752911160422L;

    /**
     * Brutto framtidig trygdetid i antall måneder etter Nordisk konvensjon.
     */
    private int ftt_A10_brutto;

    /**
     * Netto framtidig trygdetid i antall måneder etter Nordisk konvensjon.
     */
    private int ftt_A10_netto;

    /**
     * Om framtidig trygdetid etter Nordisk konvensjon er redusert etter
     * 4/5-dels regel.
     */
    private boolean ftt_A10_redusert;

    /**
     * Antall framtidige år, brukes ved bilaterale avtaler med UK og Nederland
     */
    private int ft_ar;

    /**
     * Faktisk trygdetid i antall måneder etter Nordisk konvensjon.
     */
    private int tt_A10_fa_mnd;

    /**
     * Faktisk trygdetid i antall år etter Nordisk konvensjon.
     */
    private int tt_A10_anv_aar;

    /**
     * Teller i Nordisk pro-rata brøk.
     */
    private int tt_A10_teller;

    /**
     * Nevner i Nordisk pro-rata brøk.
     */
    private int tt_A10_nevner;

    /**
     * Trygdetiden settes lik antall år som blir tastet inn i feltet.
     */
    private int tt_konvensjon_ar;

    /**
     * Trygdetid skal være like antall poeng år. Har bare betydning for personer
     * som har vært bosatt i utlandet.
     */
    private boolean tt_lik_pa;

    /**
     * Liste av merknader.
     */
    private List<Merknad> merknadListe;

    /**
     * Copy Constructor
     * 
     * @param tTUtlandKonvensjon a <code>TTUtlandKonvensjon</code> object
     */
    public TTUtlandKonvensjon(TTUtlandKonvensjon tTUtlandKonvensjon) {
        ftt_A10_brutto = tTUtlandKonvensjon.ftt_A10_brutto;
        ftt_A10_netto = tTUtlandKonvensjon.ftt_A10_netto;
        ftt_A10_redusert = tTUtlandKonvensjon.ftt_A10_redusert;
        ft_ar = tTUtlandKonvensjon.ft_ar;
        tt_A10_fa_mnd = tTUtlandKonvensjon.tt_A10_fa_mnd;
        tt_A10_anv_aar = tTUtlandKonvensjon.tt_A10_anv_aar;
        tt_A10_teller = tTUtlandKonvensjon.tt_A10_teller;
        tt_A10_nevner = tTUtlandKonvensjon.tt_A10_nevner;
        tt_konvensjon_ar = tTUtlandKonvensjon.tt_konvensjon_ar;
        tt_lik_pa = tTUtlandKonvensjon.tt_lik_pa;
        merknadListe = new ArrayList<Merknad>();
        if (tTUtlandKonvensjon.merknadListe != null) {
            for (Merknad merknad : tTUtlandKonvensjon.merknadListe) {
                merknadListe.add(new Merknad(merknad));
            }
        }
    }

    public TTUtlandKonvensjon(int ftt_A10_brutto, int ftt_A10_netto, boolean ftt_A10_redusert, int ft_ar, int tt_A10_fa_mnd, int tt_A10_anv_aar, int tt_A10_teller,
                              int tt_A10_nevner, int tt_konvensjon_ar, boolean tt_lik_pa, List<Merknad> merknadListe) {
        super();
        this.ftt_A10_brutto = ftt_A10_brutto;
        this.ftt_A10_netto = ftt_A10_netto;
        this.ftt_A10_redusert = ftt_A10_redusert;
        this.ft_ar = ft_ar;
        this.tt_A10_fa_mnd = tt_A10_fa_mnd;
        this.tt_A10_anv_aar = tt_A10_anv_aar;
        this.tt_A10_teller = tt_A10_teller;
        this.tt_A10_nevner = tt_A10_nevner;
        this.tt_konvensjon_ar = tt_konvensjon_ar;
        this.tt_lik_pa = tt_lik_pa;
        this.merknadListe = merknadListe;
    }

    public TTUtlandKonvensjon() {
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

    public int getFt_ar() {
        return ft_ar;
    }

    public void setFt_ar(int ft_ar) {
        this.ft_ar = ft_ar;
    }

    public int getFtt_A10_brutto() {
        return ftt_A10_brutto;
    }

    public void setFtt_A10_brutto(int ftt_A10_brutto) {
        this.ftt_A10_brutto = ftt_A10_brutto;
    }

    public int getFtt_A10_netto() {
        return ftt_A10_netto;
    }

    public void setFtt_A10_netto(int ftt_A10_netto) {
        this.ftt_A10_netto = ftt_A10_netto;
    }

    public boolean isFtt_A10_redusert() {
        return ftt_A10_redusert;
    }

    public void setFtt_A10_redusert(boolean ftt_A10_redusert) {
        this.ftt_A10_redusert = ftt_A10_redusert;
    }

    public List<Merknad> getMerknadListe() {
        return merknadListe;
    }

    public void setMerknadListe(List<Merknad> merknadListe) {
        this.merknadListe = merknadListe;
    }

    public int getTt_A10_anv_aar() {
        return tt_A10_anv_aar;
    }

    public void setTt_A10_anv_aar(int tt_A10_anv_aar) {
        this.tt_A10_anv_aar = tt_A10_anv_aar;
    }

    public int getTt_A10_fa_mnd() {
        return tt_A10_fa_mnd;
    }

    public void setTt_A10_fa_mnd(int tt_A10_fa_mnd) {
        this.tt_A10_fa_mnd = tt_A10_fa_mnd;
    }

    public int getTt_A10_nevner() {
        return tt_A10_nevner;
    }

    public void setTt_A10_nevner(int tt_A10_nevner) {
        this.tt_A10_nevner = tt_A10_nevner;
    }

    public int getTt_A10_teller() {
        return tt_A10_teller;
    }

    public void setTt_A10_teller(int tt_A10_teller) {
        this.tt_A10_teller = tt_A10_teller;
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
