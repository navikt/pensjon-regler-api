package no.nav.domain.pensjon.regler.beregning2011;

import no.nav.domain.pensjon.regler.Merknad;
import no.nav.domain.pensjon.regler.kode.FormelKodeCti;
import no.nav.domain.pensjon.regler.trygdetid.AnvendtTrygdetid;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


/**
 * @author Steinar Hjellvik (Decisive) - PKPYTON-1746
 * @author Frederik Rønnevig (Decisive) - PK-18954 (Nytt felt eksportforbud)
 *
 */
public class Minsteytelse implements Serializable {

    

    private FormelKodeCti formelKode;

    private List<Merknad> merknadListe;

    private SatsMinsteytelse satsMinsteytelse;

    private int arsbelop;

    private boolean eksportforbud;

    /**
     * Trygdetid som er brukt ved beregning av minsteytelsen.
     */
    private AnvendtTrygdetid anvendtTrygdetid;

    public Minsteytelse() {
        super();
        merknadListe = new ArrayList<Merknad>();
    }

    public Minsteytelse(Minsteytelse minsteytelse) {
        super();
        if (minsteytelse.formelKode != null) {
            formelKode = new FormelKodeCti(minsteytelse.formelKode);
        }
        merknadListe = new ArrayList<Merknad>();
        if (minsteytelse.merknadListe != null) {
            for (Merknad merknad : minsteytelse.merknadListe) {
                merknadListe.add(new Merknad(merknad));
            }
        }
        if (minsteytelse.satsMinsteytelse != null) {
            satsMinsteytelse = new SatsMinsteytelse(minsteytelse.satsMinsteytelse);
        }
        arsbelop = minsteytelse.arsbelop;
        if (minsteytelse.anvendtTrygdetid != null){
            anvendtTrygdetid = new AnvendtTrygdetid(minsteytelse.anvendtTrygdetid);
        }
		
		eksportforbud = minsteytelse.eksportforbud;
		
    }
	
    public FormelKodeCti getFormelKode() {
        return formelKode;
    }

    public void setFormelKode(FormelKodeCti formelKode) {
        this.formelKode = formelKode;
    }

    public List<Merknad> getMerknadListe() {
        return merknadListe;
    }

    public void setMerknadListe(List<Merknad> merknadListe) {
        this.merknadListe = merknadListe;
    }

    public SatsMinsteytelse getSatsMinsteytelse() {
        return satsMinsteytelse;
    }

    public void setSatsMinsteytelse(SatsMinsteytelse satsMinsteytelse) {
        this.satsMinsteytelse = satsMinsteytelse;
    }

    public int getArsbelop() {
        return arsbelop;
    }

    public void setArsbelop(int arsbelop) {
        this.arsbelop = arsbelop;
    }

    public AnvendtTrygdetid getAnvendtTrygdetid() {
        return anvendtTrygdetid;
    }

    public void setAnvendtTrygdetid(AnvendtTrygdetid anvendtTrygdetid) {
        this.anvendtTrygdetid = anvendtTrygdetid;
    }
	
	 public boolean isEksportforbud() {
        return eksportforbud;
    }

    public void setEksportforbud(boolean eksportforbud) {
        this.eksportforbud = eksportforbud;
    }

}
