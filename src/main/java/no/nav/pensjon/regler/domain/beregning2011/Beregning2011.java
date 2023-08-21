package no.nav.pensjon.regler.domain.beregning2011;

import no.nav.pensjon.regler.domain.IBeregning;
import no.nav.pensjon.regler.domain.Merknad;
import no.nav.pensjon.regler.domain.PenPerson;
import no.nav.pensjon.regler.domain.beregning.Beregning;
import no.nav.pensjon.regler.domain.beregning.BeregningRelasjon;
import no.nav.pensjon.regler.domain.kode.BeregningGjelderTypeCti;
import no.nav.pensjon.regler.domain.kode.BeregningMetodeTypeCti;
import no.nav.pensjon.regler.domain.kode.BeregningTypeCti;
import no.nav.pensjon.regler.domain.kode.ResultatTypeCti;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Lars Hartvigsen (Decisive) - PK-12169 HL3 2015
 */

public abstract class Beregning2011 implements IBeregning, Serializable {
    private static final long serialVersionUID = 629901728712789182L;

    private String PREG_beregningsnavn;
    private PenPerson gjelderPerson;
    private int grunnbelop;
    private int tt_anv;
    private ResultatTypeCti resultatType;
    private BeregningMetodeTypeCti beregningsMetode;
    private BeregningTypeCti beregningType;

    private List<BeregningRelasjon> delberegning2011Liste = new ArrayList<BeregningRelasjon>();
    private List<Merknad> merknadListe = new ArrayList<Merknad>();
    /**
     * Referanse tilbake til beregningsrelasjon dersom denne beregning inngår i en beregningsrelasjon.
     */
    private BeregningRelasjon PREG_beregningsrelasjon;

    /**
     * Feltet støtter navngivning av beregningen i beregningstreet.
     * Ifbm. Gjenlevendetillegg settes koden avhengig av hvilke grunnlagsroller som beregningen angår.
     */
    private BeregningGjelderTypeCti beregningGjelderType;

    public Beregning2011() {
        super();
    }

    public Beregning2011(Beregning2011 b) {
        this(b, true);
    }

    public Beregning2011(Beregning2011 b, boolean kopierDelberegning2011Liste) {
        this();
        this.grunnbelop = b.getGrunnbelop();
        if (b.gjelderPerson != null) {
            gjelderPerson = new PenPerson(b.gjelderPerson.getPenPersonId());
        }
        tt_anv = b.tt_anv;
        if (b.resultatType != null) {
            resultatType = new ResultatTypeCti(b.resultatType);
        }
        if (b.beregningsMetode != null) {
            beregningsMetode = new BeregningMetodeTypeCti(b.beregningsMetode);
        }
        if (b.beregningType != null) {
            beregningType = new BeregningTypeCti(b.beregningType);
        }
        if (b.delberegning2011Liste != null && kopierDelberegning2011Liste) {
            for (BeregningRelasjon r : b.delberegning2011Liste) {
                delberegning2011Liste.add(new BeregningRelasjon(r));
            }
        }
        PREG_beregningsnavn = b.PREG_beregningsnavn;
        if (b.merknadListe != null) {
            for (Merknad m : b.merknadListe) {
                merknadListe.add(new Merknad(m));
            }
        }

        if (b.beregningGjelderType != null) {
            this.beregningGjelderType = new BeregningGjelderTypeCti(b.beregningGjelderType);
        }
    }

    /**
     * @param pREGBeregningId the PREG_beregningsnavn to set
     */
    public void setPREG_beregningsnavn(String pREGBeregningId) {
        PREG_beregningsnavn = pREGBeregningId;
    }

    public String getPREG_beregningsnavn() {
        return PREG_beregningsnavn;
    }

    public void addBeregning2011Relasjon(BeregningRelasjon berRel) {
        if (berRel != null) {
            delberegning2011Liste.add(berRel);
        }
    }

    public BeregningMetodeTypeCti getBeregningsMetode() {
        return beregningsMetode;
    }

    public void setBeregningsMetode(BeregningMetodeTypeCti beregningsMetode) {
        this.beregningsMetode = beregningsMetode;
    }

    public BeregningTypeCti getBeregningType() {
        return beregningType;
    }

    public void setBeregningType(BeregningTypeCti beregningType) {
        this.beregningType = beregningType;
    }

    public PenPerson getGjelderPerson() {
        return gjelderPerson;
    }

    public void setGjelderPerson(PenPerson gjelderPerson) {
        this.gjelderPerson = gjelderPerson;
    }

    public void addMerknad(Merknad m) {
        if (m != null) {
            merknadListe.add(m);
        }
    }

    public ResultatTypeCti getResultatType() {
        return resultatType;
    }

    public void setResultatType(ResultatTypeCti resultatType) {
        this.resultatType = resultatType;
    }

    public int getTt_anv() {
        return tt_anv;
    }
    public void setTt_anv(int tt_anv) {
        this.tt_anv = tt_anv;
    }

