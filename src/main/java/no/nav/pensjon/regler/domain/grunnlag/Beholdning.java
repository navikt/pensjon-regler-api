package no.nav.pensjon.regler.domain.grunnlag;

import no.nav.pensjon.regler.domain.Merknad;
import no.nav.pensjon.regler.domain.Opptjening;
import no.nav.pensjon.regler.domain.beregning2011.LonnsvekstInformasjon;
import no.nav.pensjon.regler.domain.beregning2011.ReguleringsInformasjon;
import no.nav.pensjon.regler.domain.kode.BeholdningsTypeCti;
import no.nav.pensjon.regler.domain.kode.FormelKodeCti;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public abstract class Beholdning implements Serializable {
    private static final long serialVersionUID = -2398589301376104729L;

    private int ar;
    private double totalbelop;
    private Opptjening opptjening;
    private LonnsvekstInformasjon lonnsvekstInformasjon;
    private ReguleringsInformasjon reguleringsInformasjon;
    private FormelKodeCti formelkode;

    protected BeholdningsTypeCti beholdningsType;
    private List<Merknad> merknadListe;

    protected Beholdning() {
        super();
        merknadListe = new ArrayList<Merknad>();
    }

    protected Beholdning(Beholdning aBeholdning) {
        this();
        ar = aBeholdning.ar;
        totalbelop = aBeholdning.totalbelop;
        if (aBeholdning.reguleringsInformasjon != null) {
            reguleringsInformasjon = new ReguleringsInformasjon(aBeholdning.reguleringsInformasjon);
        }
        if (aBeholdning.opptjening != null) {
            opptjening = new Opptjening(aBeholdning.opptjening);
        }
        if (aBeholdning.beholdningsType != null) {
            beholdningsType = new BeholdningsTypeCti(aBeholdning.beholdningsType);
        }
        if (aBeholdning.formelkode != null)
            this.formelkode = new FormelKodeCti(aBeholdning.formelkode);
        if (aBeholdning.merknadListe != null) {
            for (Merknad m : aBeholdning.merknadListe) {
                merknadListe.add(new Merknad(m));
            }
        }
        if (aBeholdning.lonnsvekstInformasjon != null) {
            lonnsvekstInformasjon = new LonnsvekstInformasjon(aBeholdning.lonnsvekstInformasjon);
        }
    }

    public int getAr() {
        return ar;
    }

    public void setAr(int ar) {
        this.ar = ar;
    }

    public List<Merknad> getMerknadListe() {
        return merknadListe;
    }

    /**
     * Read only property for merknadListe as array
     * 
     * @return array of Merknad
     */
    public Merknad[] getMerknadListeAsArray() {
        return merknadListe != null ? merknadListe.toArray(new Merknad[merknadListe.size()]) : new Merknad[0];
    }

    public void setMerknadListe(List<Merknad> merknadListe) {
        this.merknadListe = merknadListe;
    }

    public Opptjening getOpptjening() {
        return opptjening;
    }

    public void setOpptjening(Opptjening opptjening) {
        this.opptjening = opptjening;
    }

    public double getTotalbelop() {
        return totalbelop;
    }

    public void setTotalbelop(double totalbelop) {
        this.totalbelop = totalbelop;
    }

    public BeholdningsTypeCti getBeholdningsType() {
        return beholdningsType;
    }

    public FormelKodeCti getFormelkode() {
        return formelkode;
    }

    public void setFormelkode(FormelKodeCti fk){
        this.formelkode = fk;
    }

    public LonnsvekstInformasjon getLonnsvekstInformasjon() {
        return lonnsvekstInformasjon;
    }

    public void setLonnsvekstInformasjon(LonnsvekstInformasjon lonnsvekstInformasjon) {
        this.lonnsvekstInformasjon = lonnsvekstInformasjon;
    }

    public ReguleringsInformasjon getReguleringsInformasjon() {
        return reguleringsInformasjon;
    }

    public void setReguleringsInformasjon(ReguleringsInformasjon reguleringsInformasjon) {
        this.reguleringsInformasjon = reguleringsInformasjon;
    }

}
