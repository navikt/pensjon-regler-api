package no.nav.pensjon.regler.domain.beregning2011;

import no.nav.pensjon.regler.domain.Merknad;
import no.nav.pensjon.regler.domain.kode.FormelKodeCti;
import no.nav.pensjon.regler.domain.kode.MinstepenNivaCti;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Kopi av PEN 28/8/2009 - ruller tilbake til PREG domenemodell
 * 
 * @author Ørnulf Moen
 */

public class MinstePensjonsniva implements Serializable {
    private static final long serialVersionUID = 4045032057608587522L;

    private double belop;
    private double sats;
    private int benyttetYug;
    private int pro_rata_teller_mnd;
    private int pro_rata_nevner_mnd;
    private double pro_rata_brok;
    private FormelKodeCti formelKode;

    /** Minstepensjonsnivå. Kan være lav, ordinær og forhøyet. Benytter tabellen */
    private MinstepenNivaCti satsType;

    private List<Merknad> merknadListe = new ArrayList<Merknad>();

    private double PREG_belopIkkeProratisert;
    private int faktisk_tt_avtaleland_mnd;

    public MinstePensjonsniva() {
        super();
        setFormelKode(new FormelKodeCti("MPNx"));
    }

    public MinstePensjonsniva(MinstePensjonsniva mpn) {
        super();
        belop = mpn.belop;
        sats = mpn.sats;
        benyttetYug = mpn.benyttetYug;
        pro_rata_teller_mnd = mpn.pro_rata_teller_mnd;
        pro_rata_nevner_mnd = mpn.pro_rata_nevner_mnd;
        pro_rata_brok = mpn.pro_rata_brok;
        if (mpn.satsType != null) {
            satsType = new MinstepenNivaCti(mpn.satsType);
        }
        if (mpn.formelKode != null) {
            formelKode = new FormelKodeCti(mpn.formelKode);
        }
        if (mpn.merknadListe != null) {
            for (Merknad merknad : mpn.merknadListe) {
                merknadListe.add(new Merknad(merknad));
            }
        }
        PREG_belopIkkeProratisert = mpn.PREG_belopIkkeProratisert;
        faktisk_tt_avtaleland_mnd = mpn.faktisk_tt_avtaleland_mnd;
    }

    public void addMerknad(Merknad m) {
        if (m != null) {
            merknadListe.add(m);
        }
    }

    public List<Merknad> getMerknadListe() {
        return merknadListe;
    }

    public void setMerknadListe(List<Merknad> merknadListe) {
        this.merknadListe = merknadListe;
    }

    /**
     * @deprecated
     * @return
     */
    @Deprecated
    public Merknad[] retrieveMerknadListeAsArray() {
        return merknadListe.toArray(new Merknad[0]);
    }

    /**
     * Read only property for merknadListe as array.
     * 
     * @return array of Merknad
     */
    public Merknad[] getMerknadListeAsArray() {
        return merknadListe != null ? merknadListe.toArray(new Merknad[merknadListe.size()]) : new Merknad[0];
    }

    public double getSats() {
        return sats;
    }

    public void setSats(double sats) {
        this.sats = sats;
    }

    public MinstepenNivaCti getSatsType() {
        return satsType;
    }

    public void setSatsType(MinstepenNivaCti satsType) {
        this.satsType = satsType;
    }

    public double getBelop() {
        return belop;
    }

    public void setBelop(double belop) {
        this.belop = belop;
    }

    public double getPREG_belopIkkeProratisert() {
        return PREG_belopIkkeProratisert;
    }

    public void setPREG_belopIkkeProratisert(double ikkeProratisert) {
        PREG_belopIkkeProratisert = ikkeProratisert;
    }

    public double getPro_rata_brok() {
        return pro_rata_brok;
    }

    public void setPro_rata_brok(double pro_rata_brok) {
        this.pro_rata_brok = pro_rata_brok;
    }

    public int getPro_rata_nevner_mnd() {
        return pro_rata_nevner_mnd;
    }

    public void setPro_rata_nevner_mnd(int pro_rata_nevner_mnd) {
        this.pro_rata_nevner_mnd = pro_rata_nevner_mnd;
    }

    public int getPro_rata_teller_mnd() {
        return pro_rata_teller_mnd;
    }

    public void setPro_rata_teller_mnd(int pro_rata_teller_mnd) {
        this.pro_rata_teller_mnd = pro_rata_teller_mnd;
    }

    public FormelKodeCti getFormelKode() {
        return formelKode;
    }

    public void setFormelKode(FormelKodeCti formelKode) {
        this.formelKode = formelKode;
    }

    public void setBenyttetYug(int benyttetYug) {
        this.benyttetYug = benyttetYug;
    }

    public int getBenyttetYug() {
        return benyttetYug;
    }

    public int getFaktisk_tt_avtaleland_mnd() {
        return faktisk_tt_avtaleland_mnd;
    }

    public void setFaktisk_tt_avtaleland_mnd(int faktisk_tt_avtaleland_mnd) {
        this.faktisk_tt_avtaleland_mnd = faktisk_tt_avtaleland_mnd;
    }

}