    public int getGrunnbelop() { return grunnbelop; }
    public void setGrunnbelop(int grunnbelop) { this.grunnbelop = grunnbelop; }

    @Override
    public List<BeregningRelasjon> getDelberegningsListe() {
        return delberegning2011Liste;
    }

    public List<BeregningRelasjon> getDelberegning2011Liste() {
        return delberegning2011Liste;
    }

    public void setDelberegning2011Liste(List<BeregningRelasjon> delberegning2011Liste) {
        this.delberegning2011Liste = delberegning2011Liste;
    }

    public List<Merknad> getMerknadListe() {
        return merknadListe;
    }

    public void setMerknadListe(List<Merknad> merknadListe) {
        this.merknadListe = merknadListe;
    }

    /**
     * @return returnerer delberegning1967 fra delberegning2011Liste
     */
    public BeregningRelasjon getDelberegning1967() {
        return finnDelberegning1967();
    }

    /**
     * Hvis beregningsrelasjon ikke inneholder beregning 1967 blir, delberegning1967 satt til null.
     */
    public void setDelberegning1967(BeregningRelasjon delberegning1967) {
        if (erBeregning1967(delberegning1967)) {
            BeregningRelasjon eksisterende = finnDelberegning1967();
            if (eksisterende != null) {
                // Delberegning1967 finnes fra før, blir derfor overskrevet/fjernet
                delberegning2011Liste.remove(eksisterende);
            }
            if (delberegning1967 != null) {
                delberegning2011Liste.add(delberegning1967);
                delberegning1967.setPREG_parentBeregning2011(this);
            }
        } else {
            throw new RuntimeException("delberegning1967 kan bare være av typen Beregning");
        }
    }

    /**
     * Legger til beregningRelasjon til lista. BeregningsId blir satt på den respektive beregningen.
     */
    public void addBeregningRelasjon(BeregningRelasjon beregningRelasjon, String beregningId) {
        if (beregningId != null && beregningRelasjon != null) {
            BeregningRelasjon eksisterende = getBeregningRelasjon(beregningId);
            if (eksisterende != null) {
                // Fjern eksisterende
                delberegning2011Liste.remove(eksisterende);
            }
            if (beregningRelasjon.getBeregning() != null) {
                beregningRelasjon.getBeregning().setPREG_beregningsnavn(beregningId);
            }
            if (beregningRelasjon.getBeregning2011() != null) {
                beregningRelasjon.getBeregning2011().setPREG_beregningsnavn(beregningId);
            }
            beregningRelasjon.setPREG_parentBeregning2011(this);
            delberegning2011Liste.add(beregningRelasjon);
        }
    }

    public void addBeregning(Beregning2011 beregning2011, boolean brukt, String beregningId) {
        beregning2011.setPREG_beregningsnavn(beregningId);
        BeregningRelasjon br = new BeregningRelasjon();
        br.setBeregning2011(beregning2011);
        addBeregningRelasjon(br, beregningId);
    }

    public void addBeregning(Beregning beregning, boolean brukt, String beregningId) {
        beregning.setPREG_beregningsnavn(beregningId);
        BeregningRelasjon br = new BeregningRelasjon();
        br.setBeregning(beregning);
        addBeregningRelasjon(br, beregningId);
    }

    /**
     * Hent BeregningsRelasjon som tilhører en bestemt beregning
     */
    public BeregningRelasjon getBeregningRelasjon(String beregningId) {
        for (BeregningRelasjon br : delberegning2011Liste) {
            if (br.getBeregning() != null && beregningId.equals(br.getBeregning().getPREG_beregningsnavn())) {
                return br;
            }
            if (br.getBeregning2011() != null && beregningId.equals(br.getBeregning2011().getPREG_beregningsnavn())) {
                return br;
            }
        }
        return null;
    }

    /**
     * Sjekker om beregningRelasjon er gammel beregning (1967)
     * Hvis BeregningRelasjon eller Beregning er null returneres true.
     * 
     * @param toCheck
     * @return beregning1967
     */
    private boolean erBeregning1967(BeregningRelasjon toCheck) {
        if (toCheck != null) {
            if (toCheck.getBeregning2011() != null) {
                return false;
            }
        }
        return true;
    }

    private BeregningRelasjon finnDelberegning1967() {
        for (BeregningRelasjon br : delberegning2011Liste) {
            if (br.getBeregning() != null) {
                return br;
            }
        }
        return null;
    }

    public BeregningGjelderTypeCti getBeregningGjelderType() {
        return beregningGjelderType;
    }

    public void setBeregningGjelderType(BeregningGjelderTypeCti beregningGjelderType) {
        this.beregningGjelderType = beregningGjelderType;
    }

    public BeregningRelasjon getPREG_beregningsrelasjon() {
        return PREG_beregningsrelasjon;
    }

    public void setPREG_beregningsrelasjon(BeregningRelasjon preg_beregningsrelasjon) {
        PREG_beregningsrelasjon = preg_beregningsrelasjon;
    }
}
